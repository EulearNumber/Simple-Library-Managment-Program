import java.io.*;
import java.util.Scanner;

public class issuesFileProcess {
    Issue[] L1Issues = null;
    Issue[] L2Issues = null;
    String[] L1line = null;
    String[] L2line = null;
    File L1file = new File("Files/L1_Issues.csv");
    File L2file = new File("Files/L2_Issues.csv");
    public int findL1Sıze()
    {
        int lines = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(this.L1file))) {
            while (lnr.readLine() != null) ;
            lines = lnr.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public void assignL1Sıze(int size)
    {
        this.L1Issues = new Issue[size];
    }
    public void scanL1Issues(int size)
    {
        this.L1line = new String[size];
        int index = 0;
        if(this.L1file.exists())
        {
            try {
                Scanner reader = new Scanner(this.L1file);

                while(reader.hasNextLine()) {
                    String line = reader.nextLine();
                    this.L1line[index] = line;
                    index += 1;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void fillL1Issues(int size)
    {
        for(int i = 0 ; i < size ; i++)
        {
            this.L1Issues[i] = new Issue();
        }
        for(int i = 0; i < size ; i++)
        {
            String[] bol = this.L1line[i].split(",");
            for (int j = 0; j < bol.length; j++) {
                if (j == 0) {
                    this.L1Issues[i].setID(bol[j]);
                } else if (j == 1) {
                    this.L1Issues[i].setMember(bol[j]);
                } else if (j == 2) {
                    this.L1Issues[i].setBook(bol[j]);
                } else if (j == 3) {
                    this.L1Issues[i].setIssueDate(bol[j]);
                } else if (j == 4) {
                    this.L1Issues[i].setReturningDate(bol[j]);
                }
            }
        }
    }
    public int findL2Sıze() {
        int lines = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(this.L2file))) {
            while (lnr.readLine() != null) ;
            lines = lnr.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public void assignL2Sıze(int size)
    {
        this.L2Issues = new Issue[size];
    }
    public void scanL2Issues(int size)
    {
        this.L2line = new String[size];
        int index = 0;
        if(this.L2file.exists())
        {
            try {
                Scanner reader = new Scanner(this.L2file);

                while(reader.hasNextLine()) {
                    String line = reader.nextLine();
                    this.L2line[index] = line;
                    index += 1;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void fillL2Issues(int size) {
        for (int i = 0; i < size; i++) {
            this.L2Issues[i] = new Issue();
        }
        for (int i = 0; i < size; i++) {
            String[] bol = this.L2line[i].split(",");
            for (int j = 0; j < bol.length; j++) {
                if (j == 0) {
                    this.L2Issues[i].setID(bol[j]);
                } else if (j == 1) {
                    this.L2Issues[i].setMember(bol[j]);
                } else if (j == 2) {
                    this.L2Issues[i].setBook(bol[j]);
                } else if (j == 3) {
                    this.L2Issues[i].setIssueDate(bol[j]);
                } else if (j == 4) {
                    this.L2Issues[i].setReturningDate(bol[j]);
                }
            }
        }
    }


}
