package packages.service;

import java.util.List;
import packages.model.Kpac;

public interface KpacService {
    Kpac create(Kpac kpac);

    Kpac get(Long id);

    List<Kpac> getAll();

    Kpac update(Kpac kpac);

    void delete(Long id);
}
