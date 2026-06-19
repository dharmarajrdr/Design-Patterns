
import java.util.Stack;

// command - interface with `execute` and `undo` methods
interface Command {

    void execute();
    void undo();
}

class TextEditor {

    public void bold() {
        System.out.println("Text is now bold");
    }

    public void undoBold() {
        System.out.println("Undo bold formatting");
    }
}

class BoldCommand implements Command {

    private TextEditor textEditor;

    public BoldCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void execute() {
        textEditor.bold();
    }

    public void undo() {
        textEditor.undoBold();
    }
}

// invoker - holds the history of commands and executes them
class CommandInvoker {

    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            redoHistory.push(lastCommand);
        }
    }

    public void redoLastCommand() {
        if(!redoHistory.isEmpty()) {
            Command lastCommand = redoHistory.pop();
            lastCommand.execute();
            commandHistory.push(lastCommand);
        }
    }
}

// Client
public class Solution {

    public static void main(String[] args) {
        
        TextEditor textEditor = new TextEditor();
        CommandInvoker commandInvoker = new CommandInvoker();

        // Execute the bold command
        commandInvoker.executeCommand(new BoldCommand(textEditor));
        commandInvoker.executeCommand(new BoldCommand(textEditor));
        commandInvoker.undoLastCommand();

    }
}