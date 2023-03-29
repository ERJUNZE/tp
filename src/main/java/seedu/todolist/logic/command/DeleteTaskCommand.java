//@@author RuiShengGit
package seedu.todolist.logic.command;

import seedu.todolist.constants.Flags;
import seedu.todolist.exception.InvalidIdException;
import seedu.todolist.logic.ParserUtil;
import seedu.todolist.ui.Ui;
import seedu.todolist.task.TaskList;

import java.util.HashMap;

public class DeleteTaskCommand extends Command {
    public static final Flags[] EXPECTED_FLAGS = {Flags.COMMAND_DELETE};

    private int id;

    public DeleteTaskCommand(HashMap<Flags, String> args) throws InvalidIdException {
        id = ParserUtil.parseId(args.get(Flags.COMMAND_DELETE));
        assert id >= 0: "Invalid id contained in variable";
    }

    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidIdException {
        String taskString = taskList.deleteTask(id);
        ui.printDeleteTaskMessage(taskString);
    }
}
