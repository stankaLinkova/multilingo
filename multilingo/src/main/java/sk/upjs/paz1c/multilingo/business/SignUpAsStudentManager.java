package sk.upjs.paz1c.multilingo.business;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;

public class SignUpAsStudentManager {
	
private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	
	public SignUpAsStudentManager() {
	}

	// TODO testy
	public boolean canCreate(Student student, String confirmationPassword) {
		return correctPasswords(confirmationPassword, student) && correctLogin(student) && correctFilling(student);
	}

	private boolean correctFilling(Student student) {
		return (student.getName() != null && student.getSurname() != null && student.getEmail() != null);
	
	}

	private boolean correctLogin(Student student) {
		List<Student> students = studentDao.getAll();
		String login = student.getLogin();
		if(login == null) {
			return false;
		}
		for(Student s: students) {
			if(login.equals(s.getLogin())) {
				return false;
			}
		}
		return true;
	}

	private boolean correctPasswords(String confirmationPassword, Student student) {
		if(student.getPassword() == null) {
			return false;
		}
		return student.getPassword().equals(confirmationPassword);
	}
	
	
}
