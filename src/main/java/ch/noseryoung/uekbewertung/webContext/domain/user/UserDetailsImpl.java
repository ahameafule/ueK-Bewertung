package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;
import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

public class UserDetailsImpl implements UserDetails {

	private User user;
	
	/**
	 *
	 */
	public UserDetailsImpl() {
		super();
	}
	
	/**
	 * @param user
	 */
	@Autowired
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
			}
		}
		return grantedAuthorities;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getPassword() {
		return user.getPassword();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getUsername() {
		return user.getLastName();
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
