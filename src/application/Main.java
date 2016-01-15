package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	int n = 0;
	BorderPane root = new BorderPane();
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		
		try {
			
			Scene scene = new Scene(root,1440,900);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		root.setTop(menu());
		root.setCenter(new RootLayout());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public Node menu()
	{
		//File menu
        Menu fileMenu = new Menu("File");
        MenuItem openFile = new MenuItem("Open");
        //openFile.setOnAction(e -> );
        fileMenu.getItems().add(openFile);
        MenuItem saveFile = new MenuItem("Save");
        //saveFile.setOnAction(e -> );
        fileMenu.getItems().add(saveFile);
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem testFile = new MenuItem("Test");
        testFile.setOnAction(e ->
        {
        	if (n%2 == 0)
        	{
        		AlertBox.display("Testing", "The circuit is correct");
        	}
        	else
        	{
        		AlertBox.display("Testing", "The circuit is incorrect");
        	}
        	n++;
        	 
        });
        fileMenu.getItems().add(testFile);
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem closeFile = new MenuItem("Exit");
        closeFile.setOnAction(e -> window.close());
        fileMenu.getItems().add(closeFile);
        
      //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
		return menuBar;
	}
	
}