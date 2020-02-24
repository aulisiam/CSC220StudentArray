package csc220;

import java.util.Comparator;

public class ComparatorByGrade implements Comparator<Student>
{

    @Override
    public int compare(Student s1, Student s2)
    {
        return Character.compare(s1.getGrade(), s2.getGrade());
    }
    
}
