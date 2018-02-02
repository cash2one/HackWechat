package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends i<k> implements e {
    public static final String[] gJN = new String[]{i.a(k.gJc, "snsExtInfo3")};
    public com.tencent.mm.sdk.e.e gJP;
    private boolean roO = false;
    private g roP = null;

    public final void bue() {
        x.d("MicroMsg.SnsExtStorage", "attachCache");
        this.roO = true;
    }

    public final void buf() {
        this.roO = false;
        this.roP.bvN();
        x.d("MicroMsg.SnsExtStorage", "detchCache");
    }

    public l(com.tencent.mm.sdk.e.e eVar, g gVar) {
        super(eVar, k.gJc, "snsExtInfo3", null);
        this.gJP = eVar;
        this.roP = gVar;
        x.i("MicroMsg.SnsExtStorage", "createExtStorage " + eVar + "  " + Thread.currentThread().getId());
    }

    public final boolean b(k kVar) {
        return super.a(kVar);
    }

    public final boolean a(k kVar) {
        if (!this.roO || this.roP == null) {
            return super.a(kVar);
        }
        boolean a = this.roP.a(kVar);
        if (this.roP == null) {
            return a;
        }
        this.roP.bvM();
        return a;
    }

    public final void Ln(String str) {
        c Lq = Lq(str);
        Lq.field_userName = str;
        super.a(Lq, new String[]{this.xjC.xjz});
    }

    public final int m(String str, String str2, int i, int i2) {
        c Lq = Lq(str);
        Lq.field_md5 = str2;
        Lq.field_lastFirstPageRequestErrType = i;
        Lq.field_lastFirstPageRequestErrCode = i2;
        super.a(Lq);
        return 0;
    }

    public final int e(String str, String str2, byte[] bArr) {
        c Lq = Lq(str);
        Lq.field_md5 = str2;
        Lq.field_adsession = bArr;
        super.a(Lq);
        return 0;
    }

    public final boolean em(String str, String str2) {
        c Lq = Lq(str);
        Lq.field_newerIds = str2;
        return super.a(Lq);
    }

    public final wk Lo(String str) {
        wk wkVar;
        wk wkVar2 = new wk();
        k kVar = new k();
        kVar = Lq(str);
        try {
            if (!bh.bw(kVar.field_faultS)) {
                wkVar = (wk) new wk().aF(kVar.field_faultS);
                if (wkVar != null) {
                    return new wk();
                }
                return wkVar;
            }
        } catch (Exception e) {
            x.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        }
        wkVar = wkVar2;
        if (wkVar != null) {
            return wkVar;
        }
        return new wk();
    }

    public final void Lp(String str) {
        k kVar = new k();
        kVar = Lq(str);
        kVar.field_userName = str;
        kVar.field_local_flag &= -2;
        c(kVar);
    }

    public final k Lq(String str) {
        k kVar = new k();
        if (this.roP != null && this.roO) {
            kVar = this.roP.Kk(str);
            if (kVar == null) {
                kVar = new k();
            }
            return kVar;
        }
        kVar.field_userName = str;
        super.b(kVar, new String[]{this.xjC.xjz});
        return kVar;
    }

    public final boolean c(k kVar) {
        if (kVar == null || kVar.field_userName == null || kVar.field_userName.equals("")) {
            return false;
        }
        return super.a(kVar);
    }

    public final boolean a(String str, bla com_tencent_mm_protocal_c_bla) {
        k Lq = Lq(str);
        String eq = com.tencent.mm.plugin.sns.data.i.eq(com_tencent_mm_protocal_c_bla.hvG);
        if (!bh.ov(com_tencent_mm_protocal_c_bla.hvF) && (Lq.field_bgUrl == null || !Lq.field_bgId.equals(eq))) {
            Lq.field_older_bgId = Lq.field_bgId;
            Lq.field_local_flag |= 1;
            Lq.bye();
            x.d("MicroMsg.SnsExtStorage", "bg change");
        }
        Lq.field_bgId = eq;
        Lq.field_bgUrl = com_tencent_mm_protocal_c_bla.hvF;
        Lq.field_iFlag = com_tencent_mm_protocal_c_bla.hvE;
        Lq.field_snsBgId = com_tencent_mm_protocal_c_bla.hvG;
        Lq.field_local_flag |= 4;
        if (com_tencent_mm_protocal_c_bla != null) {
            try {
                Lq.field_snsuser = com_tencent_mm_protocal_c_bla.toByteArray();
            } catch (Exception e) {
            }
        }
        a(Lq);
        return true;
    }

    public final bla b(String str, bla com_tencent_mm_protocal_c_bla) {
        k Lq = Lq(str);
        k a;
        int i;
        if (Lq == null) {
            a = a(str, Lq);
            if (a != null) {
                if (com_tencent_mm_protocal_c_bla.hvE == -1) {
                    i = a.field_iFlag;
                } else {
                    i = com_tencent_mm_protocal_c_bla.hvE;
                }
                com_tencent_mm_protocal_c_bla.hvE = i;
            }
        } else {
            com_tencent_mm_protocal_c_bla.hvF = bh.ov(com_tencent_mm_protocal_c_bla.hvF) ? Lq.field_bgUrl : com_tencent_mm_protocal_c_bla.hvF;
            Object obj = com_tencent_mm_protocal_c_bla.hvE == -1 ? 1 : null;
            com_tencent_mm_protocal_c_bla.hvE = obj != null ? Lq.field_iFlag : com_tencent_mm_protocal_c_bla.hvE;
            a = a(str, Lq);
            if (a != null) {
                if (obj != null) {
                    i = a.field_iFlag;
                } else {
                    i = com_tencent_mm_protocal_c_bla.hvE;
                }
                com_tencent_mm_protocal_c_bla.hvE = i;
            }
        }
        return com_tencent_mm_protocal_c_bla;
    }

    private k a(String str, k kVar) {
        int i;
        int i2;
        Cursor a;
        k kVar2;
        if (kVar == null) {
            i = 0;
        } else {
            if ((kVar.field_iFlag & 1) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((kVar.field_local_flag & 4) > 0) {
                i2 = i;
                i = 1;
                if (i == 0 && r4 == 0) {
                    a = this.gJP.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
                    if (a.moveToFirst()) {
                        i = 0;
                    } else {
                        i = a.getInt(0);
                    }
                    a.close();
                    if (i != 0) {
                        x.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
                        return null;
                    }
                    x.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + bh.ot(str) + "\""});
                    a = this.gJP.a(r0, null, 2);
                    kVar2 = new k();
                    if (a.moveToFirst()) {
                        a.close();
                    } else {
                        kVar2.b(a);
                        a.close();
                        x.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
                        return kVar2;
                    }
                }
                return null;
            }
        }
        i2 = i;
        i = 0;
        a = this.gJP.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
        if (a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
        }
        a.close();
        if (i != 0) {
            x.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + bh.ot(str) + "\""});
            a = this.gJP.a(r0, null, 2);
            kVar2 = new k();
            if (a.moveToFirst()) {
                a.close();
                return null;
            }
            kVar2.b(a);
            a.close();
            x.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
            return kVar2;
        }
        x.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
        return null;
    }

    public final bla Jz(String str) {
        k Lq = Lq(str);
        if (Lq == null) {
            return new bla();
        }
        return Lq.byg();
    }

    public final boolean aC(String str, boolean z) {
        k Lq = Lq(str);
        int i = Lq.field_iFlag;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        Lq.field_iFlag = i;
        c(Lq);
        return true;
    }

    public final bla aD(String str, boolean z) {
        bla byg = Lq(str).byg();
        if (byg == null) {
            x.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = byg.wOs;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        byg.wOs = i;
        return byg;
    }

    public final boolean a(String str, boolean z, boolean z2, boolean z3) {
        k Lq = Lq(str);
        int i = Lq.field_iFlag;
        if (z) {
            i |= WXMediaMessage.TITLE_LENGTH_LIMIT;
        } else {
            i &= -513;
        }
        if (z2) {
            i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        } else {
            i &= -1025;
        }
        if (z3) {
            i |= 2048;
        } else {
            i &= -2049;
        }
        Lq.field_iFlag = i;
        c(Lq);
        return true;
    }

    public final bla b(String str, boolean z, boolean z2, boolean z3) {
        bla byg = Lq(str).byg();
        if (byg == null) {
            x.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = byg.wOs;
        if (z) {
            i |= WXMediaMessage.TITLE_LENGTH_LIMIT;
        } else {
            i &= -513;
        }
        if (z2) {
            i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        } else {
            i &= -1025;
        }
        if (z3) {
            i |= 2048;
        } else {
            i &= -2049;
        }
        byg.wOs = i;
        return byg;
    }
}
