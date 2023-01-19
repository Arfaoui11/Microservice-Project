package io.microservice.formationdataservice.Services;

import io.microservice.formationdataservice.Entity.Formation;

import java.util.List;

public interface IFormationService {


    Formation ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur);
    Formation updateFormation(Formation formation);
    void deleteFormation(Integer idFormation);
    Formation getFormation(Integer idFormation);
    List<Formation> afficherFormation();
    List<Formation> getFormatioByUserId(Integer id);
}
