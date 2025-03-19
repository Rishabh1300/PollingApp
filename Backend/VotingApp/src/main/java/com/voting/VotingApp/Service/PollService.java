package com.voting.VotingApp.Service;

import com.voting.VotingApp.DTO.Vote;
import com.voting.VotingApp.Entity.OptionVote;
import com.voting.VotingApp.Entity.Poll;
import com.voting.VotingApp.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Poll changePollById(Long id, Poll newpoll){
        Poll poll1 = pollRepository.findById(id).orElse(null);

        if(poll1!=null){
            poll1.setQuestion(newpoll.getQuestion());
            pollRepository.save(poll1);
        }
        return poll1;

    }

//    public Poll changeOptionById(Long pollId, Long optionId, Poll newpoll){
//        Poll poll2 = pollRepository.findById(pollId).orElse(null);
//        if(poll2!=null){
//            Optional<Vote> optionToEdit = poll2.getOptions().stream().filter(option -> option.g)
//        }
//    }
//

}
