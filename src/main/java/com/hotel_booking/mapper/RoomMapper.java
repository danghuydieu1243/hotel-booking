package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.HotelUpdateRequest;
import com.hotel_booking.dto.request.RoomCreationRequest;
import com.hotel_booking.dto.request.RoomUpdateRequest;
import com.hotel_booking.dto.response.RoomResponse;
import com.hotel_booking.entity.Hotel;
import com.hotel_booking.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomCreationRequest request);
    RoomResponse toRoomResponse(Room room);
    void updateRoom(@MappingTarget Room room, RoomUpdateRequest request);
}
