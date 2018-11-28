package br.ufscar.latosensu.crudbasico.repositorio;

import br.ufscar.latosensu.crudbasico.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}