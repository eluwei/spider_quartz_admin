package I000.spider.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import I000.spider.football.model.ZcZc6MatchList;

/**
 * 足彩 六场半全
 * @author pingan
 * @since 2014/06/14
 */

@Component
public class ZcZc6Crawler {

    @Qualifier("ZcZc6DaoPipeline")
    @Autowired
    private PageModelPipeline<ZcZc6MatchList> pageModelPipeline;
    
    private static Spider spider = null;

    public void startCrawl() {
    	spider = OOSpider.create(Site.me(),pageModelPipeline, ZcZc6MatchList.class).addUrl("http://trade.500.com/zc6/");
    	spider.start();
    }
    
    public void stopCrawl(){
    	spider.stop();
    }
}
