package local.alexios.tasks;

import java.util.Arrays;

/**
 * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
 * на количество позиций readLength. Новые цены округляем “вниз”,
 * до меньшего целого числа.
 *
 * @param price      - исходные цены.
 * @param discount   - % скидки, от 1 до 99.
 * @param offset     - номер позиции, с которой нужно применить скидку.
 * @param readLength - количество позиций, к которым нужно применить скидку.
 * @return - массив новых цен.
 */

public class App {
    public static void main(String[] args) {
        int[] price = {1,2,3,4,5,6,7,8,9,10};
        int discount = 50;
        int offset = 0;
        int readLength = 10;

        App sale = new App();
        int[] discountedPrices = sale.decryptData(price, discount, offset, readLength);
        Arrays.stream(discountedPrices).forEach(i -> System.out.println(i));

    }

    public int[] decryptData(int[] price, int discount, int offset, int readLength) {
        Validator.validatePriceArray(price);
        Validator.validateInteger(discount, offset, readLength);
        Validator.validateWhichMoreThanZero(readLength, discount);
        Validator.validateDiscount(discount);

        if (price.length < (offset + readLength)) {
            throw new IllegalArgumentException("Quantity of position is more than array's length");
        }

        int[] discountedPrices = new int[readLength];
        int counterForDiscountedPrices = 0;
        int counterPosition = offset;
        for (int i = 0; i < readLength; i++) {
            discountedPrices[counterForDiscountedPrices] = (int) Math.floor((double) (price[counterPosition]) - ((double) price[counterPosition] * (double) discount / 100));
            counterForDiscountedPrices++;
            counterPosition++;
        }
        return discountedPrices;
    }
}