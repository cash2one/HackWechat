package com.tencent.mm.ap;

import android.text.TextUtils;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.f;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.protocal.c.ajf;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.g;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private ArrayList<o> hzd;
    private int hze;
    private int hzf;
    private int hzg;
    private int hzh;
    private HashMap<String, o> hzi = new HashMap();
    private String hzj;

    public c(ArrayList<o> arrayList, int i, HashMap<String, o> hashMap, String str) {
        a aVar = new a();
        aVar.hmj = new aos();
        aVar.hmk = new aot();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.hmi = 488;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.hzd = arrayList;
        this.hze = i;
        this.hzf = 0;
        this.hzh = 1;
        this.hzi = hashMap;
        this.hzj = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.gJT = eVar2;
        aos com_tencent_mm_protocal_c_aos = (aos) this.gJQ.hmg.hmo;
        if (this.hzd != null) {
            LinkedList linkedList = new LinkedList();
            this.hzg = this.hzd.size();
            int i = this.hzf;
            while (i < this.hzg && i < this.hzf + 500) {
                ajf com_tencent_mm_protocal_c_ajf = new ajf();
                com_tencent_mm_protocal_c_ajf.vLO = ((o) this.hzd.get(i)).field_googlegmail;
                linkedList.add(com_tencent_mm_protocal_c_ajf);
                i++;
            }
            com_tencent_mm_protocal_c_aos.ksP = linkedList;
            com_tencent_mm_protocal_c_aos.ksO = linkedList.size();
            if (this.hzf + 500 > this.hzg) {
                this.hzh = 0;
            } else {
                this.hzh = 1;
            }
            com_tencent_mm_protocal_c_aos.vPq = this.hzh;
            com_tencent_mm_protocal_c_aos.wvz = this.hze;
            x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[]{Integer.valueOf(this.hzg), Integer.valueOf(this.hzf), Integer.valueOf(this.hzh)});
        }
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            a(Pb());
            if (this.hzh == 1) {
                this.hzf += 500;
                if (a(this.hmA, this.gJT) < 0) {
                    x.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.gJT.a(3, -1, "", this);
                }
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final aot Pb() {
        return (aot) this.gJQ.hmh.hmo;
    }

    private synchronized void a(aot com_tencent_mm_protocal_c_aot) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aot.ksO)});
        if (com_tencent_mm_protocal_c_aot.ksP != null && com_tencent_mm_protocal_c_aot.ksP.size() > 0) {
            int size = com_tencent_mm_protocal_c_aot.ksP.size();
            ArrayList arrayList = new ArrayList();
            List linkedList = new LinkedList();
            for (int i = 0; i < size; i++) {
                int i2;
                aje com_tencent_mm_protocal_c_aje = (aje) com_tencent_mm_protocal_c_aot.ksP.get(i);
                if (TextUtils.isEmpty(com_tencent_mm_protocal_c_aje.ksU)) {
                    i2 = 1;
                } else {
                    ar.Hg();
                    af WO = com.tencent.mm.z.c.EY().WO(com_tencent_mm_protocal_c_aje.ksU);
                    i2 = (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) ? 0 : 2;
                }
                if (this.hzi != null && this.hzi.containsKey(com_tencent_mm_protocal_c_aje.vLO)) {
                    o oVar = (o) this.hzi.get(com_tencent_mm_protocal_c_aje.vLO);
                    oVar.field_username = com_tencent_mm_protocal_c_aje.ksU;
                    oVar.field_nickname = com_tencent_mm_protocal_c_aje.kub;
                    oVar.field_usernamepy = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_aje.kub);
                    oVar.field_nicknameqp = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_aje.kub);
                    oVar.field_ret = com_tencent_mm_protocal_c_aje.vJU;
                    oVar.field_small_url = com_tencent_mm_protocal_c_aje.wqE;
                    oVar.field_big_url = com_tencent_mm_protocal_c_aje.wqD;
                    oVar.field_status = i2;
                    oVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        oVar.field_contecttype = "weixin" + i;
                    } else {
                        oVar.field_contecttype = "google";
                    }
                    oVar.field_googlenamepy = com.tencent.mm.platformtools.c.om(oVar.field_googlename);
                    arrayList.add(oVar);
                    Object obj = oVar.field_googleid;
                    String str = oVar.field_googlephotourl;
                    String str2 = this.hzj;
                    if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        String str3 = obj + "@google";
                        h jm = n.JQ().jm(str3);
                        if (jm == null) {
                            jm = new h();
                        }
                        jm.username = str3;
                        jm.fWe = 3;
                        jm.hly = com.tencent.mm.ad.b.ab(str, str2);
                        jm.hlx = com.tencent.mm.ad.b.ab(str, str2);
                        jm.bA(true);
                        jm.fDt = 31;
                        n.JQ().a(jm);
                    }
                    f aVar = new g.a();
                    aVar.field_userName = com_tencent_mm_protocal_c_aje.ksU;
                    aVar.field_scene = 58;
                    aVar.field_ticket = com_tencent_mm_protocal_c_aje.whR;
                    linkedList.add(aVar);
                }
            }
            com.tencent.mm.modelfriend.af.OL().f(arrayList);
            ar.Hg();
            com.tencent.mm.z.c.FI().cC(linkedList);
        }
    }

    public final int getType() {
        return 488;
    }

    protected final int Bh() {
        return 20;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }
}
