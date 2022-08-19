package com.example.demo.DbsController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SsController {

@RequestMapping("/home")
public String welcome()
{
	return "Welcome to Spring home page";
}
@RequestMapping("/admin")
public String adminWelcome() {
	return "Welcome to Spring Admin Page";
}
@RequestMapping("/user")
public String userWelcome()
{
	return "Welcome to Spring User page";
}
@RequestMapping("/dashboard")
public String dashBoard() {
	return "Welcome to Spring dashBoard Page";
}


}

