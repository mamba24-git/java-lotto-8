/*
 * LottoWinning.java   0.1 2025/11/2
 */
package lotto.domain;

import java.util.*;
import lotto.util.Parser;

/**
 * 당첨 번호와 보너스 번호를 담고 있는 당첨 로또 객체
 * (추후 Lotto.java 를 상속받고 메서드도 오버로딩하는 더 효율적안 형태로 리팩토링 필요)
 *
 * @version 0.2 2025/11/3
 * @author haram
 */
public class LottoWinning {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoWinning(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        validateBonus(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning from(String mainCsv, String bonusRaw) {
        List<Integer> main = Parser.parseCsv(mainCsv);
        int bonus = Parser.parseBonus(main, bonusRaw);
        return new LottoWinning(main, bonus);
    }

    /**
     * 입력된 당첨 번호 내의 각 숫자가 올바른 값인지 검증.
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
     * 입력된 보너스 번호가 올바른 값인지 검증
     *
     * @param numbers   당첨 번호 리스트
     * @param bonusNumber   정수형의 보너스 번호
     */
    private void validateBonus(List<Integer> numbers, int bonusNumber) {
        if ((bonusNumber < 1) || (bonusNumber > 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자만 선택 가능합니다.");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
