public class LogicalOperators {
    public static void main(String[] args) {
        // and operator
        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);

        // or operator
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean isEligible = hasHighIncome || hasGoodCredit;
        System.out.println(isEligible);

        // not operator
        boolean hasHighIncome2 = true;
        boolean hasGoodCredit2 = true;
        boolean hasCriminalRecord = false;
        boolean isEligible2 = (hasHighIncome2 || hasGoodCredit2) && !hasCriminalRecord;
        System.out.println(isEligible2);
    }
}
