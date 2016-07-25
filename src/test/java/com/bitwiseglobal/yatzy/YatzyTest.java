package test.java.com.bitwiseglobal.yatzy;

import main.java.com.bitwiseglobal.yatzy.Yatzy;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Arpit on 7/22/2016.
 */
public class YatzyTest
{
    @Test
    public void itShouldSumAllTheNumbersNoMatterWhatTheyRead_chance()
    {
        Yatzy yatzy=new Yatzy();
        int sum=yatzy.chance(1,2,3,4,6);
        assertEquals(16,sum);
    }

    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldSumAllTheNumbersNoMatterWhatTheyRead_chance_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum=yatzy.chance(1,2,3,4,6,2);
        System.out.println("Code break due to exception");
        //assertEquals(18,sum);
    }

    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldSumAllTheNumbersNoMatterWhatTheyRead_chance_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum=yatzy.chance(1,2,3,4,7);
        System.out.println("Code break due to exception");
        //assertEquals(18,sum);
    }

    @Test
    public void itShouldGiveFiftyScore_yatzy()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.bingo(1,1,1,1,1);
        int sum2=yatzy.bingo(1,1,1,2,1);
        assertEquals(50,sum1);
        assertEquals(0,sum2);
    }

    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldGiveFiftyScore_yatzy_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.bingo(1,1,1,3);
        assertEquals(50,sum1);
    }

    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldGiveFiftyScore_yatzy_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.bingo('a',1,1,1,3);
        assertEquals(50,sum1);
    }

    @Test
    public void itShouldSumAPair_singlePair()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findSinglePair(4,3,3,4,5);
        assertEquals(8,sum1);
        int sum2=yatzy.findSinglePair(3,2,3,4,1);
        assertEquals(6,sum2);
        int sum3=yatzy.findSinglePair(1,2,3,4,5);
        assertEquals(0,sum3);
        int sum4=yatzy.findSinglePair(3,3,4,3,4);
        assertEquals(8,sum4);
    }

    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldSumAPair_singlePair_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findSinglePair(4,3,3,4,5,5);
        //assertEquals(8,sum1);
    }

    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldSumAPair_singlePair_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findSinglePair(3,3,4,5,'a');
        //assertEquals(8,sum1);
    }
    @Test
    public void itShouldSumTwoPairs_doublePair()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findDoublePairs(1,1,2,2,3);
        assertEquals(6,sum1);
        int sum2=yatzy.findDoublePairs(3,3,3,4,4);
        assertEquals(14,sum2);
        int sum3=yatzy.findDoublePairs(1,2,3,4,5);
        assertEquals(0,sum3);
    }

    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldSumTwoPairs_doublePair_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findDoublePairs(4,3,3,4,5,5);
        //assertEquals(8,sum1);
    }

    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldSumTwoPairs_doublePair_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findDoublePairs(3,3,4,5,'a');
        //assertEquals(8,sum1);
    }

    @Test
    public void itShouldSumThreePairs_triplePair()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findTriplePairs(3,3,4,5,3);
        assertEquals(9,sum1);
        int sum2=yatzy.findTriplePairs(1,1,1,3,2);
        assertEquals(3,sum2);
        int sum3=yatzy.findTriplePairs(1,2,3,3,4);
        assertEquals(0,sum3);
        int sum4=yatzy.findTriplePairs(3,3,4,4,3);
        assertEquals(9,sum4);
        int sum5=yatzy.findTriplePairs(4,4,3,3,4);
        assertEquals(12,sum5);
    }
    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldSumThreePairs_triplePair_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findTriplePairs(3,3,4,5,3,5);
    }
    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldSumThreePairs_triplePair_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findTriplePairs(3,3,4,5,7);
    }
    @Test
    public void itShouldSumFourPairs_fourPair()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findFourPairs(1,1,1,1,4);
        assertEquals(4,sum1);
        int sum2=yatzy.findFourPairs(3,2,2,2,2);
        assertEquals(8,sum2);
        int sum3=yatzy.findFourPairs(3,5,5,5,5);
        assertEquals(20,sum3);
        int sum4=yatzy.findFourPairs(3,3,3,4,4);
        assertEquals(0,sum4);
    }
    @Test
    public void itShouldSumUpAllDie_smallStraight()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findSmallStraight(1,2,3,4,5);
        assertEquals(15,sum1);
        int sum2=yatzy.findSmallStraight(3,2,4,5,1);
        assertEquals(15,sum2);
        int sum3=yatzy.findSmallStraight(1,2,3,4,4);
        assertEquals(0,sum3);
    }
    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldSumUpAllDie_smallStraight_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findSmallStraight(1,2,3,4,7);
    }
    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldSumUpAllDie_smallStraight_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findSmallStraight(1,2,3,4,3,5);
    }
    @Test
    public void itShouldSumUpAllDie_largeStraight()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findLargeStraight(2,5,4,6,3);
        assertEquals(20,sum1);
        int sum2=yatzy.findLargeStraight(2,3,4,5,6);
        assertEquals(20,sum2);
        int sum3=yatzy.findLargeStraight(2,2,3,4,5);
        assertEquals(0,sum3);
    }
    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldSumUpAllDie_largeStraight_invalidLength()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findLargeStraight(2,5,4,6,3,3);
    }
    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldSumUpAllDie_largeStraight_invalidData()
    {
        Yatzy yatzy=new Yatzy();
        int sum1=yatzy.findLargeStraight(2,5,4,6,'a');
    }

    @Test
    public void itShouldScoreSumOfDiesThatReadsOneTwoThreeFourFiveOrSix()
    {
        Yatzy yatzy=new Yatzy();
        int placedOn1=4;
        int sum1=yatzy.findSumPlacedOnPerticulaValue(placedOn1, 1,4,4,3,4);
        assertEquals(12,sum1);
        int placedOn2=3;
        int sum2=yatzy.findSumPlacedOnPerticulaValue(placedOn2, 1,3,3,3,4);
        assertEquals(9,sum2);
        int placedOn3=1;
        int sum3=yatzy.findSumPlacedOnPerticulaValue(placedOn3, 1,1,4,3,4);
        assertEquals(2,sum3);
        int placedOn4=5;
        int sum4=yatzy.findSumPlacedOnPerticulaValue(placedOn4, 1,4,4,3,4);
        assertEquals(0,sum4);
    }
    @Test(expected = Yatzy.InvalidLengthException.class)
    public void itShouldScoreSumOfDiesThatReadsOneTwoThreeFourFiveOrSix_invalidLength() {
        Yatzy yatzy = new Yatzy();
        int placedOn1 = 4;
        int sum1 = yatzy.findSumPlacedOnPerticulaValue(placedOn1, 1, 4, 4, 3, 4, 5);
    }
    @Test(expected = Yatzy.InvalidDataException.class)
    public void itShouldScoreSumOfDiesThatReadsOneTwoThreeFourFiveOrSix_invalidData() {
        Yatzy yatzy = new Yatzy();
        int placedOn1 = 4;
        int sum1 = yatzy.findSumPlacedOnPerticulaValue(8, 1, 4, 4, 3, 4);
    }
}
