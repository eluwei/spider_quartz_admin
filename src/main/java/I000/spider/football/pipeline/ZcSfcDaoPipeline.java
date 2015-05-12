package I000.spider.football.pipeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import I000.common.StaticFinalString;
import I000.common.vo.LotteryPeriod;
import I000.spider.football.dao.FootballMatchDao;
import I000.spider.football.model.FootballMatch;
import I000.spider.football.model.ZcSfcMatchList;

/**
 * 足彩 胜负彩  任选九场进球
 * @author vivian 陈文安
 * @since  2014-03-23
 */
@Component("ZcSfcDaoPipeline")
public class ZcSfcDaoPipeline implements PageModelPipeline<ZcSfcMatchList>{

	@Resource
    private FootballMatchDao footballMatchDao;
	public FootballMatchDao getFootballMatchDao() {
		return footballMatchDao;
	}
	public void setFootballMatchDao(FootballMatchDao footballMatchDao) {
		this.footballMatchDao = footballMatchDao;
	}
	
	@Override
    public void process(ZcSfcMatchList sfcMatchList, Task task) {
        
        String lotteryPeriod = sfcMatchList.getLotteryPeriod();
        String periodNum = lotteryPeriod.substring(3);
        periodNum = periodNum.substring(0, periodNum.length()-1);
        
        //新增排期、或者返回空字符串
        Integer periodIdSfc  = saveNewLotteryPeriodSfc(periodNum);
        Integer periodIdRx9  = saveNewLotteryPeriodRx9(periodNum);
        if(lotteryPeriod.contains("当前期")){
        	changeLotteryPeriodStatusSfc(periodNum);
        	changeLotteryPeriodStatusRx9(periodNum);
        }
        
        List<String> pdateList = sfcMatchList.getPdateList();
        List<String> leagueList = sfcMatchList.getLeagueList();
        List<String> homesxnameList = sfcMatchList.getHomesxnameList();
        //页面改版，占时可以不用 2014/06/15
        /*List<String> nspfList = sfcMatchList.getNspfList();
        List<String> spfList = sfcMatchList.getSpfList();*/
        
        if(pdateList!=null&&pdateList.size()>0){
            for(int i=0;i<pdateList.size()/15;i++){
            	try {
            		String pdate = pdateList.get(i*15).trim();
            		String homesxname = homesxnameList.get(i*2).trim();
            		String awaysname = homesxnameList.get(i*2+1).trim();
                	if(lotteryPeriod!=null&&!"".equals(lotteryPeriod.trim())){
                		FootballMatch footballMatchOldSfc = 
                				footballMatchDao.getFootballMatchByExpectAndTeam(
                						StaticFinalString.FOOTBALL_ZC_SFC_CODE,
                						periodNum,homesxname,awaysname);
                		FootballMatch footballMatchOldRx9 = 
                				footballMatchDao.getFootballMatchByExpectAndTeam(
                						StaticFinalString.FOOTBALL_ZC_RX9_CODE,
                						periodNum,homesxname,awaysname);
                    	if(footballMatchOldSfc==null){
                    		
                    		//胜负彩
                    		FootballMatch footballMatch = new FootballMatch();
                    		footballMatch.setGameNum(i+1+"");
                    		footballMatch.setTypeCode(StaticFinalString.FOOTBALL_ZC_SFC_CODE);
                    		footballMatch.setTypeName(StaticFinalString.FOOTBALL_ZC_SFC_NAME);
                    		footballMatch.setPdate(pdate);
                    		footballMatch.setLeague(leagueList.get(i));
                    		footballMatch.setLotteryPeriodId(periodIdSfc);
                    		footballMatch.setExpect(periodNum);
                    		footballMatch.setHomesxname(homesxname);
                    		footballMatch.setAwaysxname(awaysname);
                    		footballMatch.setNspf1(pdateList.get(i*15+1));
                    		footballMatch.setNspf2(pdateList.get(i*15+2));
                    		footballMatch.setNspf3(pdateList.get(i*15+3));
                    		footballMatch.setSpf1(pdateList.get(i*15+12));
                    		footballMatch.setSpf2(pdateList.get(i*15+13));
                    		footballMatch.setSpf3(pdateList.get(i*15+14));
                    		footballMatch.setCreateDate(new Date());
                    		footballMatch.setUpdateDate(new Date());
                    		footballMatchDao.save(footballMatch);
                    		
                    		//任选九场 跟胜负彩共享同一份数据、只是彩票类型不一样
                    		FootballMatch footballMatch2 = new FootballMatch();
                    		footballMatch2.setGameNum(i+1+"");
                    		footballMatch2.setTypeCode(StaticFinalString.FOOTBALL_ZC_RX9_CODE);
                    		footballMatch2.setTypeName(StaticFinalString.FOOTBALL_ZC_RX9_NAME);
                    		footballMatch2.setPdate(pdate);
                    		footballMatch2.setLeague(leagueList.get(i));
                    		footballMatch2.setLotteryPeriodId(periodIdRx9);
                    		footballMatch2.setExpect(periodNum);
                    		footballMatch2.setHomesxname(homesxname);
                    		footballMatch2.setAwaysxname(awaysname);
                    		footballMatch2.setNspf1(pdateList.get(i*15+1));
                    		footballMatch2.setNspf2(pdateList.get(i*15+2));
                    		footballMatch2.setNspf3(pdateList.get(i*15+3));
                    		footballMatch2.setSpf1(pdateList.get(i*15+12));
                    		footballMatch2.setSpf2(pdateList.get(i*15+13));
                    		footballMatch2.setSpf3(pdateList.get(i*15+14));
                    		footballMatch2.setCreateDate(new Date());
                    		footballMatch2.setUpdateDate(new Date());
                    		footballMatchDao.save(footballMatch2);
    						
                    	}else{
                    		footballMatchOldSfc.setGameNum(i+1+"");
                    		footballMatchOldSfc.setTypeCode(StaticFinalString.FOOTBALL_ZC_SFC_CODE);
                    		footballMatchOldSfc.setTypeName(StaticFinalString.FOOTBALL_ZC_SFC_NAME);
                    		footballMatchOldSfc.setPdate(pdate);
                    		footballMatchOldSfc.setLeague(leagueList.get(i));
                    		footballMatchOldSfc.setHomesxname(homesxname);
                    		footballMatchOldSfc.setAwaysxname(awaysname);
                    		footballMatchOldSfc.setNspf1(pdateList.get(i*15+1));
                    		footballMatchOldSfc.setNspf2(pdateList.get(i*15+2));
                    		footballMatchOldSfc.setNspf3(pdateList.get(i*15+3));
                    		footballMatchOldSfc.setSpf1(pdateList.get(i*15+12));
                    		footballMatchOldSfc.setSpf2(pdateList.get(i*15+13));
                    		footballMatchOldSfc.setSpf3(pdateList.get(i*15+14));
                    		footballMatchOldSfc.setUpdateDate(new Date());
                    		footballMatchDao.update(footballMatchOldSfc);
                    		
                    		//胜负彩、任选9 同一份数据  保存两次  唯独 彩票类型type_code不一样
                    		footballMatchOldRx9.setGameNum(i+1+"");
                    		footballMatchOldRx9.setTypeCode(StaticFinalString.FOOTBALL_ZC_RX9_CODE);
                    		footballMatchOldRx9.setTypeName(StaticFinalString.FOOTBALL_ZC_RX9_NAME);
                    		footballMatchOldRx9.setPdate(pdate);
                    		footballMatchOldRx9.setLeague(leagueList.get(i));
                    		footballMatchOldRx9.setHomesxname(homesxname);
                    		footballMatchOldRx9.setAwaysxname(awaysname);
                    		footballMatchOldRx9.setNspf1(pdateList.get(i*15+1));
                    		footballMatchOldRx9.setNspf2(pdateList.get(i*15+2));
                    		footballMatchOldRx9.setNspf3(pdateList.get(i*15+3));
                    		footballMatchOldRx9.setSpf1(pdateList.get(i*15+12));
                    		footballMatchOldRx9.setSpf2(pdateList.get(i*15+13));
                    		footballMatchOldRx9.setSpf3(pdateList.get(i*15+14));
                    		footballMatchOldRx9.setUpdateDate(new Date());
                    		footballMatchDao.update(footballMatchOldSfc);
                    	}
                	}
            	} catch (Exception e) {
					e.printStackTrace();
				}
            }
        }
	}
	
