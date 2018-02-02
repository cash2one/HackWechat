package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.plugin.backup.a.g;
import java.util.Date;

class BackupSelectExtUI$1 implements OnDateSetListener {
    final /* synthetic */ BackupSelectExtUI kqi;
    final /* synthetic */ int val$id;

    BackupSelectExtUI$1(BackupSelectExtUI backupSelectExtUI, int i) {
        this.kqi = backupSelectExtUI;
        this.val$id = i;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        StringBuffer append = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)}));
        long vq;
        BackupSelectExtUI backupSelectExtUI;
        boolean z;
        switch (this.val$id) {
            case 1:
                vq = g.vq(append.append("000000").toString());
                BackupSelectExtUI.a(this.kqi, (vq / 1000) * 1000);
                BackupSelectExtUI.b(this.kqi).setSummary(BackupSelectExtUI.a(this.kqi).format(new Date(vq)));
                BackupSelectExtUI.c(this.kqi).notifyDataSetChanged();
                backupSelectExtUI = this.kqi;
                z = (BackupSelectExtUI.d(this.kqi) == 0 || BackupSelectExtUI.e(this.kqi) == 0) ? false : true;
                backupSelectExtUI.enableOptionMenu(z);
                return;
            case 2:
                vq = g.vq(append.append("000000").toString());
                BackupSelectExtUI.b(this.kqi, ((vq / 1000) * 1000) + 86400000);
                BackupSelectExtUI.f(this.kqi).setSummary(BackupSelectExtUI.a(this.kqi).format(new Date(vq)));
                BackupSelectExtUI.c(this.kqi).notifyDataSetChanged();
                backupSelectExtUI = this.kqi;
                z = (BackupSelectExtUI.d(this.kqi) == 0 || BackupSelectExtUI.e(this.kqi) == 0) ? false : true;
                backupSelectExtUI.enableOptionMenu(z);
                return;
            default:
                return;
        }
    }
}
