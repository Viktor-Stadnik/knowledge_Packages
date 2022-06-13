package packages.dao;

import java.util.List;
import java.util.Optional;
import packages.model.Kpac;

public interface KpacDao {
    Kpac create(Kpac kpac);

    Optional<Kpac> get(Long id);

    List<Kpac> getAll();

    Kpac update(Kpac kpac);

    void delete(Long id);
}
