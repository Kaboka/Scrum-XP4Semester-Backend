package WebServices;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "SUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findById", query = "SELECT s FROM Subject s WHERE s.id = :id"),
    @NamedQuery(name = "Subject.findByName", query = "SELECT s FROM Subject s WHERE s.name = :name")})
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "firstPrio1")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "firstPrio2")
    private Collection<Student> studentCollection1;
    @OneToMany(mappedBy = "secondPrio1")
    private Collection<Student> studentCollection2;
    @OneToMany(mappedBy = "secondPrio2")
    private Collection<Student> studentCollection3;

    public Subject() {
    }

    public Subject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection1() {
        return studentCollection1;
    }

    public void setStudentCollection1(Collection<Student> studentCollection1) {
        this.studentCollection1 = studentCollection1;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection2() {
        return studentCollection2;
    }

    public void setStudentCollection2(Collection<Student> studentCollection2) {
        this.studentCollection2 = studentCollection2;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection3() {
        return studentCollection3;
    }

    public void setStudentCollection3(Collection<Student> studentCollection3) {
        this.studentCollection3 = studentCollection3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServices.Subject[ id=" + id + " ]";
    }

}
