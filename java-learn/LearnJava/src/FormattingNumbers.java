import java.text.NumberFormat;

public class FormattingNumbers {
    public static void main(String[] args) {
        // percent (Method Chaining)
        String percentResult = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(percentResult);
        // currency (this is the long way, you can do the above way as well)
        var currency = NumberFormat.getCurrencyInstance();
        String currencyResult = currency.format(123456.78);
        System.out.println(currencyResult);
    }
}
