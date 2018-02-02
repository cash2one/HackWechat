package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.protocal.c.cao;
import com.tencent.mm.protocal.c.cap;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiGetSetting$GetSettingTask extends MainProcessTask {
    public static final Creator<JsApiGetSetting$GetSettingTask> CREATOR = new 2();
    public j iqB;
    private String jcZ;
    public int jcs;
    public String mAppId;

    public JsApiGetSetting$GetSettingTask(Parcel parcel) {
        f(parcel);
    }

    public final void Ys() {
        x.i("MicroMsg.JsApiGetSetting", "runInClientProcess");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", "getSetting:ok");
            jSONObject.put("authSetting", new JSONArray(bh.ou(this.jcZ)));
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiGetSetting", "set json error!");
        }
        this.iqB.E(this.jcs, jSONObject.toString());
        c.bk(this);
    }

    public final void Yr() {
        a aVar = new a();
        aVar.hmj = new cao();
        aVar.hmk = new cap();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.hmi = 1196;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_cao = new cao();
        com_tencent_mm_protocal_c_cao.appId = this.mAppId;
        aVar.hmj = com_tencent_mm_protocal_c_cao;
        u.a(aVar.JZ(), new u.a(this) {
            final /* synthetic */ JsApiGetSetting$GetSettingTask jda;

            {
                this.jda = r1;
            }

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                x.d("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    cap com_tencent_mm_protocal_c_cap = (cap) bVar.hmh.hmo;
                    if (com_tencent_mm_protocal_c_cap == null) {
                        x.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq failed, response is null!");
                    } else {
                        int i3 = com_tencent_mm_protocal_c_cap.wZW.errCode;
                        String str2 = com_tencent_mm_protocal_c_cap.wZW.fnL;
                        if (i3 == 0) {
                            LinkedList linkedList = com_tencent_mm_protocal_c_cap.wZX;
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                du duVar = (du) it.next();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("scope", duVar.scope);
                                    jSONObject.put("state", duVar.state);
                                    jSONObject.put("desc", duVar.vIX);
                                    jSONArray.put(jSONObject);
                                } catch (Exception e) {
                                    x.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[]{e.getMessage()});
                                }
                            }
                            this.jda.jcZ = jSONArray.toString();
                            x.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[]{jSONArray});
                        } else {
                            x.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq error %s", new Object[]{str2});
                        }
                    }
                    this.jda.afp();
                }
                return 0;
            }
        }, true);
    }

    public final void f(Parcel parcel) {
        this.jcZ = parcel.readString();
        this.mAppId = parcel.readString();
        this.jcs = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jcZ);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.jcs);
    }
}
