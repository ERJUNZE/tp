package seedu.duke.command;

import seedu.duke.Ui;
import seedu.duke.task.TaskList;

import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class EditDeadlineCommand extends Command  {
    public static final String KEYWORD = "editdeadline";
    public static final HashSet<String> FLAGS = new HashSet<>(Arrays.asList(KEYWORD, "-d"));
    public static int index;
    public static String deadline;


    public EditDeadlineCommand(String[] splitInput) throws NumberFormatException {
        try {
            HashMap<String, String> args = CommandParser.getArguments(splitInput, FLAGS);
            index = Integer.parseInt(args.get(KEYWORD)) - 1;
            deadline = CommandParser.formatDateTime(args.get("-d"));
        } catch (NumberFormatException e) {
            index = -1;
        }
    }
    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (deadline.isEmpty()) {
            ui.printDateTimeError();
        }
        else if (index == -1) {
            ui.printIndexError();
        }
        else {
            String taskItem = taskList.editDeadline(index, deadline);
            ui.printEditDeadlineNotification(taskItem);
        }

    }
}
