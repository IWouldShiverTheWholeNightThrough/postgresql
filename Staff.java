package devoirpostgresql;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private int id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;	
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_id")
	private Store store;
	
	
	@Column(name = "active")
	private boolean active;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "last_update")
	private Date last_update;
	@Column(name = "picture")
	private File picture;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private List<Rental> rentals;
}
