package I000.spider.football.dao;


import I000.spider.football.model.BetDate;

public interface BetDateDao {
	
    public BetDate getBetDateByDayDate(String dayDate);
    
    public void save(BetDate betDate);
    
    public void update(BetDate betDate);
}
