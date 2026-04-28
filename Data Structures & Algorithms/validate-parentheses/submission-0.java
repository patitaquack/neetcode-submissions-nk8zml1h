class Solution {
    public boolean isValid(String s) {
        //if (s.length() <= 1000){
            //return;

        while (s.contains ("()") || s.contains ("[]") || s.contains ("([{}])") || s.contains ("{}")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");

        }

        return s.isEmpty();
        }
            
         
}
        
    

