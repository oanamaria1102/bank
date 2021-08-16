import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegisterServlet extends HttpServlet {

    public RegisterServlet() {
        super();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String cnp = req.getParameter("cnp");
        String password = req.getParameter("psw");
        String confPassword = req.getParameter("cpsw");

        if (password.equals(confPassword)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("insert into accounts values (" + cnp + "," + password + "," + "0)");
                Client client = new Client(cnp, password, "RON", "EUR");
                stmt.executeUpdate("insert into client values (" + cnp + "," + client.getRonAccount().getAccountNr() + "," + client.getEuroAccount().getAccountNr() + "," + client.getRonAccount().getAmount() + "," + client.getEuroAccount().getAmount() + ", 0)");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
