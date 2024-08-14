package br.alura.FasterMusic.services;

import br.alura.FasterMusic.models.ApiForProfile;
import br.alura.FasterMusic.entities.OrderProfile;
import br.alura.FasterMusic.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Principal {
    private final QueryApi queryApi = new QueryApi();
    private final ConvertData convertData = new ConvertData();
    private final String ADDRESS = "https://randomuser.me/api/";

    @Autowired
    public ProfileRepository repository;

    public void showMenu(){
       Scanner read = new Scanner(System.in);

       var option = -5;
        while(option != 0){
        System.out.println("""
                
                1 - Criar um perfil aleatório
                2 - Filtrar nome por ordem alfabética
                0 - Sair do menu
                """);
        option = read.nextInt();
        read.nextLine();

        switch (option) {
            case 1:
                builderNewProfile();
                break;
//            case 2:
//                sortByAlphabetical();
//                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        }

    }
    public ApiForProfile convetJson() {
        String json = queryApi.getData(ADDRESS);
        return convertData.getData(json, ApiForProfile.class);
    }

//    private void sortByAlphabetical() {
//        ApiForProfile dataJson = convetJson();
//        ApiForProfile alphabetical = repository.findByNameOrderByFirstDesc();
//        alphabetical.results().forEach(System.out::println);
//    }

    private void builderNewProfile() {
        ApiForProfile profile = convetJson();
        List<OrderProfile> list = profile.results().stream()
                .map(OrderProfile::new).toList();

        repository.saveAll(list);
        list.forEach(System.out::println);
    }
}