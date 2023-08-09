package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.model.filme.DadosCadastroFilme;
import br.com.alura.screenmatch.model.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    @GetMapping
    public String carregaPaginaListagem (Model model){

        model.addAttribute("lista", filmes);

        return "filmes/listagem";
    }

    @GetMapping("/formulario")
    public String carregaPaginaFormulario (){
              return "filmes/formulario";
      }

      @PostMapping
      public String cadastraFilme (DadosCadastroFilme dados){
//          System.out.println(dados);
          //crio um objeto filme para preencher
          var filme = new Filme(dados);
          filmes.add(filme);

          return "redirect:/filmes";
      }


}
