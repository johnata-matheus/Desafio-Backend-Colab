package br.com.colab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.colab.models.Champion;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long>{
}
