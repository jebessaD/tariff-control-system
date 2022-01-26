package com.imala.imala.Profile;

import java.util.List;


import javax.validation.Valid;

import com.imala.imala.Security.SignUpForm;
import com.imala.imala.Security.User;
import com.imala.imala.Security.UserRepository;
import com.imala.imala.Security.User.Role;
import com.imala.imala.description.DescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class adminHomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/admin/adminHome")
    public ModelAndView showAdminHome(){
        ModelAndView model=new ModelAndView("adminHome");
        int userCount=userRepository.countByRole(Role.USER);
        int trafficCount=userRepository.countByRole(Role.TRAFFIC);
        int adminCount=userRepository.countByRole(Role.ADMIN);
        Long reportCount=descriptionRepository.count();
        model.addObject("countUser", userCount);
        model.addObject("countTraffic", trafficCount);
        model.addObject("countAdmin", adminCount);
        model.addObject("countReport", reportCount);
        return model;
    }


    @GetMapping("/admin/trafficsList")
    public ModelAndView trafficsList(){
        List<User> traffics=userRepository.findByRole(Role.TRAFFIC);
        ModelAndView model=new ModelAndView("editTraffic");
        model.addObject("traffics", traffics);
        return model;
    }
    

    @GetMapping("/admin/updatetraffic")
    public ModelAndView updateTraffic(@RequestParam("trafficId")Long id){
        ModelAndView model=new ModelAndView("traffic_update");
        User traffic=userRepository.findById(id).get();
        model.addObject("traffic", traffic);
        return model;
    }


    @PostMapping("/admin/updateTraffic")
    public String saveTrafficUpdate(@Valid @ModelAttribute("traffic") User user,BindingResult result){
        if(result.hasErrors()){
            return "traffic_update";
        }
        else{
        userRepository.save(user);
        return "redirect:/admin/trafficsList";
        }
    }


    @GetMapping("/admin/deletetraffic")
    public String deleteTraffic(@ModelAttribute("trafficId") Long id){
        userRepository.deleteById(id);
        return "redirect:/admin/trafficsList";
    }


    @GetMapping("/admin/addTraffic")
    public ModelAndView showAddTrafficForm(){
        ModelAndView model=new ModelAndView("addTraffic");
        model.addObject("signUpForm", new SignUpForm());
        return model;
    }


    @PostMapping("/admin/addTraffic")
    public String addTraffic(@Valid @ModelAttribute SignUpForm signUpForm,BindingResult result) {
        if(result.hasErrors()){
            return "addTraffic";
        }
        else{
        signUpForm.setRole(Role.TRAFFIC);
        userRepository.save(signUpForm.createUser(passwordEncoder));
        return "redirect:/admin/trafficsList";
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////




    //////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/admin/adminsList")
    public ModelAndView adminsList(){
        List<User> admins=userRepository.findByRole(Role.ADMIN);
        ModelAndView model=new ModelAndView("editAdmin");
        model.addObject("admins", admins);
        return model;
    }

    @GetMapping("/admin/updateadmin")
    public ModelAndView updateAdmin(@RequestParam("adminId")Long id){
        ModelAndView model=new ModelAndView("admin_update");
        User admin=userRepository.findById(id).get();
        model.addObject("admin", admin);
        return model;
    }


    @PostMapping("/admin/updateAdmin")
    public String saveAdminUpdate(@Valid @ModelAttribute("admin") User user,BindingResult result){

        if(result.hasErrors()){
            return "admin_update";
        }
        else{
        userRepository.save(user);
        return "redirect:/admin/adminsList";
        }
    }

    @GetMapping("/admin/deleteadmin")
    public String deleteAdmin(@ModelAttribute("adminId") Long id){
        userRepository.deleteById(id);
        return "redirect:/admin/adminsList";
    }

    @GetMapping("/admin/addAdmin")
    public ModelAndView showAddAdminForm(){
        ModelAndView model=new ModelAndView("addAdmin");
        model.addObject("signUpForm", new SignUpForm());
        return model;
    }

    @PostMapping("/admin/addAdmin")
    public String addAdmin(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm,BindingResult result) {
        
        if(result.hasErrors()){
            return "addAdmin";
        }
        else{
        signUpForm.setRole(Role.ADMIN);
        userRepository.save(signUpForm.createUser(passwordEncoder));
        return "redirect:/admin/adminsList";
        }
    }
/////////////////////////////////////////////////////////////////////////////////////

    


        /////////////////////////////////////////////////////////////////////////////////////

@GetMapping("/admin/usersList")
    public ModelAndView usersList(){
        List<User> users=userRepository.findByRole(Role.USER);
        ModelAndView model=new ModelAndView("editUser");
        model.addObject("users", users);
        return model;
    }

    @GetMapping("/admin/updateUser")
    public ModelAndView updateUser(@RequestParam("userId")Long id){
        ModelAndView model=new ModelAndView("user_update");
        User user=userRepository.findById(id).get();
        model.addObject("user", user);
        return model;
    }
    
    @PostMapping("/admin/updateUser")
    public String saveUserUpdate(@Valid @ModelAttribute("user") User user,BindingResult result){
        if(result.hasErrors()){
            return "user_update";
        }
        else{
        userRepository.save(user);
        return "redirect:/admin/usersList";
        }
    }

    @GetMapping("/admin/deleteUser")
    public String deleteUser(@ModelAttribute("userId") Long id){
        userRepository.deleteById(id);
        return "redirect:/admin/usersList";
    }
}