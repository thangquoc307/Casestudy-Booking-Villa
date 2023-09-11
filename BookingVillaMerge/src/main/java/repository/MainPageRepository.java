package repository;

import model.Villa;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPageRepository implements IMainPageRepository{

    private static final String GET_DETAIL_IMG = "call get_detail_img();";
    private static final String INSERT_DETAIL_IMG = "insert into `image_detail_links`(`villa_id`, `image_detail`) values (?,?);";
    private static final String DELETE_PIC = "update `villa_booking`.`image_detail_links` set `is_delete` = 1 where (`image_id` = ?);";
    private static final String GET_ALL_VILLA = "call get_all_villa();";
    private static final String LOGIN = "call check_account(?,?);";
    private static final String DELETE_VILLA = "update `villa_booking`.`villas` set `is_delete` = 1 where (`villa_id` = ?);";
    private static final String EDIT = "update `villa_booking`.`villas` set `area` = ?, `level` = ?, " +
                                        "`width` = ?, `deep` = ?, `garage` = ?, `gym_room` = ?, `relax_room` = ?, " +
                                        "`toilet` = ?, `living_room` = ?, `kitchen_room` = ?, `bedroom` = ?, `price` = ?, " +
                                        "`capacity` = ?, `image_map` = ?  where (`villa_id` = ?);";
    private static final String GET_MAX_ID_VILLA = "select MAX(`villa_id`) from `villas`";
    private static final String CREATE_VILLA = "insert into `villas` (`image_map`, `area`, `level`, `width`, " +
                                                "`deep`, `garage`, `gym_room`, `relax_room`, `toilet`, `living_room`, " +
                                                "`kitchen_room`, `bedroom`, `price`, `capacity`) " +
                                                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_SEEN_TIME = "call GetBookingCountAfterSeenTime();";
    private static final String SET_SEEN_TIME = "update `villa_booking`.`seen_time` set `time` = ? where (`role` = 1);";

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
    public void createVilla(double area, double width, double deep, int price, int level, int garage, int gym, int relax, int toilet, int living, int kitchen, int bedroom, int capacity, String map, String detailImg) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_VILLA);
            statement.setString(1, map);
            statement.setDouble(2, area);
            statement.setInt(3, level);
            statement.setDouble(4, width);
            statement.setDouble(5, deep);
            statement.setInt(6, garage);
            statement.setInt(7, gym);
            statement.setInt(8, relax);
            statement.setInt(9, toilet);
            statement.setInt(10, living);
            statement.setInt(11, kitchen);
            statement.setInt(12, bedroom);
            statement.setInt(13, price);
            statement.setInt(14, capacity);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int idVilla = -1;
        try {
            PreparedStatement statementDetail = connection.prepareStatement(GET_MAX_ID_VILLA);
            ResultSet resultSet = statementDetail.executeQuery();
            while (resultSet.next()){
                idVilla = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Đây là cái map " + map);

        String[] list = detailImg.split(" ");
        addDetailPicture(idVilla, list);
    }

    @Override
    public List<Villa> filterVillaByBooking() {
        return null;
    }

    @Override
    public void editVilla(int villaId, double area, double width, double deep, int price, int level,
                          int garage, int gym, int relax, int toilet, int living, int kitchen, int bedroom,
                          int capacity, String map) {
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
            statement.setString(14, map);
            statement.setInt(15, villaId);

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

    @Override
    public void addDetailPicture(int villaId, String[] list) {
        Connection connection = BaseRepository.getConnection();
        for (String str : list){
            try {
                PreparedStatement statement = connection.prepareStatement(INSERT_DETAIL_IMG);
                statement.setInt(1, villaId);
                statement.setString(2, str);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public int getBookingNotSeen() {
        Connection connection = BaseRepository.getConnection();
        int times = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_SEEN_TIME);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                times = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return times;
    }

    @Override
    public void setSeenTime() {
        Connection connection = BaseRepository.getConnection();
        System.out.println("vào repo setseen");
        try {
            java.util.Date now = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(now.getTime());
            PreparedStatement preparedStatement = connection.prepareStatement(SET_SEEN_TIME);
            preparedStatement.setTimestamp(1, timestamp);
            System.out.println(timestamp);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
