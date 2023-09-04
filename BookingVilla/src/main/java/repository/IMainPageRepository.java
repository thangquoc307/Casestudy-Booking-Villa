package repository;

import model.Villa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IMainPageRepository {
    List<Villa> loadingDataBaseVilla();
    void createVilla();
    List<Villa> filterVillaByBooking();
    void editVilla(int villaId, Villa newVilla);
    void deleteVilla(int villaId);
    List<String> login(String id, String password);
}
