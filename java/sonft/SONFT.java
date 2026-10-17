package sonft;

import java.util.HashMap;

public final class SONFT {
    public static String compile(String sonft) {
        String[] lines = sonft.lines().toArray(String[]::new);
        int index = 0;

        HashMap<String, String> defines = new HashMap<>();
        while(index < lines.length) {
            String curline = lines[index];
            if(curline.startsWith("@define")) {
                curline = curline.substring("@define").trim();
                if(curline.equals("")) {
                    throw new SONFTSyntaxErrorException("" + index + ": Not declared properly");
                }
                String[] defcomps = curline.trim().split("\\s+");
                if(defcomps.length > 3 || < 3) {
                    throw new SONFTSyntaxErrorException("" + index + ": Not declared properly");
                }
                if(!defcomps[1].chars().allMatch(Character::isLetterOrDigit) ||
                   !defcomps[3].chars().allMatch(Character::isLetterOrDigit)) {
                    throw new SONFTSyntaxErrorException("" + index + ":  Not letter or digit");
                }
                if(!defcomps[2].equals("->")) {
                    throw new SONFTSyntaxErrorException("" + index + ": Is not arrow");
                }
            }
            index++
        }
    }

    public static class SONFTSyntaxErrorException extends Exception {
        public SONFTSyntaxErrorException(String err) {
            super(err);
        }
    }
}