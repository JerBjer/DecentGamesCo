package dao;

import java.util.List;

import beans.Credentials;

public interface CredentialsDAO {
	
	public List<Credentials> getUsernames();
	public List<Credentials> getCredentials();
	public List<Credentials> login(String username, String password);
	public void addNewCredentials(String username, String password, int x);
	public void deleteCredentials(int x);
	public void updateCredentials(String column, String update, int x);

}

