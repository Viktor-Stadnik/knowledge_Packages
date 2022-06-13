package packages.dao;

import java.util.List;
import java.util.Optional;
import packages.model.KpacSet;

public interface KpacSetDao {
    KpacSet create(KpacSet kpacSet);

    Optional<KpacSet> get(Long id);

    List<KpacSet> getAll();

    KpacSet update(KpacSet kpacSet);

    void delete(Long id);
}
