package csc220;

public class Student
{
    private String name;
    private int id;
    private char grade;  //  Only letter grades--no + or -
    
    private static int nextId = 1;
    
    public Student(int id)  //  Creates a "dummy" Student with a specific ID.
    {
        this.id = id;
        this.name = "";
        this.grade = ' ';
    }
    
    public Student(String name, char grade)
    {
        id = nextId;  // Automatically generate a new id for every new Student.
        nextId += 1;
        this.name = name; 
        this.grade = grade;
    }
    
    public int    getId()   {return id;}
    public String getName() {return name;}
    public char   getGrade(){return grade;}
    
    @Override
    public String toString()
    {
        return id + ":" + name + ":" + grade;
    }
        
}
