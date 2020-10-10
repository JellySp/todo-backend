package com.jelly.rest.webservice.restwebservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter password: ");
        System.out.println("Your encoded password: " + passwordEncoder.encode(sc.next()));
        System.out.println("Use this as your password on JwtInMemoryUserDetailsService.java line 19.");

    }
}
