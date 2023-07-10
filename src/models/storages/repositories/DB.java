package src.models.storages.repositories;

import src.models.items.ToyItem;
import src.models.storages.Storage;

public interface DB<T extends Storage<ToyItem>> {
    void save(Storage<ToyItem> storage);

    Storage<ToyItem> load();
}
