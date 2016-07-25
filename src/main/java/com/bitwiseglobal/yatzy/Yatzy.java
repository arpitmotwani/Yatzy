package main.java.com.bitwiseglobal.yatzy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Arpit on 7/22/2016.
 */
public class Yatzy implements YatzyInterface {

    private int totalSumOfAPlayer=0;


    public int chance(int... data) {
        validateLength(data);
        validateData(data);
        totalSumOfAPlayer=totalSumOfAPlayer+(data[0]+data[1]+data[2]+data[3]+data[4]);
        return (data[0]+data[1]+data[2]+data[3]+data[4]);
    }

    private void validateData(int[] data) {
        for(int number:data)
        {
            if(number<1 || number>6) throw new InvalidDataException();
        }
    }

    private void validateLength(int[] data) {
        if(data.length!=5) throw new InvalidLengthException();
    }

    public int bingo(int... data) {
        validateLength(data);
        validateData(data);
        return scoreFiftyYatzy(data);
    }

    private int scoreFiftyYatzy(int[] data) {
        int x=data[0], count=0;
        for(int number:data)
        {
            if(x==number) count++;
        }
        if(count==5)
        {
            totalSumOfAPlayer=totalSumOfAPlayer+50;
            return 50;
        }
        else return 0;
    }

    public int findSinglePair(int... data) {
        validateData(data);
        validateLength(data);
        int sum = sumOfASinglePair(data);
        totalSumOfAPlayer=totalSumOfAPlayer+sum;
        return sum;
    }

    private int sumOfASinglePair(int[] data) {
        int num=0,x=0;
        while(x<data.length)
        {
            int y=x+1;
            while(y<data.length)
            {
                if(data[x]==data[y] && (data[x]+data[y])>num)
                {
                    num=data[x]+data[y];
                    break;
                }
                y++;
            }
            x++;
        }
        return num;
    }

    public int findDoublePairs(int... data) {
        validateData(data);
        validateLength(data);
        int sum = sumOfDoublePairs(data);
        totalSumOfAPlayer=totalSumOfAPlayer+sum;
        return sum;
    }

    private int sumOfDoublePairs(int[] data) {
        int num=0;
        int x=0,y;
        while(x<data.length)
        {
            y=x+1;
            while(y<data.length)
            {
                if(data[x]==data[y] && (data[x]+data[y])>num)
                {
                    num=num+data[x]+data[y];
                    break;
                }
                y++;
            }
            x++;
        }
        return num;
    }

    public int findTriplePairs(int... data) {
        validateData(data);
        validateLength(data);
        int sum= sumOfTriplePair(data);
        totalSumOfAPlayer=totalSumOfAPlayer+sum;
        return sum;
    }

    private int sumOfTriplePair(int[] data) {
        int num=0,x=0,y,count=1;
        while(x<data.length)
        {
            y=x+1;
            while(y<data.length)
            {
                if(data[x]==data[y] && count!=3)
                {
                    num=data[x];
                    count++;
                    break;
                }
                y++;
            }
            x++;
        }
        if(count==3) return (num*3);
        else return 0;
    }

    public int findFourPairs(int... data) {
        validateData(data);
        validateLength(data);
        int sum= findSumOfFourPairOfElements(data);
        totalSumOfAPlayer=totalSumOfAPlayer+sum;
        return sum;
    }

    private int findSumOfFourPairOfElements(int[] data) {
        int num=0,x=0,y,count=1;
        while(x<data.length)
        {
            y=x+1;
            while(y<data.length)
            {
                if(data[x]==data[y] && count!=4 && (num==0 || num==data[x]))
                {
                    num=data[x];
                    count++;
                    break;
                }
                y++;
            }
            x++;
        }
        if(count==4) return (num*4);
        else return 0;
    }

    public int findSmallStraight(int... data) {
        validateData(data);
        validateLength(data);
        int sum=sumOfSmallStraightNumbers(data);
        if(sum==15)
        {
            totalSumOfAPlayer=totalSumOfAPlayer+sum;
            return 15;
        }
        else return 0;
        }

    private int sumOfSmallStraightNumbers(int[] data) {
        ArrayList<Integer> numbers= new ArrayList<>();
        for(int num:data)
        {
            numbers.add(num);
        }
        Collections.sort(numbers);
        int sum=0;
        for(int num:numbers)
        {
            sum=sum+num;
        }
        return sum;
    }

    public int findLargeStraight(int... data) {
        validateLength(data);
        validateData(data);
        int sum=sumOfSmallStraightNumbers(data);
        if(sum==20)
        {
            totalSumOfAPlayer=totalSumOfAPlayer+sum;
            return 20;
        }
        else return 0;
    }

    public int findSumPlacedOnPerticulaValue(int placedOn, int... data)
    {
        if(placedOn<1 || placedOn>6) throw new InvalidDataException();
        validateLength(data);
        validateData(data);
        int sum = getSumPlacedOnPerticularValues(placedOn, data);
        totalSumOfAPlayer=totalSumOfAPlayer+sum;
        return sum;
    }

    private int getSumPlacedOnPerticularValues(int placedOn, int[] data) {
        int x=0,sum=0;
        while(x<data.length)
        {
            if(data[x]==placedOn) sum=sum+data[x];
            x++;
        }
        return sum;
    }

    public class InvalidLengthException extends RuntimeException {
    }
    public class InvalidDataException extends RuntimeException{
    }
}