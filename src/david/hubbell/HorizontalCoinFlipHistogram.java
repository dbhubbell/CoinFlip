package david.hubbell;

public class HorizontalCoinFlipHistogram implements UpdatableGraph<TossValue> {
	private int[] array;
	private int cursor;
	private static final int INITIALSIZE = 30;

	public HorizontalCoinFlipHistogram(){
		this.array = new int[INITIALSIZE];
		this.cursor = INITIALSIZE / 2;
	}

	@Override
	public void update(TossValue type) {
		if(type == TossValue.HEADS && (cursor + 1) < INITIALSIZE) {
			this.cursor++;
		} else if((cursor - 1) >= 0) {
			this.cursor--;
		}
		this.array[cursor]++;
	}

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
