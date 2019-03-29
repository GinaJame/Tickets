
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Ticket extends Application {
    private GridPane gridpane1 = new GridPane();
    private Button asientosbu;
    private BorderPane bp = new BorderPane();
    private Button [][] asientos=new Button[20][4];
    private String nom;
    Stage stage0 =  new Stage();
    VBox panel1 = new VBox();
    Scene scene1 = new Scene(panel1,300,250);
    Scene scene2 = new Scene(bp, 300, 1000);
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    @Override
    public void init() throws Exception{
        
    }
    
    @Override
    public void start(Stage stage1) throws Exception{
        
        stage0.setTitle("Autobus");
        Label label = new Label("¿Cuál es tu nombre?");
        TextField texto1 = new TextField();
        texto1.setPromptText("Nombre");
        nom= texto1.getText();
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
    
    public void boleto(){
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

        scene2.getStylesheets().add("Styles.css");
        AgregarBotones('A');
        AgregarBotones('B');
        AgregarBotones('C');
        AgregarBotones('D');
        Button boton2 = new Button("Regresar");
        boton2.setOnAction(e-> regresar());
        /*boton2.setOnAction(e-> regresar(scene1));*/
        asientosbu.setOnAction(e-> Seleccionado(asientosbu,gridpane1.getRowIndex(asientosbu)));
        bp.setTop(label1);
        bp.setCenter(gridpane1);
        bp.setBottom(boton2);
        bp.setRight(acotaciones);
        stage0.setScene(scene2);
        
    }
    public void AgregarBotones(char lugar){
        for(int i=0;i<20;i++){
            asientosbu = new Button(""+lugar+i);
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
    public void Seleccionado(Button b, int row){
            if(row<5){
                asientosbu.getStyleClass().remove("altaButton");
                System.out.println("Clase Alta");
            }
            if(row>4&&row<15){
                asientosbu.getStyleClass().remove("turistaButton");
            }
            if(row>14){
                asientosbu.getStyleClass().remove("economicaButton");
            
            }
            b.getStyleClass().add("asientoTomado"); 
            b.setText(nom);
    }
    
    public void regresar(){
        stage0.setScene(scene1);
    }
    
    @Override
    public void stop() throws Exception{
        
    }
        
}