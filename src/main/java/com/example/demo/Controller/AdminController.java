package com.example.demo.Controller;


import com.example.demo.Model.AdminModel;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public String getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @GetMapping("/{id}")
    public String getAdminById(@PathVariable int id){
        return adminService.getAdminById(id);
    }

    @PostMapping
    public  String addAdmin(@RequestBody AdminModel adminModel){
        return adminService.addAdmin(adminModel);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable int id){
        return adminService.deleteAdmin(id); // Llama al servicio con el ID
    }

    @PutMapping("/{id}")
    public String updateAdmin(@PathVariable int id, @RequestBody AdminModel admin){
        return adminService.updateAdmin(id, admin);
    }
}
