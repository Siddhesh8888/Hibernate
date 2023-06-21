package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
	@Column(length = 100 , unique = true)
	private String name;
	@Column(length = 10 , unique = true)
	private String abbrevation;
	@Column(length = 50)
	private String owner;
	@Column(name = "max_age")
	private int maxAge;
	@Column(name = "batting_avg")
	private double minBattingAvg;
	@Column(name = "wickets_taken")
	private int minWicketsTaken;
	//bi dire. association between team--->players
	@OneToMany(mappedBy = "myTeam", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Player> players = new ArrayList<Player>();
	
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Team(long id,String abbrevation) {
		super.setId(id);
		this.abbrevation = abbrevation;
	}


	public Team(String name, String abbrevation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();
		
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getminBattingAvg() {
		return minBattingAvg;
	}
	public void setminBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}
	public int getminWicketsTaken() {
		return minWicketsTaken;
	}
	public void setminWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	
	
	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner + ", maxAge="
				+ maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken + "]";
	}
	
	//add 2 helper methods : addPlayer, removePlayer
	
	public void addPlayer(Player player)
	{
		players.add(player);
		player.setMyTeam(this);
	}
	
	public void removePlayer(Player player)
	{
		players.remove(player);
		player.setMyTeam(null);
	}
	
	
	
	

}
