package qiaolf.offer;

import java.util.List;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/8/6 17:45
 **/
public class test2 {
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        Employee e=null;
        for (Employee employee : employees) {
            if (employee.id==id){
                e=employee;
            }
        }
//        Employee employee = employees.get(id - 1);
        sum+=e.importance;
        List<Integer> subordinates = e.subordinates;
        for (Integer subordinate : subordinates) {
            Employee employee1 = null;
            for (Employee employee : employees) {
                if (employee.id==subordinate){
                    employee1=employee;
                }
            }
            if (employee1.subordinates.size()==0){
                sum+=employee1.importance;
            }else{
               sum+=getImportance(employees,employee1.id);
            }
        }
        return sum;
    }
}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
