package corporate.basic.task.storage;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainerListTest {

    private final String firstElement = UUID.randomUUID().toString();
    private final String lastElement = UUID.randomUUID().toString();
    private final String middleElement = UUID.randomUUID().toString();
    private final String strToAdd = UUID.randomUUID().toString();
    private final String strToRemove = middleElement;
    private final int defaultSize = 3;
    private ContainerList<String> containerList;

    @Before
    public void init() {
        containerList = new ContainerList<>();
        containerList.add(firstElement);
        containerList.add(middleElement);
        containerList.add(lastElement);
    }


    @Test
    public void sizeTest() {
        Assert.assertEquals("Container list size: ", defaultSize, containerList.getSize());
    }

    @Test
    public void addTest() {
        containerList.add(strToAdd);

        Assert.assertEquals("Container list size: ", defaultSize + 1, containerList.getSize());
        Assert.assertEquals("Container list element: ", strToAdd, containerList.getLast());
    }

    @Test
    public void removeTest() {
        containerList.remove(strToRemove);

        Assert.assertEquals("Container list size: ", defaultSize - 1, containerList.getSize());
        Assert.assertFalse("Container list does not contains: " + strToRemove, containerList.contains(strToRemove));
    }

    @Test
    public void addNullTest() {
        containerList.add(null);

        Assert.assertEquals("Container list size: ", defaultSize, containerList.getSize());
    }


    @Test
    public void removeNullTest() {
        containerList.remove(null);

        Assert.assertEquals("Container list size: ", defaultSize, containerList.getSize());
    }

    @Test
    public void getFirstTest() {
        Assert.assertEquals("Container list first element: ", firstElement, containerList.getFirst());
    }

    @Test
    public void getLastTest() {
        Assert.assertEquals("Container list last element: ", lastElement, containerList.getLast());
    }

    @Test
    public void getByPositionTest() {
        Assert.assertEquals("Container list first element: ", firstElement, containerList.get(0));
        Assert.assertEquals("Container list middle element: ", middleElement, containerList.get(1));
        Assert.assertEquals("Container list last element: ", lastElement, containerList.get(2));
    }

    @Test
    public void removeAllTest() {
        containerList.remove(firstElement);
        containerList.remove(middleElement);
        containerList.remove(lastElement);

        Assert.assertEquals("Container list size: ", 0, containerList.getSize());
    }

    @Test
    public void setFirstTest() {
        containerList.setFirst(strToAdd);

        Assert.assertEquals("Element: " + strToAdd + " added", strToAdd, containerList.get(0));
    }

    @Test
    public void containsTest() {
        Assert.assertTrue("Container contains element: " + firstElement, containerList.contains(firstElement));
        Assert.assertTrue("Container contains element: " + middleElement, containerList.contains(middleElement));
        Assert.assertTrue("Container contains element: " + lastElement, containerList.contains(lastElement));
    }
}
