package I000.spider.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import I000.spider.football.model.ZcJq4MatchList;
/**
 * 足彩 四场进球
 * @author pingan
 *
 */
@Component
public class ZcJq4Crawler {
    @Qualifier("ZcJq4DaoPipeline")
    @Autowired
    private PageModelPipeline<ZcJq4MatchList> pageModelPipeline;
    
    private static Spider spider = null;

    public void startCrawl() {
    	spider = OOSpider.create(Site.me(),pageModelPipeline, ZcJq4MatchList.class).addUrl("http://trade.500.com/jq4/");
    	spider.start();
    }
    
    public void stopCrawl(){
    	spider.stop();
    }
}
