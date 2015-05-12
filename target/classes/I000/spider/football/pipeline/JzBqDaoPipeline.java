package I000.spider.football.pipeline;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import I000.common.StaticFinalString;
import I000.spider.football.dao.FootballMatchDao;
import I000.spider.football.model.FootballMatch;
import I000.spider.football.model.JzBqMatchList;
/**
 * 竞足 半全场
 * @author pingan
 *
 */

@Component("JzBqDaoPipeline")
public class JzBqDaoPipeline implements PageModelPipeline<JzBqMatchList>{
	@Resource
    private FootballMatchDao footballMatchDao;
	public FootballMatchDao getFootballMatchDao() {
		return footballMatchDao;
	}
	public void setFootballMatchDao(FootballMatchDao footballMatchDao) {
		this.footballMatchDao = footballMatchDao;
	}

	@Override
    public void process(JzBqMatchList footballMatchList, Task task) {
        System.out.println("------------JzBqMatchList:"+footballMatchList);
        
        List<String> zidList = footballMatchList.getZidList();
        List<String> pdateList = footballMatchList.getPdateList();
        List<String> gameNumList = footballMatchList.getGameNumList();
        List<String> leagueList = footballMatchList.getLeagueList();
        List<String> endTimeList = footballMatchList.getEndTimeList();
        List<String> homesxnameList = footballMatchList.getHomesxnameList();
        List<String> awaysxnameList = footballMatchList.getAwaysxnameList();
        List<String> spfList = footballMatchList.getSpfList();
        
        if(zidList!=null&&zidList.size()>0){
        	int j = 0;
            for(int i=0;i<zidList.size();i++){
            	try {
            		String zid = zidList.get(i);
                	if(zid!=null&&!"".equals(zid.trim())){
                		j = j+1;
                		FootballMatch footballMatchOld = 
                				footballMatchDao.getFootballMatchByZid(zid.trim(),StaticFinalString.FOOTBALL_JCZQ_BQC_CODE);
                    	if(footballMatchOld==null){
                    		FootballMatch footballMatch = new FootballMatch();
                    		
                    		footballMatch.setZid(zidList.get(i).trim());
                    		footballMatch.setTypeCode(StaticFinalString.FOOTBALL_JCZQ_BQC_CODE);
                    		footballMatch.setTypeName(StaticFinalString.FOOTBALL_JCZQ_BQC_NAME);
                    		footballMatch.setPdate(pdateList.get(i));
                    		if(i>=gameNumList.size())
                    			break;
                    		footballMatch.setGameNum(gameNumList.get(j));
                    		footballMatch.setLeague(leagueList.get(j));
                    		footballMatch.setEndTime(endTimeList.get(j));
                    		footballMatch.setAwaysxname(awaysxnameList.get(j));
                    		footballMatch.setHomesxname(homesxnameList.get(j));
                    		if(j*7>=spfList.size()){
                        		break;
                    		}
                    		footballMatch.setNspf1(spfList.get(j*7));
                    		footballMatch.setNspf2(spfList.get(j*7+1));
                    		footballMatch.setNspf3(spfList.get(j*7+2));
                    		footballMatch.setNspf4(spfList.get(j*7+3));
                    		footballMatch.setNspf5(spfList.get(j*7+4));
                    		footballMatch.setNspf6(spfList.get(j*7+5));
                    		footballMatch.setSpf1(spfList.get(j*7+6));
                    		footballMatch.setSpf2(spfList.get(j*7+7));
                    		footballMatch.setSpf3(spfList.get(j*7+8));
                    		footballMatch.setCreateDate(new Date());
                    		footballMatch.setUpdateDate(new Date());
                    		
                    		//System.out.println("footballMatch:"+footballMatch);
                    		footballMatchDao.save(footballMatch);
    						
                    	}else{
                    		footballMatchOld.setZid(zidList.get(i).trim());
                    		footballMatchOld.setTypeCode(StaticFinalString.FOOTBALL_JCZQ_BQC_CODE);
                    		footballMatchOld.setTypeName(StaticFinalString.FOOTBALL_JCZQ_BQC_NAME);
                    		footballMatchOld.setPdate(pdateList.get(i));
                    		if(i>=gameNumList.size())
                    			break;
                    		footballMatchOld.setGameNum(gameNumList.get(j));
                    		footballMatchOld.setLeague(leagueList.get(j));
                    		footballMatchOld.setEndTime(endTimeList.get(j));
                    		footballMatchOld.setAwaysxname(awaysxnameList.get(j));
                    		footballMatchOld.setHomesxname(homesxnameList.get(j));
                    		if(j*7>=spfList.size()){
                        		break;
                    		}
                    		footballMatchOld.setNspf1(spfList.get(j*7));
                    		footballMatchOld.setNspf2(spfList.get(j*7+1));
                    		footballMatchOld.setNspf3(spfList.get(j*7+2));
                    		footballMatchOld.setNspf4(spfList.get(j*7+3));
                    		footballMatchOld.setNspf5(spfList.get(j*7+4));
                    		footballMatchOld.setNspf6(spfList.get(j*7+5));
                    		footballMatchOld.setSpf1(spfList.get(j*7+6));
                    		footballMatchOld.setSpf2(spfList.get(j*7+7));
                    		footballMatchOld.setSpf3(spfList.get(j*7+8));
                    		footballMatchOld.setUpdateDate(new Date());
                    		
                    		//System.out.println("footballMatchOld:"+footballMatchOld);
                    		footballMatchDao.update(footballMatchOld);
                    	}
                	}
            	} catch (Exception e) {
					e.printStackTrace();
				}
            }
        }
    }
}
