import java.util.ArrayList;

public class Wallet {
    String name;
    ArrayList<Card> cards = new ArrayList<Card>();
    int cash;

    public Wallet(String name) {
    }

    public Wallet(String name, ArrayList<Card> cards, int cash) {
        this.name = name;
        this.cards = cards;
        this.cash = cash;
    }

    public void checkWallet() {
        System.out.println("========================");
        System.out.println("Name : " + this.name);
        System.out.println("Cards:");
        for (Card card : this.cards) {
            System.out.println(" -" + card.getBankName() + ", Account Number: " + card.getCardNumber());
        }
        System.out.println("Cash : " + this.cash);
        System.out.println("========================");
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new Error("Incorect amount");
        } else if (amount > this.cash) {
            throw new Error("Not enough Balance");
        } else {
            this.cash = (int) (this.cash - amount);
        }
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new Error("Amount insufficient");
        } else {
            this.cash = (int) (this.cash + amount);
        }
    }

    public void addCards(String bank, int accountCardNumber) {
        Card card = new Card(bank, accountCardNumber);
        cards.add(card);
    }

    public void removeCard(int accountCardNumber) {
        boolean cardFound = false;
        for (Card card : cards) {
            if (card.getCardNumber() == accountCardNumber) {
                cards.remove(card);
                cardFound = true;
                break;
            }
        }
        if (!cardFound) {
            throw new Error("Card not found");
        }
    }


    //    GETTER & SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
