package src.views.commands;

/** интерфейс для паттерна Команда */
public interface Command {
    /** Выполнить действие */
    void execute();
    /** строковое представление */
    String toString();
}
