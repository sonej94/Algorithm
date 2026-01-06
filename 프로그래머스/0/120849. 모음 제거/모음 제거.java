class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        char[] mo = {'a','e','i','o','u'};
        char[] st = my_string.toCharArray();
        
        for(int i= 0; i< st.length; i++){
            Boolean ismo = false;
            
            for(int j =0; j<5; j++){
                if(st[i] == mo[j]){
                    ismo = true;
                    break;
                }
            }

            if(!ismo){
                sb.append(st[i]);
            }
        }

        return sb.toString();
    }
}