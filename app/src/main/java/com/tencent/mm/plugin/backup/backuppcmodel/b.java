package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;

public final class b extends d {
    private static b knx;
    private a kkN;
    private d knA;
    private a knB;
    private c kny;
    private e knz;
    private WakeLock wakeLock = null;

    public static b aps() {
        if (knx == null) {
            com.tencent.mm.plugin.backup.a.a bVar = new b();
            knx = bVar;
            a(bVar);
        }
        return knx;
    }

    public final void aog() {
        knx = null;
    }

    public final void j(Object... objArr) {
        ((Boolean) objArr[0]).booleanValue();
        new af(Looper.getMainLooper()).postDelayed(new c$5(aps().apt()), 100);
    }

    public final a aoS() {
        if (this.kkN == null) {
            this.kkN = new a();
        }
        return this.kkN;
    }

    public final c apt() {
        if (this.kny == null) {
            this.kny = new c();
        }
        return this.kny;
    }

    public final e apu() {
        if (this.knz == null) {
            this.knz = new e();
        }
        return this.knz;
    }

    public final d apv() {
        if (this.knA == null) {
            this.knA = new d();
        }
        return this.knA;
    }

    public final a apw() {
        if (this.knB == null) {
            this.knB = new a();
        }
        return this.knB;
    }

    public final void aom() {
        ag.y(new 1(this));
    }

    public final void aon() {
        ag.y(new 2(this));
    }
}
