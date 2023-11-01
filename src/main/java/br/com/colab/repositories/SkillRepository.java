package br.com.colab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.colab.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
}
