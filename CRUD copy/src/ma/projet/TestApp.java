package ma.projet;

import ma.projet.bean.Profile;
import ma.projet.bean.Utilisateur;
import ma.projet.service.ProfileService;
import ma.projet.service.UserService;

import java.util.List;

public class TestApp {
	public static void main(String[] args) {
		ProfileService ps = new ProfileService();
		UserService us = new UserService();

		// CREATE
		Profile mn = ps.create("MN", "Manager");
		Profile cp = ps.create("CP", "Chef de projet");
		us.create("youssef", "pwd1", mn);
		us.create("fatima", "pwd2", cp);
		us.create("omar", "pwd3", mn);

		// READ ALL
		System.out.println("Profils : " + ps.findAll());
		System.out.println("Users   : " + us.findAll());

		// UPDATE
		mn.setDescription("Manager confirmé");
		ps.update(mn);
		Utilisateur u2 = us.findById(2);
		/*
			if(u2 == null)
				System.out.println("id introuvable");
			else
			u2.setPassword("newPwd"); */
		us.update(u2);

		// DELETE
		us.delete(1); // supprime youssef
		ps.delete(cp.getId()); // supprime chef de projet

		// MÉTIER
		System.out.println("\nManagers :");
		List<Utilisateur> mgrs = us.findByProfile(mn);
		mgrs.forEach(System.out::println);
	}
}