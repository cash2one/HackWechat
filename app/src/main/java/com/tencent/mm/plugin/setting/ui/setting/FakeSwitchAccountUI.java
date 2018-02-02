package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a(3)
public class FakeSwitchAccountUI extends MMActivity {
    private int count;
    private String country;
    private int gyP;
    private SwitchAccountGridView qgU;
    private View qgV;
    private View qgW;
    private String qgX;
    private ArrayList<SwitchAccountModel> qgY;
    private Map<String, SwitchAccountModel> qgZ = new HashMap();
    private ak qha;

    static /* synthetic */ void e(FakeSwitchAccountUI fakeSwitchAccountUI) {
        x.i("MicroMsg.FakeSwitchAccountUI", "jump to launcher");
        fakeSwitchAccountUI.qha.TG();
        Intent intent = new Intent();
        intent.setClassName(fakeSwitchAccountUI, "com.tencent.mm.ui.LauncherUI");
        intent.addFlags(67108864);
        intent.putExtra("LauncherUI.jump_switch_account", true);
        intent.putExtra("key_switch_from_wx_username", fakeSwitchAccountUI.qgX);
        intent.putParcelableArrayListExtra("key_switch_account_users", fakeSwitchAccountUI.qgY);
        fakeSwitchAccountUI.startActivity(intent);
        fakeSwitchAccountUI.finish();
        b.fH(fakeSwitchAccountUI);
    }

    protected final int getLayoutId() {
        return R.i.dsj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.country = getIntent().getStringExtra("key_langauage_code");
        if (!bh.ov(this.country)) {
            x.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[]{this.country});
            bd.setProperty("language_key", this.country);
            p.bn(ac.getContext(), this.country);
        }
        initView();
    }

    protected final void initView() {
        x.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
        setMMTitle("");
        getSupportActionBar().hide();
        this.qgU = (SwitchAccountGridView) findViewById(R.h.cPM);
        this.qgU.setRowCount(1);
        this.qgU.setClickable(false);
        this.gyP = getIntent().getIntExtra("key_mm_process_pid", 0);
        this.qgX = getIntent().getStringExtra("key_switch_from_wx_username");
        x.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[]{getResources().getString(R.l.eNp)});
        this.qgY = getIntent().getParcelableArrayListExtra("key_switch_account_users");
        if (this.qgY != null) {
            Iterator it = this.qgY.iterator();
            while (it.hasNext()) {
                SwitchAccountModel switchAccountModel = (SwitchAccountModel) it.next();
                this.qgZ.put(switchAccountModel.qge, switchAccountModel);
            }
        }
        this.qgV = findViewById(R.h.cPL);
        this.qgV.setVisibility(8);
        this.qgW = findViewById(R.h.cPJ);
        this.qgW.setVisibility(8);
        x.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[]{Integer.valueOf(this.qgZ.size())});
        this.qgU.qmZ = true;
        this.qgU.O(this.qgZ);
        this.qgU.qgX = this.qgX;
        this.qgU.qmY = true;
        this.qgU.brm();
        this.qha = new ak(Looper.myLooper(), new 1(this), true);
        if (this.qha != null) {
            this.qha.J(1500, 500);
        }
    }

    private int bqt() {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.tencent.mm")) {
                    x.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", new Object[]{runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid)});
                    return runningAppProcessInfo.pid;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + e.toString());
        } catch (Error e2) {
            x.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + e2.toString());
        }
        return 0;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
    }

    protected void onStop() {
        super.onStop();
        x.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
    }
}
