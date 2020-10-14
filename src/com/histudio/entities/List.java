//Name: Luiz Gustavo Abou Hatem de Liz
package com.histudio.entities;

public class List implements ListInterface {

	private ListElement cursor = null, first = null, last = null;

	private int size = 0, max;

	public List(int max) {
		this.max = max;
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public int getMax() {
		return this.max;
	}
	
	@Override
	public void setMax(int max) {
		this.max = max;
	}

	private void cursorAdvancePositions(int n) {
		for (int i = 0; i < n; i++) {
			this.cursor = this.cursor.getNext();
		}
	}

	private void cursorGoBackPositions(int n) {
		for (int i = 0; i < n; i++) {
			this.cursor = this.cursor.getPrevious();
		}
	}

	private void cursorGoToLastPosition() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		this.cursor = last;
	}

	private void cursorGoToFirstPosition() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		this.cursor = first;
	}

	private void cursorAdvanceToKey(String key) throws Exception {
		cursorGoToLastPosition();
		do {
			cursorAdvancePositions(1);
			if (cursor.getKey() == key) {
				return;
			}
			if (cursor == last && cursor.getKey() != key) {
				break;
			}
		} while (cursor.getKey() != key);
		throw new Exception("Couldn't find the Element");
	}

	private void cursorAdvanceToIndex(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		if (index >= size) {
			throw new Exception("There's no such index");
		}
		if (index > size / 2) {
			cursorGoToLastPosition();
			index++;
			for (int i = size - index; i > 0; i--) {
				cursorGoBackPositions(1);
			}
			return;
		} else {
			cursorGoToFirstPosition();
			for (int i = index; i > 0; i--) {
				cursorAdvancePositions(1);
			}
			return;
		}
	}

	@Override
	public Element get(String key) throws Exception {
		cursorAdvanceToKey(key);
		return getCurrent();
	}

	@Override
	public Element getCurrent() {
		return cursor.getElement();
	}

	@Override
	public Element getByIndex(int index) throws Exception {
		cursorAdvanceToIndex(index);
		return getCurrent();
	}

	@Override
	public void insertBeforeCurrent(Element element) throws Exception {
		if (size == max) {
			throw new Exception("Full List");
		}
		if (cursor == first) {
			insertOnStart(element);
			return;
		}
		ListElement currentPrevious = cursor.getPrevious();
		ListElement newListElement = new ListElement(element, currentPrevious, cursor);
		currentPrevious.setNext(newListElement);
		cursor.setPrevious(newListElement);
		size++;
		cursor = newListElement;
	}

	@Override
	public void insertAfterCurrent(Element element) throws Exception {
		if (size == max) {
			throw new Exception("Full List");
		}
		if (cursor == last) {
			insertOnEnd(element);
			return;
		}
		ListElement currentNext = cursor.getNext();
		ListElement newListElement = new ListElement(element, currentNext, cursor);
		currentNext.setPrevious(newListElement);
		cursor.setNext(newListElement);
		size++;
		cursor = newListElement;
	}

	private void insertFirstElement(Element element) throws Exception {
		if (size == max) {
			throw new Exception("Full List");
		}
		ListElement firstElement = new ListElement(element, null, null);
		firstElement.setNext(firstElement);
		firstElement.setPrevious(firstElement);
		first = firstElement;
		last = firstElement;
		size++;
		cursorGoToFirstPosition();
	}

	@Override
	public void insertOnEnd(Element element) throws Exception {
		if (size == max) {
			throw new Exception("Full List");
		}
		if (isEmpty()) {
			insertFirstElement(element);
			return;
		}
		ListElement newListElement = new ListElement(element, last, first);
		first.setPrevious(newListElement);
		last.setNext(newListElement);
		last = newListElement;
		size++;
		cursorGoToLastPosition();
	}

	@Override
	public void insertOnStart(Element element) throws Exception {
		if (size == max) {
			throw new Exception("Full List");
		}
		if (isEmpty()) {
			insertFirstElement(element);
			return;
		}
		ListElement newListElement = new ListElement(element, last, first);
		first.setPrevious(newListElement);
		last.setNext(newListElement);
		first = newListElement;
		size++;
		cursorGoToFirstPosition();
	}

	@Override
	public void insertOnPosition(int pos, Element element) throws Exception {
		if (size == max) {
			throw new Exception("Full List");
		}
		if (pos > size || pos < 0) {
			throw new Exception("There's no such position");
		}
		if (pos == 0) {
			insertOnStart(element);
			return;
		}
		if (pos == size) {
			insertOnEnd(element);
			return;
		}
		cursorGoToFirstPosition();
		for (int i = pos; i > 0; i--) {
			cursorAdvancePositions(1);
		}
		insertBeforeCurrent(element);
	}

	@Override
	public void removeCurrent() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		if (cursor == last) {
			last = cursor.getPrevious();
		}
		ListElement previous = cursor.getPrevious();
		ListElement next = cursor.getNext();
		next.setPrevious(previous);
		previous.setNext(next);
		size--;
		if (cursor == first) {
			first = next;
			cursor = next;
			return;
		}
		cursor = previous;
	}

	@Override
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		try {
			cursorGoToFirstPosition();
			removeCurrent();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		try {
			cursorGoToLastPosition();
			removeCurrent();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void removeByKey(String key) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		cursorAdvanceToKey(key);
		removeCurrent();
	}

	@Override
	public void removeByIndex(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		cursorAdvanceToIndex(index);
		removeCurrent();
	}

	@Override
	public boolean isOnList(String key) {
		try {
			cursorAdvanceToKey(key);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (size == max) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(String name) throws Exception {
		cursorGoToFirstPosition();
		while (cursor.getElement().getName() != name) {
			cursorAdvancePositions(1);
			if (cursor == last && cursor.getElement().getName() != name) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int positionOf(String key) throws Exception {
		cursorGoToFirstPosition();
		int position = 0;
		while (cursor.getKey() != key) {
			cursorAdvancePositions(1);
			if (cursor == last && cursor.getKey() != key) {
				throw new Exception("Couldn't find element");
			}
			position++;
		}
		return position;
	}

}
