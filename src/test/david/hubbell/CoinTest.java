package test.david.hubbell; 

import david.hubbell.Coin;
import david.hubbell.TossValue;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Coin Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 13, 2018</pre> 
* @version 1.0 
*/ 
public class CoinTest {
	private Coin coin;

@Before
public void before(){
	this.coin = new Coin();
} 

@After
public void after(){
} 

/** 
* 
* Method: toss() 
* 
*/ 
@Test
public void testToss() throws Exception { 
	assert(coin.toss() == TossValue.HEADS || coin.toss() == TossValue.TAILS);
} 


} 
