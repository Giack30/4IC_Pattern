package instagramobserver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Florian
 */
public class InstagramObserver extends Application {
    
    private double posFinestraX, posFinestraY;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(null);
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.TRANSPARENT);

        gestisciDrag(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }



    private void gestisciDrag(Parent root, Stage stage) {
        root.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                posFinestraX = event.getSceneX();
                posFinestraY = event.getSceneY();
        });

        root.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {
                stage.setX(event.getScreenX() - posFinestraX);
                stage.setY(event.getScreenY() - posFinestraY);
        });
    }
    
}