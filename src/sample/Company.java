package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Company {
    public String name, profile, location;
    public int offeredSalary;
    public int vacancy;
    public Candidate[] selectedCandidates;

    public Company(String name, String location, String profile, int vacancy, int offeredSalary){
        this.name = name;
        this.location = location;
        this.profile = profile;
        this.vacancy = vacancy;
        this.offeredSalary = offeredSalary;
    }

    void viewResults(){

    }

    void openPortal(){
        Stage window = new Stage();

        BorderPane layout = new BorderPane();


        HBox header = Sample.titleGenerator("Company Portal");
        layout.setTop(header);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button button1 = new Button();
        Button button2 = new Button();

        button1.setText("Shortlist students");
        button2.setText("View Selected Students");
        button1.setOnAction(e -> shortlist());

        button2.setOnAction(e -> viewResults());

        HBox confirmation = new HBox();
        //confirmation.setAlignment(Pos.CENTER);
        confirmation.getChildren().addAll(button1, button2);

        vbox.getChildren().add(confirmation);
        layout.setCenter(vbox);
        Scene scene = new Scene(layout, 600, 400);

        window.setTitle("Company Portal");
        window.setScene(scene);
        window.show();
    }

    void shortlist(){
        /*Read database, and shortlist students who have applied. After shortlisting, write in another database,
        each line containing the name of the student, and the companies who selected him.
        */
        int i=0;
        String lineContent="";
        String filename = "studentsapplication.txt";
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
