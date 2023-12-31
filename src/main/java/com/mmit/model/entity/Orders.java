package com.mmit.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "costomer_id")
	private User customer;
	
	
	@OneToMany(mappedBy = "orders", cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	
	private String shippingName;
	private String shippingPhone;
	private String shippingEmail;
	private String shippingAddres;
	
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	
	@CreationTimestamp
	private LocalDateTime created_at;
	@UpdateTimestamp
	private LocalDateTime updated_at;
	
	public void addOrderItem(OrderItem item) {
		
		item.setOrders(this);
		items.add(item);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public String getShippingPhone() {
		return shippingPhone;
	}
	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}
	public String getShippingEmail() {
		return shippingEmail;
	}
	public void setShippingEmail(String shippingEmail) {
		this.shippingEmail = shippingEmail;
	}
	public String getShippingAddres() {
		return shippingAddres;
	}
	public void setShippingAddres(String shippingAddres) {
		this.shippingAddres = shippingAddres;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", items=" + items + ", shippingName=" + shippingName
				+ ", shippingPhone=" + shippingPhone + ", shippingEmail=" + shippingEmail + ", shippingAddres="
				+ shippingAddres + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}
	
	

	
	
	
	
}
