package I000.spider.football.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import I000.common.StaticFinalString;
import I000.spider.football.model.FootballMatch;

public class FootballMatchDaoImpl extends HibernateDaoSupport implements FootballMatchDao {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public <T> void save(T t) {
		getHibernateTemplate().save(t);	
	}
	
	@Override
	public <T> void update(T t){
		getHibernateTemplate().update(t);	
	}
	
	@Override
	public FootballMatch getFootballMatchByZid(String zid,String typeCode) {
		String hql = " from FootballMatch where zid= '"+zid+"'";
		if(typeCode!=null&&!"".equals(typeCode.trim())){
			hql += " and typeCode = '"+typeCode+"' ";
		}
		List footballMatchList=getHibernateTemplate().find(hql);
		if(footballMatchList!=null&&footballMatchList.size()>0){
			return (FootballMatch)footballMatchList.get(0);
		}
		return null;
	}

	@Override
	public void save(FootballMatch footballMatch) {
		getHibernateTemplate().save(footballMatch);	
	}
	
	@Override
	public void update(FootballMatch footballMatch){
		getHibernateTemplate().update(footballMatch);
	}

	@Override
	public FootballMatch getFootballMatchByExpectAndTeam(String typeCode,String lotteryPeriod,
			String home, String away) {
		String hql = " from FootballMatch where type_code='"+typeCode+"'" 
					+ "  and expect= '"+lotteryPeriod+"'"
					+ "  and homesxname='"+home+"' and awaysxname= '"+away+"'";
		List<FootballMatch> footballMatchList=getHibernateTemplate().find(hql);
		if(footballMatchList!=null&&footballMatchList.size()>0){
			return (FootballMatch)footballMatchList.get(0);
		}
		return null;
	}
	
	public List findByProperty(String entityName,List<String> propertyNames,List<String> values) {
		log.debug("finding "+entityName+" instance with property: " + propertyNames.toString()
				+ ", value: " + values.toString());
		try {
			String queryString = " from "+entityName+" as model where 1=1 ";
			if(propertyNames.size()>0){
				for(String propertyName:propertyNames){
					queryString += " and model."+propertyName+"=? ";
				}
			}
			return getHibernateTemplate().find(queryString, values.toArray());
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void updateLotteryPeriodStatus(String typeCode,String currentPeriod){
		String sql0 = " update lottery_period p set p.status=0,update_date=now() where p.lottery_code=? and p.lottery_period<? ";
		SQLQuery query0 = getSession().createSQLQuery(sql0);  
	    query0.setString(0,typeCode).setString(1,currentPeriod).executeUpdate();
	    
	    String sql2 = " update lottery_period p set p.status=2,update_date=now() where p.lottery_code=? and p.lottery_period>? ";
		SQLQuery query2 = getSession().createSQLQuery(sql2);  
	    query2.setString(0,typeCode).setString(1,currentPeriod).executeUpdate();
	    
	    //最后设置当前期
	    String sql1 = " update lottery_period p set p.status=1,update_date=now() where p.lottery_code=? and p.lottery_period=? ";
		SQLQuery query1 = getSession().createSQLQuery(sql1);  
	    query1.setString(0,typeCode).setString(1,currentPeriod).executeUpdate();
	}
}
