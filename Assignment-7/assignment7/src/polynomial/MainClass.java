package polynomial;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        
        int choice;
        Scanner sc = new Scanner(System.in);
        
        do
        {
            System.out.println("\nMENU");
            System.out.println("1. Evaluate a polynomial");
            System.out.println("2. Find degree of a polynomial");
            System.out.println("3. Add two polynomials");
            System.out.println("4. Multiply two polynomials");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: System.out.println("Enter the no. of terms in polynomial:");
                        int n = sc.nextInt();
                        System.out.println("Enter the polynomial");
                        int[][] array = new int[n][2];
                        
                        for(int i = 0; i < n; i++)
                        {
                            System.out.println("Coefficient:");
                            array[i][0] = sc.nextInt();
                            
                            System.out.println("Power:");
                            array[i][1] = sc.nextInt();
                        }
                        
                        Poly polynomial = new Poly(array);
                        System.out.println("Enter the value of variable x:");
                        float x = sc.nextFloat();
                        System.out.println("The result after evaluation is: " + polynomial.evaluate(x));
                        break;
                        
                case 2: System.out.println("Enter the no. of terms in polynomial:");
                        n = sc.nextInt();
                        System.out.println("Enter the polynomial");
                        int[][] array1 = new int[n][2];
                        
                        for(int i = 0; i < n; i++)
                        {
                            System.out.println("Coefficient:");
                            array1[i][0] = sc.nextInt();
                    
                            System.out.println("Power:");
                            array1[i][1] = sc.nextInt();
                        }
                        
                        Poly polynomial1 = new Poly(array1);
                        System.out.println("The degree of the polynomial is: " + polynomial1.degree());
                        break;
                        
                case 3: System.out.println("Enter the no. of terms in the first polynomial:");
                        int n1 = sc.nextInt();
                        System.out.println("Enter the first polynomial");
                        int[][] firstArray = new int[n1][2];
                        
                        for(int i = 0; i < n1; i++)
                        {
                            System.out.println("Coefficient:");
                            firstArray[i][0] = sc.nextInt();
            
                            System.out.println("Power:");
                            firstArray[i][1] = sc.nextInt();
                        }
                        
                        Poly firstPolynomial = new Poly(firstArray);
                        
                        System.out.println("Enter the no. of terms in the second polynomial:");
                        int n2 = sc.nextInt();
                        System.out.println("Enter the second polynomial");
                        int[][] secondArray = new int[n2][2];
                        
                        for(int i = 0; i < n2; i++)
                        {
                            System.out.println("Coefficient:");
                            secondArray[i][0] = sc.nextInt();
            
                            System.out.println("Power:");
                            secondArray[i][1] = sc.nextInt();
                        }
                        
                        Poly secondPolynomial = new Poly(secondArray);
                        
                        Poly addition = Poly.addPoly(firstPolynomial, secondPolynomial);
                        System.out.println("The polynomial after addition is:");
                        int[][] resultArray = addition.getPolynomial();
                        
                        for(int i = 0; i < resultArray.length; i++)
                        {
                            System.out.print(resultArray[i][0] + "x^" + resultArray[i][1]);
                            if(i < resultArray.length - 1)
                                System.out.print(" +");
                        }
                        
                        break;
                        
                case 4: System.out.println("Enter the no. of terms in the first polynomial:");
                        n1 = sc.nextInt();
                        System.out.println("Enter the first polynomial");
                        int[][] firstPolyArray = new int[n1][2];
                        
                        for(int i = 0; i < n1; i++)
                        {
                            System.out.println("Coefficient:");
                            firstPolyArray[i][0] = sc.nextInt();
    
                            System.out.println("Power:");
                            firstPolyArray[i][1] = sc.nextInt();
                        }
                        
                        Poly firstPoly = new Poly(firstPolyArray);
                
                        System.out.println("Enter the no. of terms in the second polynomial:");
                        n2 = sc.nextInt();
                        System.out.println("Enter the second polynomial");
                        int[][] secondPolyArray = new int[n2][2];
                        
                        for(int i = 0; i < n2; i++)
                        {
                            System.out.println("Coefficient:");
                            secondPolyArray[i][0] = sc.nextInt();
    
                            System.out.println("Power:");
                            secondPolyArray[i][1] = sc.nextInt();
                        }
                        
                        Poly secondPoly = new Poly(secondPolyArray);
                
                        Poly multiplication = Poly.multiplyPoly(firstPoly, secondPoly);
                        System.out.println("The polynomial after multiplication is:");
                        int[][] result = multiplication.getPolynomial();
                        
                        for(int i = 0; i < result.length; i++)
                        {
                            System.out.print(result[i][0] + "x^" + result[i][1]);
                            if(i < result.length - 1)
                                System.out.print(" +");
                        }
                        
                        break;
                        
                case 5: break;
                
                default: System.out.println("Wrong choice!! Please select correct option");
            }
        }while(choice!=5);

    }

}
