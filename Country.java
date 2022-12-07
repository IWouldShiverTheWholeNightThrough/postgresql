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
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int id;
	@Column(name = "country")
	private String country;
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<City> cities;
}
