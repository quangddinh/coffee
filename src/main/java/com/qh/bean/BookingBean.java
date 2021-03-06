package com.qh.bean;

import com.qh.pojo.Booking;
import com.qh.pojo.Capacity;
import com.qh.pojo.PaymentDetail;
import com.qh.pojo.TableSeat;
import com.qh.pojo.Timetable;
import com.qh.service.BookingService;
import com.qh.service.CapacityService;
import com.qh.service.PaymentService;
import com.qh.service.SelectService;
import com.qh.service.TabService;
import com.qh.service.TimetableService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

@ManagedBean
@Named(value = "bookingBean")
@RequestScoped
public class BookingBean implements Serializable {

    private final static CapacityService capService = new CapacityService();
    private final static TimetableService timeService = new TimetableService();
    private final static BookingService bookService = new BookingService();
    private final static SelectService selectSerice = new SelectService();
    private final static PaymentService payService = new PaymentService();
    private final static TabService tabService = new TabService();

    private int bookingId;
    private String name;
    private String phone;
    private Timetable time;
    private String description;
    private Capacity capacity;
    private Date date;
    private TableSeat tab;

    public BookingBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            String bookID = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("booking_id");

            if (bookID != null && !bookID.isEmpty()) {

                Booking p = bookService.getBookingyId(Integer.parseInt(bookID));
                this.bookingId = p.getId();
                this.name = p.getName();
                this.phone = p.getPhone();
                this.description = p.getDescription();
                this.capacity = p.getCapacity();
                this.time = p.getTimetable();
                this.date = p.getDate();
                this.tab = p.getTab();
            }
        }
    }

    public String addBooking() {
        Booking p;
        if (this.bookingId > 0) {
            p = bookService.getBookingyId(this.bookingId);
        } else {
            p = new Booking();
        }
        p.setName(this.name);
        p.setDescription(this.description);
        p.setCapacity(this.capacity);
        p.setTimetable(this.time);
        p.setDate(this.date);
        p.setPhone(this.phone);
        p.setTab(this.tab);

        if (bookService.addOrSaveBooking(p) == true) {
            return "reservations?faces-redirect=true";
        }
        return "form";
    }

    public String deleteBooking(Booking p) throws Exception {
        if (bookService.deleteBooking(p)) {
            return "successful";
        }
        throw new Exception("Sai roi");
    }

    public List<Booking> getBookings() {
        List<Booking> bookings = bookService.getBookings(null);
        return bookings;
    }

    public List<PaymentDetail> getPayment() {
        return payService.getPayments();
    }

    public List<Booking> getSelects() {
        List<Booking> selects = selectSerice.callStore();
        return selects;
    }

    public List<Capacity> getCapacities() {
        return capService.getCapacities();
    }

    public List<Timetable> getTimetable() {
        return timeService.getTimetable();
    }

    public List<TableSeat> getTabs() {
        return tabService.getTabs();
    }

    public void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Timetable getTime() {
        return time;
    }

    public void setTime(Timetable time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public TableSeat getTab() {
        return tab;
    }

    public void setTab(TableSeat tab) {
        this.tab = tab;
    }

}
