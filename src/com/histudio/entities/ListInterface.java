package com.histudio.entities;

public interface ListInterface {

	//RETURNS SIZE
	public int getSize();
	
	//RETURNS MAX
	int getMax();

	//SET NEW MAX
	void setMax(int max);	
	
	//GET ELEMENT OF THE LIST USING ITS KEY
	public Element get(String key) throws Exception;
	
	//GET ELEMENT OF THE LIST USING POSITION(INDEX)
	public Element getByIndex(int index) throws Exception;
	
	//GET ELEMENT OF THE LIST THAT IS CURRENTLY APPOINTED BY THE CURSOR
	public Element getCurrent();
	
	//INSERT AN ELEMENT BEFORE THE CURSOR AND MOVES THE CURSOR TO THE ELEMENT INSERTED
	public void insertBeforeCurrent(Element element) throws Exception;
	
	//INSERT AN ELEMENT AFTER THE CURSOR AND MOVES THE CURSOR TO THE ELEMENT INSERTED
	public void insertAfterCurrent(Element element) throws Exception;
	
	//INSERT AN ELEMENT ON THE END AND MOVES THE CURSOR TO THE ELEMENT INSERTED
	public void insertOnEnd(Element element) throws Exception;
	
	//INSERT AN ELEMENT ON THE START AND MOVES THE CURSOR TO THE ELEMENT INSERTED
	public void insertOnStart(Element element) throws Exception;
	
	//INSERT AN ELEMENT ON THE POSITION AND MOVES THE CURSOR TO THE ELEMENT INSERTED
	public void insertOnPosition(int pos, Element element) throws Exception;
	
	//REMOVES THE ELEMENT APPOINTED BY THE CURSOR AND MOVES THE CURSOR TO THE ELEMENT BEFORE
	public void removeCurrent() throws Exception;
	
	//REMOVES THE FIRST ELEMENT AND MOVES THE CURSOR TO THE NEW FIRST
	public void removeFirst() throws Exception;
	
	//REMOVES THE LAST ELEMENT AND MOVES THE CURSOR TO THE ELEMENT BEFORE
	public void removeLast() throws Exception;
	
	//REMOVES ELEMENT USING ITS KEY AND MOVES THE CURSOR TO THE ELEMENT BEFORE
	public void removeByKey(String key) throws Exception;
	
	//REMOVES ELEMENT USING ITS INDEX AND MOVES THE CURSOR TO THE ELEMENT BEFORE
	public void removeByIndex(int index) throws Exception;
	
	//RETURNS true IF THE ELEMENT IS ON LIST AND false IF IT DOESN'T
	public boolean isOnList(String key);
	
	//RETURNS true IF THE LIST IS EMPTY AND false IF IT DOESN'T
	public boolean isEmpty();
	
	//RETURNS true IF THE LIST IS FULL AND false IF IT DOESN'T
	public boolean isFull();
	
	//RETURNS true IF THE ELEMENT IS ON LIST AND false IF IT DOESN'T
	public boolean contains(String name) throws Exception;
	
	//RETURNS POSITION(INDEX) OF THE ELEMENT WITH THIS KEY
	public int positionOf(String key) throws Exception;


}
