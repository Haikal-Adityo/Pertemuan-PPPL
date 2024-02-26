public class Card {
    private String bankName;
    private int cardNumber;

    Card(String bankName, int cardNumber) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
    }

//    GETTER & SETTER
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
