package I000.common.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import I000.common.vo.ConstantConfig;
import I000.common.vo.WinningNumber;

public class CommonDaoImpl extends HibernateDaoSupport implements CommonDao {

	@Override
	public <T> T getById(T t,String id) {
		String hql = " from "+t+" where "+t+"Id = '"+id+"'";
		List<T> dayDateList=getHibernateTemplate().find(hql);
		if(dayDateList!=null&&dayDateList.size()>0){
			return (T)dayDateList.get(0);
		}
		return null;
	}

	@Override
	public <T> String save(T t) {
		return (String) getHibernateTemplate().save(t);	
	}
	
	@Override
	public <T> void update(T t){
		getHibernateTemplate().update(t);	
	}
	
	@Override
	public <T> void saveList(List<T> tList) {
		for(T t:tList){
			getHibernateTemplate().saveOrUpdate(t);	
		}
	}

	@Override
	public ConstantConfig getConstantConfigByKey(String key) {
		String hql = " from ConstantConfig where conifgKey = '"+key+"'";
		List<ConstantConfig> constantConfigList=getHibernateTemplate().find(hql);
		if(constantConfigList!=null&&constantConfigList.size()>0){
			return (ConstantConfig)constantConfigList.get(0);
		}
		return null;
	}
	
	@Override
	public String getConfigValueByKey(String key){
		String hql = " select configValue from ConstantConfig where configKey = '"+key+"'";
		List<Object> valueList=getHibernateTemplate().find(hql);
		if(valueList!=null&&valueList.size()>0){
			return (String)valueList.get(0);
		}
		return null;
	}

	@Override
	public WinningNumber getWinningNumberByTypeAndTime(String typeCode,
			String openTime) {
		String hql = " from WinningNumber where typeCode = '"+typeCode+"' "
					+ " and opentime = str_to_date('"+openTime+"','%Y-%m-%d %H:%i:%s')";
		List<WinningNumber> winningNumberList=getHibernateTemplate().find(hql);
		if(winningNumberList!=null&&winningNumberList.size()>0){
			return (WinningNumber)winningNumberList.get(0);
		}
		return null;
	}
	

}
