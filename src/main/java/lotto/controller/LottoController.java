package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.message.Message;
import lotto.service.LotteryDraw;
import lotto.service.LottoGameApplication;
import lotto.view.InputView;
import lotto.view.LotteriesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LottoMoney lottoMoney = new LottoMoney(
        InputView.inputValueWithMessage(Message.MSG_INPUT_MONEY));

    Lotteries lotteries = LottoGameApplication.createLottos(
        LottoGameApplication.getBuyCount(lottoMoney));

    ResultView.drawCountOfBuyLotteries(LottoGameApplication.getBuyCount(lottoMoney));

    LotteriesDrawingView.drawLotteriesView(lotteries);

    LottoResult result = LottoResult.getResult(LotteryDraw.createWinLottoInfo(
        InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO),
        InputView.inputValueWithMessage(Message.MSG_INPUT_BONUS_NUMBER)), lotteries);

    ResultView.drawResult(result, LotteryDraw.gradingScore(result, lottoMoney));
  }
}