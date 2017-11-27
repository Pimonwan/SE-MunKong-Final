package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    protected ArrayList<String> allBusStop = new ArrayList<String>();
    protected ObservableList<String> options = FXCollections.observableArrayList();

    public void getBusStop(String busNumber) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:BusSystem.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "Select * from stopping WHERE bus_number = "+busNumber +" ORDER BY order_sequence;";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    String bus = resultSet.getString("busStop_name");
                    allBusStop.add(bus);
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void getAllBusStopFromDB(){
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:BusSystem.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT DISTINCT busStop_name FROM stopping ORDER BY busStop_name;";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    String bus = resultSet.getString("busStop_name");
                    options.add(bus);
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getNoBus(String stopName){
        ArrayList<String> list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:BusSystem.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT bus_number FROM stopping WHERE busStop_name = '"+stopName+"'";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    String bus = resultSet.getString("bus_number");
                    list.add(bus);
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return list;
    }

    public List<String> getAllBusStop(){
        return allBusStop;
    }
    public void resetBusStopList(){
        allBusStop.clear();
    }
    public ObservableList<String> getOptions(){ return options; }

}
