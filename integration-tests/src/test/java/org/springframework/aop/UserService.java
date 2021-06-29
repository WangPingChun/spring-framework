package org.springframework.aop;


public interface UserService {

	User createUser(String firstName, String lastName, int age);

	User queryUser();
}
