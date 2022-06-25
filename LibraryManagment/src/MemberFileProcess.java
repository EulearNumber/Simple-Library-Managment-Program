import java.io.*;
import java.util.Scanner;

public class MemberFileProcess {
    File file = new File("Files/Members.csv");
    Member[] members = null;
    String[] line  = null;
    public int findMembersSıze()
    {
        int lines = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(this.file))) {
            while (lnr.readLine() != null) ;
            lines = lnr.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public void assignMembersSize(int size) {
        this.members = new Member[size];
    }
    public void scanMembers(int size)
    {
        this.line = new String[size];
        int index = 0;
        int counter = 0;
        if(this.file.exists())
        {
            try {
                Scanner reader = new Scanner(this.file);

                while(reader.hasNextLine()) {

                        String line = reader.nextLine();
                        this.line[index] = line;
                        index += 1;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void fillMembers(int size)
    {
        for(int i = 0 ; i < size; i++)
        {
            this.members[i] = new Member();
        }
        for(int i = 0; i < size ; i++) {
                String[] bol = this.line[i].split(",");
                for (int j = 0; j < bol.length; j++) {
                    if (j == 0) {
                        this.members[i].setID(bol[j]);
                    } else if (j == 1) {
                        this.members[i].setName(bol[j]);
                    } else if (j == 2) {
                        this.members[i].setEmail(bol[j]);
                    }
                }
        }
    }
}
