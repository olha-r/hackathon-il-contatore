package co.simplon.hackatonilcontatore.entities;

import java.time.LocalDateTime;

import org.hibernate.proxy.HibernateProxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "order_number")
	private String orderNumber;
	@Column(name = "order_status")
	private String status;
	@JoinColumn(name = "pizza_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Pizza pizza;
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	@JsonIgnore
    private HibernateProxy hibernateLazyInitializer;
	
	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public HibernateProxy getHibernateLazyInitializer() {
		return hibernateLazyInitializer;
	}

	public void setHibernateLazyInitializer(HibernateProxy hibernateLazyInitializer) {
		this.hibernateLazyInitializer = hibernateLazyInitializer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", status=" + status + ", pizza=" + pizza
				+ ", dateTime=" + dateTime + ", hibernateLazyInitializer=" + hibernateLazyInitializer + "]";
	}
	
}
