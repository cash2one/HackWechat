package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask extends MainProcessTask {
    public static final Creator<JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask> CREATOR = new 5();
    public String appId;
    public String fileUrl;
    public String fus;
    public String fzR;
    public String hbp;
    public int iFv;
    private ProgressDialog iln = null;
    public Runnable jcI;
    j jcM;
    public boolean jnL;
    public int jnM = 0;
    public int jnN = 0;
    public int jnO = 0;
    MMActivity jnP;
    a jnQ;
    b jnR;
    public String mimeType;

    public JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[]{Integer.valueOf(this.jnN), Integer.valueOf(this.jnO)});
        if (this.jnN == 1) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
            f.Zr().a(this.jnQ);
            f.Zr().a(this.jnR);
            f.Zr();
            com.tencent.mm.plugin.appbrand.c.b.qh(this.fus);
            this.jnN = 0;
            this.jnO = 1;
            afp();
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.appId, this.fus);
        if (itemByLocalId == null) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
            this.jnO = 1;
            afp();
            return;
        }
        boolean z;
        com.tencent.mm.plugin.appbrand.c.a aVar = new com.tencent.mm.plugin.appbrand.c.a();
        aVar.fus = itemByLocalId.fus;
        aVar.iLu = itemByLocalId.hhZ;
        aVar.ieE = itemByLocalId.ieE;
        String str = this.fus;
        aVar.mediaId = d.a("appbrandmediafile", bh.Wp(), str, str);
        f.Zq().a(aVar);
        this.jnQ = new 1(this);
        this.jnR = new 2(this, itemByLocalId);
        com.tencent.mm.plugin.appbrand.c.b Zr = f.Zr();
        a aVar2 = this.jnQ;
        if (!(Zr.iLB == null || aVar2 == null || Zr.iLB.contains(aVar2))) {
            Zr.iLB.add(aVar2);
        }
        Zr = f.Zr();
        str = this.appId;
        String str2 = itemByLocalId.fus;
        int i = com.tencent.mm.modelcdntran.b.hrN;
        b bVar = this.jnR;
        com.tencent.mm.plugin.appbrand.c.a qj = f.Zq().qj(str2);
        if (qj == null) {
            x.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
            z = false;
        } else {
            qj.appId = str;
            if (!(bVar == null || Zr.iLA == null || bVar == null || Zr.iLA.contains(bVar))) {
                Zr.iLA.add(bVar);
            }
            qj.iLx = true;
            i iVar = new i();
            iVar.htt = Zr.hBx;
            iVar.fLH = true;
            iVar.field_mediaId = qj.mediaId;
            iVar.field_fullpath = qj.iLu;
            iVar.field_fileType = i;
            iVar.field_talker = "weixin";
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
            if (i == com.tencent.mm.modelcdntran.b.hrN) {
                iVar.field_needStorage = true;
            } else {
                iVar.field_needStorage = false;
            }
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 0;
            iVar.field_bzScene = 0;
            iVar.field_force_aeskeycdn = true;
            iVar.field_trysafecdn = false;
            z = g.MJ().c(iVar);
            x.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(z), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), str2});
        }
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
            this.jnO = 1;
            f.Zr().a(this.jnQ);
            f.Zr().a(this.jnR);
            f.Zr();
            com.tencent.mm.plugin.appbrand.c.b.qh(itemByLocalId.fus);
            afp();
        } else if (this.jnL) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
            this.jnO = 2;
            afp();
        }
    }

    public final void Ys() {
        if (this.jnO == 0) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        } else if (this.jnO == 1) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (this.jcI != null) {
                this.jcI.run();
            }
        } else if (this.jnO == 2) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
            Context context = this.jnP;
            this.jnP.getString(q.j.dGO);
            this.iln = h.a(context, this.jnP.getString(q.j.iBS), true, new 3(this));
            this.iln.setOnKeyListener(new OnKeyListener(this) {
                final /* synthetic */ JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask jnS;

                {
                    this.jnS = r1;
                }

                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1) {
                        return false;
                    }
                    Object string;
                    if (TextUtils.isEmpty(this.jnS.mimeType) || !this.jnS.mimeType.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        String string2 = this.jnS.jnP.getString(q.j.iBN);
                    } else {
                        string = this.jnS.jnP.getString(q.j.iBT);
                    }
                    h.a(this.jnS.jnP, true, this.jnS.jnP.getString(q.j.iBO, new Object[]{string}), "", this.jnS.jnP.getString(q.j.iBQ), this.jnS.jnP.getString(q.j.iBR), new 1(this), new 2(this));
                    return true;
                }
            });
        } else if (this.jnO == 3) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
            Map hashMap = new HashMap();
            hashMap.put("tempFilePath", this.fus);
            hashMap.put("percent", Integer.valueOf(this.jnM));
            String jSONObject = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.f a = new JsApiUploadEncryptedFileToCDN.a((byte) 0).a(this.jcM);
            a.mData = jSONObject;
            a.afs();
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.fus = parcel.readString();
        this.fzR = parcel.readString();
        this.hbp = parcel.readString();
        this.fileUrl = parcel.readString();
        this.iFv = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jnL = z;
        this.jnM = parcel.readInt();
        this.jnO = parcel.readInt();
        this.jnN = parcel.readInt();
        this.mimeType = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fus);
        parcel.writeString(this.fzR);
        parcel.writeString(this.hbp);
        parcel.writeString(this.fileUrl);
        parcel.writeInt(this.iFv);
        parcel.writeInt(this.jnL ? 1 : 0);
        parcel.writeInt(this.jnM);
        parcel.writeInt(this.jnO);
        parcel.writeInt(this.jnN);
        parcel.writeString(this.mimeType);
    }
}
