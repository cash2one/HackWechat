package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabWebUI extends GameWebViewUI {
    private Activity activity;
    private BroadcastReceiver nwL = new 2(this);
    private String nwO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabWebUI", "%s create", new Object[]{getClass().getSimpleName()});
        this.activity = this;
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nwO = getIntent().getStringExtra("tab_key");
        View gameTabWidget = new GameTabWidget(this);
        a aVar = new a(this);
        gameTabWidget.a(aVar);
        aVar.a(gameTabData, this.nwO);
        ((LinearLayout) findViewById(R.h.cYR)).addView(gameTabWidget);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nwL, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameTabWebUI nwQ;

            {
                this.nwQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nwQ.goBack();
                return true;
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (!bh.ou(this.nwO).equals(intent.getStringExtra("tab_key"))) {
                x.i("MicroMsg.GameTabWebUI", "reload %s", new Object[]{this.activity.getClass().getSimpleName()});
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

    public void onBackPressed() {
        super.onBackPressed();
        goBack();
    }

    private void goBack() {
        x.i("MicroMsg.GameTabWebUI", "%s goBack!", new Object[]{this.activity.getClass().getSimpleName()});
        if (bh.ou(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.bqz, R.a.bqC);
            x.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}
