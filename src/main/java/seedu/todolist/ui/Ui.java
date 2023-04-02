package seedu.todolist.ui;

import seedu.todolist.constants.Messages;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ui {
    private final Scanner input = new Scanner(System.in);

    public String getUserInput() {
        System.out.print("> ");
        return input.nextLine();
    }

    public void close() {
        input.close();
    }

    /**
     * Prints out the given strings with a newline separating them.
     *
     * @param strings The strings to print out.
     */
    private void println(String... strings) {
        System.out.println(Messages.LINE.getMessage());
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(Messages.LINE.getMessage());
    }

    /**
     * Generates a grammar-appropriate string based on the number of tasks in the task list,
     * such as "0 tasks", "1 task", "2 tasks".
     *
     * @param taskListSize The size of the task list.
     * @return The task count string.
     */
    private String generateTaskCountString(int taskListSize) {
        return taskListSize + " task" + (taskListSize == 1 ? "" : "s");
    }

    public void printWelcomeMessage() {
        println(Messages.START.getMessage());
    }

    public void printNewSaveMessage() {
        println(Messages.NEW_SAVE.getMessage());
    }

    public void printLoadSaveMessage(int taskListSize) {
        println(Messages.LOAD_SAVE.getMessage() + generateTaskCountString(taskListSize));
    }

    public void printGoodbyeMessage() {
        println(Messages.EXIT.getMessage());
    }

    public void printAddTaskMessage(String taskString) {
        println(Messages.ADD_TASK.getMessage(), taskString);
    }

    public void printMarkTaskMessage(String taskString) {
        println(Messages.MARK_TASK.getMessage(), taskString);
    }

    public void printUnmarkTaskMessage(String taskString) {
        println(Messages.UNMARK_TASK.getMessage(), taskString);
    }

    public void printDeleteTaskMessage(String taskString) {
        println(Messages.DELETE_TASK.getMessage(), taskString);
    }

    public void printEditTaskMessage(String parameterType, String newValue, String taskString) {
        println(String.format(Messages.EDIT_TASK.getMessage(), parameterType, newValue), taskString);
    }

    public void printEditDeleteTaskMessage(String parameterType, String taskString) {
        println(String.format(Messages.EDIT_DELETE_TASK.getMessage(), parameterType), taskString);
    }
        
    public void printCheckRepeatingTaskMessage() {
        println(Messages.CHECK_REPEATING.getMessage());
    }

    public void printTaskList(int taskListSize, String taskListString) {
        if (taskListSize == 0) {
            println(Messages.LIST_EMPTY.getMessage());
        } else {
            println(Messages.LIST_TASKS.getMessage() + generateTaskCountString(taskListSize),
                    taskListString);
        }
    }

    public void printGetFullInfoMessage(String infoString) {
        println(Messages.FULL_INFO.getMessage(), infoString);
    }

    public void printGetTagsMessage(int tagCount, String tagsString) {
        if (tagCount == 0) {
            println(Messages.TAGS_EMPTY.getMessage());
        } else {
            println(Messages.TAGS_INFO.getMessage(), tagsString);
        }
    }

    public void printError(Exception e) {
        println(e.getMessage());
    }

    //@@author jeromeongithub
    public void printProgressBar(int completedTasksThisWeek, int tasksThisWeek,
                                 int totalSections, String taskListString) {
        if (tasksThisWeek == 0) {
            println("You have no tasks due this week!");
            return;
        }

        assert tasksThisWeek != 0;
        double progress = (double) completedTasksThisWeek / tasksThisWeek;
        int completedSections = (int) (progress * totalSections);
        int incompleteSections = totalSections - completedSections;
        DecimalFormat twoDecimalPlaces = new DecimalFormat("0.00");
        String progressPercentage = twoDecimalPlaces.format(100 * progress);
        println("You have completed " + progressPercentage + "% of the " + generateTaskCountString(tasksThisWeek)
                + " due this week!", "Progress: |" + "=".repeat(completedSections)
                + "-".repeat(incompleteSections) + "|", taskListString);
    }
}
