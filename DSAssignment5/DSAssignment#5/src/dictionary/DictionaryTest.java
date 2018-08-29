package dictionary;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

public class DictionaryTest {

    /**
     * test case for addEntry
     */
    @Test
    public void addEntryTest() {
        
        Dictionary dictionary = new BSTDictionary("D:\\eclipse workspace\\DSAssignment#5\\test.json");
        
        assertTrue(dictionary.addEntry(new DictionaryEntry("hi", "hello")));
        assertTrue(dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore")));
        assertTrue(dictionary.addEntry(new DictionaryEntry("abc", "hello")));
        assertFalse(dictionary.addEntry(new DictionaryEntry("hi", "world"))); //duplicate key
        assertFalse(dictionary.addEntry(null)); //null input
    }
    
    
    /**
     * test case for deleteEntry
     */
    @Test
    public void deleteEntryTest() {
        
        Dictionary dictionary = new BSTDictionary("D:\\eclipse workspace\\DSAssignment#5\\test.json");
        
        dictionary.addEntry(new DictionaryEntry("hi", "hello"));
        dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore"));
        dictionary.addEntry(new DictionaryEntry("abc", "hello"));
        
        assertTrue(dictionary.deleteEntry("hi"));
        assertTrue(dictionary.deleteEntry("prakalpa"));
        assertFalse(dictionary.deleteEntry("hi")); //key is already deleted
        assertFalse(dictionary.deleteEntry("mango")); //key does not exist
        assertFalse(dictionary.deleteEntry(null)); //key is null
    }
    
    
    /**
     * test case for getValue
     */
    @Test
    public void getValueTest() {
        
        Dictionary dictionary = new BSTDictionary("D:\\eclipse workspace\\DSAssignment#5\\test.json");
        
        assertEquals("a", dictionary.getValue("good"));
        assertEquals("b", dictionary.getValue("rat"));
        assertEquals(null, dictionary.getValue(null)); //key is null
        assertEquals(null, dictionary.getValue("hi")); //key does not exist
        
        dictionary.deleteEntry("good");
        dictionary.deleteEntry("rat");
        dictionary.deleteEntry("hire");
        assertEquals(null, dictionary.getValue("good")); //dictionary is empty
    }
    
    
    /**
     * test case to get all the entries in sorted form
     */
    @Test
    public void sortedListTest1() {
        
        Dictionary dictionary = new BSTDictionary("D:\\eclipse workspace\\DSAssignment#5\\test.json");
        
        dictionary.addEntry(new DictionaryEntry("hi", "hello"));
        dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore"));
        dictionary.addEntry(new DictionaryEntry("abc", "hello"));
     
        
        List<DictionaryEntry> sortedList = dictionary.getSortedList();
        List<DictionaryEntry> expectedList = new ArrayList<DictionaryEntry>();
        expectedList.add(new DictionaryEntry("abc", "hello"));
        expectedList.add(new DictionaryEntry("good", "a"));
        expectedList.add(new DictionaryEntry("hi", "hello"));
        expectedList.add(new DictionaryEntry("hire", "c"));
        expectedList.add(new DictionaryEntry("prakalpa", "rathore"));
        expectedList.add(new DictionaryEntry("rat", "b"));
        
        for(int i = 0; i < sortedList.size(); i++)
            assertEquals(expectedList.get(i).getKey(), sortedList.get(i).getKey());
        
        
        dictionary.deleteEntry("good"); 
        dictionary.deleteEntry("hire");
        
        sortedList = dictionary.getSortedList();  //sorted list after deleting some of the entries
        expectedList.remove(1);
        expectedList.remove(2);
        
        for(int i = 0; i < sortedList.size(); i++) 
            assertEquals(expectedList.get(i).getKey(), sortedList.get(i).getKey());
    }
    
    
    /**
     * test case to get entries in sorted form between key1 and key2
     */
    @Test
    public void sortedListTest2() {
        
        Dictionary dictionary = new BSTDictionary("D:\\eclipse workspace\\DSAssignment#5\\test.json");
        dictionary.addEntry(new DictionaryEntry("hi", "hello"));
        dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore"));
        dictionary.addEntry(new DictionaryEntry("abc", "hello"));
        
        List<DictionaryEntry> sortedList = dictionary.getSortedList("a", "r");
        List<DictionaryEntry> expectedList = new ArrayList<DictionaryEntry>();
        expectedList.add(new DictionaryEntry("abc", "hello"));
        expectedList.add(new DictionaryEntry("good", "a"));
        expectedList.add(new DictionaryEntry("hi", "hello"));
        expectedList.add(new DictionaryEntry("hire", "c"));
        expectedList.add(new DictionaryEntry("prakalpa", "rathore"));        
        
        for(int i = 0; i < sortedList.size(); i++)
            assertEquals(expectedList.get(i).getKey(), sortedList.get(i).getKey());
    }
        
}
    
