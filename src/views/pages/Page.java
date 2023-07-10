package src.views.pages;

/** Интерфейс меню */
public interface Page {
    /** выполнение действия */
    void execute(int index);
    /** размер меню */
    int size();
    /** строковое представление */
    String toString();   
}
