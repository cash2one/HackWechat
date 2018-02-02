package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.c.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public static String reU = ".adxml.adArgs.arg";
    public String fCs = "";
    public String fpL;
    public int hOz;
    public String rdQ;
    boolean rdZ;
    public String reA = "";
    public String reB = "";
    public String reC = "";
    public int reD = 0;
    public String reE = "";
    public String reF = "";
    public int reG = 0;
    public String reH = "";
    public int reI = 0;
    public String reJ = "";
    public String reK = "";
    public String reL = "";
    public String reM = "";
    public String reN = "";
    public String reO = "";
    public int reP;
    public int reQ;
    public int reR;
    public long reS;
    public Map<String, String> reT = new HashMap();
    boolean reV;
    public int reW;
    public int reX;
    public float reY;
    public float reZ;
    public String rev;
    public int rew = 0;
    public int rex = 0;
    public String rey = "";
    public String rez = "";
    public int rfa;
    public int rfb;
    public int rfc;
    public String rfd;
    public float rfe;
    public float rff;
    public float rfg;
    public float rfh;
    public int rfi;
    public String rfj;
    public String rfk;
    public b rfl;
    private a rfm;
    public c rfn;

    public b(String str) {
        if (bh.ov(str) || !str.trim().startsWith("<RecXml")) {
            W(str, "", "adxml");
            return;
        }
        Map W = W(str, ".RecXml", "RecXml");
        if (W != null && !W.isEmpty()) {
            this.reP = bh.VI((String) W.get(".RecXml.$type"));
            this.reQ = bh.VI((String) W.get(".RecXml.$source"));
            this.reR = bh.VI((String) W.get(".RecXml.$expId"));
            this.reS = i.lS((String) W.get(".RecXml.$expOriginSnsId"));
        }
    }

    private Map<String, String> W(String str, String str2, String str3) {
        int i = 0;
        if (bh.ov(str) || bh.ov(str3)) {
            return null;
        }
        this.fCs = str;
        x.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[]{str, str2, str3});
        Map<String, String> y = f.y(str, str3);
        if (y == null) {
            return null;
        }
        this.hOz = bh.VI((String) y.get(str2 + ".adxml.adType"));
        this.rev = bh.az((String) y.get(str2 + ".adxml.adActionTitle"), "");
        this.rdQ = bh.az((String) y.get(str2 + ".adxml.adActionLink"), "");
        this.fpL = bh.az((String) y.get(str2 + ".adxml.nickname"), "");
        this.rew = bh.VI((String) y.get(str2 + ".adxml.webviewRightBarShow"));
        this.rex = bh.VI((String) y.get(str2 + ".adxml.adActionLinkHidden"));
        this.rey = bh.az((String) y.get(str2 + ".adxml.adActionLinkName"), "");
        this.rez = bh.az((String) y.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.reA = bh.az((String) y.get(str2 + ".adxml.adActionLinkTitle.zh"), "");
        this.reC = bh.az((String) y.get(str2 + ".adxml.adActionLinkTitle.tw"), "");
        this.reB = bh.az((String) y.get(str2 + ".adxml.adActionLinkTitle.en"), "");
        this.reE = bh.az((String) y.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.reF = bh.az((String) y.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.reD = bh.VI((String) y.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (bh.ov(this.reE) || bh.ov(this.reF)) {
            this.reD = 1;
        }
        this.reJ = bh.az((String) y.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.reL = bh.az((String) y.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.reK = bh.az((String) y.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.reM = bh.az((String) y.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.reO = bh.az((String) y.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.reN = bh.az((String) y.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.reG = bh.VI((String) y.get(str2 + ".adxml.headClickType"));
        this.reH = bh.az((String) y.get(str2 + ".adxml.headClickParam"), "");
        this.reI = bh.VI((String) y.get(str2 + ".adxml.headClickRightBarShow"));
        int i2 = 0;
        while (true) {
            String str4 = str2 + reU + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".key";
            String str5 = (String) y.get(str4);
            if (str5 == null) {
                break;
            }
            String str6 = str2 + reU + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".value";
            String str7 = (String) y.get(str6);
            x.i("MicroMsg.ADXml", "newKey " + str4 + " " + str5 + " newValue : " + str6 + " " + str7);
            this.reT.put(str5, str7);
            i2++;
        }
        this.rdZ = y.containsKey(str2 + ".adxml.adCanvasInfo");
        this.reW = bh.VI((String) y.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.reX = bh.VI((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.reY = (float) bh.VK((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.reZ = (float) bh.VK((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.rfc = bh.VI((String) y.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.rfd = bh.az((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.rfa = bh.VI((String) y.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.rfb = bh.VI((String) y.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.rfe = (float) bh.VK((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.rff = (float) bh.VK((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.rfg = (float) bh.VK((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.rfh = (float) bh.VK((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.rfi = bh.VI((String) y.get(str2 + ".adxml.adContentStyle"));
        this.rfj = bh.az((String) y.get(str2 + ".adxml.adCardInfo.title"), "");
        this.rfk = bh.az((String) y.get(str2 + ".adxml.adCardInfo.description"), "");
        Object az = bh.az((String) y.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        Object az2 = bh.az((String) y.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!(TextUtils.isEmpty(az) || TextUtils.isEmpty(az2))) {
            this.rfm = new a(this);
            this.rfm.rfo = az;
            this.rfm.rfp = az2;
        }
        az2 = bh.az((String) y.get(str2 + ".adxml.adVoteInfo.componentUrl"), "");
        if (!TextUtils.isEmpty(az2)) {
            this.rfn = new c(this);
            this.rfn.rfs = az2;
            String str8 = str2 + ".adxml.adVoteInfo.optionList.option";
            while (true) {
                if (i != 0) {
                    str7 = str8 + i;
                } else {
                    str7 = str8;
                }
                if (TextUtils.isEmpty(bh.az((String) y.get(str7 + ".title"), ""))) {
                    break;
                }
                d dVar = new d(this);
                dVar.title = bh.az((String) y.get(str7 + ".title"), "");
                dVar.lOY = bh.az((String) y.get(str7 + ".shareTitle"), "");
                dVar.rfu = bh.az((String) y.get(str7 + ".shareDesc"), "");
                dVar.rfv = bh.az((String) y.get(str7 + ".shareThumb"), "");
                dVar.rfw = bh.az((String) y.get(str7 + ".selectedTitle"), "");
                this.rfn.rft.add(dVar);
                i++;
            }
        }
        this.reV = y.containsKey(str2 + ".adxml.adTurnCanvasInfo");
        this.rfl = new b();
        this.rfl.q(y, str2);
        return y;
    }

    public final boolean bwt() {
        return this.rdZ || this.reV;
    }

    public final String bwu() {
        if (bwz()) {
            return this.rfm.rfo;
        }
        if (bwA()) {
            return ((d) this.rfn.rft.get(0)).title;
        }
        return "";
    }

    public final String bwv() {
        if (bwz()) {
            return this.rfm.rfp;
        }
        if (bwA()) {
            return ((d) this.rfn.rft.get(1)).title;
        }
        return "";
    }

    public final String bww() {
        if (bwA()) {
            return this.rfn.rfs;
        }
        return "";
    }

    public final boolean bwx() {
        return this.rfi == 2;
    }

    public final boolean bwy() {
        return this.rfi == 1;
    }

    public final boolean bwz() {
        return this.rfm != null;
    }

    public final boolean bwA() {
        return this.rfn != null && this.rfn.rft.size() > 1;
    }

    public final String bwB() {
        String str = this.fCs;
        if (str.contains("<adCanvasInfoLeft>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
        }
        return str;
    }

    public final String bwC() {
        String str = this.fCs;
        if (str.contains("<adCanvasInfoRight>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
        }
        return str;
    }

    public final String bwD() {
        String str = this.fCs;
        if (str.contains("<adTurnCanvasInfo>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
        }
        return str;
    }

    public final boolean bwE() {
        return this.reQ == 2;
    }
}
