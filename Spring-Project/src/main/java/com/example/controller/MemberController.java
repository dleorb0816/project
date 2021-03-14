package com.example.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.MemberVo;
import com.example.service.MemberService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	MemberService memberService;

	@GetMapping("/join")
	public String join() {
		log.info("get join()");

		return "member/join";
	}

	@GetMapping(value = "/ajax/dupCheck")
	@ResponseBody
	public Map<String, Boolean> ajaxJoinIdDupChk(String id){
		int count = memberService.getCountById(id);
		log.info("count : " + count);

		Map<String, Boolean> map = new HashMap<>();
		if(count == 0) {
			map.put("isIdDup", false);
		}
		else {
			map.put("idIdDup", true);
		}
		return map;
	}//ajaxJoinIdDupChk

	@PostMapping("/register")
	public String register(MemberVo memberVo) {
		log.info("post register 호출됨");

		memberVo.setRegDate(new Timestamp(System.currentTimeMillis()));
		log.info("memberVo : " + memberVo);

		//회원가입 처리
		memberService.addMember(memberVo);

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {


		return "member/login";
	}//로그인 화면

	@PostMapping("/login")//로그인 로직 처리
	public ResponseEntity<String> login(String id, String pw, @RequestParam(defaultValue = "false") boolean keepLogin,
			HttpSession session,HttpServletResponse response) {

		log.info("post login");
		log.info("pw: " + pw);

		int check = memberService.userCheck(id, pw);
		log.info("check : " + check);

		//로그인 실패시
		if(check != 1) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=UTF-8");

			StringBuilder sb = new StringBuilder();
			sb.append("<script>");
			sb.append("  alert('아이디 또는 패스워드가 일치하지 않습니다.');");
			sb.append("  history.back();");
			sb.append("</script>");

			return new ResponseEntity<String>(sb.toString(), headers, HttpStatus.OK);
		}

		//세션에 아이디 저장
		session.setAttribute("id", id);

		if (keepLogin) { // keepLogin == true
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60 * 10);  // 쿠키 유효시간 10분
			cookie.setPath("/");

			response.addCookie(cookie);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/"); // 리다이렉트 경로를 Location으로 설정
		// 리다이렉트일 경우는 HttpStatus.FOUND 를 지정해야 함
		return new ResponseEntity<String>(headers, HttpStatus.FOUND);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest request,
			HttpServletResponse response) {

		session.invalidate();

		// 로그인 상태유지용 쿠키가 존재하면 삭제
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("id")) {
							cookie.setMaxAge(0); // 유효시간 0
							cookie.setPath("/"); // 경로는 생성할때와 동일하게 설정해야 삭제됨

							response.addCookie(cookie); // 삭제할 쿠키정보를 추가
						}
					}
				}

		return "redirect:/";
	}
}
