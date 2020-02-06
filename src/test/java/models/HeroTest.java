package models;

import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

class HeroTest {


    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception{
        Hero hero = setupNewHero();
        assertTrue(hero instanceof Hero);
    }
    @Test
    public void HeroInstiatesWithAllParameters_true()throws Exception{
        Hero hero = setupNewHero();
        assertEquals("superman",hero.getName());
        assertEquals(20,hero.getAge());
        assertEquals("flying",hero.getSpecialPowers());
        assertEquals("kryptonium",hero.getWeakness());
        assertEquals("https://www.washingtonpost.com/resizer/vGQG3JCfQdXsdeVtxnxAkpugvpA=/270x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/RSJU5JUWMQ34PJTSQXM5IPKPKU.jpg",hero.getImageurl());
    }




    public Hero setupNewHero(){
        return new Hero("superman",20,"flying","kryptonium","https://www.washingtonpost.com/resizer/vGQG3JCfQdXsdeVtxnxAkpugvpA=/270x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/RSJU5JUWMQ34PJTSQXM5IPKPKU.jpg");
    }
}
