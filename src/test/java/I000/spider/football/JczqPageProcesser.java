package I000.spider.football;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JczqPageProcesser implements PageProcessor {

	private Site site = Site.me().setDomain("trade.500.com").addStartUrl("http://trade.500.com/sfc/");
	

	@Override
	public void process(Page page) {
		
		System.out.println("-------------------------");
		System.out.println(page.getHtml().xpath("//tr//@zid").all().size());
		for(String str:page.getHtml().xpath("//tr//@zid").all()){
			System.out.println(str);
		}
		
		System.out.println("-------------------------");
		System.out.println(page.getHtml().xpath("//a[@class='game_num']/text()").all().size());
		for(String str:page.getHtml().xpath("//a[@class='game_num']/text()").all()){
			System.out.println(str);
		}
		
		/*System.out.println(page.getHtml().xpath("//vid[@class='b-top-time']/text()").all().size());
		for(String str:page.getHtml().xpath("//vid[@class='b-top-time']/text()").all()){
			System.out.println(str);
		}*/
		
		
		/*System.out.println(page.getHtml().xpath("//input[@id='expect']/@value").all().size());
		for(String str:page.getHtml().xpath("//input[@id='expect']/@value").all()){
			System.out.println(str);
		}*/
		
		
		
		//page.putField("zid", page.getHtml().xpath("//tr//@zid").all());
		/*List<String> list = page.getHtml().xpath("//td/span[@class='sp_w38 eng']/text()").all();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("---"+i);
			System.out.println("###"+list.get(i));
		}*/
		/*System.out.println(page.getHtml().xpath("//td/span[@class='eng']/text()").all().size());
		for(String str:page.getHtml().xpath("//td/span[@class='eng']/text()").all()){
			System.out.println("---"+str.trim());
		}*/
		
		/*System.out.println(page.getHtml().xpath("//td[@class='borderl td2']/a/text()").all().size());
		for(String str:page.getHtml().xpath("//td[@class='borderl td2']/a/text()").all()){
			try {
				System.out.println(new String(str.getBytes("GB2312"),"UTF-8"));
				System.out.println(URLDecoder.decode(str, "GB2312"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		/*System.out.println(page.getHtml().xpath("//tr/@data-vs").all().size());
		for(String str:page.getHtml().xpath("//tr/@data-vs").all()){
			System.out.println(str);
		}*/
		
		
	/*	System.out.println(page.getHtml().xpath("//a[@name='c1']/em/text()").all().size());
		for(String str:page.getHtml().xpath("//a[@name='c1']/em/text()").all()){
			try {
				//System.out.println(new String(str.getBytes("gb2312"),"UTF-8"));
				System.out.println(URLDecoder.decode(str, "gb2312"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}*/
		
		
		
		/*System.out.println(page.getHtml().xpath("//td[@class='league']/a/text()").all().size());
		for(String str:page.getHtml().xpath("//td[@class='league']/a/text()").all()){
			System.out.println("---"+str.trim());
		}*/
		
		
		
		/*page.putField("game_num", page.getHtml().xpath("//a[@class='game_num']/text()").all());
		page.putField("league", page.getHtml().xpath("//span[@class='league']/a/text()").all());	
		page.putField("end_time", page.getHtml().xpath("//span[@class='end_time']/text()").all());	
		page.putField("homesxname", page.getHtml().xpath("//td[@class='left_team']/a/text()").all());
		page.putField("awaysxname", page.getHtml().xpath("//td[@class='right_team']/a/text()").all());
		
		page.putField("concede t_line green", page.getHtml().xpath("//p[@class='concede t_line green']/span/text()").all());
		
		page.putField("nspf", page.getHtml().xpath("//span[@data-type='nspf']/text()").all());
		page.putField("spf", page.getHtml().xpath("//span[@data-type='spf']/text()").all());

		
		/*
		@ExtractBy(value = "//tr//@zid",multi=true)
		private List<String> zidList;
		@ExtractBy(value = "//tr//@mid",multi=true)
		private List<String> midList;
		@ExtractBy(value = "//tr//@pname",multi=true)
		private List<String> pnameList;
		@ExtractBy(value = "//tr//@pdate",multi=true)
		private List<Date> pdateList;
		@ExtractBy(value = "//tr//@lg",multi=true)
		private List<String> lgList;
		@ExtractBy(value = "//tr//@rq",multi=true)
		private List<Integer> rqList;
		@ExtractBy(value = "//tr//@pendtime",multi=true)
		private List<Date> pendtimeList;
		@ExtractBy(value = "//tr//@style",multi=true)
		private List<String> displayList;
		@ExtractBy(value = "//tr//@isend",multi=true)
		private List<Integer> isendList;
		@ExtractBy(value = "//tr//@gdate",multi=true)
		private List<String> gdateList;
		@ExtractBy(value = "//tr//@fid",multi=true)
		private List<String> fidList;
		@ExtractBy(value = "//tr//@homesxname",multi=true)
		private List<String> homesxnameList;
		@ExtractBy(value = "//tr//@awaysxname",multi=true)
		private List<String> awaysxnameList;
		@ExtractBy(value = "//tr//@class",multi=true)
		private List<String> classTypeList;
		@ExtractBy(value = "//tr//@zid//span[@id='g01_t1']",multi=true)
		private List<Float> g01T1List;
		@ExtractBy(value = "//tr//@zid//span[@id='g01_t2']",multi=true)
		private List<Float> g01T2List;
		@ExtractBy(value = "//tr//@zid//span[@id='g01_t3']",multi=true)
		private List<Float> g01T3List;
		@ExtractBy(value = "//tr//@zid//span[@id='g01_t4']",multi=true)
		private List<Float> g01T4List;
		@ExtractBy(value = "//tr//@zid//span[@id='g01_t5']",multi=true)
		private List<Float> g01T5List;
		@ExtractBy(value = "//tr//@zid//span[@id='g01_t6']",multi=true)
		private List<Float> g01T6List;*/
	}
	
	@Override
	public Site getSite() {
        return site;
	}
	
	public static void main(String[] args) {
        Spider.create(new JczqPageProcesser()).pipeline(new ConsolePipeline()).run();
    }

}
