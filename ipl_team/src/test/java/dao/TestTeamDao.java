package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojo.Team;
import utils.HibernateUtils;

class TestTeamDao {
private static TeamDao dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//build SF n create dao instance
		HibernateUtils.getFactory();
		dao = new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}

//	@Test
//	void test() {
//		//create team instanc
//		Team newTeam = new Team("Mumbai Indians", "MI", "Neeta Ambani", 35, 55, 25);
//		String msg = dao.addNewTeam(newTeam);
//		System.out.println(msg);
//		assertEquals(2, newTeam.getId());
//		//invoke dao's method
//		
//	}
	
	@Test
	void testGetAllTeams()
	{
		List<Team> teams = dao.getAllTeams();
		teams.forEach(t->System.out.println(t.getId()+" "+t.getAbbrevation()));
		assertEquals(2, teams.size());
	}

}
