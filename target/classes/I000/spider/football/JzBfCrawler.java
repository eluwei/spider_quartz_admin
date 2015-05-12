package I000.spider.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import I000.spider.football.model.JzBfMatchList;

/**
 * 竞足 比分
 * @author pingan
 * @since 2014-07-12
 */

@Component
public class JzBfCrawler {
    @Qualifier("JzBfDaoPipeline")
    @Autowired
    private PageModelPipeline<JzBfMatchList> jzBfDaoPipeline;
    
    private static Spider spider = null;

    public void startCrawl() {
    	spider = OOSpider.create(Site.me(),jzBfDaoPipeline, JzBfMatchList.class).addUrl("http://caipiao.163.com/order/jczq-banquan/");
    	spider.start();
    }
    
    public void stopCrawl(){
    	spider.stop();
    }
}
