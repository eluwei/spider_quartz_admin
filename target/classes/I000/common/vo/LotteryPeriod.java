package I000.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 彩票比赛期数实体
 * @author pingan
 * @since 2014/6/21
 */

public class LotteryPeriod implements Serializable{

	private static final long serialVersionUID = 952290585915441760L;
	private Integer id;
    private String lotteryPeriod;
    private String lotteryCode;// 彩票类型编码
    private Date periodEndTime;//截止时间
    private Date updateDate;
    private Date createDate;
    private Integer status;//状态（0-历史期，1-当前期，2-预售期）
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLotteryPeriod() {
		return lotteryPeriod;
	}
	public void setLotteryPeriod(String lotteryPeriod) {
		this.lotteryPeriod = lotteryPeriod;
	}
	public String getLotteryCode() {
		return lotteryCode;
	}
	public void setLotteryCode(String lotteryCode) {
		this.lotteryCode = lotteryCode;
	}
	public Date getPeriodEndTime() {
		return periodEndTime;
	}
	public void setPeriodEndTime(Date periodEndTime) {
		this.periodEndTime = periodEndTime;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
