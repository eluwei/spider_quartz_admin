package I000.spider.football.model;

import java.util.Date;

public class BetDate {
	private Integer betDateId;
    private String dayDate;
    private String matchInfo;
    private Date updateDate;
    private Date createDate;

	public Integer getBetDateId() {
		return betDateId;
	}
	public void setBetDateId(Integer betDateId) {
		this.betDateId = betDateId;
	}
	public String getDayDate() {
		return dayDate;
	}
	public void setDayDate(String dayDate) {
		this.dayDate = dayDate;
	}
	public String getMatchInfo() {
		return matchInfo;
	}
	public void setMatchInfo(String matchInfo) {
		this.matchInfo = matchInfo;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
    public String toString() {
        return "bet_date{" +
                "day_date='" + dayDate + '\'' +
                ", match_info='" + matchInfo + '\'' +
                '}';
	}
}
