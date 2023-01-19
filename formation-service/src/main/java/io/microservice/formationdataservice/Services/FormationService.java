package io.microservice.formationdataservice.Services;

import io.microservice.formationdataservice.Entity.Formation;
import io.microservice.formationdataservice.Entity.User;
import io.microservice.formationdataservice.Exceptions.ResourceNotFoundException;
import io.microservice.formationdataservice.Repository.IFormationRepo;
import io.microservice.formationdataservice.Repository.IUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class FormationService implements IFormationService{

    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IFormationRepo iFormationRepo;

    @Override
    public Formation ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur) {
     User user = restTemplate.getForObject("http://user-data-service/users/"+idFormateur, User.class);
     System.out.println(user);
     formation.setFormateurId(user.getId());
     return iFormationRepo.save(formation);
    }

    @Override
    public Formation updateFormation(Formation formationr) {
        return iFormationRepo.save(formationr);
    }

    @Override
    public void deleteFormation(Integer idFormation) {
        iFormationRepo.deleteById(idFormation);
    }

    @Override
    public Formation getFormation(Integer idFormation) {
        return iFormationRepo.findById(idFormation).orElseThrow(() -> new ResourceNotFoundException("Formation with given id not found on server !!"));
    }

    @Override
    public List<Formation> afficherFormation() {

        return iFormationRepo.findAll();
    }

    @Override
    public List<Formation> getFormatioByUserId(Integer id) {
        return iFormationRepo.findByFormateurId(id);
    }
}
