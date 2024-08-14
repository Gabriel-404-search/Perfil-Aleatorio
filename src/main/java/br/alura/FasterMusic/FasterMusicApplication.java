package br.alura.FasterMusic;

import br.alura.FasterMusic.services.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  FasterMusicApplication implements CommandLineRunner {

	private final Principal principal;

    public FasterMusicApplication(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
		SpringApplication.run(FasterMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.showMenu();
	}
}