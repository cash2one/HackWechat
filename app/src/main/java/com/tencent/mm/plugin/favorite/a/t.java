package com.tencent.mm.plugin.favorite.a;

import android.os.Bundle;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.plugin.favorite.a.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class t implements a {
    public static i mqV = null;
    private static t mqW = null;
    public int duration;
    public int fvx;
    public String path;

    public static t aIX() {
        if (mqW == null) {
            mqW = new t();
        }
        return mqW;
    }

    public static i aIY() {
        if (mqV == null) {
            mqV = new i();
        }
        return mqV;
    }

    public static i aIZ() {
        return mqV;
    }

    public final void bj(String str, int i) {
        x.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (bh.az(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        b kpVar = new kp();
        kpVar.fBX.fBR = bundle;
        kpVar.fBX.type = 4;
        com.tencent.mm.sdk.b.a.xef.m(kpVar);
    }

    public final void onFinish() {
        mqV.stopPlay();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        b kpVar = new kp();
        kpVar.fBX.fBR = bundle;
        kpVar.fBX.type = 4;
        com.tencent.mm.sdk.b.a.xef.m(kpVar);
    }

    public final void onPause() {
        mqV.aIC();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        b kpVar = new kp();
        kpVar.fBX.fBR = bundle;
        kpVar.fBX.type = 4;
        com.tencent.mm.sdk.b.a.xef.m(kpVar);
    }
}
