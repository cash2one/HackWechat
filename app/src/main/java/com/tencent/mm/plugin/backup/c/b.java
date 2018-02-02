package com.tencent.mm.plugin.backup.c;

import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.sdk.platformtools.ag;

public final class b extends d {
    private static b kkJ;
    private d kkK;
    private c kkL;
    private a kkM;
    private a kkN;
    String kkO = "tickit";
    private WakeLock wakeLock = null;

    public static b aoR() {
        if (kkJ == null) {
            com.tencent.mm.plugin.backup.a.a bVar = new b();
            kkJ = bVar;
            a(bVar);
        }
        return kkJ;
    }

    public final void aog() {
        kkJ = null;
    }

    public final void j(Object... objArr) {
        ag.y(new 1(this, (String) objArr[0]));
    }

    public final a aoS() {
        if (this.kkN == null) {
            this.kkN = new a();
        }
        return this.kkN;
    }

    public final d aoT() {
        if (this.kkK == null) {
            this.kkK = new d();
        }
        return this.kkK;
    }

    public final c aoU() {
        if (this.kkL == null) {
            this.kkL = new c();
        }
        return this.kkL;
    }

    public final a aoV() {
        if (this.kkM == null) {
            this.kkM = new a();
        }
        return this.kkM;
    }

    public final void aom() {
        ag.y(new 2(this));
    }

    public final void aon() {
        ag.y(new 3(this));
    }
}
