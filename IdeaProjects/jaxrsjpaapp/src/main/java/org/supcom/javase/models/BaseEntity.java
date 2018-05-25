package org.supcom.javase.models;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@MappedSuperclass
public  class BaseEntity<ID extends Serializable> implements Serializable{
    @Id
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?> that = (BaseEntity<?>) o;
        if(id == null || that.id==null){
            return false;
        }
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        if(id==null){
            return super.hashCode();
        }
        return id.hashCode();
    }

}