/*
 * Rank.java	0.1 2025/11/3
 */
package lotto.domain;

/**
 * 로또의 각 등수 형식을 지정하고 각 값을 가져다주는 역할
 *
 * @version 0.1 2025/11/3
 * @author haram
 */
public enum Rank {
	FIRST(6, false, 2_000_000_000),
	SECOND(5, true, 30_000_000),
	THIRD(5, false, 1_500_000),
	FOURTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	MISS(0, false, 0);

	private final int match;
	private final boolean needBonus;
	private final int prize;

	Rank(int match, boolean needBonus, int prize) {
		this.match = match;
		this.needBonus = needBonus;
		this.prize = prize;
	}

	public static Rank from(int match, boolean bonus) {
		if (match == 6) return FIRST;
		if ((match == 5) && (bonus)) return SECOND;
		if (match == 5) return THIRD;
		if (match == 4) return FOURTH;
		if (match == 3) return FIFTH;
		return MISS;
	}

	public int prize() {
		return prize;
	}

}
