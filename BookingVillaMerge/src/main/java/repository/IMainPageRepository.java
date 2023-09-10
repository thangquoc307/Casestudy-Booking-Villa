package repository;

import model.Villa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IMainPageRepository {
    List<Villa> loadingDataBaseVilla();
    void createVilla(double area, double width, double deep, int price, int level, int garage, int gym, int relax,
                     int toilet, int living, int kitchen, int bedroom, int capacity, String map, String detailImg);
    List<Villa> filterVillaByBooking();
    void editVilla(int villaId,double area,double width,double deep,int price,int level,int garage,
                   int gym,int relax,int toilet,int living,int kitchen,int bedroom, int capacity, String map);
    void deleteVilla(int villaId);
    List<String> login(String id, String password);
    void deletePicture(String[] list);
    void addDetailPicture(int villaId, String[] list);
    int getBookingNotSeen();
    void setSeenTime();
}
