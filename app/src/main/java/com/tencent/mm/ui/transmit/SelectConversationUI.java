package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.b.af;
import com.tencent.mm.k.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bx;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@a(19)
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int zoY = s.p(new int[]{1, 2});
    private String fDP;
    private au fEJ;
    private long fqk;
    private long fqm;
    private int fromScene = 0;
    private int iix;
    private String imagePath = null;
    private String kKw = null;
    private List<String> kiU;
    private int msgType;
    private int[] mxW = new int[]{R.h.bUJ, R.h.bUK, R.h.bUL, R.h.bUM, R.h.bUN};
    private int yLf = -1;
    private boolean yTm;
    private boolean yUl = false;
    private TextView yoB;
    private int zoZ;
    private boolean zpa = false;
    private boolean zpb = false;
    private boolean zpc = false;
    private boolean zpd = false;
    private boolean zpe = false;
    private boolean zpf = false;
    private boolean zpg = false;
    private int zph;
    private boolean zpi = false;
    private String zpj;
    private String zpk;
    private Boolean zpl = Boolean.valueOf(false);
    private boolean zpm = false;
    private boolean zpn = false;
    private List<String> zpo = null;
    private ReportArgs zpp;
    private String zpq;
    private String zpr = null;
    private String zps;
    private OnMenuItemClickListener zpt = new 16(this);
    private OnMenuItemClickListener zpu = new 17(this);

    static /* synthetic */ void b(SelectConversationUI selectConversationUI, Intent intent) {
        if (s.fa(selectConversationUI.iix, 256)) {
            selectConversationUI.g(-1, intent);
            selectConversationUI.finish();
            return;
        }
        e.a aVar = new e.a(selectConversationUI.mController.xIM);
        aVar.bS(selectConversationUI.zpo);
        if (selectConversationUI.yUl) {
            selectConversationUI.a(aVar, selectConversationUI.zpj);
            a(intent, selectConversationUI.zpj, selectConversationUI.zpo);
        } else if (selectConversationUI.zpb) {
            if (selectConversationUI.fqk != -1) {
                b ftVar = new ft();
                ftVar.fvl.fqk = selectConversationUI.fqk;
                ftVar.fvl.fvm = aVar;
                ftVar.fvl.fnT = selectConversationUI.mController.xIM;
                com.tencent.mm.sdk.b.a.xef.m(ftVar);
            } else if (selectConversationUI.msgType == 17 && selectConversationUI.zph != 0) {
                aVar.Sp(new StringBuffer(selectConversationUI.getResources().getString(R.l.dFG)).append(selectConversationUI.mController.xIM.getString(R.l.eED, new Object[]{Integer.valueOf(selectConversationUI.zph)})).toString());
            }
        } else if (selectConversationUI.zpc) {
            HashMap hashMap = (HashMap) selectConversationUI.getIntent().getSerializableExtra("webview_params");
            aVar.Sq((String) hashMap.get("img_url")).caT();
            String str = (String) hashMap.get("title");
            final String str2 = (String) hashMap.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            aVar.Sp(new StringBuffer(selectConversationUI.getResources().getString(R.l.dGU)).append(str).toString());
            aVar.a(new i.a.a(selectConversationUI) {
                final /* synthetic */ SelectConversationUI zpv;

                public final void aJL() {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    d.b(this.zpv.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        } else if (selectConversationUI.zpd) {
            selectConversationUI.a(aVar);
        } else {
            selectConversationUI.b(aVar);
            selectConversationUI.c(aVar);
        }
        aVar.f(Boolean.valueOf(true)).BW(R.l.dGA).a(new 15(selectConversationUI, intent)).pyk.show();
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.e.h(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        x.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!(t.ov(stringExtra) || t.ov(stringExtra2))) {
            new com.tencent.mm.plugin.base.stub.d(this, stringExtra, stringExtra2, new 1(this)).aqV();
        }
        com.tencent.mm.pluginsdk.e.i(this);
    }

    protected final void WT() {
        super.WT();
        this.zpa = getIntent().getBooleanExtra("select_is_ret", false);
        this.fromScene = getIntent().getIntExtra("scene_from", 0);
        x.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[]{Integer.valueOf(this.fromScene)});
        if (this.fromScene == 1) {
            this.zpb = true;
        } else if (this.fromScene == 2 || this.fromScene == 10) {
            this.zpc = true;
        } else if (this.fromScene == 3) {
            this.zpd = true;
        } else if (this.fromScene == 6) {
            this.zpe = true;
        } else if (this.fromScene == 7) {
            this.zpf = true;
        }
        this.zpg = getIntent().getBooleanExtra("send_to_biz", false);
        this.yLf = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.fqk = getIntent().getLongExtra("select_fav_local_id", -1);
        this.zph = getIntent().getIntExtra("select_fav_select_count", 0);
        this.zpm = getIntent().getBooleanExtra("mutil_select_is_ret", false);
        this.yUl = getIntent().getBooleanExtra("Select_Send_Card", false);
        this.zpi = getIntent().getBooleanExtra("Retr_Big_File", false);
        if (this.yUl) {
            this.zpj = getIntent().getStringExtra("Select_Talker_Name");
        }
        this.iix = getIntent().getIntExtra("Select_Conv_Type", zoY);
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.fqm = getIntent().getLongExtra("Retr_Msg_Id", -1);
        ar.Hg();
        this.fEJ = c.Fa().dH(this.fqm);
        this.imagePath = getIntent().getStringExtra("image_path");
        this.zpr = getIntent().getStringExtra("ad_video_title");
        this.kKw = getIntent().getStringExtra("desc_title");
        this.zpq = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.fDP = getIntent().getStringExtra("Retr_Msg_content");
        this.zps = getIntent().getStringExtra("Retr_fav_xml_str");
        if (this.fDP == null && this.fEJ != null) {
            this.fDP = this.fEJ.field_content;
        }
        this.zpp = (ReportArgs) getIntent().getParcelableExtra("Select_Report_Args");
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cwj());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!t.ov(stringExtra)) {
            hashSet.addAll(t.g(stringExtra.split(",")));
        }
        if (s.fa(this.iix, 2)) {
            Collection cwk = s.cwk();
            s.g(cwk);
            hashSet.addAll(cwk);
        }
        this.kiU = new ArrayList();
        this.kiU.addAll(hashSet);
        if (s.fa(this.iix, 1)) {
            this.yTm = true;
        }
        if (this.zpm) {
            this.zpo = new LinkedList();
            if (this.zpm) {
                a(1, getString(R.l.dFI), this.zpt, p.b.xJz);
                WZ();
            }
        }
    }

    protected final o WX() {
        return new com.tencent.mm.ui.contact.t(this, this.kiU, this.yTm, this.zpn, this.zpg, this.iix);
    }

    protected final m WY() {
        return new q(this, this.kiU, this.zpn, this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.yoB == null) {
            if (this.yUl) {
                this.zoZ = R.l.eJs;
            } else if (this.fromScene == 10) {
                this.zoZ = R.l.ezJ;
            } else {
                this.zoZ = R.l.eJl;
            }
            OnClickListener anonymousClass12 = new OnClickListener(this) {
                final /* synthetic */ SelectConversationUI zpv;

                {
                    this.zpv = r1;
                }

                public final void onClick(View view) {
                    if (this.zpv.zpn) {
                        this.zpv.cyn();
                    } else if (this.zpv.yUl) {
                        this.zpv.cyo();
                    } else {
                        this.zpv.cyp();
                    }
                }
            };
            CharSequence string = getString(this.zoZ);
            View inflate = v.fv(this).inflate(R.i.dlx, null);
            inflate.setOnClickListener(anonymousClass12);
            TextView textView = (TextView) inflate.findViewById(R.h.bYS);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yoB = textView;
        }
        this.yoB.setVisibility(i);
    }

    protected final void aXW() {
        if (this.fromScene == 5) {
            h.a((Context) this, getString(R.l.etO), null, getString(R.l.send), getString(R.l.cancel), true, new 19(this), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SelectConversationUI zpv;

                {
                    this.zpv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    super.aXW();
                    this.zpv.aWs();
                }
            });
        } else {
            super.aXW();
            aWs();
        }
        if (this.zpp != null) {
            ReportUtil.a(this, this.zpp);
        }
    }

    public void onBackPressed() {
        super.aXW();
    }

    public final void ja(int i) {
        int headerViewsCount;
        com.tencent.mm.ui.contact.a.a Gm;
        if (this.zpn) {
            headerViewsCount = i - this.prJ.getHeaderViewsCount();
            if (headerViewsCount < 0) {
                x.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
                cyn();
                return;
            }
            n cvZ = cvZ();
            Gm = cvZ.Gm(headerViewsCount);
            if (Gm != null && Gm.jLe != null) {
                String str = Gm.jLe.field_username;
                x.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[]{str});
                if (this.zpo.contains(str) || !nw(true)) {
                    cwf();
                    this.ooa.Sg(str);
                    if (this.zpo.contains(str)) {
                        this.zpo.remove(str);
                    } else {
                        this.zpo.add(str);
                    }
                    WZ();
                    cvZ.notifyDataSetChanged();
                    return;
                }
                cwf();
            }
        } else if (i < this.prJ.getHeaderViewsCount()) {
            x.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            if (this.yUl) {
                cyo();
            } else {
                cyp();
            }
        } else {
            Gm = (com.tencent.mm.ui.contact.a.a) this.prJ.getAdapter().getItem(i);
            if (Gm == null) {
                return;
            }
            Intent intent;
            if ((Gm instanceof com.tencent.mm.ui.contact.a.b) && ((com.tencent.mm.ui.contact.a.b) Gm).bgo == getResources().getString(R.l.dDe)) {
                x.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                intent = new Intent();
                intent.putExtra("list_attr", 16384);
                d.b(this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.zpc = true;
            } else if (Gm instanceof f) {
                f fVar = (f) Gm;
                Intent intent2 = new Intent();
                intent2.putExtra("scene", this.scene);
                Serializable arrayList = new ArrayList();
                for (Object add : fVar.mMb.mLC) {
                    arrayList.add(add);
                }
                intent2.putExtra("query_phrase_list", arrayList);
                d.a(this, ".ui.transmit.MMCreateChatroomUI", intent2, 1);
            } else {
                af afVar = Gm.jLe;
                if (afVar != null) {
                    String str2 = afVar.field_username;
                    x.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[]{str2});
                    Intent intent3 = new Intent();
                    intent3.putExtra("Select_Conv_User", str2);
                    intent = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                    if (intent != null) {
                        a(intent3, intent);
                    } else if (this.zpa || this.yUl || this.zpb || this.zpc || this.zpd) {
                        n(intent3, str2);
                    } else {
                        g(-1, intent3);
                        finish();
                    }
                    aWs();
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        String stringExtra;
        Intent intent2;
        if (i == 1) {
            if (i2 == -1 && intent != null) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                x.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    a(intent, intent2);
                } else if (this.zpa || this.yUl || this.zpb || this.zpc || this.zpd) {
                    n(intent, stringExtra);
                } else {
                    g(-1, intent);
                    finish();
                }
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    finish();
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        intent2 = new Intent(this, TaskRedirectUI.class);
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    }
                    return;
                case 0:
                    if (intent != null) {
                        this.zpp = (ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3) {
            switch (i2) {
                case -1:
                    if (intent != null) {
                        r0 = intent.getStringExtra("received_card_name");
                        if (!bh.ov(r0)) {
                            e.a aVar = new e.a(this.mController.xIM);
                            aVar.bS(r0);
                            a(aVar, this.zpj);
                            aVar.f(Boolean.valueOf(true)).BW(R.l.dGA).a(new o$a(this) {
                                final /* synthetic */ SelectConversationUI zpv;

                                public final void a(boolean z, String str, int i) {
                                    this.zpv.aWs();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (r0.endsWith("@chatroom")) {
                                            SelectConversationUI.b(intent, this.zpv.zpj, r0);
                                        } else {
                                            SelectConversationUI.a(intent, this.zpv.zpj, r0);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        this.zpv.g(-1, intent);
                                        this.zpv.finish();
                                    }
                                }
                            }).pyk.show();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 4) {
            if (i2 == -1 && intent != null) {
                n(intent, intent.getStringExtra("Select_Contact"));
            }
        } else if (i != 5) {
            x.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1 && intent != null) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            for (String Sh : this.zpo) {
                this.ooa.Sh(Sh);
            }
            if (t.ov(stringExtra)) {
                this.zpo.clear();
            } else {
                this.zpo = t.g(stringExtra.split(","));
            }
            for (String Sh2 : this.zpo) {
                this.ooa.ba(Sh2, false);
            }
            WZ();
            cvZ().notifyDataSetChanged();
        }
    }

    private static void a(Intent intent, String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(str2);
        a(intent, str, linkedList);
    }

    private static void a(Intent intent, String str, List<String> list) {
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", t.d(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
    }

    private static void b(Intent intent, String str, String str2) {
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
    }

    private void a(e.a aVar, String str) {
        ar.Hg();
        c.EY().WM(str);
        String gu = r.gu(str);
        if (!bh.ov(this.zpk)) {
            gu = this.zpk;
        }
        ar.Hg();
        aVar.Sp(new StringBuffer(com.tencent.mm.z.s.gM(c.EY().WM(str).field_verifyFlag) ? getResources().getString(R.l.dFo) : getResources().getString(R.l.dFp)).append(gu).toString());
    }

    private void a(Intent intent, Intent intent2) {
        x.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=" + intent2);
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        com.tencent.mm.ui.base.b.B(this.mController.xIM, intent2);
    }

    private void n(Intent intent, String str) {
        if (s.fa(this.iix, 256)) {
            g(-1, intent);
            finish();
        } else if (t.ov(str)) {
            x.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
        } else {
            if (com.tencent.mm.z.s.eV(str)) {
                int gl = com.tencent.mm.z.m.gl(str);
                if (!this.zpi || gl <= t.getInt(g.zY().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)) {
                    getString(R.l.eJh, new Object[]{Integer.valueOf(gl)});
                } else {
                    x.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[]{Integer.valueOf(t.getInt(g.zY().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)), Integer.valueOf(gl)});
                    h.b(this, getString(R.l.eJj, new Object[]{Integer.valueOf(r1)}), "", true);
                    return;
                }
            }
            e.a aVar = new e.a(this.mController.xIM);
            aVar.bS(str);
            if (this.yUl) {
                a(aVar, this.zpj);
                if (str.endsWith("@chatroom")) {
                    b(intent, this.zpj, str);
                } else {
                    a(intent, this.zpj, str);
                }
                aVar.f(Boolean.valueOf(true));
            } else if (this.zpb) {
                if (this.fqk != -1) {
                    c(aVar);
                    b ftVar = new ft();
                    ftVar.fvl.fqk = this.fqk;
                    ftVar.fvl.fvm = aVar;
                    ftVar.fvl.fvn = this.zps;
                    ftVar.fvl.fnT = this.mController.xIM;
                    com.tencent.mm.sdk.b.a.xef.m(ftVar);
                } else if (this.msgType == 17 && this.zph != 0) {
                    aVar.Sp(new StringBuffer(getResources().getString(R.l.dFG)).append(this.mController.xIM.getString(R.l.eED, new Object[]{Integer.valueOf(this.zph)})).toString());
                }
                aVar.f(Boolean.valueOf(true));
            } else if (this.zpc) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("webview_params");
                String str2 = (String) hashMap.get("img_url");
                String str3 = (String) hashMap.get("title");
                r0 = (String) hashMap.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                aVar.Sp(new StringBuffer(getResources().getString(R.l.dGU)).append(str3).toString());
                aVar.a(new 22(this, r0));
                aVar.Sq(str2).caT();
                aVar.f(Boolean.valueOf(true));
            } else if (this.zpd) {
                a(aVar);
            } else if (this.zpf) {
                r0 = getResources().getString(R.l.dFr);
                if (this.kKw != null) {
                    r0 = new StringBuffer(r0).append(this.kKw).toString();
                }
                aVar.Sp(r0);
                aVar.f(Boolean.valueOf(false));
            } else {
                b(aVar);
                c(aVar);
                aVar.f(Boolean.valueOf(true));
            }
            aVar.BW(R.l.dGA).a(new 23(this, intent)).pyk.show();
        }
    }

    private void a(e.a aVar) {
        HashMap hashMap = (HashMap) getIntent().getSerializableExtra("appbrand_params");
        int i = bx.getInt(hashMap.get(DownloadSettingTable$Columns.TYPE), 1);
        String d = bx.d(hashMap.get("title"), "");
        String d2 = bx.d(hashMap.get("img_url"), null);
        if (i == 2 || i == 3) {
            String d3 = bx.d(hashMap.get("app_id"), null);
            int i2 = bx.getInt(hashMap.get("pkg_type"), 0);
            int i3 = bx.getInt(hashMap.get("pkg_version"), 0);
            String d4 = bx.d(hashMap.get("cache_key"), null);
            String d5 = bx.d(hashMap.get("path"), null);
            String d6 = bx.d(hashMap.get("delay_load_img_path"), null);
            boolean aR = bx.aR(hashMap.get("is_dynamic"));
            View be = ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).be(this);
            String bi = k.bi(this);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", d3);
            bundle.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            bundle.putInt("msg_pkg_type", i2);
            bundle.putInt("pkg_version", i3);
            bundle.putString("image_url", d2);
            bundle.putBoolean("is_dynamic_page", aR);
            bundle.putString("title", d);
            bundle.putString("cache_key", d4);
            bundle.putString("msg_path", d5);
            bundle.putString("delay_load_img_path", d6);
            ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).a(bi, be, bundle);
            aVar.da(be);
            aVar.f(Boolean.valueOf(true));
            aVar.caU();
            aVar.jWl = new 24(this, bi, be);
            return;
        }
        aVar.Sp(new StringBuffer(getResources().getString(R.l.dDR)).append(d).toString());
        aVar.Sq(d2).caT();
        aVar.f(Boolean.valueOf(true));
    }

    private void b(e.a aVar) {
        int orientationInDegree;
        String str;
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap cym = cym();
                if (cym == null && this.imagePath != null) {
                    Bitmap c = com.tencent.mm.sdk.platformtools.d.c(this.imagePath, com.tencent.mm.bv.a.getDensity(ac.getContext()));
                    orientationInDegree = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    if (orientationInDegree < 0) {
                        orientationInDegree = 0;
                    }
                    cym = com.tencent.mm.sdk.platformtools.d.b(c, (float) orientationInDegree);
                }
                aVar.a(cym, 3);
                return;
            case 1:
                aVar.a(cyl(), 2);
                return;
            case 2:
            case 10:
                com.tencent.mm.y.g.a I;
                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(this.fDP));
                if (this.fEJ.ciV() && fT == null) {
                    I = com.tencent.mm.y.g.a.I(bh.VH(this.fDP), bh.VH(this.fDP));
                } else {
                    I = fT;
                }
                if (I != null) {
                    String string;
                    str = I.title;
                    if (com.tencent.mm.ui.chatting.k.e(this.fEJ, this.yLf)) {
                        string = getResources().getString(R.l.dDR);
                    } else if (I.type == 5) {
                        string = getResources().getString(R.l.dGU);
                        r2 = I.url;
                    } else if (I.type == 6) {
                        string = getResources().getString(R.l.dFj);
                    } else if (I.type == 24) {
                        r2 = getResources().getString(R.l.dFT);
                        b mtVar = new mt();
                        mtVar.fEE.type = 0;
                        mtVar.fEE.fEG = I.hbB;
                        com.tencent.mm.sdk.b.a.xef.m(mtVar);
                        str = bh.az(mtVar.fEF.fEO.desc, I.description).replaceAll("\n", " ");
                        string = r2;
                    } else if (I.type == 19) {
                        string = getResources().getString(R.l.dGs);
                    } else if (I.type == 3) {
                        string = getResources().getString(R.l.dFJ);
                    } else if (I.type == 4) {
                        string = getResources().getString(R.l.dGX);
                    } else if (I.type == 8) {
                        string = getResources().getString(R.l.dEI);
                    } else if (I.type != 33 && I.type != 36) {
                        string = getResources().getString(R.l.dDN);
                    } else if (I.hdz == 2 || I.hdz == 3 || I.type == 36) {
                        View be = ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).be(this);
                        aVar.da(be);
                        aVar.f(Boolean.valueOf(true));
                        aVar.caU();
                        str = com.tencent.mm.aq.o.Pw().ln(this.fEJ.field_imgPath);
                        String bi = k.bi(this);
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", I.hdy);
                        bundle.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(I.hdE), Integer.valueOf(I.hdB)}));
                        bundle.putInt("msg_pkg_type", I.hdE);
                        bundle.putInt("pkg_version", I.hdB);
                        if (!bh.ov(str)) {
                            bundle.putString("image_url", "file://" + str);
                        }
                        com.tencent.mm.y.a aVar2 = (com.tencent.mm.y.a) I.r(com.tencent.mm.y.a.class);
                        if (aVar2 != null) {
                            bundle.putBoolean("is_dynamic_page", aVar2.haz);
                            bundle.putString("cache_key", aVar2.haA);
                        }
                        bundle.putString("title", I.title);
                        bundle.putString("msg_path", I.hdw);
                        ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).a(bi, be, bundle);
                        aVar.jWl = new 25(this, bi, be);
                        return;
                    } else {
                        string = getResources().getString(R.l.dDR);
                    }
                    if (str == null) {
                        str = "";
                    }
                    aVar.Sp(new StringBuffer(string).append(str).toString());
                    if (I.thumburl != null) {
                        aVar.Sq(I.thumburl).caT();
                        return;
                    }
                    return;
                } else if (this.zpr != null) {
                    str = getResources().getString(R.l.dGX);
                    aVar.Sp(new StringBuffer(str).append(this.zpr).toString());
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.kKw != null) {
                    aVar.Sp(new StringBuffer(getResources().getString(R.l.dFj)).append(this.kKw).toString());
                    return;
                }
                return;
            case 4:
                aVar.Sp(this.fDP);
                aVar.caS();
                return;
            case 5:
                if (!bh.ov(this.zpq)) {
                    aVar.Sr(this.zpq);
                    return;
                } else if (bh.ov(this.fEJ.field_imgPath)) {
                    aVar.Sr(this.imagePath);
                    return;
                } else {
                    aVar.Sr(this.fEJ.field_imgPath);
                    return;
                }
            case 8:
                ar.Hg();
                au.a EK = c.Fa().EK(this.fDP);
                this.zpj = EK.rYX;
                this.zpk = EK.fpL;
                this.zpl = Boolean.valueOf(com.tencent.mm.z.s.gM(EK.tmE));
                a(aVar, this.zpj);
                return;
            case 9:
                ar.Hg();
                au.b EL = c.Fa().EL(this.fDP);
                str = "";
                if (EL != null) {
                    str = EL.label;
                }
                aVar.Sp(this.mController.xIM.getString(R.l.dFz) + str);
                return;
            case 11:
                aVar.a(cyl(), 2);
                return;
            case 12:
                mt fL = j.fL(this.mController.xIM);
                if (fL.fEE.fEK != null) {
                    orientationInDegree = fL.fEE.fEK.size();
                } else {
                    orientationInDegree = 0;
                }
                aVar.Sp(new StringBuffer(getResources().getString(R.l.dFG)).append(this.mController.xIM.getString(R.l.eED, new Object[]{Integer.valueOf(orientationInDegree)})).toString());
                return;
            case 13:
                aVar.Sp(new StringBuffer(getResources().getString(R.l.dFH)).append(t.az(j.fL(this.mController.xIM).fEF.fEN.title, "")).toString());
                return;
            default:
                return;
        }
    }

    private void c(e.a aVar) {
        switch (this.msgType) {
            case 0:
            case 1:
            case 11:
            case 16:
                aVar.a(new 3(this));
                return;
            case 2:
            case 10:
                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(this.fDP));
                if (fT == null) {
                    return;
                }
                if (fT.type == 5 && !com.tencent.mm.ui.chatting.k.e(this.fEJ, this.yLf)) {
                    aVar.a(new 5(this, fT.url));
                    return;
                } else if (fT.type == 6) {
                    aVar.a(new 6(this));
                    return;
                } else if (fT.type == 24) {
                    aVar.a(new 7(this, fT));
                    return;
                } else if (fT.type == 19) {
                    aVar.a(new 8(this, fT));
                    return;
                } else if (fT.type == 3) {
                    aVar.a(new 9(this, fT));
                    return;
                } else if (fT.type == 4) {
                    aVar.a(new i.a.a(this) {
                        final /* synthetic */ SelectConversationUI zpv;

                        {
                            this.zpv = r1;
                        }

                        public final void aJL() {
                        }
                    });
                    return;
                } else {
                    return;
                }
            case 3:
                aVar.a(new 13(this));
                return;
            case 4:
                aVar.a(new 2(this));
                return;
            case 9:
                ar.Hg();
                au.b EL = c.Fa().EL(this.fDP);
                aVar.a(new 4(this, EL, EL.label));
                return;
            case 12:
                j.fL(this.mController.xIM);
                return;
            case 13:
                aVar.a(new 11(this));
                return;
            default:
                return;
        }
    }

    private Bitmap cyl() {
        com.tencent.mm.modelvideo.o.TU();
        String nu = com.tencent.mm.modelvideo.s.nu(this.fEJ.field_imgPath);
        if (nu == null) {
            nu = this.imagePath;
        }
        return com.tencent.mm.sdk.platformtools.d.UN(nu);
    }

    private Bitmap cym() {
        if (this.fEJ == null) {
            return null;
        }
        String str = this.fEJ.field_imgPath;
        com.tencent.mm.aq.g Pw = com.tencent.mm.aq.o.Pw();
        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(Pw.ln(str), com.tencent.mm.bv.a.getDensity(ac.getContext()), 0);
        if (a == null) {
            return a;
        }
        try {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree < 0) {
                orientationInDegree = 0;
            }
            return com.tencent.mm.sdk.platformtools.d.b(a, (float) orientationInDegree);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            return a;
        }
    }

    private void cyn() {
        x.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(R.l.dDo));
        intent.putExtra("list_attr", s.yTJ);
        intent.putExtra("already_select_contact", t.d(this.zpo, ","));
        intent.putExtra("max_limit_num", 9);
        this.mController.xIM.startActivityForResult(intent, 5);
    }

    private void cyo() {
        x.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.yTG);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.zpj);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(R.l.dDo));
        this.mController.xIM.startActivityForResult(intent, 3);
    }

    private void cyp() {
        x.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(R.l.dDo));
        if (((this.fromScene == 4 || this.fromScene == 9) && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || this.fromScene == 10) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", s.p(new int[]{32, 16, 1, 2, 4, 16384}));
        } else {
            intent.putExtra("list_attr", s.yTI);
        }
        this.mController.xIM.startActivityForResult(intent, 1);
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        String stringExtra = getIntent().getStringExtra("Select_Conv_ui_title");
        return (stringExtra == null || stringExtra.length() <= 0) ? getString(R.l.eJn) : stringExtra;
    }

    protected final boolean WU() {
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.zpo.contains(aVar.jLe.field_username);
    }

    public final void oE(String str) {
        this.zpo.remove(str);
        cvZ().notifyDataSetChanged();
        WZ();
    }

    private void WZ() {
        if (!this.zpm) {
            return;
        }
        if (this.zpo != null && this.zpo.size() > 0) {
            updateOptionMenuText(1, getString(R.l.dGA) + "(" + this.zpo.size() + ")");
            a(this.zpu);
            enableOptionMenu(1, true);
        } else if (this.zpn) {
            updateOptionMenuText(1, getString(R.l.dGI));
            a(this.zpt);
            enableOptionMenu(1, true);
        } else {
            updateOptionMenuText(1, getString(R.l.dFI));
            a(this.zpt);
            enableOptionMenu(1, true);
        }
    }

    private boolean nw(boolean z) {
        if (!z ? this.zpo.size() > 9 : this.zpo.size() >= 9) {
            return false;
        }
        h.a(this.mController.xIM, getString(R.l.eJk, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), getString(R.l.dGt), new 18(this));
        return true;
    }

    protected final boolean cwd() {
        return true;
    }

    public final int[] aXV() {
        int[] intArrayExtra = getIntent().getIntArrayExtra("search_range");
        if (this.fromScene != 4 && this.fromScene != 10) {
            return intArrayExtra == null ? super.aXV() : intArrayExtra;
        } else {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        }
    }

    private void g(int i, Intent intent) {
        if (this.msgType == 5) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("emoji_thumb_path", this.zpq);
            intent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
        }
        super.setResult(-1, intent);
    }
}
