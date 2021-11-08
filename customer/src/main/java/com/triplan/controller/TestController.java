package com.triplan.controller;

import com.triplan.dto.ReservationDTO;
import com.triplan.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequiredArgsConstructor
@RequestMapping("/res")
public class TestController {

    // view page 연결 테스트
    private final ReservationService reservationService;


    @GetMapping("/pay")
    public String pay(Model model) {
        return "pay";
    }

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }

    @PostMapping(path = "/reserveItem")
    public String reserveItem(ReservationDTO reservationDTO, HttpServletRequest request){
        // 1. 멤버 id 들고와서 저장 - @PathVariable or @RequestBody
        // get방식 or hidden form 에서 상품 id 들고오기 -> DTO 저장
//        reservationDTO.setItemId(Integer.parseInt(request.getParameter("itemId")));
        // form에서 할인 쿠폰 가격 불러오기
        // 체크된 할인쿠폰으로 최종 할인쿠폰 계산
        // 예약자 정보 입력받기 - 이름, 연락처, 이메일 (form으로)
        // 체크된 결제수단으로 결제 넘기기 - 신용, 무통장입금, 네이버페이, 카카오페이, 페이코
        // setItemId
        // 결제되면 insert
        Integer result = reservationService.reserve(reservationDTO);
        if(result == 1) {
            // 결과값 리턴 1 = insert 성공
            return "test2";
        } else {
            return "test3";
            // 알림창 페이지 구현
        }
    }



}
