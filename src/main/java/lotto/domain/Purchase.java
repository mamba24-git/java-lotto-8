/*
 * Purchase.java   0.1 2025/11/1
 */
package lotto.domain;

/**
 * 지불 금액을 전달받아 올바른 금액인지 판단하고
 * 올바른 금액이면 로또를 몇 장 구매한 것인지 계산하는 역할 수행.
 *
 * @version 0.1 2025/11/1
 * @author haram
 */
public class Purchase {
	private static final int UNIT = 1000;	/* 로또 한 장 금액 최소 단위 */
	private final int amount;

	public Purchase(int amount) {
		if (amount < UNIT) {
			throw new IllegalArgumentException("[ERROR] 최소 금액은 1,000원입니다.");
		}
		if (amount % UNIT != 0) {
			throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
		}
		this.amount = amount;
	}

	/**
	 * String 입력을 받아 Purchase 객체로 변환
	 *
	 * @param raw String 입력값
	 * @return 정수화된 raw를 인자로 갖는 Purchase 객체
	 */
	public static Purchase from(String raw) {
		String s = raw.trim();
		if (!s.matches("\\d+")) {	/* int 입력인지 확인  */
			throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
		}
		int v = Integer.parseInt(s);
		return new Purchase(v);
	}

	public int amount() {
		return amount;
	}

	public int countLotto() {
		return amount / UNIT;
	}
}
