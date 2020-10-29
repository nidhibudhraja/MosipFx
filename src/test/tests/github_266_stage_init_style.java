package tests;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

public class github_266_stage_init_style extends org.testfx.framework.junit5.ApplicationTest {

    Stage stage;
    StackPane sceneRoot;

    @Override
    public void init() throws Exception {
        FxToolkit.registerStage(() -> new Stage());
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        sceneRoot = new StackPane(new Button("foo"));
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(new Scene(sceneRoot, 100, 100));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        FxToolkit.hideStage();
    }

    @Test
    public void test1() {
    	System.out.println("foo");
        clickOn("foo");
    }

    @Test
    public void test2() {
        clickOn(".button");
    }

}