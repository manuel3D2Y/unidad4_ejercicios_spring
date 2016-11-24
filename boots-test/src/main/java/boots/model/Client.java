package boots.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="client")
public class Client implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numMembership;
	@Column(name="name",length=50)
	private String name;
	@Column(name="telephone",length=50)
	private String telephone;
	@Column(name="address",length=50)
	private String address;

	
	public Client(String name, String telephone, String address) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.address = address;
	}


	public int getNumMembership() {
		return numMembership;
	}


	public void setNumMembership(int numMembership) {
		this.numMembership = numMembership;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Client [numMembership=" + numMembership + ", name=" + name + ", telephone=" + telephone + ", address="
				+ address + "]";
	}
	
	
	
}
