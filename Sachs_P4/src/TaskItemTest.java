import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(InvalidtitleException.class, () -> new TaskItem("Title","Description","06-03-2001"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(InvalidtitleException.class, () -> new TaskItem("","Description","2001-06-03"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2001-06-03"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2001-06-03"));
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() throws InvaliddiscriptionException, InvaliddateException, InvalidtitleException {
        TaskItem task = new TaskItem("Title","Description","2001-06-03");
        //assertThrows();
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2001-06-03"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        //assertThrows(InvalidtitleException.class, () -> new TaskItem("Title","Description","21/-06-03"));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2001-06-03"));
    }
}