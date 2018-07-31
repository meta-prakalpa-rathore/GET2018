package mutablePolynomial;

/**
 * mutable class Poly which uses an array to represent single variable polynomial
 * @author Prakalpa-Rathore
 *
 */
public class MutablePoly {

    private int[][] polynomial;
    private static final int COEFFICIENT = 0;
    private static final int POWER = 1;
    
    /**
     * constructor of the class
     * @param inputPolynomial a 2-d array having coefficients and corresponding powers,
     * assumes coefficient will be integer
     */
    public MutablePoly(int[][] inputPolynomial)
    {
        if(inputPolynomial == null || inputPolynomial.length == 0)
            throw new AssertionError("Invalid input");
        
        int noOfRows = inputPolynomial.length;
        this.polynomial = new int[noOfRows][2];
        
        for(int i = 0; i < noOfRows; i++)
        {
            int duplicateTerm = checkPower(polynomial, inputPolynomial[i][POWER]);
            
            if(duplicateTerm != -1)
            {
                polynomial[duplicateTerm][COEFFICIENT] += inputPolynomial[i][COEFFICIENT];
            }
            else
            {
                if(inputPolynomial[i][COEFFICIENT] != 0)
                {
                    this.polynomial[i][COEFFICIENT] = inputPolynomial[i][COEFFICIENT];
                    this.polynomial[i][POWER] = inputPolynomial[i][POWER];
                }
            }            
        }
    }
    
    
    public int[][] getPolynomial() {

        int[][] newPolynomial = new int[size()][2];
        
        for(int i = 0; i < size(); i++)
        {
            newPolynomial[i][COEFFICIENT] = polynomial[i][COEFFICIENT];
            newPolynomial[i][POWER] = polynomial[i][POWER];
        }
        
        return newPolynomial;
    } 
    
    
    /**
     * method to add a term in the polynomial
     * @param coefficient
     * @param power
     */
    public void addTerm(int coefficient, int power)
    {
        int duplicateTerm = checkPower(polynomial, power);
        
        if(duplicateTerm != -1)
        {
            polynomial[duplicateTerm][COEFFICIENT] += coefficient;
        }
        else
        {
            if(coefficient != 0)
            {
                int[][] newPolynomial = new int[polynomial.length + 1][2];
                int i;
                
                for(i = 0; i < polynomial.length; i++)
                {
                   newPolynomial[i][COEFFICIENT] = polynomial[i][COEFFICIENT];
                   newPolynomial[i][POWER] = polynomial[i][POWER];
                }
                
                polynomial = newPolynomial;
                this.polynomial[i][COEFFICIENT] = coefficient;
                this.polynomial[i][POWER] = power;
            }
        }            
    }
    
    
    /**
     * method to remove a term from the polynomial, throws assertion error if term is not present in the polynomial
     * @param power
     */
    public void removeTerm(int power)
    {
        int index = checkPower(polynomial, power);
        
        if(index != -1)
        {
            int[][] newPolynomial = new int[polynomial.length - 1][2];
            int i = 0;
            
            for(int j = 0; j < polynomial.length; j++)
            {
                if(j != index)
                {
                    newPolynomial[i][COEFFICIENT] = polynomial[j][COEFFICIENT];
                    newPolynomial[i][POWER] = polynomial[j][POWER];
                    i++;
                }
            }
            
            polynomial = newPolynomial;
        }
        else
            throw new AssertionError("Term not found!");
    }
    
    
    /**
     * evaluates the value of the polynomial for the given value of the variable
     * @param x value of variable
     * @return the result after evaluation, throws AssertionError if value is infinity
     */
    public double evaluate(float x)
    {
        double result = 0;
        
        for(int i = 0; i < polynomial.length; i++)
        {
            result += polynomial[i][COEFFICIENT] * Math.pow(x, polynomial[i][POWER]);
        }
        
        if(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY)
            throw new AssertionError("Result is too large");
        
        return result;
    }
    
    
    /**
     * computes the degree of the polynomial
     * @return degree of the polynomial
     */
    public int degree()
    {
        int degree = 0;
        
        for(int i = 0; i < polynomial.length; i++)
        {
            if(polynomial[i][POWER] > degree)
                degree = polynomial[i][POWER];
        }
        
        return degree;
    }
    
    
    /**
     * calculates the sum of the polynomials p1 and p2
     * @param p1
     * @param p2
     * @return the resulting polynomial after addition
     */
    public static MutablePoly addPoly(MutablePoly p1, MutablePoly p2)
    {
        int maxDegree = (p1.degree() > p2.degree()) ? p1.degree() : p2.degree();
        int[][] addition = new int[maxDegree + 1][2];
        int term = 0;
        
        for(int i = 0; i <= maxDegree; i++)
        {
            int coefficientP1 = p1.getCoefficientOfX(i);
            int coefficientP2 = p2.getCoefficientOfX(i);
            
            if(coefficientP1 != 0 || coefficientP2 != 0)
            {
                addition[term][COEFFICIENT] = coefficientP1 + coefficientP2;
                addition[term][POWER] = i;
                term++;
            }
                
        }
        
        return new MutablePoly(addition);
    }
    
    
    /**
     * calculates the product of polynomials p1 and p2
     * @param p1
     * @param p2
     * @return the resulting polynomial after multiplication
     */
    public static MutablePoly multiplyPoly(MutablePoly p1, MutablePoly p2)
    {
        int maxDegree = p1.degree() + p2.degree();
        int[][] multiplication = new int[maxDegree + 1][2];
        int term = 0;
        int[][] p1Array = p1.getPolynomial();
        int[][] p2Array = p2.getPolynomial();
        
        for(int i = 0; i < p1Array.length; i++)
        {
            for(int j = 0; j < p2Array.length; j++)
            {
                int powerTerm = p1Array[i][POWER] + p2Array[j][POWER];
                int duplicateTerm = checkPower(multiplication, powerTerm);
                
                if(duplicateTerm != -1)
                {
                    multiplication[duplicateTerm][COEFFICIENT] += p1Array[i][COEFFICIENT] * p2Array[j][COEFFICIENT];
                }
                else
                {
                    multiplication[term][COEFFICIENT] = p1Array[i][COEFFICIENT] * p2Array[j][COEFFICIENT];
                    multiplication[term][POWER] = powerTerm;
                    term++;
                }
            }
        }
        
        return new MutablePoly(multiplication);
        
    }
    
    
    /**
     * helper method to get the coefficient for the given power of the polynomial
     * @param powerOfX
     * @return coefficientOfX
     */
    private int getCoefficientOfX(int powerOfX)
    {
        int coefficientOfX = 0;
        
        for(int i = 0; i < polynomial.length; i++)
        {
            if(polynomial[i][POWER] == powerOfX)
                coefficientOfX = polynomial[i][COEFFICIENT];
        }
        
        return coefficientOfX;
    }
    
    
    /**
     * helper method to check if a term with given power exists in the polynomial 
     * @param array, array representation of the polynomial
     * @param powerTerm
     * @return term index with same power (-1 if not found)
     */
    private static int checkPower(int[][] array, int powerTerm)
    {
        int duplicateTerm = -1;
        
        for(int i = 0; i < array.length; i++)
        {
            if(array[i][POWER] == powerTerm)
            {
                duplicateTerm = i;
                break;
            }
        }
        
        return duplicateTerm;
    }
    
    
    /**
     * helper method to find the length of the polynomial
     * @return
     */
    private int size()
    {
        int i = 0;
        
        while(i < polynomial.length && polynomial[i][COEFFICIENT] != 0)
            i++;
        
        return i;
    }
}
