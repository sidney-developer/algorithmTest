public class WordDictionary {


    public static void main(String[] args) {
        WordDictionary wd= new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));
    }
    private TrieNode root;

    public class TrieNode {
        boolean end;
        TrieNode[] next;

        public TrieNode () {
            end= false;
            next= new TrieNode[26];
        }
    }

    public WordDictionary() {
        root= new TrieNode();
    }

    public void addWord(String word) {
        char[] chs=word.toCharArray();
        TrieNode temp=root;
        for (char ch:chs) {
            if(temp.next[ch-'a']==null) {
                System.out.println("a");
                temp.next[ch-'a']= new TrieNode();
            }
            temp= temp.next[ch-'a'];
        }
        temp.end=true;
    }

    // need to add a recursion and set an augment to dynamically trace the TrieNode
    public boolean search(String word) {
        // TrieNode cur= root;
        // while (cur!=null) {
        //     System.out.println("a");
        //     cur=cur.next[0];
        // }
        return process(word, root);
    }

    public boolean process (String word, TrieNode node) {
        if (word.length()==0 && node.end) {
            return true;
        }
        char[] chs= word.toCharArray();
        TrieNode temp= node;
        for (int i=0; i< chs.length; i++) {
            if (chs[i]!='.') {
                temp=temp.next[chs[i]-'a'];
                if (temp==null) {
                    return false;
                }
            }else {
                for (int j=0; j<26; j++) {
                    TrieNode cur= temp.next[j];
                    if (cur!=null) {
                        boolean result=process(word.substring(i+1), cur);
                        if(result) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return temp.end;
    }
}
