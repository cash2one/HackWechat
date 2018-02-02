package com.tencent.mm.plugin.clean.ui.newui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
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
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity implements g {
    private long lfQ;
    private String lfR = "com.tencent.qqpimsecure";
    private String lfS = "00B1208638DE0FCD3E920886D658DAF6";
    private String lfT = "11206657";
    private JSONObject lfU;
    private c lhS;
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dTO);
        setBackBtn(new 1(this));
        this.lhk = (LinearLayout) findViewById(R.h.cZm);
        this.lhl = (TextView) findViewById(R.h.cZn);
        this.lhm = (TextView) findViewById(R.h.cZo);
        this.lhn = (Button) findViewById(R.h.cZk);
        this.lho = (Button) findViewById(R.h.cZj);
        this.lho.setVisibility(8);
        this.lhp = (TextView) findViewById(R.h.cDt);
        this.lhn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanNewUI lhX;

            {
                this.lhX = r1;
            }

            public final void onClick(View view) {
                x.i("MicroMsg.CleanNewUI", "goto clean msg ui");
                this.lhX.startActivityForResult(new Intent(this.lhX, CleanMsgUI.class), 0);
            }
        });
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
        this.lhr.setText(bh.bx(c.ayc() - c.ayd()));
        this.lhs.setText(getString(R.l.dTH, new Object[]{bh.bx(r2)}));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            b bVar = new b();
            bVar.xet = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new 5(this, ""), new af());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        d.a(new com.tencent.mm.plugin.clean.c.a.b());
        if (d.ayk() == null) {
            com.tencent.mm.plugin.clean.c.a.b ayi = d.ayi();
            if (ayi != null) {
                this.lhS = new c(ayi, this);
                e.post(this.lhS, "CleanUI_clean");
                this.lho.setEnabled(false);
                this.lhl.setVisibility(8);
                this.lhm.setVisibility(8);
                this.lhp.setVisibility(0);
                this.lhp.setText(getString(R.l.dDH, new Object[]{"0%"}));
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (d.ayk() != null) {
            o(d.ayl(), c.ayc());
        }
    }

    private void o(long j, long j2) {
        this.lho.setEnabled(true);
        this.lhp.setVisibility(8);
        this.lhl.setVisibility(0);
        this.lhm.setVisibility(0);
        this.lhl.setText(bh.bx(j));
        int i = (int) ((100 * j) / j2);
        this.lhm.setText(getString(R.l.dTP, new Object[]{i + "%"}));
    }

    protected final int getLayoutId() {
        return R.i.deA;
    }

    public final void ck(int i, int i2) {
        this.lhp.setText(getString(R.l.dDH, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, long j3, ArrayList<com.tencent.mm.plugin.clean.c.b> arrayList, long j4, HashSet<String> hashSet) {
        x.i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)});
        d.bU(j);
        d.bR(j2);
        d.bT(j4);
        d.b(hashSet);
        d.bS(j3);
        d.m(arrayList);
        o(d.ayl(), c.ayc());
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
                com.tencent.mm.plugin.report.service.g.pQN.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        return true;
    }
}
