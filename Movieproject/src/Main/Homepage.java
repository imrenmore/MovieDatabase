package Main;

import java.io.IOException;



public class Homepage {
	public static void main(String[] args) throws IOException {
		String userChoice = "yes";
		keyboardInput input = new keyboardInput();
		Database db = new Database(userChoice);
	
		do{
			pn("\nWelcome to Imren's Database.\nPlease enter a command from a-g:");
			pn("a.) New Entry");
			pn("b.) Search by Actor (by first or last name)");
			pn("c.) Search by Year");
			pn("d.) Search by Runtime (in minutes)");
			pn("e.) Search by Director");
			pn("f.) Search by Title");
			pn("g.) Quit");
			pn("\nEnter command letter(a-g) here>");
			
			
			char choice = input.getKeyboardLine().toLowerCase().trim().charAt(0);
			
			switch(choice){
			case 'a':
				db.addEntry();
				break;
			case 'b':
				pn("Enter actor's first or last name>");
				String actor=input.getKeyboardLine();
				db.searchByActor(actor);
				break;
			case 'c':
				pn("Enter year>");
				int year = Integer.parseInt(input.getKeyboardLine());
				db.searchByYear(year);
				break;
			case 'd':
				pn("Enter runtime(in minutes)>");
				int runTime = Integer.parseInt(input.getKeyboardLine());
				db.searchByRuntime(runTime);
				break;
			case 'e':
				pn("Enter director's first or last name>");
				String director = input.getKeyboardLine();
				db.searchByDirector(director);
				break;
			case 'f':
				pn("Enter title>");
				String title = input.getKeyboardLine();
				db.searchByTitle(title);
				break;
			case 'g':
				pn("You have now quit.");
				System.exit(1);
				input.closeKeyboard();
				break;
				default:
					pn("Invalid input");
			}
			pn("Do you want to continue?: yes/no ");
			userChoice = input.getKeyboardLine();
			
		}while(userChoice.equalsIgnoreCase("yes"));
		
	
		pn("Thank you for using Imren's Movie Database");
	}
	
	
		
		/* Helper method for easy printing on same line */
		public static <E> void p(E item){
			System.out.print(item + " ");
		}
		
		/* Helper method for easy printing with line return */
		public static <E> void pn(E item){
			System.out.println(item);
		}
	
}