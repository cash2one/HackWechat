package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateRecorder.OperateRecordTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiOperateRecorder$OperateRecordTask$1 extends c<li> {
    final /* synthetic */ OperateRecordTask jfq;

    JsApiOperateRecorder$OperateRecordTask$1(OperateRecordTask operateRecordTask) {
        this.jfq = operateRecordTask;
        this.xen = li.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        li liVar = (li) bVar;
        x.i("MicroMsg.JsApiOperateRecorder", "mListener callback action : %d", new Object[]{Integer.valueOf(liVar.fCH.action)});
        if (this.jfq.appId.equalsIgnoreCase(liVar.fCH.appId)) {
            Map hashMap = new HashMap();
            hashMap.put("state", liVar.fCH.state);
            OperateRecordTask.a(this.jfq, liVar.fCH.state);
            if (liVar.fCH.action == 2) {
                OperateRecordTask.b(this.jfq, liVar.fCH.filePath);
                OperateRecordTask.a(this.jfq, liVar.fCH.duration);
                OperateRecordTask.b(this.jfq, liVar.fCH.fileSize);
                com.tencent.mm.plugin.appbrand.media.c.tg(this.jfq.appId);
            }
            if (liVar.fCH.action == 4) {
                hashMap.put("errCode", Integer.valueOf(liVar.fCH.errCode));
                Object obj = "";
                if (!TextUtils.isEmpty(liVar.fCH.fnL)) {
                    obj = liVar.fCH.fnL;
                }
                hashMap.put("errMsg", obj);
            }
            if (liVar.fCH.action == 5) {
                if (liVar.fCH.fCI == null || liVar.fCH.fCI.length <= 819200) {
                    OperateRecordTask.a(this.jfq, liVar.fCH.fCI);
                } else {
                    OperateRecordTask.a(this.jfq, liVar);
                }
                OperateRecordTask.c(this.jfq, liVar.fCH.fCI != null ? liVar.fCH.fCI.length : 0);
                OperateRecordTask.a(this.jfq, liVar.fCH.fCJ);
                x.i("MicroMsg.JsApiOperateRecorder", "frameBufferSize:%d", new Object[]{Integer.valueOf(OperateRecordTask.a(this.jfq))});
            }
            this.jfq.jeW = new JSONObject(hashMap).toString();
            this.jfq.action = liVar.fCH.action;
            OperateRecordTask.b(this.jfq);
            return true;
        }
        x.e("MicroMsg.JsApiOperateRecorder", "appId is diff, don't send event");
        return false;
    }
}
