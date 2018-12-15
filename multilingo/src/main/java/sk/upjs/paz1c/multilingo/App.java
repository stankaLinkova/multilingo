package sk.upjs.paz1c.multilingo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    //zaciatocna scena
	@Override
	public void start(Stage primaryStage) throws Exception {
		SignInController mainController	= new SignInController();            
		FXMLLoader fxmlLoader = new	FXMLLoader(getClass().getResource("log_in_scene.fxml"));
		fxmlLoader.setController(mainController);
		Parent rootPane	= fxmlLoader.load();
		Scene scene	= new Scene(rootPane);
		primaryStage.setTitle("MultiLingo: Sign in");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
