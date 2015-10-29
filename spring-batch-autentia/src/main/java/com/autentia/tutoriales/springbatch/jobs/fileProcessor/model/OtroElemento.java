package com.autentia.tutoriales.springbatch.jobs.fileProcessor.model;

import java.io.Serializable;

public class OtroElemento implements Serializable {

	//AnotherElement
    private static final long serialVersionUID = 269176933236284899L;

    private final String id;

    public OtroElemento(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OtroElemento)) return false;

        OtroElemento that = (OtroElemento) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AnotherElement{" +
                "id='" + id + '\'' +
                '}';
    }
}
