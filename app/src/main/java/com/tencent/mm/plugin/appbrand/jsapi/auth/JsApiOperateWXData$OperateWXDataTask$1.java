package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiOperateWXData$OperateWXDataTask$1 implements a {
    final /* synthetic */ OperateWXDataTask jgl;

    JsApiOperateWXData$OperateWXDataTask$1(OperateWXDataTask operateWXDataTask) {
        this.jgl = operateWXDataTask;
    }

    public final void po(String str) {
        x.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
        this.jgl.jgj = str;
        this.jgl.jfX = "ok";
        OperateWXDataTask.a(this.jgl);
    }

    public final void fq(String str) {
        x.e("MicroMsg.JsApiOperateWXData", "onFailure !");
        this.jgl.jfX = "fail:" + str;
        OperateWXDataTask.b(this.jgl);
    }

    public final void a(LinkedList<bec> linkedList, String str, String str2) {
        x.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
        this.jgl.jfZ = linkedList.size();
        int i = 0;
        while (i < this.jgl.jfZ) {
            try {
                this.jgl.jga.putByteArray(String.valueOf(i), ((bec) linkedList.get(i)).toByteArray());
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                this.jgl.jfX = "fail";
                OperateWXDataTask.c(this.jgl);
                return;
            }
        }
        this.jgl.mAppName = str;
        this.jgl.iVz = str2;
        this.jgl.jfX = "needConfirm";
        OperateWXDataTask.d(this.jgl);
    }
}
