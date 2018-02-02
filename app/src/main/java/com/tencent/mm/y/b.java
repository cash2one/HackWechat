package com.tencent.mm.y;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g.a;
import java.util.Map;

public class b extends d {
    public String fEn;
    public String haC;
    public String haD;
    public String haE;
    public String haF;
    public String haG;
    public String haH;
    public String haI;
    public String haJ;
    public String haK;
    public String haL;
    public String haM;
    public String haN;
    public String haO;
    public String haP;
    public String haQ;
    public String haR;
    public String haS;
    public String haT;
    public String haU;

    public final d EJ() {
        return new b();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        if (aVar.type == 2002) {
            this.haC = d(map, "templateid");
            this.haD = d(map, "senderurl");
            this.haE = d(map, "sendernativeurl");
            this.haF = d(map, "receiverurl");
            this.haG = d(map, "receivernativeurl");
            this.haH = d(map, "iconurl");
            this.haI = d(map, "miniiconurl");
            this.haJ = d(map, "backgroundurl");
            this.haK = d(map, "backgroundname");
            this.haL = d(map, "backgroundcolor");
            this.haM = d(map, "receivertitle");
            this.haN = d(map, "sendertitle");
            this.haO = d(map, "titlecolor");
            this.haP = d(map, "senderscenetext");
            this.haQ = d(map, "receiverscenetext");
            this.haR = d(map, "senderdes");
            this.haS = d(map, "receiverdes");
            this.haT = d(map, "descolor");
            this.haU = d(map, "sceneid");
            this.fEn = d(map, "paymsgid");
        }
    }

    private static String d(Map<String, String> map, String str) {
        return bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo." + str));
    }
}
