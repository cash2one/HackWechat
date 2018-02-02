package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.g.a.rt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class a$a extends c<rt> {
    int msn = 0;
    int qtW = 0;
    int qtX = 0;
    WeakReference<a> qtY;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        rt rtVar = (rt) bVar;
        if (this.qtY.get() != null) {
            x.d("MicroMsg.SightPlayController", "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B", new Object[]{Integer.valueOf(((a) this.qtY.get()).hashCode()), Integer.valueOf(rtVar.fJy.type), Integer.valueOf(a.D((a) this.qtY.get())), Integer.valueOf(rtVar.fJy.fJz), Integer.valueOf(rtVar.fJy.fJA), Integer.valueOf(rtVar.fJy.fJB), Boolean.valueOf(a.E((a) this.qtY.get()))});
            switch (rtVar.fJy.type) {
                case 0:
                    a(rtVar);
                    if (bsQ() && !a.E((a) this.qtY.get())) {
                        ((a) this.qtY.get()).restart();
                        break;
                    }
                case 1:
                    break;
                case 3:
                    ((a) this.qtY.get()).clear();
                    break;
                case 5:
                    a(rtVar);
                    if (bsQ() && !a.E((a) this.qtY.get())) {
                        if (!("ERROR#PATH".equals(a.F((a) this.qtY.get())) || a.a((a) this.qtY.get()).equals(a.F((a) this.qtY.get())))) {
                            x.d("MicroMsg.SightPlayController", "match diff path, change %s to %s", new Object[]{a.a((a) this.qtY.get()), a.F((a) this.qtY.get())});
                            String F = a.F((a) this.qtY.get()) == null ? "" : a.F((a) this.qtY.get());
                            ((a) this.qtY.get()).clear();
                            a.a((a) this.qtY.get(), F);
                            a.b((a) this.qtY.get(), "ERROR#PATH");
                        }
                        ((a) this.qtY.get()).restart();
                        break;
                    }
                    ((a) this.qtY.get()).clear();
                    break;
                    break;
                case 6:
                    a.b((a) this.qtY.get(), true);
                    break;
                case 7:
                    if (a.E((a) this.qtY.get())) {
                        a.b((a) this.qtY.get(), false);
                    }
                    break;
            }
            ((a) this.qtY.get()).hZ(false);
        }
        return false;
    }

    public a$a(a aVar) {
        super(0);
        this.qtY = new WeakReference(aVar);
        this.xen = rt.class.getName().hashCode();
    }

    private void a(rt rtVar) {
        this.qtW = rtVar.fJy.fJB;
        this.qtX = rtVar.fJy.fJz;
        this.msn = rtVar.fJy.fJA;
    }

    private boolean bsQ() {
        if (this.qtY.get() == null) {
            return false;
        }
        int D = a.D((a) this.qtY.get()) + this.qtW;
        if (D < this.qtX || D > this.msn) {
            return false;
        }
        return true;
    }
}
