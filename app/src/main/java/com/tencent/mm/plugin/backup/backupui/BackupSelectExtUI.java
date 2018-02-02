package com.tencent.mm.plugin.backup.backupui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.widget.h;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI extends MMPreference {
    private int afu = 0;
    private long endTime = 0;
    private f ilB;
    private int kiF;
    private long kkC = 0;
    private int kmp = 0;
    private SimpleDateFormat kmq = new SimpleDateFormat("yyyy.MM.dd");
    private CheckPreference kqd;
    private CheckPreference kqe;
    private Preference kqf;
    private Preference kqg;
    private boolean kqh = false;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        initView();
    }

    public final int XB() {
        return R.o.fbh;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("backup_select_ext_time")) {
            this.kmp = this.kmp == 0 ? 1 : 0;
            switch (this.kmp) {
                case 0:
                    this.kqd.tSw = false;
                    fVar.c(this.kqg);
                    fVar.c(this.kqf);
                    enableOptionMenu(true);
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    au();
                    return true;
                default:
                    return true;
            }
        } else if (preference.ibD.equals("backup_select_ext_content")) {
            if (!this.kqh) {
                return true;
            }
            int i;
            if (this.afu == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.afu = i;
            switch (this.afu) {
                case 0:
                    this.kqe.tSw = false;
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    this.kqe.tSw = true;
                    fVar.notifyDataSetChanged();
                    return true;
                default:
                    return true;
            }
        } else if (preference.ibD.equals("backup_select_begin_time")) {
            showDialog(1);
            return true;
        } else if (!preference.ibD.equals("backup_select_end_time")) {
            return false;
        } else {
            showDialog(2);
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        Calendar instance = Calendar.getInstance();
        switch (i) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? bh.Wp() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? bh.Wp() : this.endTime - 86400000);
                break;
        }
        Dialog hVar = new h(this.mController.xIM, new 1(this, i), instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), 1);
        hVar.setCanceledOnTouchOutside(false);
        long Wp = (((bh.Wp() / 86400000) * 86400000) + 57600000) - 1;
        if (Wp > this.kkC) {
            hVar.getDatePicker().setMaxDate(Wp);
            hVar.getDatePicker().setMinDate(this.kkC);
        }
        return hVar;
    }

    protected final void initView() {
        this.kiF = getIntent().getIntExtra("BACKUP_MODE", 0);
        setMMTitle(R.l.dJL);
        this.kmp = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.kqh = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.afu = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.kkC = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        au();
        setBackBtn(new 2(this));
        a(0, getString(R.l.dJX), new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupSelectExtUI kqi;

            {
                this.kqi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.kqi.kmp != 1 || this.kqi.startTime < this.kqi.endTime) {
                    Intent intent = new Intent();
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", this.kqi.kmp);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", this.kqi.afu);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", this.kqi.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", this.kqi.endTime);
                    this.kqi.setResult(-1, intent);
                    this.kqi.finish();
                } else if (this.kqi.kiF == 1) {
                    com.tencent.mm.ui.base.h.b(this.kqi.mController.xIM, this.kqi.getString(R.l.dIF), "", true);
                } else if (this.kqi.kiF == 2) {
                    com.tencent.mm.ui.base.h.b(this.kqi.mController.xIM, this.kqi.getString(R.l.dHv), "", true);
                }
                return true;
            }
        }, b.xJz);
    }

    private void au() {
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbh);
        this.kqd = (CheckPreference) this.ilB.YN("backup_select_ext_time");
        this.kqg = this.ilB.YN("backup_select_begin_time");
        this.kqf = this.ilB.YN("backup_select_end_time");
        this.kqe = (CheckPreference) this.ilB.YN("backup_select_ext_content");
        if (!this.kqh) {
            this.ilB.c(this.ilB.YN("backup_select_ext_content_title"));
            this.ilB.c(this.kqe);
        }
        if (this.kiF == 1) {
            this.ilB.YN("backup_select_ext_time_title").setTitle(R.l.dJx);
            this.kqd.setTitle(R.l.dJw);
            if (this.kqh) {
                this.ilB.YN("backup_select_ext_content_title").setTitle(R.l.dJv);
                this.kqe.setTitle(R.l.dJt);
            }
        } else if (this.kiF == 2) {
            this.ilB.YN("backup_select_ext_time_title").setTitle(R.l.dIy);
            this.kqd.setTitle(R.l.dIx);
            if (this.kqh) {
                this.ilB.YN("backup_select_ext_content_title").setTitle(R.l.dIw);
                this.kqe.setTitle(R.l.dIu);
            }
        }
        switch (this.kmp) {
            case 0:
                this.kqg.setEnabled(false);
                this.kqf.setEnabled(false);
                this.kqd.tSw = false;
                this.ilB.c(this.kqg);
                this.ilB.c(this.kqf);
                enableOptionMenu(true);
                break;
            case 1:
                boolean z;
                BackupSelectExtUI backupSelectExtUI;
                BackupSelectExtUI backupSelectExtUI2;
                if (this.startTime != 0 && this.endTime != 0) {
                    this.kqg.setSummary(this.kmq.format(new Date(this.startTime)));
                    this.kqf.setSummary(this.kmq.format(new Date(this.endTime - 86400000)));
                    if (this.startTime != 0 && this.endTime != 0) {
                        z = true;
                        backupSelectExtUI = this;
                        backupSelectExtUI.enableOptionMenu(z);
                        this.kqg.setEnabled(true);
                        this.kqf.setEnabled(true);
                        this.kqd.tSw = true;
                        break;
                    }
                    backupSelectExtUI2 = this;
                } else {
                    this.kqg.setSummary(R.l.dJM);
                    this.kqf.setSummary(R.l.dJM);
                    backupSelectExtUI2 = this;
                }
                backupSelectExtUI = backupSelectExtUI2;
                z = false;
                backupSelectExtUI.enableOptionMenu(z);
                this.kqg.setEnabled(true);
                this.kqf.setEnabled(true);
                this.kqd.tSw = true;
                break;
        }
        if (this.kqh) {
            switch (this.afu) {
                case 0:
                    this.kqe.tSw = false;
                    break;
                case 1:
                    this.kqe.tSw = true;
                    break;
            }
        }
        this.ilB.notifyDataSetChanged();
    }
}
