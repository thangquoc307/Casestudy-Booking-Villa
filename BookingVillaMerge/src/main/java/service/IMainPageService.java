package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IMainPageService {
    String loadingDataBaseVilla(HttpServletRequest request, HttpServletResponse response);
    void createVilla(HttpServletRequest request, HttpServletResponse response);
    String filterVillaByBooking(HttpServletRequest request, HttpServletResponse response);
    void editVilla(HttpServletRequest request, HttpServletResponse response);
    void deleteVilla(HttpServletRequest request, HttpServletResponse response);
    List<String> login(HttpServletRequest request, HttpServletResponse response);
}
