import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tickets extends Application {
    
    Stage stage0 =  new Stage();
    VBox panel1 = new VBox();
    Scene scene1 = new Scene(panel1,400,250);
    
    
    public static void main(String[] args){
        launch(args);
    }
  
    public void start(Stage stage1) throws Exception{
        
        stage0.setTitle("Autobus");
        Label label = new Label("¿Cuál es tu nombre?");
        TextField texto1 = new TextField();
        texto1.setPromptText("Nombre");
        HBox v1= new HBox(label,texto1);
        Label tipo= new Label("Tipo de boleto");
        ComboBox tboleto = new ComboBox<>();
        tboleto.getItems().add("Primera Clase");
        tboleto.getItems().add("Clase Turista");
        tboleto.getItems().add("Clase Económica");
        HBox v2= new HBox(tipo,tboleto);
        Button boton1 = new Button("Pedir un boleto");
        boton1.setOnAction(e-> boleto());
        
        panel1.setPadding(new Insets(5.0));
        panel1.setAlignment(Pos.CENTER);
        panel1.getChildren().addAll(v1,v2,boton1);
        
        stage0.setScene(scene1);
        stage0.show();
        
    }
     @Override
    public void init() throws Exception{
        
    }
    
    
    }
      @Override
    public void stop() throws Exception{
        
    }
        
}