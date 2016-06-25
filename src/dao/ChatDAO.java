package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Chat;
import util.JPAUtil;

public class ChatDAO {
	
	public boolean salva(Chat chat) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(chat);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Chat> recuperaTodos() {
		List<Chat> chats = new ArrayList<Chat>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Chat");
			chats = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chats;
	}

}
