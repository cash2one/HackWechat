package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import java.util.LinkedList;

public final class a {
    af handler = new af(Looper.getMainLooper());
    public LinkedList<a> kpH = new LinkedList();

    public final boolean e(int i, Object obj) {
        this.handler.post(new 1(this, i, obj));
        return true;
    }
}
