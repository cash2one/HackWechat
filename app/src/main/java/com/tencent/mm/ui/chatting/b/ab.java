package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.ff$a;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.viewitems.ah.d.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class ab {
    private static HashMap<Long, String> yCo = new HashMap();
    private static HashMap<Long, a> yCp = new HashMap();
    private static LinkedHashMap<Long, au> yCq = new LinkedHashMap();
    private static HashMap<Long, Boolean> yCr = new HashMap();
    private p fhr;
    public boolean yCs = false;
    long yCt = 0;
    boolean yCu = false;

    public ab(p pVar) {
        this.fhr = pVar;
    }

    public final synchronized void a(long j, String str, a aVar) {
        yCo.put(Long.valueOf(j), str);
        yCp.put(Long.valueOf(j), aVar);
        if (aVar == a.yNW) {
            yCr.put(Long.valueOf(j), Boolean.valueOf(true));
        }
    }

    public final synchronized void ge(long j) {
        yCo.remove(Long.valueOf(j));
        yCp.remove(Long.valueOf(j));
    }

    public final synchronized String v(long j, String str) {
        String str2;
        str2 = (String) yCo.get(Long.valueOf(j));
        if (bh.ov(str2)) {
            bl XO = m.UE().XO(str);
            if (!(XO == null || bh.ov(XO.field_content))) {
                str2 = XO.field_content;
            }
        }
        return str2;
    }

    public final synchronized a gf(long j) {
        a aVar;
        aVar = (a) yCp.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = a.yNT;
        }
        return aVar;
    }

    private synchronized void c(long j, au auVar) {
        yCq.put(Long.valueOf(j), auVar);
    }

    public final synchronized boolean gg(long j) {
        boolean z;
        if (yCq.containsKey(Long.valueOf(j))) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized au gh(long j) {
        return (au) yCq.get(Long.valueOf(j));
    }

    public final synchronized au ctZ() {
        au auVar;
        Iterator it = yCq.entrySet().iterator();
        if (it.hasNext()) {
            auVar = (au) ((Entry) it.next()).getValue();
        } else {
            auVar = null;
        }
        return auVar;
    }

    public final synchronized void gi(long j) {
        if (yCq.containsKey(Long.valueOf(j))) {
            yCq.remove(Long.valueOf(j));
        }
    }

    public final synchronized void cua() {
        yCq.clear();
    }

    public static boolean cub() {
        ar.Hg();
        return !((Boolean) c.CU().get(75, Boolean.valueOf(false))).booleanValue();
    }

    public static void cuc() {
        ar.Hg();
        c.CU().set(75, Boolean.valueOf(true));
    }

    public final void e(au auVar, boolean z) {
        int i = 4;
        if (auVar == null) {
            x.d("MicroMsg.TransformImp", "go VoiceTransTextAct need MsgInfo but null");
        } else if (gj(auVar.field_msgId)) {
            x.i("MicroMsg.TransformImp", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[]{Long.valueOf(auVar.field_msgId), Boolean.valueOf(this.yCs)});
            auVar.cjA();
            gk(auVar.field_msgId);
            notifyDataSetChanged();
        } else if (gg(auVar.field_msgId) && z) {
            if (gf(auVar.field_msgId) == a.yNU) {
                x.i("MicroMsg.TransformImp", "go VoiceTransTextAct unsetflag removeCache");
                gi(auVar.field_msgId);
                ge(auVar.field_msgId);
                c(5, auVar);
            } else if (this.yCs) {
                b ffVar = new ff();
                ffVar.fuq.fut = 3;
                com.tencent.mm.sdk.b.a.xef.m(ffVar);
                gi(auVar.field_msgId);
                ge(auVar.field_msgId);
                auVar.cjA();
                ar.Hg();
                c.Fa().a(auVar.field_msgId, auVar);
                cud();
            }
            notifyDataSetChanged();
        } else {
            bl XO = m.UE().XO(auVar.field_imgPath);
            if (XO == null || bh.ov(XO.field_content)) {
                int Km = ar.CG().Km();
                if (Km != 4 && Km != 6) {
                    h.h(getContext(), R.l.dTg, R.l.dGO);
                    c(2, auVar);
                    return;
                } else if (this.yCs) {
                    x.i("MicroMsg.TransformImp", "go VoiceTransformText insert transformQueue");
                    c(auVar.field_msgId, auVar);
                    a(auVar.field_msgId, "", a.yNU);
                    notifyDataSetChanged();
                    return;
                } else {
                    b ffVar2 = new ff();
                    ffVar2.fuq.fut = 1;
                    com.tencent.mm.sdk.b.a.xef.m(ffVar2);
                    ffVar2 = new ff();
                    ffVar2.fuq.fus = String.valueOf(auVar.field_msgId);
                    ffVar2.fuq.fileName = auVar.field_imgPath;
                    ffVar2.fuq.fqe = 1;
                    ffVar2.fuq.fut = 0;
                    ff$a com_tencent_mm_g_a_ff_a = ffVar2.fuq;
                    if (!s.gF(this.fhr.csi().field_username)) {
                        i = this.fhr.csd() ? 2 : 1;
                    } else if (!this.fhr.csf()) {
                        i = f.jW(this.fhr.csi().field_username) ? 3 : f.jX(this.fhr.csi().field_username) ? 0 : f.jT(this.fhr.csi().field_username) ? 6 : 7;
                    } else if (this.fhr.csg()) {
                        i = 5;
                    }
                    com_tencent_mm_g_a_ff_a.scene = i;
                    ffVar2.fuq.fuu = new 1(this, ffVar2);
                    a(Long.valueOf(ffVar2.fuq.fus).longValue(), "", a.yNV);
                    c(auVar.field_msgId, auVar);
                    this.yCs = true;
                    notifyDataSetChanged();
                    if (com.tencent.mm.sdk.b.a.xef.m(ffVar2)) {
                        x.i("MicroMsg.TransformImp", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
                        return;
                    }
                    x.i("MicroMsg.TransformImp", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
                    Zl(getContext().getString(R.l.dTf));
                    ge(Long.valueOf(ffVar2.fuq.fus).longValue());
                    gi(Long.valueOf(ffVar2.fuq.fus).longValue());
                    this.yCs = false;
                    cud();
                    return;
                }
            }
            x.i("MicroMsg.TransformImp", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[]{Long.valueOf(auVar.field_msgId), auVar.field_imgPath});
            auVar.cjB();
            a(auVar.field_msgId, XO.field_content, a.yNW);
            ar.Hg();
            c.Fa().a(auVar.field_msgId, auVar);
        }
    }

    private static void c(int i, au auVar) {
        if (auVar != null) {
            b fjVar = new fj();
            fjVar.fuB.fuD = 0;
            fjVar.fuB.fuE = 0;
            fjVar.fuB.fuF = 0;
            fjVar.fuB.fuC = 0;
            fjVar.fuB.fileName = auVar.field_imgPath;
            fjVar.fuB.result = i;
            com.tencent.mm.sdk.b.a.xef.m(fjVar);
        }
    }

    public final synchronized void cud() {
        af css = this.fhr != null ? this.fhr.css() : null;
        if (css != null) {
            css.post(new 2(this));
        }
    }

    private void notifyDataSetChanged() {
        if (this.fhr != null) {
            this.fhr.cpl();
        }
    }

    private Context getContext() {
        if (this.fhr != null) {
            return this.fhr.csq().getContext();
        }
        return ac.getContext();
    }

    private void Zl(String str) {
        if (this.fhr != null && this.fhr.csq() != null && this.fhr.csq().getActivity() != null) {
            Toast makeText = Toast.makeText(this.fhr.csq().getActivity(), str, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public final synchronized boolean gj(long j) {
        boolean booleanValue;
        Boolean bool = (Boolean) yCr.get(Long.valueOf(j));
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            booleanValue = false;
        }
        return booleanValue;
    }

    private synchronized void gk(long j) {
        yCr.put(Long.valueOf(j), Boolean.valueOf(false));
    }
}
