package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.z.ba;

public class c$c {
    private static int sgi = 0;
    public String bhd;
    public String fHV;
    public String fJq;
    public String fJw;
    public String id;
    public int ret;
    public int sgg;
    public String sgh;
    public int type;

    public c$c(String str, String str2, int i, String str3) {
        this.fJq = str;
        this.id = str2;
        this.type = i;
        this.bhd = str3;
        if (sgi == Integer.MAX_VALUE) {
            sgi = 0;
        }
        int i2 = sgi + 1;
        sgi = i2;
        this.sgg = i2;
        if (i == 1) {
            i2 = ba.hO(str);
            if (i2 != -1) {
                String trim = str.substring(0, i2).trim();
                if (trim != null && trim.length() > 0) {
                    this.sgh = trim;
                    this.fJq = str.substring(i2 + 1).trim();
                }
            }
        }
    }
}
