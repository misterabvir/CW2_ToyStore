package src.models.storages.repositories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import src.models.items.ToyItem;
import src.models.storages.Storage;

public class BinDB<T extends Storage<ToyItem>> implements DB<T> {

    private final String PATH = "storage.data";

    @Override
    public void save(Storage<ToyItem> storage) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(storage);
            fos.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Storage<ToyItem> load() {

        try {
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Storage<ToyItem> storage = (Storage<ToyItem>) ois.readObject();
            fis.close();
            return storage;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
