package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class b {
    public a lvh = new a();
    public com.tencent.mm.plugin.emoji.c.b lvi = new com.tencent.mm.plugin.emoji.c.b();
    public d lvj = new d();
    public c lvk = new c();
    public com.tencent.mm.sdk.b.c lvl = new 1(this);
    public com.tencent.mm.sdk.b.c lvm = new 3(this);
    public com.tencent.mm.sdk.b.c lvn = new 4(this);
    public com.tencent.mm.sdk.b.c lvo = new 5(this);
    public com.tencent.mm.sdk.b.c lvp = new 6(this);
    public final com.tencent.mm.sdk.b.c lvq = new com.tencent.mm.sdk.b.c<az>(this) {
        final /* synthetic */ b lvv;

        {
            this.lvv = r2;
            this.xen = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a aBz = i.aBz();
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", new Object[]{w.cfi().toLowerCase(), aBz.luY});
            if (!(bh.ov(aBz.luY) || aBz.luY.equalsIgnoreCase(r1))) {
                aBz.aAN();
            }
            i.aBE();
            l.lwW = true;
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lvr = new 8(this);
    public com.tencent.mm.sdk.b.c lvs = new com.tencent.mm.sdk.b.c<cp>(this) {
        final /* synthetic */ b lvv;

        {
            this.lvv = r2;
            this.xen = cp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cp cpVar = (cp) bVar;
            if (cpVar != null && (cpVar instanceof cp)) {
                boolean z = cpVar.fqO.fqP;
                ar.Hg();
                com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.xnv, Boolean.valueOf(z));
                i.aBF().lwq = z;
                if (z) {
                    Toast.makeText(ac.getContext(), R.l.dZG, 0).show();
                } else {
                    g.pQN.h(12953, new Object[]{Integer.valueOf(2), ""});
                    Toast.makeText(ac.getContext(), R.l.dZE, 0).show();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lvt = new 10(this);
    public com.tencent.mm.sdk.b.c lvu = new 2(this);
}
