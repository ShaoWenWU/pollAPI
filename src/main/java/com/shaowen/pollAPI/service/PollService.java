package com.shaowen.pollAPI.service;

import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.repository.PollRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollService {

  @Autowired
  public PollRepository pollRepository;

  public PollService(PollRepository pollRepository) {
    this.pollRepository = pollRepository;
  }

  public PollService() {

  }

  public Iterable<Poll> list() {
    return pollRepository.findAll();
  }

  public Poll save(Poll poll) {
    return pollRepository.save(poll);
  }

  public void save(List<Poll> polls) {
    pollRepository.saveAll(polls);
  }

  public List<Poll> findByTitleContaining(String title) {
    return pollRepository.findByTitleContaining(title);
  }

  public List<Poll> findByInitiator_NameContaining(String name) {
    return pollRepository.findByInitiator_NameContaining(name);
  }

  public List<Poll> findByInitiatedAfter(Long initiated) {
    return pollRepository.findByInitiatedAfter(initiated);
  }
}
