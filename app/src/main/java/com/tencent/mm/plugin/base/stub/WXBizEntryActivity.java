package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.plugin.base.stub.e.1;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.u;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

public class WXBizEntryActivity extends AutoLoginActivity {
    private int kuT;

    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] kuV = new int[a.values().length];

        static {
            try {
                kuV[a.vjh.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kuV[a.vjj.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kuV[a.vji.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(0);
    }

    protected final int getLayoutId() {
        return R.i.dbq;
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        Uri uri = null;
        x.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + aVar);
        if (getIntent() != null) {
            this.kuT = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (AnonymousClass5.kuV[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[]{Integer.valueOf(this.kuT)});
                Intent intent2;
                Uri data;
                switch (this.kuT) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                        startActivity(intent2);
                        finish();
                        return;
                    case 9:
                        d.a(this, "card", ".ui.CardAddEntranceUI", getIntent(), false);
                        finish();
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        d.a(this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2, false);
                        finish();
                        return;
                    case 12:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e) {
                            x.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[]{e.getMessage()});
                        }
                        if (uri != null && com.tencent.mm.pluginsdk.d.Rf(uri.toString())) {
                            u.GK().hy("key_data_center_session_id");
                            com.tencent.mm.pluginsdk.d.a(this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new 3(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        d.a(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2, false);
                        finish();
                        return;
                    case 14:
                    case 15:
                        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new 1(this)).aqV();
                        return;
                    case 16:
                        d.a(this, "card", ".ui.CardListSelectedUI", getIntent(), false);
                        finish();
                        return;
                    case 17:
                        try {
                            data = getIntent().getData();
                            Runnable 2 = new 2(this);
                            String stringExtra = getIntent().getStringExtra("key_package_name");
                            String stringExtra2 = getIntent().getStringExtra("key_package_signature");
                            int intExtra = getIntent().getIntExtra("translate_link_scene", 1);
                            x.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[]{stringExtra, stringExtra2});
                            if (bh.ov(stringExtra) || bh.ov(stringExtra2)) {
                                x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            cl clVar = new cl();
                            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[]{stringExtra});
                            clVar.vHA = stringExtra;
                            clVar.signature = stringExtra2;
                            linkedList.add(clVar);
                            k akVar = new ak(data.toString(), intExtra, linkedList);
                            ar.CG().a(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new 1(this, 2));
                            ar.CG().a(akVar, 0);
                            return;
                        } catch (Exception e2) {
                            x.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[]{e2.getMessage()});
                            return;
                        }
                    case 19:
                        try {
                            data = getIntent().getData();
                        } catch (Exception e22) {
                            x.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[]{e22.getMessage()});
                            data = uri;
                        }
                        if (data != null) {
                            com.tencent.mm.pluginsdk.d.a(this, data.toString(), getIntent().getIntExtra("translate_link_scene", 1), new 4(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    default:
                        finish();
                        return;
                }
            case 2:
            case 3:
                x.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                x.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }
}
