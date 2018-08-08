package employee;

import java.util.Comparator;

/**
 * used for imposing total ordering on Employee
 * @author Prakalpa-Rathore
 *
 */
public class NameComparator implements Comparator<Employee>{

    /**
     * method used for imposing total ordering by name on Employee
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        
        return employee1.getName().compareTo(employee2.getName());
    }

}
