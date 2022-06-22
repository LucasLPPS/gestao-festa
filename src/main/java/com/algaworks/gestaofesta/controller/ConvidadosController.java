package com.algaworks.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.gestaofesta.model.Convidado;
import com.algaworks.gestaofesta.repository.Convidados;

@Controller // para dizer que o componente Spring é um controller
// @RequestMapping("/convidados") // as anotações @GetMapping e @PostMapping irão começar sempre com /convidados.
public class ConvidadosController {
 
    @Autowired // injeção do repository no Controller
    private Convidados convidados;

    // método que receberá a requisição e retornará o nome da view

    @GetMapping("/convidados")//URL para esse método ser chamado
    public ModelAndView listar(){
        // o construtor de ModelAndView recebe o nome da view:
        ModelAndView mv = new ModelAndView("listaConvidados");
        // e com o método addObject(), podemos adicionar objetos para a view:
        mv.addObject("convidados", convidados.findAll());
        // adicionando objeto do tipo Convidado no ModelAndView, que modela o formulário:
        mv.addObject("convidado", new Convidado());
        return mv;    
    }

    // -> método para receber requisição POST em /convidados
    // -> o método salvar() recebe como parâmetro um objeto do tipo Convidado. O Spring MVC 
    //    já vai criá-lo e definir os valores enviados pelo formulário neste objeto
    @PostMapping("/convidados")
    public String salvar(Convidado convidado){
        // comando para salvar os dados 
        this.convidados.save(convidado);
        return "redirect:/convidados";
    }
    /* 
    @RequestMapping("/excluir")
    public String excluir(Convidado convidado){
        // comando para deletar os dados 
        this.convidados.delete(convidado);
        return "redirect:/convidados";
    }
    */

    @GetMapping("/excluir")
	public String excluir(@RequestParam Long convidadoId) {
		convidados.deleteById(convidadoId);
		return "redirect:/convidados";
	}
}
