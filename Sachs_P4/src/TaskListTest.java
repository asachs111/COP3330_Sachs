import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList taskList = new TaskList();
        int presize = taskList.size();
        taskList.add("Title","Description","2001-06-03");
        assertTrue(presize < taskList.size());
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.mark(0);
        assertTrue(taskList.get(0).getCompleted());
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.mark(5);
        assertFalse(taskList.get(0).getCompleted());
    }
    @Test
    public void editingTaskItemChangesValues(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("title2","description2","2006-06-03",0);
        assertFalse(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("Title","description2","2001-06-03",0);
        assertFalse(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("Title","Description","2006-06-03",3);
        assertTrue(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("Title","Description","2006-06-03",0);
        assertFalse(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("Title","Description","2006-06-03",3);
        assertTrue(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("title","Description","2001-06-03",0);
        assertFalse(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.edit("title","Description","2001-06-03",3);
        assertTrue(taskList.get(0).toString().equals(" ["+ (2001)+ "-" + (6) + "-" + 3 + "] " + "Title" + ": "+ "Description"));
    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.get(3).getDescription());
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        assertEquals( "Description", taskList.get(0).getDescription());
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
            TaskList taskList = new TaskList();
            taskList.add("Title","Description","2001-06-03");
            assertThrows(IndexOutOfBoundsException.class, () -> taskList.get(3).ezdate());
    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        assertEquals( "101 5 3", taskList.get(0).ezdate());
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.get(3).gettitle());
    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        assertEquals("Title" , taskList.get(0).gettitle());

    }
    @Test
    public void newTaskListIsEmpty(){
        TaskList taskList = new TaskList();
        assertEquals(0,taskList.size());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        int presize = taskList.size();
        taskList.remove(0);
        assertTrue(presize > taskList.size());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        assertDoesNotThrow(() ->taskList.remove(3));
    }
    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList taskList = new TaskList();
        assertDoesNotThrow(() ->taskList.inport("tasks.txt"));
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        taskList.mark(0);
        taskList.unmark(0);
        assertFalse(taskList.get(0).getCompleted());
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        taskList.add("Title","Description","2001-06-03");
        assertDoesNotThrow(() ->taskList.unmark(3));
    }


}