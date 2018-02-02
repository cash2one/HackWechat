package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v4.app.p;
import java.security.InvalidParameterException;

class b$b extends p {
    final /* synthetic */ b mkI;

    public b$b(b bVar, m mVar) {
        this.mkI = bVar;
        super(mVar);
    }

    public final Fragment R(int i) {
        switch (i) {
            case 0:
                return new b$c(this.mkI);
            default:
                throw new InvalidParameterException("hy: invalid page status");
        }
    }

    public final int getCount() {
        return 1;
    }
}
