package refactoring.guru.commands;

public interface Command {
    String getName();

    void execute();
}
