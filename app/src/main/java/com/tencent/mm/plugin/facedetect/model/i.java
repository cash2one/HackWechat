package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends c<nm> {
    public i() {
        this.xen = nm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nm nmVar = (nm) bVar;
        if (nmVar == null) {
            return false;
        }
        boolean z;
        nm.b bVar2 = nmVar.fFB;
        f fVar = f.mgf;
        Context context = nmVar.fFA.context;
        Bundle bundle = nmVar.fFA.extras;
        int i = nmVar.fFA.fFC;
        x.i("MicroMsg.FaceDetectManager", "start face detect process");
        FaceDetectReporter.aGK().aGL();
        FaceDetectReporter aGK = FaceDetectReporter.aGK();
        x.v("MicroMsg.FaceDetectReporter", "create interface called session");
        aGK.mgS = System.currentTimeMillis();
        aGK.mgV = 0;
        aGK.mgW = false;
        aGK.mgT = -1;
        aGK.mgU = -1;
        long j = aGK.mgS;
        FaceDetectReporter.aGK().mgT = System.currentTimeMillis();
        if (context == null) {
            z = false;
        } else if (bundle != null) {
            int i2 = bundle.getInt("k_server_scene", 2);
            FaceDetectReporter.aGK().appId = bundle.getString("k_app_id", "");
            if (fVar.eT(bundle.getBoolean("is_check_dyncfg", false))) {
                Intent intent = (i2 == 2 || i2 == 5) ? new Intent(context, FaceDetectConfirmUI.class) : new Intent(context, FaceDetectPrepareUI.class);
                intent.putExtras(bundle);
                ((Activity) context).startActivityForResult(intent, i);
                z = true;
            } else {
                x.w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                FaceDetectReporter aGK2 = FaceDetectReporter.aGK();
                aGK2.C(FaceDetectReporter.pu(i2), false);
                aGK2.a(FaceDetectReporter.pu(i2), false, 3, 4, 90001);
                z = false;
            }
        } else {
            x.e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
            z = false;
        }
        bVar2.fFD = z;
        if (!nmVar.fFB.fFD) {
            nmVar.fFB.extras = new Bundle();
            nmVar.fFB.extras.putInt("err_code", 90001);
            nmVar.fFB.extras.putString("err_msg", "face detect not support");
        }
        return true;
    }
}
