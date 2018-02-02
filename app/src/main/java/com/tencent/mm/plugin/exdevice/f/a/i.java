package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.bmb;
import com.tencent.mm.protocal.c.ccb;
import com.tencent.mm.protocal.c.ccc;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<ahf, ahg> {
    public String appName;
    public String bhd;
    private final WeakReference<b<i>> lKt;
    public String lOU;
    public String lOV;
    public String lOW;
    public String lOX;
    public String lOY;
    public List<bmb> lOZ;
    public List<ccc> lPa;
    public ccb lPb;
    public ArrayList<String> lPc;
    public List<wb> lPd;
    public List<jm> lPe;
    public boolean lPf;
    public int lPg;
    public boolean lPh;
    public String username;

    protected final /* synthetic */ com.tencent.mm.bq.a aDC() {
        return new ahf();
    }

    protected final /* synthetic */ com.tencent.mm.bq.a aDD() {
        return new ahg();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bq.a aVar) {
        ahf com_tencent_mm_protocal_c_ahf = (ahf) aVar;
        com_tencent_mm_protocal_c_ahf.lWn = this.appName;
        com_tencent_mm_protocal_c_ahf.username = this.username;
    }

    public i(String str, String str2, b<i> bVar) {
        x.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", str2, str);
        this.username = str;
        this.appName = str2;
        this.lKt = new WeakReference(bVar);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        x.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ahg com_tencent_mm_protocal_c_ahg = (ahg) apH();
            this.lOV = com_tencent_mm_protocal_c_ahg.woA;
            this.lOW = com_tencent_mm_protocal_c_ahg.lOW;
            this.lPa = com_tencent_mm_protocal_c_ahg.woD;
            this.lPb = com_tencent_mm_protocal_c_ahg.woB;
            this.lOX = com_tencent_mm_protocal_c_ahg.woF;
            this.bhd = com_tencent_mm_protocal_c_ahg.bhd;
            this.lOY = com_tencent_mm_protocal_c_ahg.woG;
            this.lOZ = com_tencent_mm_protocal_c_ahg.vHx;
            this.lPf = com_tencent_mm_protocal_c_ahg.lPf;
            this.lPd = com_tencent_mm_protocal_c_ahg.vGV;
            this.lPe = com_tencent_mm_protocal_c_ahg.woH;
            this.lPc = new ArrayList();
            this.lPg = com_tencent_mm_protocal_c_ahg.lVM;
            this.lPh = com_tencent_mm_protocal_c_ahg.woI;
            this.lOU = com_tencent_mm_protocal_c_ahg.lOU;
            if (com_tencent_mm_protocal_c_ahg.woE != null) {
                this.lPc.addAll(com_tencent_mm_protocal_c_ahg.woE);
            }
            this.lOZ = new LinkedList();
            if (com_tencent_mm_protocal_c_ahg.vHx != null) {
                this.lOZ.addAll(com_tencent_mm_protocal_c_ahg.vHx);
            }
            if (!(this.username == null || this.username.equalsIgnoreCase(com.tencent.mm.z.q.FS()))) {
                if (this.lPf) {
                    com.tencent.mm.plugin.exdevice.f.b.b.a aEm = ad.aEm();
                    String str2 = this.username;
                    if (aEm.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new com.tencent.mm.plugin.exdevice.f.b.a.c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        aEm.b(cVar);
                    }
                } else {
                    ad.aEm().zb(this.username);
                }
            }
            if (com_tencent_mm_protocal_c_ahg.vGV != null) {
                List arrayList = new ArrayList();
                Iterator it = com_tencent_mm_protocal_c_ahg.vGV.iterator();
                while (it.hasNext()) {
                    wb wbVar = (wb) it.next();
                    ar.Hg();
                    if (com.tencent.mm.z.c.EY().WK(wbVar.username)) {
                        com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
                        cVar2.field_username = wbVar.username;
                        cVar2.field_step = wbVar.jer;
                        arrayList.add(cVar2);
                    } else {
                        ar.CG().a(new h(wbVar.username, null), 0);
                    }
                }
                x.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", Integer.valueOf(arrayList.size()), arrayList.toString());
                if (com.tencent.mm.z.q.FS().equalsIgnoreCase(this.username)) {
                    ad.aEm().aE(arrayList);
                }
            }
            this.lPe = new ArrayList();
            if (com_tencent_mm_protocal_c_ahg.woH != null) {
                this.lPe.addAll(com_tencent_mm_protocal_c_ahg.woH);
            }
            this.lPf = com_tencent_mm_protocal_c_ahg.lPf;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championMotto = this.lOW;
            aVar.field_championUrl = this.lOV;
            aVar.field_username = this.username;
            LinkedList linkedList = com_tencent_mm_protocal_c_ahg.vHx;
            ad.aEo().a(aVar, true);
        }
        b bVar = (b) this.lKt.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return 1043;
    }
}
