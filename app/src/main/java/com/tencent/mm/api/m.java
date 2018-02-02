package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;

public abstract class m {
    public static b fdD;
    public a fdC;

    public static class a {
        public int fdE;
        public boolean fdF;
        public boolean fdG;
        public String path;
        public Rect rect;

        public a(String str, int i, boolean z, boolean z2, Rect rect) {
            this.fdE = i;
            this.path = str;
            this.fdF = z;
            this.fdG = z2;
            this.rect = rect;
        }
    }

    public abstract void a(j jVar);

    public abstract b ai(Context context);

    public abstract void onDestroy();

    public abstract boolean sS();

    public abstract k sT();

    public void a(a aVar) {
        this.fdC = aVar;
    }
}
