package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.w.a.k;

public final class j {

    public interface a {
        void ch(boolean z);
    }

    static /* synthetic */ void a(Context context, final i iVar, String str, String str2, boolean z, final a aVar, a aVar2) {
        if (bh.ov(str) || str.length() == 0) {
            str = context.getResources().getString(k.dFU);
        }
        if (bh.ov(str2) || str2.length() == 0) {
            str2 = context.getResources().getString(k.dEn);
        }
        iVar.a(str, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar != null) {
                    a aVar = aVar;
                    iVar.coS();
                    aVar.ch(true);
                }
            }
        });
        if (!z) {
            iVar.b(str2, true, new 2(aVar2));
        }
    }
}
