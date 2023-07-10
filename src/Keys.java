package src;

public enum Keys {
    /** Цена за единицу */
    PRICE("price"),
    /** Полная цена */
    PRICE_TOTAL("price_total"),
    /** Цена со скидкой за единицу */
    SPECIAL("special"),
    /** Полная Цена со скидкой */
    SPECIAL_TOTAL("special_total"),
    /** Количество */
    AMOUNT("amount"),
    /** Наименование */
    TITLE("total"),
    /** Теги */
    TAGS("tags"),
    /** Скидка */
    DISCOUNT("discount"),
    /** Формат для вывода суммы */
    MONEY_FORMAT("$%.2f");

    /** Ключ */
    private final String key;

    Keys(String key) {
        this.key = key;
    }

    /** Получить ключ */
    public String getKey() {
        return key;
    }
}