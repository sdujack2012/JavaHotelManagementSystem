/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hz957
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByBookingTime", query = "SELECT o FROM Orders o WHERE o.bookingTime = :bookingTime"),
    @NamedQuery(name = "Orders.findByExpectedCheckinTime", query = "SELECT o FROM Orders o WHERE o.expectedCheckinTime = :expectedCheckinTime"),
    @NamedQuery(name = "Orders.findByActualCheckinTime", query = "SELECT o FROM Orders o WHERE o.actualCheckinTime = :actualCheckinTime"),
    @NamedQuery(name = "Orders.findByExpectedCheckoutTime", query = "SELECT o FROM Orders o WHERE o.expectedCheckoutTime = :expectedCheckoutTime"),
    @NamedQuery(name = "Orders.findByActualCheckoutTime", query = "SELECT o FROM Orders o WHERE o.actualCheckoutTime = :actualCheckoutTime"),
    @NamedQuery(name = "Orders.findByTotalPrice", query = "SELECT o FROM Orders o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "Orders.findByOccupantsNum", query = "SELECT o FROM Orders o WHERE o.occupantsNum = :occupantsNum"),
    @NamedQuery(name = "Orders.findByOrderStatus", query = "SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus"),
    @NamedQuery(name = "Orders.findByPaymentStatus", query = "SELECT o FROM Orders o WHERE o.paymentStatus = :paymentStatus"),
    @NamedQuery(name = "Orders.findByPaymentType", query = "SELECT o FROM Orders o WHERE o.paymentType = :paymentType"),
    @NamedQuery(name = "Orders.findByPayerName", query = "SELECT o FROM Orders o WHERE o.payerName = :payerName"),
    @NamedQuery(name = "Orders.findByPayerAddress", query = "SELECT o FROM Orders o WHERE o.payerAddress = :payerAddress"),
    @NamedQuery(name = "Orders.findByPayerCcard", query = "SELECT o FROM Orders o WHERE o.payerCcard = :payerCcard"),
    @NamedQuery(name = "Orders.findByPayerCcardType", query = "SELECT o FROM Orders o WHERE o.payerCcardType = :payerCcardType")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "booking_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingTime;
    @Column(name = "expected_checkin_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedCheckinTime;
    @Column(name = "actual_checkin_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualCheckinTime;
    @Column(name = "expected_checkout_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedCheckoutTime;
    @Column(name = "actual_checkout_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualCheckoutTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "occupants_num")
    private Integer occupantsNum;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "payer_name")
    private String payerName;
    @Column(name = "payer_address")
    private String payerAddress;
    @Column(name = "payer_ccard")
    private String payerCcard;
    @Column(name = "payer_ccard_type")
    private String payerCcardType;
    @OneToMany(mappedBy = "oid")
    private Collection<Service> serviceCollection;
    @JoinColumn(name = "room_no", referencedColumnName = "room_no")
    @ManyToOne
    private Room roomNo;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer customerId;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getExpectedCheckinTime() {
        return expectedCheckinTime;
    }

    public void setExpectedCheckinTime(Date expectedCheckinTime) {
        this.expectedCheckinTime = expectedCheckinTime;
    }

    public Date getActualCheckinTime() {
        return actualCheckinTime;
    }

    public void setActualCheckinTime(Date actualCheckinTime) {
        this.actualCheckinTime = actualCheckinTime;
    }

    public Date getExpectedCheckoutTime() {
        return expectedCheckoutTime;
    }

    public void setExpectedCheckoutTime(Date expectedCheckoutTime) {
        this.expectedCheckoutTime = expectedCheckoutTime;
    }

    public Date getActualCheckoutTime() {
        return actualCheckoutTime;
    }

    public void setActualCheckoutTime(Date actualCheckoutTime) {
        this.actualCheckoutTime = actualCheckoutTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOccupantsNum() {
        return occupantsNum;
    }

    public void setOccupantsNum(Integer occupantsNum) {
        this.occupantsNum = occupantsNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAddress() {
        return payerAddress;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public String getPayerCcard() {
        return payerCcard;
    }

    public void setPayerCcard(String payerCcard) {
        this.payerCcard = payerCcard;
    }

    public String getPayerCcardType() {
        return payerCcardType;
    }

    public void setPayerCcardType(String payerCcardType) {
        this.payerCcardType = payerCcardType;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    public Room getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Room roomNo) {
        this.roomNo = roomNo;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcs9222.hms.Entity.Orders[ id=" + id + " ]";
    }
    
}
