package com.tencent.mm.pluginsdk.i.a.d;

public final class l {
    public final String aBD;
    public final long fMk;
    public final String filePath;
    final String groupId;
    public final int httpStatusCode;
    public final int status;
    private final String url;
    public final String vgd;
    public final Exception vhO;

    private l(String str, String str2, String str3, String str4, long j, String str5, int i, Exception exception, int i2) {
        this.groupId = str;
        this.vgd = str2;
        this.url = str3;
        this.filePath = str4;
        this.fMk = j;
        this.aBD = str5;
        this.status = i;
        this.vhO = exception;
        this.httpStatusCode = i2;
    }

    public l(String str, String str2, String str3, String str4, long j, String str5, Exception exception) {
        this(str, str2, str3, str4, j, str5, 3, exception, -1);
    }

    public l(k kVar, long j) {
        this(kVar.aab(), kVar.vgd, kVar.url, kVar.getFilePath(), j, null, 2, null, -1);
    }

    public l(e eVar, long j, String str) {
        this(eVar.aab(), eVar.bZj(), eVar.getURL(), eVar.getFilePath(), j, str, 2, null, -1);
    }

    public l(e eVar, Exception exception, int i, int i2) {
        this(eVar.aab(), eVar.bZj(), eVar.getURL(), eVar.getFilePath(), -1, null, i2, exception, i);
    }

    public l(e eVar, Exception exception, int i) {
        this(eVar, exception, -1, i);
    }

    public final String toString() {
        return "NetworkResponse{urlKey='" + this.vgd + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.fMk + ", contentType='" + this.aBD + '\'' + ", status=" + this.status + ", e=" + this.vhO + '}';
    }
}
