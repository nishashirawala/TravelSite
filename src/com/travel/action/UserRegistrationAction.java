package com.travel.action;

import javax.servlet.http.HttpSession;

import com.travel.model.User;
import com.travel.service.IRoleService;
import com.travel.service.IUserService;

public class UserRegistrationAction extends BaseAction {

	private String userName;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String email;

	private IUserService userService;
	private IRoleService roleService;

	
	public String saveUserRegistration() {
		try {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setIsactive(true);
			user.setRole(roleService.findRoleByRoleName("member"));

			userService.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String showUserRegistration() {
		return SUCCESS;
	}
	
	public String loginUserRegistration() {
		try{
			if(userName !=null){
				User user = userService.findUserByUserName(userName);
				if(user!=null && password != null && password.equals(user.getPassword())){
					HttpSession session = getHttpServletRequest().getSession();
					session.setAttribute("memberusername", user.getUserName());
					Object tourBookingObj = session.getAttribute("tourIdForBooking");
					Object hotelBookingObj = session.getAttribute("hotelIdForBooking");
					if(tourBookingObj!=null){
						return "TOURBOOKED";
					} else if(hotelBookingObj !=null){
						return "HOTELBOOKED";
					}
					return ERROR;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
}
