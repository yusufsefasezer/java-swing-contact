package com.yusufsezer.repository;

import com.yusufsezer.contracts.IRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectRepository<T, I extends Number> implements IRepository<T, I> {

	private List<T> contacts;
	private File file;
	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;

	public ObjectRepository(String source) throws ClassNotFoundException {

		try {
			file = new File(source);
			file.createNewFile();
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			contacts = (List<T>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
		} catch (IOException ex) {
			contacts = new ArrayList<>();
		} catch (ClassNotFoundException ex) {
			System.err.println(ex);
		}

	}

	@Override
	public T get(I index) {
		return this.contacts.get(index.intValue());
	}

	@Override
	public List<T> getAll() {
		return this.contacts;
	}

	@Override
	public boolean add(T obj) {
		return this.contacts.add(obj);
	}

	@Override
	public T update(I index, T obj) {
		return this.contacts.set(index.intValue(), obj);
	}

	@Override
	public T remove(I index) {
		return this.contacts.remove(index.intValue());
	}

	@Override
	public boolean save() {
		try {
			fileOutputStream = new FileOutputStream(file, false);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(contacts);
			fileOutputStream.close();
			objectOutputStream.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

}
