package cn.appsys.service.backend;

import java.util.List;

import cn.appsys.pojo.BackendUser;

//后台用户管理service
public interface AdminUserService {
	List<BackendUser> getBackendUsers(Integer userType);
	Integer countBackendUsers(Integer userType);
}
