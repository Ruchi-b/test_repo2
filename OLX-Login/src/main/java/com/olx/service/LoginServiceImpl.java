package com.olx.service;

import org.springframework.stereotype.Service;

import com.olx.dto.User;

@Service
public class LoginServiceImpl implements LoginService {



@Override
public String authenticate(User user) {
// TODO Auto-generated method stub
return "Akshay";
}



@Override
public boolean logout(String authToken) {
// TODO Auto-generated method stub
return true;
}



@Override
public User addUser(User user) {
// TODO Auto-generated method stub
return user;
}



@Override
public User getUser(String authtoken) {
// TODO Auto-generated method stub
return null;
}



@Override
public boolean validate(String authToken) {
// TODO Auto-generated method stub
return true;
}



}
