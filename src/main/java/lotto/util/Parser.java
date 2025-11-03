/*
 * Parser.java	0.1	2025/11/3
 */
package lotto.util;

import java.util.*;

/**
 * 입력값을 파싱하여 사용하기 올바른 형태로 가공하는 클래스
 *
 * @version 0.1	2025/11/3
 * @author haram
 */
public class Parser {

	public static List<Integer> parseCsv(String csv) {
		validateEmpty(csv);
		String s = csv.trim();
		String[] tokens = s.split(",");
		if (tokens.length != 6) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
		}
		validateNumbers(tokens);
		List<Integer> out = new ArrayList<>(6);
		for (String t : tokens) {
			t = t.trim();
			int v = Integer.parseInt(t);
			out.add(v);
		}
		validateDuplicate(out);
		return out;
	}

	public static int parseBonus(List<Integer> nums, String raw) {
		validateEmpty(raw);
		String[] token = raw.split(",");
		validateNumbers(token);
		if (token.length != 1) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호를 하나만 입력하십시오.");
		}
		int v = Integer.parseInt(token[0]);
		Set<Integer> set = new HashSet<>(nums);
		set.add(v);
		if (set.size() != 7) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}

		return v;
	}

	private static void validateEmpty(String s) {
		if (s == null) {
			throw new IllegalArgumentException("[ERROR] 입력이 비어 있습니다.");
		}
		String sTrimmed = s.trim();
		if (sTrimmed.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 입력이 비어 있습니다.");
		}
	}

	private static void validateNumbers(String[] tokens) {
		for (String t : tokens) {
			String tok = t.trim();
			if (!tok.matches("\\d+")) {
				throw new IllegalArgumentException("[ERROR] 숫자만 입력하십시오.");
			}
			int v = Integer.parseInt(tok);
			if ((v < 1) || (v > 45)) {
				throw new IllegalArgumentException("[ERROR] 번호는 1과 45 사이여야 합니다.");
			}
		}
	}

	private static void validateDuplicate(List<Integer> list) {
		Set<Integer> set = new HashSet<>(list);
		if (set.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
		}
	}
}
