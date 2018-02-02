package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.a.1;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI extends MMWizardActivity {
    private static boolean kmN = false;
    private ak klS = new ak(Looper.getMainLooper(), new 4(this), true);
    private TextView kmB;
    private Button kmM;
    private TextView kmz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            setMMTitle(R.l.dvP);
            g.pQN.h(11788, new Object[]{Integer.valueOf(1)});
            this.kmB = (TextView) findViewById(R.h.bMo);
            this.kmM = (Button) findViewById(R.h.bMk);
            this.kmz = (TextView) findViewById(R.h.bMj);
            b.aoR();
            Editor edit = b.aoq().edit();
            edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            edit.commit();
            if (b.aoR().aoV().kkG) {
                b.aoR().aoV().aoQ();
            } else {
                a aoV = b.aoR().aoV();
                d.aqe().aqh();
                e.post(new 1(aoV), "BakMoveChooseServer.calculateToChoose");
            }
            if (bh.ov(com.tencent.mm.plugin.backup.a.g.cl(this))) {
                this.kmB.setText(R.l.dJO);
                this.kmB.setTextColor(getResources().getColor(R.e.brw));
                this.kmM.setEnabled(false);
                kmN = false;
                g.pQN.h(11788, new Object[]{Integer.valueOf(2)});
            } else {
                this.kmB.setText(R.l.dJP);
                this.kmB.setTextColor(getResources().getColor(R.e.brv));
                this.kmM.setEnabled(true);
                kmN = true;
            }
            this.kmM.setOnClickListener(new 1(this));
            this.kmz.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BackupUI kmO;

                {
                    this.kmO = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", this.kmO.getString(R.l.dIH));
                    intent.putExtra("rawUrl", this.kmO.getString(R.l.dJF, new Object[]{w.cfi()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    com.tencent.mm.bm.d.b(this.kmO, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            setBackBtn(new OnMenuItemClickListener(this) {
                final /* synthetic */ BackupUI kmO;

                {
                    this.kmO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.kmO.finish();
                    return true;
                }
            });
        }
    }

    public void onStart() {
        super.onStart();
        this.klS.J(5000, 5000);
    }

    public void onStop() {
        super.onStop();
        this.klS.TG();
    }

    public void onDestroy() {
        x.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
        super.onDestroy();
        b.aoR().aoV().cancel();
        b.aoR().aoV().aoP();
    }

    protected final int getLayoutId() {
        return R.i.daR;
    }
}
