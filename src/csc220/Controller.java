package csc220;

import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable
{
    
    //  Controls that appear in the GUI frame.
    @FXML
    TextArea outputArea;
    @FXML
    TextField searchForField;
    
    //  Comparators    
    private Comparator<Student> compareByGrade;
    private Comparator<Student> compareByName;
    
    //  Indexes for various searches
    private Student[] students;
    private Student[] orderedByGrade;
    private Student[] orderedByName;
    
    private interface Displayer
    {
        public String getDisplayInfo(Student s);
    }
        
    @FXML
    private void searchForByGrade(ActionEvent event)
    {
        Button b = (Button)event.getSource();  // "Typecast" to Button
        char gradeToFind = b.getText().charAt(0);
        outputArea.setText("Students achieving an " + gradeToFind + "\n");
       
        Student key = new Student("", gradeToFind);

        display(orderedByGrade, key, compareByGrade, s -> s.getName());
    }
    
    @FXML
    private void searchForByName(ActionEvent event)
    {
        System.out.println("Search for " + searchForField.getText());
        outputArea.setText("");
        String nameToFind = searchForField.getText();
        Student key = new Student(nameToFind, ' ');
        
        display(orderedByName, key, compareByName, (s) -> s.toString());
 
    }
            
    private void display(Student[] index, 
                         Student key, 
                         Comparator<Student> comparator,
                         Displayer displayer)
    {
       
       //  Sequential search
       int start = Arrays.binarySearch(index, key, comparator);
       
       if (start < 0)  //  Grade not found
           return;
       
       //  Here's what we were missing on Monday!
//       while (start > 0 && orderedByGrade[start-1].getGrade() == gradeToFind)
       while (start > 0 && comparator.compare(index[start-1], key) == 0)
       {
           start -= 1;
       }
       
       for (int i = start; i < index.length; i += 1)
       {
//           if (orderedByGrade[i].getGrade() != gradeToFind)
            if (comparator.compare(index[i], key) != 0)
               return;
            String s = displayer.getDisplayInfo(index[i]);
            outputArea.appendText(s + "\n");
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //  Create comparators needed for sorting and searching.
        compareByGrade = (s1, s2) -> Character.compare(s1.getGrade(), s2.getGrade());
        compareByName = (s1, s2) -> s1.getName().compareTo(s2.getName());
        //  Still need one to search for by ID
        
        //  Add some students to the array.
        students = new Student[]
        {
            new Student("Lena Horne", 'D'),
            new Student("Edgar Rice Burroughs", 'B'),
            new Student("Lauren Bacall", 'B'),
            new Student("Tony Blair", 'C'),
            new Student("Isaac Asimov", 'B'),
            new Student("Lena Horne", 'A'),
            new Student("Tony Blair", 'A'),
        };
        
        orderedByGrade = Arrays.copyOf(students, students.length);
        Arrays.sort(orderedByGrade, compareByGrade);
        orderedByName = Arrays.copyOf(students, students.length);
        Arrays.sort(orderedByName, compareByName);

        System.out.println("Original:         " + Arrays.toString(students));
        System.out.println("Ordered by grade: " + Arrays.toString(orderedByGrade));
        System.out.println("Ordered by name:  " + Arrays.toString(orderedByName));
    }

    
}
