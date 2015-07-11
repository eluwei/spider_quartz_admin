package I000.spider.football.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 当前日期前的数据，备份到历史表
 * @author pingan
 * @since  2015-07-10
 */


@Component
public class FootballMatchHistoryJob {
	
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
    public void backupToHistory(){
    	jdbcTemplate.update("INSERT INTO football_match_history (football_match_history_id,type_code,type_name,pdate,zid, "
		    				+ "lottery_period_id,expect,game_num,league,end_time,homesxname,awaysxname,concede_t_line_green, "
		    				+ "nspf1,nspf2,nspf3,nspf4,nspf5,nspf6,spf1,spf2,spf3,spf4,spf5,spf6,spf7,spf8,update_date,create_date) "
		    				+ "SELECT football_match_id,type_code,type_name,pdate,zid,lottery_period_id,expect,game_num,league, "
		    				+ "end_time,homesxname,awaysxname,concede_t_line_green,nspf1,nspf2,nspf3,nspf4,nspf5,nspf6,"
		    				+ "spf1,spf2,spf3,spf4,spf5,spf6,spf7,spf8,update_date,create_date "
		    				+ "FROM football_match WHERE create_date < DATE_SUB(CURDATE(),INTERVAL 6 DAY) ");
    	
    	jdbcTemplate.update("DELETE FROM football_match  WHERE create_date < DATE_SUB(CURDATE(),INTERVAL 6 DAY) ");
    }
}
