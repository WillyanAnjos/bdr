package br.com.bdr.api.repositories;

import br.com.bdr.api.models.Infringement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfringementRepository extends JpaRepository<Infringement, Long> {
}
