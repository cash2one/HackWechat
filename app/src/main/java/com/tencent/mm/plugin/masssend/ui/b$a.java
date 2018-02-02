package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import com.tencent.mm.e.b.h;

class b$a extends h {
    String fileName;
    final /* synthetic */ b onk;

    public b$a(b bVar, Context context) {
        this.onk = bVar;
        super(context, false);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean vo() {
        this.fileName = super.getFileName();
        boolean vo = super.vo();
        super.reset();
        return vo;
    }
}
