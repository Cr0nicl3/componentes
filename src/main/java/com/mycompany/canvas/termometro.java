/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canvas;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.Month;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Cronicle
 */
public class termometro extends Application{
    @Override
    public void start(Stage stage) {
        initUI(stage);
    }
    private class Valor{
        public double temp;
        public LocalDateTime momento;
        public Valor(double temp,LocalDateTime momento){
            this.temp=temp;
            this.momento=momento;
        }
        public String toString(){
            return ""+this.momento;
        }
        public double getTemp(){
            return this.temp;
        }
    }
    public static Valor parse(Object o){
            Valor v=(Valor) o;
            return v;
        }
    private double scaleX;
    private double scaleY;
    private ArrayList<Valor> temperaturas;
    static ComboBox temps=new ComboBox();
    double min=100;
    double max=0;
    private void initUI(Stage stage) {
        var root = new Pane();
        var canvas = new Canvas(500, 800);
        canvas.widthProperty().bind(root.widthProperty());
    canvas.heightProperty().bind(root.heightProperty());
    scaleX=root.getHeight()/600;
    scaleY=root.getHeight()/600;
        var gc = canvas.getGraphicsContext2D();
        temperaturas=new ArrayList<Valor>();
        temperaturas.add(new Valor(15.8,LocalDateTime.of(2021, 2, 10, 11, 0)));
        temperaturas.add(new Valor(15.8,LocalDateTime.of(2021, 2, 10, 10, 0)));
        temperaturas.add(new Valor(15.4,LocalDateTime.of(2021, 2, 10, 9, 0)));
        temperaturas.add(new Valor(15.6,LocalDateTime.of(2021, 2, 10, 8, 0)));
        temperaturas.add(new Valor(15.6,LocalDateTime.of(2021, 2, 10, 7, 0)));
        temperaturas.add(new Valor(15.5,LocalDateTime.of(2021, 2, 10, 6, 0)));
        temperaturas.add(new Valor(15.0,LocalDateTime.of(2021, 2, 10, 5, 0)));
        temperaturas.add(new Valor(16.6,LocalDateTime.of(2021, 2, 10, 4, 0)));
        temperaturas.add(new Valor(15.0,LocalDateTime.of(2021, 2, 10, 3, 0)));
        temperaturas.add(new Valor(14.9,LocalDateTime.of(2021, 2, 10, 2, 0)));
        temperaturas.add(new Valor(15.3,LocalDateTime.of(2021, 2, 10, 1, 0)));
        temperaturas.add(new Valor(15.8,LocalDateTime.of(2021, 2, 10, 0, 0)));
        temperaturas.add(new Valor(15.7,LocalDateTime.of(2021, 2, 9, 23, 0)));
        temperaturas.add(new Valor(15.3,LocalDateTime.of(2021, 2, 9, 22, 0)));
        temperaturas.add(new Valor(15.2,LocalDateTime.of(2021, 2, 9, 21, 0)));
        temperaturas.add(new Valor(15.0,LocalDateTime.of(2021, 2, 9, 20, 0)));
        temperaturas.add(new Valor(15.7,LocalDateTime.of(2021, 2, 9, 19, 0)));
        for(int i=0;i<=temperaturas.size()-1;i++){
            if(temperaturas.get(i).temp<min)min=temperaturas.get(i).temp;
            if(temperaturas.get(i).temp>max)max=temperaturas.get(i).temp;
        }
        temps.getItems().addAll(temperaturas);
        root.heightProperty().addListener(new ChangeListener(){
           @Override
            public void changed(ObservableValue value,Object o,Object ob){
                if(root.getWidth()<root.getHeight()){
                    scaleX=root.getWidth()/600;
                    scaleY=root.getWidth()/600;
                }
                else if(root.getWidth()>root.getHeight()){
                    scaleX=root.getHeight()/600;
                    scaleY=root.getHeight()/600;
                }
                gc.clearRect(0, 0, 500, 800);
                drawSquare(gc,parse(temps.getValue()).temp);
                drawCircle(gc);
                drawLines(gc,min,max);
            } 
        });
        root.widthProperty().addListener(new ChangeListener(){
           @Override
            public void changed(ObservableValue value,Object o,Object ob){
                if(root.getWidth()<root.getHeight()){
                    scaleX=root.getWidth()/600;
                    scaleY=root.getWidth()/600;
                }
                else if(root.getWidth()>root.getHeight()){
                    scaleX=root.getHeight()/600;
                    scaleY=root.getHeight()/600;
                }
                gc.clearRect(0, 0, 500, 800);
                drawSquare(gc,parse(temps.getValue()).temp);
                drawCircle(gc);
                drawLines(gc,min,max);
            } 
        });
        temps.valueProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue value,Object o,Object ob){
                gc.clearRect(0, 0, 500, 800);
                drawSquare(gc,parse(temps.getValue()).temp);
                drawCircle(gc);
                drawLines(gc,min,max);
            }
        });
        drawSquare(gc,temperaturas.get(0).temp);
        drawCircle(gc);
        drawLines(gc,min,max);
        root.getChildren().add(canvas);
        root.getChildren().add(temps);
        var scene = new Scene(root, 150, 600, Color.WHITESMOKE);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }
    private void drawSquare(GraphicsContext gc,double actual) {
        double temp=actual;
        double variacion=(100-temp)*4;
        var stops1 = new Stop[] { 
        new Stop(0.2, Color.rgb(255, 50, 50)), // posición - color
   	new Stop(0.5, Color.WHITE), 
        new Stop(0.8, Color.rgb(255, 50, 50))};
        var lg1 = new LinearGradient(0, 0, 1, 0, true,
    	CycleMethod.NO_CYCLE, stops1);
        gc.setFill(lg1);
        gc.fillRect(40*scaleX, (60+variacion)*scaleY, 70*scaleX, (400-variacion)*scaleY);
        gc.setStroke(Color.BLACK);
        gc.strokeText(""+temp, 115*scaleX, (60+variacion)*scaleY);
    }
    private void drawLines(GraphicsContext gc, double min, double max){
        gc.setStroke(Color.BLACK);
        for(int i=1;i<=10;i++){
            gc.strokeLine(40*scaleX, (20+40*i)*scaleY, 115*scaleX, (20+40*i)*scaleY);
            gc.strokeText(""+i*10, 115*scaleX, (460-40*i)*scaleY);
        }
        double variacion=(100-min)*4;
        gc.setStroke(Color.CYAN);
        gc.strokeLine(30*scaleX, (60+variacion)*scaleY, 115*scaleX, (60+variacion)*scaleY);
        variacion=(100-max)*4;
        gc.setStroke(Color.ORANGE);
        gc.strokeLine(30*scaleX, (60+variacion)*scaleY, 115*scaleX, (60+variacion)*scaleY);
    }
    private void drawCircle(GraphicsContext gc)
    {
        var stops1 = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(255, 50, 50))};
        var lg1 = new RadialGradient(0, 0, 0.5, 0.5, 0.4, true, CycleMethod.NO_CYCLE, stops1);
        gc.setFill(lg1);
        gc.fillOval(0, 450*scaleY, 150*scaleX, 150*scaleY);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
