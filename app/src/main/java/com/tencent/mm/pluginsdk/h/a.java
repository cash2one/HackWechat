package com.tencent.mm.pluginsdk.h;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a {
    private i vfI;
    private j vfJ;
    private k vfK;
    private g vfL;
    private h vfM;
    private f vfN;

    public final boolean a(Activity activity, o oVar) {
        if (oVar.type == 0 || oVar.action == 0) {
            return false;
        }
        if (this.vfN == null) {
            this.vfN = new f(activity);
        }
        if (this.vfN.a(oVar)) {
            return true;
        }
        switch (oVar.type) {
            case 1:
                if (this.vfI == null) {
                    this.vfI = new i(activity);
                }
                this.vfI.a(oVar);
                return false;
            case 2:
                if (this.vfJ == null) {
                    this.vfJ = new j(activity);
                }
                this.vfJ.a(oVar);
                return false;
            case 3:
                if (this.vfK == null) {
                    this.vfK = new k(activity);
                }
                this.vfK.a(oVar);
                return false;
            case 4:
                if (this.vfL == null) {
                    this.vfL = new g(activity);
                }
                this.vfL.a(oVar);
                return false;
            case 5:
                if (this.vfM == null) {
                    this.vfM = new h(activity);
                }
                this.vfM.a(oVar);
                return false;
            case 6:
                if (this.vfN == null) {
                    this.vfN = new f(activity);
                }
                this.vfN.a(oVar);
                return false;
            default:
                x.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                return false;
        }
    }

    private static void a(b bVar) {
        if (bVar != null) {
            for (Integer intValue : bVar.vfO) {
                ar.CG().b(intValue.intValue(), bVar);
            }
            bVar.activity = null;
        }
    }

    public final void close() {
        a(this.vfI);
        a(this.vfJ);
        a(this.vfK);
        a(this.vfL);
        a(this.vfM);
        a(this.vfN);
    }
}
