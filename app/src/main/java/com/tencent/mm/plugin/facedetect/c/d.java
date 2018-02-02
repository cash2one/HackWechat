package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    String appId;
    private String fBZ;
    boolean liZ;
    private String mfG;
    private String mfH;
    String mfN;

    d(Context context, e eVar, int i, Bundle bundle) {
        super(context, eVar, i);
        this.liZ = false;
        this.mfD = true;
        this.appId = bundle.getString("k_app_id", null);
        this.fBZ = bundle.getString("request_verify_pre_info", null);
        this.mfN = bundle.getString("key_feedback_url", null);
    }

    public final k aGo() {
        return new m(aGm(), this.appId, this.fBZ, this.mfG, this.mfH);
    }

    public final void onStart() {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
        if (this.liZ) {
            FaceDetectReporter.aGK().aGL();
        }
        FaceDetectReporter.aGK().C(this.mfA, this.liZ);
        FaceDetectReporter aGK = FaceDetectReporter.aGK();
        aGK.mgV++;
        x.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[]{Integer.valueOf(aGK.mgV)});
    }

    public final void onRelease() {
        if (!FaceDetectReporter.aGK().mgP) {
            FaceDetectReporter.aGK().a(this.mfA, this.liZ, 2, 1, 90006);
        }
    }

    public final void h(int i, int i2, String str) {
        x.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public final boolean e(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            FaceDetectReporter.aGK().a(this.mfA, this.liZ, 1, 2, 90012);
            a(i, i2, str, false, null);
            return true;
        } else if (bundle == null || bh.ov(bundle.getString("key_pic_cdn_id"))) {
            x.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.mfG = bundle.getString("key_pic_cdn_id");
            this.mfH = bundle.getString("key_cdn_aes_key");
            x.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[]{this.mfG, this.mfH});
            return false;
        }
    }

    public final void h(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof m) {
            Bundle bundle = new Bundle();
            bundle.putString("verify_result", ((m) kVar).mfm);
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.aGK().a(this.mfA, this.liZ, 0, i, i2, this.mfC != null ? this.mfC.meT : 0);
                FaceDetectReporter.aGK().mgW = true;
                b pA = a.pA(com.tencent.mm.plugin.facedetect.a.d.mcQ);
                pA.mjc = true;
                pA.mjk = ac.getResources().getString(h.men);
                a(false, true, pA);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                ag.h(new Runnable(this) {
                    final /* synthetic */ d mfO;

                    public final void run() {
                        this.mfO.b(i3, i4, str2, bundle2);
                    }
                }, 1500);
                return;
            }
            int i5;
            FaceDetectReporter aGK = FaceDetectReporter.aGK();
            int i6 = this.mfA;
            boolean z = this.liZ;
            if (this.mfC != null) {
                i5 = this.mfC.meT;
            } else {
                i5 = 0;
            }
            aGK.a(i6, z, 1, i, i2, i5);
            a(i, i2, str, ((m) kVar).mfn, bundle);
        }
    }

    public final void f(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!FaceDetectReporter.aGK().mgP) {
            FaceDetectReporter.aGK().a(this.mfA, this.liZ, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("verify_result", bundle.getString("verify_result"));
            b(i, i2, str, bundle2);
            return;
        }
        b(i, i2, str, null);
    }

    public final void Z(int i, String str) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (!FaceDetectReporter.aGK().mgP) {
            FaceDetectReporter.aGK().a(this.mfA, this.liZ, 2, 1, i);
        }
        b(1, i, str, null);
    }

    public final Bundle aGp() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", aGm());
        bundle.putString("key_app_id", this.appId);
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        c(i, i2, str, bundle);
        Context context = ac.getContext();
        if (str == null) {
            string = context.getString(h.mdO);
        } else {
            string = str;
        }
        b a = a.a(com.tencent.mm.plugin.facedetect.a.d.mcD, string, z ? context.getString(h.mem) : context.getString(h.mel), null, z ? context.getString(h.dEn) : null, new 2(this, z, i, i2, str, bundle), new 3(this, i, i2, str, bundle));
        a.a(a, context.getString(h.mdS), new 4(this, bundle, i2, context));
        a(true, false, a);
    }
}
