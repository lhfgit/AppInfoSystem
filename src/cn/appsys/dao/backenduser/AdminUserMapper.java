package cn.appsys.dao.backenduser;

import java.util.List;

import cn.appsys.pojo.BackendUser;

//后台用户管理
public interface AdminUserMapper {
//得到后台用户
	List<BackendUser> getBackendUsers(Integer userType);
	Integer countBackendUsers(Integer userType);
}
