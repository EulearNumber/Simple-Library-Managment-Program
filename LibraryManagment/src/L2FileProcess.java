import java.io.*;
import java.util.Scanner;

public class L2FileProcess {
   File file = new File("Files/L2_Books.csv");
   Library L2books = new Library();
   String[] L2line = null;

    public int findL2Sıze()
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

    public void assignL2Books(int size) {
        this.L2books.assignL2size(size);
    }
    public void scanL2Books(int size)
    {
        this.L2line = new String[size];
        int index = 0;
        if(this.file.exists())
        {
            try {
                Scanner reader = new Scanner(this.file);

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
    public void fillL2Issues(int size)
    {
        for(int i = 0 ; i < size ; i++)
        {
            this.L2books.L2books[i] = new Books();
        }
        for(int i = 0; i < size ; i++)
        {
            String[] bol = this.L2line[i].split(",");
            for (int j = 0; j < bol.length; j++) {
                if (j == 0) {
                    this.L2books.L2books[i].setID(bol[j]);
                } else if (j == 1) {
                    this.L2books.L2books[i].setTitle(bol[j]);
                } else if (j == 2) {
                    this.L2books.L2books[i].setAuthor(bol[j]);
                } else if (j == 3) {
                    this.L2books.L2books[i].setPublisher(bol[j]);
                } else if (j == 4) {
                    this.L2books.L2books[i].setEdition(bol[j]);
                } else if (j == 5) {
                    this.L2books.L2books[i].setGenre(bol[j]);
                } else if (j == 6) {
                    this.L2books.L2books[i].setQuantity(bol[j]);
                }
            }
        }
    }

}
