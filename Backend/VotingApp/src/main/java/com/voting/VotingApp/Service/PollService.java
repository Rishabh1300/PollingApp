package com.voting.VotingApp.Service;

import com.voting.VotingApp.Entity.OptionVote;
import com.voting.VotingApp.Entity.Poll;
import com.voting.VotingApp.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;


    public Poll createPoll(Poll poll){
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls(){
        return pollRepository.findAll();
    }

    public Poll getPollById(Long id){
        return pollRepository.findById(id).orElse(null);
    }

    public void deleteByPollId(Long id){
        pollRepository.deleteById(id);
    }

    public void vote(Long PollId, int optionIndex){

        //Get the particular Poll from DB
        Poll poll = pollRepository.findById(PollId).orElseThrow(()-> new RuntimeException("Poll not found"));

        //Get ALL the options related to that Poll
        List<OptionVote> options = poll.getOptions();


        if(optionIndex<0 || optionIndex>= options.size()){
            throw new IllegalArgumentException("Invalid Option Index");
        }

        //Get the selected option

        OptionVote selectedOption = options.get(optionIndex);


        //Increamenet the vote count
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);

        pollRepository.save(poll);


    }

}
