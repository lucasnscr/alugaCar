package serviceImpl;

import java.util.Arrays;
import java.util.function.Function;

public class RegressaoLinear implements Function<Double[], Double> {

	private final double [] thetaVector;
	
	public RegressaoLinear(double[] thetaVector) {
		this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length);
	}
	
	@Override
	public Double apply(Double[] featureVector) {
		assert featureVector[0] == 1;
		double prediction = 0;
		for (int i = 0; i < thetaVector.length; i++) {
			prediction += thetaVector[i] * featureVector[i];
		}
		return prediction;
	}
	public double[] getThetas() {
		return Arrays.copyOf(thetaVector, thetaVector.length);
	}
}