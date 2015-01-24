package com.barsha.userapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

	public static UserBean insertInfo() {

		UserBean user = new UserBean();
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter user name: ");
		user.setUsername(scanner.nextLine());

		user.setEmail(emailValidation());
		user.setPassword(passwordValidation());

		return user;
	}

	public static String passwordValidation() {

		final String password_regex = "^[A-za-z\\d_-]{8,}$";
		Scanner scanner = new Scanner(System.in);
		String string;

		Pattern pattern = Pattern.compile(password_regex);

		while (true) {

			System.out.println("enter password: ");
			string = scanner.nextLine();
			Matcher matcher = pattern.matcher(string);

			if (matcher.matches()) {
				break;
			} else {
				System.out.println("password length should be at least 8 and special character isn`t allowed except _ , -");
			}

		}
		return string;

	}

	public static String emailValidation() {

		final String email_regex = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";
		Scanner scanner = new Scanner(System.in);
		String string;

		Pattern pattern = Pattern.compile(email_regex);

		while (true) {

			System.out.println("enter email address: ");
			string = scanner.nextLine();
			Matcher matcher = pattern.matcher(string);

			if (matcher.matches()) {
				break;
			} else {
				System.out.println("please enter correct email address");
			}

		}
		return string;
	}

	public static boolean checkUser(UserBean bean, ArrayList<UserBean> user_list) {

		for (UserBean userBean : user_list) {
			String string = userBean.toString();
			if (userBean.equals(bean)) {
				return true;
			}
		}
		return false;

	}

	public void updateInfo(int i, ArrayList<UserBean> user_list) {
		
		UserBean bean = new UserBean();
		
		while (true) {
			
			bean = this.insertInfo();
			
			if (!user_list.get(i - 1).getEmail().equals(bean.getEmail())) {
				
				if (!Utility.checkUser(bean, user_list)) {
					
					user_list.set(i - 1, bean);
					System.out.println("successfully updated");
					break;
					
				} else {
					
					System.out.println("email address already exist");
				}

			} else {
				
				user_list.set(i - 1, bean);
				System.out.println("successfully updated");
				break;
				
			}
		}

	}

	public static void printCommand(int i) {
		if (i == 0) {
			System.out.println("menu:");
			System.out.println("enter 1 to see the user list");
			System.out.println("enter 2 to insert a user");
			System.out.println("enter 0 for exit");
		} else if (i == 1) {
			System.out.println("menu:");
			System.out.println("enter 1 to see the user list");
			System.out.println("enter 2 to insert a user");
			System.out.println("enter 3 to update a user info");
			System.out.println("enter 4 to delete a user info");
			System.out.println("enter 0 for exit");
		} else {
			return;
		}
	}

	public static void printInfo(ArrayList<UserBean> user_list) {

		int i = 1;
		System.out.println("user list::");

		for (UserBean userBean : user_list) {

			System.out.println("user no. " + i + ":");
			System.out.println("user name-> " + userBean.getUsername() + ", "
					+ "email address-> " + userBean.getEmail() + ", "
					+ "password-> " + userBean.getPassword());
			i++;
		}

	}

}
