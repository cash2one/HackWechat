package com.tencent.mm.plugin.soter_mp.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.b.c.a;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.soter_mp.b.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import java.lang.ref.WeakReference;

public final class b extends c implements e {
    TextView jCB = null;
    a mzB = null;
    boolean rSW = false;
    private i rSX = null;
    ImageView rSY = null;
    private final int rSZ = 3;
    private int rTa = 0;
    private final long rTb = 500;
    Animation rTc = null;
    Animation rTd = null;
    Runnable rTe = new 8(this);

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.rSX == null || !bVar.rSX.isShowing()) {
            if (bVar.rTl == null || bVar.rTl.get() == null) {
                x.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                bVar.rTk.errCode = 90007;
                bVar.rTk.fnL = "internal error occurred: ui released";
                bVar.bDa();
            } else {
                if (bVar.rSX == null) {
                    Activity activity = (Activity) bVar.rTl.get();
                    i.a aVar = new i.a(activity);
                    View inflate = activity.getLayoutInflater().inflate(R.i.dil, null, false);
                    bVar.rSY = (ImageView) inflate.findViewById(R.h.cib);
                    bVar.jCB = (TextView) inflate.findViewById(R.h.cic);
                    ((TextView) inflate.findViewById(R.h.cia)).setText(bVar.rTj.content);
                    aVar.dk(inflate);
                    aVar.mi(true);
                    aVar.ED(R.l.dEn).b(new 5(bVar));
                    aVar.d(new OnCancelListener(bVar) {
                        final /* synthetic */ b rTf;

                        {
                            this.rTf = r1;
                        }

                        @TargetApi(16)
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                            this.rTf.bCZ();
                        }
                    });
                    bVar.rSX = aVar.akx();
                    a(bVar.rSX);
                    bVar.rSX.setCanceledOnTouchOutside(false);
                }
                if (!bVar.rSX.isShowing()) {
                    bVar.rSX.show();
                }
            }
        }
        if (z) {
            if (!(VERSION.SDK_INT < 23)) {
                x.i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                return;
            }
        }
        if (bVar.mzB != null) {
            x.e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            bVar.mzB.nV(true);
            ag.h(new 2(bVar), 500);
            return;
        }
        bVar.bCW();
    }

    public b(WeakReference<Activity> weakReference, d dVar, com.tencent.mm.plugin.soter_mp.b.e eVar) {
        super(weakReference, dVar, eVar);
    }

    @TargetApi(23)
    public final void cR() {
        if (!com.tencent.d.a.a.id(ac.getContext())) {
            this.rTk.errCode = 90011;
            this.rTk.fnL = "no fingerprint enrolled";
            bDa();
        }
        try {
            if (ac.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                String[] strArr = new String[]{"android.permission.USE_FINGERPRINT"};
                if (SoterAuthenticationUI.rTq != null) {
                    Message obtainMessage = SoterAuthenticationUI.rTq.obtainMessage(3);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("permissions", strArr);
                    bundle.putInt("request_code", 0);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    return;
                }
                x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
                return;
            }
            this.rSW = true;
        } catch (NoSuchMethodError e) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.rSW = true;
        }
    }

    private boolean bCV() {
        if (SoterAuthenticationUI.rTq != null) {
            SoterAuthenticationUI.rTq.obtainMessage(4).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
        x.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        com.tencent.d.b.a.a(new 1(this), false, 2, new c(), new com.tencent.mm.plugin.soter.b.e());
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 0) {
            return;
        }
        if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
            x.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
            this.rTk.errCode = 90002;
            this.rTk.fnL = "user not grant to use fingerprint";
            bDa();
            return;
        }
        x.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        bCV();
        this.rSW = true;
    }

    private void bCW() {
        this.mzB = new a();
        com.tencent.d.b.a.b 3 = new 3(this);
        com.tencent.d.b.c.b 4 = new 4(this);
        com.tencent.d.b.f.b.a abA = new com.tencent.d.b.f.b.a().Ib(2).io(ac.getContext()).a(this.mzB).abA(this.rTj.mzI);
        abA.AcZ.AcX = null;
        com.tencent.d.b.a.a(3, abA.a(4).AcZ);
    }

    public final void onResume() {
        if (this.rSW) {
            bCV();
        }
    }

    @TargetApi(16)
    public final void onPause() {
        if (this.rSW && this.mzB != null) {
            this.mzB.nV(true);
        }
        if (this.rSX != null && this.rSX.isShowing()) {
            this.rSX.dismiss();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }
}
