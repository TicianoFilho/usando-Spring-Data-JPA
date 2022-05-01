package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {

        Aluno aluno = new Aluno();

        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> todasAvaliacoes(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno.getAvaliacoes();
    }

    @Override
    public List<Aluno> getAllPorDataDeNascimento(String dataNasc) {

        if (dataNasc.isEmpty() || dataNasc == null) {
            return alunoRepository.findAll();
        } else {

            Locale localidade = new Locale("pt", "BR");
            LocalDate dataDeNasc = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyy", localidade));

            return alunoRepository.findByDataDeNascimento(dataDeNasc);
        }

    }

    @Override
    public List<Aluno> getAllPorBairro(String bairro) {
        return alunoRepository.findByBairro(bairro);
    }

    @Override
    public List<Aluno> getAllPorNome(String nome) {
        return alunoRepository.trazerNomeLike(nome);
    }
}
