package I000.spider.football.model;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * 足球 胜负彩 比赛信息
 * @author vivian 陈文安
 * @since  2014-03-23 
 */
@TargetUrl("http://trade.500.com/sfc/*")
public class ZcSfcMatchList implements AfterExtractor{

	//彩票期数
	@ExtractBy(value = "//span[@id='expect_tab']/a[@class='on']/text()")
	private String lotteryPeriod;
	
	@ExtractBy(value = "//a/@data-val",multi=true)
	private List<String> expectList;
	@ExtractBy(value = "//td[@class='league']/a/text()",multi=true)
	private List<String> leagueList;
	@ExtractBy(value = "//td/span[@class='eng']/text()",multi=true)
	private List<String> pdateList;	
	@ExtractBy(value = "//span[@class='sp_dm']/a/text()",multi=true)
	private List<String> homesxnameList;
	@ExtractBy(value = "//span[@class='sp_w38 eng']/text()",multi=true)
	private List<String> nspfList;
	@ExtractBy(value = "//span[@class='sp_w40 eng']/text()",multi=true)
	private List<String> spfList;	
	
	@Override
    public String toString() {
        return "ZcSfcMatchList{" +
        	  "expectList='" + expectList + '\'' +
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
        //System.out.println("ZcSfcMatchList拼装完毕");
    }
    
    
	public List<String> getExpectList() {
		return expectList;
	}
	public void setExpectList(List<String> expectList) {
		this.expectList = expectList;
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
