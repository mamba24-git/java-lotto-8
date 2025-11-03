/*
 * OutputView.java	0.1	2025/11/3
 */
package lotto.view;

import java.math.BigDecimal;
import lotto.domain.Result;
import lotto.domain.Tickets;

/**
 * 출력 형식에 맞춰 데이터를 담아 화면에 결과를 출력
 *
 * @version 0.1 2025/11/3
 * @author haram
 */
public class OutputView {
	public void printTickets(Tickets tickets) {
		System.out.println();
		System.out.println(tickets.count() + "개를 구매했습니다.");
		tickets.forEach(ticket -> System.out.println(ticket.getSortedNumbers().toString()));
	}

	public void printStatistics(Result result) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + result.countOf( lotto.domain.Rank.FIFTH ) + "개");
		System.out.println("4개 일치 (50,000원) - " + result.countOf( lotto.domain.Rank.FOURTH ) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + result.countOf( lotto.domain.Rank.THIRD ) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.countOf( lotto.domain.Rank.SECOND ) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + result.countOf( lotto.domain.Rank.FIRST ) + "개");
	}

	public void printYield(BigDecimal percent) {
		System.out.println("총 수익률은 " + percent.stripTrailingZeros().toPlainString() + "%입니다.");
	}

	public void printError(String message) {
		System.out.println(message);
	}
}
