/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Users;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import repository.UserEJB;

/**
 *
 * @author MECHREVO
 */
@ManagedBean
@SessionScoped
public class RegisterView implements Serializable {
	private static final long serialVersionUID = 1685823449195612778L;
	private static Logger log = Logger.getLogger(RegisterView.class.getName());
	@EJB
	private UserEJB userEJB;
	private String username;
        private String firstName;
        private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	public void validatePassword(ComponentSystemEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UIComponent components = event.getComponent();
		// get password
		UIInput uiInputPassword = (UIInput) components.findComponent("password");
		String password = uiInputPassword.getLocalValue() == null ? "" : uiInputPassword.getLocalValue().toString();
		String passwordId = uiInputPassword.getClientId();
		// get confirm password
		UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmpassword");
		String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
				: uiInputConfirmPassword.getLocalValue().toString();
		// Let required="true" do its job.
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			return;
		}
		if (!password.equals(confirmPassword)) {
			FacesMessage msg = new FacesMessage("Confirm password does not match password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			facesContext.addMessage(passwordId, msg);
			facesContext.renderResponse();
		}
		if (userEJB.findUserByEmail(email) != null) {
			FacesMessage msg = new FacesMessage("User with this e-mail already exists");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			facesContext.addMessage(passwordId, msg);
			facesContext.renderResponse();
		}
	}
	public String register() {
		Users user = new Users(username, firstName, lastName, email, password);
		userEJB.createUser(user);
		log.log(Level.INFO, "New user created with e-mail: {0} and username: {1}", new Object[]{email, username});
                //log.info("New user created with e-mail: " + email + " and username: " + username);
		return "regdone";
	}
        
	public String getUsername() {
		return username;
	}
        
	public void setUsername(String username) {
		this.username = username;
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
        
        public void setLastName(String LastName) {
            this.lastName = LastName;
        }  
        
	public String getEmail() {
		return email;
	}  
        
	public void setEmail(String email) {
		this.email = email;
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
}
