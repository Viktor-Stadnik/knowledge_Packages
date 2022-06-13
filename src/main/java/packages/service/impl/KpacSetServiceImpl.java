package packages.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import packages.dao.KpacSetDao;
import packages.model.Kpac;
import packages.model.KpacSet;
import packages.service.KpacSetService;

@Service
public class KpacSetServiceImpl implements KpacSetService {
    private final KpacSetDao kpacSetDao;

    public KpacSetServiceImpl(KpacSetDao kpacSetDao) {
        this.kpacSetDao = kpacSetDao;
    }

    public void addKPacToSet(Kpac kpac, KpacSet kpacSet) {
        kpacSet.getKPacs().add(kpac);
        kpacSetDao.update(kpacSet);
    }

    @Override
    public KpacSet create(KpacSet kpacSet) {
        return kpacSetDao.create(kpacSet);
    }

    @Override
    public KpacSet get(Long id) {
        return kpacSetDao.get(id).orElseThrow(
                () -> new RuntimeException("Can't get KPacSet by id: " + id));
    }

    @Override
    public List<KpacSet> getAll() {
        return kpacSetDao.getAll();
    }

    @Override
    public KpacSet update(KpacSet kpacSet) {
        return kpacSetDao.update(kpacSet);
    }

    @Override
    public void delete(Long id) {
        kpacSetDao.delete(id);
    }
}
