package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class User extends Entitie{

	private String lastName;
	private String firstName;
	private String email;
	private String pseudo;
	private String password;
	private LocalDateTime signInDate;
	private LocalDateTime lastConnectionDate;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@OneToOne (mappedBy = "user")  //car O ou 1 designer
	private Designer designer;
	
	@OneToMany (mappedBy = "user") 
	private Set<MCQpassed> MCQpasseds;

	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public LocalDateTime getSignInDate() {
		return signInDate;
	}
	public void setSignInDate(LocalDateTime signInDate) {
		this.signInDate = signInDate;
	}
	public LocalDateTime getLastConnectionDate() {
		return lastConnectionDate;
	}
	public void setLastConnectionDate(LocalDateTime lastConnectionDate) {
		this.lastConnectionDate = lastConnectionDate;
	}


	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", pseudo=" + pseudo
				+ ", signInDate=" + signInDate + ", lastConnectionDate=" + lastConnectionDate + ", designer=" + designer
				+ "]";
	}

	
	



	
	

}