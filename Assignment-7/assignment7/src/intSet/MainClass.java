package intSet;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        
        int choice;
        Scanner sc = new Scanner(System.in);
        
        do
        {
            System.out.println("\nMENU");
            System.out.println("1. Check for a member in a set");
            System.out.println("2. Find the size of a set");
            System.out.println("3. Check subset");
            System.out.println("4. Get complement set");
            System.out.println("5. Find union of two sets");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: System.out.println("Enter the no. of elements:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        int n = sc.nextInt();
                        System.out.println("Enter the set");
                        int[] array = new int[n];
                        
                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            array[i] = sc.nextInt();
                        }                           
                        
                        IntSet set = new IntSet(array);
                        System.out.println("Enter the element to be searched:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        int x = sc.nextInt();
                        
                        if(set.isMember(x))
                            System.out.println(x + "is a member of the set");
                        else
                            System.out.println(x + "is not a member of the set");
                        break;
                        
                case 2: System.out.println("Enter the no. of elements:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        n = sc.nextInt();
                        System.out.println("Enter the set");
                        int[] array1 = new int[n];
                
                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            array1[i] = sc.nextInt();
                        }
                                            
                        IntSet set1 = new IntSet(array1);
                        System.out.println("The size of the set is = " + set1.size());
                        break;
                        
                case 3: System.out.println("Enter the no. of elements:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        n = sc.nextInt();
                        System.out.println("Enter the set");
                        int[] array2 = new int[n];
        
                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            array2[i] = sc.nextInt();
                        }
        
                        IntSet set2 = new IntSet(array2);
                        
                        System.out.println("Enter the no. of elements for the subset:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        n = sc.nextInt();
                        System.out.println("Enter the subset");
                        int[] subset = new int[n];
        
                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            subset[i] = sc.nextInt();
                        }
                            
                        IntSet subSet = new IntSet(subset);
                        
                        if(set2.isSubSet(subSet))
                            System.out.println("Yes, it is a subset");
                        else
                            System.out.println("No, it is not a subset");
                        break;
                        
                case 4: System.out.println("Enter the no. of elements:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        n = sc.nextInt();
                        System.out.println("Enter the set");
                        int[] array3 = new int[n];

                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            array3[i] = sc.nextInt();
                        }
                            
                        IntSet set3 = new IntSet(array3);
                        
                        System.out.println("The complement of the set is:");
                        int[] complement = set3.getComplement().getSet();
                        for(int i = 0; i < complement.length; i++)
                            System.out.println(complement[i]);
                        break;
                        
                case 5: System.out.println("Enter the no. of elements of set1:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        n = sc.nextInt();
                        System.out.println("Enter the set");
                        int[] first = new int[n];

                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            first[i] = sc.nextInt();
                        }
                            
                        IntSet firstSet = new IntSet(first);
                
                        System.out.println("Enter the no. of elements of set2:");
                        //validate input
                        while(!sc.hasNextInt())
                        {
                            System.out.println("Please enter integer value");
                            sc.next();
                        }
                        n = sc.nextInt();
                        System.out.println("Enter the set");
                        int[] second = new int[n];

                        for(int i = 0; i < n; i++)
                        {
                            //validate input
                            while(!sc.hasNextInt())
                            {
                                System.out.println("Please enter integer value");
                                sc.next();
                            }
                            second[i] = sc.nextInt();
                        }
                            
                        IntSet secondSet = new IntSet(second);
                        
                        System.out.println("The union of the sets is:");
                        int[] union = IntSet.union(firstSet, secondSet).getSet();
                        for(int i = 0; i < union.length; i++)
                            System.out.println(union[i]);
                        break;
                        
                case 6: break;
                                        
                default: System.out.println("Wrong choice!! Please select correct option");
            }
        }while(choice!=6);

    }

}
