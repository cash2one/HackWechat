package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;
import com.tencent.mm.plugin.appbrand.widget.c.c;
import com.tencent.mm.plugin.appbrand.widget.c.c$a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

class JsApiOperateWXData$OperateWXDataTask$2 implements Runnable {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ OperateWXDataTask jgl;

    JsApiOperateWXData$OperateWXDataTask$2(OperateWXDataTask operateWXDataTask, LinkedList linkedList) {
        this.jgl = operateWXDataTask;
        this.iVD = linkedList;
    }

    public final void run() {
        this.jgl.jcM.irP.a(new c(this.jgl.jfT.a(this.jgl.jcM), this.iVD, this.jgl.mAppName, this.jgl.iVz, new c$a(this) {
            final /* synthetic */ JsApiOperateWXData$OperateWXDataTask$2 jgm;

            {
                this.jgm = r1;
            }

            public final void d(int i, Bundle bundle) {
                x.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                switch (i) {
                    case 1:
                    case 2:
                        this.jgm.jgl.jfW = "operateWXDataConfirm";
                        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                        if (arrayList == null || arrayList.size() <= 0) {
                            this.jgm.jgl.jgk = "";
                        } else {
                            this.jgm.jgl.jgk = (String) arrayList.get(0);
                        }
                        this.jgm.jgl.jfY = i;
                        AppBrandMainProcessService.a(this.jgm.jgl);
                        if (i == 2) {
                            this.jgm.jgl.jfT.a(this.jgm.jgl.jcM, this.jgm.jgl.jcN, "fail auth deny");
                            this.jgm.jgl.jfU.afC();
                            return;
                        }
                        return;
                    default:
                        x.d("MicroMsg.JsApiOperateWXData", "press back button!");
                        this.jgm.jgl.jfT.a(this.jgm.jgl.jcM, this.jgm.jgl.jcN, "fail auth cancel");
                        this.jgm.jgl.jfU.afC();
                        return;
                }
            }
        }));
    }
}
