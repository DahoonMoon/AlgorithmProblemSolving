package leetcode.grind75;

public class Easy_121_Best_Time_to_Buy_and_Sell_Stock {

//	Constraints
//	1 <= prices.length <= 10^5
//	0 <= prices[i] <= 10^4

	public static int maxProfit(int[] prices) {

		int min = 10000;
		int maxDiff = 0;
		int diff = 0;

		for(int i = 0; i < prices.length; i++){
			if(prices[i] < min){
				min = prices[i];
			}
			diff = prices[i] - min;
			if(maxDiff < diff){
				maxDiff = diff;
			}
		}
		return maxDiff;

	}

	public static void main(String[] args) {

		int[] prices = {7, 1, 5, 3, 6, 4};
		int answer = maxProfit(prices);

		System.out.println(answer); //5
	}
}
