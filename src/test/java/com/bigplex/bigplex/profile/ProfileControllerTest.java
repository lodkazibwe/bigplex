package com.bigplex.bigplex.profile;

import com.bigplex.bigplex.user.converter.ProfileConverter;
import com.bigplex.bigplex.user.dto.ProfileDto;
import com.bigplex.bigplex.user.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ProfileControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @MockBean //ProfileDao profileDao;
    ProfileConverter profileConverter;
    @MockBean
    ProfileService profileService;

    @Test
    public void addUserTest() throws Exception {
        ProfileDto profileDto =new ProfileDto();
        profileDto.setUserId(1);
        profileDto.setUserStatus("new");
        profileDto.setUserName("kaz");
        profileDto.setName("kaz rogers");
        profileDto.setImage("image");
        profileDto.setContact("0708252166");
        profileDto.setPassword("pass");

        String jsonRequest=objectMapper.writeValueAsString(profileDto);
        mockMvc.perform(post("user/new")
                .contentType("application/json")
                .content(jsonRequest))
                .andExpect(status().isOk());

    }
}
