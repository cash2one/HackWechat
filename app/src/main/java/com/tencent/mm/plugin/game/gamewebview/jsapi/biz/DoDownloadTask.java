package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class DoDownloadTask extends GWMainProcessTask {
    public static Creator<DoDownloadTask> CREATOR = new 1();
    public String appId;
    public String extInfo;
    public long fmZ;
    public boolean fpW;
    public String fqR;
    public String mWn;
    public String mWo;
    public String mWp;
    public long mWq;
    public String packageName;
    public int scene;
    public int type;
    public String url;

    public final void Yr() {
        boolean z = false;
        boolean z2 = true;
        x.i("MicroMsg.AddDownloadTask", "doDownloadTask, type = " + this.type);
        switch (this.type) {
            case 1:
                x.i("MicroMsg.AddDownloadTask", "addDownloadTask");
                b gpVar = new gp();
                gpVar.fwJ.url = this.url;
                gpVar.fwJ.fqR = this.fqR;
                gpVar.fwJ.extInfo = this.extInfo;
                gpVar.fwJ.appId = this.appId;
                gpVar.fwJ.scene = this.scene;
                a.xef.m(gpVar);
                g.a aVar = new g.a();
                aVar.xL(this.url);
                aVar.xM(this.mWo);
                aVar.ci(this.mWq);
                aVar.xN(this.mWn);
                aVar.xO(this.fqR);
                aVar.setAppId(this.appId);
                aVar.cu(this.packageName);
                aVar.ep(true);
                aVar.ox(bh.getInt(this.mWp, 1));
                aVar.lw(this.scene);
                this.fmZ = f.aAd().a(aVar.lsE);
                return;
            case 2:
                x.i("MicroMsg.AddDownloadTask", "pauseDownloadTask");
                z = f.aAd().bZ(this.fmZ);
                break;
            case 3:
                x.i("MicroMsg.AddDownloadTask", "resumeDownloadTask");
                com.tencent.mm.plugin.downloader.e.a ce = e.ce(this.fmZ);
                if (ce != null) {
                    ce.field_scene = this.scene;
                    e.c(ce);
                }
                z = f.aAd().ca(this.fmZ);
                break;
            case 4:
                x.i("MicroMsg.AddDownloadTask", f.NAME);
                if (f.aAd().bX(this.fmZ) <= 0) {
                    z2 = false;
                }
                this.fpW = z2;
                return;
            case 5:
                x.i("MicroMsg.AddDownloadTask", f.NAME);
                FileDownloadTaskInfo bY = f.aAd().bY(this.fmZ);
                if (bY.status != -1) {
                    if (bY.status == 3) {
                        if (com.tencent.mm.a.e.bO(bY.path)) {
                            z = q.e(ac.getContext(), Uri.fromFile(new File(bY.path)));
                            break;
                        }
                    }
                    x.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, invalid status = " + bY.status);
                    break;
                }
                x.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, apilevel not supported");
                break;
                break;
            default:
                return;
        }
        this.fpW = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.mWn);
        parcel.writeString(this.url);
        parcel.writeString(this.mWo);
        parcel.writeString(this.fqR);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.mWp);
        parcel.writeString(this.appId);
        parcel.writeString(this.packageName);
        parcel.writeLong(this.mWq);
        parcel.writeInt(this.scene);
        parcel.writeLong(this.fmZ);
        parcel.writeByte((byte) (this.fpW ? 1 : 0));
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        this.mWn = parcel.readString();
        this.url = parcel.readString();
        this.mWo = parcel.readString();
        this.fqR = parcel.readString();
        this.extInfo = parcel.readString();
        this.mWp = parcel.readString();
        this.appId = parcel.readString();
        this.packageName = parcel.readString();
        this.mWq = parcel.readLong();
        this.scene = parcel.readInt();
        this.fmZ = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.fpW = z;
    }

    private DoDownloadTask(Parcel parcel) {
        f(parcel);
    }
}
