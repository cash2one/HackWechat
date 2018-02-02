package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public static int rdH = 0;
    public static int rdI = 1;
    public String fCs;
    public String iTh;
    public String qZM;
    public int rdJ;
    public long rdK;
    public long rdL;
    public int rdM;
    public String rdN;
    public String rdO;
    public String rdP;
    public String rdQ;
    public int rdR;
    public String rdS;
    public String rdT;
    public String rdU;
    public int rdV;
    public String rdW;
    public String rdX;
    public LinkedList<String> rdY;
    boolean rdZ;
    public String rea;
    public String reb;
    public String rec;
    public HashMap<String, String> red;
    public a ree;
    public b ref;
    public String reg;
    public String reh;
    public String rei;
    public boolean rej;
    public String rek;
    public boolean rel;

    public final boolean bwr() {
        return this.rdM == 4 && this.ree != null;
    }

    public a() {
        this.fCs = "";
        this.qZM = "";
        this.rdM = 0;
        this.rdN = "";
        this.rdO = "";
        this.rdP = "";
        this.rdQ = "";
        this.rdR = 0;
        this.rdS = "";
        this.rdT = "";
        this.rdU = "";
        this.rdV = rdH;
        this.rdW = "";
        this.rdX = "";
        this.rdY = new LinkedList();
        this.rec = "";
        this.ref = new b();
        this.reg = "";
        this.reh = "";
        this.rei = "";
        this.rej = false;
        this.rek = "";
        this.rel = false;
    }

    public a(String str) {
        this.fCs = "";
        this.qZM = "";
        this.rdM = 0;
        this.rdN = "";
        this.rdO = "";
        this.rdP = "";
        this.rdQ = "";
        this.rdR = 0;
        this.rdS = "";
        this.rdT = "";
        this.rdU = "";
        this.rdV = rdH;
        this.rdW = "";
        this.rdX = "";
        this.rdY = new LinkedList();
        this.rec = "";
        this.ref = new b();
        this.reg = "";
        this.reh = "";
        this.rei = "";
        this.rej = false;
        this.rek = "";
        this.rel = false;
        this.rdZ = false;
        KV(str);
    }

    private void KV(String str) {
        boolean z = true;
        if (!bh.ov(str)) {
            x.i("MicroMsg.ADInfo", "feed xml %s", new Object[]{str});
            Map y = bi.y(str, "ADInfo");
            if (y != null) {
                this.iTh = bh.az((String) y.get(".ADInfo.viewid"), "");
                if (y.get(".ADInfo.ad_sns_pos") != null) {
                    String az;
                    boolean z2;
                    this.rdJ = bh.VI((String) y.get(".ADInfo.ad_sns_pos"));
                    this.rdK = bh.VJ((String) y.get(".ADInfo.noExposureExpireTime"));
                    this.rdL = bh.VJ((String) y.get(".ADInfo.exposureNoActionExpireTime"));
                    this.qZM = bh.az((String) y.get(".ADInfo.uxInfo"), "");
                    this.rdM = bh.VI((String) y.get(".ADInfo.adActionType"));
                    this.rdN = bh.az((String) y.get(".ADInfo.adActionCardTitle"), "");
                    this.rdO = bh.az((String) y.get(".ADInfo.adActionCardTpId"), "");
                    this.rdP = bh.az((String) y.get(".ADInfo.adActionCardExt"), "");
                    this.rdQ = bh.az((String) y.get(".ADInfo.adActionLink"), "");
                    this.rdR = bh.VI((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
                    this.rdS = bh.az((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
                    this.rdT = bh.az((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
                    this.rdU = bh.az((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
                    String az2 = bh.az((String) y.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
                    this.rdV = bh.VI((String) y.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
                    this.rdX = bh.az((String) y.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
                    if (this.rdV == rdI) {
                        String az3 = bh.az((String) y.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
                        String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
                        this.rdY.clear();
                        int i = 0;
                        while (true) {
                            if (i == 0) {
                                az = bh.az((String) y.get(str2), "");
                            } else {
                                az = bh.az((String) y.get(str2 + i), "");
                            }
                            if (bh.ov(az)) {
                                break;
                            }
                            this.rdY.add(az);
                            i++;
                        }
                        z2 = az3.indexOf("%s") >= 0;
                        i = az3.indexOf("%");
                        int lastIndexOf = az3.lastIndexOf("%");
                        if (!bh.ov(az3) && z2 && i == lastIndexOf) {
                            this.rdW = az3;
                        } else {
                            this.rdW = az2;
                            this.rdV = rdH;
                        }
                    } else {
                        this.rdW = az2;
                        this.rdV = rdH;
                    }
                    this.rdZ = y.containsKey(".ADInfo.adCanvasInfo");
                    this.reb = (String) y.get(".ADInfo.session_data.aid");
                    this.rea = (String) y.get(".ADInfo.session_data.trace_id");
                    this.red = new HashMap();
                    az2 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
                    int i2 = 0;
                    while (true) {
                        String str3;
                        if (i2 == 0) {
                            str3 = az2;
                        } else {
                            str3 = az2 + i2;
                        }
                        az = (String) y.get(str3 + ".cardTpId");
                        str3 = (String) y.get(str3 + ".cardExt");
                        if (bh.ov(az)) {
                            break;
                        }
                        this.red.put(az, str3);
                        i2++;
                    }
                    Matcher matcher = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(str);
                    if (matcher.find()) {
                        az = matcher.group();
                        if (!bh.ov(az)) {
                            this.rec = az.replaceAll("</?adCanvasExt>", "");
                        }
                    }
                    az = (String) y.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
                    if (!TextUtils.isEmpty(az)) {
                        this.ree = new a();
                        this.ree.fvL = az;
                        this.ree.bpe = (String) y.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
                        this.ree.fnq = (String) y.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
                    }
                    this.ref = new b(y, ".ADInfo");
                    this.reg = bh.az((String) y.get(".ADInfo.dislikeInfo.Title.zh"), "");
                    this.rei = bh.az((String) y.get(".ADInfo.dislikeInfo.Title.tw"), "");
                    this.reh = bh.az((String) y.get(".ADInfo.dislikeInfo.Title.en"), "");
                    if (bh.VI((String) y.get(".ADInfo.dislikeInfo.forbidClick")) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.rej = z2;
                    this.rek = bh.az((String) y.get(".ADInfo.adInfoSyncBuffer"), "");
                    if (bh.VI((String) y.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
                        z = false;
                    }
                    this.rel = z;
                }
            }
        }
    }
}
