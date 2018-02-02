package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private boolean fni = false;
    private f ilB;
    private Preference kqf;
    private Preference kqg;
    private int qiK;
    private int qiL;
    private int qiM;
    private int qiN;
    private boolean qiO = false;
    private final OnTimeSetListener qiP = new 2(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eKR);
        this.ilB = this.yjd;
        initView();
    }

    protected final void initView() {
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fck);
        this.kqg = this.ilB.YN("settings_active_begin_time");
        this.qiK = com.tencent.mm.k.f.zw();
        this.qiL = com.tencent.mm.k.f.zy();
        this.kqg.setSummary(e(this, this.qiK, this.qiL));
        this.kqf = this.ilB.YN("settings_active_end_time");
        this.qiM = com.tencent.mm.k.f.zv();
        this.qiN = com.tencent.mm.k.f.zx();
        this.kqf.setSummary(e(this, this.qiM, this.qiN));
        this.fni = !com.tencent.mm.k.f.zu();
        ((CheckBoxPreference) this.ilB.YN("settings_active_silence_time")).tSw = this.fni;
        if (this.fni) {
            this.kqg.setEnabled(true);
            this.kqf.setEnabled(true);
        } else {
            this.kqg.setEnabled(false);
            this.kqf.setEnabled(false);
        }
        if (!this.fni) {
            this.ilB.c(this.kqg);
            this.ilB.c(this.kqf);
        }
        this.ilB.bk("settings_active_time_full", true);
        this.ilB.notifyDataSetChanged();
        setBackBtn(new 1(this));
    }

    public final int XB() {
        return R.o.fck;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("settings_active_begin_time")) {
            this.qiO = true;
            showDialog(1);
            return true;
        } else if (preference.ibD.equals("settings_active_end_time")) {
            this.qiO = false;
            showDialog(1);
            return true;
        } else if (!preference.ibD.equals("settings_active_silence_time")) {
            return false;
        } else {
            boolean z;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_active_silence_time");
            if (checkBoxPreference.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            com.tencent.mm.k.f.bp(z);
            g gVar = g.pQN;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(checkBoxPreference.isChecked() ? 1 : 2);
            gVar.h(11351, objArr);
            initView();
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                if (this.qiO) {
                    return new TimePickerDialog(this.mController.xIM, this.qiP, this.qiK, this.qiL, false);
                }
                return new TimePickerDialog(this.mController.xIM, this.qiP, this.qiM, this.qiN, false);
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 1:
                if (this.qiO) {
                    ((TimePickerDialog) dialog).updateTime(this.qiK, this.qiL);
                    return;
                } else {
                    ((TimePickerDialog) dialog).updateTime(this.qiM, this.qiN);
                    return;
                }
            default:
                return;
        }
    }

    private static String e(Context context, int i, int i2) {
        String e = w.e(context.getSharedPreferences(ac.cfs(), 0));
        String cfi = w.cfi();
        if (!e.equalsIgnoreCase("zh_CN") && (!e.equalsIgnoreCase("language_default") || !"zh_CN".equalsIgnoreCase(cfi))) {
            return DateFormat.getTimeInstance(3, w.UX(e)).format(new Time(i, i2, 0));
        }
        int i3;
        if (i > 12) {
            i3 = i - 12;
        } else {
            i3 = i;
        }
        return n.p(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }
}
