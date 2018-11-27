package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 * Programmers: Hunter Danielson, Brian Withrow. Date: 11/20/2018 Description:
 *
 * Version 1.0:
 *
 * Need to do: Still needs to returns the user id and role.
 *
 * Finished Functionality: Verifies login correctly.
 */

public class User {

  //This contains all the variables and their associated values for the users instance.
  JSONArray AccountsIN;
  int UserNumber;

  //Base Constructor to create AccountsIN User array
  public User() {
    //scanner and file name is constant across all read and write classes
    Scanner scanner = new Scanner(System.in);
    File file = new File("JSONDATA.txt");
    try {
      //this is the Scanner Object being used to create a new instance that reads the file
      //if this is implemented into another file uncomment the other code
      Scanner FileInput = new Scanner(file);

      //StringBuilder is used to parse the JSON file.
      StringBuilder FileInputConcat = new StringBuilder();

      //this while statement checks for  if anything is in the file
      while (FileInput.hasNextLine()) {
        //Concatenated all lines of the code together into one giant string
        FileInputConcat.append(FileInput.nextLine());
      }
      //Creates a Object of the Parser to read the Concatenated lines of string
      JSONParser parser = new JSONParser();

      //You have to declare the right type of JSON<type> and then this code will
      //parce the string that was concatenated and will then create JSONObjects of this
      AccountsIN = (JSONArray) parser.parse(FileInputConcat.toString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    } catch (ParseException e) {
      System.out.println(e.toString());
    }
  }

  //Overloaded Constructor that will set the Students User Number for all other functions.
  public User(int UserNumber) {
    this.UserNumber = UserNumber;
    File file = new File("JSONDATA.txt");
    try {
      Scanner FileInput = new Scanner(file);
      StringBuilder FileInputConcat = new StringBuilder();
      while (FileInput.hasNextLine()) {
        FileInputConcat.append(FileInput.nextLine());
      }
      JSONParser parser = new JSONParser();
      AccountsIN = (JSONArray) parser.parse(FileInputConcat.toString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    } catch (ParseException e) {
      System.out.println(e.toString());
    }
  }

  /**
   * toString to test if Object is being made.
   */
  @Override
  public String toString() {
    return "User{" +
        "UserNumber=" + UserNumber +
        '}';
  }


  /**
   * Account information is array position 0
   */
  //Getter fucntions
  public String getUserEmail(int UserNumber) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String Email = (String) userCredentialsIn.get("Email");
    return Email;
  }

  public String getUsername(int UserNumber) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String UsernameIn = (String) userCredentialsIn.get("Username");
    return UsernameIn;
  }

