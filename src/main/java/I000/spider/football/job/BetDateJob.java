package I000.spider.football.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 设置历史比赛status=0
 * @author pingan
 * @since  2015-07-10
 */

@Component
public class BetDateJob {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public void doJob(){
		jdbcTemplate.update("update bet_date set status = 0 where pdate < ? ", new Object[] { sdf.format(new Date()) });
	}
}
