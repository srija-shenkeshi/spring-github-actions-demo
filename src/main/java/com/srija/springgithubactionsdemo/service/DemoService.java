package com.srija.springgithubactionsdemo.service;

import com.srija.springgithubactionsdemo.model.DB;
import com.srija.springgithubactionsdemo.model.GetResponse;
import com.srija.springgithubactionsdemo.model.Request;
import com.srija.springgithubactionsdemo.model.Response;
import com.srija.springgithubactionsdemo.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public Response createUserInDB(Request request) {
        String userId = UUID.randomUUID().toString(); //generating random UUID for userId
        DB db = new DB(userId, request.getUsername(), request.getPassword(), request.getEmail(), request.getAge(), request.getGender(),
                request.getOccupation(), LocalDateTime.now(), LocalDateTime.now());

        //saving to db
        DB savedResponse = createUser(db);
        log.info("Saved User Details: {}", savedResponse);
        return new Response(savedResponse.getUserId(), savedResponse.getUsername());
    }

    public DB createUser(DB db) {
        return demoRepository.save(db);
    }

    public GetResponse getUser(String username) {
        Optional<DB> dbResponse = demoRepository.findByUsername(username);
        if (dbResponse.isPresent()){
            DB response = dbResponse.get();
            return new GetResponse(response.getUserId(), response.getUsername(), response.getEmail(), response.getAge(),
                    response.getGender(), response.getOccupation());
        } else {
            log.info("null response from DB");
        }
        return null;
    }
}
