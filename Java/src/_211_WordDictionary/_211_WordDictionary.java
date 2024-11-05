package _211_WordDictionary;

public class _211_WordDictionary {
}

class WordDictionary {

    TreeNode root;

    static class TreeNode {

        TreeNode[] child;
        int flag;

        public TreeNode() {
            this.child = new TreeNode[26];
            this.flag = 0;
        }

        public void setFlag() {
            this.flag = 1;
        }

        public void addWord(String word, int index) {
            if (index == word.length()) {
                setFlag();
                return;
            }
            if (this.child[word.charAt(index) - 'a'] == null) {
                this.child[word.charAt(index) - 'a'] = new TreeNode();
            }
            this.child[word.charAt(index) - 'a'].addWord(word, index + 1);
        }

        public boolean search(String word, int index){
            if (word.length() == index) {
                return flag == 1;
            }
            if (word.charAt(index) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (this.child[i] != null && this.child[i].search(word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (this.child[word.charAt(index) - 'a'] == null) {
                    return false;
                }
            }
            return this.child[word.charAt(index) - 'a'].search(word, index + 1);
        }
    }

    public WordDictionary() {
        this.root = new TreeNode();
    }

    public void addWord(String word) {
        root.addWord(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */