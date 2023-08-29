package fodler.in.locker;


	import java.io.File;
	import java.util.Scanner;

	public class Main {
	    private static final String FOLDER_PATH = "locked_folder";
	    private static final String PASSWORD = "password123";

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Enter a command: ");
	            System.out.println("1 - Lock Folder");
	            System.out.println("2 - Unlock Folder");
	            System.out.println("3 - Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter password to lock the folder: ");
	                    String enteredPassword = scanner.nextLine();
	                    if (enteredPassword.equals(PASSWORD)) {
	                        lockFolder();
	                        System.out.println("Folder locked successfully.");
	                    } else {
	                        System.out.println("Incorrect password. Folder not locked.");
	                    }
	                    break;
	                case 2:
	                    System.out.println("Enter password to unlock the folder: ");
	                    enteredPassword = scanner.nextLine();
	                    if (enteredPassword.equals(PASSWORD)) {
	                        unlockFolder();
	                        System.out.println("Folder unlocked successfully.");
	                    } else {
	                        System.out.println("Incorrect password. Folder not unlocked.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }

	    private static void lockFolder() {
	        File folder = new File(FOLDER_PATH);
	        if (!folder.exists()) {
	            folder.mkdir();
	        }
	        folder.renameTo(new File(FOLDER_PATH + ".locked"));
	    }

	    private static void unlockFolder() {
	        File lockedFolder = new File(FOLDER_PATH + ".locked");
	        File folder = new File(FOLDER_PATH);
	        if (lockedFolder.exists()) {
	            lockedFolder.renameTo(folder);
	        }
	    }
	}


