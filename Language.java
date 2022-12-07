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
@Table(name = "language")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
	private List<Film> Films;
}
