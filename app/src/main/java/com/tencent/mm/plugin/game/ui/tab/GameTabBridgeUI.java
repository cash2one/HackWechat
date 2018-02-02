package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameTabBridgeUI extends GameCenterActivity {
    private BroadcastReceiver nwL = new BroadcastReceiver(this) {
        final /* synthetic */ GameTabBridgeUI nwM;

        {
            this.nwM = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && this.nwM != null && !this.nwM.isFinishing()) {
                x.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
                this.nwM.finish();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[]{getClass().getSimpleName()});
        GameTabWidget.nwR = hashCode();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nwL, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
        Intent intent = getIntent();
        GameTabData gameTabData = (GameTabData) intent.getParcelableExtra("tab_data");
        String stringExtra = intent.getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(R.h.cQb);
        a aVar = new a(this);
        gameTabWidget.a(aVar);
        aVar.a(gameTabData, stringExtra);
        intent.setComponent((ComponentName) intent.getParcelableExtra("next_tab_component"));
        f.a("com.tencent.mm:tools", null, GameTabWidget.a.class, new 1(this, System.currentTimeMillis(), intent));
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameTabBridgeUI nwM;

            {
                this.nwM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nwM.goBack();
                return true;
            }
        });
        setMMTitle(R.l.enh);
    }

    protected void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = false;
        }
    }

    protected final boolean aRq() {
        return false;
    }

    public final int aRr() {
        return 0;
    }

    public final int aRs() {
        return 0;
    }

    public final int aRt() {
        return 0;
    }

    protected final int getLayoutId() {
        return R.i.djv;
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.nwL);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        x.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
        if (bh.ou(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.bqz, R.a.bqC);
            x.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}
