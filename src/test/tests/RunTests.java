package tests;

import org.testfx.api.FxToolkit;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RunTests {
	public static void main(String[] args) throws Exception {
        // before test class:
        FxToolkit.registerPrimaryStage();
        FxToolkit.hideStage(); // hide primary Stage, if was previously shown.

        // before each test method:
        
        FxToolkit.registerStage(() -> new Stage());
        FxToolkit.setupStage(stage -> {
            stage.setScene(new Scene(new Label("within custom stage")));
        });
        FxToolkit.showStage();

        // after each test method:
        FxToolkit.hideStage();

        // on test suite complete (not needed in JUnit runs):
        Platform.exit();
    }

}
