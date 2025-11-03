/*
 * LottoController.java 0.1 2025/11/3
 */
package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.*;

/**
 * 프로그램의 각 부분을 호출하여 실제로 프로그램을 수행하는 컨트롤러
 *
 * @version 0.1 2025/11/3
 * @author haram
 */
public class LottoController {
	private final LottoService service;
	private final InputView in;
	private final OutputView out;

	public LottoController() {
		this.service = new LottoService();
		this.in = new InputView();
		this.out = new OutputView();
	}

	public void run() {
		Purchase purchase = readMoneyLoop();
		Tickets tickets = service.ticket(purchase);
		out.printTickets(tickets);

		LottoWinning winning = readWinningNumbersLoop();
		Result result = service.analyze(tickets, winning);
		out.printStatistics(result);
		out.printYield(service.calculateYield(result, purchase));
	}

	private Purchase readMoneyLoop() {
		while (true) {
			try {
				String line = in.readPurchaseAmountLine();
				return Purchase.from(line);
			} catch (IllegalArgumentException e) {
				out.printError(e.getMessage());
			}
		}
	}

	private LottoWinning readWinningNumbersLoop() {
		while (true) {
			try {
				String mainLine = in.readWinningNumbersLine();
				String bonusLine = in.readBonusNumberLine();
				return LottoWinning.from(mainLine, bonusLine);
			} catch (IllegalArgumentException e) {
				out.printError(e.getMessage());
			}
		}
	}
}
