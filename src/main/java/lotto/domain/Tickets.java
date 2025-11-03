/*
 * Tickets.java	0.2 2025/11/2
 */
package lotto.domain;

import java.util.*;

/**
 * 발급된 각 로또를 list로 저장
 *
 * @author haram
 * @version 0.3    2025/11/3
 */
public class Tickets {
	private final List<Lotto> list;

	public Tickets(List<Lotto> list) {
		if ((list == null) || (list.isEmpty())) {
			throw new IllegalArgumentException("[ERROR] 발급된 로또가 없습니다.");
		}
		this.list = Collections.unmodifiableList(new ArrayList<>(list));
	}

	public int count() {
		return list.size();
	}

	public List<Lotto> asList() {
		return list;
	}

	public void forEach(java.util.function.Consumer<Lotto> consumer) {
		for (Lotto t : list) {
			consumer.accept(t);
		}
	}
}