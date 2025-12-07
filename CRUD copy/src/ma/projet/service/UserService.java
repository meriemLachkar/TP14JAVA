package ma.projet.service;

import ma.projet.bean.Utilisateur;
import ma.projet.bean.Profile;
import ma.projet.dao.Dao;
import ma.projet.dao.ListDao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service pour gérer les utilisateurs. Ajoute une méthode métier findByProfile.
 */
public class UserService {
	private final Dao<Utilisateur> dao = new ListDao<>();

	/** CREATE */
	public Utilisateur create(String login, String pwd, Profile profile) {
		Utilisateur u = new Utilisateur(login, pwd, profile);
		dao.create(u);
		return u;
	}

	/** UPDATE */
	public Utilisateur update(Utilisateur u) {
		return dao.update(u);
	}

	/** DELETE */
	public boolean delete(int id) {
		return dao.delete(id);
	}

	/** FIND BY ID */
	public Utilisateur findById(int id) {
		return dao.findById(id);
	}

	/** FIND ALL */
	public List<Utilisateur> findAll() {
		return dao.findAll();
	}

	/** Recherche métier : tous les utilisateurs d’un profil donné */
	public List<Utilisateur> findByProfile(Profile profile) {
		return dao.findAll().stream().filter(u -> u.getProfile().getId() == profile.getId())
				.collect(Collectors.toList());
	}
}