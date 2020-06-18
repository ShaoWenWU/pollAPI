package com.shaowen.pollAPI.service;

import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    public PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Iterable<Poll> list() {
        return pollRepository.findAll();
    }

    public Poll save(Poll poll) {
        return pollRepository.save(poll);
    }

    public void save(List<Poll> polls) {
        System.out.println(">>>"+polls);
        pollRepository.saveAll(polls);
    }

//    public PollService(){}
}
