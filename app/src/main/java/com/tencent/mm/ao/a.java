package com.tencent.mm.ao;

import android.os.HandlerThread;
import com.tencent.mm.by.h.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public class a implements ap {
    private static HandlerThread hyP = null;
    private static af hyQ = null;

    public static boolean b(Runnable runnable, long j) {
        boolean z = false;
        if (runnable == null) {
            return false;
        }
        if (hyQ == null || hyP == null) {
            String str = "MicroMsg.GIF.SubCoreGIF";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(hyQ != null);
            if (hyP != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bh.cgy();
            x.w(str, str2, objArr);
            if (hyQ != null) {
                hyQ.removeCallbacksAndMessages(null);
            }
            if (hyP != null) {
                hyP.quit();
            }
            HandlerThread Wf = e.Wf("GIF-Decoder");
            hyP = Wf;
            Wf.start();
            hyQ = new af(hyP.getLooper());
        }
        if (j > 0) {
            hyQ.postDelayed(runnable, j);
        } else {
            hyQ.post(runnable);
        }
        return true;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        if (hyQ != null) {
            hyQ.removeCallbacksAndMessages(null);
        }
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        if (hyQ != null) {
            hyQ.removeCallbacksAndMessages(null);
        }
    }
}
