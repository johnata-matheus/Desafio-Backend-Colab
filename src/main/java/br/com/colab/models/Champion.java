package br.com.colab.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_champion")
public class Champion {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private String name;
  private String description;
  private String class_champion;
  
  @CreationTimestamp
  private LocalDateTime createdAt;
}
