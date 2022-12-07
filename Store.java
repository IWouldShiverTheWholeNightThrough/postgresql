package devoirpostgresql;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne(mappedBy = "store", cascade= CascadeType.ALL) // pas besoin de mapper dans les deux sens ?
	private Staff staff;
	
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Inventory> inventories;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "inventory",
     joinColumns = @JoinColumn(name = "store_id"),
     inverseJoinColumns = @JoinColumn(name = "film_id"))
	private List<Film> films;
}
