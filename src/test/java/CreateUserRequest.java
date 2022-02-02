public class CreateUserRequest{
	private String password;
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"CreateUserRequest{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
