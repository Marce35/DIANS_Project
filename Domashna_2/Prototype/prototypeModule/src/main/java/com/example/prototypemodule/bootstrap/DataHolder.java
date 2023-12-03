package com.example.prototypemodule.bootstrap;

import com.example.prototypemodule.model.HeritageSite;
import com.example.prototypemodule.model.enumerations.HeritageType;
import com.example.prototypemodule.model.helperClasses.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<HeritageSite> heritageSiteList = null;

    @PostConstruct
    public void init(){
        heritageSiteList = new ArrayList<>();
        heritageSiteList.add(new HeritageSite("Muzej na sovremenata umetnost","Skopje", HeritageType.MUSEUM ,new Location(42.0040225,21.4329048)));
        heritageSiteList.add(new HeritageSite("Muzej na Grad Skopje","Skopje",HeritageType.MUSEUM,new Location(41.9909145,21.4290087)));

        heritageSiteList.add(new HeritageSite("Amerikansko katche Makedonija","Skopje",HeritageType.LIBRARY,new Location(41.9980573,21.4397823)));
        heritageSiteList.add(new HeritageSite("Naum Naumoski-Borche","Krushevo",HeritageType.LIBRARY,new Location(41.3669471,21.2488978)));

        heritageSiteList.add(new HeritageSite("Stobi","Negotino",HeritageType.ARCH_SITE,new Location(41.5520256,21.9734409)));
        heritageSiteList.add(new HeritageSite("Cocev Kamen","Kratovo",HeritageType.ARCH_SITE,new Location(42.0836218,21.9862589)));

        heritageSiteList.add(new HeritageSite("Evangelsko Metodistichka Crkva","Strumica",HeritageType.CHURCH,new Location(41.4373198,22.6353267)));
        heritageSiteList.add(new HeritageSite("Crkva „Sv. Apostoli Petar i Pavle“","Skopje",HeritageType.CHURCH,new Location(41.9644772,21.4936632)));

        heritageSiteList.add(new HeritageSite("Varoshki Manastir","Prilep",HeritageType.MONASTERY,new Location(41.3602308,21.5342465)));
        heritageSiteList.add(new HeritageSite("Hotel Manastir Sv. Joakim Osogovski","Kriva Palanka",HeritageType.MONASTERY,new Location(42.2092075,22.3628114)));

        heritageSiteList.add(new HeritageSite("Spomen kukja na Strasho Pindzur","Kavadarci",HeritageType.MEMORIAL_HOUSE,new Location(41.4184594,22.0181317)));
        heritageSiteList.add(new HeritageSite("Spomen kukja na Hristo Uzunov","Ohrid",HeritageType.MEMORIAL_HOUSE,new Location(41.112242,20.7958365)));
    }
}
