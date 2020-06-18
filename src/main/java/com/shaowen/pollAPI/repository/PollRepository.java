package com.shaowen.pollAPI.repository;

import com.shaowen.pollAPI.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findByTitleContaining(String title);

    List<Poll> findByInitiator_NameContaining(String name);

    List<Poll> findByInitiatedAfter(Long initiated);
}
