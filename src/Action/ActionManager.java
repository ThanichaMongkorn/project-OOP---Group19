package Action;

import Crew.Crew;
import Player.Player;
import Region.Region;

public interface ActionManager {
    void done();
    void relocate(Crew crew, Region region, Player player);
    int[] move(String direction,int row, int col);
    void invest(int amount, Region region, Player player);//การลงทุนไปในเมืองของเราเพื่อเพิ่มมู,ค่าจากเดิมเมอืงราคา100เราลงไป i+1(i;ราคาเดิมเมืองหลวง) ก่อนinvestส่งcrewไปลงทุนแทนเรา input:ราคาของเมือง,ระยะห่างจากเมืองหลวงไปเมืองนั้น
    void collect(Player player, Crew crew, Region region);//เก็บเงินที่อยู่ในเมืองนั้นๆ
    void shoot(Direction direction, int expenditure);//โจมตีเมืองเมืองตรงข้าม หลังจากที่crewสำรวจนั้นพบว่ามีเมืองศัตรูอยู่ตรงไหนเราก็สามารถส่งcrewไปโจมตีได้เงื่อไขการโจมตี โดยการโจมตีแต่ละครั้งเงินของศัตรูจะลดลงไปทุกครั้งที่เราโจมตี
    //โดยเงินจะลดทีละ x+1 โดย x(กำหนดเอง)
}