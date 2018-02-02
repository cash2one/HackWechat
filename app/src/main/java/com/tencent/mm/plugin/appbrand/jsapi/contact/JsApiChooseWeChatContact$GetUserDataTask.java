package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;

class JsApiChooseWeChatContact$GetUserDataTask extends MainProcessTask {
    public static final Creator<JsApiChooseWeChatContact$GetUserDataTask> CREATOR = new 1();
    String bgo;
    String bgp;
    public String jiJ;
    String jiK = "";
    public String userName;

    public JsApiChooseWeChatContact$GetUserDataTask(String str) {
        this.userName = str;
    }

    public JsApiChooseWeChatContact$GetUserDataTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        this.jiJ = q.FS();
        if (!TextUtils.isEmpty(this.userName)) {
            this.bgo = r.gt(this.userName);
            this.bgp = r.gv(this.userName);
            h jm = n.JQ().jm(this.userName);
            if (jm != null) {
                this.jiK = jm.JG();
                if (bh.ov(this.jiK)) {
                    this.jiK = jm.JH();
                }
            }
        }
    }

    public final void f(Parcel parcel) {
        this.jiJ = parcel.readString();
        this.userName = parcel.readString();
        this.bgo = parcel.readString();
        this.bgp = parcel.readString();
        this.jiK = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jiJ);
        parcel.writeString(this.userName);
        parcel.writeString(this.bgo);
        parcel.writeString(this.bgp);
        parcel.writeString(this.jiK);
    }
}
