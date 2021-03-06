package com.shaowen.pollAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "polls")
public class Poll {

  @Id
  private String id;
  private String adminKey;
  private Long latestChange;
  private Long initiated;
  private Integer participantsCount;
  private Integer inviteesCount;
  private String type;
  private String hidden;
  private String preferencesType;
  private String state;
  private String locale;
  private String title;

  @Embedded
  private Initiator initiator;

  public Poll() {
  }

  public Poll(String id, Long initiated, String title, Initiator initiator) {
    this.id = id;
    this.initiated = initiated;
    this.title = title;
    this.initiator = initiator;
  }

  public Initiator getInitiator() {
    return initiator;
  }

  public String getTitle() {
    return title;
  }

  public Long getInitiated() {
    return initiated;
  }
}
