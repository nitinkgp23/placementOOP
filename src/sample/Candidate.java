package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ComponentAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Candidate {
    public String name, rollnum;
    public double cgpa, score;
    public int expectedSalary;
    public Company companyAllocated;

    /* parameterized constructor */
    public Candidate(String name, String rollnum, double cgpa, int expectedSalary){
        this.name = name;
        this.rollnum = rollnum;
        this.cgpa = cgpa;
        this.expectedSalary = expectedSalary;
    }

    void applyToCompanies(){

        ObservableList<Company> data = FXCollections.observableArrayList();

        try{
            FileReader fr = new FileReader("company_list.txt");
            BufferedReader bufr = new BufferedReader(fr);
            String line = bufr.readLine();
            while(line != null){
                String[] items = line.split(":");

                Company com = new Company(items[0], items[2], items[3], Integer.parseInt(items[4]), Integer.parseInt(items[5]));
                if (com.offeredSalary > this.expectedSalary)
                    System.out.println(com.name);
                    data.add(com);
                    System.out.println(2);
                line = bufr.readLine();
            }
            bufr.close();
        }
        catch(IOException e){
            System.out.println("Error while reading file.");
        }

        Stage window = new Stage();
        window.setTitle("Company List");
        window.setWidth(600);
        window.setHeight(400);

        TableView table = new TableView();

        TableColumn companyNameCol = new TableColumn("Name");
        TableColumn locationCol = new TableColumn("Location");
        TableColumn profileCol = new TableColumn("Profile");
        TableColumn salaryCol = new TableColumn("Offered Salary");

        companyNameCol.setMinWidth(200);
        locationCol.setMinWidth(100);
        profileCol.setMinWidth(200);
        salaryCol.setMinWidth(100);

        companyNameCol.setCellValueFactory(new PropertyValueFactory<Company, String>("Name"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Company, String>("Location"));
        profileCol.setCellValueFactory(new PropertyValueFactory<Company, String>("Profile"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<Company, Integer>("Offered Salary"));

        table.setItems(data);
        table.getColumns().addAll(companyNameCol, locationCol, profileCol, salaryCol);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);

        Scene browse = new Scene(new Group());
        ((Group) browse.getRoot()).getChildren().addAll(vbox);

        window.setScene(browse);
        window.show();
    }
    void viewResults(){

    }
    void openPortal(){
        Stage window = new Stage();

        BorderPane layout = new BorderPane();


        HBox header = Sample.titleGenerator("Candidate Portal");
        layout.setTop(header);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button button1 = new Button();
        Button button2 = new Button();

        button1.setText("Apply");
        button2.setText("View Results");

        button1.setLayoutX(150);
        button1.setLayoutY(100);
        button2.setLayoutX(250);
        button2.setLayoutY(100);

        button1.setOnAction(e -> applyToCompanies());
        button2.setOnAction(e -> viewResults());

        HBox confirmation = new HBox();
        //confirmation.setAlignment(Pos.CENTER);
        confirmation.getChildren().addAll(button1, button2);
        //confirmation.getChildren().addAll(button3, button4);

        vbox.getChildren().add(confirmation);
        layout.setCenter(vbox);
        Scene scene = new Scene(layout, 400, 200);

        window.setTitle("Placement Portal");
        window.setScene(scene);
        window.show();
    }
    void apply(Company c){
        /*Write the student object on a new database, each line contains the list of students
        applying for a single company.
         */
        String filename = "studentsapplication.txt";
        String candidateData = c.name + ":" + rollnum + "|" + cgpa + "|" + score + "|" + expectedSalary;
        Sample.writeToFile(candidateData, filename);
    }

    void allocate(){
        /*Read from the database of the student which companies selected him, allocate him the
        highest offering package. Modify the allocatedCompany attribute of the student. Also,
        modify the selectedStudents attribute of the company.
         */
        int i=0;
        String lineContent="";
        String filename = "companyshortlist.txt";
        String content = Sample.readFromFile(filename);
        char c[] = content.toCharArray();

        while(c[i]!='\0'){
            while(c[i] !='\n'){
                lineContent += c[i];
                i++;
            }
            if (lineContent.startsWith(this.name)){
                /*parse this line*/
            }
            else
                i++;
        }
    }

}
