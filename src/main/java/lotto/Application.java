/*
 * Application.java 0.1 2025/11/3
 */
package lotto;

import lotto.controller.LottoController;

/**
 * 프로그램 실제 실행부
 *
 * @version 0.1 2025/11/3
 * @author haram
 */
public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.run();
    }
}
