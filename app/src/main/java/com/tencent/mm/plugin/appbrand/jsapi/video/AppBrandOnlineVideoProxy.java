package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

public final class AppBrandOnlineVideoProxy implements b {
    private OnlineVideoProxy jrR;
    private a jrS;

    private static class OnlineVideoProxy extends MainProcessTask {
        public static final Creator<OnlineVideoProxy> CREATOR = new 2();
        final int START = 1;
        final int STOP = 4;
        String hTu;
        final int jrT = 0;
        final int jrU = 2;
        final int jrV = 3;
        int jrW;
        final int jrX = 10;
        final int jrY = 11;
        final int jrZ = 12;
        final int jsa = 13;
        int jsb;
        boolean jsc = false;
        int jsd;
        int jse;
        a jsf;
        c jsg = new 1(this);
        int length;
        int offset;
        String path;
        String url;

        public OnlineVideoProxy(Parcel parcel) {
            f(parcel);
        }

        public final void Ys() {
            x.d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", new Object[]{this.hTu, Integer.valueOf(this.jsb), Integer.valueOf(this.jsd), Integer.valueOf(this.jse)});
            if (this.jsf != null) {
                switch (this.jsb) {
                    case 10:
                        this.jsf.iG(this.jsd);
                        break;
                    case 11:
                        this.jsf.onDataAvailable(this.hTu, this.jsd, this.jse);
                        break;
                    case 12:
                        this.jsf.g(this.hTu, this.jsd, this.jse);
                        break;
                    case 13:
                        this.jsf.K(this.hTu, this.jsd);
                        break;
                }
                this.jsb = 0;
                x.i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", new Object[]{Integer.valueOf(this.jsb)});
            }
        }

        public final void Yr() {
            x.d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", new Object[]{this.hTu, Integer.valueOf(this.jrW)});
            String str;
            int i;
            int i2;
            switch (this.jrW) {
                case 1:
                    com.tencent.mm.plugin.appbrand.c.b Zr = f.Zr();
                    Zr.iLC.put(this.hTu, this.jsg);
                    Zr = f.Zr();
                    x.i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", new Object[]{this.hTu, this.url, this.path});
                    j jVar = new j();
                    jVar.field_mediaId = r1;
                    jVar.field_fullpath = r3;
                    jVar.url = r2;
                    jVar.htQ = Zr.iLD;
                    jVar.htJ = 1;
                    jVar.htE = 3;
                    o.TV().a(jVar, false);
                    break;
                case 2:
                    f.Zr();
                    str = this.hTu;
                    i = this.offset;
                    i2 = this.length;
                    x.i("MicroMsg.AppbrandCdnService", "request online video task [%s]", new Object[]{str});
                    o.TV();
                    com.tencent.mm.modelcdntran.f.f(str, i, i2);
                    break;
                case 3:
                    f.Zr();
                    str = this.hTu;
                    i = this.offset;
                    i2 = this.length;
                    x.i("MicroMsg.AppbrandCdnService", "check online video task [%s]", new Object[]{str});
                    this.jsc = o.TV().isVideoDataAvailable(str, i, i2);
                    afp();
                    return;
                case 4:
                    f.Zr().qi(this.hTu);
                    f.Zr();
                    x.i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", new Object[]{this.hTu});
                    o.TV().b(str, null);
                    break;
                default:
                    x.w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
                    break;
            }
            this.jrW = 0;
            x.i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", new Object[]{Integer.valueOf(this.jrW)});
            afp();
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.hTu = parcel.readString();
            this.jrW = parcel.readInt();
            this.path = parcel.readString();
            this.url = parcel.readString();
            this.offset = parcel.readInt();
            this.length = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jsc = z;
            this.jsb = parcel.readInt();
            this.jsd = parcel.readInt();
            this.jse = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hTu);
            parcel.writeInt(this.jrW);
            parcel.writeString(this.path);
            parcel.writeString(this.url);
            parcel.writeInt(this.offset);
            parcel.writeInt(this.length);
            parcel.writeInt(this.jsc ? 1 : 0);
            parcel.writeInt(this.jsb);
            parcel.writeInt(this.jsd);
            parcel.writeInt(this.jse);
        }
    }

    public final void o(String str, String str2, String str3) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[]{Integer.valueOf(hashCode()), str, str2, str3});
        if (this.jrR == null) {
            this.jrR = new OnlineVideoProxy();
            this.jrR.jsf = this.jrS;
            this.jrR.afi();
        }
        MainProcessTask mainProcessTask = this.jrR;
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", new Object[]{Integer.valueOf(mainProcessTask.hashCode()), str, str2, str3});
        mainProcessTask.hTu = str;
        mainProcessTask.path = str2;
        mainProcessTask.url = str3;
        mainProcessTask.jrW = 1;
        AppBrandMainProcessService.a(mainProcessTask);
    }

    public final void ng(String str) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", new Object[]{Integer.valueOf(hashCode()), str});
        if (this.jrR != null) {
            this.jrR.jsf = null;
            MainProcessTask mainProcessTask = this.jrR;
            mainProcessTask.jrW = 4;
            AppBrandMainProcessService.a(mainProcessTask);
            this.jrR.afj();
        }
        this.jrR = null;
    }

    public final void h(String str, int i, int i2) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", new Object[]{Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.jrR != null) {
            MainProcessTask mainProcessTask = this.jrR;
            mainProcessTask.offset = i;
            mainProcessTask.length = i2;
            mainProcessTask.jrW = 2;
            AppBrandMainProcessService.a(mainProcessTask);
        }
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (this.jrR == null) {
            return false;
        }
        MainProcessTask mainProcessTask = this.jrR;
        mainProcessTask.offset = i;
        mainProcessTask.length = i2;
        mainProcessTask.jrW = 3;
        AppBrandMainProcessService.b(mainProcessTask);
        return mainProcessTask.jsc;
    }

    public final void a(a aVar) {
        this.jrS = aVar;
        if (this.jrR != null) {
            this.jrR.jsf = aVar;
        }
    }
}
