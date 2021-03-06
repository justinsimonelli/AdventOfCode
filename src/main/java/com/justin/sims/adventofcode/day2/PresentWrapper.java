package com.justin.sims.adventofcode.day2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.justin.sims.adventofcode.utils.InputReader;
import com.justin.sims.adventofcode.utils.strategy.AbstractListStrategy;
import com.justin.sims.adventofcode.utils.strategy.AdditionStrategy;
import com.justin.sims.adventofcode.utils.strategy.MultiplicationStrategy;

/**
 * <p>
 * --- <b>Day 2: I Was Told There Would Be No Math</b> ---
 * </p>
 * 
 * <p>
 * The elves are running low on wrapping paper, and so they need to submit an
 * order for more. They have a list of the dimensions (length l, width w, and
 * height h) of each present, and only want to order exactly as much as they
 * need.
 * </p>
 * 
 * <p>
 * Fortunately, every present is a box (a perfect right rectangular prism),
 * which makes calculating the required wrapping paper for each gift a little
 * easier: find the surface area of the box, which is
 * <code>2*l*w + 2*w*h + 2*h*l</code>. The elves also need a little extra paper
 * for each present: the area of the smallest side.
 * </p>
 * <p>
 * For example:
 * <ul>
 * <li>A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square
 * feet of wrapping paper plus 6 square feet of slack, for a total of 58 square
 * feet.</li>
 * <li>A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square
 * feet of wrapping paper plus 1 square foot of slack, for a total of 43 square
 * feet.</li>
 * </ul>
 * </p>
 * All numbers in the elves' list are in feet. How many total square feet of
 * wrapping paper should they order?
 * 
 * @author Sims
 *
 */
public class PresentWrapper {
	private final static String PUZZLE_INPUT_PATH = "resources/day2/input.txt";

	public static void main(String[] args) {
		int totalWrappingPaper = calculateTotalMaterialNeeded(InputReader
				.getFileInputAsList(PUZZLE_INPUT_PATH), new MultiplicationStrategy());
	
		System.out.println("Total amount of wrapping paper needed: " + totalWrappingPaper);
		
		int totalRibbon = calculateTotalMaterialNeeded(InputReader
				.getFileInputAsList(PUZZLE_INPUT_PATH), new AdditionStrategy());
		
		System.out.println("Total amount of ribbon needed: " + totalRibbon);
	}

	/**
	 * Given a list of dimensions (String), calculate the total amount of
	 * wrapping paper needed (sq/ft) for the entire list of dimensions.
	 * 
	 * @param dimensionsList
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int calculateTotalMaterialNeeded(
			List<String> dimensionsList, AbstractListStrategy strategy) throws IllegalArgumentException {

		if (dimensionsList == null || dimensionsList.isEmpty()) {
			throw new IllegalArgumentException(
					"dimensionList is empty or null!");
		}

		AtomicInteger totalNeeded = new AtomicInteger(0);

		InputReader.convertStringDimensionsToIntegers(dimensionsList).forEach(
				dims -> {
					totalNeeded.addAndGet(strategy.populateList(dims));
				});

		return totalNeeded.get();
	}
}
