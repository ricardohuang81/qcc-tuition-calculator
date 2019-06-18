import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class Tuition {
  public static void main (String args[])
  {
    // varaible for decimal format package
    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    // prompts student to enter name
    String name = JOptionPane.showInputDialog(null, "Enter your name: ", "Hello Student", JOptionPane.PLAIN_MESSAGE);
    // prompts student to enter number of classes
    String inputCourses = JOptionPane.showInputDialog(null, "How many courses are you taking next semester? ", "Welcome to QCC Tuition Calculator " + name + "-san", JOptionPane.INFORMATION_MESSAGE);
    // converts number inputed to integer
    int numOfCourses = Integer.parseInt(inputCourses);
    // while loop to check for negative and numbers that are over 7
    while (numOfCourses < 0 || numOfCourses > 7) {
      if (numOfCourses < 0) {
        inputCourses = JOptionPane.showInputDialog(null, numOfCourses + " is an invalid entry. Please enter a valid number.", "Student: " + name, JOptionPane.ERROR_MESSAGE);
        numOfCourses = Integer.parseInt(inputCourses);
      }
      if (numOfCourses > 7) {
        inputCourses = JOptionPane.showInputDialog(null, "You want to register for " + numOfCourses + " courses in Fall 2019!\nYou cannot register for more than 7 courses per semester, you'll burn out!\nPlease input a smaller number.","Student: " + name, JOptionPane.ERROR_MESSAGE);
        numOfCourses = Integer.parseInt(inputCourses);
      }
    }
    // checks if number of courses registered for is zero
    if (numOfCourses == 0) {
      JOptionPane.showMessageDialog(null, "You're not registered for any courses in Fall 2019!\nSo your tuition is currently $" + df.format(0) + ".\nThanks for using our calculator.", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
    // calculates the number of credits by multiplying the number of courses by 3
    int numOfCredits = numOfCourses * 3;
    // conditional to determine if student is part-time or full-time
    if (numOfCredits >= 12) {
      JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses in Fall 2019!\nThat's " + numOfCredits + " credits, you'll be a full-time student!", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
    else if (numOfCredits == 3) {
      JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " course in Fall 2019!\nThat's " + numOfCredits + " credits, you'll be a part-time student!", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses in Fall 2019!\nThat's " + numOfCredits + " credits, you'll be a part-time student!", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
    // prompts student if they are foreign student
    String foreign = JOptionPane.showInputDialog(null, "Will you be registered as a foreign student in Fall 2019?\nEnter 1 for YES and 2 for NO:", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    // converts character/code inputed to integer
    int foreignCode = Integer.parseInt(foreign);
    // while loop to keep running if student enters an invalid code
    while (foreignCode != 1 && foreignCode != 2) {
        foreign = JOptionPane.showInputDialog(null, foreignCode + " is an invalid entry\nEnter 1 for YES or 2 for NO", JOptionPane.ERROR_MESSAGE);
        foreignCode = Integer.parseInt(foreign);
    }
    // declares tuition variable as a double
    double tuition;
    // if student is foreign, displays message with tuition amount and ends program
    if (foreignCode == 1) {
      tuition = new Double(numOfCredits) * 320;
      JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " course(s) in Fall 2019!\nSince you're a foreign student and taking " + numOfCredits + " credits\nYour total tuition will be $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
    // if student is not foreign, ensuing questions follow
    else if (foreignCode == 2) {
      // input dialog that asks if student is matriculated or not
      String matriculated = JOptionPane.showInputDialog(null, "Are you a matriculated student?\nEnter 1 for YES or 2 for NO:", JOptionPane.INFORMATION_MESSAGE);
      // converts student input to integer
      int matriculatedCode = Integer.parseInt(matriculated);
      // while loop to prevent invalid entry
      while (matriculatedCode != 1 && matriculatedCode != 2) {
        matriculated = JOptionPane.showInputDialog(null, matriculatedCode + " is an invalid entry\nEnter 1 for YES or 2 for NO:", JOptionPane.ERROR_MESSAGE);
        matriculatedCode = Integer.parseInt(foreign);
      }
      // further dialogs and question to display if student is matriculated
      if (matriculatedCode == 1) {
        // asks if student is NY resident
        String ny = JOptionPane.showInputDialog(null, "Have you lived in NY state for more than 1 year?\nEnter 1 for YES or 2 for NO:", JOptionPane.INFORMATION_MESSAGE);
        // converts student input to ingteger
        int nyCode = Integer.parseInt(ny);
        // while loop to prevent invalid activity
        while (nyCode != 1 && nyCode != 2) {
          ny = JOptionPane.showInputDialog(null, nyCode + " is an invalid entry\nEnter 1 for YES or 2 for NO:", JOptionPane.ERROR_MESSAGE);
          nyCode = Integer.parseInt(foreign);
        }
        // further dialog and question to display if student is NY resident
        if (nyCode == 1) {
          // shows tuition message if a student is matriculated, a NY Resident, and a Full-Time student
          if (numOfCredits >= 12) {
            tuition = 2400;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Full-Time), Matriculated, NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
          // shows tuition mnessage if student is matriculated, a NY Resident, and a Part-Time student
          else {
            tuition = new Double(numOfCredits) * 210;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Part-Time), Matriculated, NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
        }
        // further dialog and question if student is not a NY Resident
        else {
          // shows Tuition message if student is Matriculated, a Non-NY Resident, and a Full-Time student
          if (numOfCredits >= 12) {
            tuition = new Double(numOfCredits) * 320;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Full-Time), Matriculated, Non-NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
          // shows Tuition message if student is Matriculated, a Non-NY Resident, and a Part-Time student
          else {
            tuition = new Double(numOfCredits) * 320;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Part-Time), Matriculated, Non-NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
        }
      }
      // further dialog and question if student is NOT matriculated
      else if (matriculatedCode == 2) {
        // checks if student is NY Resident
        String ny = JOptionPane.showInputDialog(null, "Have you lived in NY state for more than 1 year?\nEnter 1 for YES or 2 for NO", JOptionPane.INFORMATION_MESSAGE);
        // converts student input to integer
        int nyCode = Integer.parseInt(ny);
        // while loop to prevent invalid entry
        while (nyCode != 1 && nyCode != 2) {
          ny = JOptionPane.showInputDialog(null, nyCode + " is an invalid entry\nEnter 1 for YES or 2 for NO", JOptionPane.ERROR_MESSAGE);
          nyCode = Integer.parseInt(foreign);
        }
        // further dialog and question if the student is Non-Matriculated, and a NY Resident
        if (nyCode == 1) {
          // shows Tuition message if student is NOT Matriculated, a NY Resident, and a Full-Time student
          if (numOfCredits >= 12) {
            tuition = new Double(numOfCredits) * 265;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Full-Time), Non-Matriculated, NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
          // shows Tuition message if the student is NOT Matriculated, a NY Resident, and a Part-Time student
          else {
            tuition = new Double(numOfCredits) * 265;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Part-Time), Non-Matriculated, NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
        }
        // further dialog and question if the student is Non-Matriculated and a Non-NY Resident
        else if (nyCode == 2) {
          // shows Tuition message if the student is NOT Matriculated, a Non-NY Resident, and a Full-Time student
          if (numOfCredits >= 12) {
            tuition = new Double(numOfCredits) * 420;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Full-Time), Non-Matriculated, NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
          // shows Tuition message if the student is NOT Matriculated, a Non-NY Resident and a Part-Time student
          else {
            tuition = new Double(numOfCredits) * 420;
            JOptionPane.showMessageDialog(null, "You're registered for " + numOfCourses + " courses for Fall 2019!\nStatus: " + numOfCredits + " credits (Part-Time), Non-Matriculated, NY Resident\nYou total tuition is $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
          }
        }
      }
    }
  } // end of main
} // end of Tuition class