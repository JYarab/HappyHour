package com.dojogroup.happyhour.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dojogroup.happyhour.models.User;
import com.dojogroup.happyhour.services.UserService;

@Component
public class UserValidator implements Validator{
	
	private UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
		
	}
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPwConfirmation().equals(user.getPassword())) {

            errors.rejectValue("pwConfirmation", "Match");
        }
        
        if(userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Registered");
			
		}
    }

}
