package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k.d;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.b.b;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class AddFavoriteUI extends MMActivity {
    String filePath = null;
    private af handler = new 12(this);
    private ProgressDialog iln = null;
    private Intent intent = null;
    Uri uri = null;
    ArrayList<String> zgG = null;
    private af zgH = new af(this) {
        final /* synthetic */ AddFavoriteUI zgJ;

        {
            this.zgJ = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.zgJ);
            x.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[]{Boolean.valueOf(AddFavoriteUI.e(this.zgJ))});
        }
    };
    private af zgI = new 11(this);

    private class a implements Runnable {
        private Uri aMK;
        final /* synthetic */ AddFavoriteUI zgJ;
        private b zgK;

        public a(AddFavoriteUI addFavoriteUI, Uri uri, b bVar) {
            this.zgJ = addFavoriteUI;
            this.aMK = uri;
            this.zgK = bVar;
        }

        public final void run() {
            this.zgJ.filePath = AddFavoriteUI.a(this.zgJ, this.aMK);
            if (bh.ov(this.zgJ.filePath) || !new File(this.zgJ.filePath).exists()) {
                if (AddFavoriteUI.ZU(this.zgJ.getContentResolver().getType(this.aMK)) == 8) {
                    this.zgJ.filePath = d.a(this.zgJ.getContentResolver(), this.aMK);
                } else {
                    this.zgJ.filePath = d.a(this.zgJ.getContentResolver(), this.aMK, 1);
                }
            }
            if (this.zgK != null) {
                this.zgK.cxB();
            }
        }
    }

    static /* synthetic */ String a(AddFavoriteUI addFavoriteUI, Uri uri) {
        String scheme = uri.getScheme();
        if (bh.ov(scheme)) {
            x.e("MicroMsg.AddFavoriteUI", "input uri error. %s", new Object[]{uri});
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            x.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            x.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = addFavoriteUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                x.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                x.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((addFavoriteUI.intent != null && addFavoriteUI.intent.getType().equals("text/x-vcalendar")) || q.gGe.gEW == 1)) {
                    return addFavoriteUI.a(uri, query);
                }
                query.close();
                return bh.f(addFavoriteUI, uri);
            }
        } else {
            x.e("MicroMsg.AddFavoriteUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void d(AddFavoriteUI addFavoriteUI) {
        if (addFavoriteUI.iln != null && addFavoriteUI.iln.isShowing()) {
            addFavoriteUI.iln.dismiss();
        }
    }

    static /* synthetic */ boolean e(AddFavoriteUI addFavoriteUI) {
        addFavoriteUI.intent = addFavoriteUI.getIntent();
        if (addFavoriteUI.intent == null) {
            x.e("MicroMsg.AddFavoriteUI", "intent is null");
            return false;
        }
        String j = t.j(addFavoriteUI.intent, "android.intent.extra.TEXT");
        if (j == null || j.length() == 0) {
            x.i("MicroMsg.AddFavoriteUI", "text is null");
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(j));
        wXMediaMessage.description = j;
        Req req = new Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        int type = req.message.getType();
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, 620823552);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        if (!ar.Hi() || ar.Cs()) {
            x.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class), addFavoriteUI.getIntent().addFlags(67108864));
            addFavoriteUI.finish();
        } else {
            cf cfVar = new cf();
            String str = e.bR(addFavoriteUI.filePath) + "." + e.bQ(addFavoriteUI.filePath);
            if (type == 1) {
                Boolean.valueOf(f.a(cfVar, j, 13));
            } else {
                Boolean.valueOf(f.a(cfVar, 13, addFavoriteUI.filePath, str, ""));
            }
            cfVar.fqp.activity = addFavoriteUI;
            cfVar.fqp.fqx = new 3(addFavoriteUI);
            cfVar.fqp.fqy = new 4(addFavoriteUI);
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
        }
        return true;
    }

    static /* synthetic */ void f(AddFavoriteUI addFavoriteUI) {
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int ZU = ZU(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (ZU == -1) {
            x.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            return;
        }
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithMultiItem msgType is %d", new Object[]{addFavoriteUI.filePath, Integer.valueOf(ZU)});
        if (ZU == 8 && !bh.ov(addFavoriteUI.filePath)) {
            addFavoriteUI.aX(ZU, addFavoriteUI.filePath);
        } else if (t.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !ar.Hi() || ar.Cs()) {
            ArrayList arrayList;
            Intent intent = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            if (bh.cA(addFavoriteUI.zgG)) {
                arrayList = new ArrayList(0);
            } else {
                ArrayList arrayList2 = new ArrayList(addFavoriteUI.zgG.size());
                Iterator it = addFavoriteUI.zgG.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Uri.fromFile(new File((String) it.next())));
                }
                arrayList = arrayList2;
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.setType(addFavoriteUI.getIntent().getType());
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
            addFavoriteUI.finish();
        } else {
            b cfVar = new cf();
            List<String> list = addFavoriteUI.zgG;
            if (list == null || list.isEmpty()) {
                x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                cfVar.fqp.fqv = R.l.efh;
            } else if (list.size() > 9) {
                cfVar.fqp.fqv = R.l.efo;
            } else {
                x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", new Object[]{list, Integer.valueOf(13)});
                ve veVar = new ve();
                vk vkVar = new vk();
                for (String str : list) {
                    if (!bh.ov(str)) {
                        uq uqVar = new uq();
                        uqVar.CJ(2);
                        uqVar.TE(str);
                        uqVar.lt(true);
                        veVar.weU.add(uqVar);
                    }
                }
                vkVar.Ui(com.tencent.mm.z.q.FS());
                vkVar.Uj(com.tencent.mm.z.q.FS());
                vkVar.CS(13);
                vkVar.fC(bh.Wp());
                veVar.a(vkVar);
                cfVar.fqp.title = "";
                cfVar.fqp.fqr = veVar;
                cfVar.fqp.type = 2;
            }
            cfVar.fqp.activity = addFavoriteUI;
            cfVar.fqp.fqx = new 13(addFavoriteUI);
            cfVar.fqp.fqy = new 14(addFavoriteUI);
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
        }
    }

    static /* synthetic */ void h(AddFavoriteUI addFavoriteUI) {
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int ZU = ZU(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (ZU == -1) {
            x.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            return;
        }
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithSimpleItem msgType is %d", new Object[]{addFavoriteUI.filePath, Integer.valueOf(ZU)});
        if ((ZU == 8 || ZU == 4) && !bh.ov(addFavoriteUI.filePath)) {
            addFavoriteUI.aX(ZU, addFavoriteUI.filePath);
        } else if (t.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !ar.Hi() || ar.Cs()) {
            addFavoriteUI.finish();
            addFavoriteUI.cxz();
        } else {
            cf cfVar = new cf();
            f.a(cfVar, 13, addFavoriteUI.filePath);
            cfVar.fqp.activity = addFavoriteUI;
            cfVar.fqp.fqx = new 15(addFavoriteUI);
            cfVar.fqp.fqy = new 2(addFavoriteUI);
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
        }
    }

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        setTitleVisibility(8);
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
                x.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        x.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        x.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
    }

    protected void onDestroy() {
        x.i("MicroMsg.AddFavoriteUI", "on Destroy");
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void initView() {
        this.intent = getIntent();
        if (this.intent == null) {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
            cxA();
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle ah = t.ah(this.intent);
        if (bh.ov(action)) {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
            cxA();
            finish();
            return;
        }
        if (ah != null) {
            Parcelable parcelable = ah.getParcelable("android.intent.extra.STREAM");
            if (parcelable instanceof Uri) {
                this.uri = (Uri) parcelable;
                if (!bh.m(this.uri)) {
                    x.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[]{this.uri});
                    cxA();
                    finish();
                    return;
                }
            } else if (parcelable != null) {
                x.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[]{parcelable});
                cxA();
                finish();
                return;
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            x.i("MicroMsg.AddFavoriteUI", "send signal: " + action);
            if (this.uri == null) {
                showDialog();
                com.tencent.mm.sdk.f.e.post(new 1(this), "AddFavoriteUI_dealWithTextHandler");
                return;
            }
            showDialog();
            com.tencent.mm.sdk.f.e.post(new a(this, this.uri, new 8(this)), "AddFavoriteUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && ah != null && ah.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[]{action, getIntent().resolveType(this)});
            if (bh.az(getIntent().resolveType(this), "").contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                this.zgG = aj(ah);
                if (this.zgG == null || this.zgG.size() == 0) {
                    x.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
                    GK(1);
                    finish();
                    return;
                }
                showDialog();
                com.tencent.mm.sdk.f.e.post(new 9(this), "AddFavoriteUI_dealWithMultiItemHandler");
                return;
            }
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
            GK(1);
            finish();
        } else {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
            cxA();
            finish();
        }
    }

    private void cxz() {
        Intent intent = new Intent(this, AddFavoriteUI.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", bh.ov(this.filePath) ? null : Uri.fromFile(new File(this.filePath)));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.setType(getIntent().getType());
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
    }

    private ArrayList<String> aj(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            x.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                x.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
            } else {
                Uri uri = (Uri) parcelable;
                if (!bh.m(uri) || uri.getScheme() == null) {
                    x.e("MicroMsg.AddFavoriteUI", "unaccepted uri: " + uri);
                } else {
                    String f = bh.f(this, uri);
                    if (!bh.ov(f)) {
                        if (bh.VV(f) && ZT(f)) {
                            x.i("MicroMsg.AddFavoriteUI", "multisend file path: " + f);
                            arrayList.add(f);
                            i = 1;
                            continue;
                            if (i == 0) {
                                return null;
                            }
                        }
                        x.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: " + f);
                    }
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return null;
            }
        }
        return arrayList.size() > 0 ? arrayList : null;
    }

    private static boolean ZT(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = p.b(str, decodeResultLogger);
        if (!b && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            g.pQN.k(12712, KVStatHelper.getKVStatString(str, 5, decodeResultLogger));
        }
        return b;
    }

    private void aX(int i, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            return;
        }
        int bN = e.bN(str);
        x.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[]{Integer.valueOf(bN)});
        if (bN == 0) {
            x.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, R.l.efy, 1).show();
            finish();
        } else if (bN > 26214400) {
            x.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, R.l.egO, 1).show();
            finish();
        } else if (!ar.Hi() || ar.Cs()) {
            x.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            cxz();
        } else {
            WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
            wXMediaMessage.title = new File(str).getName();
            if (bh.ov(null)) {
                wXMediaMessage.description = bh.bx((long) bN);
            } else {
                wXMediaMessage.description = null;
            }
            if (bN < 30720) {
                wXMediaMessage.thumbData = e.d(str, 0, -1);
            } else {
                x.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            Req req = new Req();
            req.transaction = null;
            req.message = wXMediaMessage;
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            bundle.putInt(ConstantsAPI.SDK_VERSION, 620823552);
            bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            b cfVar = new cf();
            String str2 = e.bR(str) + "." + e.bQ(str);
            if (i == 4) {
                String str3 = "";
                if (bh.ov(str)) {
                    x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    cfVar.fqp.fqv = R.l.efh;
                } else {
                    x.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[]{str2, str3, str, Integer.valueOf(13)});
                    if (new File(str).length() > ((long) com.tencent.mm.k.b.zG())) {
                        cfVar.fqp.fqv = R.l.egO;
                    } else {
                        ve veVar = new ve();
                        vk vkVar = new vk();
                        uq uqVar = new uq();
                        uqVar.TE(str);
                        uqVar.CJ(4);
                        uqVar.TA(e.bQ(str));
                        uqVar.TF(null);
                        uqVar.CI(0);
                        uqVar.Tq(str2);
                        uqVar.Tr(str3);
                        vkVar.Ui(com.tencent.mm.z.q.FS());
                        vkVar.Uj(com.tencent.mm.z.q.FS());
                        vkVar.CS(13);
                        vkVar.fC(bh.Wp());
                        veVar.a(vkVar);
                        veVar.weU.add(uqVar);
                        cfVar.fqp.title = uqVar.title;
                        cfVar.fqp.desc = uqVar.title;
                        cfVar.fqp.fqr = veVar;
                        cfVar.fqp.type = 4;
                    }
                }
            } else {
                f.a(cfVar, 13, str, str2, "");
            }
            cfVar.fqp.activity = this;
            cfVar.fqp.fqx = new 5(this);
            cfVar.fqp.fqy = new 6(this);
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
        }
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileOutputStream openFileOutput;
        FileNotFoundException e;
        Throwable e2;
        IOException e3;
        Exception e4;
        FileOutputStream fileOutputStream = null;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
                if (str != null) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                x.i("MicroMsg.AddFavoriteUI", "vcard file name: " + str);
            }
            cursor.close();
            FileInputStream createInputStream;
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
                try {
                    createInputStream = openAssetFileDescriptor.createInputStream();
                    try {
                        byte[] bArr = new byte[((int) openAssetFileDescriptor.getDeclaredLength())];
                        if (createInputStream.read(bArr) > 0) {
                            ar.Hg();
                            if (c.isSDCardAvailable()) {
                                String str2 = com.tencent.mm.compatible.util.e.bnF + "share";
                                str = com.tencent.mm.compatible.util.e.bnF + "share/" + str;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(str);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                if (e.b(str, bArr, bArr.length) == 0) {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e5) {
                                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e5, e5.getMessage(), new Object[0]);
                                            return str;
                                        }
                                    }
                                    if (openAssetFileDescriptor == null) {
                                        return str;
                                    }
                                    openAssetFileDescriptor.close();
                                    return str;
                                }
                            }
                            deleteFile(str);
                            openFileOutput = openFileOutput(str, 0);
                            try {
                                openFileOutput.write(bArr);
                                openFileOutput.flush();
                                str = getFilesDir().getPath() + "/" + str;
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e52) {
                                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e52, e52.getMessage(), new Object[0]);
                                        return str;
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput == null) {
                                    return str;
                                }
                                openFileOutput.close();
                                return str;
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                try {
                                    x.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e22) {
                                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e22, e22.getMessage(), new Object[0]);
                                        }
                                    }
                                    if (openAssetFileDescriptor != null) {
                                        openAssetFileDescriptor.close();
                                    }
                                    if (openFileOutput != null) {
                                        openFileOutput.close();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    e22 = th;
                                    fileOutputStream = openFileOutput;
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e522) {
                                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e522, e522.getMessage(), new Object[0]);
                                            throw e22;
                                        }
                                    }
                                    if (openAssetFileDescriptor != null) {
                                        openAssetFileDescriptor.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e22;
                                }
                            } catch (IOException e7) {
                                e3 = e7;
                                x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e222, e222.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                return null;
                            } catch (Exception e8) {
                                e4 = e8;
                                x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e2222) {
                                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e2222, e2222.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                return null;
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e22222) {
                                x.printErrStackTrace("MicroMsg.AddFavoriteUI", e22222, e22222.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        openFileOutput = null;
                        x.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (IOException e10) {
                        e3 = e10;
                        openFileOutput = null;
                        x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (Exception e11) {
                        e4 = e11;
                        openFileOutput = null;
                        x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        e22222 = th2;
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e22222;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    openFileOutput = null;
                    createInputStream = null;
                    x.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (IOException e13) {
                    e3 = e13;
                    openFileOutput = null;
                    createInputStream = null;
                    x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e4 = e14;
                    openFileOutput = null;
                    createInputStream = null;
                    x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    e22222 = th3;
                    createInputStream = null;
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e22222;
                }
            } catch (FileNotFoundException e15) {
                e = e15;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                x.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (IOException e16) {
                e3 = e16;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (Exception e17) {
                e4 = e17;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (Throwable th4) {
                e22222 = th4;
                createInputStream = null;
                openAssetFileDescriptor = null;
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22222;
            }
        }
        return null;
    }

    private static int ZU(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE) || toLowerCase.equals("application/vnd.google.panorama360+jpg")) {
            return 2;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            return 4;
        }
        x.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
        return 8;
    }

    private void cxA() {
        GK(0);
        Toast.makeText(this, R.l.ePp, 1).show();
    }

    private void GK(int i) {
        switch (i) {
            case 1:
                Toast.makeText(this, R.l.ePn, 1).show();
                return;
            default:
                Toast.makeText(this, R.l.ePp, 1).show();
                return;
        }
    }

    private void showDialog() {
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new 7(this));
    }
}
