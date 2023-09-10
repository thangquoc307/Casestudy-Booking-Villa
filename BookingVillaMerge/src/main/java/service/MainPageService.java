package service;

import model.Villa;
import repository.MainPageRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
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
        double area = Double.parseDouble(request.getParameter("area"));
        double width = Double.parseDouble(request.getParameter("width"));
        double deep = Double.parseDouble(request.getParameter("deep"));
        int price = Integer.parseInt(request.getParameter("price"));
        int level = Integer.parseInt(request.getParameter("level"));
        int garage = Integer.parseInt(request.getParameter("garage"));
        int gym = Integer.parseInt(request.getParameter("gym"));
        int relax = Integer.parseInt(request.getParameter("relax"));
        int toilet = Integer.parseInt(request.getParameter("toilet"));
        int living = Integer.parseInt(request.getParameter("living"));
        int kitchen = Integer.parseInt(request.getParameter("kitchen"));
        int bedroom = Integer.parseInt(request.getParameter("bedroom"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String map = request.getParameter("link-map");
        String detailImg = request.getParameter("detail-pic");

        mainPageRepository.createVilla(area,width,deep,price,level,garage,gym,
                relax,toilet,living,kitchen,bedroom,capacity,map,detailImg);
    }

    @Override
    public String filterVillaByBooking(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void editVilla(HttpServletRequest request, HttpServletResponse response) {
        int villaId = Integer.parseInt(request.getParameter("villa-id"));
        double area = Double.parseDouble(request.getParameter("area"));
        double width = Double.parseDouble(request.getParameter("width"));
        double deep = Double.parseDouble(request.getParameter("deep"));
        int price = Integer.parseInt(request.getParameter("price"));
        int level = Integer.parseInt(request.getParameter("level"));
        int garage = Integer.parseInt(request.getParameter("garage"));
        int gym = Integer.parseInt(request.getParameter("gym"));
        int relax = Integer.parseInt(request.getParameter("relax"));
        int toilet = Integer.parseInt(request.getParameter("toilet"));
        int living = Integer.parseInt(request.getParameter("living"));
        int kitchen = Integer.parseInt(request.getParameter("kitchen"));
        int bedroom = Integer.parseInt(request.getParameter("bedroom"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String map = request.getParameter("img-map");
        String detailImg = request.getParameter("img-detail");
        System.out.println(detailImg);
        if (detailImg.length() != 0){
            String[] list = detailImg.split(" ");
            mainPageRepository.addDetailPicture(villaId, list);
        }
        String deletepic = request.getParameter("img-delete");
        if (deletepic.length() != 0){
            String[] deletePicture = deletepic.split(",");
            mainPageRepository.deletePicture(deletePicture);
        }
        mainPageRepository.editVilla(villaId, area, width, deep, price, level, garage,
                gym, relax, toilet, living, kitchen, bedroom, capacity, map);
    }

    @Override
    public void deleteVilla(HttpServletRequest request, HttpServletResponse response) {
        int villaId = Integer.parseInt(request.getParameter("villa-id"));
        mainPageRepository.deleteVilla(villaId);
    }

    @Override
    public List<String> login(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pass = request.getParameter("password");
        return mainPageRepository.login(id, pass);
    }

    @Override
    public int getBookingNotSeen() {
        return mainPageRepository.getBookingNotSeen();
    }

    @Override
    public void setSeenTime() {
        mainPageRepository.setSeenTime();
    }

    private String convertVillaToString(Villa villa){
        String data = "new villa(";
        List<String> villaImg = villa.getImg();
        List<Integer> villaImgId = villa.getImgId();

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
        data += villa.getVillaId() + ",";
        data += villa.getCapacity() + ",";

        data += "[";
        for (int i = 0; i < villaImgId.size(); i++){
            data += villaImgId.get(i);
            if (i == villaImgId.size() - 1){
                data += "])";
            } else {
                data += ",";
            }
        }
        return data;
    }
}
