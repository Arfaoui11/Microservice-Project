package io.microservice.formationdataservice.Controller;

import io.microservice.formationdataservice.Entity.Formation;
import io.microservice.formationdataservice.Services.IFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationResource {


    @Autowired
    private IFormationService formationService;


    @PostMapping("/{userid}")
    @ResponseBody
    public Formation ajouterFormation(@RequestBody Formation formateur,@PathVariable("userid") Integer userid )  {

        // User user1 = userService.saveUser(formateur);
        return formationService.ajouterEtAffecterFormationAFormateur(formateur,userid);
        // return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public Formation getSingleFormation(@PathVariable(name = "id") Integer id)
    {
        // User user = userService.getUser(userid);
        return formationService.getFormation(id);
        // return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public List<Formation> getFormationByUserId(@PathVariable(name = "id") Integer id)
    {
        // User user = userService.getUser(userid);
        return formationService.getFormatioByUserId(id);
        // return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteFormation( @PathVariable(name = "id") Integer id)
    {
        formationService.deleteFormation(id);

    }

    @GetMapping()
    @ResponseBody
    public List<Formation> getAllFormations()
    {
        List<Formation> list = formationService.afficherFormation();
        //return ResponseEntity.ok(list);
        return list;
    }

}
