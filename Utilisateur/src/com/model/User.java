/**
 * 
 */
package com.model;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class User {

	int idu;
	String nom,prenom;
	public int getIdu() {
		return idu;
	}
	public void setIdu(int idu) {
		this.idu = idu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public User(int idu, String nom, String prenom) {
		super();
		this.idu = idu;
		this.nom = nom;
		this.prenom = prenom;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [idu=" + idu + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}
