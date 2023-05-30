import org.example.StringListImpl;
import org.example.StringList;
import org.example.exceptions.ElementNotFoundException;
import org.example.exceptions.NullElementException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {

    StringList myListForTest = new StringListImpl(10);

    public void addItemsToTestList(){
        myListForTest.add("January");   //0
        myListForTest.add("February");  //1
        myListForTest.add("March");     //2
        myListForTest.add("April");     //3
        myListForTest.add("April");     //4
        myListForTest.add("April");     //5
        myListForTest.add("May");       //6
        myListForTest.add("May");       //7
        myListForTest.add("June");      //8
        myListForTest.add("July");      //9
        myListForTest.add("August");    //10
        myListForTest.add("September"); //11
        myListForTest.add("October");   //12
        myListForTest.add("October");   //13
        myListForTest.add("November");  //14
        myListForTest.add("November");  //15
        myListForTest.add("November");  //16
        myListForTest.add("November");  //17
        myListForTest.add("December");  //18
        myListForTest.add("August");    //19
        myListForTest.add("January");   //20
    }

    //PositiveTests
    @Test
    public void checkAddNewItem(){
       String actualIndex0 = myListForTest.add("January");
       assertEquals("January",actualIndex0);
       assertEquals("January",myListForTest.get(0));

        String actualIndex1 = myListForTest.add("February");
        assertEquals("February",actualIndex1);
        assertEquals("February",myListForTest.get(1));

        String actualIndex2 = myListForTest.add("March");
        assertEquals("March",actualIndex2);
        assertEquals("March",myListForTest.get(2));

        String actualIndex3 = myListForTest.add("April");
        assertEquals("April",actualIndex3);
        assertEquals("April",myListForTest.get(3));

        String actualIndex4 = myListForTest.add("March");
        assertEquals("March",actualIndex4);
        assertEquals("March",myListForTest.get(4));

        String actualIndex5 = myListForTest.add("March");
        assertEquals("March",actualIndex5);
        assertEquals("March",myListForTest.get(5));

        String actualIndex6 = myListForTest.add("February");
        assertEquals("February",actualIndex6);
        assertEquals("February",myListForTest.get(6));
    }

    @Test
    public void checkAddNewItemByIndex(){
        String actualIndex0 = myListForTest.add(0,"January");
        assertEquals("January",actualIndex0);
        assertEquals("January",myListForTest.get(0));

        String actualIndex1 = myListForTest.add(1,"February");
        assertEquals("February",actualIndex1);
        assertEquals("February",myListForTest.get(1));

        String actualIndex2 = myListForTest.add(2,"March");
        assertEquals("March",actualIndex2);
        assertEquals("March",myListForTest.get(2));

        String actualIndex3 = myListForTest.add(3,"April");
        assertEquals("April",actualIndex3);
        assertEquals("April",myListForTest.get(3));

        String actualIndex4 = myListForTest.add(2,"March");
        assertEquals("March",actualIndex4);
        assertEquals("March",myListForTest.get(2));
        assertEquals("February",myListForTest.get(1));
        assertEquals("March",myListForTest.get(3));
        assertEquals("April",myListForTest.get(4));

        String actualIndex5 = myListForTest.add(5,"March");
        assertEquals("March",actualIndex5);
        assertEquals("March",myListForTest.get(5));

        String actualIndex6 = myListForTest.add(0,"February");
        assertEquals("February",actualIndex6);
        assertEquals("February",myListForTest.get(0));
        assertEquals("January",myListForTest.get(1));
        assertEquals("March",myListForTest.get(6));

        String actualIndex7 = myListForTest.add(99,"WorkDay");
        assertEquals("WorkDay",actualIndex7);
        assertEquals("WorkDay",myListForTest.get(7));

        String actualIndex8 = myListForTest.add(10,"August");
        assertEquals("August",actualIndex8);
        assertEquals("August",myListForTest.get(8));
    }

    @Test
    public void checkSetNewItem(){
        String actualIndex0 = myListForTest.set(0,"January");
        assertEquals("January",actualIndex0);
        assertEquals("January",myListForTest.get(0));

        String actualIndex1 = myListForTest.set(1,"February");
        assertEquals("February",actualIndex1);
        assertEquals("February",myListForTest.get(1));

        String actualIndex2 = myListForTest.set(2,"Martch");
        assertEquals("Martch",actualIndex2);
        assertEquals("Martch",myListForTest.get(2));

        String actualIndex3 = myListForTest.set(3,"April");
        assertEquals("April",actualIndex3);
        assertEquals("April",myListForTest.get(3));

        String actualIndex4 = myListForTest.set(2,"Marchh");
        assertEquals("Marchh",actualIndex4);
        assertEquals("Marchh",myListForTest.get(2));

        String actualIndex5 = myListForTest.set(5,"March");
        assertEquals("March",actualIndex5);
        assertEquals("March",myListForTest.get(4));

        String actualIndex6 = myListForTest.set(0,"February");
        assertEquals("February",actualIndex6);
        assertEquals("February",myListForTest.get(0));
        assertEquals("February",myListForTest.get(1));

        String actualIndex7 = myListForTest.set(99,"WorkDay");
        assertEquals("WorkDay",actualIndex7);
        assertEquals("WorkDay",myListForTest.get(5));

        String actualIndex8 = myListForTest.set(9,"August");
        assertEquals("August",actualIndex8);
        assertEquals("August",myListForTest.get(6));
    }

    @Test
    public void checkRemoveItem(){
        myListForTest.add("January");
        myListForTest.add("February");
        myListForTest.add("March");
        myListForTest.add("April");
        myListForTest.add("May");
        myListForTest.add("June");
        myListForTest.add("July");

        //remove the first element
        assertEquals("January",myListForTest.remove("January"));

        assertEquals("February",myListForTest.get(0));
        assertEquals("March",myListForTest.get(1));
        assertEquals("April",myListForTest.get(2));
        assertEquals("May",myListForTest.get(3));
        assertEquals("June",myListForTest.get(4));
        assertEquals("July",myListForTest.get(5));

        //remove an element in the middle
        assertEquals("April",myListForTest.remove("April"));

        assertEquals("February",myListForTest.get(0));
        assertEquals("March",myListForTest.get(1));
        assertEquals("May",myListForTest.get(2));
        assertEquals("June",myListForTest.get(3));
        assertEquals("July",myListForTest.get(4));

        //remove the last element
        assertEquals("July",myListForTest.remove("July"));

        assertEquals("February",myListForTest.get(0));
        assertEquals("March",myListForTest.get(1));
        assertEquals("May",myListForTest.get(2));
        assertEquals("June",myListForTest.get(3));
    }

    @Test
    public void checkRemoveItemByIndex(){
        myListForTest.add("January");
        myListForTest.add("February");
        myListForTest.add("March");
        myListForTest.add("April");
        myListForTest.add("May");
        myListForTest.add("June");
        myListForTest.add("July");

        //remove the first element
        assertEquals("January",myListForTest.remove(0));

        assertEquals("February",myListForTest.get(0));
        assertEquals("March",myListForTest.get(1));
        assertEquals("April",myListForTest.get(2));
        assertEquals("May",myListForTest.get(3));
        assertEquals("June",myListForTest.get(4));
        assertEquals("July",myListForTest.get(5));

        //remove an element in the middle
        assertEquals("April",myListForTest.remove(2));

        assertEquals("February",myListForTest.get(0));
        assertEquals("March",myListForTest.get(1));
        assertEquals("May",myListForTest.get(2));
        assertEquals("June",myListForTest.get(3));
        assertEquals("July",myListForTest.get(4));

        //remove the last element
        assertEquals("July",myListForTest.remove(4));

        assertEquals("February",myListForTest.get(0));
        assertEquals("March",myListForTest.get(1));
        assertEquals("May",myListForTest.get(2));
        assertEquals("June",myListForTest.get(3));
    }

    @Test
    public void checkContainsElement(){
        addItemsToTestList();

        assertTrue(myListForTest.contains("January"));
        assertTrue(myListForTest.contains("April"));
        assertFalse(myListForTest.contains("Maie"));
        assertFalse(myListForTest.contains("January "));
        assertFalse(myListForTest.contains("Ja nuary"));
        assertFalse(myListForTest.contains("JaNuary"));
    }

    @Test
    public void checkIndexOfItem(){
        addItemsToTestList();
        assertEquals(-1,myListForTest.indexOf("Aprily"));
        assertEquals(0,myListForTest.indexOf("January"));
        assertEquals(6,myListForTest.indexOf("May"));
        assertEquals(-1,myListForTest.indexOf(""));
        assertEquals(-1,myListForTest.indexOf(" "));
    }

    @Test
    public void checkLastIndexOfItem(){
        addItemsToTestList();
        assertEquals(-1,myListForTest.lastIndexOf("Aprily"));
        assertEquals(20,myListForTest.lastIndexOf("January"));
        assertEquals(7,myListForTest.lastIndexOf("May"));
        assertEquals(-1,myListForTest.lastIndexOf(""));
        assertEquals(-1,myListForTest.lastIndexOf(" "));
    }

    @Test
    public void checkGetItem(){
        addItemsToTestList();
        assertEquals("January",myListForTest.get(0));
        assertEquals("May",myListForTest.get(7));
        assertEquals("January",myListForTest.get(20));
        assertEquals("February",myListForTest.get(1));
    }

    @Test
    public void checkIsEqualsLists(){
        addItemsToTestList();
        String[] arrayToCopy = Arrays.copyOf(myListForTest.toArray(), myListForTest.size());
        StringList newList = new StringListImpl(arrayToCopy);
        assertTrue(myListForTest.equals(newList));

        newList.remove(2);
        assertFalse(myListForTest.equals(newList));
    }

    @Test
    public void checkSize(){
        addItemsToTestList();
        assertEquals(21,myListForTest.size());

        myListForTest.remove(0);
        myListForTest.remove("April");
        assertEquals(19, myListForTest.size());
    }

    @Test
    public void checkListIsEmpty(){
        assertTrue(myListForTest.isEmpty());

        addItemsToTestList();
        assertFalse(myListForTest.isEmpty());
    }

    @Test
    public void checkClear(){
        addItemsToTestList();
        myListForTest.clear();
        assertEquals(0,myListForTest.size());
    }

    //NegativeTests
    @Test
    public void checkAddNullItem(){
        assertThrows(NullElementException.class,()->myListForTest.add(""));
        assertThrows(NullElementException.class,()->myListForTest.add(" "));
    }

    @Test
    public void checkAddItemByBadIndex(){
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.add(-100,"aaa"));
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.add(-1,"abc"));
    }

    @Test
    public void checkAddNullItemByIndex(){
        assertThrows(NullElementException.class,()->myListForTest.add(0,""));
        assertThrows(NullElementException.class,()->myListForTest.add(1," "));
    }

    @Test
    public void checkSetItemByBadIndex(){
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.set(-10,"aaa"));
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.set(-1,"abcd"));
    }

    @Test
    public void checkSetNullItemByIndex(){
        assertThrows(NullElementException.class,()->myListForTest.set(0,""));
        assertThrows(NullElementException.class,()->myListForTest.set(1," "));
    }

    @Test
    public void checkRemoveNullItem(){
        assertThrows(NullElementException.class,()->myListForTest.remove(" "));
        assertThrows(NullElementException.class,()->myListForTest.remove(""));
    }

    @Test
    public void checkRemoveNonExistingElement(){
        assertThrows(ElementNotFoundException.class,()->myListForTest.remove("JaJaJanuary"));
        assertThrows(ElementNotFoundException.class,()->myListForTest.remove("March "));
    }

    @Test
    public void checkRemoveItemByBadIndex(){
        myListForTest.add("January");
        myListForTest.add("February");
        myListForTest.add("March");

        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.remove(-100));
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.remove(-1));
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.remove(3));
    }

    @Test
    public void checkGetItemByBadIndex(){
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.get(-1));
        assertThrows(IndexOutOfBoundsException.class,()->myListForTest.get(21));
    }

    @Test
    public void checkIsEqualsListsIfNull(){
        assertThrows(NullElementException.class, ()->myListForTest.equals(null));
    }
}
