package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class UploadMediaFileHelp$UploadMediaFileActivity extends GameProcessActivityTask {
    public static final Creator<UploadMediaFileHelp$UploadMediaFileActivity> CREATOR = new 2();
    public String appId;
    public Runnable jcI;
    public String mXA;
    public boolean mXB;
    public String mXC;
    public boolean mXD;
    private a mXz;
    public String mediaId;

    static /* synthetic */ void a(UploadMediaFileHelp$UploadMediaFileActivity uploadMediaFileHelp$UploadMediaFileActivity, GameProcessActivityTask.a aVar, String str, String str2) {
        uploadMediaFileHelp$UploadMediaFileActivity.mediaId = str;
        uploadMediaFileHelp$UploadMediaFileActivity.mXC = str2;
        uploadMediaFileHelp$UploadMediaFileActivity.mXD = true;
        aVar.afh();
    }

    private void a(GameProcessActivityTask.a aVar) {
        this.mXD = false;
        aVar.afh();
    }

    public final void a(Context context, final GameProcessActivityTask.a aVar) {
        x.i("MicroMsg.UploadMediaFileActivity", "runInMainProcess");
        if (this.mXz == null) {
            this.mXz = new a(this) {
                final /* synthetic */ UploadMediaFileHelp$UploadMediaFileActivity mXE;

                public final void b(boolean z, String str, String str2) {
                    x.i("MicroMsg.UploadMediaFileActivity", "success = %b, mediaId = %s, mediaUrl = %s", new Object[]{Boolean.valueOf(z), str, str2});
                    if (z) {
                        UploadMediaFileHelp$UploadMediaFileActivity.a(this.mXE, aVar, str, str2);
                    } else {
                        this.mXE.a(aVar);
                    }
                }
            };
        }
        WebViewJSSDKFileItem Oo = f.bRB().Oo(this.mXA);
        if (Oo == null) {
            a(aVar);
            return;
        }
        switch (Oo.ftE) {
            case 1:
                UploadMediaFileHelp.a(context, Oo, this.appId, this.mXA, b.hrP, this.mXB, this.mXz);
                return;
            case 4:
                UploadMediaFileHelp.a(context, this.appId, this.mXA, b.hrQ, this.mXB, this.mXz);
                return;
            default:
                UploadMediaFileHelp.a(context, this.appId, this.mXA, b.hrQ, this.mXB, this.mXz);
                return;
        }
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.mXA = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.mXB = z;
        this.mediaId = parcel.readString();
        this.mXC = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.mXD = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.mXA);
        parcel.writeString(this.appId);
        if (this.mXB) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.mXC);
        if (!this.mXD) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public UploadMediaFileHelp$UploadMediaFileActivity(MMActivity mMActivity) {
        super(mMActivity);
    }

    private UploadMediaFileHelp$UploadMediaFileActivity(Parcel parcel) {
        f(parcel);
    }
}
