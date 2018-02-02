package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.facedetect.a$d;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    boolean liZ;
    private String mfG;
    private String mfH;
    private int mfI;

    c(Context context, e eVar, int i) {
        super(context, eVar, i);
        this.liZ = false;
        this.mfD = true;
        this.mfI = i;
    }

    private String getResultKey() {
        switch (this.mfI) {
            case 0:
            case 3:
                return "faceregister_ticket";
            case 1:
            case 4:
                return "faceverify_ticket";
            default:
                return "verify_result";
        }
    }

    public final k aGo() {
        long aGm = aGm();
        String str = this.mfG;
        String str2 = this.mfH;
        switch (this.mfI) {
            case 0:
                return new n(aGm, str, str2);
            case 1:
                return new s(aGm, str, str2);
            case 3:
                return new o(aGm, str, str2);
            case 4:
                return new t(aGm, str, str2);
            default:
                return null;
        }
    }

    public final void onStart() {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
        if (this.liZ) {
            FaceDetectReporter.aGK().aGL();
            FaceDetectReporter.aGK().C(FaceDetectReporter.pu(this.mfI), this.liZ);
        }
    }

    public final void onRelease() {
        if (!FaceDetectReporter.aGK().mgP) {
            FaceDetectReporter.aGK().a(FaceDetectReporter.pu(this.mfI), this.liZ, 2, 1, 90006);
        }
    }

    public final void h(int i, int i2, String str) {
        x.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    public final boolean e(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            FaceDetectReporter.aGK().a(FaceDetectReporter.pu(this.mfI), this.liZ, 1, 2, 90012);
            a(i, i2, str, false, null);
            return true;
        } else if (bundle == null || bh.ov(bundle.getString("key_pic_cdn_id"))) {
            x.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.mfG = bundle.getString("key_pic_cdn_id");
            this.mfH = bundle.getString("key_cdn_aes_key");
            x.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", this.mfG, this.mfH);
            return false;
        }
    }

    public final void h(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof e) {
            e eVar = (e) kVar;
            Bundle bundle = new Bundle();
            bundle.putString(getResultKey(), eVar.aGi());
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.aGK().a(this.mfA, eVar.aGh(), 0, i, i2, this.mfC != null ? this.mfC.meT : 0);
                b pA = a.pA(a$d.mcQ);
                pA.mjc = true;
                pA.mjk = ac.getResources().getString(a$h.men);
                a(false, true, pA);
                ag.h(new 1(this, i, i2, str, bundle), 1500);
                return;
            }
            int i3;
            FaceDetectReporter aGK = FaceDetectReporter.aGK();
            int i4 = this.mfA;
            boolean aGh = eVar.aGh();
            if (this.mfC != null) {
                i3 = this.mfC.meT;
            } else {
                i3 = 0;
            }
            aGK.a(i4, aGh, 1, i, i2, i3);
            a(i, i2, str, eVar.aGh(), bundle);
        }
    }

    public final void f(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.aGK().mgP) {
            FaceDetectReporter.aGK().a(FaceDetectReporter.pu(this.mfI), this.liZ, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(getResultKey(), bundle.getString(getResultKey()));
            b(i, i2, str, bundle2);
            return;
        }
        b(i, i2, str, null);
    }

    public final void Z(int i, String str) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.aGK().mgP) {
            FaceDetectReporter.aGK().a(FaceDetectReporter.pu(this.mfI), this.liZ, 2, 1, i);
        }
        b(1, i, str, null);
    }

    public final Bundle aGp() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", aGm());
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        c(i, i2, str, bundle);
        Context context = ac.getContext();
        if (str == null) {
            string = context.getString(a$h.mdO);
        } else {
            string = str;
        }
        a(true, false, a.a(a$d.mcD, string, z ? context.getString(a$h.mem) : context.getString(a$h.mel), null, z ? context.getString(a$h.dEn) : null, new 2(this, z, i, i2, str, bundle), new 3(this, i, i2, str, bundle)));
    }
}
