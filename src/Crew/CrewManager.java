package Crew;

import Region.Region;

public interface CrewManager {
    int nearby(String direction,Region region, Crew crew);

    int enermy(String direction, Region region,Crew crew);

    int moveCrew(String direction, Region region);
}
