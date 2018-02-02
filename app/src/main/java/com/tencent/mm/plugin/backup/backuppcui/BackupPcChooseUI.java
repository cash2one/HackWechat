package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

@a(3)
public class BackupPcChooseUI extends MMWizardActivity {
    private static int afu = 0;
    private static long endTime;
    private static int kmp = 0;
    private static long startTime;
    private View kmh;
    private TextView kmi;
    private CheckBox kmj;
    private TextView kmk;
    private TextView kml;
    private RelativeLayout kmm;
    private TextView kmn;
    private ProgressBar kmo;
    private SimpleDateFormat kmq = new SimpleDateFormat("yyyy.MM.dd");
    private a kol = new a(this);
    private ListView kom;
    private b.a kon = new 5(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            initView();
        }
    }

    protected final int getLayoutId() {
        return R.i.daN;
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().knv = this.kon;
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().knv = null;
    }

    protected final void initView() {
        setMMTitle(R.l.dJz);
        this.kom = (ListView) findViewById(R.h.bLX);
        this.kom.setAdapter(this.kol);
        this.kom.setEmptyView(findViewById(R.h.bLZ));
        this.kmh = findViewById(R.h.bMe);
        this.kmi = (TextView) findViewById(R.h.bMg);
        this.kmj = (CheckBox) findViewById(R.h.bMd);
        this.kmk = (TextView) findViewById(R.h.bMf);
        this.kml = (TextView) findViewById(R.h.bLY);
        this.kmo = (ProgressBar) findViewById(R.h.bMc);
        this.kmm = (RelativeLayout) findViewById(R.h.bMb);
        this.kmn = (TextView) findViewById(R.h.bMa);
        if (!w.cfe()) {
            this.kmi.setTextSize(1, 14.0f);
            this.kmk.setTextSize(1, 14.0f);
        }
        setBackBtn(new 1(this));
        a(0, getString(R.l.dJX), new 2(this), p.b.xJz);
        enableOptionMenu(false);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apu().knY || com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apu().knZ) {
            this.kmm.setVisibility(0);
            dJ(true);
            this.kmm.setOnClickListener(new 3(this));
        } else {
            this.kmm.setVisibility(8);
        }
        this.kmh.setOnClickListener(new 4(this));
        if (!com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().kkG) {
            this.kmj.setClickable(false);
            this.kmo.setVisibility(0);
        } else if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().aoN().size() == 0) {
            switch (kmp) {
                case 0:
                    this.kml.setText(R.l.dIE);
                    break;
                case 1:
                    this.kml.setText(R.l.dJK);
                    break;
            }
            this.kml.setVisibility(0);
        }
    }

    private void dJ(boolean z) {
        if (z) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.aps();
            SharedPreferences aoq = com.tencent.mm.plugin.backup.backuppcmodel.b.aoq();
            kmp = aoq.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
            afu = aoq.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aoq.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
            endTime = aoq.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apu().knY) {
            switch (kmp) {
                case 0:
                    this.kmn.setText("");
                    break;
                case 1:
                    this.kmn.setText(this.kmq.format(new Date(startTime)) + "~" + this.kmq.format(new Date(endTime - 86400000)));
                    break;
            }
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apu().knZ && afu == 1) {
            this.kmn.setText(this.kmn.getText() + (kmp == 1 ? ";" : "") + this.mController.xIM.getResources().getString(R.l.dJu));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        int size = com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().aoN().size();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue >= size) {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove(Integer.valueOf(((Integer) it2.next()).intValue()));
        }
        if (hashSet.size() != 0) {
            enableOptionMenu(true);
            if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().kkG && hashSet.size() == this.kol.getCount()) {
                this.kmj.setChecked(true);
            } else {
                this.kmj.setChecked(false);
            }
            this.kmi.setText(getString(R.l.dHp, new Object[]{Integer.valueOf(hashSet.size())}));
            return;
        }
        enableOptionMenu(false);
        this.kmj.setChecked(false);
        this.kmi.setText("");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            x.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[]{Integer.valueOf(i2)});
            return;
        }
        int i3 = kmp;
        long j = startTime;
        long j2 = endTime;
        kmp = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", kmp);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        afu = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", afu);
        x.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[]{Integer.valueOf(kmp), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(afu)});
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apu();
        e.d(kmp, startTime, endTime, afu);
        dJ(false);
        if (i3 == kmp) {
            if (kmp == 0) {
                return;
            }
            if (kmp == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().a(kmp, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().aoM());
        a aVar = this.kol;
        aVar.kmb.clear();
        aVar.koi.a(aVar.kmb);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().aoN() == null || com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apw().aoN().size() == 0) {
            switch (kmp) {
                case 0:
                    this.kml.setText(R.l.dIE);
                    break;
                case 1:
                    this.kml.setText(R.l.dJK);
                    break;
            }
            this.kml.setVisibility(0);
        } else {
            this.kml.setVisibility(4);
        }
        this.kol.notifyDataSetChanged();
    }
}
