package Abstractfactory;
interface PaymentGateway {
    void processPayment(double amount);
}

class PhonePe implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PhonePe.");
    }
}

class Paytm implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Paytm.");
    }
}

class PayPal implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class Stripe implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

interface Invoice {
    void generateInvoice(double amount);
}

class GSTInvoice implements Invoice {
    public void generateInvoice(double amount) {
        System.out.println("Generating GST invoice for amount: $" + amount);
    }
}

class USAInvoice implements Invoice {
    public void generateInvoice(double amount) {
        System.out.println("Generating USA invoice for amount: $" + amount);
    }
}

interface RegionFactory {
    PaymentGateway createPaymentGateway(String paymentType);
    Invoice createInvoice();
}

class IndianFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String paymentType) {
        switch (paymentType) {
            case "phonepay":
                return new PhonePe();
            case "paytm":
                return new Paytm();
            default:
                throw new IllegalArgumentException("Invalid Indian payment gateway");
        }
    }

    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}

class USAFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String paymentType) {
        switch (paymentType) {
            case "paypal":
                return new PayPal();
            case "stripe":
                return new Stripe();
            default:
                throw new IllegalArgumentException("Invalid USA payment gateway");
        }
    }

    public Invoice createInvoice() {
        return new USAInvoice();
    }
}

class Checkout {
    private PaymentGateway paymentGateway;
    private Invoice invoice;

    Checkout(RegionFactory factory, String paymentType) {
        this.paymentGateway = factory.createPaymentGateway(paymentType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Checkout checkoutIndia =
            new Checkout(new IndianFactory(), "phonepay");

        checkoutIndia.completeOrder(100.0);

        Checkout checkoutUSA =
            new Checkout(new USAFactory(), "paypal");

        checkoutUSA.completeOrder(200.0);
    }
}
