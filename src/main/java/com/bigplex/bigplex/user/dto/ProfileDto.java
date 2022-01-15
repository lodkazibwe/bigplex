package com.bigplex.bigplex.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private String userStatus;
    private int userId;
    private String userName;
    private String contact;
    private String name;
    private String image;
    private String password;
}
