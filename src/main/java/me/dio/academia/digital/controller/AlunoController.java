package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.AlunoServiceImpl;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Aluno save(@Valid @RequestBody AlunoForm alunoForm) {
        return service.create(alunoForm);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> todasAvaliacoes(@PathVariable Long id) {
        return service.todasAvaliacoes(id);
    }

    @GetMapping("/pordata")
    public List<Aluno> getAlunoPorDataDeNascimento(@RequestParam(value = "dataNasc", required = false)
                                                       String dataDeNascimento) {
        return service.getAllPorDataDeNascimento(dataDeNascimento);
    }

    @GetMapping("/porbairro")
    public List<Aluno> getAllPorBairro(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAllPorBairro(bairro);
    }

    @GetMapping("/pornome")
    public List<Aluno> getAllPorNome(@RequestParam(value = "nome", required = false) String nome) {
        return service.getAllPorNome(nome);
    }
}
