package com.lec.sts14_transaction;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*트렌젝션 적용 안된 버전의 dao*/
	//private TicketDAO1 dao;
	//private TicketDAO2 dao;
	private TicketDAO3 dao;
	
	/* @Autowired :  TicketDAO1 type 의 beans 를 주입받겠다는 의미 */
	@Autowired
	//public void setDao(TicketDAO1 dao) {
	//public void setDao(TicketDAO2 dao) {	
	public void setDao(TicketDAO3 dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket"; // 티켓 구매 양식  페이지 
	}
	
	// 티켓 구매 처리 (트렌젝션)
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDTO dto, Model model) {
		//확인용 
		System.out.println("/buy_ticket_card");
		System.out.println("user id :  " + dto.getUserId());
		System.out.println("ticket count :  " + dto.getTicketCount());
		
		String page = "buy_ticket_done";
		
		try {
			dao.buyTicket(dto); // 이곳에서 트렌젝션이 발생되어야 한다. 
			model.addAttribute("ticketInfo", dto);
		} catch (Exception e) {
			e.printStackTrace();
			page = "buy_ticket_fail"; // 트렌잭션 오류 발생시 보여지는 페이지 
		}
		return page;
	}
	
}
