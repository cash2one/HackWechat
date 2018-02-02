package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ah;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.q;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean mIsRunning = false;
    private static byte[] xGK = new byte[0];

    protected void onCreate(Bundle bundle) {
        boolean z;
        x.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[]{Boolean.valueOf(mIsRunning)});
        super.onCreate(bundle);
        setContentView(R.i.daM);
        synchronized (xGK) {
            if (mIsRunning) {
                x.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                finish();
            }
        }
        String stringExtra = getIntent().getStringExtra("key_user");
        int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(q.FS())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        x.i(str, str2, objArr);
        if (stringExtra == null) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[]{Integer.valueOf(intExtra)});
            finish();
        } else {
            getString(R.l.dGO);
            final ProgressDialog a = h.a(this, getString(R.l.eYF), false, null);
            ar.CG().a(new bd(new 1(this, stringExtra, intExtra)), 0);
            final OnDismissListener anonymousClass2 = new OnDismissListener(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI xGL;

                {
                    this.xGL = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    if (!this.xGL.isFinishing()) {
                        this.xGL.finish();
                    }
                }
            };
            ar.a(new ah(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI xGL;

                public final void fW(int i) {
                    i h;
                    if (i < 0) {
                        x.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[]{Integer.valueOf(i)});
                        ar.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        h = h.h(this.xGL, R.l.eSf, R.l.dGO);
                        if (h != null) {
                            h.setOnDismissListener(anonymousClass2);
                        }
                        synchronized (JSAPIUploadLogHelperUI.xGK) {
                            JSAPIUploadLogHelperUI.mIsRunning = false;
                        }
                    } else if (i >= 100) {
                        x.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        ar.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        h = h.h(this.xGL, R.l.eSj, R.l.dGO);
                        if (h != null) {
                            h.setOnDismissListener(anonymousClass2);
                        }
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        g.pQN.h(12975, new Object[]{Long.valueOf(currentTimeMillis)});
                        synchronized (JSAPIUploadLogHelperUI.xGK) {
                            JSAPIUploadLogHelperUI.mIsRunning = false;
                        }
                    } else {
                        x.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[]{Integer.valueOf(i)});
                        if (a != null) {
                            a.setMessage(this.xGL.getString(R.l.eSg) + i + "%");
                        }
                    }
                }
            });
        }
    }

    protected void onDestroy() {
        x.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[]{Boolean.valueOf(mIsRunning)});
        super.onDestroy();
    }
}
