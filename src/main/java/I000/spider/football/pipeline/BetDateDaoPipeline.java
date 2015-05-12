package I000.spider.football.pipeline;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import I000.spider.football.dao.BetDateDao;
import I000.spider.football.model.BetDate;
import I000.spider.football.model.BetDateList;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component("BetDateDaoPipeline")
public class BetDateDaoPipeline implements PageModelPipeline<BetDateList> {

	@Resource
    private BetDateDao betDateDao;

    public BetDateDao getBetDateDao() {
		return betDateDao;
	}

	public void setBetDateDao(BetDateDao betDateDao) {
		this.betDateDao = betDateDao;
	}


	@Override
    public void process(BetDateList betDateList, Task task) {
        System.out.println("BetDateDaoPipeline:"+betDateList);
        
        List<String> dayDateList = betDateList.getDayDateList();
        List<String> matchInfoList = betDateList.getMatchInfoList();
        if(dayDateList!=null&&dayDateList.size()>0){
            for(int i=0;i<dayDateList.size();i++){
            	try {
            		String dayDate = dayDateList.get(i);
                	String matchInfo = matchInfoList.get(i);
                	BetDate betDateOld = betDateDao.getBetDateByDayDate(dayDate.trim());
                	if(betDateOld==null){
                		BetDate betDate = new BetDate();
                		betDate.setDayDate(dayDate.trim());
                		betDate.setMatchInfo(matchInfo.trim());
                		betDate.setCreateDate(new Date());
                		betDate.setUpdateDate(new Date());
                		betDateDao.save(betDate);
                	}else{
                		betDateOld.setDayDate(dayDate.trim());
                		betDateOld.setMatchInfo(matchInfo.trim());
                		betDateOld.setUpdateDate(new Date());
                		betDateDao.update(betDateOld);
                	}
				} catch (Exception e) {
					e.printStackTrace();
				}
            	
            }
        }
    }
}
