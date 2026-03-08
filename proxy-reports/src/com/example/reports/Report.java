package com.example.reports;

/**
 * Self note:
 * ye abstraction hai jisse client interact karega.
 * Proxy aur RealReport dono isko implement karenge.
 */
public interface Report {

    void display(User user);

}