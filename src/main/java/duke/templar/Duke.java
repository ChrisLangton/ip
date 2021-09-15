package duke.templar;

import duke.exception.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Duke {

    public static final String MESSAGE_DIVIDER = "____________________________________________________________";
    public static final String FILE_PATH = "data/tasks.txt";
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) throws CommandInvalidException, DeadlineInvalidFormatException, TodoInvalidFormatException, EventInvalidFormatException, TaskNumberInvalidException, NoSuchTaskException, IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println(MESSAGE_DIVIDER);
        System.out.println("[The Templar:]");
        System.out.println("Greetings, Hero. Meet Vector Unit 202 - codename DUKE.\n" + "The state of the art AI assassin you requested. Give DUKE a mission, and it shall be done.");
        System.out.println(MESSAGE_DIVIDER);

        DataManager activateDataManager = new DataManager(FILE_PATH);
        TaskManager activateTaskManager = activateDataManager.loadSave(tasks);

        boolean endSession = false;

        while (!endSession) {

            System.out.println(MESSAGE_DIVIDER);
            System.out.println("[Hero:]");

            String line; // the task
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            
            activateTaskManager.processInput(line, tasks);

            if (line.contains("bye")) {
                activateDataManager.writeSave(activateTaskManager);
                System.out.println(MESSAGE_DIVIDER);
                System.out.println("[The Templar:]\n" + "DUKE shall carry out his mission. Farewell, Hero.");
                System.out.println(MESSAGE_DIVIDER);
                endSession = true;
            }
        }
    }

}
