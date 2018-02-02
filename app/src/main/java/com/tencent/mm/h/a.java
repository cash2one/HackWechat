package com.tencent.mm.h;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public String desc;
    public String fon;
    private c gAY;
    public int showType;
    public String url;

    public static a eA(String str) {
        c eC = c.eC(str);
        if (eC == null) {
            return null;
        }
        a aVar = new a();
        aVar.gAY = eC;
        aVar.url = eC.url;
        aVar.desc = eC.desc;
        aVar.showType = eC.showType;
        aVar.fon = eC.fon;
        return aVar;
    }

    public final boolean a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (this.showType == 3 || this.showType == 4) {
            String str = this.gAY.gBk;
            String str2 = this.gAY.gBl;
            if (bh.ov(str) && bh.ov(str2)) {
                str = context.getString(this.showType == 3 ? h.dHd : h.dFU);
                str2 = context.getString(this.showType == 3 ? h.dFR : h.dEn);
            }
            if (bh.ov(str) || bh.ov(str2)) {
                String str3 = this.desc;
                String str4 = this.fon;
                if (!bh.ov(str)) {
                    str2 = str;
                }
                if (!bh.ov(str)) {
                    onClickListener2 = onClickListener;
                }
                com.tencent.mm.ui.base.h.a(context, str3, str4, str2, onClickListener2);
            } else {
                com.tencent.mm.ui.base.h.a(context, this.desc, this.fon, str, str2, onClickListener, onClickListener2);
            }
            return true;
        } else if (this.showType == 1) {
            com.tencent.mm.ui.base.h.b(context, this.desc, this.fon, true);
            return true;
        } else if (this.showType != 5) {
            return false;
        } else {
            com.tencent.mm.ui.base.h.b(context, this.desc, this.fon, true);
            return true;
        }
    }
}
