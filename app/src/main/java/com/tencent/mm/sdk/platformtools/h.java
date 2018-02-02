package com.tencent.mm.sdk.platformtools;

public final class h {
    public static String kmR = "]]>";
    public StringBuffer kmW = new StringBuffer();
    public String xeE = "";

    public h(String str) {
        this.xeE = str;
        vs(this.xeE);
    }

    private void vs(String str) {
        this.kmW.append("<" + str + ">");
    }

    public final void vt(String str) {
        this.kmW.append("</" + str + ">");
    }

    public final void bG(String str, String str2) {
        vs(str);
        if (!bh.ov(str2)) {
            if (str2.contains(kmR)) {
                this.kmW.append("<![CDATA[" + bh.VG(str2) + "]]>");
            } else {
                this.kmW.append("<![CDATA[" + str2 + "]]>");
            }
        }
        vt(str);
    }
}
