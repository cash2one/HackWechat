package com.google.android.gms.analytics.internal;

import android.util.DisplayMetrics;
import com.google.android.gms.c.al;
import java.util.Locale;

public final class af extends o {
    af(q qVar) {
        super(qVar);
    }

    protected final void mf() {
    }

    public final al nH() {
        mQ();
        DisplayMetrics displayMetrics = this.aFo.mT().mContext.getResources().getDisplayMetrics();
        al alVar = new al();
        alVar.aYF = k.c(Locale.getDefault());
        alVar.aYH = displayMetrics.widthPixels;
        alVar.aYI = displayMetrics.heightPixels;
        return alVar;
    }
}
