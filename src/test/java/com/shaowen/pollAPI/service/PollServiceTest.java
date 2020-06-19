package com.shaowen.pollAPI.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.shaowen.pollAPI.domain.Initiator;
import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.repository.PollRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = PollService.class)
public class PollServiceTest {

  @Autowired
  public PollService pollService;

  @MockBean
  public PollRepository pollRepository;

  @Before
  public void setUp() {

    Initiator initiator = new Initiator("John Doe");
    Poll poll = new Poll(
        "xsd4cv89t5f5um4b",
        1485521569056L,
        "Qui sont les superhéros Marvel les plus oufs?",
        initiator);

    List<Poll> pollList = Arrays.asList(poll);

    Mockito.when(pollRepository.findByInitiator_NameContaining(poll.getInitiator().getName()))
        .thenReturn(pollList);
  }

  @Test
  public void whenValidName_thenPollShouldBeFound() {
    String name = "John Doe";
    List<Poll> foundPoll = pollService.findByInitiator_NameContaining(name);

    assertThat(foundPoll.get(0).getInitiator().getName()).isEqualTo(name);
  }

}
