package com.hdsoft.coremailbridge.service;

import com.hdsoft.coremailbridge.model.User;

import java.util.List;


public interface UserService {


	/**
	 * 根据用户名取得用户信息
	 * @param userName
	 * @return
	 */
	User findUserAccount(String userName);

	/**
	 * 根据用户id获取角色列表
	 * @param userId 用户id
	 * @return 角色列表
	 */
	List<String> getRoleNames(Long userId);

    List<User> listUsers();

	void saveUser(User dbUser);
}
