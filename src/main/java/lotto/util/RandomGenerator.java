/*
 * randomGenerator.java	0.1 2025/11/2
 */
package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

/**
 * 1~45 범위의 중복되지 않는 숫자 6개를 랜덤하게 뽑아 로또 번호에 사용하기 위한 용도로 사용.
 *
 * @version 0.1 2025/11/2
 * @author haram
 */
public class RandomGenerator {
	public static List<Integer> generate() {
		List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return list;
	}
}
