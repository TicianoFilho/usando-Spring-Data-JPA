package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

    public List<Aluno> findByBairro(String bairro);

    //Spring Data JPA won't read the method name in this case. It will read the HQL in @Query annotation
    @Query("from Aluno a where a.nome like %:meuNome%")
    List<Aluno> trazerNomeLike(String meuNome);
}
