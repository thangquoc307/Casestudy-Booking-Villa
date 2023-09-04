package service;

import model.Villa;
import repository.MainPageRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPageService implements IMainPageService{
    MainPageRepository mainPageRepository = new MainPageRepository();

    @Override
    public String loadingDataBaseVilla(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("service loading all");
        List<Villa> villaList = mainPageRepository.loadingDataBaseVilla();

        String data = "[";
        for (int i = 0; i < villaList.size(); i++){
            data += convertVillaToString(villaList.get(i));
            if (i == villaList.size() - 1){
                data += "]";
            } else {
                data += ",";
            }
        }
        return data;
    }

    @Override
    public void createVilla(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public String filterVillaByBooking(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void editVilla(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void deleteVilla(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public List<String> login(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pass = request.getParameter("password");
        return mainPageRepository.login(id, pass);
    }

    private String convertVillaToString(Villa villa){
        String data = "new villa(";
        List<String> villaImg = villa.getImg();

        data += "[";
        for (int i = 0; i < villaImg.size(); i++){
            data += '"' + villaImg.get(i) + '"';
            if (i == villaImg.size() - 1){
                data += "],";
            } else {
                data += ",";
            }
        }

        data += villa.getPrice() + ",";
        data += villa.getLevel() + ",";
        data += villa.getArea() + ",";
        data += villa.getWidth() + ",";
        data += villa.getDeep() + ",";
        data += '"' + villa.getMap() + '"' + ",";
        data += villa.getBedroom() + ",";
        data += villa.getKitchen() + ",";
        data += villa.getLiving() + ",";
        data += villa.getToilet() + ",";
        data += villa.getRelax() + ",";
        data += villa.getGym() + ",";
        data += villa.getGarage() + ",";
        data += villa.getVillaId() + ")";

        return data;
    }
}
