package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al$a;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class SnsGalleryUI extends SnsBaseGalleryUI implements a {
    private int rza = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        initView();
    }

    public void onDestroy() {
        int max;
        if (this.ryY != null) {
            this.ryY.bAY();
            this.ryY.onDestroy();
        }
        getWindow().clearFlags(FileUtils.S_IWUSR);
        al$a bvl = ae.bvl();
        String str = this.userName;
        if (bvl.qXk.containsKey(str)) {
            max = Math.max(((Integer) bvl.qXk.get(str)).intValue() - 1, 0);
            bvl.qXk.put(str, Integer.valueOf(max));
        } else {
            max = 0;
        }
        if (max <= 0) {
            bvl.qXj.remove(str);
        }
        ae.bvs().K(this);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.ryY != null) {
            this.ryY.aHq();
        }
    }

    protected final int getLayoutId() {
        return i$g.qHo;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.ryV.rti);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void initView() {
        List arrayList;
        an ciQ;
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.rza = getIntent().getIntExtra("sns_gallery_position", 0);
        x.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[]{u.ac("sns_table_", (long) intExtra), Integer.valueOf(this.rza)});
        ci(r0, this.rza);
        u(booleanExtra, 1);
        this.ryY = new SnsInfoFlip(this);
        this.ryY.rsA = true;
        al$a bvl = ae.bvl();
        String str = this.userName;
        if (bvl.qXk.containsKey(str)) {
            bvl.qXk.put(str, Integer.valueOf(((Integer) bvl.qXk.get(str)).intValue() + 1));
        } else {
            bvl.qXk.put(str, Integer.valueOf(0));
        }
        ArrayList arrayList2 = (ArrayList) bvl.qXj.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            Object obj = arrayList2;
        }
        this.ryY.rCa = true;
        this.ryY.rCc = true;
        this.ryY.rCd = false;
        this.ryY.a(arrayList, this.userName, this.rza, this.ryT, this);
        this.ryY.rCi = new 1(this);
        g.Dk();
        af WO = ((h) g.h(h.class)).EY().WO(this.userName);
        if (WO == null || ((int) WO.gJd) <= 0 || !com.tencent.mm.l.a.fZ(WO.field_type)) {
            if (this.userName.equals(q.FS())) {
                ciQ = an.ciQ();
            } else {
                ciQ = an.ciR();
            }
        } else {
            ciQ = an.ciP();
        }
        this.ryY.qQS = ciQ;
        this.ryY.username = this.userName;
        addView(this.ryY);
        setBackBtn(new 2(this));
        addIconOptionMenu(0, e.bDI, new 3(this, booleanExtra));
    }

    public final void ch(String str, int i) {
        if (this.ryY != null) {
            if (!(bh.ov(str) || i == 3)) {
                SnsInfoFlip snsInfoFlip = this.ryY;
                if (snsInfoFlip.hiv != null) {
                    int i2;
                    for (int i3 = 0; i3 >= 0; i3 = i2) {
                        i2 = i3;
                        while (i2 < snsInfoFlip.hiv.size()) {
                            b bVar = (b) snsInfoFlip.hiv.get(i2);
                            if (!bh.ov(bVar.raG) && bVar.raG.equals(str)) {
                                snsInfoFlip.hiv.remove(i2);
                                break;
                            }
                            i2++;
                        }
                        i2 = -1;
                    }
                    snsInfoFlip.rBT.notifyDataSetChanged();
                }
            }
            this.ryY.aHq();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String str;
            if (2 == i) {
                if (-1 == i2) {
                    aqr com_tencent_mm_protocal_c_aqr;
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    if (this.ryY != null) {
                        b bAW = this.ryY.bAW();
                        if (bAW.fHC.ktN == 6) {
                            com_tencent_mm_protocal_c_aqr = bAW.fHC;
                        } else {
                            return;
                        }
                    }
                    com_tencent_mm_protocal_c_aqr = null;
                    if (com_tencent_mm_protocal_c_aqr != null) {
                        String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                        str = "";
                        String str2 = "";
                        String j = i.j(com_tencent_mm_protocal_c_aqr);
                        if (FileOp.bO(r + j)) {
                            str2 = r + j;
                            str = r + i.e(com_tencent_mm_protocal_c_aqr);
                        }
                        if (FileOp.bO(r + i.p(com_tencent_mm_protocal_c_aqr))) {
                            j = r + i.p(com_tencent_mm_protocal_c_aqr);
                            r = r + i.n(com_tencent_mm_protocal_c_aqr);
                        } else {
                            j = str2;
                            r = str;
                        }
                        List<String> F = bh.F(stringExtra.split(","));
                        int JS = i.JS(j);
                        for (String str3 : F) {
                            x.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[]{str3, j, r, Integer.valueOf(JS)});
                            f.aZh().a(this, str3, j, r, 62, JS, "");
                            f.aZh().dj(stringExtra2, str3);
                        }
                        com.tencent.mm.ui.snackbar.a.h(this, getString(j.epb));
                    }
                }
            } else if (1 == i) {
                int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
                str = u.ac("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
                this.ryV.xr(intExtra);
                ch(str, 1);
                if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("sns_cmd_list", this.ryV.rti);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
    }
}
