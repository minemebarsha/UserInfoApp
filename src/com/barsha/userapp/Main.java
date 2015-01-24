package com.barsha.userapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int i;
		int j = 0;
		int k;
		ArrayList<UserBean> user_list = new ArrayList<UserBean>();
		Utility utility = new Utility();
		UserBean bean = new UserBean();

		while (true) {

			if (user_list.isEmpty()) {
				j = 0;
				Utility.printCommand(j);
			} else {
				j = 1;
				Utility.printCommand(j);
			}

			try {

				Scanner scanner = new Scanner(System.in);
				i = scanner.nextInt();

				switch (i) {

				case 0:

					System.out
							.println("successfully exited...abar ashben :D :D");
					return;

				case 1:

					if (!user_list.isEmpty()) {

						Utility.printInfo(user_list);

					} else {

						System.out.println("empty user list");
					}
					break;

				case 2:

					if (user_list.isEmpty()) {
						user_list.add(Utility.insertInfo());
						System.out.println("insertion completed");
					} else {
						while (true) {
							bean = Utility.insertInfo();
							if (!Utility.checkUser(bean, user_list)) {
								user_list.add(bean);
								System.out.println("insertion completed");
								break;
							} else {
								System.out
										.println("email address already exist");
							}
						}
					}

					break;

				case 3:

					if (user_list.isEmpty()) {
						System.out.println("empty user list");
					} else {

						Utility.printInfo(user_list);

						System.out.println("enter the user no. to update:");
						i = scanner.nextInt();
						
						utility.updateInfo(i, user_list);

					}
					
					break;

				case 4:

					if (user_list.isEmpty()) {
						System.out.println("empty user list");
					} else {

						Utility.printInfo(user_list);

						System.out.println("enter the user no. to delete:");
						i = scanner.nextInt();
						user_list.remove(i - 1);
						System.out.println("successfully deleted");
					}

					break;
					
				default:

					if (user_list.isEmpty()) {
						k = 0;
					} else {
						k = 1;
					}
					System.out.println("outor..please follow menu :@ :@");
					break;
				}
			} catch (Exception e) {
				System.out.println("please enter only number..try again..");
			}

		}

	}

}
