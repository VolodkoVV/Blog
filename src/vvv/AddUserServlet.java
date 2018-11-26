package vvv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@WebServlet(name = "AddUserServlet", urlPatterns = "/registration/adduser")
public class AddUserServlet extends HttpServlet {

    private static Map<String, String> usersWithID = new HashMap<>();
    private static Map<String, String> users = new HashMap<>();

    public Map<String, String> getUsers() {
        return users;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        javax.servlet.http.HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String log = req.getParameter("login");
        String psw = req.getParameter("password");
        String logPsw = log + psw;
        String nameSurname = name + " " + surname;
        if (!users.containsKey(log)) {
            users.put(log, psw);
            saveUsers();
            usersWithID.put(logPsw, nameSurname);
            saveUsersWithID();
        } else {
            req.setAttribute("oldUserMessage", "User with this login is already registered.");
            req.getRequestDispatcher("/index_response.jsp").forward(req, resp);
        }
        session.setAttribute("logpsw", logPsw);
        session.setAttribute("name", name);
        session.setAttribute("login", log);
        req.setAttribute("addUserMessage", "The registration process was successfully completed");
        req.getRequestDispatcher("/index_response.jsp").forward(req, resp);
    }

    public void saveUsers() throws IOException {
        File save = new File("users.txt");
        Set<Map.Entry<String, String>> setUsers = users.entrySet();
        if (!save.exists()) {
            save.createNewFile();
        }
        FileWriter fw = new FileWriter(save);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (Map.Entry<String, String> temp : setUsers) {
                bw.write(temp.getKey() + ":" + temp.getValue());
                bw.newLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void saveUsersWithID() throws IOException {
        File save = new File("usersWithID.txt");
        Set<Map.Entry<String, String>> setUsers = usersWithID.entrySet();
        if (!save.exists()) {
            save.createNewFile();
        }
        FileWriter fw = new FileWriter(save);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (Map.Entry<String, String> temp : setUsers) {
                bw.write(temp.getKey() + ":" + temp.getValue());
                bw.newLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public Map<String, String> getUsersFromFile() {
        String str = "";
        File file = new File("users.txt");
        try (Scanner sc = new Scanner(file)) {
            for (; sc.hasNextLine(); ) {
                str = sc.nextLine();
                String[] arrStr = str.split(":");
                String login = arrStr[0];
                String password = arrStr[1];
                users.put(login, password);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return users;
    }

}
