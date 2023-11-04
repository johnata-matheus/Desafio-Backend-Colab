package br.com.colab.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.colab.dtos.request.ChampionRequestDto;
import br.com.colab.dtos.response.ChampionResponseDto;
import br.com.colab.models.Champion;
import br.com.colab.repositories.ChampionRepository;

@Service
public class ChampionService {

  @Autowired
  private ChampionRepository championRepository;

  @Autowired
  ModelMapper modelMapper;

  public List<ChampionResponseDto> getAllChampions(){
    List<Champion> champions = championRepository.findAll();
    List<ChampionResponseDto> championDto = champions
      .stream().map(champion -> modelMapper.map(champion, ChampionResponseDto.class)).collect(Collectors.toList());
    return championDto;
  }

  public ResponseEntity<ChampionResponseDto> findChampionById(Long id){
    Optional<Champion> championId = championRepository.findById(id);
    if(championId.isPresent()){
      Champion champion = championId.get();
      ChampionResponseDto championToDTO = modelMapper.map(champion, ChampionResponseDto.class);
      return ResponseEntity.ok().body(championToDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public Champion createChampion(ChampionRequestDto championRequestDto){
    Champion champion = modelMapper.map(championRequestDto, Champion.class);

    return championRepository.save(champion);
  }

  public ResponseEntity<Champion> updateChampionById(ChampionRequestDto championRequestDto, Long id){
    Optional<Champion> championId = championRepository.findById(id);
    if(championId.isPresent()){
      Champion championToUpdate = championId.get();
      modelMapper.map(championRequestDto, championToUpdate);
      Champion updateChampion = championRepository.save(championToUpdate);
      return ResponseEntity.ok().body(updateChampion);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<Object> deleteChampionById(Long id){
    return championRepository.findById(id).map(championToDelete -> {
      championRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }).orElse(ResponseEntity.notFound().build());
  }

}

