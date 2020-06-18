package com.shaowen.pollAPI.repository;

import com.shaowen.pollAPI.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface PollRepository extends CrudRepository<Poll, String> {
}
