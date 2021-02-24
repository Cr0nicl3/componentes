/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canvas;


import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ClipEx extends Application {

   @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub  
        // creating the rectangles   
        
        
    ComboBox<String> cb = new ComboBox<String>();

    cb.setPrefSize(150, 20);
   


    ObservableList<String> data = FXCollections.observableArrayList("NORTE","SUR","ESTE","OESTE","NORESTE","NOROESTE","SURESTE","SUROESTE");

    cb.setItems(data);

    String seleccionado=cb.getSelectionModel(). getSelectedItem();
    
      System.out.println(cb.getValue());
    System.out.print(seleccionado);
    System.out.print("hola");
   
        // Con Shape arc
        Text norte = new Text();
        Text sur = new Text();
        Text este = new Text();
        Text oeste = new Text(); 
        

        //Setting the text to be added. 
        norte.setText("N"); 
        norte.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        norte.setFill(Color.AQUA);
        norte.setX(235); 
        norte.setY(90);
        
        sur.setText("S"); 
        sur.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        sur.setFill(Color.AQUA);
        sur.setX(235); 
        sur.setY(430); 
        
        este.setText("E"); 
        este.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        este.setFill(Color.AQUA);
        este.setX(70); 
        este.setY(250);
        
        oeste.setText("O"); 
        oeste.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        oeste.setFill(Color.AQUA);
        oeste.setX(410); 
        oeste.setY(250); 
        
        Arc arc = new Arc(250, 250, 150, 150, 0, 360);
        arc.setStroke(Color.AQUA);
        arc.setStrokeWidth(5);
        arc.setFill(Color.TRANSPARENT);
        
        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(new Double[]{
            175.0, 175.0,
            325.0, 250.0,
            250.0, 325.0 });
        polygon1.setFill(Color.AQUA);
        Polygon polygon2 = new Polygon();
        polygon2.getPoints().addAll(new Double[]{
            175.0, 325.0,
            250.0, 175.0,
            325.0, 250.0 });
        polygon2.setFill(Color.AQUA);
        Polygon polygon3 = new Polygon();
        polygon3.getPoints().addAll(new Double[]{
            325.0, 175.0,
            175.0, 250.0,
            250.0, 325.0 });
        polygon3.setFill(Color.AQUA);
        Polygon polygon4 = new Polygon();
        polygon4.getPoints().addAll(new Double[]{
            325.0, 325.0,
            250.0, 175.0,
            175.0, 250.0 });
        polygon4.setFill(Color.AQUA);
        Polygon polygon5 = new Polygon();
        polygon5.getPoints().addAll(new Double[]{
            250.0, 325.0,
            325.0, 175.0,
            175.0, 175.0 });
        polygon5.setFill(Color.AQUA);
        Polygon polygon6 = new Polygon();
        polygon6.getPoints().addAll(new Double[]{
            325.0, 250.0,
            175.0, 175.0,
            175.0, 325.0 });
        polygon6.setFill(Color.AQUA);
        Polygon polygon7 = new Polygon();
        polygon7.getPoints().addAll(new Double[]{
            250.0, 175.0,
            175.0, 325.0,
            325.0, 325.0 });
        polygon7.setFill(Color.AQUA);
        Polygon polygon8 = new Polygon();
        polygon8.getPoints().addAll(new Double[]{
            175.0, 250.0,
            325.0, 175.0,
            325.0, 325.0 });
        polygon8.setFill(Color.AQUA);
        


        // setting the color and stroke for the Rectangles    
      

        // instantiating the Rotate class.   
        Rotate rotate = new Rotate();

        //setting properties for the rotate object.   
        rotate.setAngle(30);
        rotate.setPivotX(100);
        rotate.setPivotY(300);

        //rotating the 2nd rectangle.   
        

        Group root = new Group();
        if ("sur".equals(seleccionado)){
            polygon8.getTransforms().add(rotate);
        }
        root.getChildren().addAll(arc,norte,sur,este,oeste,cb,polygon8);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotation Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
     static class ColorRectCell extends ListCell<String>{
      @Override
      public void updateItem(String item, boolean empty){
          super.updateItem(item, empty);
          Rectangle rect = new Rectangle(120,18);
          if(item != null){
              rect.setFill(Color.web(item));
              setGraphic(rect);
      }
  }
  }   
}

