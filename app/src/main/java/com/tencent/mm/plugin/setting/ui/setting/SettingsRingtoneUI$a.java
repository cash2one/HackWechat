package com.tencent.mm.plugin.setting.ui.setting;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class SettingsRingtoneUI$a extends BaseAdapter {
    int count = 0;
    Cursor ftn;
    int padding = 0;
    final /* synthetic */ SettingsRingtoneUI qkJ;

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public SettingsRingtoneUI$a(SettingsRingtoneUI settingsRingtoneUI, Cursor cursor) {
        this.qkJ = settingsRingtoneUI;
        this.ftn = cursor;
        this.count = cursor.getCount() + 1;
        x.d("RingtonePickerActivity", "count = " + this.count);
        this.padding = settingsRingtoneUI.getResources().getDimensionPixelSize(R.f.bvJ);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) this.qkJ.qkF.inflate(R.i.select_dialog_singlechoice, null);
        if (i == 0) {
            checkedTextView.setBackgroundResource(R.g.bBx);
            checkedTextView.setText(R.l.eMf);
        } else {
            checkedTextView.setBackgroundResource(R.g.bBx);
            checkedTextView.setText(kC(i));
        }
        checkedTextView.setPadding(this.padding, 0, this.padding, 0);
        checkedTextView.setCheckMarkDrawable(R.g.bFs);
        return checkedTextView;
    }

    public final int getCount() {
        return this.count;
    }

    private String kC(int i) {
        if (this.ftn.isClosed() || !this.ftn.moveToPosition(i - 1)) {
            return "";
        }
        return this.ftn.getString(this.ftn.getColumnIndex("title"));
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
