/*
 * Lotto.java   0.2 2025/11/1
 */
package lotto.domain;

import java.util.*;

/**
 * 구매한 각 로또 객체 클래스
 *
 * @version 0.3 2025/11/3
 * @author haram
 */
public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	/**
	 * 입력된 당첨 번호 내의 각 숫자가 올바른 값인지 검증.
	 * 입력값이 공백이거나 숫자가 아닌 경우 등은 파싱 단계에서 진행하므로 여기서 중복으로 처리할 필요 없음.
	 *
	 * @param numbers 파싱된 로또번호 입력값울 담은 리스트
	 */
	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
		Set<Integer> duplicateCheck = new HashSet<>(numbers);
		if (duplicateCheck.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
		}
		for (Integer n : numbers) {
			if ((n < 1) || (n > 45)) {
				throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 선택 가능합니다.");
			}
		}
	}

	/**
	 * 로또 번호 출력할 때 정렬된 번호 리스트가 필요하여 작성
	 *
	 * @return 정렬된 로또 번호 리스트
	 */
	public List<Integer> getSortedNumbers() {
		List<Integer> copy = new ArrayList<>(numbers);
		Collections.sort(copy);
		return copy;
	}

	/**
	 * 당첨 번호와 몇 개가 일치하는지 계산하는 메서드
	 *
	 * @param lottoWinning 당첨번호가 담겨있는 LottoWinning 클래스 객체
	 * @return 당첨 번호 일치 개수
	 */
	public int countMatch(LottoWinning lottoWinning) {
		int cnt = 0;
		for (Integer n : numbers) {
			if (lottoWinning.contains(n)) {
				cnt++;
			}
		}
		return cnt;
	}

	/**
	 * 보너스 번호를 포함하는지 확인하는 메서드
	 *
	 * @param lottoWinning 보너스 번호가 담겨있는 LottoWinning 클래스 객체
	 * @return 보너스 번호 포함 여부
	 */
	public boolean bonusMatch(LottoWinning lottoWinning) {
		for (Integer n : numbers) {
			if(lottoWinning.containBonus(n)) {
				return true;
			}
		}
		return false;
	}


}
