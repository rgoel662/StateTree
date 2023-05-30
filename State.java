/**
 *	The object to store US state information.
 *
 *	@author	
 *	@since	
 */
public class State implements Comparable<State>
{
	private String name;
	private String abbreviation;
	private int population;
	private int area;
	private int reps;
	private String capital;
	private int month;
	private int day;
	private int year;
	
	public State(String n, String a, int p, int ar, int r, String c, int m, int d, int y) 
	{
		name = n;
		abbreviation = a;
		population = p;
		area = ar;
		reps = r;
		capital = c;
		month = m;
		day = d;
		year = y;
	}
	
	/**
	 * 	Compares this State to another State using name.
	 * 
	 * 	@param	other	the other State to compare to
	 * 	@return			0 if the two States are equal, a negative number if this State is 
	 * 					less than the other, a positive number otherwise
	 */
	public int compareTo(State other) 
	{
		return name.compareTo(other.name);
	}
	
	public String getName ( )
	{
		return name;
	}
	
	/**
	 * 	Returns a String representation of this State.
	 *  Example:
	 *  Alabama AL 4858979 50744 7 Montgomery 12 14 1819
	 * 
	 * 	@return		a String representation of this State
	 */
	public String toString() 
	{
		String str = String.format("%-15s %-7s %-10d %-10d %-4d %-15s %-4d %-4d %-4d", 
			name, abbreviation, population, area, reps, capital, month, day, year);

		return str;
	}
}
