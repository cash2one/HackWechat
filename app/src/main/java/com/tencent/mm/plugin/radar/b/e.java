package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import b.i;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bam;
import com.tencent.mm.protocal.c.ban;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e implements com.tencent.mm.ae.e {
    private static final String TAG = TAG;
    private static final int pxq = pxq;
    private static final int pxr = 5000;
    private static final int pxs = 1;
    public static final b pxt = new b((byte) 0);
    private final Context context;
    private String frP;
    public final a gyF = new i(this);
    private final LinkedList<bao> hII = new LinkedList();
    private boolean hnr;
    public c hpO;
    private Location pxe;
    private b pxf;
    private f pxg = f.pxF;
    public LinkedList<bam> pxh;
    public Map<String, String> pxi = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> pxj = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> pxk = new LinkedHashMap();
    public Map<Long, c> pxl = new LinkedHashMap();
    public Map<String, a> pxm = new LinkedHashMap();
    private final ak pxn = new ak(new h(this), false);
    private final g pxo = new g();
    private final d pxp;

    public e(d dVar, Context context) {
        b.c.b.e.i(dVar, "delegate");
        b.c.b.e.i(context, "context");
        this.pxp = dVar;
        this.context = context;
    }

    public final void blt() {
        blu();
        this.hnr = false;
        this.pxe = null;
        this.pxg = f.pxF;
        this.pxn.TG();
        x.d(TAG, "start radar");
        if (this.hpO == null) {
            this.hpO = c.OP();
        }
        this.pxg = f.pxG;
        c cVar = this.hpO;
        if (cVar != null) {
            cVar.b(this.gyF);
        }
        x.d(TAG, "status: %s", new Object[]{this.pxg});
    }

    public final void blu() {
        switch (f.pxK[this.pxg.ordinal()]) {
            case 1:
                return;
            case 2:
                stop();
                break;
            case 3:
                if (this.pxf != null) {
                    stop();
                    g.CG().c(this.pxf);
                    blv();
                    break;
                }
                break;
            case 4:
                stop();
                blv();
                break;
        }
        x.d(TAG, "stop radar");
    }

    private final void blv() {
        this.pxo.sendEmptyMessageDelayed(pxs, (long) pxr);
    }

    public final void stop() {
        this.hnr = true;
        this.pxg = f.pxF;
        this.pxn.TG();
    }

    private final void a(int i, int i2, LinkedList<bao> linkedList) {
        this.pxp.a(i, i2, linkedList);
    }

    private final void b(int i, int i2, LinkedList<bal> linkedList) {
        this.pxp.b(i, i2, linkedList);
    }

    public final void a(int i, int i2, String str, k kVar) {
        LinkedList linkedList = null;
        b.c.b.e.i(kVar, "scene");
        switch (kVar.getType()) {
            case com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX /*425*/:
                if (this.pxf != kVar) {
                    return;
                }
                if (((b) kVar).fut == 1) {
                    this.pxg = f.pxI;
                    if (i == 0 && i2 == 0) {
                        x.d(TAG, "rader members count: %s ticket: %s", new Object[]{Integer.valueOf(((b) kVar).blr()), this.frP});
                        this.pxn.fH((long) pxq);
                        b bVar = ((b) kVar).gJQ;
                        baq com_tencent_mm_protocal_c_baq = (baq) (bVar != null ? bVar.JX() : null);
                        if (com_tencent_mm_protocal_c_baq != null) {
                            linkedList = com_tencent_mm_protocal_c_baq.vGF;
                        }
                        if (linkedList != null) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                bao com_tencent_mm_protocal_c_bao = (bao) it.next();
                                Object XW = com.tencent.mm.plugin.d.a.XW();
                                b.c.b.e.h(XW, "PinAntispam.instance()");
                                XW.FI().fB(com_tencent_mm_protocal_c_bao.ksU, com_tencent_mm_protocal_c_bao.whR);
                            }
                        }
                        if (linkedList != null) {
                            this.hII.clear();
                            this.hII.addAll(linkedList);
                        }
                        LinkedList linkedList2 = this.hII;
                        ((b) kVar).blr();
                        a(i, i2, linkedList2);
                        x.d(TAG, "status: %s", new Object[]{this.pxg});
                        return;
                    }
                    stop();
                    a(i, i2, null);
                    return;
                }
                a(i, i2, null);
                return;
            case 602:
                x.d(TAG, " MMFunc_MMRadarRelationChain ");
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.bq.a JX = ((a) kVar).gJQ.JX();
                    if (JX == null) {
                        throw new i("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
                    }
                    ban com_tencent_mm_protocal_c_ban = (ban) JX;
                    this.frP = com_tencent_mm_protocal_c_ban.vZK;
                    if (com_tencent_mm_protocal_c_ban.kZx > 0) {
                        linkedList = com_tencent_mm_protocal_c_ban.vGF;
                        int i3 = com_tencent_mm_protocal_c_ban.kZx;
                        b(i, i2, linkedList);
                        return;
                    }
                    b(i, i2, null);
                    return;
                }
                b(i, i2, null);
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        Object obj = (com.tencent.mm.plugin.radar.b.c.e) this.pxj.get(str);
        if (obj != null && (b.c.b.e.h(obj, (Object) eVar) ^ 1) != 0) {
            this.pxk.put(str, obj);
        }
    }

    public final void b(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        b.c.b.e.i(str, "username");
        b.c.b.e.i(eVar, "state");
        if (!b.f.a.X(str)) {
            a(str, eVar);
            this.pxj.put(str, eVar);
        }
    }

    public final com.tencent.mm.plugin.radar.b.c.e a(bao com_tencent_mm_protocal_c_bao, boolean z) {
        b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
        Object obj = com_tencent_mm_protocal_c_bao.ksU;
        b.c.b.e.h(obj, "member.UserName");
        com.tencent.mm.plugin.radar.b.c.e aw = aw(obj, z);
        if (aw != null) {
            return aw;
        }
        obj = com_tencent_mm_protocal_c_bao.wcv;
        b.c.b.e.h(obj, "member.EncodeUserName");
        return aw(obj, z);
    }

    public final com.tencent.mm.plugin.radar.b.c.e Ia(String str) {
        b.c.b.e.i(str, "username");
        return aw(str, false);
    }

    private final com.tencent.mm.plugin.radar.b.c.e aw(String str, boolean z) {
        if (z) {
            return (com.tencent.mm.plugin.radar.b.c.e) this.pxk.get(str);
        }
        return (com.tencent.mm.plugin.radar.b.c.e) this.pxj.get(str);
    }

    public final void a(bao com_tencent_mm_protocal_c_bao) {
        if (com_tencent_mm_protocal_c_bao != null) {
            com.tencent.mm.plugin.radar.ui.g gVar = com.tencent.mm.plugin.radar.ui.g.pzC;
            String b = com.tencent.mm.plugin.radar.ui.g.b(com_tencent_mm_protocal_c_bao);
            if (this.pxm.containsKey(b)) {
                this.pxm.remove(b);
            } else {
                this.pxm.put(b, a.pxu);
            }
        }
    }
}
