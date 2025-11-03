/*
 * LottoService 0.1	2025/11/3
 */
package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import lotto.domain.*;
import lotto.util.*;

/**
 * 로또 발행, 판정, 수익률 계산 등 프로그램 전반의 비즈니스 로직
 */
public class LottoService {

	public LottoService() {
	}

	/**
	 * 로또를 구매하기 위에 금액을 지불하면 로또 번호를 만들고 로또를 발급하여 티켓에 추가
	 *
	 * @param purchase 결제를 위해 지불한 금액
	 * @return	Lotto 객체를 요소로 하는 리스트로 만들어진 Tickets 객체
	 */
	public Tickets ticket(Purchase purchase) {
		int count = purchase.countLotto();
		List<Lotto> list = new ArrayList<>();
		for (int i=0; i<count; i++) {
			List<Integer> nums = new ArrayList<>(RandomGenerator.generate());
			list.add(new Lotto(nums));
		}
		return new Tickets(list);
	}

	/**
	 * Tickets 객체에 담겨 있는 각 Lotto 객체의 로또 번호의 각 숫자를
	 * 당첨번호와 비교하여 등수 및 결과를 Result 객체로 저장
	 *
	 * @param tickets Lotto 객체를 담겨있는 Tickets 객체
	 * @param winning 당첨번호와 보너스 번호가 담겨있는 LottoWinning 객체
	 * @return
	 */
	public Result analyze(Tickets tickets, LottoWinning winning) {
		Map<Rank, Integer> counter = new EnumMap<>(Rank.class);
		for (Rank r : Rank.values()) {
			counter.put(r, 0);
		}
		for (Lotto t : tickets.asList()) {
			int match = t.countMatch(winning);
			boolean bonus = t.bonusMatch(winning);
			Rank rank = Rank.from(match, bonus);
			counter.put(rank, counter.get(rank) + 1);
		}
		return new Result(counter);
	}

	public BigDecimal calculateYield(Result result, Purchase purchase) {
		long totalPrize = result.totalPrize();
		BigDecimal ratio = new BigDecimal(totalPrize)
				.divide(new BigDecimal(purchase.amount()), 4, RoundingMode.HALF_UP)
				.multiply(new BigDecimal("100"));
		return ratio.setScale(1, RoundingMode.HALF_UP);
	}
}
