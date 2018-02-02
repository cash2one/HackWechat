package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.b.n;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a$b;
import com.tencent.mm.ui.chatting.a$d;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ac$a;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, ac, b {
    protected af handler;
    public long kGB;
    private boolean mIsPause = true;
    private TextView mSn;
    private Animation qvq;
    private String talker;
    public boolean vnK;
    private boolean vzn = false;
    private c yAr = new 4(this);
    public int yDK;
    private GridView yDL;
    c yDM;
    private WeakReference<c.a> yDN;
    private Boolean yDO;
    private Boolean yDP;
    private TextView yDQ;
    private Runnable yDR = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI yEd;

        {
            this.yEd = r1;
        }

        public final void run() {
            if (this.yEd.yDL != null && this.yEd.yDL.getVisibility() != 4) {
                this.yEd.yDL.setVisibility(4);
            }
        }
    };
    private Runnable yDS = new 3(this);
    private boolean yDT = false;
    private long yDU = 0;
    Runnable yDV = new 8(this);
    public View yDW = null;
    private View yDX;
    private int yDY = -1;
    private View yDZ;
    private View yEa;
    private View yEb;
    private View yEc;

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i, gl glVar) {
        if (imageGalleryGridUI.yDL != null) {
            int firstVisiblePosition = imageGalleryGridUI.yDL.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.yDL.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.yDL.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    glVar.fwz.foL = iArr[0];
                    glVar.fwz.foM = iArr[1];
                    glVar.fwz.foN = childAt.getWidth();
                    glVar.fwz.foO = childAt.getHeight();
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.cpf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yDT = true;
        this.handler = new af();
        FX(0);
        com.tencent.mm.sdk.b.a.xef.b(this.yAr);
    }

    protected final boolean cmP() {
        return true;
    }

    protected void onDestroy() {
        this.handler.removeCallbacks(this.yDS);
        this.handler = null;
        o.PA().bp(0);
        com.tencent.mm.sdk.b.a.xef.c(this.yAr);
        super.onDestroy();
    }

    protected void onResume() {
        g.a.cuF().a(this);
        this.mIsPause = false;
        if (this.yDT) {
            if (g.a.cuF().yEF) {
                cui();
            } else {
                cuj();
            }
        }
        this.handler.postDelayed(this.yDS, 300);
        super.onResume();
        if (this.yDM != null) {
            this.yDM.yDD = true;
            c cVar = this.yDM;
            if (cVar.yDD) {
                cVar.notifyDataSetChanged();
            }
            if (g.a.cuF().yEF) {
                setMMTitle(getString(R.l.elE, new Object[]{Integer.valueOf(g.a.cuF().yDd.size())}));
            }
        }
        this.yDT = false;
        cuC();
    }

    protected void onPause() {
        g cuF = g.a.cuF();
        if (this != null) {
            cuF.yEG.remove(this);
        }
        this.mIsPause = true;
        super.onPause();
    }

    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        FX(1);
    }

    public void onBackPressed() {
        if (g.a.cuF().yEF) {
            cuj();
        } else if (this.yDO.booleanValue()) {
            super.onBackPressed();
        } else {
            if (this.yDK >= 0) {
                L(null, this.yDK);
            }
            finish();
        }
    }

    @TargetApi(11)
    private void FX(int i) {
        Intent intent = getIntent();
        this.yDO = Boolean.valueOf(intent.getIntExtra("kintent_intent_source", 0) == 1);
        this.talker = intent.getStringExtra("kintent_talker");
        this.yDK = intent.getIntExtra("kintent_image_index", 0);
        this.vnK = intent.getBooleanExtra("key_is_biz_chat", false);
        this.kGB = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yDP = Boolean.valueOf(true);
        setMMTitle(getString(R.l.dDB));
        setBackBtn(new 5(this));
        this.yDX = findViewById(R.h.cxj);
        View findViewById = findViewById(R.h.cgh);
        this.yDZ = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.cSL);
        this.yEa = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.cIE);
        this.yEb = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.bBE);
        this.yEc = findViewById;
        findViewById.setOnClickListener(this);
        this.mSn = (TextView) findViewById(R.h.bJU);
        this.yDQ = (TextView) findViewById(R.h.bJS);
        if (i == 0) {
            this.yDL = (GridView) findViewById(R.h.cpf);
            this.yDL.setOnItemClickListener(this);
            this.yDL.setNumColumns(3);
            au auVar = new au();
            if (this.vnK) {
                auVar.ar(this.kGB);
            }
            this.yDM = new c(this, auVar, this.talker);
            if (this.yDM.getCount() == 0) {
                this.yDQ.setVisibility(0);
                return;
            }
            this.yDQ.setVisibility(8);
            this.yDL.setAdapter(this.yDM);
            cuB();
        } else if (this.yDM != null) {
            this.yDM.notifyDataSetChanged();
            cuB();
        }
        this.yDL.setOnScrollListener(new OnScrollListener(this) {
            private Runnable mSS = new 1(this);
            final /* synthetic */ ImageGalleryGridUI yEd;

            {
                this.yEd = r2;
            }

            private void fq(boolean z) {
                if (z) {
                    this.yEd.mSn.removeCallbacks(this.mSS);
                    if (this.yEd.mSn.getVisibility() != 0) {
                        this.yEd.mSn.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.yEd.mController.xIM, R.a.bpZ);
                        this.yEd.mSn.setVisibility(0);
                        this.yEd.mSn.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                this.yEd.mSn.removeCallbacks(this.mSS);
                this.yEd.mSn.postDelayed(this.mSS, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    fq(true);
                } else if (i == 0) {
                    fq(false);
                }
                o.PA().bp(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CharSequence charSequence;
                Context context = this.yEd;
                au auVar = (au) context.yDM.getItem(i);
                if (auVar == null) {
                    charSequence = null;
                } else {
                    charSequence = com.tencent.mm.ui.gridviewheaders.a.cxk().a(new Date(auVar.field_createTime), context);
                }
                this.yEd.mSn.setText(charSequence);
            }
        });
    }

    private void cuB() {
        int firstVisiblePosition = this.yDL.getFirstVisiblePosition();
        int lastVisiblePosition = this.yDL.getLastVisiblePosition();
        int i = this.yDK;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.yDL.setSelection(i);
        }
    }

    public void finish() {
        super.finish();
        g.a.cuF().detach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g.a I;
        au auVar = (au) this.yDM.getItem(i);
        String str = auVar.field_content;
        if (str != null) {
            I = g.a.I(str, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null && I.type == 6) {
            bj(auVar);
        } else if (I != null && I.type == 3) {
            str = p.A(I.url, "message");
            r3 = p.A(I.hba, "message");
            PackageInfo packageInfo = getPackageInfo(this.mController.xIM, I.appId);
            r4 = packageInfo == null ? null : packageInfo.versionName;
            r1 = packageInfo == null ? 0 : packageInfo.versionCode;
            String str2 = I.appId;
            r6 = auVar.field_msgId;
            long j2 = auVar.field_msgSvrId;
            if ((str == null || str.length() == 0) && (r3 == null || r3.length() == 0)) {
                x.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                return;
            }
            if (an.isMobile(this.mController.xIM) ? r3 != null && r3.length() > 0 : str == null || str.length() <= 0) {
                str = r3;
            }
            Intent intent = new Intent();
            intent.putExtra("msg_id", r6);
            intent.putExtra("rawUrl", str);
            intent.putExtra("version_name", r4);
            intent.putExtra("version_code", r1);
            intent.putExtra("usePlugin", true);
            intent.putExtra("geta8key_username", this.talker);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
            intent.putExtra("KAppId", str2);
            r1 = bi(auVar);
            intent.putExtra("pre_username", r1);
            intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
            if (auVar != null) {
                intent.putExtra("preUsername", r1);
            }
            intent.putExtra("preChatName", this.talker);
            intent.putExtra("preChatTYPE", t.N(r1, this.talker));
            intent.putExtra("preMsgIndex", 0);
            d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
        } else if (I == null || I.type != 5) {
            Intent intent2;
            if (I != null && I.type == 19) {
                intent2 = new Intent();
                intent2.putExtra("message_id", auVar.field_msgId);
                intent2.putExtra("record_xml", I.hbB);
                d.b(this.mController.xIM, "record", ".ui.RecordMsgDetailUI", intent2);
            } else if (I != null && I.type == 24) {
                com.tencent.mm.sdk.b.b lhVar = new lh();
                lhVar.fCF.context = this.mController.xIM;
                lhVar.fCF.fqm = auVar.field_msgId;
                lhVar.fCF.fCG = I.hbB;
                com.tencent.mm.sdk.b.a.xef.m(lhVar);
            } else if (I != null && I.type == 7) {
                n aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(I.appId, false);
                if (aZ != null && aZ.Yz()) {
                    Object obj;
                    r1 = this.talker;
                    if (s.eV(r1)) {
                        r1 = ba.hP(auVar.field_content);
                    }
                    r6 = auVar.field_msgSvrId;
                    int i2 = (aZ == null || !p.m(this.mController.xIM, aZ.field_packageName)) ? 6 : 3;
                    if (I.type == 2) {
                        i2 = 4;
                    } else if (I.type == 5) {
                        i2 = 1;
                    }
                    com.tencent.mm.sdk.b.b nhVar = new nh();
                    nhVar.fFl.context = this.mController.xIM;
                    nhVar.fFl.scene = 1;
                    nhVar.fFl.fFm = I.appId;
                    nhVar.fFl.packageName = aZ == null ? null : aZ.field_packageName;
                    nhVar.fFl.msgType = I.type;
                    nhVar.fFl.fzO = r1;
                    nhVar.fFl.fFn = i2;
                    nhVar.fFl.mediaTagName = I.mediaTagName;
                    nhVar.fFl.fFo = r6;
                    nhVar.fFl.fFp = "";
                    com.tencent.mm.sdk.b.a.xef.m(nhVar);
                    j jVar = q.a.vcu;
                    if (com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xIM, aZ) || jVar == null) {
                        obj = null;
                    } else {
                        if (!bh.ov(aZ.fQK)) {
                            x.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[]{aZ.fQK, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.aY(this.mController.xIM, aZ.fQK))});
                            if (com.tencent.mm.pluginsdk.model.app.q.aY(this.mController.xIM, aZ.fQK)) {
                                obj = 1;
                            }
                        }
                        com.tencent.mm.sdk.b.b gmVar = new gm();
                        gmVar.fwC.actionCode = 2;
                        gmVar.fwC.scene = 1;
                        gmVar.fwC.appId = aZ.field_appId;
                        gmVar.fwC.context = this.mController.xIM;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        Intent intent3 = new Intent();
                        ActionBarActivity actionBarActivity = this.mController.xIM;
                        jVar.I(aZ.field_appId, 1, 1);
                        obj = 1;
                    }
                    if (obj != null) {
                        return;
                    }
                    if (I.fny == null || I.fny.length() == 0) {
                        r1 = auVar.field_content;
                        if (auVar.field_isSend == 0) {
                            i2 = auVar.field_isSend;
                            if (!this.vnK && s.eV(this.talker) && r1 != null && i2 == 0) {
                                r1 = ba.hQ(r1);
                            }
                        }
                        g.a fT = g.a.fT(r1);
                        f aZ2 = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, true);
                        if (aZ2 == null || !p.m(this.mController.xIM, aZ2.field_packageName)) {
                            r0 = p.w(this.mController.xIM, fT.appId, "message");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", r0);
                            d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent2);
                        } else if (aZ2.field_status == 3) {
                            x.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + aZ2.field_packageName);
                        } else if (!p.b(this.mController.xIM, aZ2)) {
                            x.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[]{aZ2.field_appName});
                            Toast.makeText(this.mController.xIM, getString(R.l.emo, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xIM, aZ2, null)}), 1).show();
                        } else if (!a(auVar, aZ2)) {
                            IMediaObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = fT.extInfo;
                            if (fT.fny != null && fT.fny.length() > 0) {
                                com.tencent.mm.pluginsdk.model.app.b Rz = com.tencent.mm.pluginsdk.model.app.an.aqd().Rz(fT.fny);
                                wXAppExtendObject.filePath = Rz == null ? null : Rz.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = 620823552;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = fT.title;
                            wXMediaMessage.description = fT.description;
                            wXMediaMessage.messageAction = fT.messageAction;
                            wXMediaMessage.messageExt = fT.messageExt;
                            wXMediaMessage.thumbData = e.d(o.Pw().lm(auVar.field_imgPath), 0, -1);
                            new com.tencent.mm.ui.chatting.an(this).a(aZ2.field_packageName, wXMediaMessage, aZ2.field_appId, aZ2.field_openId);
                        }
                    } else if (this.vzn) {
                        intent2 = new Intent();
                        intent2.setClassName(this.mController.xIM, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent2.putExtra("app_msg_id", auVar.field_msgId);
                        startActivityForResult(intent2, i.CTRL_INDEX);
                    } else {
                        u.fI(this.mController.xIM);
                    }
                }
            } else if (auVar.cjh() || auVar.cje() || auVar.cji() || auVar.cjm()) {
                if (I == null || bh.ov(I.hdo)) {
                    r0 = null;
                } else {
                    r1 = auVar.field_imgPath;
                    r4 = new Intent();
                    r4.putExtra("IsAd", false);
                    r4.putExtra("KStremVideoUrl", I.hdo);
                    r4.putExtra("KThumUrl", I.hdt);
                    r4.putExtra("KThumbPath", r1);
                    r4.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
                    r4.putExtra("KMediaVideoTime", I.hdp);
                    r4.putExtra("StremWebUrl", I.hds);
                    r4.putExtra("StreamWording", I.hdr);
                    r4.putExtra("KMediaTitle", I.title);
                    str = auVar.field_talker;
                    boolean endsWith = str.endsWith("@chatroom");
                    r1 = endsWith ? ba.hP(auVar.field_content) : str;
                    r4.putExtra("KSta_StremVideoAduxInfo", I.hdu);
                    r4.putExtra("KSta_StremVideoPublishId", I.hdv);
                    r4.putExtra("KSta_SourceType", 1);
                    r4.putExtra("KSta_Scene", endsWith ? a$b.TalkChat.value : a$b.Chat.value);
                    r4.putExtra("KSta_FromUserName", r1);
                    r4.putExtra("KSta_ChatName", str);
                    r4.putExtra("KSta_MsgId", auVar.field_msgSvrId);
                    r4.putExtra("KSta_SnsStatExtStr", I.fGG);
                    if (endsWith) {
                        r4.putExtra("KSta_ChatroomMembercount", m.gl(str));
                    }
                    d.b(this.mController.xIM, "sns", ".ui.VideoAdPlayerUI", r4);
                    r0 = 1;
                }
                if (r0 == null) {
                    L(view, i);
                }
            } else if (I != null && I.type == 15) {
                r0 = I.hbE;
                if (TextUtils.isEmpty(r0)) {
                    r0 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yh(I.url);
                }
                if (TextUtils.isEmpty(r0)) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
                    intent4.putExtra("rawUrl", I.url);
                    d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent4);
                    return;
                }
                x.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                intent2 = new Intent();
                intent2.putExtra("extra_id", r0);
                intent2.putExtra("preceding_scence", 123);
                intent2.putExtra("download_entrance_scene", 23);
                d.b(this.mController.xIM, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                com.tencent.mm.plugin.report.service.g.pQN.h(10993, new Object[]{Integer.valueOf(2), r0});
            } else if (I != null && I.type == 26) {
                r1 = I.tid;
                str = I.hdm;
                r3 = I.desc;
                r4 = I.iconUrl;
                r6 = I.secondUrl;
                r7 = I.pageType;
                if (r1 != 0) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("geta8key_username", bi(auVar));
                    intent5.putExtra("rawUrl", I.gjD);
                    intent5.putExtra("topic_id", r1);
                    intent5.putExtra("topic_name", str);
                    intent5.putExtra("topic_desc", r3);
                    intent5.putExtra("topic_icon_url", r4);
                    intent5.putExtra("topic_ad_url", r6);
                    intent5.putExtra("extra_scence", 23);
                    d.b(this.mController.xIM, "emoji", ".ui.EmojiStoreTopicUI", intent5);
                    return;
                }
                x.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            } else if (I == null || I.type != 27) {
                x.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[]{auVar.field_talker, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.getType()), auVar.field_content});
                if (I.url != null && !I.url.equals("") && I.url != null && !I.url.equals("")) {
                    r1 = p.A(I.url, s.eV(this.talker) ? "groupmessage" : "singlemessage");
                    str = I.url;
                    r3 = getPackageInfo(this.mController.xIM, I.appId);
                    r4 = new Intent();
                    r4.putExtra("rawUrl", r1);
                    r4.putExtra("webpageTitle", I.title);
                    if (I.appId != null && ("wx751a1acca5688ba3".equals(I.appId) || "wxfbc915ff7c30e335".equals(I.appId) || "wx482a4001c37e2b74".equals(I.appId))) {
                        r1 = new Bundle();
                        r1.putString("jsapi_args_appid", I.appId);
                        r4.putExtra("jsapiargs", r1);
                    }
                    if (bh.ov(str)) {
                        r4.putExtra("shortUrl", I.url);
                    } else {
                        r4.putExtra("shortUrl", str);
                    }
                    r4.putExtra("version_name", r3 == null ? null : r3.versionName);
                    r4.putExtra("version_code", r3 == null ? 0 : r3.versionCode);
                    if (!bh.ov(I.fGz)) {
                        r4.putExtra("srcUsername", I.fGz);
                        r4.putExtra("srcDisplayname", I.fGA);
                    }
                    r4.putExtra("msg_id", auVar.field_msgId);
                    r4.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    r4.putExtra("KAppId", I.appId);
                    r4.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
                    r4.putExtra("pre_username", bi(auVar));
                    r4.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    r0 = bi(auVar);
                    r1 = com.tencent.mm.z.q.FS();
                    r4.putExtra("preUsername", r0);
                    r4.putExtra("preChatName", r1);
                    r4.putExtra("preChatTYPE", t.N(r0, r1));
                    r4.putExtra("preMsgIndex", 0);
                    d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", r4);
                }
            } else {
                r1 = I.tid;
                str = I.hdm;
                r3 = I.desc;
                r4 = I.iconUrl;
                r6 = I.secondUrl;
                r7 = I.pageType;
                if (r1 != 0) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("geta8key_username", bi(auVar));
                    intent6.putExtra("rawUrl", I.gjD);
                    intent6.putExtra("set_id", r1);
                    intent6.putExtra("set_title", str);
                    intent6.putExtra("set_iconURL", r4);
                    intent6.putExtra("set_desc", r3);
                    intent6.putExtra("headurl", r6);
                    intent6.putExtra("pageType", r7);
                    d.b(this.mController.xIM, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent6);
                    return;
                }
                x.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            }
        } else if (I.url != null && !I.url.equals("")) {
            r1 = p.A(I.url, this.talker.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            str = I.url;
            r3 = getPackageInfo(this.mController.xIM, I.appId);
            r4 = new Intent();
            r4.putExtra("rawUrl", r1);
            r4.putExtra("webpageTitle", I.title);
            if (I.appId != null && ("wx751a1acca5688ba3".equals(I.appId) || "wxfbc915ff7c30e335".equals(I.appId) || "wx482a4001c37e2b74".equals(I.appId))) {
                r1 = new Bundle();
                r1.putString("jsapi_args_appid", I.appId);
                r4.putExtra("jsapiargs", r1);
            }
            if (bh.ov(str)) {
                r4.putExtra("shortUrl", I.url);
            } else {
                r4.putExtra("shortUrl", str);
            }
            r4.putExtra("version_name", r3 == null ? null : r3.versionName);
            r4.putExtra("version_code", r3 == null ? 0 : r3.versionCode);
            if (!bh.ov(I.fGz)) {
                r4.putExtra("srcUsername", I.fGz);
                r4.putExtra("srcDisplayname", I.fGA);
            }
            r4.putExtra("msg_id", auVar.field_msgId);
            r4.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
            r4.putExtra("KAppId", I.appId);
            r4.putExtra("geta8key_username", this.talker);
            r1 = bi(auVar);
            r4.putExtra("pre_username", r1);
            r4.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
            r4.putExtra("preUsername", r1);
            r4.putExtra("preChatName", this.talker);
            r4.putExtra("preChatTYPE", t.N(r1, this.talker));
            r4.putExtra("preMsgIndex", 0);
            d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", r4);
        }
    }

    private boolean a(au auVar, f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.GalleryGridUI", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", av(this.mController.xIM, "com.tencent.mobileqq"));
        intent.putExtra(ConstantsAPI$Token.WX_TOKEN_PLATFORMID_KEY, ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
        ar.Hg();
        Object obj = com.tencent.mm.z.c.CU().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            }
        }
        try {
            startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String av(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String bi(au auVar) {
        String az = bh.az(this.talker, "");
        boolean endsWith = this.talker.endsWith("@chatroom");
        if (!endsWith) {
            return az;
        }
        String hP;
        if (endsWith) {
            hP = ba.hP(auVar.field_content);
            if (hP != null) {
            }
        }
        hP = az;
        return hP;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            if (aZ == null) {
                Object obj = packageInfo;
            } else {
                str2 = aZ.field_packageName;
            }
        }
        if (str2 != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    private void bj(au auVar) {
        long j = this.yDU + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yDU = currentTimeMillis;
        if (j < currentTimeMillis) {
            ar.Hg();
            this.vzn = com.tencent.mm.z.c.isSDCardAvailable();
        }
        if (this.vzn) {
            Intent intent = new Intent();
            intent.setClassName(this.mController.xIM, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", auVar.field_msgId);
            startActivity(intent);
            return;
        }
        u.fI(this.mController.xIM);
    }

    private void L(View view, int i) {
        if (this.yDM != null) {
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_biz_chat_id", this.kGB);
            intent.putExtra("key_is_biz_chat", this.vnK);
            intent.putExtra("intent.key.with.footer", true);
            au auVar = (au) this.yDM.getItem(i);
            if (auVar != null) {
                int width;
                int height;
                int i2 = getResources().getConfiguration().orientation;
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("img_gallery_msg_id", auVar.field_msgId).putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId).putExtra("img_gallery_talker", auVar.field_talker).putExtra("img_gallery_chatroom_name", auVar.field_talker).putExtra("img_gallery_orientation", i2);
                if (view != null) {
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                } else {
                    intent.putExtra("img_gallery_back_from_grid", true);
                }
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }
    }

    public boolean onPreDraw() {
        c.a aVar = (c.a) this.yDN.get();
        if (aVar != null) {
            ViewTreeObserver viewTreeObserver = aVar.qqc.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = aVar.qqc.getMeasuredWidth();
                int measuredHeight = aVar.qqc.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = (LayoutParams) aVar.yyq.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.yyq.setLayoutParams(layoutParams);
                    View view = aVar.yyq;
                    TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.yDW = view;
                        this.handler.postDelayed(new 7(this, view, decelerateInterpolator), 700);
                    }
                }
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(getString(R.l.ela))) {
            g.a.cuF().clear();
            cui();
        } else {
            cuj();
        }
        return false;
    }

    private void cui() {
        setMMTitle(getString(R.l.elE, new Object[]{Integer.valueOf(g.a.cuF().yDd.size())}));
        g.a.cuF().yEF = true;
        if (this.yDM != null) {
            if (this.qvq == null) {
                this.qvq = AnimationUtils.loadAnimation(this, R.a.bqo);
            }
            c cVar = this.yDM;
            cVar.hKW = false;
            cVar.notifyDataSetChanged();
            this.yDX.setVisibility(0);
            this.yDX.startAnimation(this.qvq);
            this.yDZ.setEnabled(false);
            this.yEa.setEnabled(false);
            this.yEb.setEnabled(false);
            this.yEc.setEnabled(false);
            this.yDY = this.yDL.getPaddingBottom();
            this.yDL.setPadding(this.yDL.getPaddingLeft(), this.yDL.getPaddingTop(), this.yDL.getPaddingRight(), com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bvR));
            com.tencent.mm.plugin.report.service.g.pQN.h(11627, new Object[]{Integer.valueOf(2)});
            removeOptionMenu(0);
            addTextOptionMenu(0, getString(R.l.ekZ), this);
        }
    }

    private void cuC() {
        boolean z = !g.a.cuF().yDd.isEmpty() && g.a.cuF().yEF;
        if (z) {
            this.yDZ.setEnabled(true);
            this.yEa.setEnabled(true);
            this.yEb.setEnabled(true);
            this.yEc.setEnabled(true);
            return;
        }
        this.yDZ.setEnabled(false);
        this.yEa.setEnabled(false);
        this.yEb.setEnabled(false);
        this.yEc.setEnabled(false);
    }

    public final void cuj() {
        g.a.cuF().yEF = false;
        setMMTitle(getString(R.l.dDB));
        if (this.yDM != null) {
            this.yDM.notifyDataSetChanged();
            if (this.yDY >= 0) {
                this.yDL.setPadding(this.yDL.getPaddingLeft(), this.yDL.getPaddingTop(), this.yDL.getPaddingRight(), this.yDY);
            }
            this.yDX.setVisibility(8);
            removeOptionMenu(0);
            addTextOptionMenu(0, getString(R.l.ela), this);
        }
    }

    public void onClick(View view) {
        if (!g.a.cuF().yDd.isEmpty()) {
            boolean endsWith = this.talker.toLowerCase().endsWith("@chatroom");
            final List<au> list = g.a.cuF().yDd;
            if (list != null && !list.isEmpty()) {
                au auVar;
                if (view.getId() == R.h.bBE) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11627, new Object[]{Integer.valueOf(5)});
                    Set treeSet = new TreeSet();
                    for (au auVar2 : list) {
                        treeSet.add(Long.valueOf(auVar2.field_msgId));
                    }
                    h.a((Context) this, getString(R.l.dTV), "", getString(R.l.dYt), getString(R.l.dEn), new 9(this, treeSet), null);
                } else if (view.getId() == R.h.cgh) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(219, 18, 1, true);
                    final cf cfVar = new cf();
                    if (com.tencent.mm.pluginsdk.model.h.a(this.mController.xIM, cfVar, this.talker, list, false, false)) {
                        b(cfVar);
                        dg(list);
                    } else if (list.size() > 1) {
                        String string;
                        Context context = this.mController.xIM;
                        String string2 = cfVar.fqp.fqv >= 0 ? this.mController.xIM.getString(R.l.efu) : this.mController.xIM.getString(R.l.eft);
                        r2 = "";
                        if (cfVar.fqp.fqv >= 0) {
                            string = this.mController.xIM.getString(R.l.dUc);
                        } else {
                            string = this.mController.xIM.getString(R.l.eAd);
                        }
                        h.a(context, string2, r2, string, this.mController.xIM.getString(R.l.dUa), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ ImageGalleryGridUI yEd;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (cfVar.fqp.type == 14 && cfVar.fqp.fqr.weU.size() == 0) {
                                    this.yEd.cuj();
                                    return;
                                }
                                this.yEd.b(cfVar);
                                ImageGalleryGridUI.dg(list);
                            }
                        }, null);
                    } else {
                        h.h(this.mController.xIM, cfVar.fqp.fqv, 0);
                    }
                } else if (view.getId() == R.h.cSL) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(219, 19, 1, true);
                    com.tencent.mm.ui.chatting.j.a(this, list, endsWith, this.talker, this);
                    cuj();
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11627, new Object[]{Integer.valueOf(3)});
                    List dl = dl(list);
                    if (dl.size() != list.size()) {
                        h.a(this.mController.xIM, R.l.elu, R.l.dGO, new 2(this, dl), null);
                        return;
                    }
                    auVar2 = (au) dl.get(0);
                    if (list.size() == 1 && auVar2 != null && auVar2.aNc()) {
                        r2 = auVar2.field_content;
                        g.a aVar = null;
                        if (r2 != null) {
                            aVar = g.a.I(r2, auVar2.field_reserved);
                        }
                        if (aVar != null && aVar.type == 6) {
                            bj(auVar2);
                            return;
                        }
                        return;
                    }
                    b.c(this, list);
                    cuj();
                }
            }
        }
    }

    private static void dg(List<au> list) {
        for (au a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.ypb, a$d.Samll, a, 0);
        }
    }

    private static List<au> dl(List<au> list) {
        List<au> arrayList = new ArrayList();
        for (au auVar : list) {
            if (!(b.aY(auVar) || b.aZ(auVar))) {
                arrayList.add(auVar);
            }
        }
        return arrayList;
    }

    private void b(cf cfVar) {
        cfVar.fqp.activity = this;
        cfVar.fqp.fqw = 45;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        if (cfVar.fqq.ret != -2 && cfVar.fqq.ret <= 0 && cfVar.fqq.ret <= 0) {
            cuj();
            if (14 != cfVar.fqp.type) {
                x.d("MicroMsg.GalleryGridUI", "not record type, do not report");
            } else if (cfVar.fqp.fqs == null) {
                x.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(11142, new Object[]{Integer.valueOf(cfVar.fqp.fqs.wfk), Integer.valueOf(cfVar.fqp.fqs.wfl), Integer.valueOf(cfVar.fqp.fqs.wfm), Integer.valueOf(cfVar.fqp.fqs.wfn), Integer.valueOf(cfVar.fqp.fqs.wfo), Integer.valueOf(cfVar.fqp.fqs.wfp), Integer.valueOf(cfVar.fqp.fqs.wfq), Integer.valueOf(cfVar.fqp.fqs.wfr), Integer.valueOf(cfVar.fqp.fqs.wfs), Integer.valueOf(cfVar.fqp.fqs.wft), Integer.valueOf(cfVar.fqp.fqs.wfu), Integer.valueOf(cfVar.fqp.fqs.wfv), Integer.valueOf(cfVar.fqp.fqs.wfw), Integer.valueOf(cfVar.fqp.fqs.wfx), Integer.valueOf(cfVar.fqp.fqs.wfy)});
            }
        }
    }

    public final void cuD() {
        if (this.yDM != null && this.mIsPause) {
            this.yDM.yDD = true;
        }
        setMMTitle(getString(R.l.elE, new Object[]{Integer.valueOf(g.a.cuF().yDd.size())}));
        cuC();
    }

    public final void clear() {
        if (this.yDM != null && this.mIsPause) {
            this.yDM.yDD = true;
        }
        cuC();
    }

    public final void crT() {
    }

    public final void a(ac$a com_tencent_mm_ui_chatting_ac_a) {
    }

    public final boolean crU() {
        return true;
    }

    public final void b(ac$a com_tencent_mm_ui_chatting_ac_a) {
        if (com_tencent_mm_ui_chatting_ac_a == ac$a.del) {
            this.yDM.Xy();
            this.yDM.notifyDataSetChanged();
        }
        cuj();
    }
}
