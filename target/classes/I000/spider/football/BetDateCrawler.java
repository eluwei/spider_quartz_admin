package I000.spider.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import I000.spider.football.model.BetDateList;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class BetDateCrawler {
    @Qualifier("BetDateDaoPipeline")
    @Autowired
    private PageModelPipeline<BetDateList> betDateDaoPipeline;
    
    private static Spider spider = null;

    public void startCrawl() {
    	spider = OOSpider.create(Site.me(),betDateDaoPipeline, BetDateList.class).addUrl("http://trade.500.com/jczq/");
    	spider.start();
    }
    
    public void stopCrawl(){
    	spider.stop();
    }
}
