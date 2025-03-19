package com.voting.VotingApp.Controller;

import com.voting.VotingApp.DTO.Vote;
import com.voting.VotingApp.Entity.Poll;
import com.voting.VotingApp.Service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping("/create")
    public Poll createPol(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping("/get")
    public List<Poll> getAllPoll(){
        return pollService.getAllPolls();
    }

    @GetMapping("/get/{id}")
    public Poll getPollById(@PathVariable(name = "id") Long id){
        return pollService.getPollById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePollById(@PathVariable(name = "id") Long id){
        pollService.deleteByPollId(id);
    }


    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
        pollService.vote(vote.getPollId(),vote.getOptionIndex());
    }

    @PutMapping("/change/{id}")
    public Poll changePollById(@PathVariable(name = "id") Long id, @RequestBody Poll newpoll){
        return pollService.changePollById(id, newpoll);
    }
}
