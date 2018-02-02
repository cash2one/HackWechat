package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.webview.ui.tools.game.a.2;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.webview.wepkg.a;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameWebViewUI extends GameBaseWebViewUI {
    private static String tFx = "wx_fullscreen";
    private Map<Integer, aqy> mZV = new HashMap();
    private boolean nbV = false;
    private Drawable tFA;
    private String tFB = null;
    private String tFC;
    private GameMenuImageButton tFD;
    private boolean tFE;
    private boolean tFF = false;
    private boolean tFG = false;
    private boolean tFH = false;
    private BroadcastReceiver tFI = new 8(this);
    private a tFk;
    private int tFv;
    private boolean tFw = false;
    private HashMap<String, String> tFy = new HashMap();
    private Drawable tFz;

    static /* synthetic */ void J(GameWebViewUI gameWebViewUI) {
        if (gameWebViewUI.typ != null) {
            gameWebViewUI.typ.setVisibility(8);
        }
    }

    static /* synthetic */ void af(GameWebViewUI gameWebViewUI) {
        gameWebViewUI.tFw = false;
        gameWebViewUI.AW(255);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.Wepkg.GameWebViewUI", "GameWebViewUI oncreate");
        x.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[]{d.Qs(this.fIG), d.Qq(this.fIG)});
        Intent intent = getIntent();
        if (intent != null) {
            b.tNW = intent.getBooleanExtra("disable_wepkg", false);
            if (intent.getBooleanExtra("disable_progress_bar", false)) {
                this.tyo.yaf = false;
                bUi();
            }
        }
        this.tzX = new 10(this);
        if (!bh.ov(this.fIG)) {
            try {
                a(new URI(this.fIG));
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.GameWebViewUI", "parseUrl error, %s,  rawUrl = %s", new Object[]{e.getMessage(), this.fIG});
            }
        }
        this.tFv = bSz();
        if (this.tFy.containsKey(tFx) && ((String) this.tFy.get(tFx)).equals("1")) {
            this.nbV = true;
        }
        this.ptK.setWebViewClient(new b(this, (byte) 0));
        if (this.ptK.isX5Kernel) {
            this.ptK.setWebViewClientExtension(new a(this, (byte) 0));
        }
        this.tFk = new a(this, this.ptK);
        this.tFk.tLt = new 1(this);
        if (this.tFk.PN(this.fIG)) {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.tFF = true;
            bUi();
        }
        this.tEZ = new a(this, this.tyu);
        this.tFD = new GameMenuImageButton(this.mController.xIM);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_RELOAD");
        registerReceiver(this.tFI, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
    }

    private n aPA() {
        try {
            List list;
            List list2 = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.tFL;
            Bundle bundle = new Bundle();
            bundle.putString("game_hv_menu_appid", this.tFC);
            if (this.juQ != null) {
                bundle = this.juQ.e(92, bundle);
            } else {
                bundle = null;
            }
            if (bundle != null) {
                String string = bundle.getString("game_hv_menu_pbcache");
                if (!bh.ov(string)) {
                    byte[] bytes = string.getBytes("ISO-8859-1");
                    ajq com_tencent_mm_protocal_c_ajq = new ajq();
                    com_tencent_mm_protocal_c_ajq.aF(bytes);
                    if (!bh.cA(com_tencent_mm_protocal_c_ajq.wqI)) {
                        LinkedList linkedList = com_tencent_mm_protocal_c_ajq.wqI;
                        x.i("MicroMsg.Wepkg.GameWebViewUI", "use net menu data");
                        list = linkedList;
                        this.mZV.clear();
                        for (aqy com_tencent_mm_protocal_c_aqy : r2) {
                            this.mZV.put(Integer.valueOf(com_tencent_mm_protocal_c_aqy.wyO), com_tencent_mm_protocal_c_aqy);
                        }
                        return c.bUj().i(r2, Vb());
                    }
                }
            }
            list = list2;
            this.mZV.clear();
            for (aqy com_tencent_mm_protocal_c_aqy2 : r2) {
                this.mZV.put(Integer.valueOf(com_tencent_mm_protocal_c_aqy2.wyO), com_tencent_mm_protocal_c_aqy2);
            }
            return c.bUj().i(r2, Vb());
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[]{e.getMessage()});
            return null;
        }
    }

    protected final void aPz() {
        if (this.tFD == null || !this.tFD.tFM) {
            super.aPz();
            return;
        }
        com.tencent.mm.plugin.webview.ui.tools.game.menu.d dVar = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(this.mController.xIM);
        dVar.a(new 3(this));
        dVar.tGf = new 4(this);
        if (this.tyw) {
            dVar.tGk = true;
            dVar.tGl = true;
        } else {
            dVar.tGk = false;
            dVar.tGl = false;
        }
        if (this.tyA == null || !this.tyA.isShown()) {
            aWs();
            ag.h(new 6(this, dVar), 100);
            return;
        }
        this.tyA.hide();
        ag.h(new 5(this, dVar), 100);
    }

    protected final void cA(String str, int i) {
        super.cA(str, i);
    }

    protected final int bSH() {
        return super.bSH();
    }

    protected final void U(Bundle bundle) {
        super.U(bundle);
    }

    protected final void akN() {
        super.akN();
        this.tFE = true;
        try {
            boolean z;
            Bundle e = this.juQ.e(j.CTRL_INDEX, null);
            e.setClassLoader(GameSettingParams.class.getClassLoader());
            GameSettingParams gameSettingParams = (GameSettingParams) e.getParcelable("game_setting_params");
            if (!this.nbV && this.nmr == null && this.nmq == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!bh.ov(gameSettingParams.fxA)) {
                    try {
                        this.nmq = Color.parseColor(gameSettingParams.fxA);
                    } catch (IllegalArgumentException e2) {
                        x.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + e2.getMessage());
                    }
                }
                this.nmr = gameSettingParams.fxB;
                bSD();
                kt(true);
            }
        } catch (Exception e3) {
            x.e("MicroMsg.Wepkg.GameWebViewUI", e3.getMessage());
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            this.tFB = intent.getStringExtra("game_transparent_float_url");
            if (bh.ov(this.tFB)) {
                intent = new Intent();
                intent.putExtra("game_check_float", true);
                intent.putExtra("game_sourceScene", intExtra);
                com.tencent.mm.bm.d.b(this, "game", ".ui.GameCenterUI", intent);
                return;
            }
            try {
                e = new Bundle();
                e.putInt("game_sourceScene", intExtra);
                if (this.juQ != null) {
                    this.juQ.e(91, e);
                }
                a aVar = this.tEZ;
                String str = this.tFB;
                aVar.mXZ = str;
                aVar.tFk.PN(str);
                if (aVar.juE != null && aVar.juE.getParent() == null) {
                    aVar.Fl.addView(aVar.juE, new LayoutParams(-1, -1));
                }
                if (!(aVar.juE == null || aVar.tFl == null)) {
                    aVar.juE.post(new 2(aVar, str));
                }
                this.tFB = null;
            } catch (RemoteException e4) {
            }
        }
    }

    protected final void kt(boolean z) {
        super.kt(z);
        kw(false);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (this.tFE) {
            super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        this.tFk.onDestroy();
        unregisterReceiver(this.tFI);
    }

    public void initView() {
        super.initView();
        this.tFz = new ColorDrawable(android.support.v4.content.a.c(this, R.e.brg));
        this.tFA = new ColorDrawable(android.support.v4.content.a.c(this, R.e.brg));
    }

    protected final void bSI() {
        super.bSI();
        this.tFC = getIntent().getStringExtra("game_hv_menu_appid");
        if (this.tyw && !bh.ov(this.tFC)) {
            if (this.tyv != null) {
                this.tyv.setVisibility(8);
            }
            this.tFD.a(this.tyt, new GameMenuImageButton.a(this) {
                final /* synthetic */ GameWebViewUI tFJ;

                {
                    this.tFJ = r1;
                }

                public final void aPy() {
                    this.tFJ.aPz();
                }
            });
        }
    }

    protected final boolean Pl(String str) {
        return this.tFk.PO(str);
    }

    protected final void BO(String str) {
        if (!this.tFk.bUY()) {
            super.BO(str);
        } else if (this.ptK != null) {
            this.ptK.loadUrl(str);
        }
    }

    protected final void afg() {
        if (VERSION.SDK_INT <= 10) {
            super.afg();
        } else if (this.screenOrientation == -1) {
            this.xIo = getSharedPreferences(ac.cfs(), 4).getBoolean("settings_landscape_mode", false);
            if (this.xIo) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    protected final void bSU() {
        this.tFG = true;
        if (this.tFH) {
            bUd();
        }
    }

    private void bUi() {
        if (this.typ != null) {
            this.typ.setVisibility(0);
        }
    }

    private void bUd() {
        this.tFG = false;
        this.tFH = false;
        if (this.tFF) {
            ag.h(new Runnable(this) {
                final /* synthetic */ GameWebViewUI tFJ;

                {
                    this.tFJ = r1;
                }

                public final void run() {
                    if (this.tFJ.ptK != null) {
                        if (this.tFJ.tFk != null) {
                            this.tFJ.tFk.bUX();
                        }
                        x.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", new Object[]{this.tFJ.mFa});
                        this.tFJ.ptK.stopLoading();
                        this.tFJ.ptK.loadUrl(this.tFJ.mFa);
                    }
                }
            }, 100);
        } else {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "no use wepkg, dont reload");
        }
    }

    private void a(URI uri) {
        String[] split = bh.ou(uri.getQuery()).split("&");
        if (split != null && split.length != 0) {
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    this.tFy.put(split3[0], split3[1]);
                }
            }
        }
    }

    protected final boolean bSy() {
        return true;
    }

    protected final void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        super.a(viewGroup, windowInsets);
        if (this.nbV && this.ptK.isX5Kernel) {
            this.tFw = true;
            this.tyx = true;
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(this.tFz);
                this.tFz.setAlpha(0);
                if (supportActionBar.getCustomView() != null) {
                    supportActionBar.getCustomView().setBackground(this.tFA);
                    this.tFA.setAlpha(0);
                    supportActionBar.getCustomView().invalidate();
                }
            }
            setStatusBarColor(0);
            if (this.nmo != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nmo.getLayoutParams();
                marginLayoutParams.topMargin = this.jNd;
                this.nmo.setLayoutParams(marginLayoutParams);
            }
            DP(8);
        }
    }

    protected boolean bSB() {
        return true;
    }

    private void AW(int i) {
        if (i < 10) {
            DP(8);
        } else {
            DP(0);
        }
        if (i < 255) {
            this.tFw = true;
        } else {
            this.tFw = false;
        }
        if (this.tFz != null) {
            this.tFz.setAlpha(i);
        }
    }
}
