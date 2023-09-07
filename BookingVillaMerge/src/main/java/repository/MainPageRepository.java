package repository;

import model.Villa;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPageRepository implements IMainPageRepository{

    private static final String GET_DETAIL_IMG = "call get_detail_img();";
    private static final String DELETE_PIC = "update `villa_booking`.`image_detail_links` set `is_delete` = 1 where (`image_id` = ?);";
    private static final String GET_ALL_VILLA = "call get_all_villa();";
    private static final String LOGIN = "call check_account(?,?);";
    private static final String DELETE_VILLA = "update `villa_booking`.`villas` set `is_delete` = 1 where (`villa_id` = ?);";
    private static final String EDIT = "update `villa_booking`.`villas` set `area` = ?, `level` = ?, " +
                                        "`width` = ?, `deep` = ?, `garage` = ?, `gym_room` = ?, `relax_room` = ?, " +
                                        "`toilet` = ?, `living_room` = ?, `kitchen_room` = ?, `bedroom` = ?, `price` = ?, " +
                                        "`capacity` = ?  where (`villa_id` = ?);";
    @Override
    public List<Villa> loadingDataBaseVilla() {
        System.out.println("repository loading all");
        Map<Integer, List<String>> detailImg = new HashMap<>();
        Map<Integer, List<Integer>> detailImgId = new HashMap<>();
        List<Villa> villaList = new ArrayList<>();

        Connection connection = BaseRepository.getConnection();

        try {
            Statement statementImg = connection.createStatement();

            ResultSet resultSetImg = statementImg.executeQuery(GET_DETAIL_IMG);
            while (resultSetImg.next()){
                int villaId = resultSetImg.getInt(1);
                String link = resultSetImg.getString(2);
                int imgId = Integer.parseInt(resultSetImg.getString(3));

                if (detailImg.containsKey(villaId)){
                    detailImg.get(villaId).add(link);
                    detailImgId.get(villaId).add(imgId);
                } else {
                    List<String> detailImgLink = new ArrayList<>();
                    detailImgLink.add(link);
                    detailImg.put(villaId, detailImgLink);

                    List<Integer> detailImgLinkId = new ArrayList<>();
                    detailImgLinkId.add(imgId);
                    detailImgId.put(villaId, detailImgLinkId);
                }
            }

            ResultSet resultSetVilla = statementImg.executeQuery(GET_ALL_VILLA);
            while (resultSetVilla.next()){
                int villaId = resultSetVilla.getInt(1);
                String map = resultSetVilla.getString(2);
                Double area = resultSetVilla.getDouble(3);
                int level = resultSetVilla.getInt(4);
                Double width = resultSetVilla.getDouble(5);
                Double deep = resultSetVilla.getDouble(6);
                int garage = resultSetVilla.getInt(7);
                int gym = resultSetVilla.getInt(8);
                int relax = resultSetVilla.getInt(9);
                int toilet = resultSetVilla.getInt(10);
                int living = resultSetVilla.getInt(11);
                int kitchen = resultSetVilla.getInt(12);
                int bedroom = resultSetVilla.getInt(13);
                int price = resultSetVilla.getInt(14);
                int capacity = resultSetVilla.getInt(15);

                List<String> listImg;
                List<Integer> listImgId;
                if (detailImg.containsKey(villaId)){
                    listImg = detailImg.get(villaId);
                    listImgId = detailImgId.get(villaId);
                } else {
                    listImg = new ArrayList<>();
                    listImgId = new ArrayList<>();
                }
                villaList.add(new Villa(villaId,listImg, price, level, area, width, deep, map, bedroom, kitchen, living, toilet, relax, gym, garage, capacity,listImgId));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return villaList;
    }

    @Override
    public void createVilla() {

    }

    @Override
    public List<Villa> filterVillaByBooking() {
        return null;
    }

    @Override
    public void editVilla(int villaId, double area, double width, double deep, int price, int level, int garage, int gym, int relax, int toilet, int living, int kitchen, int bedroom, int capacity) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(EDIT);
            statement.setDouble(1, area);
            statement.setInt(2, level);
            statement.setDouble(3, width);
            statement.setDouble(4, deep);
            statement.setInt(5, garage);
            statement.setInt(6, gym);
            statement.setInt(7, relax);
            statement.setInt(8, toilet);
            statement.setInt(9, living);
            statement.setInt(10, kitchen);
            statement.setInt(11, bedroom);
            statement.setInt(12, price);
            statement.setInt(13, capacity);
            statement.setInt(14, villaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteVilla(int villaId) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_VILLA);
            statement.setInt(1, villaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> login(String id, String password) {
        System.out.println("repository login");
        List<List<String>> accounts = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(LOGIN);
            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                List<String> account = new ArrayList<>();
                account.add(resultSet.getString(1));
                account.add(resultSet.getString(2));
                account.add(resultSet.getString(3));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (accounts.size() == 0){
            return new ArrayList<>();
        } else {
            return accounts.get(0);
        }
    }

    @Override
    public void deletePicture(String[] list) {
        Connection connection = BaseRepository.getConnection();
        for (String str : list){
            try {
                System.out.println(Integer.parseInt(str));
                PreparedStatement statement = connection.prepareStatement(DELETE_PIC);
                statement.setInt(1, Integer.parseInt(str));
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
