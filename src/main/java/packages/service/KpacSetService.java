package packages.service;

import java.util.List;
import packages.model.KpacSet;

public interface KpacSetService {
    KpacSet create(KpacSet kpacSet);

    KpacSet get(Long id);

    List<KpacSet> getAll();

    KpacSet update(KpacSet kpacSet);

    void delete(Long id);
}
