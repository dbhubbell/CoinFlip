package david.hubbell;

/**
 * HorizontalCoinFlipHistogram Object
 *
 * <p>As one of potentially many ways to display the outcome of a series of
 * coin tosses, the {@link HorizontalCoinFlipHistogram} class implements the
 * {@link UpdatableGraph} generic interface, using {@link TossValue} as the
 * datatype passed to the {@link #update(TossValue)} method.
 *
 * The goal of this class is to produce a horizontal histogram, which refers
 * to a histogram in which the bars of data span from left to right as opposed
 * to the more common vertical histogram.
 *
 * The specified behavior for this type of graph is for it to be of fixed domain.
 * At the outset, the cursor for the array is set to point to the middle of the
 * array.  When a {@link TossValue#HEADS} value is passed to the {@link #update(TossValue)}method,
 * the cursor moves in the positive direction and increments the value stored at
 * this new index.  In the case of {@link TossValue#TAILS}, the cursor moves to the left
 * and increments the value stored there.
 *
 * In the case that moving either right or left would cause the cursor to point
 * outside the bounds of the array, the cursor remains where it is and increments
 * the value stored at the current index.  This has the potential to skew output,
 * but we really don't care.
 *
 * At any time, the {@link #print()} method can be called to produce a rendering
 * of the histogram on the command line.</p>
 *
 * @author David Hubbell
 * @see     UpdatableGraph
 */
public class HorizontalCoinFlipHistogram implements UpdatableGraph<TossValue> {
	private int[] array;
	private int cursor;
	private static final int INITIALSIZE = 30;

	/**
	 * Constructor.
	 *
	 * Creates a new instance of the HorizontalCoinFlipHistorgram class
	 * and initializes the array and cursor position.
	 * At the outset the cursor position will be in the middle of the array.
	 *
	 * @see HorizontalCoinFlipHistogram
	 */
	public HorizontalCoinFlipHistogram(){
		this.array = new int[INITIALSIZE];
		this.cursor = INITIALSIZE / 2;
	}

	/**
	 * Adds data to the histogram by moving the cursor and updating the
	 * referenced index according the kind of {@link TossValue} passed in.
	 *
	 * Values of {@link TossValue#HEADS} cause the cursor to move in the
	 * positive direction. Values of {@link TossValue#TAILS} cause the
	 * cursor to move in the negative direction.
	 *
	 * Wherever the cursor moves, it increments the value stored at the new
	 * location by one.
	 *
	 * If moving in a particular direction would cause the cursor to point
	 * outside of the bounds of the array, the cursor remains where it is
	 * and updates the current location.
	 *
	 * @param value The outcome of a coin toss.  Either {@link TossValue#HEADS} or {@link TossValue#TAILS}
	 * @see TossValue
	 * @see UpdatableGraph
	 */
	@Override
	public void update(TossValue value) {
		if(value == TossValue.HEADS && (cursor + 1) < INITIALSIZE) {
			this.cursor++;
		} else if((cursor - 1) >= 0) {
			this.cursor--;
		}
		this.array[cursor]++;
	}

	/**
	 * Prints a representation of the graph to the command line.
	 */
	@Override
	public void print() {
		for(int rowValue : this.array){
			StringBuilder sb = new StringBuilder();
			sb.append('|');
			for(int i = 0; i < rowValue; i++){
				sb.append('*');
			}
			System.out.println(sb.toString());
		}
	}
}
