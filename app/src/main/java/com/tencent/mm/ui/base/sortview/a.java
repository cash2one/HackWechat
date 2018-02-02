package com.tencent.mm.ui.base.sortview;

import android.content.Context;

public abstract class a {
    public Object data;
    public int type;
    public boolean yjT;

    public abstract void a(Context context, a aVar, Object... objArr);

    public abstract b asm();

    public abstract a asn();

    public a(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }
}
