package com.tencent.mm.plugin.setting.ui.setting;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;

class SettingsActiveTimeUI$2 implements OnTimeSetListener {
    final /* synthetic */ SettingsActiveTimeUI qiQ;

    SettingsActiveTimeUI$2(SettingsActiveTimeUI settingsActiveTimeUI) {
        this.qiQ = settingsActiveTimeUI;
    }

    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        if (SettingsActiveTimeUI.a(this.qiQ)) {
            SettingsActiveTimeUI.a(this.qiQ, i);
            SettingsActiveTimeUI.b(this.qiQ, i2);
            SettingsActiveTimeUI.b(this.qiQ);
        } else {
            SettingsActiveTimeUI.c(this.qiQ, i);
            SettingsActiveTimeUI.d(this.qiQ, i2);
            SettingsActiveTimeUI.c(this.qiQ);
        }
        this.qiQ.initView();
    }
}
