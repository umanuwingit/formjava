public class Calculation {

	// Modify depends on csv format
	public int[] responceCount () {
		int[] count = null;
		
		return count;
	}
	
	
	
	public double seltScore(int[] rating) {
		
		double selt = 0;
		int sum = rating[0] + rating[1] + rating[2] + rating[3] + rating[4];
		selt = ((rating[0]*5) + (rating[1]*4) + (rating[2]*3) + (rating[3]*2) + (rating[4]*1));
		selt = selt/sum;
		selt = (selt/5)*100;
		return selt;
			
	}
	
	public double responseRate(int studentCount, int responseCount) {		
		double out = ((double)responseCount/(double)studentCount)*100;
		return Math.round(out * 10) / 10.0;
	}
	
	
	
}
