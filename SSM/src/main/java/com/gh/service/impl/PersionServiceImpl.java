package com.gh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gh.dao.PersonDao;
import com.gh.domain.PersonDO;
import com.gh.service.PersionService;

@Service
public class PersionServiceImpl implements PersionService{

	@Resource
	private PersonDao personDao;
	
	@Override
	public PersonDO getPersonByName(String name) {
		return this.personDao.getPersonByName(name);
	}


}
