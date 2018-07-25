package intSet;

/**
 * immutable class intSet which uses an array to represent a set of integers in the range 1-1000
 * @author Prakalpa-Rathore
 *
 */
public final class IntSet {

    private final int[] set;
    
    public int[] getSet() {
        
        int[] newSet = new int[size()];
        
        for(int i = 0; i < size(); i++)
            newSet[i] = set[i];
        
        return newSet;
    }

    
    /**
     * constructor of the class
     * @param inputSet
     */
    public IntSet(int[] inputSet)
    {
        if(inputSet == null)
            throw new AssertionError("Invalid input");
        
        if(inputSet.length == 0)
            this.set = new int[]{};
        else
        {
            sort(inputSet);
            int[] finalInputSet = removeDuplicate(inputSet);
            
            this.set = new int[finalInputSet.length];
            int term = 0;
            
            for(int i = 0; i < finalInputSet.length; i++) 
            {
                if(finalInputSet[i] >= 1 && finalInputSet[i] <= 1000)
                {
                    this.set[term] = finalInputSet[i];
                    term++;
                }
            }
        }
     }
    
    
    /**
     * check whether x is a member of the set 
     * @param x
     * @return boolean value
     */
    public boolean isMember(int x)
    {
        int i = 0;
        boolean member = false;
                
        if(x >= 1 && x <= 1000)
        {
            while(i < set.length)
            {
                if(set[i] == x)
                {
                    member = true;
                    break;
                }
                i++;                
            }
        }
                
        return member;
    }
    
    
    /**
     * calculates the size of the set
     * @return size
     */
    public int size()
    {
        int i = 0;
        
        while(i < set.length && set[i] != 0)
            i++;
        
        return i;
    }
    
    
    /**
     * check whether s is a subset of the set
     * @param s
     * @return boolean value
     */
    public boolean isSubSet(IntSet s)
    {
        boolean isSubSet = false;
        int[] sArray = s.getSet();
        int j = 0;
        
        if(s.size() == 0)
            isSubSet = true;
        
        if(this.size() >= s.size())
        {
            for(int i = 0; i < this.size(); i++)
            {
                if(j < s.size())
                    isSubSet = false;
                else
                    break;
                
                if(set[i] == sArray[j])
                {    
                    isSubSet = true;
                    j++;
                }
            }
        }
        return isSubSet;
    }
    
    
    /**
     * creates the complement set, assuming that 1..1000 is the universal set
     * @return complement set
     */
    public IntSet getComplement()
    {
        int[] complement = new int[1000 - this.size()];
        int term = 0;
        
        for(int i = 1; i <= 1000; i++)
        {
            if(!this.isMember(i))
                complement[term++] = i;
        }
        
        return new IntSet(complement);
    }
    
    
    /**
     * computes the union of sets s1 and s2
     * @param s1
     * @param s2
     * @return union set
     */
    public static IntSet union(IntSet s1, IntSet s2)
    {
        int term = 0;
        int[] s1Array = s1.getSet();
        int[] s2Array = s2.getSet();
        int[] union = new int[s1Array.length + s2Array.length];
        
        for(int i = 0; i < s1.size(); i++)
            union[term++] = s1Array[i];
        
        for(int j = 0; j < s2.size(); j++)
            union[term++] = s2Array[j];
        
        return new IntSet(union);
        
    }
    
    
    /**
     * helper method to remove duplicate values from the set
     * @param array
     * @return array after removing duplicate values
     */
    private int[] removeDuplicate(int[] array)
    {
        int[] newArray = new int[array.length];
        int term = 0;
                
        for(int i = 0; i < array.length; i++) 
        {
            newArray[term] = array[i];
            
            while((i + 1) != array.length && newArray[term] == array[i + 1])
                i++;
            
            term++;
        }
        
        return newArray;
    }
    
    
    /**
     * helper method to sort the values in the set
     * @param set
     */
    public void sort(int[] set)
    {
        int size = set.length;
        
        while(set[size - 1] == 0)
            size--;
                
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = 0; j < size - i - 1; j++)
            {
                if(set[j] > set[j + 1])
                {
                    int temp = set[j];
                    set[j] = set[j + 1];
                    set[j + 1] = temp;
                }
            }
        }
    }
}
