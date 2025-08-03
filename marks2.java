import java.util.Scanner;

public class marks2{

    static final int MATHS = 0;
    static final int CHEMISTRY = 1;
    static final int PHYSICS = 2;

    static int[][] students;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        students = new int[n][3]; 

        System.out.println("\nCommands:");
        System.out.println("a.add [studentID] - Add marks for student");
        System.out.println("b.update [studentID] [subjectID] - Update a mark");
        System.out.println("c.average_s [subjectID] - Get average for subject");
        System.out.println("d.average [studentID] - Get average for student");
        System.out.println("e.total [studentID] - Get total for student");
        System.out.println("f.Grades");
        System.out.println("g.exit - Exit the program");

        while(true){
            System.out.print("\nEnter command: ");
            String command = sc.next();

            if(command.equals("a")){
                int id = sc.nextInt() - 1;
                if(validStudent(id, n)){
                    System.out.print("Enter marks for Maths ");
                    students[id][MATHS] = sc.nextInt();
                    System.out.print("Enter marks for Chemistry ");
                    students[id][CHEMISTRY] = sc.nextInt();
                    System.out.print("Enter marks for Physics ");
                    students[id][PHYSICS] = sc.nextInt();
                    System.out.println("Marks added.");
                }

            }else if(command.equals("b")){
                int id = sc.nextInt() -1;
                int sub = sc.nextInt() -1;
                if(validStudent(id, n) && validSubject(sub)){
                    System.out.print("Enter new mark: ");
                    students[id][sub] = sc.nextInt();
                    System.out.println("Mark updated.");
                }

            }else if(command.equals("c")){
                int sub = sc.nextInt() -1;
                if(validSubject(sub)){
                    double sum = 0;
                    for (int i = 0; i < n; i++){
                        sum += students[i][sub];
                    }
                    System.out.printf("Average for Subject %d: %.2f\n", sub + 1, sum / n);
                }

            }else if(command.equals("d")){
                int id = sc.nextInt()-1;
                if (validStudent(id, n)){
                    double sum = students[id][MATHS]+students[id][CHEMISTRY]+students[id][PHYSICS];
                    System.out.printf("Average for Student %d: %.2f\n", id + 1,sum/3);
                }

            }else if(command.equals("e")){
                int id = sc.nextInt() -1;
                if(validStudent(id, n)){
                    int total = students[id][MATHS] + students[id][CHEMISTRY] + students[id][PHYSICS];
                    System.out.printf("Total for Student %d: %d\n", id + 1, total);
                }
   }else if(command.equals("f")){
          System.out.printf("\n%-10s %-6s %-6s %-6s %-8s %-8s %-8s\n", "StudentID","Maths", "Chemistry", "Physics", "Grade(Maths)", "Grade(Chemistry)", "Grade(Physics)");
                
for(int i=0;i <n;i++){
        System.out.printf("%-10d %-6d %-6d %-6d %-8s %-8s %-8s\n",i + 1,students[i][MATHS],students[i][CHEMISTRY], students[i][PHYSICS], getGrade(students[i][MATHS]),
getGrade(students[i][CHEMISTRY]),getGrade(students[i][PHYSICS]));
                }

            }else if(command.equals("g")){
                System.out.println("Exiting program.");
                break;

            }else{
                System.out.println("Invalid command.");
            }
        }
        sc.close();
    }
static boolean validStudent(int id, int n){
        if(id<0 || id>=n){
            System.out.println("Invalid student ID.");
            return false;
        }
        return true;
    }
static boolean validSubject(int sub){
        if(sub<0 || sub>2){
            System.out.println("Invalid subject ID.Use 1=MathS,2=Chemistry,3=Physics. ");
            return false;
        }
        return true;
    }
static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Fail";
    }

}
