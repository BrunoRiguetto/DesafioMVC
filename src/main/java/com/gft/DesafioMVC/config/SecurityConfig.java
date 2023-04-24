package com.gft.DesafioMVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.DesafioMVC.domain.PerfilTipo;
import com.gft.DesafioMVC.service.UsuarioService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN = PerfilTipo.ADMIN.getDesc();
    private static final String USUARIOLOGADO = PerfilTipo.USUARIOLOGADO.getDesc();
    
	
	@Autowired
	private UsuarioService service;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()

			.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
			.antMatchers("/", "/home").permitAll()
			.antMatchers("/u/novo/cadastro", "/u/cadastro/realizado", "/u/cadastro/paciente/salvar").permitAll()
			.antMatchers("/u/confirmacao/cadastro").permitAll()
			.antMatchers("/u/p/**").permitAll()

			.antMatchers("/u/editar/senha", "/u/confirmar/senha").hasAnyAuthority(USUARIOLOGADO)
			.antMatchers("/u/**").hasAuthority(ADMIN)
									
			.antMatchers("/usuarioLogado/**").hasAnyAuthority(USUARIOLOGADO)
			.antMatchers("/receitas/u/novo**").hasAnyAuthority(ADMIN, USUARIOLOGADO)
			.antMatchers("/receitas/cadastroIngrediente").hasAuthority(ADMIN)
			
			.antMatchers("/ingredientes/datatables/server/*").hasAnyAuthority(ADMIN)
			.antMatchers("/ingredientes/titulo").hasAnyAuthority(ADMIN, USUARIOLOGADO)
			.antMatchers("/ingredientes/**").hasAuthority(ADMIN)
			.antMatchers("/receitas/u/novo").hasAuthority(ADMIN)
			.antMatchers("/unidadeMedida/**").hasAuthority(ADMIN)
			
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login-error")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/acesso-negado")
			.and()
				.rememberMe();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
}
