/*
 * Lotto.java   0.1 2025/10/29
 */
package lotto.domain;

import java.util.*;

/**
 * 로또 번호에 대한 검증 등 각 로또 단위에 대한 기능 처리를 담당.
 *
 * @version 0.2 2025/11/1
 * @author haram
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 입력된 로또 번호 내의 각 숫자가 올바른 값인지 검증.
     * 입력값이 공백이거나 숫자가 아닌 경우 등은 파싱 단계에서 진행하므로 여기서 중복 처리할 필요 없음.
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
}
