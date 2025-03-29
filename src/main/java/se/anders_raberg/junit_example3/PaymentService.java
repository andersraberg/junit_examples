package se.anders_raberg.junit_example3;

public class PaymentService {
    
    public double calculateFee(double amount) {
        return amount * 0.05; // 5% fee
    }

    public String processPayment(double amount) {
        double fee = calculateFee(amount);
        return "Processed payment of $" + amount + " with a fee of $" + fee;
    }
}
