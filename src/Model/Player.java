package Model;

/** 
 * @author Warington
 * player object
 */
public class Player {

	private int playernumber;
	private String name;
	private String results;
	
	public void Player() {
		
	}
	
	public int getPlayernumber() {
		return playernumber;
	}
	public void setPlayernumber(int playernumber) {
		this.playernumber = playernumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
}
