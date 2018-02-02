package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a {
    float jek = 0.0f;
    int jtA = -1;
    int jtB = 0;
    Runnable jtC = new 1(this);
    View jtu;
    GestureDetector jtw;
    int jty = 0;
    float jtz = 0.0f;
    Context mContext;
    int tqI = a.tqL;
    b tqJ;

    public a(Context context, View view, b bVar) {
        this.mContext = context;
        this.tqJ = bVar;
        this.jtu = view;
        this.jtw = new GestureDetector(this.mContext, new 2(this));
        this.jek = c.bW(context);
    }
}
