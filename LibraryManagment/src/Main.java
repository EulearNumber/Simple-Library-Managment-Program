import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        libraryManagment LibraryManagment = new libraryManagment();
        Library library = new Library();
        Member[] members = new Member[6];
        libraryOne(library);
        libraryTwo(library);
        members = membersProcess(members);
        Issues(LibraryManagment);

        LibraryQuery libraryQuery = new LibraryQuery();

        libraryQuery.findMostIssuedBook(LibraryManagment.issue);
        System.out.println("The ID of the most issued book is :"+libraryQuery.theMostIssued);
        System.out.println("The name of the most issued book is :"+findNameOfTheBook(libraryQuery.theMostIssued, library));
        libraryQuery.findMostMember(LibraryManagment.issue);
        System.out.println("The ID of the member who issues the most book is :"+libraryQuery.theMostMember);
        System.out.println("The name of the member who issues the most book is :"+findNameOfTheMember(libraryQuery.theMostMember, members));

    }
    public static void libraryOne(Library library) {
        L1FileProcess l1FileProcess = new L1FileProcess();
        int L1Size;
        L1Size = l1FileProcess.findL1Sıze();
        l1FileProcess.assignL1Books(L1Size);
        l1FileProcess.scanL1Books(L1Size);
        l1FileProcess.fillL1Issues(L1Size);

        library.assignL1size(L1Size);
        library.L1books = l1FileProcess.L1books.L1books;
    }
    public static void libraryTwo(Library library) {
        L2FileProcess l2FileProcess = new L2FileProcess();
        int L2Size;
        L2Size = l2FileProcess.findL2Sıze();
        l2FileProcess.assignL2Books(L2Size);
        l2FileProcess.scanL2Books(L2Size);
        l2FileProcess.fillL2Issues(L2Size);

        library.assignL2size(L2Size);
        library.L2books = l2FileProcess.L2books.L2books;
    }
    public static Member[] membersProcess(Member[] member)
    {
        MemberFileProcess memberFileProcess = new MemberFileProcess();
        int MemberSize;
        MemberSize = memberFileProcess.findMembersSıze();
        memberFileProcess.assignMembersSize(MemberSize);
        memberFileProcess.scanMembers(MemberSize);
        memberFileProcess.fillMembers(MemberSize);
        return memberFileProcess.members;
    }
    public static void Issues(libraryManagment libraryManagment)
    {
        issuesFileProcess fileProcess = new issuesFileProcess();
        int L1SIZE, L2SIZE;
        L1SIZE = fileProcess.findL1Sıze();
        fileProcess.assignL1Sıze(L1SIZE);
        fileProcess.scanL1Issues(L1SIZE);
        fileProcess.fillL1Issues(L1SIZE);

        libraryManagment.L1IssueSıze(L1SIZE);
        libraryManagment.issue[0] = fileProcess.L1Issues;

        L2SIZE = fileProcess.findL2Sıze();
        fileProcess.assignL2Sıze(L2SIZE);
        fileProcess.scanL2Issues(L2SIZE);
        fileProcess.fillL2Issues(L2SIZE);

        libraryManagment.L2IssueSıze(L2SIZE);
        libraryManagment.issue[1] = fileProcess.L2Issues;

    }
    public static String findNameOfTheBook(String ID, Library library)
    {
        int flag = 0;
        String name = null;
            for(int i = 0 ; i < library.L1books.length; i++)
            {
                if(Objects.equals(ID, library.L1books[i].getID()))
                {
                    name = library.L1books[i].getTitle();
                    flag = 1;
                }
            }
        if(flag == 1)
        {
            for(int i = 0 ; i < library.L2books.length; i++)
            {
                if(Objects.equals(ID, library.L2books[i].getID()))
                {
                    name = library.L2books[i].getTitle();
                }
            }
        }
        return name;
    }
    public static String findNameOfTheMember(String ID, Member[] member)
    {
        String name = null;
        for (Member value : member) {
            if (Objects.equals(ID, value.getID())) {
                name = value.getName();
            }
        }
        return name;
    }

}