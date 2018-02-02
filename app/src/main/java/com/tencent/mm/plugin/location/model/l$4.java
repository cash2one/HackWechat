package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class l$4 extends c<hu> {
    final /* synthetic */ l nRF;

    l$4(l lVar) {
        this.nRF = lVar;
        this.xen = hu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hu huVar = (hu) bVar;
        j aVt = l.aVt();
        cf cfVar = huVar.fye.fnB;
        ImageView imageView = huVar.fye.fyg;
        ProgressBar progressBar = huVar.fye.fyi;
        ImageView imageView2 = huVar.fye.fyh;
        int i = huVar.fye.fyj;
        int i2 = huVar.fye.w;
        int i3 = huVar.fye.h;
        String str = cfVar.field_content;
        if (!bh.ov(str)) {
            aVt.w = i2;
            aVt.h = i3;
            if (aVt.w <= 0 || aVt.h <= 0) {
                aVt.w = 300;
                aVt.h = 300;
            }
            boolean z = cfVar.field_isSend == 0;
            if (s.eV(cfVar.field_talker) && z) {
                int hO = ba.hO(str);
                if (hO != -1) {
                    str = str.substring(hO + 1).trim();
                }
            }
            ar.Hg();
            au.b EL = com.tencent.mm.z.c.Fa().EL(str);
            if (cfVar.gjL == 5 || aVt.nRe.contains(Long.valueOf(cfVar.field_msgId))) {
                x.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", new Object[]{Long.valueOf(cfVar.field_msgId), Integer.valueOf(cfVar.gjL)});
                imageView2.setVisibility(0);
                progressBar.setVisibility(8);
            } else {
                com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(cfVar.field_msgId, (float) EL.nQx, (float) EL.nQy, (int) (((double) EL.fzv) * 1.1d), 0);
                progressBar.setVisibility(0);
                imageView2.setVisibility(8);
                k aVs = l.aVs();
                aVs.w = i2;
                aVs.h = i3;
                if (aVs.w <= 0 || aVs.h <= 0) {
                    aVs.w = 300;
                    aVs.h = 300;
                }
                String b = k.b(bVar2);
                if (e.bO(b)) {
                    if (!ar.Hj()) {
                        b = "";
                    }
                } else if (aVs.nRg == null || !aVs.nRg.toString().equals(bVar2.toString())) {
                    Iterator it = aVs.nRf.iterator();
                    while (it.hasNext()) {
                        if (bVar2.toString().equals(((com.tencent.mm.pluginsdk.location.b) it.next()).toString())) {
                            x.i("MicroMsg.StaticMapServer", "has add queue");
                            aVs.OO();
                            b = "";
                            break;
                        }
                    }
                    aVs.nRf.add(bVar2);
                    x.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", new Object[]{Integer.valueOf(aVs.nRf.size()), Integer.valueOf(aVs.w), Integer.valueOf(aVs.h)});
                    aVs.OO();
                    b = "";
                } else {
                    x.i("MicroMsg.StaticMapServer", "has add queue");
                    aVs.OO();
                    b = "";
                }
                if (bh.ov(b) || !e.bO(b)) {
                    aVt.nQZ.put(Long.valueOf(bVar2.vcV), EL);
                    aVt.nRd.put(Long.valueOf(cfVar.field_msgId), Integer.valueOf(i));
                    aVt.nRc.put(EL, cfVar);
                    aVt.nQY.put(Long.valueOf(cfVar.field_msgId), new WeakReference(imageView));
                    aVt.nRa.put(Long.valueOf(cfVar.field_msgId), new WeakReference(progressBar));
                    aVt.nRb.put(Long.valueOf(cfVar.field_msgId), new WeakReference(imageView2));
                    aVt.start();
                } else {
                    x.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", new Object[]{Integer.valueOf(i)});
                    if (ar.Hj()) {
                        Bitmap a = o.Pw().a(cfVar.field_msgId, b, i, aVt.w, aVt.h, z);
                        if (!(a == null || a.isRecycled())) {
                            imageView.setImageBitmap(a);
                            progressBar.setVisibility(8);
                            imageView2.setVisibility(0);
                        }
                    }
                }
            }
        }
        return false;
    }
}
