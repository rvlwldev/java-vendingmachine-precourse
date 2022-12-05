package vendingmachine.Util.Validation;

import static vendingmachine.Constant.Error.*;
import static vendingmachine.Constant.ProductConstant.MINIMUM_DIVIDED_PRICE;
import static vendingmachine.Constant.ProductSeparator.ORDER_PREFIX;
import static vendingmachine.Constant.ProductSeparator.ORDER_SUFFIX;

public class Validation {

    public int inputMoneyForChanges(String number) {
        int toNumber;

        try {
            toNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ALLOWED_ONLY_NUMBER.toMessage());
        }

        return toNumber;
    }

    public int inputMoneyDivision(int number) {
        if (number % MINIMUM_DIVIDED_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_SINGLE_DIGIT.toMessage());
        }

        return number;
    }

    public void prefixAndSuffix(String order) {
        char prefix = order.charAt(0);
        char suffix = order.charAt(order.length() - 1);

        if (prefix != ORDER_PREFIX.getChar() || suffix != ORDER_SUFFIX.getChar()) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }
    }



}
