package com.histudio.entities;

public class ListElement {

	private Element element;

	private ListElement previous;

	private ListElement next;

	public ListElement(Element element, ListElement previous, ListElement next) {
		this.element = element;
		this.previous = previous;
		this.next = next;

	}

	public Element getElement() {
		return this.element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public String getKey() {
		return this.element.getKey();
	}

	public ListElement getPrevious() {
		return this.previous;
	}

	public void setPrevious(ListElement previous) {
		this.previous = previous;
	}

	public ListElement getNext() {
		return this.next;
	}

	public void setNext(ListElement next) {
		this.next = next;
	}

}
