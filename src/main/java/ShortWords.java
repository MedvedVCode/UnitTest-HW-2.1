public class ShortWords {
    public void main(String[] args) {
        String[] str = {"aaa", "fsdf", "sad", "qw", "sdffsg", "cv"};
        int count = findShortWords(str);
        String pos = "CAAAABBBBBCCYVVVVSFGJJJGKKKQQQQQCPOYMNNNNEEJJJGGGGGHHYZZ";
        String newpos = zipStr(pos);
        System.out.println(newpos);

    }

    public String zipStr(String pos) {
        if (pos == null || pos.length() == 0) {
            return "";
        }
        char current = pos.charAt(0);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        System.out.println(pos);
        for (int i = 1; i < pos.length(); i++) {
            if (pos.charAt(i) == current) {
                count++;
                if (i == pos.length() - 1) {
                    sb.append(pos.charAt(i));
                    sb.append(count);
                }
            } else {
                sb.append(current);
                if (count > 1) {
                    sb.append(count);
                }
                if (i == pos.length() - 1) {
                    sb.append(pos.charAt(i));
                }
                current = pos.charAt(i);
                count = 1;
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    public int findShortWords(String[] str) {
        if(str==null || str.length==0){
            return -1;
        }
        int minSize = str[0].length();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (minSize > str[i].length()) {
                minSize = str[i].length();
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (minSize == str[i].length()) {
                System.out.print(str[i] + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("count = " + count);
        return count;
    }
}
