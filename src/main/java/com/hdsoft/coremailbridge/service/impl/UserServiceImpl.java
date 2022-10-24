package com.hdsoft.coremailbridge.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hdsoft.coremailbridge.model.User;
import com.hdsoft.coremailbridge.model.UserExample;
import com.hdsoft.coremailbridge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsoft.coremailbridge.persistence.CusUserMapper;
import com.hdsoft.coremailbridge.persistence.UserMapper;

/**
 * 用户service
 * @author wxy
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(SysServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CusUserMapper cusUserMapper;

	/* (non-Javadoc)
	 * @see com.hdsoft.service.UserService#getRoleNames(java.lang.Long)
	 */
	@Override
	public List<String> getRoleNames(Long userId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId", userId);
		return cusUserMapper.selectUserRoles(parameters);
	}

	@Override
	public List<User> listUsers() {
		UserExample example = new UserExample();
		example.createCriteria().andFsUnionIdIsNotNull().andStatusEqualTo(true);
		return userMapper.selectByExample(example);
	}

	@Transactional
	@Override
	public void saveUser(User user) {
		if (user.getId() != null) {
			userMapper.insert(user);
		}
		else {
			userMapper.updateByPrimaryKey(user);
		}
	}


	/* (non-Javadoc)
	 * @see com.hdsoft.service.UserService#findUserAccount(java.lang.String)
	 */
	@Override
	public User findUserAccount(String userName) {

        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);

        List<User> userList = userMapper.selectByExample(example);
        if (userList!=null && !userList.isEmpty()) {
        	return userList.get(0);
        }
        return null;
    }

}
