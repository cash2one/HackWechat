package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;

final class j extends c<Object> {
    j(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    public final boolean bR(int i, int i2) {
        if (!this.jKY.get(i).getClass().equals(this.jKZ.get(i2).getClass())) {
            return false;
        }
        if (!(this.jKY.get(i) instanceof i)) {
            return false;
        }
        i iVar = (i) this.jKY.get(i);
        i iVar2 = (i) this.jKZ.get(i2);
        return iVar.iGA == iVar2.iGA && iVar.fnl.equals(iVar2.fnl);
    }

    public final boolean bS(int i, int i2) {
        if (!(this.jKY.get(i) instanceof i)) {
            return false;
        }
        i iVar = (i) this.jKY.get(i);
        i iVar2 = (i) this.jKZ.get(i2);
        if (bh.ou(iVar.appId).equals(iVar2.appId) && iVar.fnl.equals(iVar2.fnl) && iVar.iGA == iVar2.iGA && iVar.iJL == iVar2.iJL && bh.ou(iVar.iJJ).equals(iVar2.iJJ) && bh.ou(iVar.appName).equals(iVar2.appName)) {
            return true;
        }
        return false;
    }

    public final Object bT(int i, int i2) {
        if (i >= this.jKY.size()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.jKY.get(i) instanceof i) {
            i iVar = (i) this.jKY.get(i);
            i iVar2 = (i) this.jKZ.get(i2);
            if (iVar.iJK != iVar2.iJK) {
                bundle.putLong("running_flag", iVar2.iJK);
            }
            if (iVar.iJL != iVar2.iJL) {
                bundle.putBoolean("star", iVar2.iJL);
            }
            if (iVar.iGA != iVar2.iGA) {
                bundle.putInt("debug_type", iVar2.iGA);
            }
            if (!bh.ou(iVar.iJJ).equals(iVar2.iJJ)) {
                bundle.putString("icon", iVar2.iJJ);
            }
            if (!bh.ou(iVar.appName).equals(iVar2.appName)) {
                bundle.putString("nick_name", iVar2.appName);
            }
        }
        return bundle.size() <= 0 ? null : bundle;
    }
}
