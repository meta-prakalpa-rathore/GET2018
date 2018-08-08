package uniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest {

	/**
	 * test case for countUniqueCharacters when string contains only characters
	 */
	@Test
    public void countUniqueCharactersTest1() {
        
        String string = "Prakalpa";
        assertEquals(5, CountUniqueCharacters.countUniqueCharacters(string));
    }

    
	/**
	 * test case for countUniqueCharacters when string contains characters, numbers as well as special characters
	 */
    @Test
    public void countUniqueCharactersTest2() {
        
        String string = "Prakalpa#1213";
        assertEquals(9, CountUniqueCharacters.countUniqueCharacters(string));
    }
    
    
    /**
	 * test case for countUniqueCharacters when string contains words with spaces
	 */
    @Test
    public void countUniqueCharactersTest3() {
        
        String string = "Prakalpa Rathore";
        assertEquals(10, CountUniqueCharacters.countUniqueCharacters(string));
    }
    
    
    /**
	 * test case for countUniqueCharacters when string is null
	 */
    @Test(expected = NullPointerException.class)
    public void countUniqueCharactersTest4() {
        
        CountUniqueCharacters.countUniqueCharacters(null);
    }
}
