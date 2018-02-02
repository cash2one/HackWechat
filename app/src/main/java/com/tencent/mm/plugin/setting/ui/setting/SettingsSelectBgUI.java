package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.m;
import com.tencent.mm.az.a;
import com.tencent.mm.az.b;
import com.tencent.mm.az.j;
import com.tencent.mm.az.k;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public class SettingsSelectBgUI extends MMActivity implements e {
    private boolean qjg;
    private a qkU;
    private GridView qkV;
    private j qkW;
    private List<j> qkX = new ArrayList();
    private ak qkY = new ak(new 1(this), true);
    private String username;

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.qkU = new a(settingsSelectBgUI, settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.qkV = (GridView) settingsSelectBgUI.findViewById(R.h.cMz);
        r.QH().c(settingsSelectBgUI.qkU);
        settingsSelectBgUI.qkV.setAdapter(settingsSelectBgUI.qkU);
        settingsSelectBgUI.qkV.setOnItemClickListener(new 3(settingsSelectBgUI));
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI, int i) {
        ar.Hg();
        c.CU().set(66820, Integer.valueOf(i));
        g.pQN.h(10198, new Object[]{Integer.valueOf(i)});
        x.i("MicroMsg.SettingsSelectBgUI", "set chating bg id:%d", new Object[]{Integer.valueOf(i)});
        if (settingsSelectBgUI.qjg) {
            ar.Hg();
            c.CU().set(12311, Integer.valueOf(i));
            r.QH().ii(1);
            return;
        }
        b QI = r.QI();
        a lM = QI.lM(settingsSelectBgUI.username);
        if (lM == null) {
            lM = new a();
            lM.username = settingsSelectBgUI.username;
            lM.hJl = i;
            QI.a(lM);
            return;
        }
        lM.hJl = i;
        QI.b(lM);
    }

    static /* synthetic */ void e(int i, List list) {
        for (j jVar : list) {
            if (jVar.hJE == i) {
                r.QH().bi(jVar.hJE, 1);
                list.remove(jVar);
                return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dsh;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.CG().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        ar.CG().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
        ar.Hg();
        if (c.isSDCardAvailable()) {
            ar.CG().a(new k(1), 0);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qkW != null) {
            ar.CG().c(this.qkW);
            r.QH().bi(this.qkW.hJE, 1);
        }
        List<j> list = this.qkX;
        for (j jVar : list) {
            r.QH().bi(jVar.hJE, 1);
        }
        list.clear();
        ar.CG().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        ar.CG().b(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
        this.qkU.aUn();
        r.QH().j(this.qkU);
    }

    protected final void initView() {
        setMMTitle(R.l.eLd);
        setBackBtn(new 2(this));
        this.qjg = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra("username");
        this.qkY.J(20, 20);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if ((kVar instanceof m) && ((m) kVar).Kl() == 1) {
            int type = kVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX || type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                    bG(this.qkX);
                }
                if (i == 0 && i2 != 0) {
                    return;
                }
                return;
            }
            return;
        }
        x.d("MicroMsg.SettingsSelectBgUI", "another scene");
    }

    private void bG(List<j> list) {
        if (list.size() > 0) {
            this.qkW = (j) list.remove(0);
            ar.CG().a(this.qkW, 0);
            return;
        }
        this.qkW = null;
    }
}
