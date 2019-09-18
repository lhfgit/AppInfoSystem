package cn.appsys.dao.appversion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppVersion;

public interface AppVersionMapper {
	/**
	 * 根据Appid得到所有版本
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionList(@Param("appId")Integer appId) throws Exception;
	/**
	 * 添加版本
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public int add(AppVersion appVersion)throws Exception;
	/**
	 * 根据Appid得到版本记录数
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public int getVersionCountByAppId(@Param("appId")Integer appId)throws Exception;
	/**
	 * 根据Appid删除版本
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public int deleteVersionByAppId(@Param("appId")Integer appId)throws Exception;
	/**
	 * 根据id获取版本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppVersion getAppVersionById(@Param("id")Integer id)throws Exception;
	/**
	 * 更新版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public int modify(AppVersion appVersion)throws Exception;
	/**
	 * 根据id进行删除版本
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteApkFile(@Param("id")Integer id)throws Exception;
}
