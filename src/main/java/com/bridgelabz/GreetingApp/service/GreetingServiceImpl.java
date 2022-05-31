package com.bridgelabz.GreetingApp.service;

import com.bridgelabz.GreetingApp.Model.Greeting;
import com.bridgelabz.GreetingApp.Model.User;
import com.bridgelabz.GreetingApp.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService{

    @Autowired
    private IGreetingRepository greetingRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }


    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting editGreetingById(long id, String name) {
        Greeting greeting = greetingRepository.findById(id).get();
        greeting.setMessage(name);
        greetingRepository.save(greeting);
        return greeting;
    }

    @Override
    public List<Greeting> deleteGreetingById(Long id) {
        greetingRepository.deleteById(id);
        return greetingRepository.findAll();
    }
}
