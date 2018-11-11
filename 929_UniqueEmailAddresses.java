import java.util.Set;
import java.util.HashSet;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<String>();
        for (String email : emails) {
            String[] splitedEmail = email.split("@");
            String localName = splitedEmail[0], domainName = splitedEmail[1];
            localName = localName.split("/+")[0];
            localName = localName.replaceAll(".", "");
            String purifiedEmail = localName + "@" + domainName;
            if (!uniqueEmails.contains(purifiedEmail)) {
                uniqueEmails.add(purifiedEmail);
            }
        }
        return uniqueEmails.size();
    }
}

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(emails));
    }
}
