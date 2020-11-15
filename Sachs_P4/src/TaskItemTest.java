import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(InvaliddateException.class, () -> new TaskItem("Title","Description","06-03-2001"));
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
        assertThrows(InvaliddateException.class, () -> task.setDate("20-06-03"));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() throws InvaliddiscriptionException, InvaliddateException, InvalidtitleException {
        TaskItem task = new TaskItem("Title","Description","2001-06-03");
        assertDoesNotThrow(() -> task.setDate("2006-06-03"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() throws InvaliddiscriptionException, InvaliddateException, InvalidtitleException {
        TaskItem task = new TaskItem("Title","Description","2001-06-03");
        assertThrows(InvalidtitleException.class, () -> task.settitle(""));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() throws InvaliddiscriptionException, InvaliddateException, InvalidtitleException {
        TaskItem task = new TaskItem("Title","Description","2001-06-03");
        assertDoesNotThrow(() -> task.settitle("new title"));
    }
}