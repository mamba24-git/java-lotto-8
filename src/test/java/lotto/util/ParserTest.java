package lotto.util;

import lotto.domain.LottoWinning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.Parser.parseBonus;
import static lotto.util.Parser.parseCsv;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ParserTest {
	@DisplayName("당첨 번호 정상 파싱 확인")
	@Test
	void 당첨_번호_정상_파싱_확인() {
		String csv = "1,2,3,4,5,7";
		List<Integer> expect = List.of(1,2,3,4,5,7);
		Assertions.assertEquals(expect, parseCsv(csv));
	}

	@DisplayName("공백 포함 당첨 번호 정상 파싱 확인")
	@Test
	void 공백_포함_당첨_번호_정상_파싱_확인() {
		String csv = "1,2,3,4 ,5, 7";
		List<Integer> expect = List.of(1,2,3,4,5,7);
		Assertions.assertEquals(expect, parseCsv(csv));
	}

	@DisplayName("보너스 번호 정상 파싱 확인")
	@Test
	void 보너스_번호_정상_파싱_확인() {
		String raw = "7";
		Assertions.assertEquals(7, parseBonus(List.of(1,2,3,4,5,6), raw));
	}

	@DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
	@Test
	void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
		String raw = "7";
		assertThatThrownBy(() -> Parser.parseBonus(List.of(1,2,3,4,5,7), "7"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}