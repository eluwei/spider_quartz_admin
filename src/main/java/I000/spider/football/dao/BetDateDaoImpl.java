package I000.spider.football.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import I000.spider.football.model.BetDate;

public class BetDateDaoImpl extends HibernateDaoSupport implements BetDateDao {

	@Override
	public BetDate getBetDateByDayDate(String dayDate) {
		String hql = " from BetDate where dayDate= '"+dayDate+"'";
		List dayDateList=getHibernateTemplate().find(hql);
		if(dayDateList!=null&&dayDateList.size()>0){
			return (BetDate)dayDateList.get(0);
		}
		return null;
	}

	@Override
	public void save(BetDate betDate) {
		getHibernateTemplate().save(betDate);	
	}
	
	@Override
	public void update(BetDate betDate){
		getHibernateTemplate().update(betDate);
	}
}
