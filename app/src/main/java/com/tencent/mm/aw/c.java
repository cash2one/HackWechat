package com.tencent.mm.aw;

import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;

public final class c {
    public static boolean a(ay ayVar) {
        if (ayVar == null) {
            x.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
            return false;
        }
        boolean z;
        long Wo = bh.Wo();
        if (ayVar.field_overdueTime == 0 && ayVar.field_disappearTime == 0) {
            z = true;
        } else {
            z = Wo >= ayVar.field_beginShowTime && Wo <= Long.valueOf(Math.min(ayVar.field_beginShowTime + ayVar.field_overdueTime, ayVar.field_disappearTime)).longValue();
        }
        x.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", new Object[]{Long.valueOf(Wo), Long.valueOf(ayVar.field_overdueTime), Long.valueOf(ayVar.field_disappearTime), Boolean.valueOf(z)});
        return z;
    }

    protected static boolean b(ay ayVar) {
        if (ayVar == null) {
            x.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
            return false;
        } else if (ayVar.field_isExit && !ayVar.field_hadRead && a(ayVar)) {
            return true;
        } else {
            x.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", new Object[]{Boolean.valueOf(ayVar.field_isExit), Boolean.valueOf(ayVar.field_hadRead), Boolean.valueOf(a(ayVar))});
            return false;
        }
    }

    public final boolean ig(int i) {
        ay Dr = a.bfn().Dr(i);
        if (Dr == null) {
            x.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
            return false;
        } else if (b(a.bfn().Dr(i)) && Dr.field_tipsShowInfo != null && Dr.field_tipsShowInfo.showType == b.hIl) {
            return true;
        } else {
            return false;
        }
    }
}
