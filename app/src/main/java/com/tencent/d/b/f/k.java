package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.b.b.a;
import com.tencent.d.b.d.b;
import com.tencent.d.b.e.e;

public final class k extends c {
    String AcJ = null;
    private boolean AdO = false;
    e AdR = null;
    private e AdS = null;
    private boolean AdT = false;
    private int irz = -1;

    public k(int i, e eVar, e eVar2, boolean z, boolean z2) {
        this.irz = i;
        this.AdR = eVar;
        this.AdO = z;
        this.AdT = true;
        this.AdS = eVar2;
    }

    @SuppressLint({"DefaultLocale"})
    final boolean cGg() {
        if (!a.cFX().isInit()) {
            c.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (a.cFX().cFW()) {
            this.AcJ = (String) a.cFX().cFZ().get(this.irz, "");
            if (f.ov(this.AcJ)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.c(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.irz)})));
                return true;
            }
            boolean cFM = com.tencent.d.a.a.cFM();
            if (!cFM && com.tencent.d.a.a.abt(this.AcJ)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                com.tencent.d.a.a.bs(this.AcJ, false);
            }
            if (!cFM && !this.AdT) {
                c.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                b(new com.tencent.d.b.a.c(3));
                return true;
            } else if (com.tencent.d.a.a.abt(this.AcJ) && !com.tencent.d.a.a.abu(this.AcJ)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                return false;
            } else if (!com.tencent.d.a.a.abt(this.AcJ) || this.AdO) {
                if (this.AdR == null) {
                    c.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                return false;
            } else {
                c.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                b(new com.tencent.d.b.a.c(com.tencent.d.a.a.abv(this.AcJ)));
                return true;
            }
        } else {
            c.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        }
    }

    final void cGh() {
        c.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[]{this.AcJ});
        com.tencent.d.a.a.bs(this.AcJ, false);
    }

    final void execute() {
        if (com.tencent.d.a.a.cFM() || !this.AdT) {
            cGn();
            return;
        }
        c.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        com.tencent.d.b.a.a(new 1(this), false, this.AdS);
    }

    private void cGn() {
        dI(this.AcJ, 1);
        b.a aVar = new b.a();
        String str = this.AcJ;
        boolean z = this.AdO;
        aVar.AcJ = str;
        aVar.AcL = z;
        aVar.AcI |= 2;
        aVar.AcM = new 2(this);
        aVar.cGe().cGd();
    }
}
