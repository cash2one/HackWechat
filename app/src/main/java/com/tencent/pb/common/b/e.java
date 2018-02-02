package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.pb.common.c.c;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class e implements b {
    private static e zMk = null;
    private final Handler handler = new 1(this, Looper.getMainLooper());
    private Vector<d> hmX = new Vector();
    private Vector<d> hmY = new Vector();
    private final SparseArray<Set<b>> zMl = new SparseArray();
    private d zMm = null;

    private e() {
    }

    public static e cCE() {
        if (zMk == null) {
            synchronized (e.class) {
                if (zMk == null) {
                    zMk = new e();
                }
            }
        }
        return zMk;
    }

    public final void a(int i, b bVar) {
        if (this.zMl.get(i) == null) {
            this.zMl.put(i, new HashSet());
        }
        if (!((Set) this.zMl.get(i)).contains(bVar)) {
            ((Set) this.zMl.get(i)).add(bVar);
        }
    }

    public final boolean a(d dVar) {
        if (!h.isNetworkConnected()) {
            int type = dVar.getType();
            if (type == 102 || type == 104 || type == 103) {
                c.m("MicroMsg.Voip", "doScene do retain mReissueNetScene");
                this.zMm = dVar;
            }
        }
        Assert.assertTrue(true);
        if (dVar == null) {
            return false;
        }
        a(dVar, 0);
        return true;
    }

    private void a(d dVar, int i) {
        if (cCF()) {
            int i2;
            this.hmX.add(dVar);
            if (dVar.zMd == null) {
                c.m("MicroMsg.Voip", dVar.TAG2, "dosene reqData is null cmd=" + dVar.zMf);
                i2 = -1;
            } else {
                dVar.zMc = this;
                i2 = f.cCH().a(null, new i(dVar), dVar.zMf, dVar.cCD(), dVar.zMd, dVar.zMg);
                if (i2 >= 0) {
                    dVar.mHandler.postDelayed(dVar.hnt, 60000);
                }
                c.d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", dVar.cCD(), Integer.valueOf(i2));
            }
            if (i2 < 0) {
                c.m("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(i2));
                this.handler.post(new 2(this, dVar));
            }
        } else {
            this.hmY.add(dVar);
        }
        Kq();
    }

    public final void a(int i, int i2, String str, d dVar) {
        this.hmX.remove(dVar);
        Kq();
        this.handler.post(new 3(this, dVar, i, i2, str));
    }

    private void Kq() {
        if (this.hmY.size() > 0) {
            d dVar = (d) this.hmY.get(0);
            for (int i = 1; i < this.hmY.size(); i++) {
                this.hmY.get(i);
            }
            if (cCF()) {
                this.hmY.remove(dVar);
                a(dVar, 0);
            }
        }
    }

    private boolean cCF() {
        if (this.hmX.size() >= 20) {
            return false;
        }
        return true;
    }
}
