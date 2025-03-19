package com.voting.VotingApp.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class OptionVote {
    private String optionText;
    private Long voteCount=0L;

    public OptionVote(){}

    public OptionVote(String optionText, Long voteCount) {
        this.optionText = optionText;
        this.voteCount = voteCount;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
