package org.example.services;

import org.example.dto.VoteDTO;
import org.example.services.api.IVoteService;

import java.util.HashMap;
import java.util.Map;

public class VoteService implements IVoteService {

    private final static VoteService instance = new VoteService();
    private Map<String, Integer> artist = new HashMap<>();

    private VoteService() {
    }

    @Override
    public void create(VoteDTO vote) {
        artist.compute(vote.getArtist(), (k,v) ->{
            if(v == null){
                return 1;
            }
            return v + 1;
        });
    }

    public static VoteService getInstance(){
        return instance;
    }
}
