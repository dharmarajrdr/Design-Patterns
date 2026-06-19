
import java.util.Stack;

// interface = command
interface Command {
    void execute();
    void undo();
}

class Light {

    public void on() {
        System.out.println("Turned ON Light");
    }

    public void off() {
        System.out.println("Turned OFF Light");
    }
}

class Fan {

    public void on() {
        System.out.println("Turned ON Fan");
    }

    public void off() {
        System.out.println("Turned OFF Fan");
    }
}

class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

class FanOnCommand implements Command {

    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class FanOffCommand implements Command {

    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
    }
}

// history = invoker

class CommandExecutor {

    private Stack<Command> undohistory = new Stack<>();
    private Stack<Command> redoHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        undohistory.push(command);
        redoHistory.clear();
    }

    public void undoLastCommand() {
        if(!undohistory.isEmpty()) {
            Command command = undohistory.pop();
            command.undo();
            redoHistory.push(command);
        }
    }

    public void redoLastCommand() {
        if(!redoHistory.isEmpty()) {
            Command command = redoHistory.pop();
            command.execute();
            undohistory.push(command);
        }
    }

}

public class Solution {
    public static void main(String[] args) {
        
        CommandExecutor executor = new CommandExecutor();

        Light light = new Light();
        Fan fan = new Fan();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);

        executor.executeCommand(lightOn);   // Turned ON Light
        executor.executeCommand(fanOn);     // Turned ON Fan
        executor.executeCommand(lightOff);  // Turned OFF Light
        executor.undoLastCommand();      // Turned OFF Fan
        executor.undoLastCommand();      // Turned OFF Light
        executor.redoLastCommand();      // Turned ON Light
    }
}