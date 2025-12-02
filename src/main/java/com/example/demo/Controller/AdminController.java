package com.example.demo.Controller;


import com.example.demo.Model.AdminModel;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public List<AdminModel> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdminModel> getAdminById(@PathVariable int id){
        Optional<AdminModel> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdminModel addAdmin(@RequestBody AdminModel adminModel){
        return adminService.addAdmin(adminModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id){
        boolean deleted = adminService.deleteAdmin(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminModel> updateAdmin(@PathVariable int id, @RequestBody AdminModel admin){
        Optional<AdminModel> updated = adminService.updateAdmin(id, admin);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
