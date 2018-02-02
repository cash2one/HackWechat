package com.tencent.mm.av;

import com.tencent.mm.g.b.ci;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.bh;

public final class a extends ci {
    public static com.tencent.mm.sdk.e.c.a gJc = ci.vJ();
    public String hHP;
    public String hHQ;

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public final boolean Ql() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean Qm() {
        return !bh.ov(this.field_songHAlbumUrl);
    }

    public final boolean e(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.field_musicId.equals(aVar.field_musicId);
    }

    public final asv Qn() {
        asv com_tencent_mm_protocal_c_asv = new asv();
        com_tencent_mm_protocal_c_asv.vVZ = this.field_originMusicId;
        com_tencent_mm_protocal_c_asv.wAi = this.field_musicType;
        com_tencent_mm_protocal_c_asv.ngo = this.field_appId;
        com_tencent_mm_protocal_c_asv.wAm = this.field_songAlbum;
        com_tencent_mm_protocal_c_asv.wAu = this.field_songAlbumType;
        com_tencent_mm_protocal_c_asv.wAn = this.field_songAlbumUrl;
        com_tencent_mm_protocal_c_asv.wAo = this.field_songWifiUrl;
        com_tencent_mm_protocal_c_asv.wAk = this.field_songName;
        com_tencent_mm_protocal_c_asv.wAl = this.field_songSinger;
        com_tencent_mm_protocal_c_asv.wAp = this.field_songWapLinkUrl;
        com_tencent_mm_protocal_c_asv.wAq = this.field_songWebUrl;
        com_tencent_mm_protocal_c_asv.wAs = this.field_songAlbumLocalPath;
        com_tencent_mm_protocal_c_asv.vZq = this.field_songMediaId;
        com_tencent_mm_protocal_c_asv.wAy = this.field_songSnsAlbumUser;
        com_tencent_mm_protocal_c_asv.wAz = this.field_songSnsShareUser;
        com_tencent_mm_protocal_c_asv.wAB = this.field_hideBanner;
        com_tencent_mm_protocal_c_asv.wAC = this.field_jsWebUrlDomain;
        com_tencent_mm_protocal_c_asv.hkt = this.field_startTime;
        com_tencent_mm_protocal_c_asv.hHP = this.hHP;
        com_tencent_mm_protocal_c_asv.protocol = this.field_protocol;
        com_tencent_mm_protocal_c_asv.wAD = this.field_barBackToWebView;
        com_tencent_mm_protocal_c_asv.wAE = this.field_musicbar_url;
        return com_tencent_mm_protocal_c_asv;
    }
}
