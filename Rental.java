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
@Table(name = "rental")
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private int id;
	@Column(name = "rental_date")
	private Date rental_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id")
	private Inventory inventories;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	@Column(name = "return_date")
	private Date return_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	private List<Payment> payments;
}
