package lotto.domain;

import static lotto.service.Operation.DIVISION_REMAINDER;
import static lotto.service.Operation.chooseOperation;

import lotto.message.Message;
import lotto.service.Operation;

public class LottoMoney {

  private static final int LIMIT_MIN_NUMBER = 0;

  private static final int EACH_LOTTO_COST = 1000;

  private static final int INT_ZERO = 0;

  private final int money;

  public LottoMoney(int money) {
    validationMoney(money);
    this.money = money;
  }

  private void validationMoney(final int money) {
    checkMinimumValue(money);
    checkEnoughValue(money);
  }

  private void checkMinimumValue(final int money) {
    if(money < LIMIT_MIN_NUMBER){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_MONEY);
    }
  }

  private void checkEnoughValue(int money) {
    if (calculateMoney(DIVISION_REMAINDER, EACH_LOTTO_COST, money) != INT_ZERO) {
      throw new RuntimeException(Message.MSG_ERROR_WRONG_MONEY);
    }
  }

  public int calculateMoney(Operation mark, final int eachLottoCost, int money) {
    return chooseOperation(mark).calculation(money,eachLottoCost);
  }

  public static double getReward(final double totalWinningRewards,
      final LottoMoney lottoMoney) {
    return totalWinningRewards / (double) lottoMoney.money;
  }

  public int countLottoToMoney(final Operation mark, final int eachLottoCost) {
    return calculateMoney(mark,eachLottoCost,money);
  }
}
