package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.g.a;

class i$1 implements a {
    final /* synthetic */ i AdM;

    i$1(i iVar) {
        this.AdM = iVar;
    }

    @SuppressLint({"ApplySharedPref"})
    public final void cFV() {
        c.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
        SharedPreferences cGa = com.tencent.d.b.b.a.cFX().cGa();
        if (cGa != null) {
            Editor edit = cGa.edit();
            edit.putBoolean(i.by(), true);
            edit.commit();
        }
    }

    public final boolean cFU() {
        SharedPreferences cGa = com.tencent.d.b.b.a.cFX().cGa();
        if (cGa == null) {
            return false;
        }
        c.i("Soter.TaskInit", "soter: is triggered OOM: %b", new Object[]{Boolean.valueOf(cGa.getBoolean(i.by(), false))});
        return cGa.getBoolean(i.by(), false);
    }
}
