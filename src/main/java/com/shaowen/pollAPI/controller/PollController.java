package com.shaowen.pollAPI.controller;

import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    public PollController(PollService pollService){
        this.pollService = pollService;
    }

    @GetMapping("/list")
    public Iterable<Poll> list(){
        return pollService.list();
    }
}
