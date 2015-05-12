package I000.spider.football.dao;

import java.util.List;

import I000.spider.football.model.FootballMatch;

public interface FootballMatchDao {

	public <T> void save(T t);
	
	public <T> void update(T t);
	
    public FootballMatch getFootballMatchByZid(String zid,String typeCode);
    
    public void save(FootballMatch footballMatch);
    
	public void update(FootballMatch footballMatch);
	
	/**
	 * 根据期数和主队、客队获取比赛信息
	 * @param lotteryPeriod
	 * @param home
	 * @param away
	 * @return
	 */
	public FootballMatch getFootballMatchByExpectAndTeam(
			String typeCode,String lotteryPeriod,String home,String away);
	
	
	/**
	 * 更加实例属性，查找实例
	 * @param entityName
	 * @param propertyNames
	 * @param value
	 * @return
	 */
	public List findByProperty(String entityName,List<String> propertyNames,List<String> values);
	
	/**
	 * 根据当前期、修改其他排期状态、规则如下
	 * 1.小于当前期的都设置成历史排期
	 * 2.大于当前期的都设置成预售排期
	 * @param typeCode  	类型编号
	 * @param currentPeriod 当前排期号
	 */
	public void updateLotteryPeriodStatus(String typeCode,String currentPeriod);
}
