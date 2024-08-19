package br.alura.FasterMusic.services;

import br.alura.FasterMusic.entities.OrderProfile;
import br.alura.FasterMusic.models.ApiForProfile;
import br.alura.FasterMusic.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Principal {
    Scanner read = new Scanner(System.in);
    private final QueryApi queryApi = new QueryApi();
    private final ConvertData convertData = new ConvertData();
    String ADDRESS = "https://randomuser.me/api/";

    @Autowired
    public ProfileRepository repository;

    public void showMenu(){

        var option = -5;
        while(option != 0){
            System.out.println("""
                
                1 - Criar um perfil aleatório
                2 - Buscar perfil pelo E-mail
                3 - Filtrar perfil pela idade
                4 - Buscar E-mail por trecho
                
                0 - Sair do menu
                """);
            option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    builderNewProfile();
                    break;
                case 2:
                    buiderAcrossEmail();
                    break;
                case 3:
                    buiderAcrossAge();
                    break;
                case 4:
                    buiderAcrossExcerpt();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }

    }

    public List<OrderProfile> convertJson() {
        String json = queryApi.getData(ADDRESS);
        ApiForProfile test = convertData.getData(json, ApiForProfile.class);
        return test.results().stream()
                .map(OrderProfile::new).toList();
    }

    private void buiderAcrossExcerpt() {
        System.out.println("Digite o trecho do e-mail da sua respectiva busca.");
        String opcao = read.nextLine();
        List<OrderProfile> partEmail = repository.seekEmailByExcerpt(opcao);
        partEmail.forEach(p-> System.out.printf("Nome: %s\n - E-mail: %s\n - Telefone: %s\n - Idade filtrada: %s\n - Genero: %s\n - Cidade: %s\n",
                p.getName().getFirst(), p.getEmail(), p.getPhone(),
                p.getBirthDay().getAge(), p.getGender().name(), p.getLocation().getCity()));
    }

    private void buiderAcrossAge() {
        System.out.println("A partir de qual idade miníma voce pretende filtrar?");
        int limitAge = read.nextInt();
        read.nextLine();
        List<OrderProfile> optional = repository.filterName(limitAge);
        optional.forEach(o ->
                System.out.printf("Nome: %s\n - E-mail: %s\n - Telefone: %s\n - Idade filtrada: %s\n - Genero: %s\n - Cidade: %s\n",
                        o.getName().getFirst(), o.getEmail(), o.getPhone(),
                        o.getBirthDay().getAge(), o.getGender().name(), o.getLocation().getCity()));
    }

    private void buiderAcrossEmail() {
        System.out.println("Digite o e-mail que deseja consultar..\n");
        String opcao = read.nextLine();
        List<OrderProfile> optional = repository.findByEmailContainingIgnoreCase(opcao);
        if (optional.isEmpty()) {
            System.out.println("\nE-mail incorreto!\nVerifique se houve algum erro durante a digitação e tente novamente. \n");
        } else {
            optional.forEach(o ->
                    System.out.printf("E-mail: %s\n - Nome: %s\n - Telefone: %s\n - Data de nascimento: %s\n - Genero: %s\n - Cidade: %s\n",
                            o.getEmail(), o.getName().getFirst(), o.getPhone(),
                            o.getBirthDay().getDate(), o.getGender().name(), o.getLocation().getCity()));
        }
    }

    private void builderNewProfile() {
        List<OrderProfile> list = convertJson();
        repository.saveAll(list);
        list.forEach(System.out::println);
    }
} //arttu.arola@example.com