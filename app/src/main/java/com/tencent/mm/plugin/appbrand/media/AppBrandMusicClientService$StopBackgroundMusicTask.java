package com.tencent.mm.plugin.appbrand.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.av.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMusicClientService$StopBackgroundMusicTask extends MainProcessTask {
    public static final Creator<AppBrandMusicClientService$StopBackgroundMusicTask> CREATOR = new Creator<AppBrandMusicClientService$StopBackgroundMusicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandMusicClientService$StopBackgroundMusicTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandMusicClientService$StopBackgroundMusicTask[i];
        }
    };
    public String appId;

    public AppBrandMusicClientService$StopBackgroundMusicTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
        String str = a.aio().jzA;
        if (!bh.ov(str) && !str.equals(this.appId)) {
            x.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            afp();
        } else if (a.aio().tj(this.appId)) {
            if (c.Qw()) {
                x.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
            } else {
                x.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
            }
            afp();
        } else {
            x.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            afp();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
    }
}
