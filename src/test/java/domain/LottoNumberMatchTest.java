package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberMatchTest {
   @Test
   public void 번호일치테스트_6자리_전부_일치_GREEN() {
     List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
     List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

     final Lotto lotto = new Lotto(lottoNumber);

     final Integer allMached = LottoNumberMatch.matchCount(winNumber, lotto);

       assertThat(6).isEqualTo(allMached);
       assertThat(6).isEqualTo(lotto.rank().countOfMatch());
   }

  @Test
  public void 번호일치테스트_5자리_일치_GREEN() {
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 7);

    final Lotto lotto = new Lotto(lottoNumber);

    final Integer allMached = LottoNumberMatch.matchCount(winNumber, lotto);

    assertThat(allMached).isEqualTo(5);
    assertThat(lotto.rank().countOfMatch()).isEqualTo(5);
  }

  @Test
  public void 번호일치테스트_4자리_일치_GREEN() {
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 8, 7);

    final Lotto lotto = new Lotto(lottoNumber);

    final Integer allMached = LottoNumberMatch.matchCount(winNumber, lotto);

    assertThat(allMached).isEqualTo(4);
    assertThat(lotto.rank().countOfMatch()).isEqualTo(4);
  }

  @Test
  public void 번호일치테스트_3자리_일치_GREEN() {
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 9, 8, 7);

    final Lotto lotto = new Lotto(lottoNumber);

    final Integer allMached = LottoNumberMatch.matchCount(winNumber, lotto);

    assertThat(allMached).isEqualTo(3);
    assertThat(lotto.rank().countOfMatch()).isEqualTo(3);
  }

  @Test
  public void 번호일치테스트_맞는번호없음() {
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> lottoNumber = Arrays.asList(7, 8, 9, 10, 11, 12);

    final Lotto lotto = new Lotto(lottoNumber);

    final Integer nothingMatched = LottoNumberMatch.matchCount(winNumber, lotto);

    assertThat(nothingMatched).isEqualTo(0);
  }
}