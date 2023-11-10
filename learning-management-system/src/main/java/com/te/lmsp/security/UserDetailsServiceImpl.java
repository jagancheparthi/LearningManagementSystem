package com.te.lmsp.security;

 import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.te.lmsp.entity.AppUser;
import com.te.lmsp.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	private final AppUserRepository appUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = appUserRepository.findById(username);
		if(user!=null)
		return new User(username, user.get().getPassword(), List.of(new SimpleGrantedAuthority(user.get().getRole())));
		else throw new UsernameNotFoundException("no user with the given USER NAME");
	}

}
