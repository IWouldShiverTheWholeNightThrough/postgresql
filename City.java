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
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int id;
	@Column(name = "city")
	private String city;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<Address> addresses;
	
}
