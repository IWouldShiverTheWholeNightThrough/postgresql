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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	@Column(name = "address")
	private String address;
	@Column(name = "address2")
	private String address2;
	@Column(name = "district")
	private String district;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "postal_code")
	private String postal_code;
	@Column(name = "phone")
	private String phone;
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	@OneToOne(mappedBy = "address", cascade= CascadeType.ALL)
	private Staff staff;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private List<Store> stores;
	
}
