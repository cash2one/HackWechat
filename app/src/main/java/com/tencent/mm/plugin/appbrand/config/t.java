package com.tencent.mm.plugin.appbrand.config;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

public final class t {
    public String appId;
    public String fpL;
    public String hpu;
    public int iPF;
    public String iPN;
    private String iPO = null;
    public List<WxaAttributes$WxaEntryInfo> iPl;
    public List<Pair<String, String>> iPz;
    public String signature;
    public String username;

    public final String acf() {
        if (bh.ov(this.iPO) && !bh.cA(this.iPz)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            for (Pair pair : this.iPz) {
                str = bh.ov((String) pair.second) ? (String) pair.first : (String) pair.second;
                if (!bh.ov(str)) {
                    stringBuilder.append("、");
                    stringBuilder.append(str);
                }
            }
            str = stringBuilder.toString();
            if (!bh.ov(str)) {
                str = str.replaceFirst("、", "");
            }
            this.iPO = str;
        }
        return bh.ou(this.iPO);
    }
}
