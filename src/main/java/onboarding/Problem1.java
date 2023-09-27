package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외사항 -1
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            answer = -1;
        }

        // pobi 결과
        int pobiResult = getPobiResult(pobi);

        // crong 결과
        int crongResult = getCrongResult(crong);

        // 승부
        answer = getAnswer(answer, pobiResult, crongResult);

        return answer;
    }

    private static int getAnswer(int answer, int pobiResult, int crongResult) {
        if(pobiResult > crongResult) {
            answer = 1;
        } else if (pobiResult < crongResult) {
            answer = 2;
        } else if (pobiResult == crongResult) {
            answer = 0;
        }
        return answer;
    }

    private static int getCrongResult(List<Integer> crong) {
        int crongResult = 0;

        for(int i = 0; i < 2; i ++){
            if( (int)(Math.log10(crong.get(i) + 1)) == 2) {
                int mul = (crong.get(i) / 10) * (crong.get(i) % 10);
                int sum = (crong.get(i) / 10) + (crong.get(i) % 10);

                crongResult = sum > mul ? sum : mul;
            } else {
                int sum = (crong.get(i) / 100) + (crong.get(i) / 10) + (crong.get(i) % 10);
                int mul = (crong.get(i) / 100) * (crong.get(i) / 10) * (crong.get(i) % 10);

                crongResult = sum > mul ? sum : mul;
            }
        }
        return crongResult;
    }

    private static int getPobiResult(List<Integer> pobi) {
        int pobiResult = 0;

        for(int i = 0; i < 2; i ++){
            if( (int)(Math.log10(pobi.get(i) + 1)) == 2) {
                int sum = (pobi.get(i) / 10) + (pobi.get(i) % 10);
                int mul = (pobi.get(i) / 10) * (pobi.get(i) % 10);

                pobiResult = sum > mul ? sum : mul;
            } else {
                int sum = (pobi.get(i) / 100) + (pobi.get(i) / 10) + (pobi.get(i) % 10);
                int mul = (pobi.get(i) / 100) * (pobi.get(i) / 10) * (pobi.get(i) % 10);

                pobiResult = sum > mul ? sum : mul;
            }
        }
        return pobiResult;
    }
}