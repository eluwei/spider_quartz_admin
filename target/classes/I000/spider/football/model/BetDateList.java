package I000.spider.football.model;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://trade.500.com/jczq/*")
public class BetDateList implements AfterExtractor{
	
    @ExtractBy(value = "//div[@class='bet_date']/text()",multi=true)
    private List<String> dayDateList;
    @ExtractBy(value = "//div[@class='bet_date']/a/text()",multi=true)
    private List<String> matchInfoList;
    
	public List<String> getDayDateList() {
		return dayDateList;
	}
	public void setDayDateList(List<String> dayDateList) {
		this.dayDateList = dayDateList;
	}
	public List<String> getMatchInfoList() {
		return matchInfoList;
	}
	public void setMatchInfoList(List<String> matchInfoList) {
		this.matchInfoList = matchInfoList;
	}

	@Override
    public String toString() {
        return "bet_date{" +
                "dayDateList='" + dayDateList + '\'' +
                ", matchInfoList='" + matchInfoList + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {
        //System.out.println("BetDateList拼装完毕");
    }
}
