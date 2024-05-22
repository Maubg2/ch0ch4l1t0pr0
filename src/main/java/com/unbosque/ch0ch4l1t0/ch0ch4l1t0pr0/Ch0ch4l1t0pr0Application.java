package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.UsuarioRepository;

@SpringBootApplication
public class Ch0ch4l1t0pr0Application implements CommandLineRunner{

	@Autowired
	private UsuarioRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Ch0ch4l1t0pr0Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	/* 	Usuario usuario = new Usuario("Edison", "Beltran", "mau@bosque.com",
							 "Maubg2", "123456", "3504165311", new Date(), 2L);

		repository.save(usuario);

		Usuario usuario2 = new Usuario("Karol", "Beltran", "karol@bosque.com",
							 "Karito", "123456", "3504165311", new Date(), 1L);
		repository.save(usuario2);*/
	}

}
