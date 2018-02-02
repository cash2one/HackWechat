package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.aq.o;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements a {
    int h = 300;
    HashMap<Long, WeakReference<ImageView>> nQY = new HashMap();
    HashMap<Long, b> nQZ = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> nRa = new HashMap();
    HashMap<Long, WeakReference<ImageView>> nRb = new HashMap();
    HashMap<b, au> nRc = new HashMap();
    HashMap<Long, Integer> nRd = new HashMap();
    HashSet<Long> nRe = new HashSet();
    int w = 300;

    public j() {
        start();
    }

    public final void start() {
        k aVs = l.aVs();
        if (this != null) {
            for (a equals : aVs.gxL) {
                if (equals(equals)) {
                    return;
                }
            }
            aVs.gxL.add(this);
            x.i("MicroMsg.StaticMapServer", "addMapCallBack " + aVs.gxL.size());
            if (aVs.gxL.size() == 1) {
                aVs.start();
            }
        }
    }

    public final void a(String str, com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.nQZ.containsKey(Long.valueOf(bVar.vcV))) {
            au auVar = (au) this.nRc.remove((b) this.nQZ.get(Long.valueOf(bVar.vcV)));
            if (auVar != null) {
                WeakReference weakReference = (WeakReference) this.nQY.get(Long.valueOf(auVar.field_msgId));
                if (weakReference != null && weakReference.get() != null && this.nRd.containsKey(Long.valueOf(auVar.field_msgId))) {
                    ((ImageView) weakReference.get()).setImageBitmap(o.Pw().a(auVar.field_msgId, str, ((Integer) this.nRd.remove(Long.valueOf(auVar.field_msgId))).intValue(), this.w, this.h, auVar.field_isSend == 0));
                    weakReference = (WeakReference) this.nRa.remove(Long.valueOf(auVar.field_msgId));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((ProgressBar) weakReference.get()).setVisibility(8);
                    }
                    WeakReference weakReference2 = (WeakReference) this.nRb.remove(Long.valueOf(auVar.field_msgId));
                    if (weakReference2 != null && weakReference2.get() != null) {
                        ((ImageView) weakReference2.get()).setVisibility(0);
                    }
                }
            }
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.nQZ.containsKey(Long.valueOf(bVar.vcV))) {
            au auVar = (au) this.nRc.remove((b) this.nQZ.get(Long.valueOf(bVar.vcV)));
            if (auVar != null) {
                this.nQY.get(Long.valueOf(auVar.field_msgId));
                if (auVar == null) {
                    return;
                }
                if (auVar.gjL < 0 || auVar.gjL > 5) {
                    auVar.fe(0);
                    auVar.fe(auVar.gjL + 1);
                    if (ar.Hj()) {
                        ar.Hg();
                        c.Fa().a(auVar.field_msgId, auVar);
                        x.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[]{Integer.valueOf(auVar.gjL)});
                    }
                }
            }
        }
    }
}
