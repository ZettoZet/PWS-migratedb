/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.teamdeltafoxtrot;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ToRo
 */
@Entity
@Table(name = "bookingtbl")
@NamedQueries({
    @NamedQuery(name = "Bookingtbl.findAll", query = "SELECT b FROM Bookingtbl b"),
    @NamedQuery(name = "Bookingtbl.findByBookI", query = "SELECT b FROM Bookingtbl b WHERE b.bookI = :bookI"),
    @NamedQuery(name = "Bookingtbl.findByBookDate", query = "SELECT b FROM Bookingtbl b WHERE b.bookDate = :bookDate"),
    @NamedQuery(name = "Bookingtbl.findByDuration", query = "SELECT b FROM Bookingtbl b WHERE b.duration = :duration"),
    @NamedQuery(name = "Bookingtbl.findByCost", query = "SELECT b FROM Bookingtbl b WHERE b.cost = :cost")})
public class Bookingtbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookI")
    private Integer bookI;
    @Basic(optional = false)
    @Column(name = "BookDate")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    @Basic(optional = false)
    @Column(name = "Duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "Cost")
    private int cost;
    @JoinColumn(name = "CustId", referencedColumnName = "CustId")
    @ManyToOne(optional = false)
    private Customertbl custId;
    @JoinColumn(name = "RId", referencedColumnName = "RId")
    @ManyToOne(optional = false)
    private Roomtbl rId;

    public Bookingtbl() {
    }

    public Bookingtbl(Integer bookI) {
        this.bookI = bookI;
    }

    public Bookingtbl(Integer bookI, Date bookDate, int duration, int cost) {
        this.bookI = bookI;
        this.bookDate = bookDate;
        this.duration = duration;
        this.cost = cost;
    }

    public Integer getBookI() {
        return bookI;
    }

    public void setBookI(Integer bookI) {
        this.bookI = bookI;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Customertbl getCustId() {
        return custId;
    }

    public void setCustId(Customertbl custId) {
        this.custId = custId;
    }

    public Roomtbl getRId() {
        return rId;
    }

    public void setRId(Roomtbl rId) {
        this.rId = rId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookI != null ? bookI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookingtbl)) {
            return false;
        }
        Bookingtbl other = (Bookingtbl) object;
        if ((this.bookI == null && other.bookI != null) || (this.bookI != null && !this.bookI.equals(other.bookI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.b.teamdeltafoxtrot.Bookingtbl[ bookI=" + bookI + " ]";
    }
    
}
