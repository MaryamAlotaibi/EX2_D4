package com.example.myusercontrollers.Controllers;
import com.example.myusercontrollers.model.MyUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class MyUserController {
    ArrayList<MyUser> users= new ArrayList<>();

    @GetMapping("/user")
    public ArrayList<MyUser> getUsers(){
        return users;
    }
    @PostMapping("/user")
    public String addUser(@RequestBody MyUser user){
        users.add(user);
        return "New user added to the list !";
    }

    @PutMapping("/user/role/{index}")
    public String updateUser(@PathVariable int index, @RequestBody MyUser user)
    {
        MyUser myUsers= users.get(index);
        myUsers.setRole(user.getRole());
        return "user Update !";
    }
    @DeleteMapping("/user/{index}")
    public String deleteUser(@PathVariable int index){

        users.remove(index);
        return "user delete !";
    }


}
