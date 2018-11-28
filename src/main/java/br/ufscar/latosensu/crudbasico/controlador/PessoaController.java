package br.ufscar.latosensu.crudbasico.controlador;

import br.ufscar.latosensu.crudbasico.entidade.Pessoa;
import br.ufscar.latosensu.crudbasico.servico.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/post");
        mv.addObject("posts", pessoaService.findAll());

        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Pessoa pessoa) {

        ModelAndView mv = new ModelAndView("/postAdd");
        mv.addObject("post", pessoa);

        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(pessoaService.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        pessoaService.delete(id);

        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {

        if(result.hasErrors()) {
            return add(pessoa);
        }

        pessoaService.save(pessoa);

        return findAll();
    }

}
