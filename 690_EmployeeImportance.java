import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> id2Position = new HashMap<Integer, Integer>();
        int result = 0;
        Queue<Employee> pendingEmployees = new LinkedList<Employee>();
        for (Integer i = 0; i < employees.size(); i++) {
            id2Position.put(employees.get(i).id, i);
        }
        pendingEmployees.add(employees.get(id2Position.get(id)));
        while (!pendingEmployees.isEmpty()) {
            Employee currentEmployee = pendingEmployees.poll();
            result += currentEmployee.importance;
            for (Integer i = 0; i < currentEmployee.subordinates.size(); i++) {
                pendingEmployees.add(employees.get(id2Position.get(currentEmployee.subordinates.get(i))));
            }
        }
        return result;
    }
}
public class EmployeeImportance {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        Solution solution = new Solution();
        int id = 2;
        Employee eachEmployee = new Employee();
        eachEmployee.id = 1;
        eachEmployee.importance = 5;
        eachEmployee.subordinates = new ArrayList<Integer>(){{add(2);add(3);}};
        employees.add(eachEmployee);
        eachEmployee = new Employee();
        eachEmployee.id = 2;
        eachEmployee.importance = 3;
        eachEmployee.subordinates = new ArrayList<Integer>();
        employees.add(eachEmployee);
        eachEmployee = new Employee();
        eachEmployee.id = 3;
        eachEmployee.importance = 3;
        eachEmployee.subordinates = new ArrayList<Integer>();
        employees.add(eachEmployee);
        System.out.println(solution.getImportance(employees, id));
    }
}
