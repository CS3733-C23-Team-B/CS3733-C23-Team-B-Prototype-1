package edu.wpi.teamname.database;

import java.util.Scanner;

public class DBInteract {

  public void action() {
    int cmd = 0;
    while (cmd != 5) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a number to indicate what you would like to do:");
      System.out.printf(
          "1 - Display Node and Edge Info \n"
              + "2 - Update Node Coordinates \n"
              + "3 - Update Name of Location Node \n"
              + "4 - Display Help on How to Use the Program \n"
              + "5 - Exit The Program \n");
      cmd = scan.nextInt();
      if (cmd == 5) {
        break;
      }

      scan.close();
    }
  }
}
