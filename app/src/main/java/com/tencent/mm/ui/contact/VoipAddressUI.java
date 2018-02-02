package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private List<String> kiU;
    private String talker = "";
    private boolean yUW = false;
    private boolean yUX = false;
    private c yUY = new 1(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.xef.b(this.yUY);
    }

    public final void ja(int i) {
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.prJ.getAdapter().getItem(i);
        if (aVar != null && aVar.jLe != null) {
            this.talker = aVar.jLe.field_username;
            if (this.yUX) {
                bjC();
            } else {
                bjB();
            }
        }
    }

    private void bjB() {
        x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bh.cgy(), this});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            b spVar = new sp();
            spVar.fKq.fuL = 5;
            spVar.fKq.talker = this.talker;
            spVar.fKq.context = this;
            int i = this.yUW ? 2 : 1;
            spVar.fKq.fKl = 3;
            g.pQN.h(11033, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0)});
            a.xef.m(spVar);
            aWs();
        }
    }

    private void bjC() {
        x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")), bh.cgy(), this});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")) {
            x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bh.cgy(), this});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")) {
                b spVar = new sp();
                spVar.fKq.fuL = 5;
                spVar.fKq.talker = this.talker;
                spVar.fKq.context = this;
                int i = this.yUW ? 2 : 1;
                spVar.fKq.fKl = 2;
                g.pQN.h(11033, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0)});
                a.xef.m(spVar);
                aWs();
            }
        }
    }

    protected final void WT() {
        super.WT();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.yUX = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.yUW = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.yUX = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.yUX = false;
            }
        }
        this.kiU = new ArrayList();
        this.kiU.addAll(s.cwj());
        this.kiU.addAll(s.cwk());
    }

    protected final o WX() {
        c.a aVar = new c.a();
        aVar.yQX = true;
        aVar.yQW = true;
        return new c(this, this.kiU, false, aVar);
    }

    protected final m WY() {
        return new q(this, this.kiU, false, this.scene);
    }

    public static void fR(Context context) {
        int i = 0;
        boolean z = 1 == bh.getInt(com.tencent.mm.k.g.zY().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(R.l.dDo));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(11034, objArr);
    }

    protected final boolean WV() {
        return true;
    }

    public final int[] aXV() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public void onDestroy() {
        a.xef.c(this.yUY);
        super.onDestroy();
    }

    protected final void aXW() {
        if (this.yUW) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        aWs();
        finish();
    }

    protected final String WW() {
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (bh.ov(stringExtra)) {
            return stringExtra;
        }
        return getString(R.l.dDo);
    }

    protected final boolean WU() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bjC();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ;
                if (iArr[0] != 0) {
                    h.a(this, getString(i2), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
                return;
            case 82:
                if (iArr[0] == 0) {
                    bjB();
                    return;
                } else {
                    h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 4(this), null);
                    return;
                }
            default:
                return;
        }
    }
}
