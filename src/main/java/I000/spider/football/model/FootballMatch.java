package I000.spider.football.model;

import java.io.Serializable;
import java.util.Date;
/**
 *  足球比赛信息通用实体
 *  包含：竞彩足球、足彩胜负、任选9场、6场半全场、4场进球彩
 * @author vivian.chen 陈文安
 * @since  2014-03-18
 *
 */

public class FootballMatch implements Serializable{

	private static final long serialVersionUID = 2400701508523147985L;
	
	private Integer footballMatchId;
	private String typeCode;
	private String typeName;
	private String pdate;
	private String zid;
	private Integer lotteryPeriodId;
	private String expect;
	private String gameNum;
	private String league;
	private String endTime;
	private String concedeTLineGreen;
	private String homesxname;
	private String awaysxname;
	private String nspf1;
	private String nspf2;
	private String nspf3;
	private String nspf4;
	private String nspf5;
	private String nspf6;
	private String spf1;
	private String spf2;
	private String spf3;
	private String spf4;
	private String spf5;
	private String spf6;
	private String spf7;
	private String spf8;
	private Date updateDate;
	private Date createDate;
	
	public Integer getFootballMatchId() {
		return footballMatchId;
	}
	public void setFootballMatchId(Integer footballMatchId) {
		this.footballMatchId = footballMatchId;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getZid() {
		return zid;
	}
	public void setZid(String zid) {
		this.zid = zid;
	}
	public String getGameNum() {
		return gameNum;
	}
	public void setGameNum(String gameNum) {
		this.gameNum = gameNum;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getConcedeTLineGreen() {
		return concedeTLineGreen;
	}
	public void setConcedeTLineGreen(String concedeTLineGreen) {
		this.concedeTLineGreen = concedeTLineGreen;
	}
	public String getHomesxname() {
		return homesxname;
	}
	public void setHomesxname(String homesxname) {
		this.homesxname = homesxname;
	}
	public String getAwaysxname() {
		return awaysxname;
	}
	public void setAwaysxname(String awaysxname) {
		this.awaysxname = awaysxname;
	}
	public String getNspf1() {
		return nspf1;
	}
	public void setNspf1(String nspf1) {
		this.nspf1 = nspf1;
	}
	public String getNspf2() {
		return nspf2;
	}
	public void setNspf2(String nspf2) {
		this.nspf2 = nspf2;
	}
	public String getNspf3() {
		return nspf3;
	}
	public void setNspf3(String nspf3) {
		this.nspf3 = nspf3;
	}
	public String getSpf1() {
		return spf1;
	}
	public void setSpf1(String spf1) {
		this.spf1 = spf1;
	}
	public String getSpf2() {
		return spf2;
	}
	public void setSpf2(String spf2) {
		this.spf2 = spf2;
	}
	public String getSpf3() {
		return spf3;
	}
	public void setSpf3(String spf3) {
		this.spf3 = spf3;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getNspf4() {
		return nspf4;
	}
	public void setNspf4(String nspf4) {
		this.nspf4 = nspf4;
	}
	public String getNspf5() {
		return nspf5;
	}
	public void setNspf5(String nspf5) {
		this.nspf5 = nspf5;
	}
	public String getNspf6() {
		return nspf6;
	}
	public void setNspf6(String nspf6) {
		this.nspf6 = nspf6;
	}
	public String getSpf4() {
		return spf4;
	}
	public void setSpf4(String spf4) {
		this.spf4 = spf4;
	}
	public String getSpf5() {
		return spf5;
	}
	public void setSpf5(String spf5) {
		this.spf5 = spf5;
	}
	public String getSpf6() {
		return spf6;
	}
	public void setSpf6(String spf6) {
		this.spf6 = spf6;
	}
	public String getSpf7() {
		return spf7;
	}
	public void setSpf7(String spf7) {
		this.spf7 = spf7;
	}
	public String getSpf8() {
		return spf8;
	}
	public void setSpf8(String spf8) {
		this.spf8 = spf8;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}
	public Integer getLotteryPeriodId() {
		return lotteryPeriodId;
	}
	public void setLotteryPeriodId(Integer lotteryPeriodId) {
		this.lotteryPeriodId = lotteryPeriodId;
	}
}
