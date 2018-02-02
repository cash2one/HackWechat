package com.tencent.mm.pluginsdk.i.a.d;

public abstract class a {
    private final String filePath;
    public final String fqR;
    private volatile int hJm;
    private final long hQs;
    public final int networkType;
    public final int priority;
    protected volatile int status = 0;
    public final String url;
    public final String vgd;
    public final int vgn;
    public final String vhw;
    private final String vhx;
    private final String vhy;

    public a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
        this.url = str;
        this.vgd = str2;
        this.vhw = str3;
        this.networkType = i;
        this.vgn = i2;
        this.hJm = this.vgn;
        this.filePath = str4;
        this.hQs = j;
        this.vhx = str6;
        this.vhy = str7;
        this.fqR = str5;
        this.priority = i3;
    }

    public q bZo() {
        q qVar = new q();
        qVar.field_url = this.url;
        qVar.field_urlKey = this.vgd;
        qVar.field_fileVersion = this.vhw;
        qVar.field_networkType = this.networkType;
        qVar.field_maxRetryTimes = this.vgn;
        qVar.field_retryTimes = this.hJm;
        qVar.field_filePath = this.filePath;
        qVar.field_status = this.status;
        qVar.field_expireTime = this.hQs;
        qVar.field_groupId1 = this.vhx;
        qVar.field_groupId2 = this.vhy;
        qVar.field_md5 = this.fqR;
        qVar.field_priority = this.priority;
        return qVar;
    }

    public int RQ(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.vgd + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.hQs + ", fileVersion=" + this.vhw + ", maxRetryTimes=" + this.vgn + ", md5='" + this.fqR + '\'' + ", groupId1='" + this.vhx + '\'' + ", groupId2='" + this.vhy + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.hJm + ", status=" + this.status + ", priority=" + this.priority;
    }
}
