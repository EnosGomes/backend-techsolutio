package com.enos.techsolutio;

import com.enos.techsolutio.model.ERole;
import com.enos.techsolutio.model.Produto;
import com.enos.techsolutio.model.Role;
import com.enos.techsolutio.respository.ProdutoRepository;
import com.enos.techsolutio.respository.RoleRepository;
import com.enos.techsolutio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class TechsolutioApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ProdutoService produtoService;

	public static void main(String[] args) {
		SpringApplication.run(TechsolutioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		roleRepository.save(new Role(ERole.ROLE_ADMIN));
		roleRepository.save(new Role(ERole.ROLE_MODERATOR));
		roleRepository.save(new Role(ERole.ROLE_USER));

		produtoService.salvarProduto(new Produto("notebook","americanas",new BigDecimal(1000)));

	}
}
