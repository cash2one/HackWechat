package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.h.1;

class h$1$1 implements Runnable {
    final /* synthetic */ Object qTB;
    final /* synthetic */ 1 qTC;

    h$1$1(1 1, Object obj) {
        this.qTC = 1;
        this.qTB = obj;
    }

    public final void run() {
        this.qTC.qTA.onPostExecute(this.qTB);
    }
}
