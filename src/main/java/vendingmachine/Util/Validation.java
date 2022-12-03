package vendingmachine.Util;

import vendingmachine.Domain.Product;

import java.util.List;

import static vendingmachine.Constant.Error.*;

public class Validation {

    private final char ORDER_PREFIX = '[';
    private final char ORDER_SUFFIX = ']';
    private final char ORDER_SEPARATOR = ';';
    private final char ORDER_INFO_SEPARATOR = ',';

    public int inputValueToNumber(String number) {
        int toNumber;

        try {
            toNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ALLOWED_ONLY_NUMBER.toMessage());
        }

        return toNumber;
    }

    public void productNameExist(String name, List<Product> product) {
        for (Product productObject : product) {
            if (name.equals(productObject.getName())) return;
        }

        throw new IllegalArgumentException(NOT_EXIST_PRODUCT_NAME.toMessage());

    }

    public void productOrder(String order) {
        try {
            checkPrefixAndSuffix(order);
            checkOrderInfo(order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkPrefixAndSuffix(String order) {
        if (order.charAt(0) != ORDER_PREFIX || order.charAt(order.length() - 1) != ORDER_SUFFIX) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }
    }

    private void checkOrderInfo(String order) {
        String separator;

        separator = String.valueOf(ORDER_SEPARATOR);
        if (order.contains(separator)) {
            checkOrderArray(order.split(separator));
        }

        separator = String.valueOf(ORDER_INFO_SEPARATOR);
        if (order.split(separator).length != 3) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }
    }

    private void checkOrderArray(String[] orders) {
        for (String order : orders) {
            checkOrderInfo(order);
        }
    }


}
