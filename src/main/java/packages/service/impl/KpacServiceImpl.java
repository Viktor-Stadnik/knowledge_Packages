package packages.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import packages.dao.KpacDao;
import packages.model.Kpac;
import packages.service.KpacService;

@Service
public class KpacServiceImpl implements KpacService {
    private final KpacDao kpacDao;

    public KpacServiceImpl(KpacDao kpacDao) {
        this.kpacDao = kpacDao;
    }

    @Override
    public Kpac create(Kpac kpac) {
        return kpacDao.create(kpac);
    }

    @Override
    public Kpac get(Long id) {
        return kpacDao.get(id).orElseThrow(
                () -> new RuntimeException("Can't get KPac by id " + id));
    }

    @Override
    public List<Kpac> getAll() {
        return kpacDao.getAll();
    }

    @Override
    public Kpac update(Kpac kpac) {
        return kpacDao.update(kpac);
    }

    @Override
    public void delete(Long id) {
        kpacDao.delete(id);
    }
}
