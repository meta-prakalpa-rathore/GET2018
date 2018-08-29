package nestedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class NestedListTest {

    /**
     * test cases for NestedListImplementation
     */
	@Test
	public void nestedListImplementationTest()
	{
		NestedList nestedList = new NestedListImplementation("test.json");
		
		assertEquals(207, nestedList.sumOfList()); //sum of list test
		assertEquals(99, nestedList.largestValue()); //largest value test
		assertTrue(nestedList.searchValue(99)); //positive test for search value
		assertFalse(nestedList.searchValue(12)); //negative test for search value
	}

	/**
	 * positive test case for getValue method of NestedListSearch
	 */
	@Test
	public void nestedListSearchTest1()
	{
		NestedListImplementation nestedList = new NestedListImplementation("test.json");
		NestedListSearch search = new NestedListSearch(nestedList);
		assertEquals(1, search.getValue("thh"));
	}
	
	
	/**
     * negative test case for getValue method of NestedListSearch when we get value while expecting list
     */
	@Test(expected = AssertionError.class)
    public void nestedListSearchTest2()
    {
        NestedListImplementation nestedList = new NestedListImplementation("test.json");
        NestedListSearch search = new NestedListSearch(nestedList);
        search.getValue("thht");
    }
	
	
	/**
     * negative test case for getValue method of NestedListSearch when we get list while expecting value
     */
	@Test(expected = AssertionError.class)
    public void nestedListSearchTest3()
    {
        NestedListImplementation nestedList = new NestedListImplementation("test.json");
        NestedListSearch search = new NestedListSearch(nestedList);
        search.getValue("tt");
    }
}
