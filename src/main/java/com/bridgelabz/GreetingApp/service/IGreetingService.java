package com.bridgelabz.GreetingApp.service;

import com.bridgelabz.GreetingApp.Model.Greeting;
import com.bridgelabz.GreetingApp.Model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<Greeting> getAll();

    Greeting editGreetingById(long id, String name);

    List<Greeting> deleteGreetingById(Long id);
}

