package com.example.demo.Controller;

import com.example.demo.Model.Region;
import com.example.demo.Service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/region")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping
    public List<Region> getAllRegion(){
        return regionService.getAllRegion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable int id){
        Optional<Region> region = regionService.getRegionById(id);
        return region.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Region addRegion(@RequestBody Region regionModel){
        return regionService.addRegion(regionModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable int id){
        boolean deleted = regionService.deleteRegion(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable int id, @RequestBody Region region){
        Optional<Region> updated = regionService.updateRegion(id, region);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
