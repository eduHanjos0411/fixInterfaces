package model.services;

public class paypalService implements OnlinePaymentService {

    public Double paymentFee (Double amount) {
        return amount * 0.02;
    }

    public Double interest (Double amount, Integer months) {
        return (amount * 0.01) * months;
    }
}
