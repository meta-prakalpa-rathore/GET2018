package jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCTest {

    /**
     * test case for insertImages
     */
    @Test
    public void insertImagesTest() 
    {        
        List<Image> images = new ArrayList<Image>();
        images.add(new Image("iPhone-8 image 1", "image.com/id201"));
        images.add(new Image("iPhone-8 image 2", "image.com/id202"));
        images.add(new Image("iPhone-8 image 3", "image.com/id203"));
        images.add(new Image("iPhone-8 image 4", "image.com/id204"));
        images.add(new Image("iPhone-8 image 5", "image.com/id205"));
        
        assertTrue(DataAccessObject.insertImages(images, 11));
    }
    
    
    /**
     * test case for markInactive
     */
    @Test
    public void markInactiveTest()
    {        
        assertEquals(6, DataAccessObject.markInactive());
    }
    
    
    /**
     * test case for fetchOrderLineItems
     */
    @Test
    public void fetchOrderLineItemsTest()
    {
        List<OrderLineItem> result = DataAccessObject.fetchOrderLineItems(3);
        List<OrderLineItem> expected = new ArrayList<OrderLineItem>();
        expected.add(new OrderLineItem(2, 6, "2018-07-04", 1080.00f));
        
        assertEquals(expected.size(), result.size());
        
        for(OrderLineItem item: result)
            System.out.println(item);
    }
    
    
    /**
     * test case for countChildren
     */
    @Test
    public void countChildrenTest()
    {
        List<TopCategory> result = DataAccessObject.countChildren();
        List<TopCategory> expected = new ArrayList<TopCategory>();
        expected.add(new TopCategory("Electronics", 4));
        expected.add(new TopCategory("Fashion", 4));
        expected.add(new TopCategory("Sports", 2));
        
        assertEquals(expected.size(), result.size());
        
        for(TopCategory category: result)
            System.out.println(category);
    }
}
