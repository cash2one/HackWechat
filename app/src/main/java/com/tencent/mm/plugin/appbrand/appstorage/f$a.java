package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bh;

public class f$a {
    private String country;
    private String fWq;
    private String iIo;
    public String iIp;
    private String state;

    public f$a(String str, String str2, String str3, String str4, String str5) {
        this.country = bh.ou(str);
        this.state = bh.ou(str2);
        this.fWq = bh.ou(str3);
        this.iIo = bh.ou(str4);
        this.iIp = bh.ou(str5);
    }

    public final String Rf() {
        StringBuilder stringBuilder;
        if (bh.Vq(this.country) || bh.Vq(this.state) || bh.Vq(this.fWq) || bh.Vq(this.iIo) || bh.Vq(this.iIp)) {
            stringBuilder = new StringBuilder();
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            if (this.state.length() > 0) {
                stringBuilder.append(this.state);
            }
            if (this.fWq.length() > 0) {
                stringBuilder.append(this.fWq);
            }
            if (this.iIo.length() > 0) {
                stringBuilder.append(this.iIo);
            }
            if (this.iIp.length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.iIp);
            }
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        if (this.iIo.length() > 0) {
            stringBuilder.append(this.iIo);
            stringBuilder.append(" ");
        }
        if (this.fWq.length() > 0) {
            stringBuilder.append(this.fWq + " ");
        }
        if (this.state.length() > 0) {
            stringBuilder.append(this.state + " ");
        }
        if (this.country.length() > 0) {
            stringBuilder.append(this.country);
        }
        if (this.iIp.length() > 0) {
            stringBuilder.append(" ");
            stringBuilder.append(this.iIp);
        }
        return stringBuilder.toString();
    }
}
