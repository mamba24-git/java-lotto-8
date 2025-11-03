/*
 * InputView.java	0.1	2025/11/3
 */
package lotto.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 각종 값 입력부의 출력 및 실제 입력 담당
 *
 * @version 0.1 2025/11/3
 * @author haram
 */
public class InputView {
	public String readPurchaseAmountLine() {
		System.out.println("구입금액을 입력해 주세요.");
		return validatedLine();
	}

	public String readWinningNumbersLine() {
		System.out.println("\n당첨 번호를 입력해 주세요.");
		return validatedLine();
	}

	public String readBonusNumberLine() {
		System.out.println("\n보너스 번호를 입력해 주세요.");
		return validatedLine();
	}


	private String validatedLine() {
		String line = Console.readLine();
		String lineTrimmed = line.trim();
		if (lineTrimmed.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
		}
		return lineTrimmed;
	}
}
