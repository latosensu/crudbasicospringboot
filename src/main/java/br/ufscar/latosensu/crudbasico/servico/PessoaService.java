package br.ufscar.latosensu.crudbasico.servico;

import br.ufscar.latosensu.crudbasico.entidade.Pessoa;
import br.ufscar.latosensu.crudbasico.repositorio.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorio;

    public List<Pessoa> findAll() {
        return (List<Pessoa>)repositorio.findAll();
    }

    public Pessoa findOne(Long id) {
        return repositorio.findById(id).get();
    }

    public Pessoa save(Pessoa post) {
        return repositorio.saveAndFlush(post);
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }
}