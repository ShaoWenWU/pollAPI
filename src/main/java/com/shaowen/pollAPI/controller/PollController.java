package com.shaowen.pollAPI.controller;

import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    public PollController(PollService pollService){
        this.pollService = pollService;
    }

    // List all data in the database
    @GetMapping(path = "/list")
    public Iterable<Poll> list(){
        return pollService.list();
    }

    // Query title
    @GetMapping(path = "/title={_title}")
    public List<Poll> findByTitle(@PathVariable("_title") String _title){
        return pollService.findByTitleContaining(_title);
    }

    // Query user name
    @GetMapping(path = "/user={_name}")
    public List<Poll> findByName(@PathVariable("_name") String _name){
        return pollService.findByInitiator_NameContaining(_name);
    }

    // Query after initiated date
    @GetMapping(path = "/dateAfter={_initiated}")
    public List<Poll> findByName(@PathVariable("_initiated") Long _initiated){
        return pollService.findByInitiatedAfter(_initiated);
    }
}
