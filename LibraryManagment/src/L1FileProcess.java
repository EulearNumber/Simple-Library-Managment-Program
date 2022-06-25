import java.io.*;
import java.util.Scanner;

public class L1FileProcess {
    File file = new File("Files/L1_Books.csv");
    Library L1books = new Library();
    String[] L1line = null;

    public int findL1Sıze()
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

    public void assignL1Books(int size) {
        this.L1books.assignL1size(size);
    }
    public void scanL1Books(int size)
    {
        this.L1line = new String[size];
        int index = 0;
        if(this.file.exists())
        {
            try {
                Scanner reader = new Scanner(this.file);

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
            this.L1books.L1books[i] = new Books();
        }
        for(int i = 0; i < size ; i++)
        {
            String[] bol = this.L1line[i].split(",");
            for (int j = 0; j < bol.length; j++) {
                if (j == 0) {
                    this.L1books.L1books[i].setID(bol[j]);
                } else if (j == 1) {
                    this.L1books.L1books[i].setTitle(bol[j]);
                } else if (j == 2) {
                    this.L1books.L1books[i].setAuthor(bol[j]);
                } else if (j == 3) {
                    this.L1books.L1books[i].setPublisher(bol[j]);
                } else if (j == 4) {
                    this.L1books.L1books[i].setEdition(bol[j]);
                } else if (j == 5) {
                    this.L1books.L1books[i].setGenre(bol[j]);
                } else if (j == 6) {
                    this.L1books.L1books[i].setQuantity(bol[j]);
                }
            }
        }
    }
}

