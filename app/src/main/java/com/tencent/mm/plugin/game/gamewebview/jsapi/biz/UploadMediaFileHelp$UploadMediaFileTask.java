package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public class UploadMediaFileHelp$UploadMediaFileTask extends GWMainProcessTask {
    public static final Creator<UploadMediaFileHelp$UploadMediaFileTask> CREATOR = new 2();
    public String appId;
    public Runnable jcI;
    public String mXA;
    public String mXC;
    private a mXz;
    public String mediaId;
    public boolean success;

    public final void Yr() {
        x.i("MicroMsg.UploadMediaTask", "runInMainProcess");
        if (this.mXz == null) {
            this.mXz = new 1(this);
        }
        WebViewJSSDKFileItem Oo = f.bRB().Oo(this.mXA);
        if (Oo == null) {
            afp();
            return;
        }
        switch (Oo.ftE) {
            case 1:
                UploadMediaFileHelp.a(ac.getContext(), Oo, this.appId, this.mXA, b.hrP, false, this.mXz);
                return;
            case 4:
                UploadMediaFileHelp.a(ac.getContext(), this.appId, this.mXA, b.hrQ, false, this.mXz);
                return;
            default:
                UploadMediaFileHelp.a(ac.getContext(), this.appId, this.mXA, b.hrQ, false, this.mXz);
                return;
        }
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.mXA = parcel.readString();
        this.appId = parcel.readString();
        this.mediaId = parcel.readString();
        this.mXC = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mXA);
        parcel.writeString(this.appId);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.mXC);
        parcel.writeByte((byte) (this.success ? 1 : 0));
    }

    private UploadMediaFileHelp$UploadMediaFileTask(Parcel parcel) {
        f(parcel);
    }
}
