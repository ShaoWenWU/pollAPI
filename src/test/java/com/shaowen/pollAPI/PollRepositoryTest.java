package com.shaowen.pollAPI;

import static org.assertj.core.api.Assertions.assertThat;

import com.shaowen.pollAPI.domain.Initiator;
import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.repository.PollRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
public class PollRepositoryTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private PollRepository pollRepository;

  @Before
  public void setUp() {
    // given
    Initiator initiator = new Initiator("John Doe");
    Poll poll = new Poll(
        "xsd4cv89t5f5um4b",
        1485521569056L,
        "Qui sont les superhéros Marvel les plus oufs?",
        initiator);

    testEntityManager.persist(poll);
    testEntityManager.flush();
  }

  @Test
  public void whenFindByInitiator_NameContaining_thenReturnInitiator() {
    Poll foundPoll = pollRepository.findByInitiator_NameContaining("John Doe").get(0);
    assertThat(foundPoll.getInitiator().getName()).isEqualTo("John Doe");
  }

  @Test
  public void whenFindByTitle_thenReturnTitle() {
    Poll foundPoll = pollRepository.findByTitleContaining("Qui sont les superhéros Marvel les plus oufs?").get(0);
    assertThat(foundPoll.getTitle()).isEqualTo("Qui sont les superhéros Marvel les plus oufs?");
  }

  @Test
  public void whenFindByInitiatedAfter_thenReturnPoll() {
    Poll foundPoll = pollRepository.findByInitiatedAfter(1485521569055L).get(0);
    assertThat(foundPoll.getTitle()).isEqualTo("Qui sont les superhéros Marvel les plus oufs?");
  }

}
