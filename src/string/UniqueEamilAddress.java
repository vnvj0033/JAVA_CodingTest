package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEamilAddress {

    public static void main(String[] args) {
        UniqueEamilAddress uea = new UniqueEamilAddress();

        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};

        System.out.println(uea.solve1(emails));
    }


    int solve1(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String localName = getLocalName(email);
            String domainName = getDomainName(email);
            uniqueEmails.add(localName + "@" + domainName);
        }
        return uniqueEmails.size();
    }

    public int solve2(String[] emails) {
        Set<String> sentEmails = new HashSet();
        if (emails == null)
            return 0;

        for (String email : emails) {
            String[] parts = email.split("\\@");
            String[] partsForPlus = parts[0].split("\\+");
            String[] partsForDot = partsForPlus[0].split("\\.");
            StringBuilder emailM = new StringBuilder();
            for (String part : partsForDot) {
                emailM.append(part);
            }
            emailM.append("@" + parts[1]);
            sentEmails.add(emailM.toString());
        }
        return sentEmails.size();
    }

    private String getLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.')
                continue;
            else if (email.charAt(i) == '+')
                break;
            else if (email.charAt(i) == '@')
                break;

            sb.append(email.charAt(i));
        }
        return sb.toString();
    }

    private String getDomainName(String email) {
        return email.substring(email.indexOf('@') + 1);
    }
}
