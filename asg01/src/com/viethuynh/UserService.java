package com.viethuynh;
import java.util.List;

public interface UserService {
    List<User> getAllUsers(int page, int pageSize);
    int getTotalUsers();
}
