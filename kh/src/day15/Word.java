package day15;

public class Word {
	private String word;
	private String mean;

	public Word(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}

	@Override
	public String toString() {
		return "[" + word + " : " + mean + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) { //해당객체가 런타임 아니면
			if (!(obj instanceof String)) { // 같은 객체가 아니면
				return false;				// 펄스
			}
			return word.equals(obj);		// word랑 obj랑 비교함
		}
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

}
