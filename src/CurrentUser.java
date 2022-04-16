public class CurrentUser {
	private String username;
	private String password;
	private String subscriptionLevel;
	
	CurrentUser(String username, String password, String subscriptionLevel) {
		this.setUsername(username);
		this.setPassword(password);
		this.setSubscriptionLevel(subscriptionLevel);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubscriptionLevel() {
		return subscriptionLevel;
	}

	public void setSubscriptionLevel(String subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}
}
