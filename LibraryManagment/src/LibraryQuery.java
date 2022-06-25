public class LibraryQuery {
    String theMostIssued;
    int highestPenalty;
    String theMostMember;
    String fewestBook;
    String theLastMember;

    public void findMostIssuedBook(Issue[][] issues)
    {
        int count = 1;
        int tempcount;
        String temp = null;
        this.theMostIssued = issues[0][0].getBook();
        for(int i = 0 ; i < 2; i++)
        {
            for(int j = 0; j < (issues[i].length - 1) ; j++)
            {
                temp = issues[i][j].getBook();
                tempcount = 0;
                for(int n = 0; n < (issues[i].length) ; n++)
                {
                    if(temp == issues[i][n].getBook())
                    {
                        count++;
                    }
                }
                if(tempcount > count)
                {
                    this.theMostIssued = issues[i][j].getBook();
                    count = tempcount;
                }
            }
        }
    }
    public void findMostMember(Issue[][] issues)
    {
        int count = 1;
        int tempcount;
        String temp = null;
        this.theMostMember = issues[0][0].getMember();
        for(int i = 0 ; i < 2; i++)
        {
            for(int j = 0; j < (issues[i].length - 1) ; j++)
            {
                temp = issues[i][j].getMember();
                tempcount = 0;
                for(int n = 0; n < (issues[i].length) ; n++)
                {
                    if(temp == issues[i][n].getMember())
                    {
                        count++;
                    }
                }
                if(tempcount > count)
                {
                    this.theMostMember = issues[i][j].getMember();
                    count = tempcount;
                }
            }
        }
    }
}
