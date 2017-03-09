package com.beehyv.nmsreporting.controller;

import com.beehyv.nmsreporting.business.ModificationTrackerService;
import com.beehyv.nmsreporting.business.UserService;
import com.beehyv.nmsreporting.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by beehyv on 23/2/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModificationTrackerService modificationTrackerService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        return userService.getListOfUsers();
    }

    @RequestMapping(value = {"/list/role/{userRole}"}, method = RequestMethod.GET)
    public @ResponseBody List<User> getUsersByRole(@PathVariable("userRole") String userRole) {
        return userService.getListOfUsersByRole(userRole);
    }

    @RequestMapping(value = {"/list/level/{hierarchyLevel}"}, method = RequestMethod.GET)
    public @ResponseBody List<User> getUsersByLevel(@PathVariable("hierarchyLevel") String hierarchyLevel) {
        return userService.getListOfUsersByLevel(hierarchyLevel);
    }

    @RequestMapping(value = {"/list/access/{hierarchyLevel}/{userRole}"})
    public @ResponseBody List<User> getUsersByAccessPermission(@PathVariable("hierarchyLevel") String hierarchyLevel,
                                                               @PathVariable("userRole") String userRole) {
        return userService.getListOfUsersByAccessPermissions(hierarchyLevel, userRole);
    }

    @RequestMapping(value = {"/create-user"}, method = RequestMethod.POST)
    public void createNewUser(@RequestBody User user) {
        userService.createNewUser(user);
//        ModificationTracker modification = new ModificationTracker();
//        modification.setModificationDate(new Date(System.currentTimeMillis()));
//        modification.setModificationDetails("Account creation");
//        modification.setModificationType(ModificationType.CREATE.getModificationType());
//        modification.setModifiedUserId(user);
//        modification.setModifiedByUserId(userService.findUserByUserName(getPrincipal()));
//        modificationTrackerService.saveModification(modification);
    }


    @RequestMapping(value = {"/update-user"}, method = RequestMethod.POST)
    public void updateExistingUser(@RequestBody String modificationDetails) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(modificationDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = mapper.convertValue(node.get("user"), User.class);
        userService.updateExistingUser(user);

//        String trackModification = mapper.convertValue(node.get("modification"), String.class);
//
//        ModificationTracker modification = new ModificationTracker();
//        modification.setModificationDate(new Date(System.currentTimeMillis()));
//        modification.setModificationType(ModificationType.UPDATE.getModificationType());
//        modification.setModifiedByUserId(userService.findUserByUserName(getPrincipal()));
//        modification.setModifiedUserId(user);
//        modification.setModificationDetails(trackModification);
//        modificationTrackerService.saveModification(modification);
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
