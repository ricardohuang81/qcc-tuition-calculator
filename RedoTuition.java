import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class RedoTuition {
  // declare variables related to students
  String name, classes, foreign, matriculated, nyRes, fullTime, partTime;
  double tuition;
  DecimalFormat df = new DecimalFormat("#, ###, ##0.00");
  // method to save student name
  void nameInput() {
    name = JOptionPane.showInputDialog(null, "Enter your name: ", "Hello Student", JOptionPane.PLAIN_MESSAGE);
  }
  // method to convert string to int
  int converter (String input) {
    int result = Integer.parseInt(input);
    return result;
  }
  // method to save number of coures
  int numClasses() {
    classes = JOptionPane.showInputDialog(null, "How many courses are you taking next semester? ", "Welcome to QCC Tuition Calculator " + name + "-san", JOptionPane.QUESTION_MESSAGE);
    return converter(classes);
  }
  // method to calculate credits
  int numCredits() {
    return converter(classes) * 3;
  }
  // method to run while loop to prevent invalid inputs
  void negativeOrOverload() {
    while (numClasses() < 0 || numClasses() > 7) {
      if (numClasses() < 0) {
        JOptionPane.showInputDialog(null, numClasses() + " is an invalid entry. Please enter a valid number.", "Student: " + name, JOptionPane.ERROR_MESSAGE);
      }
      if (numClasses() > 7) {
        JOptionPane.showInputDialog(null, "You want to register for " + numClasses() + " courses in Fall 2019!\nYou cannot register for more than 7 courses per semester, you'll burn out!\nPlease input a smaller number.","Student: " + name, JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  // method to check if foreign or not
  boolean foreignOrNot() {
    foreign = JOptionPane.showInputDialog(null, "Will you be registered as a foreign student in Fall 2019?\nEnter 1 for YES and 2 for NO:", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    int foreignCode = converter(foreign);
    notOneOrTwo(foreign);
    if (foreignCode == 1) {
      return true;
    } else {
      return false;
    }
  }
  // method to run while loop for 1 or 2 input
  void notOneOrTwo (String input) {
    while (input != "1" && input != "2") {
      foreign = JOptionPane.showInputDialog(null, converter(input) + " is an invalid entry\nEnter 1 for YES or 2 for NO", JOptionPane.ERROR_MESSAGE);
    }
  }
  // method to convert int to double
  double doubleConverter(int num) {
    return new Double(num);
  }
  // method to display message if student is registered for 0 classes
  void displayZeroMessage() {
    if (converter(classes) == 0) {
      JOptionPane.showMessageDialog(null, "You're registered for " + converter(classes) + " courses in Fall 2019!\nSo your tuition is currently $" + df.format(0) + ".\nThanks for using our calculator.", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }
  // method to determine full-time or part-time status
  boolean partFullStatus() {
    if (numCredits() >= 12) {
      return true;
    }
    else {
      return false;
    }
  }

  // method to display message if student is part-time or full-time
  void displayPartFullMessage() {
    if (numCredits() >= 12) {
      JOptionPane.showMessageDialog(null, "You're registered for " + converter(classes) + " courses in Fall 2019!\nThat's " + numCredits() + " credits, you'll be a full-time student!", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
    else if (numCredits() == 3) {
      JOptionPane.showMessageDialog(null, "You're registered for " + converter(classes) + " course in Fall 2019!\nThat's " + numCredits() + " credits, you'll be a part-time student!", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(null, "You're registered for " + converter(classes) + " courses in Fall 2019!\nThat's " + numCredits() + " credits, you'll be a part-time student!", "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
  }
  // method to display message if student is foreign
  void displayForeignMessage() {
    if (foreignOrNot() == true) {
      tuition = doubleConverter(numCredits()) * 320;
      JOptionPane.showMessageDialog(null, "You're registered for " + converter(classes) + " course(s) in Fall 2019!\nSince you're a foreign student and taking " + numCredits() + " credits\nYour total tuition will be $" + df.format(tuition), "Student: " + name, JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }
  // method to convert showInputDialog to int
  boolean matriculatedOrNot() {
    matriculated = JOptionPane.showInputDialog(null, "Are you a matriculated student?\nEnter 1 for YES or 2 for NO:", JOptionPane.INFORMATION_MESSAGE);
    int matriculatedCode = converter(matriculated);
    notOneOrTwo(matriculated);
    if (matriculatedCode == 1) {
      return true;
    }
    else {
      return false;
    }
  }
    // method to check if student is NY resident or not
  boolean nyOrNot() {
    nyRes = JOptionPane.showInputDialog(null,
        "Have you lived in NY state for more than 1 year?\nEnter 1 for YES or 2 for NO:",
        JOptionPane.INFORMATION_MESSAGE);
    int nyCode = Integer.parseInt(nyRes);
    notOneOrTwo(nyRes);
    if (nyCode == 1) {
      return true;
    } else {
      return false;
    }
  }
  // method to capture student's name
} // end of class