package vvv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private String registration = "<form action=\"/registration/adduser\" method=\"post\">\n" +
            "      <div class=\"container\">\n" +
            "        <br><h1>REGISTRATION:</h1><br>\n" +
            "        <label for=\"name\">enter your name:</label>\n" +
            "        <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"input your name\"/>\n" +
            "        <label for=\"surname\">enter your surname:</label>\n" +
            "        <input type=\"text\" id=\"surname\" name=\"surname\" placeholder=\"input your surname\"/>\n" +
            "        <label for=\"login\">enter your login:</label>\n" +
            "        <input type=\"text\" id=\"login\" name=\"login\" placeholder=\"input your login\"/>\n" +
            "        <label for=\"password\">enter your password:</label>\n" +
            "        <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"input your password\"/>\n" +
            "        <input type=\"submit\" value=\"register\" name=\"submitReg\"/>\n" +
            "      </div>\n" +
            "    </form>";

    private String login = "<form action=\"/login_user\" method=\"post\">\n" +
            "        <div class=\"container\">\n" +
            "            <br><h1>LOG IN:</h1><br>\n" +
            "            <label for=\"logining\">enter your login:</label>\n" +
            "            <input type=\"text\" id=\"logining\" name=\"logining\" placeholder=\"input your login\"/>\n" +
            "            <label for=\"passwording\">enter your password:</label>\n" +
            "            <input type=\"password\" id=\"passwording\" name=\"passwording\" placeholder=\"input your password\"/>\n" +
            "            <input type=\"submit\" value=\"log in\" name=\"submitLog\"/>\n" +
            "        </div>\n" +
            "    </form>";

    private String text = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/web../../../../styles/reset.css\">"
            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"/web../../../../styles/styles.css\">"
            + "<title>ProgBlog - Title</title></head><body><div id=\"header\" class=\"title\">"
            + "<div id=\"problog_title\"><a href=\"/index.jsp\"><p>Nice BLOG</p></a></div>"
            + "<div id=\"image_title\">"
            + "<img src=\"/images/java.png\" alt=\"java\"></div></div><div id=\"navi\" class=\"navi\">"
            + "<div id=\"my_cabinet\"><a href=\"/my_cabinet\"><p>My cabinet</p></a></div>"
            + "<div id=\"search\"><a href=\"/search\"><p>Searching articles</p></a>"
            + "</div><div id=\"sort\"><a href=\"/sort\"><p>Sorting articles</p></a></div><div id=\"registration\">"
            + "<a href=\"/registration\"><p>Login/Registration</p></a></div></div><fieldset>"
            + "<div id=\"content\"><div id=\"article\">" + registration + login + "</div></div></fieldset></body></html>";

    private String template = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/web../../../../styles/reset.css\">"
            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"/web../../../../styles/styles.css\">"
            + "<title>Nice BLOG</title></head><body><div id=\"header\" class=\"title\">"
            + "<div id=\"problog_title\"><a href=\"/index.jsp\"><p>Nice BLOG</p></a>"
            + "</div><div id=\"image_title\">"
            + "<img src=\"/images/java.png\" alt=\"java\"></div></div><div id=\"navi\" class=\"navi\">"
            + "<div id=\"my_cabinet\"><a href=\"/my_cabinet\"><p>My cabinet</p></a></div>"
            + "<div id=\"search\"><a href=\"/search\"><p>Searching articles</p></a>"
            + "</div><div id=\"sort\"><a href=\"/sort\"><p>Sorting articles</p></a></div><div id=\"registration\">"
            + "<a href=\"/registration\"><p>Login/Registration</p></a></div></div><fieldset>"
            + "<div id=\"content\"><div id=\"article\">";

    public RegistrationServlet() {
    }

    public RegistrationServlet(String registration, String login, String text, String template) {
        this.registration = registration;
        this.login = login;
        this.text = text;
        this.template = template;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().print(text);
    }

}
