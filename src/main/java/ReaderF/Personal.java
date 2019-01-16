package ReaderF;

import lombok.Data;

@Data
public class Personal {
    private String country;
    private String city;
    private char gender;
    private CurrencyType currencyType;
    private Double avgIncome;


    Personal(String country, String city, char gender, CurrencyType currencyType, Double avgIncome) {
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.currencyType = currencyType;
        this.avgIncome = avgIncome;
    }

    public static PersonalBuilder builder() {
        return new PersonalBuilder();
    }

    public static class PersonalBuilder {
        private String country;
        private String city;
        private char gender;
        private CurrencyType currencyType;
        private Double avgIncome;

        PersonalBuilder() {
        }

        public PersonalBuilder country(String country) {
            if (country == null) {
                country = "Other";
            }
            this.country = country;
            return this;
        }

        public PersonalBuilder city(String city) {
            if (city == null) {
                city = "DontKnow";
            }
            this.city = city;
            return this;
        }

        public PersonalBuilder gender(char gender) {
            if (gender != 'M' && gender != 'F') {
                gender = 'K';
            }
            this.gender = gender;
            return this;
        }

        public PersonalBuilder currencyType(CurrencyType currencyType) {
            if (currencyType == null) {
                currencyType = CurrencyType.Other;
            }
            this.currencyType = currencyType;
            return this;
        }

        public PersonalBuilder avgIncome(Double avgIncome) {
            this.avgIncome = avgIncome;
            return this;
        }

        public Personal build() {
            return new Personal(country, city, gender, currencyType, avgIncome);
        }

        public String toString() {
            return "Personal.PersonalBuilder(country=" + this.country + ", city=" + this.city + ", gender=" + this.gender + ", currencyType=" + this.currencyType + ", avgIncome=" + this.avgIncome + ")";
        }
    }
}

