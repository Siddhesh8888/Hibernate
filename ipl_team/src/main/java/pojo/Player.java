package pojo;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "players")
public class Player extends BaseEntity{
	@Column(length = 20, unique = true)
	private String email;
	@Column(name = "first_name", length = 20)
	private String fname;
	@Column(name = "last_name", length = 20)
	private String lname;
	@Column(name = "date_of_birth")
	private LocalDate dob;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	//player * ----->1 Team
	@ManyToOne
	@JoinColumn(name = "team_id" , nullable = false)
	private Team myTeam;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public Player(String email, String fname, String lname, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
		
	
	public Team getMyTeam() {
		return myTeam;
	}


	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}


	@Override
	public String toString() {
		return "Player [plyerId=" + this.getId() + ", fname=" + fname + ", lname=" + lname +", email=" + email + ", dob=" + dob + ", battingAvg="
				+ battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
	

}
