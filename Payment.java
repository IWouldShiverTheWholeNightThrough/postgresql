package devoirpostgresql;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rental_id") // peut y avoir plusieurs paiements pour un rental ? (paiement en plusieurs fois par exemple ?)
	private Rental rental;	
	
	@Column(name = "amount")
	private double amount;
	@Column(name = "payment_date")
	private Date payment_date;
	
}
