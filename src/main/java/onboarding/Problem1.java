package onboarding;

import java.util.List;

class Problem1 {

    static boolean exceptionFlag = false;

    public void checkException(List<Integer> pages){

    }

    public int calculateMaximumAddOrMultiply(int pageNum){
        int result = 0;
        return result;
    }

    public int calculateScore(List<Integer> pages){
        int result = 0;
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 T = new Problem1();

        T.checkException(pobi);
        T.checkException(crong);
        if(exceptionFlag) return -1;

        int pobiScore = T.calculateScore(pobi);
        int crongScore = T.calculateScore(crong);

        if(pobiScore>crongScore) return 1;
        if(pobiScore<crongScore) return 2;
        return 0;
    }
}