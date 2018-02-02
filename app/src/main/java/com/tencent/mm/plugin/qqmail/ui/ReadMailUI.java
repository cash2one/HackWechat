package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bz.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI extends MMActivity implements OnCreateContextMenuListener {
    private static String puA = "";
    private static float puB;
    private static int puC;
    private static String puy = "var mail_css = document.createElement(\"style\");";
    private static String puz = "";
    private long fqm = -1;
    private SharedPreferences gZO;
    private af handler;
    private long jcE = -1;
    private TextView lUD;
    private d mfB = new d(this);
    private String pod;
    private String poi;
    private String ptU;
    private MailMMWebView ptV;
    private ProgressBar ptW;
    private ImageView ptX;
    private TextView ptY;
    private MailAddrsViewControl ptZ;
    private ReadMailProxy puD;
    private String puE;
    private int puF;
    private MailAddrsViewControl pua;
    private MailAddrsViewControl pub;
    private TextView puc;
    private View pud;
    private LinearLayout pue;
    private TextView puf;
    private TextView pug;
    private LinearLayout puh;
    private MailAttachListLinearLayout pui;
    private View puj;
    private TextView puk;
    private TextView pul;
    private View pum;
    private long pun = -1;
    private int puo;
    private int pup;
    private String puq;
    private String pur;
    private String pus;
    private int put = 0;
    private String puu;
    private ak puv;
    private int puw = 0;
    private int pux = 0;

    public class c {
        final /* synthetic */ ReadMailUI puG;

        public c(ReadMailUI readMailUI) {
            this.puG = readMailUI;
        }
    }

    static /* synthetic */ void E(ReadMailUI readMailUI) {
        readMailUI.gZO = ac.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.gZO != null) {
            bh.i(readMailUI.gZO.getString("qqmail_downloadpath", ""), readMailUI);
        }
    }

    static /* synthetic */ void F(ReadMailUI readMailUI) {
        final Intent intent = new Intent();
        if (bh.ov(readMailUI.puE)) {
            x.w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            return;
        }
        x.d("MicroMsg.ReadMailUI", "qq mail scheme:%s", new Object[]{readMailUI.puE.replace("$uin$", (String) new ReadMailProxy(readMailUI.mfB, new a(readMailUI, 1)).REMOTE_CALL("getBindUin", new Object[0]))});
        intent.setData(Uri.parse(r0));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        }
        if (bh.k(readMailUI, intent)) {
            a.post(new Runnable(readMailUI) {
                final /* synthetic */ ReadMailUI puG;

                public final void run() {
                    g.a(this.puG, intent, this.puG.getString(R.l.dQs), null);
                }
            });
            return;
        }
        x.w("MicroMsg.ReadMailUI", "schema failed");
        a.post(new 6(readMailUI));
    }

    static /* synthetic */ void J(ReadMailUI readMailUI) {
        try {
            new ReadMailProxy(readMailUI.mfB, null).REMOTE_CALL("deleteMsgById", new Object[]{Long.valueOf(readMailUI.fqm)});
        } catch (Exception e) {
            x.w("MicroMsg.ReadMailUI", "doDelete fail, ex = %s", new Object[]{e.getMessage()});
        }
        readMailUI.finish();
    }

    static /* synthetic */ void a(ReadMailUI readMailUI, Runnable runnable) {
        com.tencent.xweb.c.iO(readMailUI);
        b cIj = b.cIj();
        cIj.ApL.removeSessionCookie();
        readMailUI.handler.postDelayed(new 2(readMailUI, cIj, runnable), 500);
    }

    static /* synthetic */ void a(ReadMailUI readMailUI, Map map) {
        if (bh.getInt(bh.az((String) map.get(".Response.result.attachlen"), "0"), 0) == 0) {
            readMailUI.puh.setVisibility(8);
            return;
        }
        readMailUI.puh.setVisibility(0);
        ((TextView) readMailUI.findViewById(R.h.cFR)).setText(readMailUI.getString(R.l.eCd, new Object[]{Integer.valueOf(r3)}));
        readMailUI.pui.removeAllViews();
        MailAttachListLinearLayout mailAttachListLinearLayout = readMailUI.pui;
        int i = bh.getInt(bh.az((String) map.get(".Response.result.attachlen"), "0"), 0);
        if (i == 0) {
            x.i("MicroMsg.MailAttachListLinearLayout", "inflate, attachLen = 0");
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            StringBuffer stringBuffer = new StringBuffer(".Response.result.attachlist.item");
            if (i2 != 0) {
                stringBuffer.append(i2);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (map.get(stringBuffer2) == null) {
                x.e("MicroMsg.MailAttachListLinearLayout", "item is null, itemKey = " + stringBuffer2);
                return;
            }
            View inflate = View.inflate(mailAttachListLinearLayout.context, R.i.dqq, null);
            if (i == 1 || i2 >= i - 1) {
                inflate.setBackgroundResource(R.g.bDD);
            } else {
                inflate.setBackgroundResource(R.g.bDC);
            }
            mailAttachListLinearLayout.addView(inflate);
            String str = (String) map.get(stringBuffer2 + ".name");
            long j = bh.getLong((String) map.get(stringBuffer2 + ".size"), 0);
            ((TextView) inflate.findViewById(R.h.cFT)).setText(str);
            ((TextView) inflate.findViewById(R.h.cFU)).setText(bh.bx(j));
            String str2 = (String) map.get(stringBuffer2 + ".path");
            String dK = MailAttachListLinearLayout.dK(str2, "mailid");
            map.get(stringBuffer2 + ".type");
            String str3 = "";
            try {
                str3 = URLDecoder.decode(MailAttachListLinearLayout.dK(str2, "attachid"), ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MailAttachListLinearLayout", e, "", new Object[0]);
            }
            mailAttachListLinearLayout.ptl.add(str);
            inflate.setOnClickListener(new 1(mailAttachListLinearLayout, str, dK, str3, j, bh.getInt(bh.az((String) map.get(stringBuffer2 + ".preview"), "0"), 0), str2));
            ((ImageView) inflate.findViewById(R.h.cFS)).setImageResource(FileExplorerUI.SM(str));
            i2++;
        }
    }

    static /* synthetic */ void q(ReadMailUI readMailUI) {
        readMailUI.pug.setOnClickListener(new 11(readMailUI));
        readMailUI.ptX.setOnClickListener(new 12(readMailUI));
        readMailUI.addIconOptionMenu(0, R.g.bDI, new 13(readMailUI));
        if (readMailUI.pun != -2) {
            String str;
            if (!(readMailUI.pun == -1 || readMailUI.pun == -2)) {
                try {
                    new ReadMailProxy(readMailUI.mfB, new a(readMailUI, 0)).REMOTE_CALL("cancel", new Object[]{Long.valueOf(readMailUI.pun)});
                } catch (Exception e) {
                    x.w("MicroMsg.ReadMailUI", "render cancel, ex = %s", new Object[]{e.getMessage()});
                }
            }
            try {
                str = (String) new ReadMailProxy(readMailUI.mfB, null).REMOTE_CALL("getMsgContent", new Object[]{Long.valueOf(readMailUI.fqm)});
            } catch (Exception e2) {
                x.w("MicroMsg.ReadMailUI", "render, getMsgContent, ex = %s", new Object[]{e2.getMessage()});
                str = null;
            }
            Map y = bi.y(str, "msg");
            if (y == null) {
                x.e("MicroMsg.ReadMailUI", "render fail, maps is null");
                return;
            }
            readMailUI.setMMTitle("");
            readMailUI.pod = (String) y.get(".msg.pushmail.mailid");
            readMailUI.poi = (String) y.get(".msg.pushmail.content.subject");
            readMailUI.ptZ.a(new String[]{((String) y.get(".msg.pushmail.content.fromlist.item.name")) + " " + ((String) y.get(".msg.pushmail.content.fromlist.item.addr"))}, true);
            readMailUI.pub.a(a(y, ".msg.pushmail.content.tolist", bh.getInt((String) y.get(".msg.pushmail.content.tolist.$count"), 0)), true);
            String[] a = a(y, ".msg.pushmail.content.cclist", bh.getInt((String) y.get(".msg.pushmail.content.cclist.$count"), 0));
            LinearLayout linearLayout = readMailUI.pue;
            int i = (a == null || a.length == 0) ? 8 : 0;
            linearLayout.setVisibility(i);
            readMailUI.pua.a(a, true);
            readMailUI.puf.setText(readMailUI.poi);
            readMailUI.lUD.setText((CharSequence) y.get(".msg.pushmail.content.date"));
            readMailUI.pug.setEnabled(true);
            readMailUI.a(new com.tencent.mm.plugin.qqmail.b.p.c());
        }
    }

    static /* synthetic */ void s(ReadMailUI readMailUI) {
        readMailUI.gZO = ac.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.gZO != null) {
            long j = readMailUI.gZO.getLong("qqmail_info_report_time", -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0 || currentTimeMillis - j > 86400000) {
                if (p.m(readMailUI, "com.tencent.androidqqmail")) {
                    int i = p.getPackageInfo(readMailUI, "com.tencent.androidqqmail").versionCode;
                    x.d("MicroMsg.ReadMailUI", "is intalled:%d, version:%d", new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
                    new ReadMailProxy(readMailUI.mfB, null).REMOTE_CALL("reportKvStates", new Object[]{Integer.valueOf(11389), Integer.valueOf(1), Integer.valueOf(i)});
                } else {
                    x.d("MicroMsg.ReadMailUI", "is intalled:%d", new Object[]{Integer.valueOf(0)});
                    readMailUI.dj(11389, 0);
                }
                readMailUI.gZO.edit().putLong("qqmail_info_report_time", currentTimeMillis).commit();
            }
        }
    }

    static /* synthetic */ void z(ReadMailUI readMailUI) {
        readMailUI.jcE = ((Long) new ReadMailProxy(readMailUI.mfB, null).REMOTE_CALL("downloadQQMailApp", new Object[]{readMailUI.pur, readMailUI.pus})).longValue();
        if (readMailUI.jcE <= 0) {
            x.e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", new Object[]{Long.valueOf(readMailUI.jcE)});
            return;
        }
        readMailUI.gZO = ac.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.gZO != null) {
            readMailUI.gZO.edit().putLong("qqmail_downloadid", readMailUI.jcE).commit();
        }
        readMailUI.pux = 1;
        readMailUI.put = ((Integer) new ReadMailProxy(readMailUI.mfB, null).REMOTE_CALL("getMailAppDownloadStatus", new Object[]{Long.valueOf(readMailUI.jcE)})).intValue();
        readMailUI.puj.setVisibility(0);
        readMailUI.bll();
        readMailUI.blh();
    }

    private void blh() {
        switch (this.pux) {
            case 0:
                this.pul.setText(R.l.eCi);
                return;
            case 1:
                this.pul.setText(R.l.eCg);
                return;
            case 2:
                this.pul.setText(R.l.eCh);
                return;
            case 3:
                String str = "";
                if (this.puF > 99) {
                    str = "99+";
                } else if (this.puF > 0) {
                    str = Integer.toString(this.puF);
                }
                if (bh.ov(str)) {
                    this.pul.setText(R.l.eCj);
                    return;
                }
                this.pul.setText(String.format(com.tencent.mm.bv.a.ac(this, R.l.eCk), new Object[]{str}));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dqp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new af();
        this.fqm = getIntent().getLongExtra("msgid", -1);
        this.puo = 0;
        this.pup = 0;
        initView();
        this.mfB.I(new Runnable(this) {
            final /* synthetic */ ReadMailUI puG;

            {
                this.puG = r1;
            }

            public final void run() {
                ReadMailUI.q(this.puG);
                if (this.puG.pup == 0) {
                    ReadMailUI.s(this.puG);
                    if (!this.puG.blj()) {
                        this.puG.blk();
                    }
                    this.puG.puD = new ReadMailProxy(this.puG.mfB, null, new b(this.puG), new c(this.puG));
                    this.puG.puD.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (this.pun != -1 && this.pun != -2) {
            try {
                new ReadMailProxy(this.mfB, new a(this, 0)).REMOTE_CALL("cancel", new Object[]{Long.valueOf(this.pun)});
            } catch (Exception e) {
                x.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.ptV.stopLoading();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.puD != null) {
            this.puD.REMOTE_CALL("removeDownloadCallback", new Object[0]);
        }
        this.mfB.release();
        this.ptV.setVisibility(8);
        this.ptV.destroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                x.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
                a(new com.tencent.mm.plugin.qqmail.b.p.c());
            } else if (i == 2) {
                x.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
                bli();
            }
        }
    }

    protected final void initView() {
        this.ptZ = (MailAddrsViewControl) findViewById(R.h.cEX);
        this.pub = (MailAddrsViewControl) findViewById(R.h.cEY);
        this.pua = (MailAddrsViewControl) findViewById(R.h.cEW);
        this.puc = (TextView) findViewById(R.h.cFY);
        this.pud = findViewById(R.h.cGa);
        this.pue = (LinearLayout) findViewById(R.h.cFX);
        this.puf = (TextView) findViewById(R.h.cGd);
        this.lUD = (TextView) findViewById(R.h.cGe);
        this.pug = (TextView) findViewById(R.h.cGc);
        this.puh = (LinearLayout) findViewById(R.h.cFW);
        this.pui = (MailAttachListLinearLayout) findViewById(R.h.cFV);
        this.ptW = (ProgressBar) findViewById(R.h.cFZ);
        this.ptX = (ImageView) findViewById(R.h.cGb);
        this.ptY = (TextView) findViewById(R.h.cGf);
        int i = R.h.cGg;
        MMWebViewWithJsApi.dR(this);
        MMWebViewWithJsApi mMWebViewWithJsApi = (MMWebViewWithJsApi) findViewById(i);
        MMWebViewWithJsApi.b(mMWebViewWithJsApi);
        this.ptV = (MailMMWebView) mMWebViewWithJsApi;
        this.pum = findViewById(R.h.cuJ);
        this.puj = findViewById(R.h.cuE);
        this.pul = (TextView) findViewById(R.h.cuG);
        this.puk = (TextView) findViewById(R.h.cuF);
        this.puj.setOnClickListener(new 7(this));
        this.puc.setOnClickListener(new 8(this));
        setBackBtn(new 9(this));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        puB = ((float) displayMetrics.widthPixels) / displayMetrics.scaledDensity;
        puC = displayMetrics.heightPixels;
        this.ptV.getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        this.ptV.getSettings().setSupportZoom(false);
        this.ptV.getSettings().setBuiltInZoomControls(false);
        this.ptV.getSettings().cIp();
        this.ptV.getSettings().setLoadsImagesAutomatically(false);
        this.ptV.getSettings().setUseWideViewPort(true);
        this.ptV.cyV();
        MailMMWebView mailMMWebView = this.ptV;
        View view = this.pum;
        if (view != null) {
            if (mailMMWebView.ptF != null) {
                mailMMWebView.removeView(mailMMWebView.ptF);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            mailMMWebView.ptF = new MailMMWebView.a(mailMMWebView, mailMMWebView.getContext());
            ((MailMMWebView.a) mailMMWebView.ptF).addView(view, new FrameLayout.LayoutParams(-1, -2));
            mailMMWebView.ptF.setBackgroundColor(-1);
            mailMMWebView.addView(mailMMWebView.ptF, layoutParams);
        }
        mailMMWebView = this.ptV;
        view = this.puj;
        if (view != null) {
            if (mailMMWebView.ptG != null) {
                mailMMWebView.removeView(mailMMWebView.ptG);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            mailMMWebView.ptG = new MailMMWebView.a(mailMMWebView, mailMMWebView.getContext());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            ((MailMMWebView.a) mailMMWebView.ptG).addView(view, layoutParams3);
            mailMMWebView.addView(mailMMWebView.ptG, layoutParams);
            mailMMWebView.ptG.setVisibility(4);
        }
        Intent intent = this.mController.xIM.getIntent();
        byte[] bArr = new byte[MMGIFException.D_GIF_ERR_IMAGE_DEFECT];
        bArr[25] = (byte) 1;
        bArr[16] = (byte) 1;
        bArr[57] = (byte) 1;
        bArr[63] = (byte) 1;
        bArr[61] = (byte) 1;
        bArr[70] = (byte) 1;
        bArr[68] = (byte) 1;
        bArr[82] = (byte) 1;
        bArr[111] = (byte) 1;
        intent.putExtra("hardcode_jspermission", new JsapiPermissionWrapper(bArr));
        this.mController.xIM.setIntent(intent);
        this.ptV.setWebViewClient(new 10(this, this.ptV));
        if (puz.equals("")) {
            try {
                puz += bh.convertStreamToString(getAssets().open("mail/lib.js"));
                puA += bh.convertStreamToString(getAssets().open("mail/readmail.js"));
                puy += "mail_css.innerHTML='" + bh.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                x.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e.getMessage());
            }
        }
        registerForContextMenu(this.ptV);
        new l(this).a(this.ptV, this, null);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof WebView) {
            WebView.a hitTestResult = ((WebView) view).getHitTestResult();
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                boolean booleanValue;
                try {
                    booleanValue = ((Boolean) new ReadMailProxy(this.mfB, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                } catch (Exception e) {
                    x.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[]{e.getMessage()});
                    booleanValue = false;
                }
                if (booleanValue) {
                    contextMenu.setHeaderTitle(R.l.eYq);
                    contextMenu.add(0, 0, 0, getString(R.l.eHg)).setOnMenuItemClickListener(new 14(this, hitTestResult));
                } else {
                    return;
                }
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    private static String[] a(Map<String, String> map, String str, int i) {
        if (map.get(str) == null) {
            return null;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            String str2 = str + ".item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            strArr[i2] = ((String) map.get(str2 + ".name")) + " " + ((String) map.get(str2 + ".addr"));
            i2++;
        }
        return strArr;
    }

    private void a(com.tencent.mm.plugin.qqmail.b.p.c cVar) {
        if (this.pod == null || this.pod.length() == 0) {
            x.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
            return;
        }
        this.ptX.setVisibility(8);
        this.ptW.setVisibility(0);
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.pod);
        hashMap.put("texttype", "html");
        if (!(this.pun == -1 || this.pun == -2)) {
            try {
                new ReadMailProxy(this.mfB, new a(this, 0)).REMOTE_CALL("cancel", new Object[]{Long.valueOf(this.pun)});
            } catch (Exception e) {
                x.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
        this.ptU = this.pod;
        cVar.toBundle(new Bundle());
        try {
            this.pun = ((Long) new ReadMailProxy(this.mfB, new a(this, 1)).REMOTE_CALL("get", new Object[]{"/cgi-bin/readmail", hashMap, new Bundle()})).longValue();
        } catch (Exception e2) {
            x.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[]{e2.getMessage()});
        }
    }

    private void bli() {
        if (this.pod == null || this.pod.length() == 0) {
            x.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
            return;
        }
        new HashMap().put("mailid", this.pod);
        com.tencent.mm.plugin.qqmail.b.p.c cVar = new com.tencent.mm.plugin.qqmail.b.p.c();
        cVar.ppk = false;
        cVar.toBundle(new Bundle());
        try {
            new ReadMailProxy(this.mfB, new a(this, 2)).REMOTE_CALL("get", new Object[]{"/cgi-bin/setmailunread", new HashMap(), new Bundle()});
        } catch (Exception e) {
            x.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[]{e.getMessage()});
        }
    }

    private boolean blj() {
        this.puq = (String) new ReadMailProxy(this.mfB, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]);
        this.puE = (String) new ReadMailProxy(this.mfB, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]);
        try {
            this.puF = ((Integer) new ReadMailProxy(this.mfB, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
        } catch (Throwable e) {
            this.puF = -1;
            x.printErrStackTrace("MicroMsg.ReadMailUI", e, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
        }
        new ReadMailProxy(this.mfB, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
        Integer num = (Integer) new ReadMailProxy(this.mfB, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
        if (num == null) {
            x.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
            return true;
        }
        this.pup = 1;
        this.puo = num.intValue();
        if (bh.ov(this.puE)) {
            return true;
        }
        if (p.m(this, "com.tencent.androidqqmail")) {
            this.pux = 3;
            blh();
            return true;
        }
        this.gZO = ac.getContext().getSharedPreferences("QQMAIL", 4);
        if (this.gZO == null) {
            return true;
        }
        this.jcE = this.gZO.getLong("qqmail_downloadid", -1);
        this.put = ((Integer) new ReadMailProxy(this.mfB, null).REMOTE_CALL("getMailAppDownloadStatus", new Object[]{Long.valueOf(this.jcE)})).intValue();
        this.puu = this.gZO.getString("qqmail_downloadpath", "");
        if (this.put == 3 && e.bO(this.puu)) {
            this.pux = 2;
            blh();
            if (this.puv != null) {
                this.puv.TG();
            }
            return true;
        } else if (this.puo == 1) {
            return false;
        } else {
            this.puj.setVisibility(8);
            x.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[]{Integer.valueOf(this.puo)});
            return true;
        }
    }

    private void blk() {
        if (bh.ov(this.puq)) {
            x.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
            return;
        }
        vf(0);
        x.i("MicroMsg.ReadMailUI", "status:%d", new Object[]{Integer.valueOf(this.put)});
        switch (this.put) {
            case 1:
            case 2:
                this.pux = 1;
                bll();
                blh();
                return;
            case 3:
                if (!e.bO(this.puu)) {
                    break;
                }
                return;
        }
        this.pux = 0;
        vf(0);
        blh();
    }

    private void vf(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.puk.getLayoutParams();
        layoutParams.width = i;
        this.puk.setLayoutParams(layoutParams);
    }

    private void bll() {
        this.puv = new ak(Looper.getMainLooper(), new 4(this), true);
        this.puv.J(500, 500);
    }

    private void dj(int i, int i2) {
        new ReadMailProxy(this.mfB, null).REMOTE_CALL("reportKvState", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    protected void onResume() {
        if (this.puo == 1 && !blj()) {
            blk();
        }
        super.onResume();
    }
}
