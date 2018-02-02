package com.tencent.mm.plugin.offline.a;

import java.util.Map;

public class s$h {
    public String fKP;
    public String fKQ;
    public String fKR;
    public String fKS;
    public String fKT;
    final /* synthetic */ s oXf;
    public boolean oXv;

    public s$h(s sVar, Map<String, String> map) {
        this.oXf = sVar;
        this.fKP = (String) map.get(".sysmsg.paymsg.guide_flag");
        this.fKQ = (String) map.get(".sysmsg.paymsg.guide_wording");
        this.fKR = (String) map.get(".sysmsg.paymsg.left_button_wording");
        this.fKS = (String) map.get(".sysmsg.paymsg.right_button_wording");
        this.fKT = (String) map.get(".sysmsg.paymsg.upload_credit_url");
        this.oXv = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
    }
}
