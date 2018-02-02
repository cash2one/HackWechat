package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<nn> {
    public m() {
        this.xen = nn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        nn nnVar = (nn) bVar;
        if (nnVar == null) {
            x.e("MicroMsg.FaceStartManageListener", "hy: event is null");
            return false;
        }
        Context context = nnVar.fFE.context;
        nn.b bVar2 = nnVar.fFF;
        f fVar = f.mgf;
        x.i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            x.e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
        } else if (fVar.eT(true)) {
            context.startActivity(new Intent(context, SettingsFacePrintManagerUI.class));
            z = true;
        } else {
            x.w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
        }
        bVar2.fFD = z;
        return true;
    }
}
