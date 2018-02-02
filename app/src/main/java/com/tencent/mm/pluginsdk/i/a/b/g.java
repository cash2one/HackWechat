package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.d.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;

final class g extends a {
    final long fileSize;
    final int fpm;
    final int fpn;
    private final boolean fpp;
    final boolean fpt;
    final byte[] vgL;
    final boolean vgM;
    final boolean vgN;
    private final int vgO;
    private final String vgg;
    final int vgh;
    private final byte[] vgi;
    final String vgj;
    final long vgl;
    private final String vgm;

    public g(String str, String str2, int i, int i2, int i3, long j, String str3, int i4, int i5, long j2, String str4, byte[] bArr, String str5, boolean z, boolean z2, String str6, int i6, int i7, byte[] bArr2, long j3, boolean z3, boolean z4, int i8) {
        super(str, str2, String.valueOf(i), i2, i3, i.RR(str2), j, str3, "CheckResUpdate", z3 ? "NewXml" : "CGI", i8);
        this.fpm = i4;
        this.fpn = i5;
        this.vgl = j2;
        this.vgm = str4;
        this.vgi = bArr;
        this.vgj = str5;
        this.vgM = z;
        this.vgN = z2;
        this.vgg = str6;
        this.vgh = i6;
        this.vgO = i7;
        this.vgL = bArr2;
        this.fileSize = j3;
        this.fpt = z3;
        this.fpp = z4;
    }

    public final String toString() {
        return "CheckResUpdateRequest | fileUpdated=" + this.fpp + ", resType=" + this.fpm + ", subType=" + this.fpn + ", reportId=" + this.vgl + ", sampleId='" + this.vgm + '\'' + ", originalMd5='" + this.vgj + '\'' + ", fileCompress=" + this.vgM + ", fileEncrypt=" + this.vgN + ", encryptKey='" + this.vgg + '\'' + ", keyVersion=" + this.vgh + ", EID=" + this.vgO + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.fpt + " | " + super.toString();
    }

    public final q bZo() {
        q bZo = super.bZo();
        bZo.field_fileUpdated = this.fpp;
        bZo.field_resType = this.fpm;
        bZo.field_subType = this.fpn;
        bZo.field_reportId = this.vgl;
        bZo.field_sampleId = this.vgm;
        bZo.field_eccSignature = this.vgi;
        bZo.field_originalMd5 = this.vgj;
        bZo.field_fileCompress = this.vgM;
        bZo.field_fileEncrypt = this.vgN;
        bZo.field_encryptKey = this.vgg;
        bZo.field_keyVersion = this.vgh;
        bZo.field_fileSize = this.fileSize;
        bZo.field_EID = this.vgO;
        return bZo;
    }

    protected final int RQ(String str) {
        return bh.getInt(this.vhw, 0) - bh.getInt(str, 0);
    }
}
