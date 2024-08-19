package br.alura.FasterMusic.repository;

import br.alura.FasterMusic.entities.OrderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<OrderProfile, Long> {
    List<OrderProfile> findByEmailContainingIgnoreCase(String nameEmail);

    @Query("SELECT o FROM OrderProfile o JOIN o.birthDay b WHERE b.age >= :limitAge ORDER BY b.age DESC LIMIT 5")
    // falta alguns ajustes
    List<OrderProfile> filterName(int limitAge);

    @Query("SELECT o FROM OrderProfile o WHERE o.email ILIKE %:excerpt%")
    // o erro que esta dando neste carinha é que ele nao consegue ler as outras classes que não são informadas, perguntar pro lucas como consertar.
    List<OrderProfile> seekEmailByExcerpt(String excerpt);
}