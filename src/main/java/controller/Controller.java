package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Database;
import view.DisplayPath;
import view.MainView;

public class Controller implements EventHandler<ActionEvent>{

    public Parent setMainView(){
        MainView mainView = new MainView();
        Database db = mainView.getDis().getDatabase();
        db.getAllBusStopFromDB();
        DisplayPath display = new DisplayPath();

        mainView.getNo29button().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DisplayPath display = new DisplayPath();
                System.out.println("29");
                mainView.getBackLayout().setCenter(display.buildView("29"));
            }
        });

        mainView.getNo134button().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DisplayPath display = new DisplayPath();
                System.out.println("134");
                mainView.getBackLayout().setCenter(display.buildView("134"));
            }
        });

        mainView.getNo191button().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DisplayPath display = new DisplayPath();
                System.out.println("191");
                mainView.getBackLayout().setCenter(display.buildView("191"));
            }
        });

        mainView.getNo510button().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DisplayPath display = new DisplayPath();
                System.out.println("510");
                mainView.getBackLayout().setCenter(display.buildView("510"));
            }
        });

        mainView.getNo555button().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DisplayPath display = new DisplayPath();
                System.out.println("555");
                mainView.getBackLayout().setCenter(display.buildView("555"));
            }
        });

        mainView.getChoice().setOnAction(e -> {
            mainView.getSearchResult().getChildren().clear();
            Text busNameText = new Text();
            busNameText.setStyle("-fx-font-size: 20;-fx-font-weight:bold;");
            busNameText.setText("     "+mainView.getChoice().getValue().toString()+"\n");
            mainView.getSearchResult().getChildren().add(busNameText);

            for(String s : db.getNoBus(mainView.getChoice().getValue().toString())){
                Text t = new Text();
                t.setStyle("-fx-font-size: 30;-fx-font-weight:normal;");
                t.setFill(Color.rgb(212, 33, 90));
                t.setText("       "+s+"\n");
                mainView.getSearchResult().getChildren().add(t);
            }
        });

        Parent parent = mainView.buildView();
        return parent;
    }
    @Override
    public void handle(ActionEvent event){

    }
}
