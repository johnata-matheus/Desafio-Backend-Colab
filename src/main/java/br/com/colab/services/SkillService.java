package br.com.colab.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.colab.dtos.SkillResponseDto;
import br.com.colab.dtos.request.SkillRequestDto;
import br.com.colab.models.Skill;
import br.com.colab.repositories.SkillRepository;

@Service
public class SkillService {
  
  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  ModelMapper modelMapper;

  public List<SkillResponseDto> getAllSkills(){
    List<Skill> skills = skillRepository.findAll();
    List<SkillResponseDto> skillDto = skills
      .stream().map(skill -> modelMapper.map(skill, SkillResponseDto.class)).collect(Collectors.toList());
    
    return skillDto;
  }

  public ResponseEntity<SkillResponseDto> getSkillById(Long id){
    Optional<Skill> skillId = skillRepository.findById(id);
    if(skillId.isPresent()){
      Skill skill = skillId.get();
      SkillResponseDto skillToDTO = modelMapper.map(skill, SkillResponseDto.class);
      return ResponseEntity.ok().body(skillToDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  } 

  public Skill createSkill(SkillRequestDto skillRequestDto){
    Skill skill = modelMapper.map(skillRequestDto, Skill.class);

    return skillRepository.save(skill);
  }

  public ResponseEntity<Skill> updateSkillById(SkillRequestDto skillRequestDto, Long id){
    Optional<Skill> skillId = skillRepository.findById(id);
    if(skillId.isPresent()){
      Skill skillToUpdate = skillId.get();
      modelMapper.map(skillRequestDto, skillToUpdate);
      Skill updateSkill = skillRepository.save(skillToUpdate);
      return ResponseEntity.ok().body(updateSkill);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<Object> deleteSkillById(Long id){
    return skillRepository.findById(id).map(taskToDelete -> {
      skillRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }).orElse(ResponseEntity.notFound().build());
  }


  
  
    

}
