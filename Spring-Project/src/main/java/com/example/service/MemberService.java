package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MemberVo;
import com.example.mapper.MemberMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	public int getCountById(String id) {
		int count = memberMapper.getCountById(id);
		return count;
	}

	public void addMember(MemberVo memberVo) {
		memberMapper.addMember(memberVo);
	}

	public int userCheck(String id, String pw) {
		int check = -1;

		//패스워드 확인
		String dbPw = memberMapper.userCheck(id);

		log.info("dbPw : " +dbPw);
		log.info("pw : " + pw);

		//패스워드가 있을때
		if(dbPw != null) {
			if(pw.equals(dbPw)) { //입력받은 패스워드와 조회된 패스워드랑 같을때
				check = 1;
			}else {	//입력받은 패스워드와 조회된 패스워드랑 다를때
				check = 0;
			}
		} else { //dbPw가 null일떄 (패스워드가 없을때)
			check = -1;
		}

		return check;
	}

}
