package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class b$b {
    public String bpe;
    public String fnq;
    public String fvL;
    public String rdQ = "";
    public List<e> rfr = new ArrayList();

    public final void q(Map<String, String> map, String str) {
        this.rdQ = bh.az((String) map.get(str + ".adxml.adTurnActionLink"), "");
        String str2 = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appUserName");
        if (!TextUtils.isEmpty(str2)) {
            this.fvL = str2;
            this.bpe = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appVersion");
            this.fnq = (String) map.get(str + ".adxml.adTurnActionExtWeApp.relativePagePath");
        }
        String str3 = str + ".adxml.adTurnInfo.materialInfo";
        int i = 0;
        while (true) {
            String str4;
            if (i > 0) {
                str4 = str3 + i;
            } else {
                str4 = str3;
            }
            if (map.get(str4 + ".displayType") != null && ((String) map.get(str4 + ".displayType")).length() > 0) {
                e eVar = new e();
                eVar.title = bh.az((String) map.get(str4 + ".title"), "");
                eVar.desc = bh.az((String) map.get(str4 + ".desc"), "");
                eVar.rfx = bh.VI((String) map.get(str4 + ".displayType"));
                this.rfr.add(eVar);
                i++;
            } else {
                return;
            }
        }
    }
}
