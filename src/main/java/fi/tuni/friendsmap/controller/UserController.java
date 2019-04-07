package fi.tuni.friendsmap.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fi.tuni.friendsmap.entity.User;
import fi.tuni.friendsmap.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
			
	@RequestMapping(value = "users/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@RequestMapping(value = "users/", method = RequestMethod.PUT)
	public User createUser(@RequestBody User user) throws UsernameAlreadyTakenException {
		User createdUser;
		
		try {
			createdUser = userRepo.save(user);
			
			return createdUser;
		} catch(DataIntegrityViolationException  e) {
			throw new UsernameAlreadyTakenException("Username is already in use!");			
		}
	}
	
	@RequestMapping(value = "users/", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		User currentUser = userRepo.findById(user.getId());
		
		currentUser.setLatitude(round(user.getLatitude(), 6));
		currentUser.setLongitude(round(user.getLongitude(), 6));
		currentUser.setLocationInfo(user.getLocationInfo());
		
		userRepo.save(currentUser);
		
		return currentUser;
	}
	
	@RequestMapping(value = "users/deletelocations", method = RequestMethod.POST)
	public User deleteUsersLocation(@RequestBody User user) {
		User currentUser = userRepo.findById(user.getId());
		
		if(currentUser != null) {
			currentUser.setLatitude(-1);
			currentUser.setLongitude(-1);
			currentUser.setLocationInfo("");
		}
		
		return userRepo.save(currentUser);
	}
	
	/**
	 * TODO: MOVE THIS SOMEWHERE
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	
	@RequestMapping(value = "users/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) throws UserAuthenticationException {
		if(user != null) {
			User userFromDatabase = userRepo.findByUsername(user.getUsername());
			
			if(userFromDatabase == null)
				throw new UserAuthenticationException("User " + user.getUsername() + " not found.");
			else 
				return userFromDatabase;
					
		}
		/* Hmm... */
		return null;
	}
	
	@ResponseStatus(code = HttpStatus.CONFLICT)
	class UsernameAlreadyTakenException extends AuthenticationException {
		
		public UsernameAlreadyTakenException(String msg) {
			super(msg);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	class UserAuthenticationException extends AuthenticationException {
		
		public UserAuthenticationException(String msg) {
			super(msg);
		}
		
	}



}
