package WebServices;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByFullName", query = "SELECT s FROM Student s WHERE s.fullName = :fullName")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "FULL_NAME")
    private String fullName;
    @JoinColumn(name = "FIRST_PRIO_1", referencedColumnName = "ID")
    @ManyToOne
    private Subject firstPrio1;
    @JoinColumn(name = "FIRST_PRIO_2", referencedColumnName = "ID")
    @ManyToOne
    private Subject firstPrio2;
    @JoinColumn(name = "SECOND_PRIO_1", referencedColumnName = "ID")
    @ManyToOne
    private Subject secondPrio1;
    @JoinColumn(name = "SECOND_PRIO_2", referencedColumnName = "ID")
    @ManyToOne
    private Subject secondPrio2;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Subject getFirstPrio1() {
        return firstPrio1;
    }

    public void setFirstPrio1(Subject firstPrio1) {
        this.firstPrio1 = firstPrio1;
    }

    public Subject getFirstPrio2() {
        return firstPrio2;
    }

    public void setFirstPrio2(Subject firstPrio2) {
        this.firstPrio2 = firstPrio2;
    }

    public Subject getSecondPrio1() {
        return secondPrio1;
    }

    public void setSecondPrio1(Subject secondPrio1) {
        this.secondPrio1 = secondPrio1;
    }

    public Subject getSecondPrio2() {
        return secondPrio2;
    }

    public void setSecondPrio2(Subject secondPrio2) {
        this.secondPrio2 = secondPrio2;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServices.Student[ id=" + id + " ]";
    }

}
