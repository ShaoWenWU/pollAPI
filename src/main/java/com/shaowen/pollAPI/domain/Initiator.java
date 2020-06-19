package com.shaowen.pollAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Initiator {

  private String name;
  private String email;
  private String notify;

  public Initiator() {
  }

  public Initiator(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
