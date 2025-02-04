package com.satyam.recipy.Entity;

import java.util.List;

public interface AppUserDetails {
    String getUserName();
    String getPassword();
    List<Role> getRoles();
}
