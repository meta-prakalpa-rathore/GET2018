package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * used to sort a list of Employees by natural ordering, i.e empId
 * @author Prakalpa-Rathore
 *
 */
public class SortByNaturalOrder {

    List<Employee> collectionOfEmployee = new ArrayList<Employee>();
    
    /**
     * getter of collectionOfEmployee list
     * @return collectionOfEmployee
     */
    public List<Employee> getCollectionOfEmployee() {
        
        return collectionOfEmployee;
    }

    
    /**
     * method for adding the given employee to the collectionOfEmployee list
     * @param employee
     * @return true if employee is added, false otherwise
     */
    public boolean addEmployee(Employee employee)
    {
        try {

            if(employee == null)
                throw new AssertionError("Invalid input");

            boolean flag = true;

            for(Employee employeeInCollection : collectionOfEmployee)
            {
                if(employee.getEmpId() == employeeInCollection.getEmpId()) 
                {
                    flag = false;
                    break;
                }
            }

            if(flag)
                collectionOfEmployee.add(employee);

            return flag;
            
        } 
        catch (AssertionError error)
        {
            return false;
        }
    }
    
    
    /**
     * method to sort the collectionOfEmployee list by natural ordering, i.e empId
     */
    public void sortByNaturalOrder()
    {
        Collections.sort(collectionOfEmployee);
    }
}
