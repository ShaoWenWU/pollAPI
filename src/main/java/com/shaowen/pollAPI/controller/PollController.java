package com.shaowen.pollAPI.controller;

import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.service.PollService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
@Api(tags = { "Poll Controller" })
public class PollController {

  @Autowired
  private final PollService pollService;

  public PollController(PollService pollService) {
    this.pollService = pollService;
  }

  // List all data in the database
  @GetMapping(path = "/list")
  @ApiOperation(value = "Poll list", response = Poll.class, tags = "Poll Controller")
  public Iterable<Poll> list() {
    return pollService.list();
  }

  // Query title
  @GetMapping(path = "/title={_title}")
  @ApiOperation(value = "Find all polls by title", response = Poll.class, tags = "Poll Controller")
  public List<Poll> findByTitle(@PathVariable("_title") String _title) {
    return pollService.findByTitleContaining(_title);
  }

  // Query user name
  @GetMapping(path = "/user={_name}")
  @ApiOperation(value = "Find all polls created by user name", response = Poll.class, tags = "Poll Controller")
  public List<Poll> findByName(@PathVariable("_name") String _name) {
    return pollService.findByInitiator_NameContaining(_name);
  }

  // Query after initiated date
  @GetMapping(path = "/dateAfter={_initiated}")
  @ApiOperation(value = "Find all polls created after a certain date", response = Poll.class, tags = "Poll Controller")
  public List<Poll> findByName(@PathVariable("_initiated") Long _initiated) {
    return pollService.findByInitiatedAfter(_initiated);
  }
}
