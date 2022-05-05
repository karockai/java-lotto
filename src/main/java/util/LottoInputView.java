package util;

import java.util.Scanner;
import lotto.PaymentAmount;

public class LottoInputView {

  private static final String MESSAGE_FOR_INSERT_PAYMENT_AMOUNT = "구입 금액을 입력해주세요.";
  private static final String MESSAGE_FOR_INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String MESSAGE_FOR_INSERT_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";
  private static final Scanner SCANNER = new Scanner(System.in);


  private LottoInputView() {
  }

  public static PaymentAmount insertPaymentAmount() {
    return new PaymentAmount(scanInt(MESSAGE_FOR_INSERT_PAYMENT_AMOUNT));
  }

  public static String insertWinningLotto() {
    return scanString(MESSAGE_FOR_INSERT_WINNING_NUMBERS);
  }

  public static int insertBonusNumber() {
    return scanInt(MESSAGE_FOR_INSERT_BONUS_NUMBERS);
  }

  private static void printDescription(String description) {
    System.out.println(description);
  }


  private static Integer scanInt(String description) {
    printDescription(description);
    return Integer.parseInt(SCANNER.nextLine());
  }

  private static String scanString(String description) {
    printDescription(description);
    return SCANNER.nextLine();
  }
}