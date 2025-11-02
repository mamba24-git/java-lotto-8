package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
	@Test
	void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 범위가 맞지 않는 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_범위에_맞지_않는_숫자가_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호 개수 일치 확인")
	@Test
	void 당첨_번호_개수_일치_확인() {
		Lotto l = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		LottoWinning testLotto = new LottoWinning(List.of(2, 3, 4, 5, 6, 7), 1);
		Assertions.assertEquals(5, l.countMatch(testLotto));
	}

	@DisplayName("보너스 번호 일치 확인")
	@Test
	void 보너스_번호_일치_확인() {
		Lotto l = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		LottoWinning testLotto = new LottoWinning(List.of(2, 3, 4, 5, 6, 7), 1);
		Assertions.assertTrue(l.bonusMatch(testLotto));
	}
}