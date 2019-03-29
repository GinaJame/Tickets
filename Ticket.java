
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
import javafx.event.ActionEvent;

public class Ticket extends Application {
    private GridPane gridpane1 = new GridPane();
    private Button asientosbu;
    private BorderPane bp = new BorderPane();
    private Button [][] asientos=new Button[20][4];
    private String nom;
    private Stage stage0 =  new Stage();
    private TextField texto1;
    private VBox panel1 = new VBox();
    private Scene scene1 = new Scene(panel1,300,250);
    private Scene scene2 = new Scene(bp, 300, 1000);
    private String tipo;
    private ComboBox tboleto;
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
        texto1 = new TextField();
        texto1.setPromptText("Nombre");
        HBox v1= new HBox(label,texto1);
        Label tipo= new Label("Tipo de boleto");
        tboleto = new ComboBox<>();
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
        nom= texto1.getText();
        tipo=(String) tboleto.getValue();
        System.out.println(tipo);
        System.out.println(nom);
        Label label1 = new Label("Elige tu asiento");

        Rectangle ac3= new Rectangle(10, 10);
        ac3.setFill(Paint.valueOf("#0f6e1f"));
        Label etiqueta3=new Label("primera");
        HBox acot3=new HBox(ac3,etiqueta3);

        Rectangle ac2= new Rectangle(10, 10);
        ac2.setFill(Paint.valueOf("#0f286e"));
        Label etiqueta2=new Label("turista");
        HBox acot2=new HBox(ac2,etiqueta2);

        Rectangle ac1= new Rectangle(10, 10);
        ac1.setFill(Paint.valueOf("#6e0f0f"));
        Label etiqueta1=new Label("economico");
        HBox acot1=new HBox(ac1,etiqueta1);




        VBox acotaciones = new VBox(acot1,acot2,acot3);

        scene2.getStylesheets().add("Styles.css");
        AgregarBotones('A');
        AgregarBotones('B');
        AgregarBotones('C');
        AgregarBotones('D');
        Button boton2 = new Button("Regresar");
        boton2.setOnAction(e-> regresar());
        /*boton2.setOnAction(e-> regresar(scene1));*/
        //asientosbu.setOnAction(e-> Seleccionado(asientosbu,gridpane1.getRowIndex(asientosbu)));
        
        
        bp.setTop(label1);
        bp.setCenter(gridpane1);
        bp.setBottom(boton2);
        bp.setRight(acotaciones);
        stage0.setScene(scene2);
        
    }
    public void AgregarBotones(char lugar){
        for(int i=0;i<20;i++){
            asientosbu = new Button(""+lugar+i);
            asientosbu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent event){
                Button select = (Button) event.getSource();
                Seleccionado(select,gridpane1.getRowIndex(select));
            }
            
        }); 
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
            
            if(row<5&&(tipo=="Primera Clase")){
                asientosbu.getStyleClass().remove("altaButton");
            }else if(row>4&&row<15&&(tipo=="Clase Turista")){
                asientosbu.getStyleClass().remove("turistaButton");
            }else if(row>14&&(tipo=="Clase Económica")){
                asientosbu.getStyleClass().remove("economicaButton");
            
            }else{
                System.out.println("Elige de tu tipo de asiento");
                
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