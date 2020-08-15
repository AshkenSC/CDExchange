package repository;

import entities.UserGroups;
import entities.Users;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import util.AuthenticationUtils;

@Stateless
public class UserEJB {
	
	@PersistenceContext(unitName="FIT5042Final-ejbPU")
	private EntityManager em;
	
	public Users createUser(Users user) {
		try {
			user.setPassword(AuthenticationUtils.encodeMD5(user.getPassword()));
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		UserGroups group = new UserGroups();
		group.setEmail(user.getEmail());
		group.setGroupname(UserGroups.USERS_GROUP);
		em.persist(user);
		em.persist(group);
		return user;
	}
	public Users findUserByEmail(String email) {
		TypedQuery<Users> query = em.createNamedQuery("findUserByEmail", Users.class);
		query.setParameter("email", email);
		Users user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			// getSingleResult throws NoResultException in case there is no user in DB
			// ignore exception and return NULL for user instead
		}
		return user;
	}
}
