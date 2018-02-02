package com.tencent.mm.ag;

import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bh;

public final class c extends i<b> implements e {
    public static final String[] gJN = new String[]{i.a(b.gJc, "BizEnterprise")};
    public static fa hoc;
    private com.tencent.mm.sdk.e.e gJP;
    private final k<a, a> hod = new 1(this);

    public c(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, b.gJc, "BizEnterprise", null);
        this.gJP = eVar;
        eVar.fx("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        hoc = new fa();
        g.Di().gPJ.a(1343, this);
        g.Di().gPJ.a(1228, this);
    }

    public final void a(a aVar, Looper looper) {
        this.hod.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hod != null) {
            this.hod.remove(aVar);
        }
    }

    public final b jx(String str) {
        if (bh.ov(str)) {
            return null;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_userName = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        a(str, null);
        return null;
    }

    public final b jy(String str) {
        b jx = jx(str);
        if (jx != null) {
            return jx;
        }
        jx = new b();
        jx.field_userName = str;
        jx.field_qyUin = 0;
        jx.field_userUin = 0;
        jx.field_userFlag = 0;
        jx.field_wwExposeTimes = 0;
        jx.field_wwMaxExposeTimes = 0;
        jx.field_wwUserVid = 0;
        jx.field_wwCorpId = 0;
        jx.field_chatOpen = false;
        jx.field_wwUnreadCnt = 0;
        return jx;
    }

    public final int jz(String str) {
        b jx = jx(str);
        if (jx == null) {
            return 0;
        }
        return jx.field_qyUin;
    }

    public final boolean iF(String str) {
        boolean z = false;
        if (!bh.ov(str)) {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_userName = str;
            z = super.a(bVar, new String[]{"userName"});
            if (z) {
                a aVar = new a();
                aVar.hog = str;
                aVar.hof = b.hoj;
                aVar.hoh = bVar;
                this.hod.ca(aVar);
                this.hod.doNotify();
            }
        }
        return z;
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean z;
        int i;
        boolean b = super.b(bVar);
        int i2 = b.hoi;
        if (b) {
            int i3 = i2;
            z = b;
            i = i3;
        } else {
            b = super.a(bVar);
            z = b;
            i = b.hok;
        }
        if (!z) {
            return z;
        }
        a aVar = new a();
        aVar.hog = bVar.field_userName;
        aVar.hof = i;
        aVar.hoh = bVar;
        this.hod.ca(aVar);
        this.hod.doNotify();
        return z;
    }

    private boolean a(hr hrVar) {
        b jy = jy(hrVar.vNq);
        jy.field_userName = hrVar.vNq;
        jy.field_qyUin = hrVar.vNA;
        jy.field_userUin = hrVar.vNB;
        jy.field_wwMaxExposeTimes = hrVar.vND;
        jy.field_wwUserVid = hrVar.vNE;
        jy.field_wwCorpId = hrVar.vNF;
        jy.field_userType = hrVar.vNG;
        jy.field_chatOpen = hrVar.vNH;
        jy.field_wwUnreadCnt = hrVar.vNI;
        jy.field_show_confirm = hrVar.vNJ;
        jy.field_use_preset_banner_tips = hrVar.vNL;
        hoc = hrVar.vNK;
        if (hrVar.vNE == 0 && hrVar.vNF == 0 && hrVar.vNA != 0) {
            jy.field_wwUserVid = (long) hrVar.vNB;
            jy.field_wwCorpId = (long) hrVar.vNA;
        }
        hrVar.vNC &= -9;
        jy.field_userFlag = hrVar.vNC | (jy.field_userFlag & 8);
        return a(jy);
    }

    public static boolean a(String str, e eVar) {
        if (bh.ov(str)) {
            return false;
        }
        int i;
        if (f.jX(str)) {
            i = 1;
        } else if (!f.jW(str)) {
            return false;
        } else {
            i = 2;
        }
        return g.Di().gPJ.a(new r(str, i, eVar), 0);
    }

    public static x a(String str, boolean z, e eVar) {
        hr hrVar = new hr();
        hrVar.vNq = str;
        hrVar.vNC = z ? 1 : 0;
        hrVar.vNA = 0;
        com.tencent.mm.ae.k xVar = new x(hrVar, eVar);
        return g.Di().gPJ.a(xVar, 0) ? xVar : null;
    }

    public final void jA(String str) {
        b jy = jy(str);
        if (jy.field_wwExposeTimes < jy.field_wwMaxExposeTimes) {
            jy.field_wwExposeTimes++;
            a(jy);
        }
    }

    public static void a(x xVar) {
        g.Di().gPJ.c(xVar);
        xVar.data = null;
    }

    public final boolean jB(String str) {
        b jx = jx(str);
        return (jx == null || (jx.field_userFlag & 1) == 0) ? false : true;
    }

    public static String hn(int i) {
        String str = "";
        if (hoc == null) {
            hoc = new fa();
        }
        switch (i) {
            case 0:
                return hoc.vKO;
            case 1:
                return hoc.vKP;
            case 2:
                return hoc.vKQ;
            default:
                return str;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        int i3 = -1;
        if (i == 0 && i2 == 0) {
            e eVar;
            if (kVar instanceof r) {
                r rVar = (r) kVar;
                zm zmVar = (rVar.gJQ == null || rVar.gJQ.hmh.hmo == null) ? null : (zm) rVar.gJQ.hmh.hmo;
                if (zmVar != null && zmVar.vNw != null && zmVar.vNw.ret == 0 && zmVar.wjh != null) {
                    if (!a(zmVar.wjh)) {
                        i2 = -1;
                    }
                    eVar = (e) rVar.data;
                    if (eVar != null) {
                        eVar.a(i, i2, str, kVar);
                    }
                } else {
                    return;
                }
            }
            if (kVar instanceof x) {
                x xVar = (x) kVar;
                bgy com_tencent_mm_protocal_c_bgy = (xVar.gJQ == null || xVar.gJQ.hmh.hmo == null) ? null : (bgy) xVar.gJQ.hmh.hmo;
                if (com_tencent_mm_protocal_c_bgy != null && com_tencent_mm_protocal_c_bgy.vNw != null && com_tencent_mm_protocal_c_bgy.vNw.ret == 0 && com_tencent_mm_protocal_c_bgy.wjh != null) {
                    if (a(com_tencent_mm_protocal_c_bgy.wjh)) {
                        i3 = i2;
                    }
                    eVar = (e) xVar.data;
                    if (eVar != null) {
                        eVar.a(i, i3, str, kVar);
                    }
                }
            }
        }
    }
}
