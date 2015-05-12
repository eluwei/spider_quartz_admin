package I000.spider.football.model;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * 竞彩  进球
 * 数据来源 网易彩票
 * @author vivian
 * @since  2014-07-12
 */
@TargetUrl("http://caipiao.163.com/order/jczq-jinqiu/")
public class JzJqsMatchList implements AfterExtractor{
	
	@ExtractBy(value = "//dd//@matchnumcn",multi=true)
	private List<String> pdateList;
	@ExtractBy(value = "//dd//@matchcode",multi=true)
	private List<String> zidList;
	@ExtractBy(value = "//span[@class='co1']/i/text()",multi=true)
	private List<String> gameNumList;
	@ExtractBy(value = "//span[@class='co2']/a/text()",multi=true)
	private List<String> leagueList;
	@ExtractBy(value = "//span[@class='co3 gameTime']/text()",multi=true)
	private List<String> endTimeList;
	@ExtractBy(value = "//em[@class='hostTeam']/b/text()",multi=true)
	private List<String> homesxnameList;
	@ExtractBy(value = "//em[@class='guestTeam']/b/text()",multi=true)
	private List<String> awaysxnameList;
	@ExtractBy(value = "//em[@gametype='zjq']/text()",multi=true)
	private List<String> spfList;
	
	
	public List<String> getPdateList() {
		return pdateList;
	}
	public void setPdateList(List<String> pdateList) {
		this.pdateList = pdateList;
	}
	public List<String> getZidList() {
		return zidList;
	}
	public void setZidList(List<String> zidList) {
		this.zidList = zidList;
	}
	public List<String> getGameNumList() {
		return gameNumList;
	}
	public void setGameNumList(List<String> gameNumList) {
		this.gameNumList = gameNumList;
	}
	public List<String> getLeagueList() {
		return leagueList;
	}
	public void setLeagueList(List<String> leagueList) {
		this.leagueList = leagueList;
	}
	public List<String> getEndTimeList() {
		return endTimeList;
	}
	public void setEndTimeList(List<String> endTimeList) {
		this.endTimeList = endTimeList;
	}
	public List<String> getHomesxnameList() {
		return homesxnameList;
	}
	public void setHomesxnameList(List<String> homesxnameList) {
		this.homesxnameList = homesxnameList;
	}
	public List<String> getAwaysxnameList() {
		return awaysxnameList;
	}
	public void setAwaysxnameList(List<String> awaysxnameList) {
		this.awaysxnameList = awaysxnameList;
	}
	public List<String> getSpfList() {
		return spfList;
	}
	public void setSpfList(List<String> spfList) {
		this.spfList = spfList;
	}
	
	@Override
    public String toString() {
        return "JzSfpMatchList{" +
        	  "zidList='" + zidList + '\'' +
               "gameNumList='" + gameNumList + '\'' +
                ", leagueList='" + leagueList + '\'' +
                 ", endTimeList='" + endTimeList + '\'' +
                   ", homesxnameList='" + homesxnameList + '\'' +
                    ", awaysxnameList='" + awaysxnameList + '\'' +
                      ", spfList='" + spfList + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {
        //System.out.println("JzJqsMatchList拼装完毕");
    }
}
