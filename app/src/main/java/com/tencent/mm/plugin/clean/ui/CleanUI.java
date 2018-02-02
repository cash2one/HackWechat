package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONObject;

@a(19)
public class CleanUI extends MMActivity {
    private long lfQ;
    private String lfR = "com.tencent.qqpimsecure";
    private String lfS = "00B1208638DE0FCD3E920886D658DAF6";
    private String lfT = "11206657";
    private JSONObject lfU;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) && ayw()) {
            finish();
            return;
        }
        startActivity(new Intent(this, CleanNewUI.class));
        finish();
    }

    private boolean ayw() {
        ayx();
        if (!p.m(this.mController.xIM, this.lfR)) {
            return false;
        }
        Signature[] aX = p.aX(this, this.lfR);
        if (aX == null || aX[0] == null) {
            return false;
        }
        String s = g.s(aX[0].toByteArray());
        if (s == null || !s.equalsIgnoreCase(this.lfS)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.lfR);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                p.g(bundle, this.lfT);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                startActivity(launchIntentForPackage);
                com.tencent.mm.plugin.report.service.g.pQN.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
        }
        return true;
    }

    private boolean ayx() {
        ar.Hg();
        String str = (String) c.CU().get(w.a.xqx, "");
        if (bh.ov(str)) {
            return false;
        }
        try {
            this.lfU = new JSONObject(str);
            this.lfR = this.lfU.getString(DownloadInfoColumns.PACKAGENAME);
            this.lfU.get("md5");
            this.lfT = this.lfU.getString("launcherID");
            this.lfS = this.lfU.getString("signature");
            this.lfU.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.lfQ = this.lfU.getLong("size");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dey;
    }
}
