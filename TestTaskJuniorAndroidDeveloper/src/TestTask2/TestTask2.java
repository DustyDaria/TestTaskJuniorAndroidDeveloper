package TestTask2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTask2 {

    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     * * @param price - исходные цены.
     * * @param discount - % скидки, от 1 до 99.
     * * @param offset - номер позиции, с которой нужно применить скидку.
     * * @param readLength - количество позиций, к которым нужно применить скидку.
     * * @return - массив новых цен.
     */


    static int getALotOfPrice(){
        Scanner input = new Scanner(System.in);
        int size;

        while (true){
            System.out.print("Введите количество исходных цен, для которых нужно посчитать скидку: ");
            size = input.nextInt();
            if (size < 0) {
                System.out.println("Количество исходных цен не может быть меньше нуля");

            } else if (size == 0) {
                System.out.println("Количество исходных цен не может быть равно нулю");
            } else {
                return size;
            }
        }
    }

    static int getDiscount()
    {
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Введите размер скидки, от 1% до 99%: ");
            int discount = input.nextInt();
            if (discount < 1){
                System.out.println("Размер скидки должен быть больше 1%");
            } else if (discount > 99){
                System.out.println("Размер скидки не может быть больше 99%");
            } else{
                return discount;
            }
        }
    }

    static int getOffset(int size){
        Scanner input = new Scanner(System.in);
        int offset;

        while(true){
            System.out.print("Введите номер позиции, с которой нужно применить скидку: ");
            offset = input.nextInt();
            if (offset <= 0){
                System.out.println("Введенный номер позиции отсутвует");
            } else if (offset > size) {
                System.out.println("Введенный номер позиции отсутвует");
            } else{
                return offset - 1;
            }
        }

    }

    static int getReadLength(int offset, int size){
        Scanner input = new Scanner(System.in);
        int readLength;

        while(true){
            System.out.print("Введите количество позиций, к которым нужно применить скидку: ");
            readLength = input.nextInt();

            if (readLength > size || readLength > (size - offset)){
                System.out.println("Введенное количество позиций не совпадает");
            } else if (readLength <= 0){
                System.out.println("Количество позиций не может быть меньше или равно нулю");
            } else {
                return readLength;
            }
        }
    }

    public static void main(String[] args) {
        int realEndPositon, setDiscount, setOffset, setReadLength, setALotOfPrice;
        Scanner input = new Scanner(System.in);


        setALotOfPrice = getALotOfPrice();

        ArrayList<Integer> price = new ArrayList<>();
        System.out.print("price = ");
        for (int i = 0; i < setALotOfPrice; i++) {
            price.add(i, input.nextInt());
            if (price.get(i) <= 0) {
                System.out.println("Цена не должна быть меньше нуля");
                price.clear();
            }
            else if (price.get(i) == 0) {
                System.out.println("Цена не должна быть равна нулю");
                price.clear();
            }

        }

        setDiscount = getDiscount(); //Получаем скидку

        setOffset = getOffset(setALotOfPrice); //Получаем первую позицию

        setReadLength = getReadLength(setOffset, setALotOfPrice); //Получаем количество позиций


        realEndPositon = setOffset + setReadLength; //Индекс конечной позиции

        List<Integer> priceDis = price.subList(setOffset, realEndPositon);
        System.out.print("Ценики со скидками: ");
        for (Integer priceD : priceDis) {
            double priceDiscount = priceD - ((priceD / 100.d) * setDiscount);
            System.out.print(priceDiscount + ", ");
        }
    }
}
