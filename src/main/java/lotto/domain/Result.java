/*
 * Result.java	0.1	2025/11/3
 */
package lotto.domain;

import java.util.*;

/**
 * 로또 당첨 결과와 총 상금의 합계를 저장하는 역할
 *
 * @version 0.1 2025/11/3
 * @author haram
 */
public class Result {
	private final Map<Rank, Integer> counts;

	public Result(Map<Rank, Integer> counts) {
		this.counts = new EnumMap<>(counts);
	}

	public int countOf(Rank rank) {
		Integer v = counts.get(rank);
		if (v == null)	return 0;
		return v;
	}

	public long totalPrize() {
		long sum = 0L;
		for (Map.Entry<Rank, Integer> e : counts.entrySet()) {
			sum += (long) e.getKey().prize() * e.getValue();
		}
		return sum;
	}
}
