package com.example.demo.model;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class EntityDetails {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		int id;
		String userName;
		String password;
		String roles;
		public EntityDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		public EntityDetails(int id, String userName, String password, String roles) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.roles = roles;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getRoles() {
			return roles;
		}
		public void setRoles(String roles) {
			this.roles = roles;
		}
		@Override
		public String toString() {
			return "EntityDetails [id=" + id + ", userName=" + userName + ", password=" + password + ", roles=" + roles
					+ "]";
		}
	



}
