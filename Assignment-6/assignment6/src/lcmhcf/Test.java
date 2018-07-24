package lcmhcf;

import static org.junit.Assert.*;

public class Test {

    MathsOperation mathsOperations = new MathsOperation();
    
    /**
     * Test case for checking lcm 
     */
    @org.junit.Test
    public void testLCM() {
        int lcm = mathsOperations.LCM(9, 6);
        assertEquals(18, lcm);
    }
    
    
    /**
     * Test case for checking hcf 
     */
    @org.junit.Test
    public void testHCF() {
        int hcf = mathsOperations.HCF(9, 6);
        assertEquals(3, hcf);
    }

}
