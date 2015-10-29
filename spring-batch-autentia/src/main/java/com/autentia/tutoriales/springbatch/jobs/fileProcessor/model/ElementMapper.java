package com.autentia.tutoriales.springbatch.jobs.fileProcessor.model;

import java.io.Serializable;

public class ElementMapper implements Serializable {
	
	//Element
	private static final long serialVersionUID = 141976950236790725L;

	private int id;

	private String text;

	public ElementMapper() {
		super();
	}

	public ElementMapper(int id, String text) {
		this();
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElementMapper)) return false;

        ElementMapper element = (ElementMapper) o;

        if (id != element.id) return false;
        if (text != null ? !text.equals(element.text) : element.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
