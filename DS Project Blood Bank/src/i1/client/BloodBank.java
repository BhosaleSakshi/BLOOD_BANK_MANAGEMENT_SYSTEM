package i1.client;

import java.util.Scanner;
import i1.logic.Receiver;
import i1.logic.Donor;
import java.util.LinkedList;
import java.util.Queue;

public class BloodBank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Donor> donarlist = new LinkedList<>();
		Queue<Donor> Apositive = new LinkedList<>();
		Queue<Donor> Bpositive = new LinkedList<>();
		Queue<Donor> Opositive = new LinkedList<>();
		Queue<Donor> ABpositive = new LinkedList<>();
		Queue<Donor> Anegative = new LinkedList<>();
		Queue<Donor> Bnegative = new LinkedList<>();
		Queue<Donor> Onegative = new LinkedList<>();
		Queue<Donor> ABnegative = new LinkedList<>();
		System.out.println(
				"********************************************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\tLIFE LINE BLOOD BANK");
		System.out.println(
				"********************************************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\tWELCOME");
		int flag1 = 0;
		int ch = 0;
		int choice = 0;
		do {
			System.out.println(
					"____________________________________________________________________________________________________________________________________________");
			System.out.println(
					"\n\t\t\t1.Donation Department  \n\t\t\t2.Transfusion Department \n\t\t\t3.Info About Process ");
			System.out.print("\n\t\t\t\tPlease Choose Your Department? : ");
			choice = sc.nextInt();
			System.out.println(
					"____________________________________________________________________________________________________________________________________________");

			switch (choice) {
			case 1:

				do {
					System.out.println(
							"\n1.Register  \n2.Test Blood Samples \n3.Test Results And Info \n4.Total Storage \n5.Donar List \n6.Exit");
					System.out.print("\t\t\t\tWhat to you want ? : ");
					ch = sc.nextInt();

					switch (ch) {
					case 1:
						System.out.print("\nPlease Enter Donor's Weight : ");
						int weight = sc.nextInt();
						System.out.print("Please Enter Donor's Age    : ");
						int age = sc.nextInt();
						if (weight < 45) {
							System.out.println(
									"\n\t\t\t\t\tSorry!! Donor can not donate his blood since your weight is less than 45 \n\t\t\t\t\tDonar need to be phisically strong and healthy. Thank you !!!");
							System.out.println(
									"____________________________________________________________________________________________________________________________________________");
						} else if (age < 18 || age > 65) {
							System.out.println(
									"\n\t\t\t\t\tSorry!! Donor can not donate your blood since his age should be in 18 - 65 \n\t\t\t\t\tDonar need to be phisically strong and healthy. Thank you !!!");
							System.out.println(
									"____________________________________________________________________________________________________________________________________________");
						} else {
							System.out.println("\nNow You Can Register :");
							sc.nextLine();
							System.out.print("Enter Donor's Name     : ");
							String n = sc.nextLine();
							System.out.print("Enter Donor's Phone No.: ");
							Long p = sc.nextLong();
							Donor Donor = new Donor(n, p);
							donarlist.add(Donor);
							System.out.println(
									"\n\t\t\t\t\t\tDonor's Blood Sample Will Be Tested soon \n\t\t\t\t\t\tWait for 10 minitues");
							System.out.println(
									"____________________________________________________________________________________________________________________________________________");
						}
						break;

					case 2:
						System.out
								.println("\n\t\t\t	# # # # # # # # # # # # Test Blood Sample # # # # # # # # # # # #");

						if (donarlist.isEmpty() == false) {
							for (int i = 0; i < donarlist.size(); i++) {
								if (donarlist.get(i).getBloodgrp() == null) {
									System.out.println("\n\t\t\t\t\tTest Result of 	-  " + donarlist.get(i).getName());
									System.out.print("\t\t\t\t\tHemoglobin Level  : ");
									double hb = sc.nextDouble();
									System.out.print("\t\t\t\t\tBlood group       : ");
									String group = sc.next();
									System.out.println(
											"____________________________________________________________________________________________________________________________________________");
									donarlist.get(i).setBloodgrp(group);
									donarlist.get(i).setHb(hb);
								} else {
									System.out.println("\n\t\t\t\t" + donarlist.get(i).getName()
											+ "'s Blood Is Already Tested ! See Test Results for Test Info!");
									System.out.println(
											"____________________________________________________________________________________________________________________________________________");

								}
								flag1 = 1;
							}

						} else {
							System.out.println("\n\t\t\t\t\tThere Is No Blood To Do Test On It \n"
									+ "\t\t\t\t\tSince No One Has Donated Blood !!!!");
							System.out.println(
									"-------------------------------------------------------------------------------------------------------------------------------------------");
						}
						break;
					case 3:
						System.out.println("\n\t\t\t	# # # # # # # # # # # #  Test Result # # # # # # # # # # # # ");
						if (donarlist.isEmpty() == false) {
							int flag = 0;
							;
							for (int i = 0; i < donarlist.size(); i++) {
								if (donarlist.get(i).getBloodgrp() != null) {
									if (donarlist.get(i).getHb() >= 13) {
										System.out.println("\n\t\t\t\t\t" + donarlist.get(i).getName()
												+ " Is Eiligible To Donate his Blood  :) ");
										System.out.println(
												"____________________________________________________________________________________________________________________________________________");

										flag = 0;
										if (donarlist.get(i).getStatus() == 0) {
											String group = donarlist.get(i).getBloodgrp();
											if (group.equalsIgnoreCase("a+")) {
												Apositive.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("b+")) {
												Bpositive.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("o+")) {
												Opositive.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("ab+")) {
												ABpositive.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("a-")) {
												Anegative.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("b-")) {
												Bnegative.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("o-")) {
												Onegative.add(donarlist.get(i));
											} else if (group.equalsIgnoreCase("ab-")) {
												ABnegative.add(donarlist.get(i));
											}
											donarlist.get(i).setStatus(1);
										}
									} else {

										System.out.println("\n\t\t\t\t\t" + donarlist.get(i).getName()
												+ " Can Not Donate their Blood Since its HB Is Low !! \n\t\t\t\t\tPlease Convey To "
												+ donarlist.get(i).getName()
												+ " That \n\t\t\t\t   !   They Must Get Checked From Physician To Be Healthy   !");
										System.out.println(
												"____________________________________________________________________________________________________________________________________________");

										flag = 1;
									}

									if (flag == 1) {
										donarlist.remove(i);
										i = i - 1;
									}
								} else {
									System.out.println("\n\t\t\t\t\t" + donarlist.get(i).getName()
											+ "'s Blood Sample Has Not Tested !!!!!!!");
									System.out.println(
											"-------------------------------------------------------------------------------------------------------------------------------------------");
								}
							}

						} else {
							System.out
									.println("\n\t\t\t\tThere Is No Result Since There Is No Blood To Do Test On It \n"
											+ "\t\t\t\tcause No One Has Donated Blood !!!!");
							System.out.println(
									"--------------------------------------------------------------------------------------------------------------------------------------------");
						}

						break;

					case 4:
						System.out.println("\n\t\t\t	# # # # # # # # # # # #  STORAGE  # # # # # # # # # # # # ");
						// int flag = 0;
						if (donarlist.isEmpty() == false) {
							int remainTest = donarlist.size() - (Apositive.size() + Bpositive.size() + Opositive.size()
									+ ABpositive.size() + Anegative.size() + Bnegative.size() + Onegative.size()
									+ ABnegative.size());
							System.out.println(
									"\n\t\t\t\tUnits Of Total Blood Package In Storage Are : " + donarlist.size());
							System.out.println("\t\t\t\tRemaining Blood Package To Test : " + remainTest);
							System.out.println("\n\t\tNumber Of Packages Of Each Blood Group  : ");
							System.out.println("\t\tBlood Group A+  : " + Apositive.size());
							System.out.println("\t\tBlood Group B+  : " + Bpositive.size());
							System.out.println("\t\tBlood Group O+  : " + Opositive.size());
							System.out.println("\t\tBlood Group AB+ : " + ABpositive.size());
							System.out.println("\t\tBlood Group A-  : " + Anegative.size());
							System.out.println("\t\tBlood Group B-  : " + Bnegative.size());
							System.out.println("\t\tBlood Group O-  : " + Onegative.size());
							System.out.println("\t\tBlood Group AB- : " + ABnegative.size());
							System.out.println(
									"____________________________________________________________________________________________________________________________________________");

						} else {
							if (flag1 == 0) {
								System.out.println(
										"\n\t\t\t\tPlease First Test The Blood Samples And Then Check Storage ");
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------------------");

							} else {
								System.out.println("\n				There Is No Blood To Storage !!!");
								System.out.println(
										"____________________________________________________________________________________________________________________________________________");

							}
						}

						break;

					case 5:

						System.out.println("\n\t\t\t	# # # # # # # # # # # #  DONAR LIST  # # # # # # # # # # # # ");
						if (donarlist.isEmpty() == false) {
							String checkStatus = "TEST Done & Result Seen ";
							for (int i = 0; i < donarlist.size(); i++) {
								if (donarlist.get(i).getStatus() == 0) {
									checkStatus = " TEST Pending / Result Are Not Out";

								}
								System.out.println("\n\t\t\t Name : " + donarlist.get(i).getName()
										+ "\n\t\t\t Phone No. : " + donarlist.get(i).getPhoneno()
										+ "\n\t\t\t Test Status : " + checkStatus);
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------------------");

							}
						} else {
							System.out.println("\n\t\t\t\t\t\tDonar List Is Empty !!!!");
							System.out.println(
									"-------------------------------------------------------------------------------------------------------------------------------------------");

						}
						System.out.println(
								"____________________________________________________________________________________________________________________________________________");

						break;
					case 6:
						ch = 0;
						break;
					default:
						System.out.println("\n					Invalide Choice !!!");
						break;
					}
				} while (0 < ch && ch < 7);

				break;
			case 2:
				Queue<Receiver> emergency = new LinkedList<Receiver>();
				Queue<Receiver> scheduled = new LinkedList<Receiver>();
				int flag = 0;

				int option = 0;
				do {
					System.out.println("\n1.Go To Counter   \n2.Check and Give  \n3.Exit");
					System.out.print("\t\t\t\tSelet Work : ");
					option = sc.nextInt();

					switch (option) {
					case 1:
						String name2 = null;
						sc.nextLine();
						System.out.print("\nEnter Patient's Name: ");
						name2 = sc.nextLine();

						System.out.println("1.Is Blood Needed For Emergency ? ");
						System.out.println("2.Is Blood For Scheduled Operations ?");
						int z = sc.nextInt();

						if (z == 1) {
							System.out.print("\nPatient's Blood Group : ");
							String gr = sc.next();
							System.out.print("Patient's Age         : ");
							int ag = sc.nextInt();
							Receiver r1 = new Receiver(name2, ag, gr);
							emergency.add(r1);
						} else {

							System.out.print("\nPatient Blood Group : ");
							String gr = sc.next();
							System.out.print("Patient Age         : ");
							int ag = sc.nextInt();
							Receiver r1 = new Receiver(name2, ag, gr);
							scheduled.add(r1);
						}
						System.out.println(
								"____________________________________________________________________________________________________________________________________________");

						flag = 1;
						break;

					case 2:
						int flag2 = 2;
						while (emergency.isEmpty() == false) {
							System.out.println("\n\tName Of Patient : " + emergency.peek().getName());
							System.out.println("\tBlood Group Of Patient : " + emergency.peek().getBloodgrup());
							for (int i = 0; i < emergency.size(); i++)
								;
							if (emergency.peek().getBloodgrup().equalsIgnoreCase("a+")) {
								if (Apositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Apositive.peek().getName());
									System.out
											.println("\t\t\tBlood group of Donor : " + Apositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("a-")) {
								if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("b+")) {
								if (Bpositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bpositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bpositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("b-")) {
								if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("AB+")) {
								if (ABpositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + ABpositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + ABpositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (ABnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + ABnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + ABnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Apositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Apositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Apositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bpositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bpositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bpositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("AB-")) {
								if (ABnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + ABnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + ABnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("O+")) {
								if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (emergency.peek().getBloodgrup().equalsIgnoreCase("O-")) {
								if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							emergency.poll();
							if (flag2 == 0) {
								System.out.println(
										"\t\t\tAbove information is of the donor whose blood matched you. \n\t\t\t\tGet well soon!!");
							} else if (flag2 == 1) {
								System.out
										.println("\t\t\tSorry, we dont have a blood that can match patient's blood!!");
							}
						}
						while (scheduled.isEmpty() == false) {
							System.out.println("\n\tName Of Patient : " + scheduled.peek().getName());
							System.out.println("\tBlood Group Of Patient : " + scheduled.peek().getBloodgrup());

							if (scheduled.peek().getBloodgrup().equalsIgnoreCase("a+")) {
								if (Apositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Apositive.peek().getName());
									System.out
											.println("\t\t\tBlood group of Donor : " + Apositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("a-")) {
								if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Anegative.poll().getBloodgrp());
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("b+")) {
								if (Bpositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bpositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bpositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("b-")) {
								if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("AB+")) {
								if (ABpositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + ABpositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + ABpositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (ABnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + ABnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + ABnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Apositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Apositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Apositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bpositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bpositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bpositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("AB-")) {
								if (ABnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + ABnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + ABnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Anegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Anegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Anegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Bnegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Bnegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Bnegative.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("O+")) {
								if (Opositive.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Opositive.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Opositive.poll().getBloodgrp());
									flag2 = 0;
								} else if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							else if (scheduled.peek().getBloodgrup().equalsIgnoreCase("O-")) {
								if (Onegative.isEmpty() == false) {
									System.out.println("\t\t\tName of Donor : " + Onegative.peek().getName());
									System.out
											.println("\t\t\tBlood Group of Donor : " + Onegative.poll().getBloodgrp());
									flag2 = 0;
								} else {
									flag2 = 1;
								}
							}

							scheduled.poll();

							if (flag2 == 0) {
								System.out.println(
										"\t\t\tAbove information is of the donor whose blood matched you. \n\t\t\t\tGet well soon!!");
							} else if (flag2 == 1) {
								System.out
										.println("\t\t\tSorry, we dont have a blood that can match patient's blood!!");
							}
						}
						if (flag2 == 2) {
							System.out.println("\n\t\t\t\t\t* PLEASE GO TO COUNTER FIRST *");
						}
						System.out.println(
								"____________________________________________________________________________________________________________________________________________");

						break;

					case 3:
						option = 4;
						break;

					}
				} while (option < 4);

				break;
			case 3:
				System.out.println(
						"\n   Basic Requirements for Donation \n\t+ Donor must be in good health and feeling well\n"
								+ "\t+ Donor must be at least 18 years old and less than 65\n"
								+ "\t+ Donor must weigh at least 45 Kgs");
				System.out.print("\n\t\tIf Donor does not satisfy these requirements then ");
				System.out.println("Person is NOT eligible to Donate !");
				System.out.println("\n\t\tIf Donor satisfy these requirements then ");
				System.out.println("\t\tDonar's blood sample is taken and tested ");
				System.out.println("\n\t\t\tDuring TEST Hemoglobin and Blood groups are tested tested");
				System.out.println("\t\t\t\tIf Hemoglobin (HB) < 13 then Person can NOT Donate !");
				System.out.println("\t\t\t\tIf Hemoglobin (HB) >= 13 then Donar is eligible to Donate ");
				System.out.println("\n\t\t\tThen Test Result are displayed");
				System.out.println("\n\t\t\tAccording to Result Blood Packages are sorted and stored in Storage");
				System.out.println("\n\n\n INFORMATION ABOUT BLOOD GROUPS");
				System.out.println("\n\n|------------|--------------|-------------|");
				System.out.println("| BLOOD TYPE |    GIVES     |  RECIEVES   |");
				System.out.println("|------------|--------------|-------------|");
				System.out.println("|     A+     |    A+,AB+    | A+,A-,O+,O- |");
				System.out.println("|     O+     | O+,A+,B+,AB+ |    O+,O-    |");
				System.out.println("|     B+     |    B+,AB+    | B+,B-,O+,O- |");
				System.out.println("|     AB+    |      AB+     |  Everyone   |");
				System.out.println("|     A-     | A+,A-,AB+,AB-|    A-,O-    |");
				System.out.println("|     O-     |   Everyone   |     O-      |");
				System.out.println("|     B-     | B+,B-,AB+,AB-|    B-,O-    |");
				System.out.println("|     AB-    |    AB+,AB-   | AB-,A-,B-,O-|");
				System.out.println("|------------|--------------|-------------|");

				break;

			}
		} while (choice < 4);

	}

}
