package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public enum i implements e {
    ;
    
    private ProgressDialog iln;
    private boolean lMN;
    public a lMO;

    private i(String str) {
        this.lMN = false;
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        if (sharedPreferences.getLong(stringBuilder.append(c.Cg()).toString(), 0) != 0) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[]{Long.valueOf(sharedPreferences.getLong(stringBuilder.append(c.Cg()).toString(), 0))});
            return;
        }
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    }

    public final void a(Context context, a aVar) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.lMN) {
            if (this.lMO == null) {
                this.lMO = aVar;
            }
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            return;
        }
        k oVar = new o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
            }
            context.getString(R.l.dGO);
            this.iln = h.a(context, context.getString(R.l.eHP), new 1(this, oVar, aVar));
        }
        this.lMO = aVar;
        ar.CG().a(oVar, 0);
    }

    public final boolean eI(boolean z) {
        if (this.lMN) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        long j = sharedPreferences.getLong(stringBuilder.append(c.Cg()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            return true;
        }
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        return false;
    }

    public static void ct(long j) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[]{Long.valueOf(j)});
        Editor edit = ac.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        edit.putLong(stringBuilder.append(c.Cg()).toString(), j).commit();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.lMN = false;
        if (kVar != null && i2 == 0 && i == 0) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    o oVar = (o) kVar;
                    zu zuVar = (oVar.gJQ == null || oVar.gJQ.hmh.hmo == null) ? null : (zu) oVar.gJQ.hmh.hmo;
                    if (zuVar == null || zuVar.wjp == null) {
                        if (this.lMO != null) {
                            this.lMO.eH(false);
                        }
                        if (this.iln != null && this.iln.isShowing()) {
                            this.iln.dismiss();
                            return;
                        }
                        return;
                    }
                    ar.Dm().F(new 2(this, zuVar));
                    if (this.lMO != null) {
                        this.lMO.eH(true);
                    }
                } else {
                    x.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                    if (this.lMO != null) {
                        this.lMO.eH(false);
                    }
                    if (this.iln != null && this.iln.isShowing()) {
                        this.iln.dismiss();
                        return;
                    }
                    return;
                }
            }
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
                return;
            }
            return;
        }
        x.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }
}
