package obj;


import javax.validation.constraints.*;

public class User {
	
	@Min(value =7, message = "email must be greater than or equal to 7 charcters")
	@Email(message = "Not a vaild email")
	private String email;
	
	@Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$", message = "Follow this format xxxxx-xxxx or xxxxx")
	private String zip;
	
	
	public User(String email,String zip)
	{
		this.email = email;
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
    
				
}
