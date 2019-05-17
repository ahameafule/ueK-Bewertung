package ch.noseryoung.uekbewertung.config.security;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;
import ch.noseryoung.uekbewertung.webContext.domain.user.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	private Properties properties;

	/**
	 * @param requiresAuthenticationRequestMatcher
	 * @param authenticationManager
	 */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, Properties properties,
			RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
		setAuthenticationManager(authenticationManager);
		this.properties = properties;
	}

	/**
	 * This method attempts to login a user with the given credentials
	 *
	 * @param req Client request
	 * @param res Response to client request
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
		
		// read creds from header
		User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);

		// return authentication with read creds
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(creds.getLastName(), creds.getPassword()));
	}

	/**
	 * This method gets invoked in case the method attemptAuthentication
	 * successfully authenticated the given user
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 * @param auth  Authentication context that got generated in
	 *              attemptAuthentication
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		// Adds the UserDetailsImpl logic to the authenticated user
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) auth.getPrincipal();
		User user = userDetailsImpl.getUser();
		String subject = Long.toString(user.getId());

		// Builds the JWT
		String token = Jwts.builder().setSubject(subject)
				.setExpiration(new Date(
						Integer.parseInt(properties.getProperty("jwt.expiration-time")) + System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS512, properties.getProperty("jwt.secret").getBytes()).compact();

		// add the jwt to the return header
		res.addHeader(properties.getProperty("jwt.header-string"), properties.getProperty("jwt.token-prefix") + token);
	}

}
