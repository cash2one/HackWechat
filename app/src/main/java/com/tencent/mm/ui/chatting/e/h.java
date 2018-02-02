package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a.b$e;
import com.tencent.mm.ui.chatting.a.b.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;

public final class h extends b {
    int jRy = -1;
    HashSet<Integer> yHN = new HashSet();
    int yHq = 0;

    class b extends a {
        TextView iir;
        ImageView jCP;
        TextView mxT;
        final /* synthetic */ h yHO;

        public b(h hVar, View view) {
            this.yHO = hVar;
            super(view);
            this.jCP = (ImageView) view.findViewById(R.h.cgI);
            this.iir = (TextView) view.findViewById(R.h.cgu);
            this.mxT = (TextView) view.findViewById(R.h.cgZ);
            this.mxT.setVisibility(0);
        }
    }

    static /* synthetic */ void a(h hVar, a aVar) {
        ar.Hg();
        cf dH = c.Fa().dH(aVar.fqm);
        g.a fT = g.a.fT(dH.field_content);
        if (fT.url != null && !fT.url.equals("")) {
            String A = p.A(fT.url, hVar.jRw.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            String str = fT.url;
            PackageInfo packageInfo = getPackageInfo(hVar.mContext, fT.appId);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", A);
            intent.putExtra("webpageTitle", fT.title);
            if (fT.appId != null && ("wx751a1acca5688ba3".equals(fT.appId) || "wxfbc915ff7c30e335".equals(fT.appId) || "wx482a4001c37e2b74".equals(fT.appId))) {
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", fT.appId);
                intent.putExtra("jsapiargs", bundle);
            }
            if (bh.ov(str)) {
                intent.putExtra("shortUrl", fT.url);
            } else {
                intent.putExtra("shortUrl", str);
            }
            intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            if (!bh.ov(fT.fGz)) {
                intent.putExtra("srcUsername", fT.fGz);
                intent.putExtra("srcDisplayname", fT.fGA);
            }
            intent.putExtra("msg_id", dH.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(dH.field_msgSvrId));
            intent.putExtra("KAppId", fT.appId);
            intent.putExtra("geta8key_username", hVar.jRw);
            A = g(dH, s.eV(hVar.jRw));
            intent.putExtra("pre_username", A);
            intent.putExtra("prePublishId", "msg_" + Long.toString(dH.field_msgSvrId));
            intent.putExtra("preUsername", A);
            intent.putExtra("preChatName", hVar.jRw);
            intent.putExtra("preChatTYPE", t.N(A, hVar.jRw));
            intent.putExtra("preMsgIndex", 0);
            d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    static /* synthetic */ void b(h hVar, a aVar) {
        ar.Hg();
        au dH = c.Fa().dH(aVar.fqm);
        g.a fT = g.a.fT(dH.field_content);
        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
        if (aZ != null && aZ.Yz()) {
            Object obj;
            Intent intent;
            String str = hVar.jRw;
            if (s.eV(str)) {
                str = ba.hP(dH.field_content);
            }
            long j = dH.field_msgSvrId;
            int i = (aZ == null || !p.m(hVar.mContext, aZ.field_packageName)) ? 6 : 3;
            if (fT.type == 2) {
                i = 4;
            } else if (fT.type == 5) {
                i = 1;
            }
            com.tencent.mm.sdk.b.b nhVar = new nh();
            nhVar.fFl.context = hVar.mContext;
            nhVar.fFl.scene = 1;
            nhVar.fFl.fFm = fT.appId;
            nhVar.fFl.packageName = aZ == null ? null : aZ.field_packageName;
            nhVar.fFl.msgType = fT.type;
            nhVar.fFl.fzO = str;
            nhVar.fFl.fFn = i;
            nhVar.fFl.mediaTagName = fT.mediaTagName;
            nhVar.fFl.fFo = j;
            nhVar.fFl.fFp = "";
            com.tencent.mm.sdk.b.a.xef.m(nhVar);
            j jVar = q.a.vcu;
            if (com.tencent.mm.pluginsdk.model.app.g.a(hVar.mContext, aZ) || jVar == null) {
                obj = null;
            } else {
                if (!bh.ov(aZ.fQK)) {
                    x.i("MicroMsg.UrlHistoryListPresenter", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[]{aZ.fQK, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.aY(hVar.mContext, aZ.fQK))});
                    if (com.tencent.mm.pluginsdk.model.app.q.aY(hVar.mContext, aZ.fQK)) {
                        obj = 1;
                    }
                }
                com.tencent.mm.sdk.b.b gmVar = new gm();
                gmVar.fwC.actionCode = 2;
                gmVar.fwC.scene = 1;
                gmVar.fwC.appId = aZ.field_appId;
                gmVar.fwC.context = hVar.mContext;
                com.tencent.mm.sdk.b.a.xef.m(gmVar);
                intent = new Intent();
                jVar.I(aZ.field_appId, 1, 1);
                obj = 1;
            }
            if (obj != null) {
                return;
            }
            if (fT.fny == null || fT.fny.length() == 0) {
                str = dH.field_content;
                if (dH.field_isSend == 0) {
                    i = dH.field_isSend;
                    if (s.eV(hVar.jRw) && str != null && i == 0) {
                        str = ba.hQ(str);
                    }
                }
                g.a fT2 = g.a.fT(str);
                f aZ2 = com.tencent.mm.pluginsdk.model.app.g.aZ(fT2.appId, true);
                if (aZ2 == null || !p.m(hVar.mContext, aZ2.field_packageName)) {
                    str = p.w(hVar.mContext, fT2.appId, "message");
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
                } else if (aZ2.field_status == 3) {
                    x.e("MicroMsg.UrlHistoryListPresenter", "requestAppShow fail, app is in blacklist, packageName = " + aZ2.field_packageName);
                } else if (!p.b(hVar.mContext, aZ2)) {
                    x.e("MicroMsg.UrlHistoryListPresenter", "The app %s signature is incorrect.", new Object[]{aZ2.field_appName});
                    Toast.makeText(hVar.mContext, hVar.mContext.getString(R.l.emo, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(hVar.mContext, aZ2, null)}), 1).show();
                } else if (!hVar.a(dH, aZ2)) {
                    IMediaObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = fT2.extInfo;
                    if (fT2.fny != null && fT2.fny.length() > 0) {
                        com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(fT2.fny);
                        wXAppExtendObject.filePath = Rz == null ? null : Rz.field_fileFullPath;
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = 620823552;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = fT2.title;
                    wXMediaMessage.description = fT2.description;
                    wXMediaMessage.messageAction = fT2.messageAction;
                    wXMediaMessage.messageExt = fT2.messageExt;
                    wXMediaMessage.thumbData = e.d(o.Pw().lm(dH.field_imgPath), 0, -1);
                    new com.tencent.mm.ui.chatting.an(hVar.mContext).a(aZ2.field_packageName, wXMediaMessage, aZ2.field_appId, aZ2.field_openId);
                }
            } else if (hVar.cvr()) {
                Intent intent2 = new Intent();
                intent2.setClassName(hVar.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                intent2.putExtra("app_msg_id", dH.field_msgId);
                hVar.mContext.startActivity(intent2);
            } else {
                u.fI(hVar.mContext);
            }
        }
    }

    static /* synthetic */ void c(h hVar, a aVar) {
        ar.Hg();
        g.a fT = g.a.fT(c.Fa().dH(aVar.fqm).field_content);
        Object obj = fT.hbE;
        if (TextUtils.isEmpty(obj)) {
            obj = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yh(fT.url);
        }
        if (TextUtils.isEmpty(obj)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
            intent.putExtra("rawUrl", fT.url);
            d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        x.d("MicroMsg.UrlHistoryListPresenter", "start emoji detail from brandcontact");
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", obj);
        intent2.putExtra("preceding_scence", 123);
        intent2.putExtra("download_entrance_scene", 23);
        d.b(hVar.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        com.tencent.mm.plugin.report.service.g.pQN.h(10993, new Object[]{Integer.valueOf(2), obj});
    }

    static /* synthetic */ void d(h hVar, a aVar) {
        ar.Hg();
        cf dH = c.Fa().dH(aVar.fqm);
        g.a fT = g.a.fT(dH.field_content);
        int i = fT.tid;
        String str = fT.hdm;
        String str2 = fT.desc;
        String str3 = fT.iconUrl;
        String str4 = fT.secondUrl;
        int i2 = fT.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", g(dH, s.eV(hVar.jRw)));
            intent.putExtra("rawUrl", fT.gjD);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 23);
            d.b(hVar.mContext, "emoji", ".ui.EmojiStoreTopicUI", intent);
            return;
        }
        x.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
    }

    static /* synthetic */ void e(h hVar, a aVar) {
        ar.Hg();
        cf dH = c.Fa().dH(aVar.fqm);
        g.a fT = g.a.fT(dH.field_content);
        int i = fT.tid;
        String str = fT.hdm;
        String str2 = fT.desc;
        String str3 = fT.iconUrl;
        String str4 = fT.secondUrl;
        int i2 = fT.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", g(dH, s.eV(hVar.jRw)));
            intent.putExtra("rawUrl", fT.gjD);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            d.b(hVar.mContext, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            return;
        }
        x.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
    }

    public h(Context context) {
        super(context);
    }

    public final int getType() {
        this.yHN.add(Integer.valueOf(5));
        this.yHN.add(Integer.valueOf(7));
        this.yHN.add(Integer.valueOf(27));
        this.yHN.add(Integer.valueOf(26));
        this.yHN.add(Integer.valueOf(15));
        return -1;
    }

    public final void cur() {
        this.yHf.cuv();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dm().F(new 1(this, true));
    }

    public final String WW() {
        return this.mContext.getString(R.l.dDA);
    }

    public final String cuu() {
        return this.mContext.getString(R.l.dDA);
    }

    public final b$e cus() {
        return new b$e(this) {
            final /* synthetic */ h yHO;

            {
                this.yHO = r1;
            }

            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                x.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
                if (bVar == null) {
                    x.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[]{Integer.valueOf(i)});
                    return;
                }
                a aVar = (a) bVar;
                if (aVar.getType() == 5) {
                    h.a(this.yHO, aVar);
                } else if (aVar.getType() == 7) {
                    h.b(this.yHO, aVar);
                } else if (aVar.getType() == 15) {
                    h.c(this.yHO, aVar);
                } else if (aVar.getType() == 26) {
                    h.d(this.yHO, aVar);
                } else if (aVar.getType() == 27) {
                    h.e(this.yHO, aVar);
                } else {
                    x.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[]{Integer.valueOf(aVar.getType())});
                }
            }

            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                x.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
                new l(view.getContext()).b(view, new 1(this), new 2(this, bVar, i));
            }
        };
    }

    public final RecyclerView.t l(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dtq, viewGroup, false));
    }

    public final void a(a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FD(i);
        if (bh.ov(aVar2.desc) || !bh.ov(aVar2.bhd)) {
            bVar.iir.setVisibility(8);
        } else {
            bVar.iir.setVisibility(0);
            bVar.iir.setText(bh.az(aVar2.desc, ""));
        }
        Bitmap a = o.Pw().a(aVar2.imagePath, com.tencent.mm.bv.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bv.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                a = com.tencent.mm.platformtools.j.a(new com.tencent.mm.pluginsdk.model.t(aVar2.imagePath, aVar2.type, "@S", false));
                if (a == null) {
                    bVar.jCP.setImageResource(R.k.dvD);
                    bVar.mxT.setText(bh.az(aVar2.bhd, ""));
                    b.d(bVar.mxT, this.yHg.yyw);
                }
            }
        }
        bVar.jCP.setImageBitmap(a);
        bVar.mxT.setText(bh.az(aVar2.bhd, ""));
        b.d(bVar.mxT, this.yHg.yyw);
    }

    private boolean a(au auVar, f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", av(this.mContext, "com.tencent.mobileqq"));
        intent.putExtra(ConstantsAPI$Token.WX_TOKEN_PLATFORMID_KEY, ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
        ar.Hg();
        Object obj = c.CU().get(9, null);
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
                x.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
            }
        }
        try {
            this.mContext.startActivity(intent);
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
            x.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
        }
        return null;
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
                x.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
