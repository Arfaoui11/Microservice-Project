package io.microservice.formationdataservice.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.microservice.formationdataservice.Entity.Formation;
import io.microservice.formationdataservice.Services.IFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/formations")
public class FormationResource {


    @Autowired
    private IFormationService formationService;


    @PostMapping("/{userid}")
    @ResponseBody
    @CircuitBreaker(name = "formation")
    //@TimeLimiter(name = "formation")
    //@Retry(name = "formation")
    public Formation ajouterFormation(@RequestBody Formation formateur, @PathVariable("userid") Integer userid )  {

        // User user1 = userService.saveUser(formateur);
        return formationService.ajouterEtAffecterFormationAFormateur(formateur,userid) ;
        // return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }



    @GetMapping("/{id}")
    @ResponseBody
   // @CircuitBreaker(name = "formation")
    public Formation getSingleFormation(@PathVariable(name = "id") Integer id)
    {
        // User user = userService.getUser(userid);
        return formationService.getFormation(id);
        // return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
   // @CircuitBreaker(name = "formation")
    public List<Formation> getFormationByUserId(@PathVariable(name = "id") Integer id)
    {
        // User user = userService.getUser(userid);
        return formationService.getFormatioByUserId(id);
        // return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    //@CircuitBreaker(name = "formation")
    public void deleteFormation( @PathVariable(name = "id") Integer id)
    {
        formationService.deleteFormation(id);

    }

    @GetMapping()
    @ResponseBody
   // @CircuitBreaker(name = "formation",fallbackMethod = "fallbackMethod")
    public List<Formation> getAllFormations()
    {
        List<Formation> list = formationService.afficherFormation();
        //return ResponseEntity.ok(list);
        return list;
    }



}
