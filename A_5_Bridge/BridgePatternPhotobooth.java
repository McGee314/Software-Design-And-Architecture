// ============================================================
// MUHAMMAD SAMUDERA BAGJA
// Bridge Pattern - Photobooth Camera System
// Diagram: CameraAPI (Interface) + BoothController (Abstraction)
// ============================================================

// ─────────────────────────────────────────
// IMPLEMENTOR INTERFACE
// ─────────────────────────────────────────

interface CameraAPI {
    void triggerShutter();

    void setExposure(int level);

    String getPreview();
}

// ─────────────────────────────────────────
// CONCRETE IMPLEMENTATIONS
// ─────────────────────────────────────────

class IPadCameraAPI implements CameraAPI {

    @Override
    public void triggerShutter() {
        System.out.println("[IPadCameraAPI] Shutter triggered via iPad camera.");
    }

    @Override
    public void setExposure(int level) {
        System.out.println("[IPadCameraAPI] Exposure set to level: " + level);
    }

    @Override
    public String getPreview() {
        return "[IPadCameraAPI] Preview image from iPad camera.";
    }
}

class RicohGRAPI implements CameraAPI {

    @Override
    public void triggerShutter() {
        System.out.println("[RicohGRAPI] Shutter triggered via Ricoh GR camera.");
    }

    @Override
    public void setExposure(int level) {
        System.out.println("[RicohGRAPI] Exposure set to level: " + level);
    }

    @Override
    public String getPreview() {
        return "[RicohGRAPI] Preview image from Ricoh GR camera.";
    }
}

// ─────────────────────────────────────────
// ABSTRACTION
// ─────────────────────────────────────────

class BoothController {

    // Bridge: composition instead of inheritance
    protected CameraAPI camera;

    public BoothController(CameraAPI camera) {
        this.camera = camera;
    }

    public void takePhoto() {
        System.out.println("[BoothController] Taking photo...");
        camera.setExposure(5);
        camera.triggerShutter();
        System.out.println("[BoothController] Preview: " + camera.getPreview());
    }

    public void startSession() {
        System.out.println("[BoothController] Session started.");
    }
}

// ─────────────────────────────────────────
// REFINED ABSTRACTION
// ─────────────────────────────────────────

class ProBoothController extends BoothController {

    public ProBoothController(CameraAPI camera) {
        super(camera);
    }

    public void takePhotoWithWatermark() {
        System.out.println("[ProBoothController] Taking photo with watermark...");
        camera.setExposure(7);
        camera.triggerShutter();
        System.out.println("[ProBoothController] Preview: " + camera.getPreview());
        System.out.println("[ProBoothController] Watermark applied.");
    }

    public void startTimedSession(int seconds) {
        System.out.println("[ProBoothController] Timed session started for " + seconds + " seconds.");
    }
}

// ─────────────────────────────────────────
// CLIENT
// ─────────────────────────────────────────

class Client {

    private BoothController controller;

    public Client(BoothController controller) {
        this.controller = controller;
    }

    public void runPhotobooth() {
        System.out.println("=== Photobooth Running ===");
        controller.startSession();
        controller.takePhoto();
        System.out.println("=== Photobooth Done ===\n");
    }
}

// ─────────────────────────────────────────
// MAIN - DEMO
// ─────────────────────────────────────────

public class BridgePatternPhotobooth {

    public static void main(String[] args) {

        // Scenario 1: Basic booth with iPad camera
        System.out.println("--- Scenario 1: BoothController + IPadCameraAPI ---");
        CameraAPI ipad = new IPadCameraAPI();
        BoothController basicBooth = new BoothController(ipad);
        Client client1 = new Client(basicBooth);
        client1.runPhotobooth();

        // Scenario 2: Basic booth with Ricoh GR camera
        System.out.println("--- Scenario 2: BoothController + RicohGRAPI ---");
        CameraAPI ricoh = new RicohGRAPI();
        BoothController ricohBooth = new BoothController(ricoh);
        Client client2 = new Client(ricohBooth);
        client2.runPhotobooth();

        // Scenario 3: Pro booth with iPad camera
        System.out.println("--- Scenario 3: ProBoothController + IPadCameraAPI ---");
        ProBoothController proBooth = new ProBoothController(new IPadCameraAPI());
        proBooth.startTimedSession(30);
        proBooth.takePhotoWithWatermark();
        System.out.println();

        // Scenario 4: Pro booth with Ricoh GR camera
        System.out.println("--- Scenario 4: ProBoothController + RicohGRAPI ---");
        ProBoothController proRicohBooth = new ProBoothController(new RicohGRAPI());
        proRicohBooth.startTimedSession(60);
        proRicohBooth.takePhotoWithWatermark();
    }
}