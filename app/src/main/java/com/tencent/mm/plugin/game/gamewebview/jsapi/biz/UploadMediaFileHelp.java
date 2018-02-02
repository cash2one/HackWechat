package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class UploadMediaFileHelp {
    private static ProgressDialog iln = null;
    public MMActivity iqt;
    public String mAppId;
    public d mWG;
    public String mXp;
    public boolean mXq;
    public b mXr;

    static /* synthetic */ void a(Context context, WebViewJSSDKFileItem webViewJSSDKFileItem, String str, final String str2, int i, boolean z, final a aVar) {
        final b 5 = new 5(str2, aVar);
        e b = o.Pw().b(Long.valueOf(o.Pw().a(webViewJSSDKFileItem.iLu, webViewJSSDKFileItem.iLy ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str3 = webViewJSSDKFileItem.iLu;
        webViewJSSDKFileItem.iLu = o.Pw().m(b.hzQ, "", "");
        x.i("MicroMsg.UploadMediaFileHelp", "Image Inserted: %s", new Object[]{r0});
        x.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", new Object[]{Boolean.valueOf(f.bRA().a(str, str2, i, 202, 2, 5))});
        webViewJSSDKFileItem.iLu = str3;
        if (!f.bRA().a(str, str2, i, 202, 2, 5)) {
            aVar.b(false, "", "");
        } else if (z) {
            context.getString(R.l.dGO);
            iln = h.a(context, context.getString(R.l.eYF), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    f.bRA().a(5);
                    f.bRA();
                    ac.qh(str2);
                    aVar.b(false, "", "");
                }
            });
        }
    }

    static /* synthetic */ void a(Context context, String str, String str2, int i, boolean z, a aVar) {
        b 7 = new 7(str2, aVar);
        x.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", new Object[]{Boolean.valueOf(f.bRA().a(str, str2, i, 202, 2, 7))});
        if (!f.bRA().a(str, str2, i, 202, 2, 7)) {
            aVar.b(false, "", "");
        } else if (z) {
            context.getString(R.l.dGO);
            ProgressDialog a = h.a(context, context.getString(R.l.eYF), true, new 8(7, str2, aVar));
            iln = a;
            a.setOnKeyListener(new 9(context));
        }
    }

    static /* synthetic */ void b(UploadMediaFileHelp uploadMediaFileHelp) {
        if (uploadMediaFileHelp.mWG.mYI != null) {
            com.tencent.mm.plugin.game.gamewebview.ui.e eVar = uploadMediaFileHelp.mWG.mYI;
            if (eVar.mZT != null) {
                eVar.mZT.dismiss();
                eVar.mZT = null;
            }
            uploadMediaFileHelp.mWG.mYI.B(null);
        }
    }

    final void aOO() {
        if (this.mWG.mYI != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", true);
            bundle.putString("close_window_confirm_dialog_title_cn", this.iqt.getString(R.l.eWW));
            bundle.putString("close_window_confirm_dialog_title_eng", this.iqt.getString(R.l.eWW));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.iqt.getString(R.l.eWT));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.iqt.getString(R.l.eWT));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.iqt.getString(R.l.eWU));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.iqt.getString(R.l.eWU));
            this.mWG.mYI.B(bundle);
        }
        aOP();
    }

    final void aOP() {
        if (this.mXq) {
            UploadMediaFileActivity uploadMediaFileActivity = new UploadMediaFileActivity(this.iqt);
            uploadMediaFileActivity.mXA = this.mXp;
            uploadMediaFileActivity.appId = this.mAppId;
            uploadMediaFileActivity.mXB = this.mXq;
            uploadMediaFileActivity.jcI = new 3(this, uploadMediaFileActivity);
            uploadMediaFileActivity.aKE();
            return;
        }
        final GWMainProcessTask uploadMediaFileTask = new UploadMediaFileTask();
        uploadMediaFileTask.mXA = this.mXp;
        uploadMediaFileTask.appId = this.mAppId;
        uploadMediaFileTask.jcI = new Runnable(this) {
            final /* synthetic */ UploadMediaFileHelp mXs;

            public final void run() {
                uploadMediaFileTask.afj();
                UploadMediaFileHelp.b(this.mXs);
                if (uploadMediaFileTask.success) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("serverId", bh.ou(uploadMediaFileTask.mediaId));
                    hashMap.put("mediaUrl", bh.ou(uploadMediaFileTask.mXC));
                    this.mXs.mXr.a(true, hashMap);
                    return;
                }
                this.mXs.mXr.a(false, null);
            }
        };
        uploadMediaFileTask.afi();
        GameWebViewMainProcessService.a(uploadMediaFileTask);
    }
}
