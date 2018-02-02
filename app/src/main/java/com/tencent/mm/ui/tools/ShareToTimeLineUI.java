package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareToTimeLineUI extends AutoLoginActivity implements e {
    private ProgressDialog iln = null;
    private Intent intent;

    protected final boolean bfz() {
        if (ar.Hi() && !ar.Cs()) {
            return false;
        }
        x.w("MicroMsg.ShareToTimeLine", "not login");
        cyb();
        return true;
    }

    private void cyb() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            cxA();
            finish();
            return;
        }
        String action = intent.getAction();
        Bundle ah = t.ah(intent);
        if (bh.ov(action)) {
            x.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
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
        } else if (action.equals("android.intent.action.SEND") && ah != null) {
            x.i("MicroMsg.ShareToTimeLine", "send signal: " + action);
            Parcelable parcelable = ah.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (bh.m(uri)) {
                    String f = bh.f(this, uri);
                    if (bh.ov(f)) {
                        action = d.a(getContentResolver(), uri, 2);
                    } else {
                        action = f;
                    }
                    if (bh.ov(action) || !bh.VV(action)) {
                        if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                            fQ(action, j);
                            return;
                        }
                        cxA();
                        finish();
                        return;
                    } else if (ZT(action)) {
                        fQ(action, j);
                        return;
                    } else {
                        cxA();
                        finish();
                        return;
                    }
                }
                x.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[]{uri});
                cxA();
                finish();
            } else if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                fQ(null, j);
            } else {
                cxA();
                finish();
            }
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && ah != null && ah.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.ShareToTimeLine", "send multi: " + action);
            ArrayList aj = aj(ah);
            if (aj == null || aj.size() == 0) {
                cxA();
                finish();
                return;
            }
            c(aj, j);
        } else {
            x.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            cxA();
            finish();
        }
    }

    private static boolean ZT(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = p.b(str, decodeResultLogger);
        if (b || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            return b;
        }
        g.pQN.k(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
        return b;
    }

    private ArrayList<String> aj(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            x.e("MicroMsg.ShareToTimeLine", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) ((Parcelable) it.next());
            if (uri == null || !bh.m(uri) || uri.getScheme() == null) {
                x.e("MicroMsg.ShareToTimeLine", "unaccepted uri: " + uri);
            } else {
                String f = bh.f(this, uri);
                if (!bh.ov(f)) {
                    if (ZT(f)) {
                        x.i("MicroMsg.ShareToTimeLine", "multisend file path: " + f);
                        arrayList.add(f);
                    } else {
                        x.w("MicroMsg.ShareToTimeLine", "not image: " + f);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
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
            intent.putExtra("Ksnsupload_source", 12);
            com.tencent.mm.bm.d.b(this, "sns", ".ui.SnsUploadUI", intent);
        } else if (bh.ov(str)) {
            cxA();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT), intent);
        }
        finish();
    }

    private void c(ArrayList<String> arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            finish();
            return;
        }
        if (arrayList.size() > 9) {
            arrayList.subList(9, arrayList.size()).clear();
        }
        if (!ar.Hi() || ar.Cs()) {
            Intent intent = new Intent(this, ShareToTimeLineUI.class);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setType("image/*");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT), intent);
        } else {
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
            if (!bh.ov(str)) {
                intent2.putExtra("Kdescription", str);
            }
            intent2.putExtra("K_go_to_SnsTimeLineUI", true);
            intent2.putExtra("Ksnsupload_source", 12);
            com.tencent.mm.bm.d.b(this, "sns", ".ui.SnsUploadUI", intent2);
        }
        finish();
    }

    private void cxA() {
        Toast.makeText(this, R.l.ePr, 1).show();
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        switch (2.kuV[aVar.ordinal()]) {
            case 1:
                this.intent = intent;
                x.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[]{Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("SystemShareControlBitset"), 0))});
                if ((bh.getInt(com.tencent.mm.k.g.zY().getValue("SystemShareControlBitset"), 0) & 2) > 0) {
                    x.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    return;
                }
                x.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[]{t.j(intent, "android.intent.extra.TEXT")});
                if (bh.ov(t.j(intent, "android.intent.extra.TEXT"))) {
                    cyb();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                getString(R.l.dGO);
                this.iln = h.a((Context) this, getString(R.l.dHc), true, new 1(this));
                ar.CG().a(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
                ar.CG().a(new ak(format, 15, null), 0);
                return;
            default:
                finish();
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (i == 0 && i2 == 0) {
            cyb();
        } else {
            finish();
        }
    }
}
