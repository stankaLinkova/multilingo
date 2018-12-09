package sk.upjs.paz1c.multilingo.business;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;

public class SignUpAsSchoolManager {
	
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	
	public SignUpAsSchoolManager() {
	}

	// TODO testy
	public boolean canCreate(School school, String confirmationPassword) {
		return correctPasswords(confirmationPassword, school) && correctLogin(school) && correctFilling(school);
	}

	private boolean correctFilling(School school) {
		return (school.getName() != null && school.getAddress() != null && school.getEmail() != null);
	
	}

	private boolean correctLogin(School school) {
		List<School> schools = schoolDao.getAll();
		String login = school.getLogin();
		if(login == null) {
			return false;
		}
		for(School s: schools) {
			if(login.equals(s.getLogin())) {
				return false;
			}
		}
		return true;
	}

	private boolean correctPasswords(String confirmationPassword, School school) {
		if(school.getPassword() == null) {
			return false;
		}
		return school.getPassword().equals(confirmationPassword);
	}
	
	
}
