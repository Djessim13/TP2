package fr.univ_amu.iut.exercice9;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

//@Disabled
@ExtendWith(ApplicationExtension.class)
public class TestHelloBeautifulUsefulButton {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                TestHelloBeautifulUsefulButton.this.stage = new Stage();
                try {
                    FxToolkit.setupStage((sta) -> {
                        try {
                            new HelloBeautifulUsefulButton().start(TestHelloBeautifulUsefulButton.this.stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @AfterEach
    public void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    //@Disabled
    @Test
    public void should_initialize_stage_with_correct_title() {
        assertEquals("Hello !", stage.getTitle());
    }

    //@Disabled
    @Test
    public void should_initialize_stage_is_showing() {
        assertTrue(stage.isShowing());
    }

    //@Disabled
    @Test
    public void should_initialize_stage_with_height_of_250() {
        assertEquals(250, stage.getHeight());
    }

    //@Disabled
    @Test
    public void should_initialize_stage_with_width_of_250() {
        assertEquals(250, stage.getWidth());
    }

    //@Disabled
    @Test
    public void should_initialize_button_with_text_hello() {
        verifyThat("#buttonHello", hasText("Hello !"));
    }

    //@Disabled
    @Test
    public void should_initialize_stage_with_a_graphic() {
        verifyThat("#buttonHello", (Button node) -> node.getGraphic() instanceof ImageView);
        verifyThat("#buttonHello", (Button node) -> ((ImageView) node.getGraphic()).getImage() != null);
        verifyThat("#buttonHello", (Button node) -> ((ImageView) node.getGraphic()).getImage().getHeight() == 150);
        verifyThat("#buttonHello", (Button node) -> ((ImageView) node.getGraphic()).getImage().getWidth() == 150);
    }

    //@Disabled
    @Test
    public void should_button_click_show_useless_text(FxRobot robot) {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        robot.clickOn("#buttonHello");
        verify(out).println("Bouton actionné");
    }

}
