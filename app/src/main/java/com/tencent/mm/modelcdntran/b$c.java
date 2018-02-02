package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;

class b$c {
    public int field_AckSlice = 8192;
    public String field_ApprovedVideoHosts = CdnLogic.defaultApprovedVideoHosts;
    public int field_C2COverloadDelaySeconds = 10;
    public int field_EnableCDNVerifyConnect = 1;
    public int field_EnableCDNVideoRedirectOC = 1;
    public int field_EnableSafeCDN = 0;
    public int field_EnableSnsImageDownload = 0;
    public int field_EnableSnsStreamDownload = 0;
    public int field_EnableStreamUploadVideo = 1;
    public int field_Ptl = 35;
    public int field_SNSOverloadDelaySeconds = 60;
    public int field_UseDynamicETL = 0;
    public int field_UseStreamCDN = 1;
    public int field_WifiEtl = 90;
    public int field_noWifiEtl = 70;
    public boolean field_onlyrecvPtl = false;
    public boolean field_onlysendETL = false;
    final /* synthetic */ b hso;

    b$c(b bVar) {
        this.hso = bVar;
    }

    public final String toString() {
        return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d, safecdn:%d, snsstream:%d, snsimage:%d, videohosts:\n%s", new Object[]{Integer.valueOf(this.field_WifiEtl), Integer.valueOf(this.field_noWifiEtl), Integer.valueOf(this.field_Ptl), Integer.valueOf(this.field_UseStreamCDN), Boolean.valueOf(this.field_onlysendETL), Boolean.valueOf(this.field_onlyrecvPtl), Integer.valueOf(this.field_AckSlice), Integer.valueOf(this.field_EnableCDNVerifyConnect), Integer.valueOf(this.field_EnableCDNVideoRedirectOC), Integer.valueOf(this.field_EnableStreamUploadVideo), Integer.valueOf(this.field_UseDynamicETL), Integer.valueOf(this.field_C2COverloadDelaySeconds), Integer.valueOf(this.field_SNSOverloadDelaySeconds), Integer.valueOf(this.field_EnableSafeCDN), Integer.valueOf(this.field_EnableSnsStreamDownload), Integer.valueOf(this.field_EnableSnsImageDownload), this.field_ApprovedVideoHosts});
    }
}
