package com.salvai.user.service.implementation;

import com.salvai.user.model.client.UserRequest;
import com.salvai.user.model.domain.User;
import com.salvai.user.repository.UserRepository;
import com.salvai.user.service.specification.IUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    @NonNull
    private UserRepository userRepository;

    @Override
    public User addUser(UserRequest userRequest) {
        var playgroundUser = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .build();

        // todo: check if email valid
        // todo: check if email not taken

        userRepository.save(playgroundUser);
        return playgroundUser;
    }

    @Override
    public User getUser(Long userId) {
        var user = userRepository.findById(userId);

        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return user.get(); // TODO: convert
    }
}