  public String getPassword(int UserNumber) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String PasswordIn = (String) userCredentialsIn.get("Password");
    return PasswordIn;
  }

  public String getFirstName(int UserNumber) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String FirstName = (String) userCredentialsIn.get("FirstName");
    return FirstName;
  }

  public String getLastName(int UserNumber) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String LastName = (String) userCredentialsIn.get("LastName");
    return LastName;
  }

  public String getRole(int UserNumber) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String Role = (String) userCredentialsIn.get("AccountType");
    return Role;
  }

  public String getMajor(int UserNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String Major = (String) userCredentialsIn.get("Major");
    return Major;

  }

  public String getaboutMeText(int UserNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String aboutMeText = (String) userCredentialsIn.get("aboutMeText");
    return aboutMeText;

  }

  public String getProfileIcon(int UserNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String profileIcon = (String) userCredentialsIn.get("ProfileIcon");
    return profileIcon;

  }

  //setters
  public void setUserEmail(int UserNumber, String Email) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("Email", Email);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setUsername(int UserNumber, String Username) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("Username", Username);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setPassword(int UserNumber, String Password) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("Password", Password);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setFirstName(int UserNumber, String FirstName) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("FirstName", FirstName);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setLastName(int UserNumber, String LastName) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("LastName", LastName);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setMajor(int UserNumber, String major) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("major", major);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAboutMeText(int UserNumber, String aboutMeText) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("aboutMeText", aboutMeText);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setProfileIcon(int UserNumber, String location) {
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);

    userCredentialsIn.put("location", location);

    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  /**
   * Appointment information position 1 on the array
   */
  //Needs TESTING
  public void createAppointment(int UserNumber, String Subject, String TutorName,
      String AppointmentDate, String Location, boolean Attendance) {
    //this parses the users account from the constructor
    //System.out.println("start");
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    //System.out.println("AccountsIN present");
    JSONArray AppointmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //System.out.println("accessed the accounts array");
    //this is the new object that will be added to the array
    JSONObject AppointmentData = new JSONObject();
    //System.out.println("made new object");
    AppointmentData.put("Subject", Subject);
    //System.out.println(Subject);
    AppointmentData.put("TutorName", TutorName);
    //System.out.println(TutorName);
    AppointmentData.put("AppointmentDate", AppointmentDate);
    //System.out.println(AppointmentDate);
    AppointmentData.put("Location", Location);
    //System.out.println(Location);
    AppointmentData.put("Attendance", Attendance);
    //System.out.println(Attendance);
    AppointmentArrayInstance.add(AppointmentData);
    //System.out.println("added");

    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  //getters
  public String getAppointmentDate(int UserNumber, int appointmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray appointmentsArrayIn = (JSONArray) userAccountsIN.get(1);
    JSONObject assignmentDataIn = (JSONObject) appointmentsArrayIn.get(appointmentNumber);
    String assignmentDate = (String) assignmentDataIn.get("AppointmentDate");
    return assignmentDate;
  }

  public String getAppointmentSubject(int UserNumber, int appointmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray appointmentsArrayIn = (JSONArray) userAccountsIN.get(1);
    JSONObject assignmentDataIn = (JSONObject) appointmentsArrayIn.get(appointmentNumber);
    String Subject = (String) assignmentDataIn.get("Subject");
    return Subject;
  }

  public String getAppointmentLocation(int UserNumber, int appointmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray appointmentsArrayIn = (JSONArray) userAccountsIN.get(1);
    JSONObject assignmentDataIn = (JSONObject) appointmentsArrayIn.get(appointmentNumber);
    String Location = (String) assignmentDataIn.get("Location");
    return Location;
  }

  public String getAppointmentTutor(int UserNumber, int appointmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray appointmentsArrayIn = (JSONArray) userAccountsIN.get(1);
    JSONObject assignmentDataIn = (JSONObject) appointmentsArrayIn.get(appointmentNumber);
    String TutorName = (String) assignmentDataIn.get("TutorName");
    return TutorName;
  }

  public boolean getAppointmentAttendance(int UserNumber, int appointmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray appointmentsArrayIn = (JSONArray) userAccountsIN.get(1);
    JSONObject assignmentDataIn = (JSONObject) appointmentsArrayIn.get(appointmentNumber);
    boolean Attendance = (boolean) assignmentDataIn.get("Attendance");
    return Attendance;
  }

  //setters
  public void setAppointmentDate(int UserNumber, int appointmentNumber, Date AppointmentDate) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray appointmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //this is the new object that will be added to the array
    JSONObject individualAppointmentdata = (JSONObject) appointmentArrayInstance
        .get(appointmentNumber);
    individualAppointmentdata.put("AppointmentDate", AppointmentDate);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAppointmentSubject(int UserNumber, int appointmentNumber,
      String Subject) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray appointmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //this is the new object that will be added to the array
    JSONObject individualAppointmentData = (JSONObject) appointmentArrayInstance
        .get(appointmentNumber);
    //potential spelling error
    individualAppointmentData.put("Subject", Subject);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAppointmentLocation(int UserNumber, int appointmentNumber, String Location) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AppointmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //this is the new object that will be added to the array
    JSONObject individualAppointmentData = (JSONObject) AppointmentArrayInstance
        .get(appointmentNumber);
    individualAppointmentData.put("Location", Location);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAppointmentTutor(int UserNumber, int appointmentNumber, String TutorName) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AppointmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //this is the new object that will be added to the array
    JSONObject individualAppointmentData = (JSONObject) AppointmentArrayInstance
        .get(appointmentNumber);
    individualAppointmentData.put("TutorName", TutorName);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAppointmentAttendance(int UserNumber, int appointmentNumber, boolean Attendance) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AppointmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //this is the new object that will be added to the array
    JSONObject individualAppointmentData = (JSONObject) AppointmentArrayInstance
        .get(appointmentNumber);
    individualAppointmentData.put("Attendance", Attendance);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }


  /**
   * Assignment Functions Array position 2 included: Get Set Create Assignments
   */
  public void createAssignment(int UserNumber, String AssigmentName, String AssignmentType,
      String Comments, int MaxPoints, int PointsReceived) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject AssignmentData = new JSONObject();
    AssignmentData.put("AssigmentName", AssigmentName);
    AssignmentData.put("MaxPoint", MaxPoints);
    AssignmentData.put("PointsReceived", PointsReceived);
    AssignmentData.put("Comments", Comments);
    AssignmentData.put("AssigmentType", AssignmentType);
    //adds assignment to the array
    AssignmentArrayInstance.add(AssignmentData);
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());
    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  //getters
  public String getAssignmentName(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(2);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String assignmentName = (String) assignmentDataIn.get("AssignmentName");
    return assignmentName;
  }

  public long getAssignmentMaxPoints(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(2);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    long maxPoints = (long) assignmentDataIn.get("MaxPoint");
    return maxPoints;
  }

  public long getAssignmentPointsRecived(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(2);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    long pointsRecived = (long) assignmentDataIn.get("PointsReceived");
    return pointsRecived;
  }

  public String getAssignmentComments(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(2);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String assignmentComments = (String) assignmentDataIn.get("Comments");
    return assignmentComments;
  }

  public String getAssigmentType(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(2);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String assigmentType = (String) assignmentDataIn.get("AssigmentType");
    return assigmentType;
  }

  //setters
  public void setAssignmentName(int UserNumber, int assignmentNumber, String AssigmentName) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AssigmentName", AssigmentName);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setMaxPoints(int UserNumber, int assignmentNumber, int MaxPoints) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("MaxPoints", MaxPoints);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  //Double check spelling for the assignment points recived when initaly wrtting to it
  public void setPointRecived(int UserNumber, int assignmentNumber,
      int PointRecived) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("PointRecived", PointRecived);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setComments(int UserNumber, int assignmentNumber,
      String Comment) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("Comment", Comment);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAssignmentType(int UserNumber, int assignmentNumber,
      String AssignmetType) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AssignmetType", AssignmetType);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }


  /**
   * need create reviews section position 3
   */
  public void createReview(int UserNumber, String TutorName, String StudentName, String Comments,
      Boolean ReviewFlagged, String ReviewTags, int ReviewValue) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray ReviewArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject ReviewData = new JSONObject();
    ReviewData.put("TutorName", TutorName);
    ReviewData.put("StudentName", StudentName);
    ReviewData.put("Comments", Comments);
    ReviewData.put("ReviewFlagged", ReviewFlagged);
    ReviewData.put("ReviewValue", ReviewValue);
    //adds assignment to the array
    ReviewArrayInstance.add(ReviewData);
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());
    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  //getters
  public String getReviewTutor(int UserNumber, int reviewNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(3);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(reviewNumber);
    String TutorName = (String) assignmentDataIn.get("TutorName");
    return TutorName;
  }

  public String getReviewStudent(int UserNumber, int reviewNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(3);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(reviewNumber);
    String StudentName = (String) assignmentDataIn.get("StudentName");
    return StudentName;
  }

  public String getReviewComment(int UserNumber, int reviewNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(3);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(reviewNumber);
    String Comments = (String) assignmentDataIn.get("Comments");
    return Comments;
  }

  public boolean getReviewFlagged(int UserNumber, int reviewNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(3);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(reviewNumber);
    Boolean ReviewFlagged = (Boolean) assignmentDataIn.get("ReviewFlagged");
    return ReviewFlagged;
  }

  public String getReviewTags(int UserNumber, int reviewNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(3);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(reviewNumber);
    String ReviewTags = (String) assignmentDataIn.get("ReviewTags");
    return ReviewTags;
  }

  public long getReviewValue(int UserNumber, int reviewNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(3);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(reviewNumber);
    long ReviewValue = (long) assignmentDataIn.get("ReviewValue");
    return ReviewValue;
  }

  //setters
  public void setReviewTutor(int UserNumber, int assignmentNumber, String AssigmentName) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AssigmentName", AssigmentName);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setReviewStudent(int UserNumber, int assignmentNumber, int MaxPoints) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("MaxPoints", MaxPoints);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setReviewComment(int UserNumber, int assignmentNumber,
      String Comment) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("Comment", Comment);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setReviewFlagged(int UserNumber, int assignmentNumber,
      String AssignmetType) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AssignmetType", AssignmetType);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setReviewTags(int UserNumber, int assignmentNumber,
      String AssignmetType) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AssignmetType", AssignmetType);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setReviewValue(int UserNumber, int assignmentNumber,
      String AssignmetType) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AssignmetType", AssignmetType);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }


  /**
   * need create quiz section position 4
   */
  public void createQuiz(String QuizQuestion, String AnswerOne, String AnswerTwo,
      String AnswerThree, String AnswerFour, String QuestionAnswer, String UserAnswer) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject AssignmentData = new JSONObject();
    AssignmentData.put("QuizQuestion", QuizQuestion);
    AssignmentData.put("AnswerOne", AnswerOne);
    AssignmentData.put("AnswerTwo", AnswerTwo);
    AssignmentData.put("AnswerThree", AnswerThree);
    AssignmentData.put("AnswerFour", AnswerFour);
    AssignmentData.put("QuestionAnswer", QuestionAnswer);
    AssignmentData.put("UserAnswer", UserAnswer);
    //adds assignment to the array
    AssignmentArrayInstance.add(AssignmentData);
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());
    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  //getters
  public String getQuizQuestion(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String QuizQuestion = (String) assignmentDataIn.get("QuizQuestion");
    return QuizQuestion;
  }

  public String getAnswerOne(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String AnswerOne = (String) assignmentDataIn.get("AnswerOne");
    return AnswerOne;
  }

  public String getAnswerTwo(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String AnswerTwo = (String) assignmentDataIn.get("AnswerTwo");
    return AnswerTwo;
  }

  public String getAnswerThree(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String AnswerThree = (String) assignmentDataIn.get("AnswerThree");
    return AnswerThree;
  }

  public String getAnswerFour(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String AnswerFour = (String) assignmentDataIn.get("AnswerFour");
    return AnswerFour;
  }

  public String getQuestionAnswer(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String QuestionAnswer = (String) assignmentDataIn.get("QuestionAnswer");
    return QuestionAnswer;
  }

  public String getUserAnswer(int UserNumber, int assignmentNumber) {
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    JSONArray assignmnetsArrayIn = (JSONArray) userAccountsIN.get(4);
    JSONObject assignmentDataIn = (JSONObject) assignmnetsArrayIn.get(assignmentNumber);
    String UserAnswer = (String) assignmentDataIn.get("UserAnswer");
    return UserAnswer;
  }

  //setters
  public void setQuizQuestion(int UserNumber, int assignmentNumber, String QuizQuestion) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("QuizQuestion", QuizQuestion);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAnswerOne(int UserNumber, int assignmentNumber, int AnswerOne) {
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AnswerOne", AnswerOne);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAnswerTwo(int UserNumber, int assignmentNumber,
      String AnswerTwo) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AnswerTwo", AnswerTwo);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAnswerThree(int UserNumber, int assignmentNumber,
      String AnswerThree) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AnswerThree", AnswerThree);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setAnswerFour(int UserNumber, int assignmentNumber,
      String AnswerFour) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("AnswerFour", AnswerFour);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setQuestionAnswer(int UserNumber, int assignmentNumber,
      String QuestionAnswer) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("QuestionAnswer", QuestionAnswer);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  public void setUserAnswer(int UserNumber, int assignmentNumber,
      String UserAnswer) {//this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(4);
    //this is the new object that will be added to the array
    JSONObject individualAssignmentData = (JSONObject) AssignmentArrayInstance
        .get(assignmentNumber);
    individualAssignmentData.put("UserAnswer", UserAnswer);
    //print to file and console
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File Edited Successfuly");
  }

  /**
   * Login Functions Are position 5 on the array TEST STILL need to go to last object to logout
   * properly
   */
  public void createLoginObject(int UserNumber, Date Login) {
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray LoginArrayInstance = (JSONArray) UserAccountsIN.get(5);
    //this is the new object that will be added to the array
    JSONObject LoginData = new JSONObject();
    LoginData.put("Login", Login);
    LoginData.put("Logout", Login);
    LoginArrayInstance.add(LoginData);
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());
    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  public void setLogout(int UserNumber, Date Logout) {
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray LoginArrayInstance = (JSONArray) UserAccountsIN.get(5);
    //this is the new object that will be added to the array
    JSONObject LoginData = new JSONObject();
    LoginData.put("Logout", Logout);
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());
    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

}