	/**
	 * 如果该排期已经存 返回空字符串、
	 * 否则新增排期并返回记录ID
	 * @param period
	 * @return
	 */
	private Integer saveNewLotteryPeriodSfc(String period){
		
		List<String> propertyParmas = new ArrayList<String>();
		propertyParmas.add("lotteryCode");
		propertyParmas.add("lotteryPeriod");
		List<String> propertyValues = new ArrayList<String>();
		propertyValues.add(StaticFinalString.FOOTBALL_ZC_SFC_CODE);
		propertyValues.add(period);
		List periods = footballMatchDao.findByProperty("LotteryPeriod",propertyParmas,propertyValues);
		if(periods!=null&&periods.size()>0){
			return 0;
		}
		
		LotteryPeriod lotteryPeriod = new LotteryPeriod();
		lotteryPeriod.setLotteryCode(StaticFinalString.FOOTBALL_ZC_SFC_CODE);
		lotteryPeriod.setCreateDate(new Date());
		lotteryPeriod.setUpdateDate(new Date());
		lotteryPeriod.setLotteryPeriod(period);
		//暂时设置为预售排期
		lotteryPeriod.setStatus(StaticFinalString.PERIOD_TYPE_FUTURE);
		footballMatchDao.save(lotteryPeriod);
		
		return lotteryPeriod.getId();
	}
	
