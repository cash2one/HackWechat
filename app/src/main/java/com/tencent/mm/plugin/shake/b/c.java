package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.shake.c.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.List;

public final class c extends l$b implements e {
    private Context context;
    float gyA = -1000.0f;
    private a$a gyF = new a$a(this) {
        final /* synthetic */ c qnJ;

        {
            this.qnJ = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            com.tencent.mm.modelstat.e.SS().a(2002, i != 0, this.qnJ.hpO == null ? false : this.qnJ.hpO.hxP, f, f2, (int) d2);
            x.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + this.qnJ.pYB, new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            if (!z) {
                return true;
            }
            if (this.qnJ.qnD && this.qnJ.gyz == -85.0f && this.qnJ.gyA == -1000.0f) {
                this.qnJ.qnD = false;
                this.qnJ.gyz = f2;
                this.qnJ.gyA = f;
                this.qnJ.pYy = (int) d2;
                this.qnJ.pYx = i;
                this.qnJ.pYB = true;
            }
            return false;
        }
    };
    float gyz = -85.0f;
    com.tencent.mm.modelgeo.c hpO;
    boolean pYB = false;
    int pYx = 1;
    int pYy = DownloadResult.CODE_UNDEFINED;
    boolean qnD = true;
    b qnE;
    a qnF;
    private int qnG = 0;
    af qnH = new af();
    Runnable qnI = new 1(this);

    public c(Context context, l$a com_tencent_mm_plugin_shake_b_l_a) {
        super(com_tencent_mm_plugin_shake_b_l_a);
        this.context = context;
    }

    public final void init() {
        ar.CG().a(JsApiOperateBackgroundAudio.CTRL_INDEX, this);
        ar.CG().a(162, this);
        ar.CG().a(1251, this);
        bro();
    }

    public final void start() {
        reset();
        init();
        this.qnE = new b(this.gyA, this.gyz, this.pYy, this.pYx, "", "");
        ar.CG().a(this.qnE, 0);
        if (!this.pYB) {
            if (this.hpO == null) {
                bro();
            }
            this.hpO.b(this.gyF, true);
        }
        if (this.qnG <= 0) {
            this.qnG++;
        } else if (this.qnG <= 0 || this.qnG > 10) {
            this.qnG = 0;
        } else {
            this.qnG++;
            return;
        }
        x.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        ar.CG().a(new b(this.gyA, this.gyz), 0);
    }

    private void bro() {
        this.hpO = com.tencent.mm.modelgeo.c.OP();
        this.qnD = true;
        this.hpO.a(this.gyF, true);
    }

    public final void reset() {
        if (this.qnE != null) {
            ar.CG().c(this.qnE);
        }
        if (this.qnF != null) {
            ar.CG().c(this.qnF);
        }
        if (this.qnH != null && this.qnI != null) {
            this.qnH.removeCallbacks(this.qnI);
        }
    }

    public final void pause() {
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
    }

    public final void resume() {
        if (this.hpO != null) {
            this.hpO.a(this.gyF, true);
        }
    }

    public final void brp() {
        super.brp();
        ar.CG().b(JsApiOperateBackgroundAudio.CTRL_INDEX, this);
        ar.CG().b(162, this);
        ar.CG().b(1251, this);
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case JsApiOperateBackgroundAudio.CTRL_INDEX /*161*/:
                b bVar = (b) kVar;
                if (bVar.brn() == 3 || bVar.brn() == 4) {
                    x.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    return;
                } else if (i2 == 0 && i == 0 && bVar.ret == 0) {
                    this.qnH.postDelayed(this.qnI, 3000);
                    return;
                } else {
                    x.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.qnR.d(null, 3);
                    return;
                }
            case 162:
                a aVar = (a) kVar;
                if (i2 == 0 && i == 0 && aVar.ret == 0) {
                    List list = aVar.qnB;
                    if (list.size() == 0) {
                        x.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.qnR.d(null, 3);
                        return;
                    }
                    this.qnR.d(list, 1);
                    return;
                }
                this.qnR.d(null, 3);
                return;
            case 1251:
                b bVar2 = (b) kVar;
                if (i2 == 0 && i == 0) {
                    if (this.qnR != null) {
                        this.qnR.a(1251, bVar2.qok, 1);
                        return;
                    }
                    return;
                } else if (this.qnR != null) {
                    this.qnR.a(1251, null, 2);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
