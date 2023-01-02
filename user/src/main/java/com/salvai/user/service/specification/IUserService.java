package com.salvai.user.service.specification;

import com.salvai.user.model.client.UserRequest;
import com.salvai.user.model.domain.User;

public interface IUserService {
    User addUser(UserRequest userRequest);

    User getUser(Long userId);
}
