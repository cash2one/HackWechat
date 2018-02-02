package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.i.b.5;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e$h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity {
    private long lfQ;
    private String lfR = "com.tencent.qqpimsecure";
    private String lfS = "00B1208638DE0FCD3E920886D658DAF6";
    private String lfT = "11206657";
    private JSONObject lfU;
    private long lhA = 0;
    private c lhB = new 6(this);
    private com.tencent.mm.sdk.b.c<ji> lhC = new 9(this);
    private LinearLayout lhk;
    private TextView lhl;
    private TextView lhm;
    private Button lhn;
    private Button lho;
    private TextView lhp;
    private LinearLayout lhq;
    private TextView lhr;
    private TextView lhs;
    private Button lht;
    private View lhu;
    private boolean lhv = false;
    private a lhw;
    private long lhx = 0;
    private long lhy = 0;
    private long lhz = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dTI);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanNewUI lhD;

            {
                this.lhD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lhD.finish();
                return false;
            }
        });
        this.lhk = (LinearLayout) findViewById(R.h.cZm);
        this.lhl = (TextView) findViewById(R.h.cZn);
        this.lhm = (TextView) findViewById(R.h.cZo);
        this.lhn = (Button) findViewById(R.h.cZk);
        this.lhn.setEnabled(false);
        this.lho = (Button) findViewById(R.h.cZj);
        this.lho.setVisibility(8);
        this.lhp = (TextView) findViewById(R.h.cDt);
        this.lhn.setOnClickListener(new 2(this));
        this.lho.setOnClickListener(new 3(this));
        this.lhq = (LinearLayout) findViewById(R.h.cwN);
        this.lhr = (TextView) findViewById(R.h.cwO);
        this.lhs = (TextView) findViewById(R.h.cwP);
        this.lht = (Button) findViewById(R.h.cEx);
        this.lhu = findViewById(R.h.cEy);
        this.lht.setOnClickListener(new 4(this));
        if (bh.cgw() || f.fdS == 1) {
            this.lht.setVisibility(8);
            this.lhu.setVisibility(0);
        }
        j.ayv();
        long ayc = j.ayc();
        j.ayv();
        this.lhr.setText(bh.bx(ayc - j.ayd()));
        this.lhs.setText(getString(R.l.dTH, new Object[]{bh.bx(r4)}));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            b bVar = new b();
            bVar.xet = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new com.tencent.mm.sdk.c.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new 5(this, ""), new af());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        if (com.tencent.mm.plugin.i.b.asG().asJ()) {
            x.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[]{asN()});
            this.lhv = false;
            ayB();
            this.lhp.setText(getString(R.l.dDH, new Object[]{"0%"}));
            g.pQN.a(714, 50, 1, false);
        } else {
            x.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[]{asN()});
            this.lhx = bh.Wp();
            this.lhv = true;
            com.tencent.mm.sdk.b.a.xef.a(this.lhC);
            com.tencent.mm.plugin.i.b.asG().dX(true);
            ayA();
            cm(0, 100);
        }
        g.pQN.a(714, 1, 1, false);
    }

    public void onResume() {
        super.onResume();
        if (this.lhA > 0 && j.ayv().leW != 0) {
            long j = j.ayv().leW;
            j.ayv();
            o(j, j.ayc());
        }
    }

    protected void onDestroy() {
        boolean z = false;
        super.onDestroy();
        x.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[]{asN(), Boolean.valueOf(this.lhv)});
        if (this.lhv) {
            com.tencent.mm.sdk.b.a.xef.c(this.lhC);
            com.tencent.mm.plugin.i.b asG = com.tencent.mm.plugin.i.b.asG();
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = asG.asN();
            if (asG.kHI != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            asG.i(new 5(asG));
        }
        if (this.lhw != null) {
            this.lhw.stop();
        }
    }

    private void o(long j, long j2) {
        this.lho.setEnabled(true);
        this.lhp.setVisibility(8);
        this.lhl.setVisibility(0);
        this.lhm.setVisibility(0);
        this.lhn.setEnabled(true);
        this.lhl.setText(bh.bx(j));
        if (((int) ((100 * j) / j2)) > 0) {
            this.lhm.setText(getString(R.l.dTP, new Object[]{r0 + "%"}));
            return;
        }
        this.lhm.setText(R.l.dTQ);
    }

    private void ayA() {
        this.lho.setEnabled(false);
        this.lhl.setVisibility(8);
        this.lhm.setVisibility(8);
        this.lhp.setVisibility(0);
    }

    private void ayB() {
        this.lhw = new a(this.lhB);
        this.lhz = bh.Wp();
        e.post(this.lhw, "cleanUI_calc");
        ayA();
        g.pQN.a(714, 52, 1, false);
    }

    protected final int getLayoutId() {
        return R.i.deA;
    }

    private boolean ayx() {
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(w.a.xqx, "");
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
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            return false;
        }
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
        String s = com.tencent.mm.a.g.s(aX[0].toByteArray());
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
                g.pQN.a(714, 7, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        return true;
    }

    public final void cm(int i, int i2) {
        ag.y(new 7(this, i, i2));
    }

    private String asN() {
        return hashCode();
    }
}
