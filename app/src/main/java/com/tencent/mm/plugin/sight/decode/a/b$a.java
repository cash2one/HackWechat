package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.g.a.rt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$a extends c<rt> {
    int msn = 0;
    int qtW = 0;
    int qtX = 0;
    WeakReference<b> qtY;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        rt rtVar = (rt) bVar;
        if (this.qtY.get() != null) {
            x.d("MicroMsg.SightPlayController", "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B", new Object[]{Integer.valueOf(((b) this.qtY.get()).hashCode()), Integer.valueOf(rtVar.fJy.type), Integer.valueOf(b.D((b) this.qtY.get())), Integer.valueOf(rtVar.fJy.fJz), Integer.valueOf(rtVar.fJy.fJA), Integer.valueOf(rtVar.fJy.fJB), Boolean.valueOf(b.E((b) this.qtY.get()))});
            switch (rtVar.fJy.type) {
                case 0:
                    a(rtVar);
                    if (bsQ() && !b.E((b) this.qtY.get())) {
                        ((b) this.qtY.get()).restart();
                        break;
                    }
                case 1:
                    break;
                case 3:
                    ((b) this.qtY.get()).clear();
                    break;
                case 5:
                    a(rtVar);
                    if (bsQ() && !b.E((b) this.qtY.get())) {
                        if (!("ERROR#PATH".equals(b.F((b) this.qtY.get())) || b.a((b) this.qtY.get()).equals(b.F((b) this.qtY.get())))) {
                            x.d("MicroMsg.SightPlayController", "match diff path, change %s to %s", new Object[]{b.a((b) this.qtY.get()), b.F((b) this.qtY.get())});
                            String F = b.F((b) this.qtY.get()) == null ? "" : b.F((b) this.qtY.get());
                            ((b) this.qtY.get()).clear();
                            b.a((b) this.qtY.get(), F);
                            b.b((b) this.qtY.get(), "ERROR#PATH");
                        }
                        ((b) this.qtY.get()).restart();
                        break;
                    }
                    ((b) this.qtY.get()).clear();
                    break;
                    break;
                case 6:
                    b.b((b) this.qtY.get(), true);
                    break;
                case 7:
                    if (b.E((b) this.qtY.get())) {
                        b.b((b) this.qtY.get(), false);
                    }
                    break;
            }
            ((b) this.qtY.get()).hZ(false);
        }
        return false;
    }

    public b$a(b bVar) {
        super(0);
        this.qtY = new WeakReference(bVar);
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
        int D = b.D((b) this.qtY.get()) + this.qtW;
        if (D < this.qtX || D > this.msn) {
            return false;
        }
        return true;
    }
}
