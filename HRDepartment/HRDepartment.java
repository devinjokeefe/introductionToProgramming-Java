import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class HRDepartment {

	private static final int EXCEEDED_EXPECTATIONS = 0;
	Collection employeeList;

	public HRDepartment() {
		employeeList = new ArrayList<Employee>();
	}

	public void addEmployee (int employeeId, String name, int role) {
		Employee employeeToAdd = new Employee (employeeId, name, role);
		employeeList.add(employeeToAdd);
	}
	
	public void printAllEmployees () {
		for (int i = 0; i < employeeList.size(); i ++) {
			Employee curEmployee = (Employee) employeeList.toArray()[i];
			System.out.println("Employee ID : " + curEmployee.getEmployeeId());
			System.out.println("Role : " + curEmployee.getRole());
			System.out.println("Name : " + curEmployee.getName());
		}
	}
	
	public Employee findEmployee (int employeeId) {
		for (int i = 0; i < employeeList.size(); i ++) {
			Employee curEmployee = (Employee) employeeList.toArray()[i];
			if (curEmployee.getEmployeeId() == employeeId) {
				return curEmployee;
			}
		}
		
		return null;
	}
	
	public boolean recordEmployeeAppraisal (int employeeId, Date appraisalDate, int score) {
		
		if (appraisalDate == null || score <= 0) {
			return false;
		}
		
		Employee employeeToAppraise = findEmployee (employeeId);
		
		if (employeeToAppraise != null) {
			ArrayList<EmployeeAppraisal> appraisalHistory = employeeToAppraise.getAppraisalHistory();
			EmployeeAppraisal appraisalToAdd = new EmployeeAppraisal(appraisalDate, score);
			appraisalHistory.add(appraisalToAdd);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean promoteEmployee (int employeeId) {
		Employee employeeToPromote = findEmployee (employeeId);
		ArrayList<EmployeeAppraisal> appraisalHistory = employeeToPromote.getAppraisalHistory();
		


		if (appraisalHistory.size() >= 2) {
			for (int i = appraisalHistory.size()-1; i < appraisalHistory.size()-3; i --) {
				int appraisalScore = appraisalHistory.get(i).getAppraisalScore();
				if (appraisalScore != EXCEEDED_EXPECTATIONS) {
					System.out.print("Didn't exceed");
					return false;
				}
	
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.YEAR, -1);
				Date lastYear = calendar.getTime();
				
				Date appraisalDate = appraisalHistory.get(i).getAppraisalDate();
				if (!lastYear.equals(appraisalDate)) {
					return false;
				}
			}
			
			int curRole = employeeToPromote.getRole();
			
			if (curRole > HRCodes.EXECUTIVE) {
				
				int newRole = curRole - 1;
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				Date dateToday = calendar.getTime();
				
				employeeToPromote.setRole(newRole);
				employeeToPromote.setPromotionDate(dateToday);
				return true;
			}
		}

		System.out.println("FAILED");
		return false;
	}

}
