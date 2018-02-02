package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.b.b$b;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class BackupMoveChooseUI extends MMWizardActivity implements b$b {
    private static int afu = 0;
    private static long endTime;
    private static int kmp = 0;
    private static long startTime;
    private a kmf = new a(this);
    private ListView kmg;
    private View kmh;
    private TextView kmi;
    private CheckBox kmj;
    private TextView kmk;
    private TextView kml;
    private RelativeLayout kmm;
    private TextView kmn;
    private ProgressBar kmo;
    private SimpleDateFormat kmq = new SimpleDateFormat("yyyy.MM.dd");

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onStart() {
        super.onStart();
        b.aoR().aoV().kkB = this;
    }

    public void onStop() {
        super.onStop();
        b.aoR().aoV().kkB = null;
    }

    public final void initView() {
        setMMTitle(R.l.dJN);
        this.kmg = (ListView) findViewById(R.h.bLX);
        this.kmg.setAdapter(this.kmf);
        this.kmg.setEmptyView(findViewById(R.h.bLZ));
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
        dG(true);
        this.kmm.setOnClickListener(new 3(this));
        this.kmh.setOnClickListener(new 4(this));
        if (b.aoR().aoV().kkG) {
            if (b.aoR().aoV().aoN() == null || b.aoR().aoV().aoN().size() == 0) {
                switch (kmp) {
                    case 0:
                        this.kml.setText(R.l.dHu);
                        break;
                    case 1:
                        this.kml.setText(R.l.dJK);
                        break;
                }
                this.kml.setVisibility(0);
            }
            this.kmo.setVisibility(4);
        } else if (b.aoR().aoV().kkG) {
            this.kmo.setVisibility(4);
        } else {
            this.kmj.setClickable(false);
            this.kmj.setVisibility(4);
            this.kmk.setVisibility(4);
            this.kmo.setVisibility(0);
        }
    }

    private void dG(boolean z) {
        if (z) {
            b.aoR();
            SharedPreferences aoq = b.aoq();
            kmp = aoq.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            afu = aoq.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aoq.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            endTime = aoq.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        }
        switch (kmp) {
            case 0:
                this.kmn.setText("");
                break;
            case 1:
                this.kmn.setText(this.kmq.format(new Date(startTime)) + "~" + this.kmq.format(new Date(endTime - 86400000)));
                break;
        }
        if (afu == 1) {
            this.kmn.setText(this.kmn.getText() + (kmp == 1 ? ";" : "") + this.mController.xIM.getResources().getString(R.l.dIv));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        LinkedList aoN = b.aoR().aoV().aoN();
        if (aoN == null) {
            x.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < aoN.size()) {
                j = ((f.b) aoN.get(intValue)).kiS + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            enableOptionMenu(true);
            if (hashSet.size() == this.kmf.getCount()) {
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
            x.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", Integer.valueOf(i2));
            return;
        }
        int i3 = kmp;
        long j = startTime;
        long j2 = endTime;
        kmp = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", kmp);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        afu = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", afu);
        x.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(kmp), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(afu));
        b.aoR().aoT();
        d.c(kmp, startTime, endTime, afu);
        dG(false);
        if (i3 == kmp) {
            if (kmp == 0) {
                return;
            }
            if (kmp == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        b.aoR().aoV().a(kmp, startTime, endTime, b.aoR().aoV().aoM());
        a aVar = this.kmf;
        aVar.kmb.clear();
        aVar.kma.a(aVar.kmb);
        if (b.aoR().aoV().aoN() == null || b.aoR().aoV().aoN().size() == 0) {
            switch (kmp) {
                case 0:
                    this.kml.setText(R.l.dHu);
                    break;
                case 1:
                    this.kml.setText(R.l.dJK);
                    break;
            }
            this.kml.setVisibility(0);
        } else {
            this.kml.setVisibility(4);
        }
        this.kmf.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.daN;
    }

    public final void v(LinkedList<f.b> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                this.kmo.setVisibility(8);
                this.kml.setVisibility(0);
                switch (kmp) {
                    case 0:
                        this.kml.setText(R.l.dHu);
                        return;
                    case 1:
                        this.kml.setText(R.l.dJK);
                        return;
                    default:
                        return;
                }
            }
            this.kmj.setClickable(true);
            this.kmj.setVisibility(0);
            this.kmk.setVisibility(0);
            this.kmo.setVisibility(8);
            this.kmf.notifyDataSetChanged();
        }
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
    }

    public final void w(LinkedList<f.b> linkedList) {
    }
}
