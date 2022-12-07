package devoirpostgresql;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private int id;
	
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
	private List<Rental> rentals;
	
}
