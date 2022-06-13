package packages.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import packages.dao.KpacSetDao;
import packages.exception.DataProcessingException;
import packages.model.KpacSet;

@Repository
public class KpacSetDaoImpl implements KpacSetDao {
    private final SessionFactory factory;

    public KpacSetDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public KpacSet create(KpacSet kpacSet) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(kpacSet);
            transaction.commit();
            return kpacSet;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't create KPacSet " + kpacSet, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<KpacSet> get(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(KpacSet.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get KPacSet, id: " + id, e);
        }
    }

    @Override
    public List<KpacSet> getAll() {
        try (Session session = factory.openSession()) {
            CriteriaQuery<KpacSet> query = session.getCriteriaBuilder()
                    .createQuery(KpacSet.class);
            query.from(KpacSet.class);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all KPacSets from db ", e);
        }
    }

    @Override
    public KpacSet update(KpacSet kpacSet) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(kpacSet);
            transaction.commit();
            return kpacSet;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update KPacSet " + kpacSet, e);
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
            KpacSet kpacSet = session.get(KpacSet.class, id);
            session.delete(kpacSet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete KPacSet with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
