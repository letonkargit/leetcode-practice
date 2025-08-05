class ValidWordAbbreviation408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int aptr = 0;//abbr ptr
        int wptr = 0;//word ptr
        int a = abbr.length();
        int b = word.length();

        while(aptr < a && wptr < b){
            //Skip matching
            while(aptr < a && wptr < b && abbr.charAt(aptr) == word.charAt(wptr)){
                aptr++;
                wptr++;
            }

            //Collect number
            int num = 0;
            while(aptr < a && Character.isDigit(abbr.charAt(aptr))){
                if(num == 0 && abbr.charAt(aptr) == '0') return false;
                num = (num * 10) + (int) (abbr.charAt(aptr)-'0');//Was missing -'0'
                aptr++;
            }

            //Skip collected numbers
            wptr += num;

            //If mismatch
            if(num == 0 && aptr < a && !Character.isDigit(abbr.charAt(aptr))){
                return false;
            }
        }

        return wptr==b && aptr == abbr.length();
    }
}