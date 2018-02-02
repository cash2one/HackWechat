package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetGameCommInfo extends a {
    public static final int CTRL_BYTE = 241;
    public static final String NAME = "getGameCommInfo";

    private static class GetGameCommInfoTask extends GWMainProcessTask {
        public static final Creator<GetGameCommInfoTask> CREATOR = new 1();
        public String fwF;
        public int pK;
        public String result;

        public final void Yr() {
            b gnVar = new gn();
            gnVar.fwD.pK = this.pK;
            gnVar.fwD.fwF = this.fwF;
            gnVar.fwD.context = ac.getContext();
            com.tencent.mm.sdk.b.a.xef.m(gnVar);
            this.result = gnVar.fwE.result;
        }

        public final void f(Parcel parcel) {
            this.pK = parcel.readInt();
            this.fwF = parcel.readString();
            this.result = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.pK);
            parcel.writeString(this.fwF);
            parcel.writeString(this.result);
        }

        private GetGameCommInfoTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetGameCommInfo", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiGetGameCommInfo", "data is null");
            dVar.E(i, a.e("getGameCommInfo:fail_invalid_data", null));
            return;
        }
        GWMainProcessTask getGameCommInfoTask = new GetGameCommInfoTask();
        getGameCommInfoTask.pK = jSONObject.optInt("cmd", 0);
        getGameCommInfoTask.fwF = jSONObject.optString("param");
        GameWebViewMainProcessService.b(getGameCommInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("gameRegionName", getGameCommInfoTask.result);
        dVar.E(i, a.e("getGameCommInfo:ok", hashMap));
    }
}
