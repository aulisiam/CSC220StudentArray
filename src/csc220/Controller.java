package csc220;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable
{
    
    //  Controls that appear in the GUI frame.
    @FXML
    TextArea outputArea;
    @FXML
    TextField searchForField;
    @FXML
    TextField searchForByIdField;
    
    private OrderByGrade orderByGrade;
    private OrderByName orderByName;
    private OrderById orderById;
    
    private Student[] students;
    private Student[] orderedByGrade;
    private Student[] orderedByName;
    private Student[] orderedById;
    
    @FXML
    private void findAs(ActionEvent event){display('A');}
    @FXML
    private void findBs(ActionEvent event){display('B');}
    @FXML
    private void findCs(ActionEvent event){display('C');}
    @FXML
    private void findDs(ActionEvent event){display('D');}
    
    @FXML
    private void searchForByName(ActionEvent event)
    {
        System.out.println("Search for " + searchForField.getText());
        
        String nameToFind = searchForField.getText();
        Student key = new Student(nameToFind, ' ');
        
        outputArea.setText("Search for " + nameToFind + "\n");
       
       //  Sequential search
       int start = Student.indexOfFirstMatchingBy(orderedByName, key, orderByName);
       if (start < 0)  //  Name not found
           return;
       for (int i = start; i < orderedByName.length; i += 1)
       {
           if (!orderedByName[i].getName().equals(nameToFind))
               return;
            outputArea.appendText(orderedByName[i].toString() + "\n");
       }
 
    }
    
    @FXML
    private void searchForById(ActionEvent event)
    {
        System.out.println("Search for Id " + searchForByIdField.getText());
<<<<<<< Updated upstream
        String idToFind = searchForByIdField.getText();
        Student key = new Student(Integer.parseInt(idToFind));
        
        outputArea.setText("Search for Id " + idToFind + "\n" );
        
        //Sequential Search
        int start = Student.indexOfFirstMatchingBy(orderedById, key, orderById);
        if (start < 0)
        {
            return;
        }
        for (int i = start; i < orderedById.length; i += 1)
       {
           if (!orderedById[i].getId() != idToFind)
           {
                outputArea.appendText(orderedById[i].toString() + "\n");
           }
       }
=======
        int id = searchForByIdField.getText();
        Student key = new Student(id);
>>>>>>> Stashed changes
    }
            
    private void display(char gradeToFind)
    {
       outputArea.setText("Students achieving an " + gradeToFind + "\n");
       
       Student key = new Student("", gradeToFind);
       
       //  Sequential search
       int start = Student.indexOfFirstMatchingBy(orderedByGrade, key, orderByGrade);
       if (start < 0)  //  Grade not found
           return;
       for (int i = start; i < students.length; i += 1)
       {
           if (orderedByGrade[i].getGrade() != gradeToFind)
               return;
            outputArea.appendText(orderedByGrade[i].getName() + "\n");
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        orderByGrade = new OrderByGrade();
        orderByName = new OrderByName();
        //  Add some students to the array.
        students = new Student[]
        {
            new Student("Edgar Rice Burroughs", 'B'),
            new Student("Lauren Bacall", 'B'),
            new Student("Tony Blair", 'C'),
            new Student("Isaac Asimov", 'B'),
            new Student("Lena Horne", 'A'),
        };
        orderedByGrade = Arrays.copyOf(students, students.length);
        Student.sortBy(orderedByGrade, orderByGrade);
        orderedByName = Arrays.copyOf(students, students.length);
        Student.sortBy(orderedByName, orderByName);

        System.out.println("Original:         " + Arrays.toString(students));
        System.out.println("Ordered by grade: " + Arrays.toString(orderedByGrade));
        System.out.println("Ordered by name:  " + Arrays.toString(orderedByName));
    }
    
}
