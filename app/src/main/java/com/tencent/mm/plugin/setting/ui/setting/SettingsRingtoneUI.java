package com.tencent.mm.plugin.setting.ui.setting;

import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;

public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    private Cursor BA;
    private af mHandler;
    private RingtoneManager qkE;
    LayoutInflater qkF;
    private int qkG = -1;
    private int qkH = -1;
    private Ringtone qkI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new af();
        this.qkF = LayoutInflater.from(this);
        this.qkE = new RingtoneManager(this);
        this.qkE.setType(2);
        setVolumeControlStream(5);
        this.qkI = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        setMMTitle(R.l.eMg);
        setBackBtn(new 1(this));
        a(0, getString(R.l.eLA), new 2(this), b.xJz);
        ListView listView = (ListView) findViewById(R.h.cMy);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvv);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.BA = this.qkE.getCursor();
        listView.setAdapter(new a(this, this.BA));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String zs = f.zs();
        if (zs != f.gHY) {
            int ringtonePosition = this.qkE.getRingtonePosition(Uri.parse(zs));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.qkG = ringtonePosition;
            if (this.qkG == 1) {
                getSharedPreferences(ac.cfs(), 0).edit().putString("settings.ringtone.name", getString(R.l.eMf)).commit();
                x.d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.qkH = this.qkG - 1;
        } else {
            this.qkG = 1;
        }
        listView.setItemChecked(this.qkG, true);
        listView.setSelection(this.qkG);
    }

    protected final int getLayoutId() {
        return R.i.dsf;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mHandler.removeCallbacks(this);
        this.qkH = i - 1;
        this.mHandler.postDelayed(this, 300);
    }

    public void run() {
        if (!isFinishing()) {
            Ringtone ringtone;
            if (this.qkH == 0) {
                ringtone = this.qkI;
            } else {
                ringtone = this.qkE.getRingtone(this.qkH - 1);
            }
            if (ringtone != null) {
                try {
                    ringtone.play();
                } catch (Throwable e) {
                    x.printErrStackTrace("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
                }
            }
        }
    }

    protected void onStop() {
        this.qkE.stopPreviousRingtone();
        super.onStop();
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacks(this);
        if (!(this.BA == null || this.BA.isClosed())) {
            this.BA.close();
            this.BA = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyUp(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
