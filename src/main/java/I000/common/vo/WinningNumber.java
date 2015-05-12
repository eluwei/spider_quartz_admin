package I000.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 彩票开奖结果
 * @author pingan
 *
 */

public class WinningNumber implements Serializable{
	private static final long serialVersionUID = 6597038181845234547L;
	private Integer winningNumberId;
    private String expect;
    private String opencode;
    private Date opentime;
    private Date updateDate;
    private Date createDate;
    private String typeCode;
    private String typeName;
    private String tryCode;
    private String ballsnum;
    private String typeArea;
    
	public Integer getWinningNumberId() {
		return winningNumberId;
	}
	public void setWinningNumberId(Integer winningNumberId) {
		this.winningNumberId = winningNumberId;
	}
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}
	public String getOpencode() {
		return opencode;
	}
	public void setOpencode(String opencode) {
		this.opencode = opencode;
	}
	public Date getOpentime() {
		return opentime;
	}
	public void setOpentime(Date opentime) {
		this.opentime = opentime;
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
	public String getTryCode() {
		return tryCode;
	}
	public void setTryCode(String tryCode) {
		this.tryCode = tryCode;
	}
	public String getBallsnum() {
		return ballsnum;
	}
	public void setBallsnum(String ballsnum) {
		this.ballsnum = ballsnum;
	}
	public String getTypeArea() {
		return typeArea;
	}
	public void setTypeArea(String typeArea) {
		this.typeArea = typeArea;
	}
    
}
