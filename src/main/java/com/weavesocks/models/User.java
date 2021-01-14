package com.weavesocks.models;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class User {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
