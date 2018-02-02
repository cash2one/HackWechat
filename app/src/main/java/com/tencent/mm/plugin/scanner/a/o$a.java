package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bh;

public class o$a {
    private String country;
    private String hPe;
    private String hxw;
    private String iIo;
    private String iIp;
    private String pTG;
    private String pTH;

    public o$a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (str == null) {
            str = "";
        }
        this.pTG = str;
        if (str2 == null) {
            str2 = "";
        }
        this.pTH = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.iIo = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.hxw = str4;
        if (str5 == null) {
            str5 = "";
        }
        this.hPe = str5;
        if (str6 == null) {
            str6 = "";
        }
        this.iIp = str6;
        if (str7 == null) {
            str7 = "";
        }
        this.country = str7;
    }

    public final String Rf() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        if (bh.Vq(this.pTG) || bh.Vq(this.pTH) || bh.Vq(this.iIo) || bh.Vq(this.hxw) || bh.Vq(this.hPe) || bh.Vq(this.country)) {
            stringBuilder = new StringBuilder();
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
                stringBuilder.append("\n");
            }
            if (this.hPe.length() > 0) {
                stringBuilder.append(this.hPe + " ");
            }
            if (this.hxw.length() > 0) {
                stringBuilder.append(this.hxw);
            }
            if (this.hPe.length() > 0 || this.hxw.length() > 0) {
                stringBuilder.append("\n");
            }
            if (this.iIo.length() > 0) {
                stringBuilder.append(this.iIo + " ");
                stringBuilder.append("\n");
            }
            if (this.pTH.length() > 0) {
                stringBuilder.append(this.pTH);
                stringBuilder.append("\n");
            }
            if (this.pTG.length() > 0) {
                stringBuilder.append(this.pTG);
                stringBuilder.append("\n");
            }
            if (this.iIp.length() > 0) {
                stringBuilder.append(this.iIp);
            }
            stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.endsWith("\n")) {
                return stringBuilder2.substring(0, stringBuilder2.length() - 1);
            }
            return stringBuilder2;
        }
        stringBuilder = new StringBuilder();
        if (this.pTG.length() > 0) {
            stringBuilder.append(this.pTG);
            stringBuilder.append("\n");
        }
        if (this.pTH.length() > 0) {
            stringBuilder.append(this.pTH);
            stringBuilder.append("\n");
        }
        if (this.iIo.length() > 0) {
            stringBuilder.append(this.iIo);
            stringBuilder.append("\n");
        }
        if (this.hxw.length() > 0) {
            stringBuilder.append(this.hxw + " ");
        }
        if (this.hPe.length() > 0) {
            stringBuilder.append(this.hPe + " ");
        }
        if (this.iIp.length() > 0) {
            stringBuilder.append(this.iIp);
        }
        if (this.hxw.length() > 0 || this.hPe.length() > 0) {
            stringBuilder.append("\n");
        }
        if (this.country.length() > 0) {
            stringBuilder.append(this.country);
        }
        stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.endsWith("\n") ? stringBuilder2.substring(0, stringBuilder2.length() - 1) : stringBuilder2;
    }
}
