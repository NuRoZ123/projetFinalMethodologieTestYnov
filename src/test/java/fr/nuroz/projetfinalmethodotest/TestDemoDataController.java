package fr.nuroz.projetfinalmethodotest;
import static org.assertj.core.api.Assertions.assertThat;

import fr.nuroz.projetfinalmethodotest.entities.Etudiant;
import fr.nuroz.projetfinalmethodotest.repositories.EtudiantRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestDemoDataController {

    @Autowired
    private EtudiantRepository repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateProduct() {
        Etudiant etudiantSauvegarder = repo.save(new Etudiant("Jean", 12));

        assertThat(etudiantSauvegarder.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testFindProductByName() {
        Etudiant etudiant = repo.findByNom("Jean");
        assertThat(etudiant.getNom()).isEqualTo("Jean");
    }

    @Test
    @Order(3)
    public void testListProducts() {
        List<Etudiant> products = (List<Etudiant>) repo.findAll();
        assertThat(products).size().isGreaterThan(0);
    }

}
