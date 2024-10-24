package com.hotel_booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomService {

    private List<Room> roomList = new ArrayList<>();

    // Add a new room
    public void addRoom(Room room) {
        roomList.add(room);
        System.out.println("Room added: " + room);
    }

    // Update room details
    public void updateRoom(int roomId, Room updatedRoom) {
        Optional<Room> roomOptional = roomList.stream().filter(room -> room.getId() == roomId).findFirst();
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            room.setNumber(updatedRoom.getNumber());
            room.setType(updatedRoom.getType());
            room.setPrice(updatedRoom.getPrice());
            room.setAvailable(updatedRoom.isAvailable());
            System.out.println("Room updated: " + room);
        } else {
            System.out.println("Room not found with ID: " + roomId);
        }
    }

    // Delete a room
    public void deleteRoom(int roomId) {
        roomList.removeIf(room -> room.getId() == roomId);
        System.out.println("Room with ID " + roomId + " has been deleted.");
    }

    // Check room availability
    public boolean isRoomAvailable(int roomId) {
        return roomList.stream().anyMatch(room -> room.getId() == roomId && room.isAvailable());
    }

    // Get all rooms
    public List<Room> getAllRooms() {
        return roomList;
    }

    // Find room by ID
    public Room getRoomById(int roomId) {
        return roomList.stream().filter(room -> room.getId() == roomId).findFirst().orElse(null);
    }
}
