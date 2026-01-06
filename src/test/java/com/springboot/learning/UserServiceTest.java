package com.springboot.learning;

import com.springboot.learning.model.Users;
import com.springboot.learning.repostiory.UserRepository;
import com.springboot.learning.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnUser() throws Exception {
        Users user = new Users(1L,"kumar", "1234", true);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Users result = userService.getUserById(1L);

        Assertions.assertEquals("kumar", result.getUsername());

    }
}
