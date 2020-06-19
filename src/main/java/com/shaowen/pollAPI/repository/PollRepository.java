package com.shaowen.pollAPI.repository;

import com.shaowen.pollAPI.domain.Poll;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, String> {

  List<Poll> findByTitleContaining(String title);

  List<Poll> findByInitiator_NameContaining(String name);

  List<Poll> findByInitiatedAfter(Long initiated);
}
