package com.yusufsezer.repository;

import com.yusufsezer.contact.IRepository;
import com.yusufsezer.contact.ISaveable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectRepository<T, I extends Number>
        implements IRepository<T, I>, ISaveable {

    private List<T> items;
    private File file;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    public ObjectRepository(String source) {
        try {
            file = new File(source);
            file.createNewFile();
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            items = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException ex) {
            items = new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public T get(I index) {
        return this.items.get(index.intValue());
    }

    @Override
    public List<T> getAll() {
        return this.items;
    }

    @Override
    public boolean add(T item) {
        return this.items.add(item);
    }

    @Override
    public T update(I index, T item) {
        return this.items.set(index.intValue(), item);
    }

    @Override
    public T remove(I index) {
        return this.items.remove(index.intValue());
    }

    @Override
    public boolean save() {
        try {
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(items);
            fileOutputStream.close();
            objectOutputStream.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
