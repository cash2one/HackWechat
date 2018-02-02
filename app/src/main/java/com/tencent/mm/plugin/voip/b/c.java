package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public int mState;
    public Map<Integer, Map<Integer, Integer>> ssF;

    public c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void Z(int i, int i2, int i3) {
        Map map;
        if (this.ssF == null) {
            this.ssF = new HashMap();
        }
        if (this.ssF.containsKey(Integer.valueOf(i))) {
            map = (Map) this.ssF.get(Integer.valueOf(i));
        } else {
            map = new HashMap();
            this.ssF.put(Integer.valueOf(i), map);
        }
        map.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final boolean yV(int i) {
        if (this.ssF == null || !this.ssF.containsKey(Integer.valueOf(this.mState))) {
            x.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[]{b.yP(this.mState)});
            return false;
        } else if (((Map) this.ssF.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            return true;
        } else {
            x.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[]{b.yP(this.mState), b.yP(i)});
            return false;
        }
    }
}
