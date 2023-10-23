package br.com.colab.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.colab.models.Champion;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, UUID>{
}
