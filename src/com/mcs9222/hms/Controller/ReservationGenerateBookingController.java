/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Customer;
import com.mcs9222.hms.Entity.Orders;
import com.mcs9222.hms.Entity.Room;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author YEXIAO
 */
public class ReservationGenerateBookingController extends Controller {

    private JTextField reservationCustomerNameTextField;
    private JTextField reservationPhoneTextField;
    private JComboBox reservationMemberBox;
    private String roomNo;
    private Date startDate;
    private Date endDate;

    public ReservationGenerateBookingController(JTextField reservationCustomerNameTextField, JTextField reservationPhoneTextField, JComboBox reservationMemberBox, String RoomNo, Date startDate, Date endDate) {
        this.reservationCustomerNameTextField = reservationCustomerNameTextField;
        this.reservationPhoneTextField = reservationPhoneTextField;
        this.reservationMemberBox = reservationMemberBox;
        this.roomNo = RoomNo;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void generateBooking() {
        try {
            //get customer id
            Query q = em.createNamedQuery("Customer.findByPhone");
            q.setParameter("phone", this.reservationPhoneTextField.getText());
            Customer cResult;
            try {
                cResult = (Customer) q.getSingleResult();
                em.getTransaction().begin();
                cResult.setName(this.reservationCustomerNameTextField.getText());
                cResult.setPhone(this.reservationPhoneTextField.getText());
                cResult.setType((String) this.reservationMemberBox.getSelectedItem());
                em.persist(cResult);
                em.getTransaction().commit();
                em.refresh(cResult);
            } catch (NoResultException e) {
                //save customer
                em.getTransaction().begin();
                cResult = new Customer();
                cResult.setName(this.reservationCustomerNameTextField.getText());
                cResult.setPhone(this.reservationPhoneTextField.getText());
                cResult.setType((String) this.reservationMemberBox.getSelectedItem());
                em.persist(cResult);
                em.getTransaction().commit();
                em.refresh(cResult);
            }

            //get room
            q = em.createNamedQuery("Room.findByRoomNo");
            q.setParameter("roomNo", this.roomNo);
            Room rResult = (Room) q.getSingleResult();

            //generate order
            em.getTransaction().begin();
            Orders order = new Orders();
            order.setExpectedCheckinTime(this.startDate);
            order.setExpectedCheckoutTime(this.endDate);
            order.setCustomerId(cResult);
            order.setOrderStatus("Booked");
            order.setPaymentStatus("Unpaid");
            order.setRoomNo(rResult);
            Date date = new Date();
            order.setBookingTime(date);
            em.persist(order);
            em.getTransaction().commit();
            em.refresh(order);
            System.out.println("Order generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
