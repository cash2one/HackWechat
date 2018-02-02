package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.a;
import com.tencent.mm.plugin.game.model.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.model.GameWebViewLaunchParams;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class GameWebViewUI extends MMActivity {
    protected c mYs;
    protected int nao = -1;
    private boolean nap;
    private boolean naq;
    GameSettingParams nar;

    static /* synthetic */ void a(GameWebViewUI gameWebViewUI) {
        b bVar = (b) gameWebViewUI.mYs.mYw.peek();
        if (bVar != null) {
            bVar.mWG.aPm();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameWebViewUI", "onCreate");
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        final GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 10;
        commonLogicTask.mVP = new Runnable(this) {
            final /* synthetic */ GameWebViewUI nat;

            public final void run() {
                commonLogicTask.afj();
                commonLogicTask.msB.setClassLoader(GameSettingParams.class.getClassLoader());
                this.nat.nar = (GameSettingParams) commonLogicTask.msB.getParcelable("game_setting_params");
                GameWebViewUI.a(this.nat);
            }
        };
        commonLogicTask.afi();
        GameWebViewMainProcessService.a(commonLogicTask);
        this.nap = getIntent().getBooleanExtra("disable_swipe_back", false);
        initView();
    }

    public void onNewIntent(Intent intent) {
        x.i("MicroMsg.GameWebViewUI", "onNewIntent: " + System.currentTimeMillis());
        d(intent, false);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.GameWebViewUI", "onResume");
        if (getSwipeBackLayout() != null) {
            if (this.nap) {
                getSwipeBackLayout().mEnable = false;
            } else {
                getSwipeBackLayout().mEnable = this.naq;
            }
        }
        afg();
        b bVar = (b) this.mYs.mYw.peek();
        if (bVar != null) {
            bVar.aes();
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.GameWebViewUI", "onPause");
        b bVar = (b) this.mYs.mYw.peek();
        if (bVar != null) {
            bVar.fv(true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.GameWebViewUI", "onDestroy");
        a.cleanup();
        this.mYs.cleanup();
        System.gc();
    }

    protected void initView() {
        View frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(17170443);
        frameLayout.setId(R.h.ckI);
        setContentView(frameLayout);
        this.mYs = new c(this);
        this.mYs.setBackgroundResource(17170443);
        this.mYs.setId(R.h.ckS);
        frameLayout.addView(this.mYs);
        d(getIntent(), true);
    }

    private void d(Intent intent, boolean z) {
        x.d("MicroMsg.GameWebViewUI", "loadIntent: " + System.currentTimeMillis());
        setIntent(intent);
        this.mYs.c(intent, z);
        this.nao = intent.getIntExtra("screen_orientation", -1);
        intent.setExtrasClassLoader(GameWebViewLaunchParams.class.getClassLoader());
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) intent.getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams != null) {
            final GameFloatLayerInfo gameFloatLayerInfo = gameWebViewLaunchParams.nes;
            if (gameFloatLayerInfo != null) {
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ GameWebViewUI nat;

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", gameFloatLayerInfo.url);
                        intent.putExtra("show_full_screen", gameFloatLayerInfo.nbV);
                        intent.putExtra("screen_orientation", gameFloatLayerInfo.orientation);
                        intent.putExtra("transparent_page", true);
                        intent.putExtra("needAnimation", false);
                        this.nat.d(intent, false);
                    }
                }, 200);
            }
        }
        if (aPP()) {
            d.cH(this.mController.xIM);
        } else {
            d.cI(this.mController.xIM);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        this.mYs.fw(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mYs.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mYs != null) {
            Object obj;
            b bVar = (b) this.mYs.mYw.peek();
            if (bVar != null) {
                d dVar = bVar.mWG;
                if (dVar.mZf == null || !dVar.mZf.b(dVar.mYx, i, i2, intent)) {
                    if (dVar.mYI != null) {
                        e eVar = dVar.mYI;
                        if (eVar.mZR != null ? eVar.mZR.onActivityResult(i, i2, intent) : false) {
                            int i3 = 1;
                        }
                    }
                    obj = null;
                } else {
                    obj = 1;
                }
            } else {
                obj = null;
            }
            if (obj == null) {
            }
        }
    }

    public final void K(final Intent intent) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ GameWebViewUI nat;

            public final void run() {
                this.nat.d(intent, false);
            }
        });
    }

    public final void qJ(int i) {
        if (!this.nap && getSwipeBackLayout() != null) {
            if (aPP() || i > 1) {
                this.naq = false;
                getSwipeBackLayout().mEnable = false;
                return;
            }
            this.naq = true;
            getSwipeBackLayout().mEnable = true;
        }
    }

    private boolean aPP() {
        return getIntent().getBooleanExtra("from_shortcut", false);
    }

    protected final void afg() {
        if (this.nao != -1) {
            setRequestedOrientation(this.nao);
            return;
        }
        this.xIo = getSharedPreferences(ac.cfs(), 4).getBoolean("settings_landscape_mode", false);
        if (this.xIo) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    public final void qK(int i) {
        this.nao = i;
        afg();
    }
}
