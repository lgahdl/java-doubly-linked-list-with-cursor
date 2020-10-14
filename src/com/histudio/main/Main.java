package com.histudio.main;

import com.histudio.entities.Element;
import com.histudio.entities.List;

public class Main {

	public static void main(String[] args) {

		try {
			List list = new List(6);
			Element element1 = new Element("1", "name1");
			Element element2 = new Element("2", "name2");
			Element element3 = new Element("3", "name3");
			Element element4 = new Element("4", "name4");
			Element element5 = new Element("5", "name5");
			Element element6 = new Element("6", "name6");
//			list.getByIndex(0); Throws "Empty List"
//			list.get("1"); Throws "Empty List"
//			list.insertOnPosition(4, element1); //Throw "There's no such position"
			list.insertOnPosition(0, element2); // [element2(cursor)]
			System.out.println("Expected name2 -> " + list.getCurrent().getName());
			list.insertAfterCurrent(element3);// [element2, element3(cursor)]
			System.out.println("Expected name3 -> " + list.getByIndex(1).getName());
			list.insertOnEnd(element3);// [element2,element3,element3(cursor)]
			System.out.println("Expected name3 -> " + list.getByIndex(2).getName());
			list.insertOnStart(element1);// [element1(cursor),element2,element3,element3]
			System.out.println("Expected name1 -> " + list.getByIndex(0).getName());
			list.removeByIndex(2); // Removes 3[element1,element2,element3(cursor)]
			System.out.println("Expected name3 -> " + list.getByIndex(2).getName());
			list.insertOnPosition(3, element5);// [element1,element2,element3,element5(cursor)]
			System.out.println("Expected name5 -> " + list.getCurrent().getName());
			list.insertBeforeCurrent(element4);// [element1,element2,element3,element4(cursor),element5]
			list.removeCurrent(); // [element1,element2,element3(cursor),element5]
			list.removeCurrent(); // [element1,element2(cursor),element5]
			list.removeCurrent();// [element1(cursor),element5]
			list.removeCurrent();// [element5(cursor)]
			System.out.println("Expected name5 -> " + list.getByIndex(0).getName());
			list.removeLast();// []
//			list.removeCurrent(); //Throws Empty List
			System.out.println("Expected true -> " + list.isEmpty());
			list.insertAfterCurrent(element2); // [element1(cursor)]
			list.insertBeforeCurrent(element1);
			list.insertOnEnd(element3);
			list.insertOnPosition(3, element4);
			list.insertOnEnd(element6);
			list.insertBeforeCurrent(element5);
//			list.insertOnEnd(element1); Throws "Full List"
			System.out.println("Final Positions [" + list.getByIndex(0).getKey() + "," + list.getByIndex(1).getKey()
					+ "," + list.getByIndex(2).getKey() + "," + list.getByIndex(3).getKey() + ","
					+ list.getByIndex(4).getKey() + "," + list.getByIndex(5).getKey() + "]");
			System.out.println("Expected name1 -> " + list.getByIndex(0).getName());
			System.out.println("Expected name2 -> " + list.getByIndex(1).getName());
			System.out.println("Expected name3 -> " + list.getByIndex(2).getName());
			System.out.println("Expected name4 -> " + list.getByIndex(3).getName());
			System.out.println("Expected name5 -> " + list.getByIndex(4).getName());
			System.out.println("Expected name6 -> " + list.getByIndex(5).getName());
			System.out.println("Expected true -> " + list.isFull());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
