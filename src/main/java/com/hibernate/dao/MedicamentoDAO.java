package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Medicamento;
import com.hibernate.util.HibernateUtil;

public class MedicamentoDAO {
	

	public void insertMed(Medicamento m) {
		Transaction transaction=null;
			try (Session session=HibernateUtil.getSessionFactory().openSession()) {
				transaction=session.beginTransaction();
				session.persist(m);
				transaction.commit();
			} catch (Exception e) {
				if (transaction!=null) {
					transaction.rollback();
				}
			}
		}
	
	public void deleteMed(int idMedicamentos) {
		Transaction transaction=null;
		Medicamento m=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			m=session.get(Medicamento.class, idMedicamentos);
			session.remove(m);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}
	
	public void updateMed(Medicamento m) {
		Transaction transaction=null;
			try (Session session=HibernateUtil.getSessionFactory().openSession()) {
				transaction=session.beginTransaction();
				session.merge(m);
				transaction.commit();
			} catch (Exception e) {
				if (transaction!=null) {
					transaction.rollback();
				}
			}
		}
	
	public static List<Medicamento> selectAllMed() {
		Transaction transaction=null;
		List<Medicamento> productos=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			productos=session.createQuery("FROM Medicamentos",Medicamento.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
		return productos;
	}

}
