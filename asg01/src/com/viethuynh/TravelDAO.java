package com.viethuynh;
import java.util.List;


public interface TravelDAO {
	TravelDAO travelDAO = new TravelDAOImpl();
    List<Travel> getAllTravels();
    void addTravel(Travel travel);
    boolean deleteTravelById(int travelId);
    List<Travel> searchTravel(String query);
    boolean updateTravel(int travelId, String name, String price, String address);
	Travel getTravelById(int travelId);
	boolean bookTravel(int travelId, int userId);
}
