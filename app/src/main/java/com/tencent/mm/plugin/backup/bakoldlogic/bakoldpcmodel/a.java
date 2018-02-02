package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b;

public final class a extends d {
    private static a kqn;
    private e kqo;
    private c kqp;
    private b kqq;

    public static a aql() {
        if (kqn == null) {
            com.tencent.mm.plugin.backup.a.a aVar = new a();
            kqn = aVar;
            a(aVar);
        }
        return kqn;
    }

    public final void aog() {
        kqn = null;
    }

    public final void j(Object... objArr) {
        Context context = (Context) objArr[0];
        aql().aqo().aqp();
        b.clear();
        context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    }

    public final e aqm() {
        if (this.kqo == null) {
            this.kqo = new e();
        }
        return this.kqo;
    }

    public final c aqn() {
        if (this.kqp == null) {
            this.kqp = new c();
        }
        return this.kqp;
    }

    public final b aqo() {
        if (this.kqq == null) {
            this.kqq = new b();
        }
        return this.kqq;
    }

    public final void aom() {
    }

    public final void aon() {
    }
}
