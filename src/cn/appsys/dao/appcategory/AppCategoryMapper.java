package cn.appsys.dao.appcategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
/**
 *根据父id查询App分类
 * @param parentId
 * @return
 * @throws Exception
 */
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId) throws Exception;
}
