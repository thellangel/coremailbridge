package com.hdsoft.coremailbridge.service.impl;

import java.util.List;

import com.hdsoft.coremailbridge.model.Matcher;
import com.hdsoft.coremailbridge.model.MatcherExample;
import com.hdsoft.coremailbridge.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsoft.coremailbridge.persistence.MatcherMapper;

@Service
public class SysServiceImpl implements SysService {

	private final Logger logger = LoggerFactory.getLogger(SysServiceImpl.class);

	@Autowired
	private MatcherMapper matcherMapper;

	@Override
	public List<Matcher> listMatcher() {
		MatcherExample example = new MatcherExample();
		example.createCriteria().andCreateTimeIsNotNull();
		return matcherMapper.selectByExample(example);
	}
}
