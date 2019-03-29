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
    
    
    GridPane gridpane1 = new GridPane();
    
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
    
    public void boleto(){
        BorderPane bp = new BorderPane();
        bp.setPrefSize(700,1000);
        Label label1 = new Label("Elige tu asiento");

        Rectangle ac1= new Rectangle(10, 10);
        Label etiqueta1=new Label("economico");
        ac1.getStyleClass().add("economicaButton");
        HBox acot1=new HBox(ac1,etiqueta1);

        Rectangle ac2= new Rectangle(10, 10);
        Label etiqueta2=new Label("turista");
        ac1.getStyleClass().add("turistaButton");
        HBox acot2=new HBox(ac2,etiqueta2);

        Rectangle ac3= new Rectangle(10, 10);
        Label etiqueta3=new Label("primera");
        ac1.getStyleClass().add("primeraButton");
        HBox acot3=new HBox(ac3,etiqueta3);


        VBox acotaciones = new VBox(acot1,acot2,acot3);

        Scene scene2 = new Scene(bp, 300, 1000);
        scene2.getStylesheets().add("Styles.css");
        AgregarBotones('A');
        AgregarBotones('B');
        AgregarBotones('C');
        AgregarBotones('D');
        Button boton2 = new Button("Regresar");
        boton2.setOnAction(e-> regresar());
        
        bp.setTop(label1);
        bp.setCenter(gridpane1);
        bp.setBottom(boton2);
        bp.setRight(acotaciones);
        
        stage0.setScene(scene2);
        
    }
    
    public void regresar(){
        stage0.setScene(scene1);
    }
    public void AgregarBotones(char lugar){
        for(int i=0;i<20;i++){
            Button asientosbu = new Button(""+lugar+i);
            switch (lugar){
                case 'A':
                    gridpane1.add(asientosbu,1,i);
                break;
                case 'B':
                    gridpane1.add(asientosbu,2,i);
                break;
                case 'C':
                    gridpane1.add(asientosbu,3,i);
                break;
                default:
                    gridpane1.add(asientosbu,4,i);
                break;
            }
            if(i<5){
                asientosbu.getStyleClass().add("altaButton");
                
            
            }
            if(i>4&&i<15){
                asientosbu.getStyleClass().add("turistaButton");
            }
            if(i>14){
                asientosbu.getStyleClass().add("economicaButton");
            
            }
        }
    }
      @Override
    public void stop() throws Exception{
        
    }
        
}