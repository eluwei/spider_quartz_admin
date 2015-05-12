package I000.common.dao;

import java.util.List;

import I000.common.vo.ConstantConfig;
import I000.common.vo.WinningNumber;

public interface CommonDao {

	public <T> String save(T t);
	
	public <T> void update(T t);
	
	public <T> void saveList(List<T> tList);
	
	/**
	 * 注意：
	 * T一定要跟映射的实体名称完全一致
	 * @param t
	 * @param id
	 * @return
	 */
	public <T> T getById(T t,String id);
	
	/**
	 * 根据key取配置常量
	 * @param key
	 * @return
	 */
	public ConstantConfig getConstantConfigByKey(String key);
	
	/**
	 * 根据key取value
	 * @param key
	 * @return
	 */
	public String getConfigValueByKey(String key);
	
	/**
	 * 根据类型和日期取开奖记录
	 * @param typeCode
	 * @param openTime
	 * @return
	 */
	public WinningNumber getWinningNumberByTypeAndTime(String typeCode,String openTime);
}
