import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private City mockCity;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
        mockCity = new City("Edmonton", "AB");
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity)); // exists
        assertFalse(list.hasCity(new City("Calgary", "AB"))); // does not exist
    }

    @Test
    public void deleteCityTest(){
        // Add city and check that it is in there
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity));
        // Remove the city
        list.deleteCity(mockCity);
        assertFalse(list.hasCity(mockCity));
    }
}
