
interface UniversalCard {
    void displayInfo();
}


abstract class CardDecorator implements UniversalCard {
    protected UniversalCard decoratedCard;

    public CardDecorator(UniversalCard card) {
        this.decoratedCard = card;
    }

    @Override
    public void displayInfo() {
        decoratedCard.displayInfo();
    }
}


class PassportDecorator extends CardDecorator {
    public PassportDecorator(UniversalCard card) {
        super(card);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Функция добавлена: Паспорт.");
    }
}


class InsurancePolicyDecorator extends CardDecorator {
    public InsurancePolicyDecorator(UniversalCard card) {
        super(card);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Функция добавлена: Страховой полис.");
    }
}


class BankCardDecorator extends CardDecorator {
    public BankCardDecorator(UniversalCard card) {
        super(card);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Функция добавлена: Банковская карта.");
    }
}


public class Main {
    public static void main(String[] args) {
        UniversalCard basicCard = new UniversalCard() {
            @Override
            public void displayInfo() {
                System.out.println("Универсальная карта.");
            }
        };


        UniversalCard passportCard = new PassportDecorator(basicCard);
        UniversalCard insuranceCard = new InsurancePolicyDecorator(passportCard);
        UniversalCard bankCard = new BankCardDecorator(insuranceCard);


        System.out.println("Описание карты:");
        bankCard.displayInfo();
    }
}
