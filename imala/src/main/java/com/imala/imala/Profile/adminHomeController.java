package com.imala.imala.Profile;

import java.util.List;

import javax.sound.sampled.Line;

import com.imala.imala.Security.SignUpForm;
import com.imala.imala.Security.User;
import com.imala.imala.Security.UserRepository;
import com.imala.imala.Security.User.Role;
import com.imala.imala.cityJourney.CityJourneyRepository;
import com.imala.imala.cityJourney.CityJourneyService;
import com.imala.imala.crosscountry.CrossRepository;
import com.imala.imala.description.DescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private CityJourneyService cityJourneyService;

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Autowired
    private CityJourneyRepository cityJourneyRepository;

    @Autowired
    private CrossRepository crossRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/adminHome")
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

    @GetMapping("/trafficsList")
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

    @PostMapping("/updateTraffic")
    public String saveTrafficUpdate(@ModelAttribute("traffic") User user){
        userRepository.save(user);
        return "redirect:/trafficsList";
    }

    @GetMapping("/admin/deletetraffic")
    public String deleteTraffic(@ModelAttribute("trafficId") Long id){
        userRepository.deleteById(id);
        return "redirect:/trafficsList";
    }

    @GetMapping("/addTraffic")
    public String showAddTrafficForm(){
        return "addTraffic";
    }

    @PostMapping("/admin/addTraffic")
    public String addTraffic(SignUpForm signUpForm) {
        signUpForm.setRole(Role.TRAFFIC);
        userRepository.save(signUpForm.createUser(passwordEncoder));
        return "redirect:/trafficsList";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////




    //////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/adminsList")
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


    @PostMapping("/updateAdmin")
    public String saveAdminUpdate(@ModelAttribute("admin") User user){
        userRepository.save(user);
        return "redirect:/adminsList";
    }

    @GetMapping("/admin/deleteAdmin")
    public String deleteAdmin(@ModelAttribute("adminId") Long id){
        userRepository.deleteById(id);
        return "redirect:/adminsList";
    }

    @GetMapping("/addAdmin")
    public String showAddAdminForm(){
        return "addAdmin";
    }

    @PostMapping("/admin/addAdmin")
    public String addAdmin(SignUpForm signUpForm) {
        signUpForm.setRole(Role.ADMIN);
        userRepository.save(signUpForm.createUser(passwordEncoder));
        return "redirect:/adminsList";
    }
/////////////////////////////////////////////////////////////////////////////////////

    


        /////////////////////////////////////////////////////////////////////////////////////

@GetMapping("/usersList")
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
    
    @PostMapping("/updateUser")
    public String saveUserUpdate(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "redirect:/usersList";
    }

    @GetMapping("/admin/deleteUser")
    public String deleteUser(@ModelAttribute("userId") Long id){
        userRepository.deleteById(id);
        return "redirect:/usersList";
    }
}