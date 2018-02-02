package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.m;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends h {
    public String token;

    public d(String str, String str2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i));
        x.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        D(hashMap);
    }

    public final int bKu() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.token = jSONObject.optString("token");
        }
    }

    public final void F(boolean z, boolean z2) {
        b bVar = this.gJQ;
        if (bVar == null) {
            a aVar = new a();
            aVar.hmj = new bnl();
            aVar.hmk = new bnm();
            aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            aVar.hmi = 1616;
            aVar.hml = 185;
            aVar.hmm = 1000000185;
            bVar = aVar.JZ();
            bVar.hmx = true;
        }
        b bVar2 = bVar;
        bnl com_tencent_mm_protocal_c_bnl = (bnl) bVar2.hmg.hmo;
        if (z2) {
            com_tencent_mm_protocal_c_bnl.wrv = 1;
        }
        this.gJQ = bVar2;
    }

    public final String MP(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bdn com_tencent_mm_protocal_c_bdn) {
        ((bnl) bVar.hmg.hmo).wrw = com_tencent_mm_protocal_c_bdn;
    }

    public final void b(b bVar, bdn com_tencent_mm_protocal_c_bdn) {
        ((bnl) bVar.hmg.hmo).wEj = com_tencent_mm_protocal_c_bdn;
    }

    public final m d(b bVar) {
        bnm com_tencent_mm_protocal_c_bnm = (bnm) bVar.hmh.hmo;
        m mVar = new m();
        mVar.wrA = com_tencent_mm_protocal_c_bnm.wrA;
        mVar.wrz = com_tencent_mm_protocal_c_bnm.wrz;
        mVar.wry = com_tencent_mm_protocal_c_bnm.wry;
        mVar.wrx = com_tencent_mm_protocal_c_bnm.wrx;
        mVar.lOs = com_tencent_mm_protocal_c_bnm.wEl;
        mVar.zHA = com_tencent_mm_protocal_c_bnm.wEk;
        return mVar;
    }

    public final int getType() {
        return 1616;
    }

    public final int a(e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
