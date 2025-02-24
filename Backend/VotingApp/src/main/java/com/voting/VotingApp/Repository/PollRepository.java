package com.voting.VotingApp.Repository;

import com.voting.VotingApp.Entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll,Long> {

}
