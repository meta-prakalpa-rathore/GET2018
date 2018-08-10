package employee;

/**
 * custom class to store properties of an employee
 * @author Prakalpa-Rathore
 */
public class Employee implements Comparable<Employee>{

    final int empId;
    final String name;
    String address;
    
    /**
     * parameterized constructor of the class
     * @param empId
     * @param name
     * @param address
     */
    public Employee(int empId, String name, String address) {
        
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    
    /**
     * getter of address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    
    /**
     * setter of address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /**
     * getter of empId
     * @return empId
     */
    public int getEmpId() {
        return empId;
    }

    
    /**
     * getter of name
     * @return name
     */
    public String getName() {
        return name;
    }

    
    /**
     * compares two employee objects on the basis of empId
     */
    @Override
    public int compareTo(Employee otherEmployee) {
        
        return this.empId - otherEmployee.empId;
    }  
    
    
    /**
     * Returns the hashCode of this object
     */
    @Override
    public int hashCode() {
       return empId;
    }
    
    
    /**
     * compares this employee object to the specified object
     */
    @Override
    public boolean equals(Object obj) {
       if (this == obj)
          return true;
       if (obj == null)
          return false;
       if (getClass() != obj.getClass())
          return false;
       Employee other = (Employee) obj;
       if (empId != other.empId)
          return false;
       return true;
    }
    
}
