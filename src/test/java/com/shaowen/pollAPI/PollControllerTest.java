package com.shaowen.pollAPI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.shaowen.pollAPI.controller.PollController;
import com.shaowen.pollAPI.domain.Initiator;
import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.service.PollService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PollController.class)
@ActiveProfiles("test")
public class PollControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PollService pollService;

  @Test
  public void givenPoll_whenListPoll_thenReturnJsonArray()
      throws Exception {

    Initiator initiator = new Initiator("John Doe");
    Poll poll = new Poll(
        "xsd4cv89t5f5um4b",
        1485521569056L,
        "Qui sont les superhéros Marvel les plus oufs?",
        initiator);

    List<Poll> pollList = Arrays.asList(poll);

    // mock output
    given(pollService.list()).willReturn(pollList);

    mvc.perform(get("/polls/list")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].title", is(poll.getTitle())));
  }

  @Test
  public void givenPoll_whenQueryTitle_thenReturnJsonArray()
      throws Exception {

    Initiator initiator = new Initiator("John Doe");
    Poll poll = new Poll(
        "xsd4cv89t5f5um4b",
        1485521569056L,
        "Qui",
        initiator);

    List<Poll> pollList = Arrays.asList(poll);

    // mock output
    given(pollService.findByTitleContaining("Qui")).willReturn(pollList);

    mvc.perform(get("/polls/title=Qui")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].title", is(poll.getTitle())));
  }

  @Test
  public void givenPoll_whenQueryName_thenReturnJsonArray()
      throws Exception {

    Initiator initiator = new Initiator("John Doe");
    Poll poll = new Poll(
        "xsd4cv89t5f5um4b",
        1485521569056L,
        "Qui",
        initiator);

    List<Poll> pollList = Arrays.asList(poll);

    // mock output
    given(pollService.findByInitiator_NameContaining("John")).willReturn(pollList);

    mvc.perform(get("/polls/user=John")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].initiator.name", is(poll.getInitiator().getName())));
  }

  @Test
  public void givenPoll_whenQueryDateAfter_thenReturnJsonArray()
      throws Exception {

    Initiator initiator = new Initiator("John Doe");
    Poll poll = new Poll(
        "xsd4cv89t5f5um4b",
        1485521569056L,
        "Qui",
        initiator);

    List<Poll> pollList = Arrays.asList(poll);
    Long date = 1485521569055L;

    // mock output
    given(pollService.findByInitiatedAfter(date)).willReturn(pollList);

    mvc.perform(get("/polls/dateAfter=1485521569055")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].initiated", is(poll.getInitiated())));
  }

}
