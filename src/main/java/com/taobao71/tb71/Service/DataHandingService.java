package com.taobao71.tb71.Service;

import com.taobao71.tb71.dao.CategoryDao;
import com.taobao71.tb71.dao.MaterialDao;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyzhang
 * @since 2019/11/7 11:29
 */
@Service
public class DataHandingService {
  @Autowired
  MaterialDao materialDao;
  @Autowired
  CategoryDao categoryDao;

  /**
   * 获取categoryName,并计算其名称缩写
   * @return 暂时
   */
  public List categoryNameUnique () {
    List categoryNames = materialDao.categoryNameUnique();
    for(int i=0;i<categoryNames.size();i++) {
      Map<String,String> categoryInfo = (Map<String,String>) categoryNames.get(i);
      String categoryName = categoryInfo.get("level_one_category_name");
      String categoryShortName = categoryName.contains("/")?categoryName.split("/")[0]:categoryName;
      categoryInfo.put("category_short_name",categoryShortName);
    }
    return categoryNames;
  }

  /**
   *将新的categoryName 写入到数据库，并获取到ID
   * @return 暂时
   */
  public List categoryNameAdd() {
    List categoryNames = categoryNameUnique();
    for(int i=0;i<categoryNames.size();i++) {
      Map<String,String> categoryName = (Map<String,String>)categoryNames.get(i);
      Integer categoryId = categoryDao.categoryAdd(categoryName.get("category_short_name"));
      categoryName.put("categoryId",categoryId.toString());
    }
    return categoryNames;
  }

  public boolean updateCategoryID() {
    List categoryNames = categoryNameAdd();
    for(int i=0;i<categoryNames.size();i++) {
      Map<String,String> categoryName = (Map<String,String>)categoryNames.get(i);
      String categoryFullName = categoryName.get("level_one_category_name");
      Integer categoryId = Integer.valueOf(categoryName.get("categoryId"));
      materialDao.updateCategoryID(categoryFullName,categoryId);
    }
    return true;
  }
}
