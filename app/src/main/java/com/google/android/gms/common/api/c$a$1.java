package com.google.android.gms.common.api;

import com.google.android.gms.common.api.c.a;

class c$a$1 implements Runnable {
    final /* synthetic */ c aKl;
    final /* synthetic */ a aKm;

    public c$a$1(a aVar, c cVar) {
        this.aKm = aVar;
        this.aKl = cVar;
    }

    public final void run() {
        if (!this.aKm.aKb.isFinishing() && !this.aKm.aKb.getSupportFragmentManager().isDestroyed()) {
            this.aKm.a(u.b(this.aKm.aKb), this.aKl);
        }
    }
}
