package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.PeriodicalThesisMapper;
import com.qaii.domain.PeriodicalThesis;
import com.qaii.service.PeriodicalThesisService;

@Service
public class PeriodicalThesisServiceImpl implements PeriodicalThesisService {

	@Resource
	private PeriodicalThesisMapper mapper;
	
	@Override
	public List<PeriodicalThesis> listAllMessage() {
		// TODO Auto-generated method stub
		return mapper.listAllMessage();
	}

	@Override
	public int deleteMessages(Integer[] id) {
		// TODO Auto-generated method stub
		return mapper.deleteMessages(id);
	}

	@Override
	public PeriodicalThesis getMessage(long id) {
		// TODO Auto-generated method stub
		return mapper.getMessage(id);
	}

	@Override
	public int updateMessage(PeriodicalThesis record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertMessage(PeriodicalThesis record) {
		// TODO Auto-generated method stub
		return mapper.insertMessage(record);
	}

	@Override
	public List<PeriodicalThesis> listNotPass() {
		// TODO Auto-generated method stub
		return mapper.listNotPass();
	}

	@Override
	public int insert(PeriodicalThesis record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

}
