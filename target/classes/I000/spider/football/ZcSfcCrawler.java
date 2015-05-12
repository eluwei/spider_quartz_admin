package I000.spider.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import I000.spider.football.model.ZcSfcMatchList;

/**
 * 足彩   胜负彩
 * @author pingan
 * @since 2014/06/14
 */

@Component
public class ZcSfcCrawler {
    @Qualifier("ZcSfcDaoPipeline")
    @Autowired
    private PageModelPipeline<ZcSfcMatchList> pageModelPipeline;
    
    private static Spider spider = null;

    public void startCrawl() {
    	spider = OOSpider.create(Site.me(),pageModelPipeline, ZcSfcMatchList.class).addUrl("http://trade.500.com/sfc/");
    	spider.start();
    }
    
    public void stopCrawl(){
    	spider.stop();
    }
}
