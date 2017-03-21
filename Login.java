public class Login {
	
	ArrayList users;
	User currentUser
	Login()
	{
		users = newArrayList<User>();
		currentUser = null;
	}
	public static boolean login(String email, String password) {
		//Requires ArrayList...
		for(int i=0;i<users.size();i++) {
			if(email.equals(users.get(i).email) {
				System.out.println("User Found");
				if(password.equals(users.get(i).password) {
					currentUser = users[i];
					return true;
				} else {
					System.out.println("Password Invalid");
					return false;
				}
			}else {
				return false;
			}
		}
	}
	
	
}
