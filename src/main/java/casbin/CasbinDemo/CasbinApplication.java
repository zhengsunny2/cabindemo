package casbin.CasbinDemo;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CasbinApplication {

	public static void main(String[] args) {
		String resPath = CasbinApplication.class.getResource("/").getPath();
        Enforcer e = new Enforcer(resPath + "model.conf", resPath + "policy.csv");

        String sub = "zhangsan";
        String obj = "data1";
        String act = "read";

        if (e.enforce(sub, obj, act) == true) {
            System.out.println("pass");
        } else {
            System.out.println("refuse");
        }
    }
}
