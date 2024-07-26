package guis;


public class Die {

	private int sideUp;
	private int numSides;
	
	/**
	 * This is an unargumented constructor
	 * @param sides number of sides on the die
	 */
	public Die(int sides) {
		if(sides == 6 || sides == 20 || sides == 100)
			numSides = sides;
		else 
			throw new IllegalArgumentException(sides + " is not a valid number of sides.");
	}
	
	
	
	
	/**
	 * Change the side up.
	 */
	public void roll() { sideUp = 
						(int)(Math.random()*numSides)+1;
	}
	
	/**
	 * Get the side that is up.
	 * @return the side that is up.
	 */
	public int getSideUp() { return sideUp; }


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Die other = (Die) obj;
		if (numSides != other.numSides)
			return false;
		if (sideUp != other.sideUp)
			return false;
		return true;
	}
	
	/*
	public boolean equals(Die in) {
		
		return this.numSides == in.numSides;
	}
	*/
	
	public String toString() {
		return "Die[" + numSides + "]";
	}
	

	
	
	
	
}
