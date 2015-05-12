package I000.common;

import java.util.Date;

public class ConstantConfig {
	private String constantConfigId;
    private String configKey;
    private String configValue;
    private Date configType;
    private Date updateDate;
    private Date createDate;
    
	public String getConstantConfigId() {
		return constantConfigId;
	}
	public void setConstantConfigId(String constantConfigId) {
		this.constantConfigId = constantConfigId;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public Date getConfigType() {
		return configType;
	}
	public void setConfigType(Date configType) {
		this.configType = configType;
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

    
}
