package com.google.android.gms.tagmanager;

import java.util.List;

class ap$1 implements Runnable {
    final /* synthetic */ List bdb;
    final /* synthetic */ long bdc;
    final /* synthetic */ ap bdd;

    ap$1(ap apVar, List list, long j) {
        this.bdd = apVar;
        this.bdb = list;
        this.bdc = j;
    }

    public final void run() {
        ap.a(this.bdd, this.bdb, this.bdc);
    }
}
