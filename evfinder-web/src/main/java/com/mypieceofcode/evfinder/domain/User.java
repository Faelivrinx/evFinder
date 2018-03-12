package com.mypieceofcode.evfinder.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

    public User(User user) {
        this(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRoles());
    }

    public User(String id, String username, String password, String email, List<String> roles){
        this.id = id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.roles = roles;
    }

    @Id
    private String id;
    private String username;

    private String password;

    @Email
    private String email;

    @Builder.Default()
    private boolean active = true;

    @Builder.Default()
    private List<String> roles = new ArrayList<>();

}