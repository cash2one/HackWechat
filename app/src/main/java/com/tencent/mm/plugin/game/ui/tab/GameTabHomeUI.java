package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabHomeUI extends GameCenterUI5 {
    private BroadcastReceiver nwL = new 2(this);
    public String nwO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabHomeUI", "%s create", new Object[]{getClass().getSimpleName()});
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nwO = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(R.h.cQb);
        a aVar = new a(this);
        gameTabWidget.a(aVar);
        aVar.a(gameTabData, this.nwO);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nwL, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (!bh.ou(this.nwO).equals(intent.getStringExtra("tab_key"))) {
                x.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", new Object[]{getClass().getSimpleName(), this.nwO, intent.getStringExtra("tab_key")});
                finish();
                startActivity(intent);
            }
            overridePendingTransition(R.a.bqe, R.a.bqe);
        }
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
        x.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
        if (bh.ou(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.bqz, R.a.bqC);
            x.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}
