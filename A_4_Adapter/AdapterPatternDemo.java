// ============================================================
//  MUHAMMAD SAMUDERA BAGJA
//  Adapter Pattern - E-Wallet Payment System
// ============================================================

// ─────────────────────────────────────────────
// 1. TARGET INTERFACE
// ─────────────────────────────────────────────
interface PaymentProcessor {
    void pay(int amount);
}

// ─────────────────────────────────────────────
// 2. ADAPTEE - External library (cannot be modified)
// ─────────────────────────────────────────────
class EWalletLibrary {
    public void makePayment(double amountIDR, String walletID) {
        System.out.println("[EWalletLibrary] Processing payment...");
        System.out.println("  Wallet ID  : " + walletID);
        System.out.println("  Amount IDR : Rp " + String.format("%,.0f", amountIDR));
        System.out.println("[EWalletLibrary] Payment successful!");
    }
}

// ─────────────────────────────────────────────
// 3. ADAPTER - Bridges the Client with EWalletLibrary
// ─────────────────────────────────────────────
class EWalletAdapter implements PaymentProcessor {
    private EWalletLibrary adaptee;
    private String walletID;

    public EWalletAdapter(EWalletLibrary adaptee, String walletID) {
        this.adaptee = adaptee;
        this.walletID = walletID;
    }

    @Override
    public void pay(int amount) {
        // Conversion: int → double (matches EWalletLibrary signature)
        double amountIDR = (double) amount;
        adaptee.makePayment(amountIDR, walletID);
    }
}

// ─────────────────────────────────────────────
// 4. CLIENT - OnlineStore
// ─────────────────────────────────────────────
class Client {
    private PaymentProcessor processor;

    public Client(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void checkout(int total) {
        System.out.println("[OnlineStore] Starting checkout with total: Rp "
                + String.format("%,d", total));
        processor.pay(total);
        System.out.println("[OnlineStore] Checkout completed.\n");
    }
}

// ─────────────────────────────────────────────
// 5. MAIN - Entry point / Demo
// ─────────────────────────────────────────────
public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   Demo Adapter Pattern - E-Wallet Payment   ");
        System.out.println("==============================================\n");

        // Create an instance of EWalletLibrary (Adaptee)
        EWalletLibrary eWalletLibrary = new EWalletLibrary();

        // Wrap it with the Adapter and provide the walletID
        PaymentProcessor adapter = new EWalletAdapter(eWalletLibrary, "WALLET-2025-XYZ");

        // Client uses PaymentProcessor without knowing EWalletLibrary details
        Client onlineStore = new Client(adapter);

        // Simulate several checkout transactions
        onlineStore.checkout(150000);
        onlineStore.checkout(850000);
        onlineStore.checkout(2500000);
    }
}