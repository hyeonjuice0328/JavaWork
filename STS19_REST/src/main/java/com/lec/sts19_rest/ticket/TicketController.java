package com.lec.sts19_rest.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired 	// 트랜젝션 수행하는 객체
	TicketService ticketService;
	//ticketservice 는  자동주입 받자 
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "ticket/buy_ticket";
	}
	
	// 티켓 구매 처리 (트랜젝션)
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDTO dto, Model model) {
		
		String page = "ticket/buy_ticket_done";
		
		try {
			// 트랜젝션 수행!!!!!!!!!
			ticketService.buyTicket(dto);
			// model 에 결과 담기
			model.addAttribute("ticketInfo", dto);
		} catch (Exception e) {
			e.printStackTrace();
			// 트랜젝션 오류 발생 시 .. 
			page = "ticket/buy_ticket_fail"; 
		}
		
		return page;
		
	}
	
}
