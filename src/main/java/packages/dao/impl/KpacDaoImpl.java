package packages.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import packages.dao.KpacDao;
import packages.exception.DataProcessingException;
import packages.model.Kpac;

@Repository
public class KpacDaoImpl implements KpacDao {
    private final SessionFactory factory;

    public KpacDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Kpac create(Kpac kpac) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(kpac);
            transaction.commit();
            return kpac;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't create KPac " + kpac, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Kpac> get(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(Kpac.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get KPac, id: " + id, e);
        }
    }

    @Override
    public List<Kpac> getAll() {
        try (Session session = factory.openSession()) {
            CriteriaQuery<Kpac> query = session.getCriteriaBuilder()
                    .createQuery(Kpac.class);
            query.from(Kpac.class);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all KPacs from db ", e);
        }
    }

    @Override
    public Kpac update(Kpac kpac) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(kpac);
            transaction.commit();
            return kpac;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update KPac " + kpac, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Kpac kpac = session.get(Kpac.class, id);
            session.delete(kpac);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete KPac with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
