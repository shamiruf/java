package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    
    private boolean  permutation ( int index, char [] str) {
        char[] chars = this.getCharacters();
        for (int i = 0; i < chars.length; i++) {
            str[index] = chars[i];
            
            if (str.length == index + 1) {
                
                boolean itWorks = this.tryOpen(str);
                if (itWorks) {
                    return true;
                } else {
                    continue;
                }
                
            } else {
                boolean isCorrect = this.permutation(index + 1, str);
                if (isCorrect) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    @Override
    public void breakPassword(int sizeOfPassword) {
        // write your code
        if (sizeOfPassword == 0) {
            this.tryOpen(new char [0]);
            return;
        }
        this.permutation(0, new char[sizeOfPassword]);
        
        
    }
    
}