	//胜负彩、任选9场 同一份数据、保存两次
	private Integer saveNewLotteryPeriodRx9(String period){
		
		List<String> propertyParmas = new ArrayList<String>();
		propertyParmas.add("lotteryCode");
		propertyParmas.add("lotteryPeriod");
		List<String> propertyValues = new ArrayList<String>();
		propertyValues.add(StaticFinalString.FOOTBALL_ZC_RX9_CODE);
		propertyValues.add(period);
		List periods = footballMatchDao.findByProperty("LotteryPeriod",propertyParmas,propertyValues);
		if(periods!=null&&periods.size()>0){
			return 0;
		}
		
		LotteryPeriod lotteryPeriod = new LotteryPeriod();
		lotteryPeriod.setLotteryCode(StaticFinalString.FOOTBALL_ZC_RX9_CODE);
		lotteryPeriod.setCreateDate(new Date());
		lotteryPeriod.setUpdateDate(new Date());
		lotteryPeriod.setLotteryPeriod(period);
		//暂时设置为预售排期
		lotteryPeriod.setStatus(StaticFinalString.PERIOD_TYPE_FUTURE);
		footballMatchDao.save(lotteryPeriod);
		
		return lotteryPeriod.getId();
	}
	
	/**
	 * 根据当前期、修改其他排期状态、规则如下
	 * 1.小于当前期的都设置成历史排期
	 * 2.大于当前期的都设置成预售排期
	 * @param currentLotteryExpect
	 */
	private void changeLotteryPeriodStatusSfc(String currentLotteryExpect){
		footballMatchDao.updateLotteryPeriodStatus(StaticFinalString.FOOTBALL_ZC_SFC_CODE,currentLotteryExpect);
	}
	
	//胜负彩、任选9场 同一份数据、保存两次
	private void changeLotteryPeriodStatusRx9(String currentLotteryExpect){
		footballMatchDao.updateLotteryPeriodStatus(StaticFinalString.FOOTBALL_ZC_RX9_CODE,currentLotteryExpect);
	}
	
}
