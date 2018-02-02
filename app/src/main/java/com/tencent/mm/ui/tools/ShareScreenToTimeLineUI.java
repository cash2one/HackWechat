package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        int a = t.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.wG();
                ar.CG().a(new bd(new 1(this)), 0);
                initView();
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void initView() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            cxA();
            finish();
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (bh.ov(action)) {
            x.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            cxA();
            finish();
            return;
        }
        String j = t.j(intent, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (bh.ov(resolveType)) {
            cxA();
            finish();
        } else if (!resolveType.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            cxA();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            x.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: " + action);
            if (bh.m(this.uri)) {
                this.filePath = bh.f(this, this.uri);
                if (!bh.ov(this.filePath) && bh.VV(this.filePath)) {
                    String str = this.filePath;
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    boolean b = p.b(str, decodeResultLogger);
                    if (!b && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        g.pQN.k(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
                    }
                    if (b) {
                        fQ(this.filePath, j);
                        return;
                    }
                    cxA();
                    finish();
                    return;
                } else if (t.a(intent, "Ksnsupload_empty_img", false)) {
                    fQ(this.filePath, j);
                    return;
                } else {
                    cxA();
                    finish();
                    return;
                }
            }
            x.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[]{this.uri});
            cxA();
            finish();
        } else {
            x.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
            cxA();
            finish();
        }
    }

    private void fQ(String str, String str2) {
        Intent intent = new Intent();
        if (!bh.ov(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!bh.ov(str2)) {
            intent.putExtra("Kdescription", str2);
        }
        if (ar.Hi() && !ar.Cs()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            d.b(this, "sns", ".ui.SnsUploadUI", intent);
        } else if (bh.ov(str)) {
            cxA();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
        }
        finish();
    }

    private void cxA() {
        Toast.makeText(this, R.l.ePr, 1).show();
    }
}
