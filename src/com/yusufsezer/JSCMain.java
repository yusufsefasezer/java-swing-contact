package com.yusufsezer;

import com.yusufsezer.repository.ObjectRepository;
import com.yusufsezer.ui.JSCFrame;

public class JSCMain {

	public static void main(String[] args) {

		try {
			JSCFrame frame = new JSCFrame(new ObjectRepository<>("contacts.dat"));
			frame.setVisible(true);
		} catch (ClassNotFoundException ex) {
			System.err.println(ex);
		}

	}

}
