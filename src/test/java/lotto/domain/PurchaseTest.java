package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
	@DisplayName("지불 금액에 맞는 장수를 구매하는지 확인한다")
	@Test
	void 지불_금액에_맞는_장수를_구매하는지_확인한다() {
		Purchase p = new Purchase(5000);

		Assertions.assertEquals(5, p.countLotto());
	}

	@DisplayName("결제 금액이 정수로 구성된 문자열이면 int로 바꾸어 객체를 만든다")
	@Test
	void 결제_금액이_정수로_구성된_문자열이면_int로_바꾸어_객체를_만든다() {
		Purchase p = new Purchase(3000);
		Purchase pFrom = Purchase.from("3000");

		Assertions.assertEquals(p.countLotto(), pFrom.countLotto());
	}

	@DisplayName("결제 금액이 1000보다 작으면 예외가 발생한다")
	@Test
	void 결제_금액이_1000보다_작으면_예외가_발생한다() {
		assertThatThrownBy(() -> new Purchase(0))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("결제 금액이 1000원 단위가 아니면 예외가 발생한다.")
	@Test
	void 결제_금액이_1000원_단위가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> new Purchase(1500))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("결제 금액이 숫자가 아니면 예외가 발생한다")
	@Test
	void 결제_금액이_숫자가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> Purchase.from("money"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}