package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.l;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.h.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import junit.framework.Assert;

public final class p implements e {
    private Context context;
    private ProgressDialog kVi;
    private String path;
    private Runnable vdB = null;
    private Runnable vdC = null;

    public p(Context context, String str) {
        this.context = context;
        this.path = str;
        this.kVi = null;
        ar.CG().a(157, this);
    }

    public final boolean c(int i, Runnable runnable) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.vdB = runnable;
        Context context = this.context;
        this.context.getString(R.l.dGO);
        this.kVi = h.a(context, this.context.getString(R.l.eNO), true, null);
        ar.CG().a(new l(i, this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        return true;
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.vdB = runnable;
        this.vdC = runnable2;
        ar.CG().a(new l(1, this.path), 0);
        x.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[]{Boolean.valueOf(false)});
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        ar.CG().b(157, this);
        if (this.kVi != null && this.kVi.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.kVi.dismiss();
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e.getMessage());
            }
        }
        if (i == 0 && i2 == 0) {
            Toast.makeText(this.context, R.l.eNN, 0).show();
            if (this.vdB != null) {
                new af(Looper.getMainLooper()).post(this.vdB);
                return;
            }
            return;
        }
        if (this.vdC != null) {
            new af(Looper.getMainLooper()).post(this.vdC);
        }
        if (str != null && str.length() > 0) {
            a eA = a.eA(str);
            if (eA != null) {
                eA.a(this.context, null, null);
                return;
            }
        }
        if (i == 4 && i2 == -4) {
            Toast.makeText(this.context, R.l.dVM, 0).show();
        } else {
            Toast.makeText(this.context, R.l.eNM, 0).show();
        }
    }
}
