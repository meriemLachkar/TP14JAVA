package ma.projet.service;

import ma.projet.bean.Profile;
import ma.projet.dao.Dao;
import ma.projet.dao.ListDao;

import java.util.List;

/**
 * Service pour gérer les profils. Délègue la persistance à un Dao<Profile>, et
 * peut appliquer ici des règles métier si besoin.
 */
public class ProfileService {
	private final Dao<Profile> dao = new ListDao<>();

	/** CREATE : construction + persistance */
	public Profile create(String code, String desc) {
		Profile p = new Profile(code, desc);
		dao.create(p);
		return p;
	}

	/** UPDATE : modifie un profil existant */
	public Profile update(Profile p) {
		return dao.update(p);
	}

	/** DELETE : supprime par ID */
	public boolean delete(int id) {
		return dao.delete(id);
	}

	/** READ : recherche par ID */
	public Profile findById(int id) {
		return dao.findById(id);
	}

	/** READ ALL : liste tous les profils */
	public List<Profile> findAll() {
		return dao.findAll();
	}
}