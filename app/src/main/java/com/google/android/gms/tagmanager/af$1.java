package com.google.android.gms.tagmanager;

import android.content.SharedPreferences.Editor;

class af$1 implements Runnable {
    final /* synthetic */ Editor bcC;

    af$1(Editor editor) {
        this.bcC = editor;
    }

    public final void run() {
        this.bcC.commit();
    }
}
