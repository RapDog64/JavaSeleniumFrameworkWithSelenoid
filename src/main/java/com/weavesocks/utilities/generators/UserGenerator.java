package com.weavesocks.utilities.generators;

import com.weavesocks.models.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {

    public static User generateUser() {
        return User.builder()
                .firstname(RandomStringUtils.randomAlphabetic(3, 4))
                .lastname(RandomStringUtils.randomAlphabetic(3, 4))
                .username(RandomStringUtils.randomAlphabetic(3, 4))
                .email(RandomStringUtils.randomAlphabetic(3, 4))
                .password(RandomStringUtils.randomAlphabetic(3, 4) + "@mail.ru")
                .build();
    }
}
