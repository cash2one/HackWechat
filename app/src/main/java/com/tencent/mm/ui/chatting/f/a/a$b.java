package com.tencent.mm.ui.chatting.f.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.b.b.b;
import java.util.ArrayList;
import java.util.Iterator;

class a$b implements Runnable {
    private au fnB;
    private int scene;
    private CharSequence text;

    a$b(CharSequence charSequence, au auVar, int i) {
        this.text = charSequence;
        this.fnB = auVar;
        this.scene = i;
    }

    public final void run() {
        if (this.text instanceof Spannable) {
            try {
                Spannable spannable = (Spannable) this.text;
                System.nanoTime();
                Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
                ArrayList arrayList = new ArrayList(1);
                if (spans == null || spans.length == 0) {
                    arrayList = null;
                } else {
                    for (Object obj : spans) {
                        if (d.oSu.b(obj, m.class)) {
                            arrayList.add(new a$b$a$a().a(obj, spannable));
                        }
                    }
                }
                if (arrayList != null && arrayList.size() != 0) {
                    this.fnB = ((h) g.h(h.class)).aZi().dH(this.fnB.field_msgId);
                    if (!(this.fnB == null || bh.ov(this.fnB.field_talker))) {
                        this.fnB.fa(this.fnB.field_flag | 16);
                        ((h) g.h(h.class)).aZi().a(this.fnB.field_msgId, this.fnB);
                    }
                    ar.Hg().FH().Iv();
                    ar.Hg().FH().b(b.his);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = ((c) it.next()).extInfo;
                        com.tencent.mm.plugin.report.service.g.pQN.h(14237, new Object[]{"msg", Long.valueOf(this.fnB.field_msgId), Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), str});
                        com.tencent.mm.plugin.report.service.g.pQN.a(587, 0, 1, false);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
