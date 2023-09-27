package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION_NUMBER = -1;
    private static final int DRAW_NUMBER = 0;
    private static final int WIN_POBI_NUMBER = 1;
    private static final int WIN_CRONG_NUMBER = 2;
    private static final int FIRST_PAGE_OF_BOOK = 1;
    private static final int LAST_PAGE_OF_BOOK = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // Exception
        if(isNotTwoSize(pobi) || isNotBookPage(pobi) || isNotSidePage(pobi)) {
            return EXCEPTION_NUMBER;
        } else if (isNotTwoSize(crong) || isNotBookPage(crong) || isNotSidePage(crong)) {
            return EXCEPTION_NUMBER;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        Integer drawNumber = getResult(pobiScore, crongScore);
        if (drawNumber != null) return drawNumber;

        return answer;
    }

    private static Integer getResult(int pobiScore, int crongScore) {
        if(pobiScore == crongScore) {
            return DRAW_NUMBER;
        } else if (pobiScore > crongScore) {
            return WIN_POBI_NUMBER;
        } else {
            return WIN_CRONG_NUMBER;
        }
    }

    private static int getScore(List<Integer> list) {
        int leftSum = getSum(list.get(0));
        int leftMul = getMul(list.get(0));
        int rightSum = getSum(list.get(1));
        int rightMul = getMul(list.get(1));

        int left = Math.max(leftSum, leftMul);
        int right = Math.max(rightSum, rightMul);

        return Math.max(left, right);
    }

    private static int getMul(Integer integer) {
        int result = 0;

        while(integer != 0) {
            result *= integer % 10;
            integer /= 10;
        }

        return result;
    }

    private static int getSum(Integer integer) {
        int result = 0;

        while(integer != 0) {
            result += integer % 10;
            integer /= 10;
        }

        return result;
    }

    private static boolean isNotSidePage(List<Integer> list) {
        return list.get(0) != list.get(1) - 1;
    }

    private static boolean isNotBookPage(List<Integer> list) {
        return list.get(0) < FIRST_PAGE_OF_BOOK || list.get(0) > LAST_PAGE_OF_BOOK ||
                list.get(1) < FIRST_PAGE_OF_BOOK || list.get(1) > LAST_PAGE_OF_BOOK;
    }

    private static boolean isNotTwoSize(List<Integer> list) {
        return list.size() != 2;
    }


}