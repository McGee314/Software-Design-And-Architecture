import java.util.List;

// ============================================================
// SUBSYSTEM CLASSES
// FACADE PATTERN
// MUHAMMAD SAMUDERA BAGJA
// These classes handle the complex logic of the photobooth
// - WatermarkEngine: Applies watermarks to images
// - PaymentProcessor: Processes payments
// - CloudStorage: Uploads files to cloud storage
// - PrinterService: Prints images
// ============================================================

class WatermarkEngine {
    public String applyFrame(List<String> images, String templateId) {
        System.out.println("[WatermarkEngine] Applying frame with templateId: " + templateId);
        System.out.println("[WatermarkEngine] Processing " + images.size() + " image(s)...");
        return "framed_image_" + templateId + ".jpg";
    }
}

class PaymentProcessor {
    public String charge(double amount, String paymentMethod) {
        System.out.println("[PaymentProcessor] Charging " + amount + " via " + paymentMethod);
        return "TXN-" + System.currentTimeMillis();
    }
}

class CloudStorage {
    public String upload(String file) {
        System.out.println("[CloudStorage] Uploading file: " + file);
        return "FILE-" + file.hashCode();
    }

    public String generateDownloadLink(String fileId) {
        System.out.println("[CloudStorage] Generating download link for fileId: " + fileId);
        return "https://storage.photobooth.com/download/" + fileId;
    }
}

class PrinterService {
    public void print(String file) {
        System.out.println("[PrinterService] Printing file: " + file);
    }
}

// ============================================================
// FACADE CLASS
// ============================================================

class PhotoboothSessionFacade {
    private WatermarkEngine watermarkEngine;
    private PaymentProcessor paymentProcessor;
    private CloudStorage cloudStorage;
    private PrinterService printerService;

    public PhotoboothSessionFacade() {
        this.watermarkEngine = new WatermarkEngine();
        this.paymentProcessor = new PaymentProcessor();
        this.cloudStorage = new CloudStorage();
        this.printerService = new PrinterService();
    }

    public String processCompleteSession(
            List<String> images,
            String templateId,
            double amount,
            String paymentMethod) {

        System.out.println("\n===== Starting Photobooth Session =====");

        // Step 1: Apply watermark/frame
        String framedImage = watermarkEngine.applyFrame(images, templateId);

        // Step 2: Process payment
        String transactionId = paymentProcessor.charge(amount, paymentMethod);
        System.out.println("[Facade] Payment successful. Transaction ID: " + transactionId);

        // Step 3: Upload to cloud
        String fileId = cloudStorage.upload(framedImage);
        String downloadLink = cloudStorage.generateDownloadLink(fileId);

        // Step 4: Print the image
        printerService.print(framedImage);

        System.out.println("===== Session Complete =====\n");
        return downloadLink;
    }
}

// ============================================================
// CLIENT CLASS
// ============================================================

class Application {
    private PhotoboothSessionFacade facade;

    public Application() {
        this.facade = new PhotoboothSessionFacade();
    }

    public void onCheckoutClicked(List<String> images) {
        // The client only needs to call one method in the Facade
        // without knowing the details of the subsystems inside
        String downloadUrl = facade.processCompleteSession(
                images,
                "TEMPLATE_VINTAGE",
                25000.0,
                "QRIS");
        System.out.println("[Application] Download your photos here: " + downloadUrl);
    }
}

// ============================================================
// MAIN - Entry Point
// ============================================================

public class PhotoboothFacadePattern {
    public static void main(String[] args) {
        // Simulating the user pressing the checkout button
        Application app = new Application();

        List<String> capturedImages = List.of(
                "photo_001.jpg",
                "photo_002.jpg",
                "photo_003.jpg");

        app.onCheckoutClicked(capturedImages);
    }
}