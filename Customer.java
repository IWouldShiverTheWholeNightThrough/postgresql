package devoirpostgresql;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_id")
	private Store store;
	
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address; // plusieurs clients peuvent habiter au même endroit, si c'est une famille par exemple
	
	@Column(name = "activebool")
	private boolean activebool;
	@Column(name = "create_date")
	private Date create_date;
	@Column(name = "last_update")
	private Date last_update;
	@Column(name = "active")
	private int active;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Rental> rentals;
	
}
