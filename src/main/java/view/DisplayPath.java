package view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.Database;

import java.util.ArrayList;
import java.util.List;


public class DisplayPath {
    protected Database database;
    protected ScrollPane scroller;
    protected List<Circle> busStops;
    protected List<Text> busStopTexts;
    protected StackPane stackPane;
    protected Line line;

    public DisplayPath(){

        database = new Database();
        scroller = new ScrollPane();
        busStops = new ArrayList<Circle>();
        busStopTexts = new ArrayList<Text>();
        stackPane = new StackPane();
    }

    public ScrollPane buildView(String busNo) {
        //go to get bus' s all bus stop in database
        database.getBusStop(busNo);
        scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        GridPane gridPane = new GridPane();
        gridPane.setMaxSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(15);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        //สร้างวงกลมตามจำนวนป้ายทั้งหมดของสายนั้น
        for(int i = 0 ; i < database.getAllBusStop().size() ; i++){
            busStops.add(new Circle(0,0,40));
            busStopTexts.add(new Text(database.getAllBusStop().get(i)));
        }

        //สร้างวงกลมบนจอและเพิ่มชื่อป้ายนั้น
        for(int i = 0 ; i < busStops.size() ; i++){
            busStops.get(i).setFill(Color.YELLOW);
            gridPane.add(busStops.get(i), 0, i);
            gridPane.add(busStopTexts.get(i),1,i);

        }
        database.resetBusStopList();

        //สร้างเส้นระหว่างป้าย
        if(busNo.equals("29")) {
            int endY = busStops.size() * 90;
            line = new Line(10, 0, 10, endY);
            line.setStrokeWidth(20);
            line.setStroke(Color.YELLOW);
            stackPane.setMargin(line, new Insets(0, 0, 0, -285));
            stackPane.setMargin(gridPane, new Insets(0, 0, 0, 0));
        }
        if(busNo.equals("134")) {
            int endY = busStops.size() * 93;
            line = new Line(10, 0, 10, endY);
            line.setStrokeWidth(20);
            line.setStroke(Color.YELLOW);
            stackPane.setMargin(line, new Insets(0, 0, 0, -282));
            stackPane.setMargin(gridPane, new Insets(0, 0, 0, 0));
        }
        if(busNo.equals("191")) {
            int endY = busStops.size() * 93;
            line = new Line(10, 0, 10, endY);
            line.setStrokeWidth(20);
            line.setStroke(Color.YELLOW);
            stackPane.setMargin(line, new Insets(0, 0, 0, -280));
            stackPane.setMargin(gridPane, new Insets(0, 0, 0, 0));
        }
        if(busNo.equals("510")) {
            int endY = busStops.size() * 93;
            line = new Line(10, 0, 10, endY);
            line.setStrokeWidth(20);
            line.setStroke(Color.YELLOW);
            stackPane.setMargin(line, new Insets(0, 0, 0, -300));
            stackPane.setMargin(gridPane, new Insets(0, 0, 0, 0));
        }
        if(busNo.equals("555")) {
            int endY = busStops.size() * 93;
            line = new Line(10, 0, 10, endY);
            line.setStrokeWidth(20);
            line.setStroke(Color.YELLOW);
            stackPane.setMargin(line, new Insets(0, 0, 0, -318));
            stackPane.setMargin(gridPane, new Insets(0, 0, 0, 0));
        }



        ObservableList list = stackPane.getChildren();
        list.addAll(gridPane,line);

        busStops.clear();
        busStopTexts.clear();
        scroller.setContent(stackPane);
        return scroller;
        }

        public Database getDatabase(){ return database; }
    }

