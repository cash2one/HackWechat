package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ac;

public final class a extends LinearLayoutManager {
    private final int tXN = j.c(ac.getContext(), true);
    public int tXO = -1;
    public boolean tXP = false;

    public a(Context context) {
    }

    public final int b(int i, m mVar, q qVar) {
        int i2 = 1;
        int i3 = 0;
        if (!this.tXP) {
            return super.b(i, mVar, qVar);
        }
        int i4 = i < 0 ? k.aq(49.0f) <= ((float) Math.abs(i)) ? 1 : i3 : i3;
        if (i <= 0) {
            i2 = i4;
        } else if (((float) this.tXN) + k.aq(49.0f) >= ((float) i)) {
            i2 = i3;
        }
        if (i2 != 0 && this.tXP) {
            return i3;
        }
        try {
            return super.b(i, mVar, qVar);
        } catch (Exception e) {
            return i3;
        }
    }

    protected final int a(q qVar) {
        if (this.tXO > 0) {
            return this.tXO;
        }
        return 900;
    }

    public final void c(m mVar, q qVar) {
        try {
            super.c(mVar, qVar);
        } catch (Exception e) {
        }
    }
}
