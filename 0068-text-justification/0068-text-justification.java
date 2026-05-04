class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, len[] = new int[n];
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = words[i].length(), next = i + 1;
            while (next < n && words[next].length() + sum + 1 <= maxWidth) {
                sum += words[next].length() + 1;
                next++;
            }
            int space = (next - i - 1);
            if (space > 0 && next!=n) {
                int spacex = ((maxWidth - sum + space) / (space)), extras = ((maxWidth - sum + space) % (space));
                // 
                String temp = "";
                for (int j = i; j < next; j++) {
                    temp += words[j];
                    if (j != next - 1) {
                        for (int k = 0; k < spacex; k++)
                            temp += " ";
                        if (extras > 0) {
                            temp += " ";
                            extras--;
                        }
                    }
                }
                ans.add(temp);
            } else if (sum <= maxWidth) {
                int spacex = maxWidth - sum;
                String temp =words[i];
                for (int j = i+1; j < next; j++) {
                temp += " "+words[j];
                }
                while (spacex-- > 0) {
                    temp += " ";
                }
                ans.add(temp);
            }
            i = next - 1;
        }
        return ans;
    }
}