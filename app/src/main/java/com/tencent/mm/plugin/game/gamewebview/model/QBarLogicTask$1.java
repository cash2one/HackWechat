package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.game.gamewebview.ipc.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class QBarLogicTask$1 extends c<mr> {
    QBarLogicTask$1() {
        this.xen = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        x.d("MicroMsg.QBarLogicTask", "mRecogResultListener");
        if ((mrVar instanceof mr) && (QBarLogicTask.agr() == null || QBarLogicTask.agr().containsKey(mrVar.fED.filePath))) {
            if (QBarLogicTask.agr() != null) {
                QBarLogicTask.agr().remove(mrVar.fED.filePath);
            }
            x.d("MicroMsg.QBarLogicTask", "result: " + mrVar.fED.result);
            Bundle bundle = new Bundle();
            bundle.putInt("mm_to_client_notify_type", 2);
            bundle.putString("file_path", mrVar.fED.filePath);
            bundle.putString("result", mrVar.fED.result);
            bundle.putInt("code_type", mrVar.fED.fqb);
            bundle.putInt("code_version", mrVar.fED.fqc);
            a.z(bundle);
        }
        return false;
    }
}
