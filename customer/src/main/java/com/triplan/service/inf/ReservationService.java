package com.triplan.service.inf;

import com.triplan.domain.ItemScheduleVO;
import com.triplan.dto.ReservationDTO;

import java.util.List;


public interface ReservationService {

    void insert(ReservationDTO reservationDTO);

    ReservationDTO select(Integer resId);

    void update(Integer reservationId, ReservationDTO reservationDTO);

    void delete(Integer resId);

    List<ReservationDTO> myResList(Integer memberId);

    List<ReservationDTO> myUpcomingResList(Integer memberId);

    List<ReservationDTO> myPastResList(Integer memberId);

    List<ReservationDTO> myCancelledResList(Integer memberId);

    void reserve(Integer itemScheduleId, ReservationDTO reservationDTO);

    void cancel(Integer resId, ReservationDTO reservationDTO);
}