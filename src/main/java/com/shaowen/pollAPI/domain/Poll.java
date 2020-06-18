package com.shaowen.pollAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Poll {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
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

    public Poll(){}

}
