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
public class Boleto extends Scene{

    
    private GridPane gridpane1 = new GridPane();

    private Button asientosbu;
    public Boleto(Main main){
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
        asientosbu.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler <MouseEvent>(){
            public void handle(MouseEvent e){
                asientosbu.getStyleClass().add("asientoTomado");
            }
        });
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
}