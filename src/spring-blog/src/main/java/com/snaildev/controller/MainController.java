package com.snaildev.controller;

import com.snaildev.model.UserEntity;
import com.snaildev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        List<UserEntity> userList = userRepository.findAll();
        modelMap.addAttribute("userList", userList);

        return "admin/users";
    }

    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        return "admin/addUser";
    }

    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        //userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
        userRepository.saveAndFlush(userEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {
        UserEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);

        return "admin/userDetail";
    }

    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {
        UserEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);

        return "admin/updateUser";
    }

    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity userEntity) {
        userRepository.updateUser(userEntity.getNickname(), userEntity.getFirstName(),
                userEntity.getLastName(), userEntity.getPassword(), userEntity.getId());

        userRepository.flush();

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId){
        userRepository.delete(userId);
        userRepository.flush();

        return "redirect:/admin/users";
    }
}
