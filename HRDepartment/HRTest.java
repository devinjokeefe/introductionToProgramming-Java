import java.util.Calendar;
import java.util.Date;

public class HRTest {

	public static void main(String[] args) {
		HRDepartment testProg = new HRDepartment();
		testProg.addEmployee(1, "Devin", 5);

		testProg.printAllEmployees();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date appraisalDate = calendar.getTime();
		
		testProg.recordEmployeeAppraisal(1, appraisalDate, 1);
		testProg.recordEmployeeAppraisal(1, appraisalDate, 1);

		testProg.promoteEmployee(1);
		testProg.printAllEmployees();
	}

}
