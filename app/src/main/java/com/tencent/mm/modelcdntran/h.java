package com.tencent.mm.modelcdntran;

public final class h extends i {
    public int fWx;
    public int fileType;
    public String host;
    public String htn;
    public String[] hto;
    public String[] htp;
    public int htq;
    public int htr;
    public int hts;
    public boolean isColdSnsData;
    public String referer;
    public String signalQuality;
    public String snsCipherKey;
    public String snsScene;
    public String url;

    public h() {
        this.snsCipherKey = "";
        this.fWx = -1;
        this.hts = -1;
        this.fileType = 0;
        this.htC = true;
    }

    public final String toString() {
        return String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[]{this.field_mediaId, this.url, this.host, this.referer, this.htn, f(this.hto), f(this.htp), Integer.valueOf(this.htq), Integer.valueOf(this.htr), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene});
    }

    private static String f(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int length = strArr.length;
        String str = "";
        int i = 0;
        while (i < length) {
            i++;
            str = str + strArr[i] + ",";
        }
        return str;
    }
}
