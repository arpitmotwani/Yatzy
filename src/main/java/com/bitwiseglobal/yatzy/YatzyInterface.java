package main.java.com.bitwiseglobal.yatzy;

/**
 * Created by arpitm on 7/25/2016.
 */
public interface YatzyInterface {
    public int chance(int... data);
    public int bingo(int... data);
    public int findSinglePair(int... data);
    public int findDoublePairs(int... data);
    public int findTriplePairs(int... data);
    public int findFourPairs(int... data);
    public int findSmallStraight(int... data);
    public int findLargeStraight(int... data);
    public int findSumPlacedOnPerticulaValue(int placedOn, int... data);
}
