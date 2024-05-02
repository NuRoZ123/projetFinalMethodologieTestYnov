package fr.nuroz.projetfinalmethodotest.repositories;

import fr.nuroz.projetfinalmethodotest.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

    public Etudiant findByNom(String nom);
}