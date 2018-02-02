package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
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
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.k.b;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareImgUI extends AutoLoginActivity implements e {
    String filePath = null;
    private af handler = new 3(this);
    private ProgressDialog iln = null;
    private Intent intent = null;
    String text = null;
    Uri uri = null;
    ArrayList<String> zgG = null;

    static /* synthetic */ String a(ShareImgUI shareImgUI, Uri uri) {
        String scheme = uri.getScheme();
        if (bh.ov(scheme)) {
            x.e("MicroMsg.ShareImgUI", "input uri error. %s", new Object[]{uri});
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            x.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            x.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = shareImgUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                x.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                x.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((shareImgUI.intent != null && shareImgUI.intent.getType().equals("text/x-vcalendar")) || q.gGe.gEW == 1)) {
                    return shareImgUI.a(uri, query);
                }
                query.close();
                return bh.f(shareImgUI, uri);
            }
        } else {
            x.e("MicroMsg.ShareImgUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void a(ShareImgUI shareImgUI, b bVar, ArrayList arrayList) {
        if (bVar != null) {
            shareImgUI.runOnUiThread(new 5(shareImgUI, bVar, arrayList));
        }
    }

    static /* synthetic */ boolean a(ShareImgUI shareImgUI, ArrayList arrayList, Parcelable parcelable) {
        if (parcelable == null || !(parcelable instanceof Uri)) {
            x.e("MicroMsg.ShareImgUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
        } else {
            Uri uri = (Uri) parcelable;
            if (!bh.m(uri) || uri.getScheme() == null) {
                x.e("MicroMsg.ShareImgUI", "unaccepted uri: " + uri);
            } else {
                String f = bh.f(shareImgUI, uri);
                if (!bh.ov(f)) {
                    if (bh.VV(f) && ZT(f)) {
                        x.i("MicroMsg.ShareImgUI", "multisend file path: " + f);
                        arrayList.add(f);
                        return true;
                    }
                    x.w("MicroMsg.ShareImgUI", "multisend tries to send illegal img: " + f);
                }
            }
        }
        return false;
    }

    static /* synthetic */ void c(ShareImgUI shareImgUI) {
        Intent intent = shareImgUI.getIntent();
        int ZU = ZU(intent.resolveType(shareImgUI));
        if (ZU == 0 && p.UR(shareImgUI.filePath)) {
            x.i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            ZU = 5;
        }
        x.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d, text:%s", new Object[]{shareImgUI.filePath, Integer.valueOf(ZU), shareImgUI.text});
        if (ZU == -1) {
            x.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
        } else if (!bh.ov(shareImgUI.filePath) && bh.VV(shareImgUI.filePath) && !ZT(shareImgUI.filePath)) {
            x.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            shareImgUI.GK(0);
        } else if (ZU == 3 && !bh.ov(shareImgUI.filePath)) {
            shareImgUI.aaa(shareImgUI.filePath);
        } else if (shareImgUI.text == null || ZU != 0 || bh.ov(shareImgUI.filePath)) {
            if (ZU == 5 && !bh.ov(shareImgUI.filePath)) {
                if (com.tencent.mm.a.e.bN(shareImgUI.filePath) > b.zF()) {
                    g.pQN.h(13459, new Object[]{Integer.valueOf(com.tencent.mm.a.e.bN(shareImgUI.filePath)), Integer.valueOf(1), "", Integer.valueOf(2)});
                    shareImgUI.cya();
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                if ((d.decodeFile(shareImgUI.filePath, options) != null && options.outHeight > b.zE()) || options.outWidth > b.zE()) {
                    g.pQN.h(13459, new Object[]{Integer.valueOf(com.tencent.mm.a.e.bN(shareImgUI.filePath)), Integer.valueOf(1), "", Integer.valueOf(2)});
                    shareImgUI.cya();
                    return;
                }
            }
            if (!t.a(shareImgUI.getIntent(), "Intro_Switch", false) && ar.Hi() && !ar.Cs()) {
                intent.setData(shareImgUI.uri);
                intent.setClass(shareImgUI, MsgRetransmitUI.class);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                intent.putExtra("Retr_File_Name", shareImgUI.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", shareImgUI.zgG);
                intent.putExtra("Retr_Msg_Type", ZU);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                shareImgUI.startActivity(intent);
            } else if (!shareImgUI.cxZ()) {
                shareImgUI.GK(0);
            }
        } else {
            shareImgUI.aaa(shareImgUI.filePath);
        }
        shareImgUI.finish();
    }

    static /* synthetic */ void d(ShareImgUI shareImgUI) {
        if (shareImgUI.iln != null && shareImgUI.iln.isShowing()) {
            shareImgUI.iln.dismiss();
        }
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final boolean bfz() {
        if (ar.Hi() && !ar.Cs()) {
            return false;
        }
        x.w("MicroMsg.ShareImgUI", "not login");
        this.intent = getIntent();
        Yt();
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        switch (7.kuV[aVar.ordinal()]) {
            case 1:
                this.intent = intent;
                x.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[]{Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("SystemShareControlBitset"), 0))});
                if ((bh.getInt(com.tencent.mm.k.g.zY().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    x.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    return;
                }
                x.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[]{t.j(intent, "android.intent.extra.TEXT")});
                if (bh.ov(t.j(intent, "android.intent.extra.TEXT"))) {
                    Yt();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                ar.CG().a(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
                ar.CG().a(new ak(format, 15, null), 0);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.fG(this);
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
    }

    private void Yt() {
        if (this.intent == null) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            GK(0);
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (bh.ov(action)) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            GK(0);
            finish();
            return;
        }
        this.text = t.j(this.intent, "android.intent.extra.TEXT");
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!bh.m(this.uri)) {
                    x.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                    GK(0);
                    finish();
                    return;
                }
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            x.i("MicroMsg.ShareImgUI", "send signal: " + action);
            if (this.uri == null) {
                boolean z;
                Intent intent = getIntent();
                if (intent == null) {
                    x.e("MicroMsg.ShareImgUI", "intent is null");
                    z = false;
                } else {
                    String j = t.j(intent, "android.intent.extra.TEXT");
                    if (j == null || j.length() == 0) {
                        x.i("MicroMsg.ShareImgUI", "text is null");
                        z = false;
                    } else {
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(j));
                        wXMediaMessage.description = j;
                        Req req = new Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        extras = new Bundle();
                        req.toBundle(extras);
                        extras.putInt(ConstantsAPI.SDK_VERSION, 620823552);
                        extras.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                        extras.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        intent = new Intent();
                        intent.setClass(this, SelectConversationUI.class);
                        intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(extras).putExtra("animation_pop_in", true));
                        if (!ar.Hi() || ar.Cs()) {
                            x.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                        } else {
                            startActivity(intent);
                        }
                        z = true;
                    }
                }
                x.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    GK(0);
                }
                finish();
                return;
            }
            showDialog();
            com.tencent.mm.sdk.f.e.post(new a(this, this.uri, new 1(this)), "ShareImgUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.ShareImgUI", "send multi: " + action);
            com.tencent.mm.sdk.f.e.post(new 4(this, extras, new 2(this), System.currentTimeMillis()), "getMultiSendFilePathList");
        } else {
            x.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            GK(0);
            finish();
        }
    }

    private boolean cxZ() {
        Intent intent = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (bh.ov(this.filePath)) {
                return false;
            }
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent.setAction("android.intent.action.SEND");
            intent.setType(getIntent().getType());
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction()) || bh.cA(this.zgG)) {
            return false;
        } else {
            ArrayList arrayList = new ArrayList(this.zgG.size());
            Iterator it = this.zgG.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(getIntent().getType());
        }
        intent.addFlags(67108864);
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
        return true;
    }

    private static boolean ZT(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = p.b(str, decodeResultLogger);
        if (!b && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            g.pQN.k(12712, KVStatHelper.getKVStatString(str, 3, decodeResultLogger));
        }
        return b;
    }

    private void aaa(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
        } else if (bh.VU(str)) {
            String str2 = "";
            int bN = com.tencent.mm.a.e.bN(str);
            x.i("MicroMsg.ShareImgUI", "filelength: [%d]", new Object[]{Integer.valueOf(bN)});
            if (bN == 0) {
                x.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
            } else if (bN > 10485760) {
                x.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", new Object[]{Integer.valueOf(bN), str});
                Toast.makeText(this, R.l.ePo, 1).show();
            } else {
                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
                wXMediaMessage.title = new File(str).getName();
                if (str2.length() > 0) {
                    wXMediaMessage.description = str2;
                } else {
                    wXMediaMessage.description = bh.bx((long) bN);
                }
                if (bN < 30720) {
                    wXMediaMessage.thumbData = com.tencent.mm.a.e.d(str, 0, -1);
                } else {
                    x.i("MicroMsg.ShareImgUI", "thumb data is exceed 30k, ignore");
                }
                Req req = new Req();
                req.transaction = null;
                req.message = wXMediaMessage;
                Bundle bundle = new Bundle();
                req.toBundle(bundle);
                bundle.putInt(ConstantsAPI.SDK_VERSION, 620823552);
                bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                Intent intent = new Intent();
                intent.setClass(this, SelectConversationUI.class);
                intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                if (!ar.Hi() || ar.Cs()) {
                    x.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                    MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                    return;
                }
                startActivity(intent);
            }
        } else {
            x.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
        }
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        IOException e2;
        Exception e3;
        FileOutputStream fileOutputStream2 = null;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    x.w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", new Object[]{e4.getMessage()});
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                x.i("MicroMsg.ShareImgUI", "vcard file name: " + str);
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                try {
                    x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            throw th;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e2 = e8;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e10) {
                e3 = e10;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                x.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e11) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                fileInputStream = openAssetFileDescriptor.createInputStream();
                try {
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
                        fileOutputStream = new FileOutputStream(str, false);
                    } else {
                        deleteFile(str);
                        String str3 = getFilesDir().getPath() + "/" + str;
                        fileOutputStream = openFileOutput(str, 0);
                        str = str3;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e13) {
                    e2 = e13;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e3 = e14;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    x.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 5120);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e15) {
                            return str;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream == null) {
                        return str;
                    }
                    fileOutputStream.close();
                    return str;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e17) {
                    e2 = e17;
                    x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e18) {
                    e3 = e18;
                    x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    x.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (IOException e20) {
                e2 = e20;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e21) {
                e3 = e21;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                x.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return null;
    }

    private static int ZU(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("image/gif")) {
            return 5;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            return 0;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            return 1;
        }
        x.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
        return 3;
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

    private void cya() {
        Toast.makeText(this, R.l.dZJ, 1).show();
        finish();
    }

    private void showDialog() {
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new 6(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (i == 0 && i2 == 0) {
            Yt();
        } else {
            finish();
        }
    }
}
