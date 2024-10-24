package com.hotel_booking.service;

import com.hotel_booking.dto.request.RoomCreationRequest;
import com.hotel_booking.dto.request.RoomUpdateRequest;
import com.hotel_booking.dto.response.RoomResponse;
import com.hotel_booking.entity.Room;
import com.hotel_booking.exception.AppException;
import com.hotel_booking.exception.ErrorCode;
import com.hotel_booking.mapper.RoomMapper;
import com.hotel_booking.repository.RoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoomService {
    RoomRepository roomRepository;
    RoomMapper roomMapper;

    public RoomResponse createRoom(RoomCreationRequest request) {
        Room room = roomMapper.toRoom(request);
        room = roomRepository.save(room);

        return roomMapper.toRoomResponse(room);
    }

    public List<RoomResponse> getRooms() {
        log.info("In method get Rooms");
        return roomRepository.findAll().stream().map(roomMapper::toRoomResponse).toList();
    }

    public RoomResponse getRoom(String id) {
        return roomMapper.toRoomResponse(
                roomRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND)));
    }

    public RoomResponse updateRoom(String roomId, RoomUpdateRequest request) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND));

        roomMapper.updateRoom(room, request);

        return roomMapper.toRoomResponse(roomRepository.save(room));
    }

    public void deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
    }
}
