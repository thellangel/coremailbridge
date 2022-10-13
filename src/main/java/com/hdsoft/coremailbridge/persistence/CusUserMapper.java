package com.hdsoft.coremailbridge.persistence;

import java.util.List;
import java.util.Map;

public interface CusUserMapper {
	List<String> selectUserRoles(Map<String, Object> parameters);
}
