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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "release_year")
	private int release_year;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "language_id")
	private Language language;
	
	
	@Column(name = "rental_duration")
	private int rental_duration;
	@Column(name = "rental_rate")
	private double rental_rate;
	@Column(name = "length")
	private int length;
	@Column(name = "replacement_cost")
	private double replacement_cost;
	@Column(name = "rating")
	private String rating;
	@Column(name = "last_update")
	private Date last_update;
	@Column(name = "special_features")
	private String[] special_features;
	@Column(name = "fulltext")
	private String fulltext; // pas le type le plus pertinent pour un tsvector ...
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "film_actor",
     joinColumns = @JoinColumn(name = "film_id"),
     inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "film_category",
     joinColumns = @JoinColumn(name = "film_id"),
     inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "inventory",
     joinColumns = @JoinColumn(name = "film_id"),
     inverseJoinColumns = @JoinColumn(name = "store_id"))
	private List<Store> stores;
	
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private List<Inventory> inventories;
}
