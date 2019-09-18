package cn.appsys.service.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.backenduser.AdminUserMapper;
import cn.appsys.pojo.BackendUser;
@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired 
private AdminUserMapper adminUserMapper;
	
	public List<BackendUser> getBackendUsers(Integer userType) {
		// TODO Auto-generated method stub
		return adminUserMapper.getBackendUsers(userType);
	}

	
	public Integer countBackendUsers(Integer userType) {
		// TODO Auto-generated method stub
		return adminUserMapper.countBackendUsers(userType);
	}

}
