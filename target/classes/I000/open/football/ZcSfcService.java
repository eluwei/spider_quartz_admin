package I000.open.football;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import I000.common.StaticFinalString;
import I000.common.dao.CommonDao;
import I000.common.vo.WinningNumber;
/**
 * 胜负彩和任选9场的开奖结果用同一个接口
 * @author vivian.chen 陈文安
 * @since  2014-03-23	
 */
@Component
public class ZcSfcService {

    @Qualifier("commonDaoImpl")
    @Autowired
	private CommonDao commonDao;

	public void getWinningNumber(){
		try {
			List<WinningNumber> list = new ArrayList<WinningNumber>();
			
			String httpUrl = commonDao.getConfigValueByKey(StaticFinalString.CAIPIAOKONG_URL);
			String uid = commonDao.getConfigValueByKey(StaticFinalString.CAIPIAOKONG_UID);
			String openId = commonDao.getConfigValueByKey(StaticFinalString.CAIPIAOKONG_OPENID);
			
			if(httpUrl==null||"".equals(httpUrl)){
				httpUrl = StaticFinalString.CAIPIAOKONG_URL_DEFAULT;
			}
			if(uid==null||"".equals(uid)){
				httpUrl = StaticFinalString.CAIPIAOKONG_UID_DEFAULT;
			}
			if(openId==null||"".equals(openId)){
				openId = StaticFinalString.CAIPIAOKONG_OPENID_DEFAULT;
			}
			
			
			String getUrl = httpUrl+"type="+StaticFinalString.FOOTBALL_ZC_SFC_CAIPIAOKONG+"&uid="+uid+"&openid="+openId;
			
			//GET的URL,参数直接加URL后
			HttpGet httpget=new HttpGet(getUrl);
			//建立HttpPost对象
			HttpResponse response=new DefaultHttpClient().execute(httpget);
			//发送GET,并返回一个HttpResponse对象，相对于POST，省去了添加NameValuePair数组作参数
			if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String returnXml=EntityUtils.toString(response.getEntity());
				Document document = DocumentHelper.parseText(returnXml);
				Element root = document.getRootElement();
				List<Element> rowElements = root.elements();
				for (Element child : rowElements) {
					String openTime = child.attributeValue("opentime");
					WinningNumber winningNumberOld = 
							commonDao.getWinningNumberByTypeAndTime(StaticFinalString.FOOTBALL_ZC_SFC_CODE, openTime);
					if(winningNumberOld==null){
						WinningNumber winningNumber = new WinningNumber();
						
						winningNumber.setExpect(child.attributeValue("expect"));
						winningNumber.setOpencode(child.attributeValue("opencode"));
						winningNumber.setOpentime(sdf.parse(child.attributeValue("opentime")));
						winningNumber.setTypeCode(StaticFinalString.FOOTBALL_ZC_SFC_CODE);
						winningNumber.setTypeName(StaticFinalString.FOOTBALL_ZC_SFC_NAME);
						winningNumber.setTypeArea(StaticFinalString.AREA_NAME_ZC);
						winningNumber.setUpdateDate(new Date());
						winningNumber.setCreateDate(new Date());
						
						list.add(winningNumber);
					}else{
						winningNumberOld.setOpencode(child.attributeValue("opencode"));
						winningNumberOld.setUpdateDate(new Date());
					}
				}
				
				commonDao.saveList(list);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
