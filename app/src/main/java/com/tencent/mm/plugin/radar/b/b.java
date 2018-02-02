package com.tencent.mm.plugin.radar.b;

import b.i;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private static final String TAG = TAG;
    public static final a pww = new a();
    private final float fBc;
    private final int fBd;
    private final int fBe;
    private final String fBf;
    private final String fBg;
    final int fut;
    private final float fzt;
    com.tencent.mm.ae.b gJQ;
    private e gJT;

    public static final class a {
        private a() {
        }
    }

    public /* synthetic */ b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
    }

    public b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        b.c.b.e.i(str, "macAddr");
        b.c.b.e.i(str2, "cellId");
        this.fut = i;
        this.fzt = f;
        this.fBc = f2;
        this.fBd = i2;
        this.fBe = i3;
        this.fBf = str;
        this.fBg = str2;
        if (this.fut == 0) {
            x.e(TAG, "opcode is wrong!");
        }
    }

    public final int blr() {
        com.tencent.mm.ae.b bVar = this.gJQ;
        baq com_tencent_mm_protocal_c_baq = (baq) (bVar != null ? bVar.JX() : null);
        return com_tencent_mm_protocal_c_baq != null ? com_tencent_mm_protocal_c_baq.kZx : 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d(TAG, "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.fut == 1 && i2 == 0) {
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.ae.b bVar = this.gJQ;
            com.tencent.mm.bq.a JX = bVar != null ? bVar.JX() : null;
            if (!(JX instanceof baq)) {
                JX = null;
            }
            baq com_tencent_mm_protocal_c_baq = (baq) JX;
            if (com_tencent_mm_protocal_c_baq != null) {
                LinkedList<Object> linkedList = com_tencent_mm_protocal_c_baq.vGF;
                if (linkedList != null) {
                    for (Object obj : linkedList) {
                        h hVar = new h();
                        g gVar = g.pzC;
                        b.c.b.e.h(obj, "member");
                        hVar.setUsername(g.b(obj));
                        hVar.jl(obj.wao);
                        hVar.bA(true);
                        arrayList.add(hVar);
                    }
                }
            }
            n.JQ().H(arrayList);
        }
        e eVar = this.gJT;
        if (eVar != null) {
            eVar.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        b.c.b.e.i(eVar, "dispatcher");
        b.c.b.e.i(eVar2, "callback");
        this.gJT = eVar2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.a(new bap());
        aVar.b(new baq());
        aVar.jo("/cgi-bin/micromsg-bin/mmradarsearch");
        aVar.hh(com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX);
        aVar.hi(c.CTRL_INDEX);
        aVar.hj(1000000209);
        this.gJQ = aVar.JZ();
        com.tencent.mm.ae.b bVar = this.gJQ;
        if (bVar == null) {
            b.c.b.e.cJy();
        }
        com.tencent.mm.bq.a JW = bVar.JW();
        if (JW == null) {
            throw new i("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
        }
        bap com_tencent_mm_protocal_c_bap = (bap) JW;
        com_tencent_mm_protocal_c_bap.vDW = this.fut;
        com_tencent_mm_protocal_c_bap.wct = this.fBg;
        com_tencent_mm_protocal_c_bap.wcu = this.fBe;
        com_tencent_mm_protocal_c_bap.vQu = this.fzt;
        com_tencent_mm_protocal_c_bap.vQt = this.fBc;
        com_tencent_mm_protocal_c_bap.wcs = this.fBf;
        com_tencent_mm_protocal_c_bap.wcr = this.fBd;
        return a(eVar, this.gJQ, this);
    }
}
