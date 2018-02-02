package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenImgUI extends MMActivity {
    String filePath = null;
    private af handler = new 1(this);
    private ProgressDialog iln = null;
    private Intent intent = null;
    Uri uri = null;

    static /* synthetic */ void a(ShareScreenImgUI shareScreenImgUI) {
        if (shareScreenImgUI.iln != null && shareScreenImgUI.iln.isShowing()) {
            shareScreenImgUI.iln.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        int a = t.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.wG();
                initView();
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void initView() {
        this.intent = getIntent();
        if (this.intent == null) {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            cxA();
            finish();
            return;
        }
        x.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (bh.ov(action)) {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            cxA();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            x.i("MicroMsg.ShareScreenImgUI", "send signal: " + action);
            if (this.uri == null || !bh.m(this.uri)) {
                x.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", this.uri);
                cxA();
                finish();
                return;
            }
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.dHc), true, new 2(this));
            this.filePath = bh.f(this, this.uri);
            if (!bh.ov(this.filePath)) {
                action = this.filePath;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                boolean b = p.b(action, decodeResultLogger);
                if (!b && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    g.pQN.k(12712, KVStatHelper.getKVStatString(action, 3, decodeResultLogger));
                }
                if (b) {
                    cyb();
                    return;
                }
            }
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
            cxA();
            finish();
        } else {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            cxA();
            finish();
        }
    }

    private void cyb() {
        int i;
        x.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", this.filePath);
        Intent intent = getIntent();
        String resolveType = intent.resolveType(this);
        if (resolveType == null || resolveType.length() == 0) {
            x.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            i = -1;
        } else if (resolveType.toLowerCase().contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            i = 0;
        } else {
            x.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
            i = 3;
        }
        if (i == -1) {
            x.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            return;
        }
        if (!t.a(getIntent(), "Intro_Switch", false) && ar.Hi() && !ar.Cs()) {
            intent.setData(this.uri);
            intent.setClass(this, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", this.filePath);
            intent.putExtra("Retr_Msg_Type", i);
            intent.putExtra("Retr_Scene", 1);
            intent.putExtra("Retr_start_where_you_are", false);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (bh.ov(this.filePath)) {
            cxA();
        } else {
            Intent intent2 = new Intent(this, ShareImgUI.class);
            intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent2.addFlags(67108864);
            intent2.setType("image/*");
            intent2.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent2);
        }
        finish();
    }

    private void cxA() {
        Toast.makeText(this, R.l.ePp, 1).show();
    }
}
