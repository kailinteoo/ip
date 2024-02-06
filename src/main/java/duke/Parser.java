package duke;

import java.util.ArrayList;
/*
 * Deals with making sense of the user command
 */


public class Parser {
    
    private String userInput;
    private ArrayList<Task> myList;
    private Ui ui;

    public Parser(String userInput, ArrayList<Task> myList) {
        this.userInput = userInput;
        this.myList = myList;
        this.ui = new Ui();
    }

    public boolean parseCommand() {

        // Split input into "command" and "parameters"
        String[] parts = userInput.split(" ", 2);
        String command = parts[0];
        String restOfInputs = parts.length > 1 ? parts[1] : "";


        if(command.equals("list")) {
            /*
            * Displays the list of tasks in the MyList
            */
            TaskList taskList = new TaskList(myList);
            taskList.list();
            return true;

        } else if(command.equals("bye")) {
            /*
            * Save the new task in MyList before exiting the Duke Program
            */
            return false;

        } else if (parts.length == 1) {

            ui.commandError();
            return true;

        } else if(command.equals("unmark")) {
            TaskList taskList = new TaskList(myList);
            taskList.unmarkList(parts);
            return true;

        } else if (command.equals("mark")) {
            TaskList taskList = new TaskList(myList);
            taskList.markList(parts);
            return true;

        } else if (command.equals("delete")){
            TaskList taskList = new TaskList(myList);
            taskList.remove(parts);
            return true;

        } else {

            TaskList taskList = new TaskList(myList);
            taskList.add(command, restOfInputs);
            return true;
            
        }
    }
 }

 