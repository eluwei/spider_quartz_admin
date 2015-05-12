package I000.spider.football.model;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * 足球  6场半全   比赛信息
 * @author vivian 陈文安
 * @since  2014-06-14 
 */
@TargetUrl("http://trade.500.com/zc6/*")
public class ZcZc6MatchList implements AfterExtractor{

	//彩票期数
	@ExtractBy(value = "//span[@id='expect_tab']/a[@class='on']/text()")
	private String lotteryPeriod;
	
	@ExtractBy(value = "//td[@class='league']/a/text()",multi=true)
	private List<String> leagueList;
	@ExtractBy(value = "//td/span[@class='eng']/text()",multi=true)
	private List<String> pdateList;	
	@ExtractBy(value = "//span[@class='sp_dm']/a/text()",multi=true)
	private List<String> homesxnameList;
	//页面改版，占时可以不用 2014/06/15
	@ExtractBy(value = "//span[@class='sp_w38 eng']/text()",multi=true)
	private List<String> nspfList;
	//页面改版，占时可以不用 2014/06/15
	@ExtractBy(value = "//span[@class='sp_w40 eng']/text()",multi=true)
	private List<String> spfList;	
	
	@Override
    public String toString() {
        return "ZcSfcMatchList{" +
               "leagueList='" + leagueList + '\'' +
                ", leagueList='" + leagueList + '\'' +
                 ", pdateList='" + pdateList + '\'' +
                   ", homesxnameList='" + homesxnameList + '\'' +
                     ", nspfList='" + nspfList + '\'' +
                      ", spfList='" + spfList + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {
        //System.out.println("ZcZc6MatchList拼装完毕");
    }

	public List<String> getLeagueList() {
		return leagueList;
	}

	public void setLeagueList(List<String> leagueList) {
		this.leagueList = leagueList;
	}

	public List<String> getPdateList() {
		return pdateList;
	}

	public void setPdateList(List<String> pdateList) {
		this.pdateList = pdateList;
	}

	public List<String> getHomesxnameList() {
		return homesxnameList;
	}

	public void setHomesxnameList(List<String> homesxnameList) {
		this.homesxnameList = homesxnameList;
	}

	public List<String> getNspfList() {
		return nspfList;
	}

	public void setNspfList(List<String> nspfList) {
		this.nspfList = nspfList;
	}

	public List<String> getSpfList() {
		return spfList;
	}

	public void setSpfList(List<String> spfList) {
		this.spfList = spfList;
	}

	public String getLotteryPeriod() {
		return lotteryPeriod;
	}

	public void setLotteryPeriod(String lotteryPeriod) {
		this.lotteryPeriod = lotteryPeriod;
	}

}
