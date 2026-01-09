//package com.aluracursos.screenmatch;
//
//import com.aluracursos.screenmatch.principal.Principal;
//import com.aluracursos.screenmatch.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenmatchApplicationConsolaApp implements CommandLineRunner {
//
//	// Le pedimos a Spring que inyecte el repositorio aquí
//	@Autowired
//	private SerieRepository repository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchApplicationConsolaApp.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// Pasamos el repositorio a nuestra clase Principal para poder usarlo allí
//		Principal principal = new Principal(repository);
//		principal.muestraElMenu();
//	}
//}
