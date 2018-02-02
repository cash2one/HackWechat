package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class SettingsRingtoneUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsRingtoneUI qkJ;

    SettingsRingtoneUI$2(SettingsRingtoneUI settingsRingtoneUI) {
        this.qkJ = settingsRingtoneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String uri;
        Editor edit = this.qkJ.getSharedPreferences(ac.cfs(), 0).edit();
        if (SettingsRingtoneUI.a(this.qkJ) != 0) {
            Uri a = SettingsRingtoneUI.a(this.qkJ, SettingsRingtoneUI.a(this.qkJ));
            x.d("RingtonePickerActivity", "set ringtone to " + a);
            if (a != null) {
                uri = a.toString();
                String a2 = SettingsRingtoneUI.a(this.qkJ, a);
                edit.putString("settings.ringtone.name", a2);
                x.d("RingtonePickerActivity", "ringtone name: " + a2);
            } else {
                uri = f.gHY;
                edit.putString("settings.ringtone.name", this.qkJ.getString(R.l.eMf));
                x.d("RingtonePickerActivity", "set ringtone follow system");
            }
        } else {
            uri = f.gHY;
            edit.putString("settings.ringtone.name", this.qkJ.getString(R.l.eMf));
            x.d("RingtonePickerActivity", "set ringtone follow system");
        }
        edit.commit();
        f.eO(uri);
        this.qkJ.finish();
        return true;
    }
}
