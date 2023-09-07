package controller;

import service.MainPageService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainPageController", value = "/main-page-controller")
public class MainPageController extends HttpServlet {
    private static int role = 0;
    private static int account;
    private static String user;

    public static String getUser() {
        return user;
    }
    public static void setUser(String user) {
        MainPageController.user = user;
    }
    public static int getAccount() {
        return account;
    }
    public static void setAccount(int account) {
        MainPageController.account = account;
    }
    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        MainPageController.role = role;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MainPageService mainPageService = new MainPageService();
        System.out.println("do get controller");

        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "getdata":
                System.out.println("doget controller getdata");

                String data = mainPageService.loadingDataBaseVilla(request,response);
                request.setAttribute("data", data);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "logout":
                System.out.println("logout");
                setRole(0);
                response.sendRedirect("/index.jsp");
                break;
            case "villaManage":
                if (getRole() == 3){
                    System.out.println(user);

                    String manageVillaData = mainPageService.loadingDataBaseVilla(request,response);
                    request.setAttribute("data", manageVillaData);
                    request.setAttribute("user_name", getUser());
                    request.getRequestDispatcher("editVilla.jsp").forward(request,response);
                }
                break;
            case "backToMain":
                String dataVillaReload = mainPageService.loadingDataBaseVilla(request,response);
                request.setAttribute("data", dataVillaReload);
                request.setAttribute("role", getRole());
                request.setAttribute("user_name", getUser());
                request.setAttribute("loginfail", 0);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        MainPageService mainPageService = new MainPageService();
        if (action == null){
            action = "";
        }
        switch (action) {
            case "login":
                System.out.println("dopost login");
                List<String> accountInfo = mainPageService.login(request,response);
                String data = mainPageService.loadingDataBaseVilla(request,response);
                request.setAttribute("data", data);

                if (accountInfo.size() == 0){
                    System.out.println("fail");
                    request.setAttribute("loginfail", 1);
                    request.setAttribute("user_name", "");
                } else {
                    setAccount(Integer.parseInt(accountInfo.get(2)));
                    setUser(accountInfo.get(1));
                    switch (accountInfo.get(0)){
                        case "customer":
                            setRole(1);
                            break;
                        case "customer service":
                            setRole(2);
                            break;
                        case "admin":
                            setRole(3);
                            break;
                        default:
                            setRole(0);
                            break;
                    }

                    request.setAttribute("role", getRole());
                    request.setAttribute("user_name", getUser());
                    request.setAttribute("loginfail", 0);
                }
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "delete-villa":
                if (getRole() == 3) {
                    mainPageService.deleteVilla(request,response);
                    System.out.println("delete villa");
                }
                String manageVillaData = mainPageService.loadingDataBaseVilla(request,response);
                request.setAttribute("data", manageVillaData);
                request.setAttribute("user_name", getUser());
                request.getRequestDispatcher("editVilla.jsp").forward(request,response);
                break;
            case "edit-villa":
                if (getRole() == 3){
                    mainPageService.editVilla(request,response);
                }
                String manageVillaEdit = mainPageService.loadingDataBaseVilla(request,response);
                request.setAttribute("data", manageVillaEdit);
                request.setAttribute("user_name", getUser());
                request.getRequestDispatcher("editVilla.jsp").forward(request,response);
                break;

        }
    }
}
