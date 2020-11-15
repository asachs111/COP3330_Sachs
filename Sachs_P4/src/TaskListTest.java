import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @BeforeEach
    @Test
    public void addingTaskItemsIncreasesSize(){}
    @Test
    public void completingTaskItemChangesStatus(){}
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){}
    @Test
    public void editingTaskItemChangesValues(){}
    @Test
    public void editingTaskItemDescriptionChangesValue(){}
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){}
    @Test
    public void editingTaskItemDueDateChangesValue(){}
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){}
    @Test
    public void editingTaskItemTitleChangesValue(){}
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){}
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){}
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){}
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){}
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){}
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){}
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){}
    @Test
    public void newTaskListIsEmpty(){
        TaskList taskList = new TaskList();
        assertEquals(0,taskList.size());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title","Description","2001-06-03"));
        int presize = taskList.size();
        taskList.remove(0);
        assertTrue(presize > taskList.size());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){}
    @Test
    public void savedTaskListCanBeLoaded(){}
    @Test
    public void uncompletingTaskItemChangesStatus(){}
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){}


}