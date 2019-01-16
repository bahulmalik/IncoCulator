package ReaderF;


public enum CurrencyType {
    INR(66), SGP(1.34), GBP(1.74),USD(1),Other(2);
    double currencyRate;

    CurrencyType(double rate) {
        currencyRate = rate;
    }

    Double getUSDConverted(double income) {
        return (income / currencyRate);
    }


}
