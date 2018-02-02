package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.z.q;

public class SettingsFontUI extends MMActivity {
    private int qjl = 0;
    private int qjm = 2;
    private int qjn = a.fromDPToPix(ac.getContext(), R.f.bwU);
    final float qjo = SetTextSizeUI.dt(this.mController.xIM);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsb;
    }

    protected final void initView() {
        setMMTitle(R.l.eNs);
        x.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.qjo);
        TextView textView = (TextView) findViewById(R.h.cMp);
        TextView textView2 = (TextView) findViewById(R.h.cMn);
        TextView textView3 = (TextView) findViewById(R.h.cMo);
        b.a((ImageView) findViewById(R.h.bTw), q.FS());
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(R.h.ciW);
        float dt = SetTextSizeUI.dt(this.mController.xIM);
        if (dt < 0.875f || dt > 2.025f) {
            dt = 1.0f;
        }
        int i = dt == 0.875f ? 0 : dt == 1.125f ? 2 : dt == 1.25f ? 3 : dt == 1.375f ? 4 : dt == 1.625f ? 5 : dt == 1.875f ? 6 : dt == 2.025f ? 7 : 1;
        fontSelectorView.qmR = i;
        fontSelectorView.qmS = new 1(this, textView, textView2, textView3);
        setBackBtn(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        g.pQN.h(11609, new Object[]{Integer.valueOf(this.qjl), Integer.valueOf(this.qjm), Integer.valueOf(0)});
        x.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[]{Integer.valueOf(11609), Integer.valueOf(this.qjl), Integer.valueOf(this.qjm)});
        finish();
        ap(this.qjo);
        return true;
    }

    private void ap(float f) {
        float f2 = this.mController.xIM.getSharedPreferences(ac.cfs(), 0).getFloat("current_text_size_scale_key", 1.0f);
        x.i("MicroMsg.SettingsFontUI", "fontSizeAfter=" + f2);
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.a.ifs.s(intent, this.mController.xIM);
            com.tencent.mm.sdk.b.b gfVar = new gf();
            gfVar.fwo.fwp = f;
            gfVar.fwo.fwq = f2;
            com.tencent.mm.sdk.b.a.xef.m(gfVar);
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent2.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ac.getContext().sendBroadcast(intent2);
        }
    }
}
