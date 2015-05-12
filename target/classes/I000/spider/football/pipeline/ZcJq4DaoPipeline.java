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
import I000.spider.football.model.ZcJq4MatchList;

/**
 * 足彩    足彩   四场进球   
 * @author vivian 陈文安
 * @since  2014-06-14
 */
@Component("ZcJq4DaoPipeline")
public class ZcJq4DaoPipeline implements PageModelPipeline<ZcJq4MatchList>{

	@Resource
    private FootballMatchDao footballMatchDao;
	public FootballMatchDao getFootballMatchDao() {
		return footballMatchDao;
	}
	public void setFootballMatchDao(FootballMatchDao footballMatchDao) {
		this.footballMatchDao = footballMatchDao;
	}
	
	@Override
    public void process(ZcJq4MatchList sfcMatchList, Task task) {
        //System.out.println("ZcJq4MatchList:"+sfcMatchList);
        
        String lotteryPeriod = sfcMatchList.getLotteryPeriod();
        String periodNum = lotteryPeriod.substring(3);
        periodNum = periodNum.substring(0, periodNum.length()-1);
        
        //新增排期、或者返回空字符串
        Integer periodId  = saveNewLotteryPeriod(periodNum);
        if(lotteryPeriod.contains("当前期")){
        	//System.out.println("-----胜负彩  当前期-------"+periodNum);
        	changeLotteryPeriodStatus(periodNum);
        }
        
        List<String> pdateList = sfcMatchList.getPdateList();
        List<String> leagueList = sfcMatchList.getLeagueList();
        List<String> homesxnameList = sfcMatchList.getHomesxnameList();
        //页面改版，占时可以不用 2014/06/15
        //List<String> spfList = sfcMatchList.getSpfList();
        
        if(pdateList!=null&&pdateList.size()>0){
        	int k=0;//用于排除掉空的字符串
            for(int i=0;i<pdateList.size()/12;i++){
            	try {
            		String pdate = pdateList.get(i*12).trim();
            		while("".equals(homesxnameList.get(i+k).trim())){
            			k += 1;
            		}
            		String homesxname = homesxnameList.get(i*2+k).trim();
            		String awaysname = homesxnameList.get(i*2+k+1).trim();
            		
                	if(lotteryPeriod!=null&&!"".equals(lotteryPeriod.trim())){
                		FootballMatch footballMatchOld = 
                				footballMatchDao.getFootballMatchByExpectAndTeam(
                						StaticFinalString.FOOTBALL_ZC_JQ4_CODE,
                						periodNum,homesxname,awaysname);
                    	if(footballMatchOld==null){
                    		FootballMatch footballMatch = new FootballMatch();
                    		
                    		footballMatch.setGameNum(i+1+"");
                    		footballMatch.setTypeCode(StaticFinalString.FOOTBALL_ZC_JQ4_CODE);
                    		footballMatch.setTypeName(StaticFinalString.FOOTBALL_ZC_JQ4_NAME);
                    		footballMatch.setPdate(pdate);
                    		footballMatch.setLeague(leagueList.get(i));
                    		
                    		footballMatch.setLotteryPeriodId(periodId);
                    		footballMatch.setExpect(periodNum);
                    		
                    		footballMatch.setHomesxname(homesxname);
                    		footballMatch.setAwaysxname(awaysname);
                    		
                    		footballMatch.setNspf1(pdateList.get(i*12+1));
                    		footballMatch.setNspf2(pdateList.get(i*12+2));
                    		footballMatch.setNspf3(pdateList.get(i*12+3));
                    		footballMatch.setSpf1(pdateList.get(i*12+4));
                    		footballMatch.setSpf2(pdateList.get(i*12+5));
                    		footballMatch.setSpf3(pdateList.get(i*12+6));
                    		footballMatch.setSpf4(pdateList.get(i*12+7));
                    		footballMatch.setSpf5(pdateList.get(i*12+8));
                    		footballMatch.setSpf6(pdateList.get(i*12+9));
                    		footballMatch.setSpf7(pdateList.get(i*12+10));
                    		footballMatch.setSpf8(pdateList.get(i*12+11));
                    		
                    		footballMatch.setCreateDate(new Date());
                    		footballMatch.setUpdateDate(new Date());
                    		
                    		//System.out.println("ZcJq4MatchList:"+footballMatch);
                    		footballMatchDao.save(footballMatch);
    						
                    	}else{
                    		footballMatchOld.setGameNum(i+1+"");
                    		footballMatchOld.setTypeCode(StaticFinalString.FOOTBALL_ZC_JQ4_CODE);
                    		footballMatchOld.setTypeName(StaticFinalString.FOOTBALL_ZC_JQ4_NAME);
                    		footballMatchOld.setPdate(pdate);
                    		footballMatchOld.setLeague(leagueList.get(i));
                    		
                    		footballMatchOld.setHomesxname(homesxname);
                    		footballMatchOld.setAwaysxname(awaysname);
                    		
                    		footballMatchOld.setNspf1(pdateList.get(i*12+1));
                    		footballMatchOld.setNspf2(pdateList.get(i*12+2));
                    		footballMatchOld.setNspf3(pdateList.get(i*12+3));
                    		footballMatchOld.setSpf1(pdateList.get(i*12+4));
                    		footballMatchOld.setSpf2(pdateList.get(i*12+5));
                    		footballMatchOld.setSpf3(pdateList.get(i*12+6));
                    		footballMatchOld.setSpf4(pdateList.get(i*12+7));
                    		footballMatchOld.setSpf5(pdateList.get(i*12+8));
                    		footballMatchOld.setSpf6(pdateList.get(i*12+9));
                    		footballMatchOld.setSpf7(pdateList.get(i*12+10));
                    		footballMatchOld.setSpf8(pdateList.get(i*12+11));
                    		
                    		footballMatchOld.setUpdateDate(new Date());
                    		
                    		//System.out.println("ZcJq4MatchList:"+footballMatchOld);
                    		footballMatchDao.update(footballMatchOld);
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
	private Integer saveNewLotteryPeriod(String period){
		
		List<String> propertyParmas = new ArrayList<String>();
		propertyParmas.add("lotteryCode");
		propertyParmas.add("lotteryPeriod");
		List<String> propertyValues = new ArrayList<String>();
		propertyValues.add(StaticFinalString.FOOTBALL_ZC_JQ4_CODE);
		propertyValues.add(period);
		List periods = footballMatchDao.findByProperty("LotteryPeriod",propertyParmas,propertyValues);
		if(periods!=null&&periods.size()>0){
			return 0;
		}
		
		LotteryPeriod lotteryPeriod = new LotteryPeriod();
		lotteryPeriod.setLotteryCode(StaticFinalString.FOOTBALL_ZC_JQ4_CODE);
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
	private void changeLotteryPeriodStatus(String currentLotteryExpect){
		footballMatchDao.updateLotteryPeriodStatus(StaticFinalString.FOOTBALL_ZC_JQ4_CODE,currentLotteryExpect);
	}
}
