package br.alura.FasterMusic.repository;

import br.alura.FasterMusic.models.ApiForProfile;
import br.alura.FasterMusic.entities.OrderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<OrderProfile, Long> {}