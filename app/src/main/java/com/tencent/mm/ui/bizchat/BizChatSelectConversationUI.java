package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.v;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements n {
    private String kGH = null;
    private int scene = 0;
    private r tipDialog = null;
    j ynE;
    private TextView yoB;

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        bizChatSelectConversationUI.ynE = y.Mj().ca(y.Mj().cb(bizChatSelectConversationUI.kGH));
        if (bizChatSelectConversationUI.ynE == null || bh.ov(bizChatSelectConversationUI.ynE.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.ynE != null ? bizChatSelectConversationUI.ynE.field_addMemberUrl : null;
            x.i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(R.l.dMp), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.ynE.field_addMemberUrl);
        x.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", new Object[]{bizChatSelectConversationUI.ynE.field_addMemberUrl});
        intent.putExtra("useJs", true);
        d.b(bizChatSelectConversationUI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        cqO();
        String cb = y.Mj().cb(this.kGH);
        this.ynE = y.Mj().ca(cb);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.kGH;
        objArr[1] = cb;
        if (this.ynE == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (bh.ov(cb) || this.ynE == null || this.ynE.Mu() || bh.ov(this.ynE.field_addMemberUrl)) {
            y.Ml();
            h.a(this.kGH, this);
            getString(R.l.dGO);
            this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.dHc), true, new OnCancelListener(this) {
                final /* synthetic */ BizChatSelectConversationUI yoC;

                {
                    this.yoC = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.yoC.finish();
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void cqO() {
        if (bh.ov(this.kGH)) {
            this.kGH = getIntent().getStringExtra("enterprise_biz_name");
            if (bh.ov(this.kGH)) {
                x.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
    }

    protected final o WX() {
        cqO();
        return new d(this, this.kGH);
    }

    protected final m WY() {
        cqO();
        return new p(this, this.kGH);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.yoB == null) {
            OnClickListener 1 = new 1(this);
            CharSequence string = getString(R.l.eJl);
            View inflate = v.fv(this).inflate(R.i.dlx, null);
            inflate.setOnClickListener(1);
            TextView textView = (TextView) inflate.findViewById(R.h.bYS);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yoB = textView;
        }
        this.yoB.setVisibility(i);
    }

    protected final void aXW() {
        super.aXW();
    }

    public final void ja(int i) {
        if (i < this.prJ.getHeaderViewsCount()) {
            x.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
        } else if (this.prJ.getAdapter().getItem(i) instanceof a) {
            a aVar = (a) this.prJ.getAdapter().getItem(i);
            if (aVar != null) {
                String str = aVar.username;
                long j = aVar.kGB;
                if (str == null || j == -1) {
                    x.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[]{str, Long.valueOf(j)});
                    return;
                }
                a(str, j, aVar.iil);
            }
        } else {
            x.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
        }
    }

    private void a(final String str, final long j, CharSequence charSequence) {
        x.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[]{str});
        if (this.scene == 2) {
            long j2;
            if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
                j2 = j;
                e.a(this.mController, j2, getString(R.l.eEF), String.valueOf(charSequence), getString(R.l.dGA), new com.tencent.mm.pluginsdk.ui.applet.o.a(this) {
                    final /* synthetic */ BizChatSelectConversationUI yoC;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("enterprise_biz_name", str);
                            intent.putExtra("key_biz_chat_id", j);
                            intent.putExtra("key_is_biz_chat", true);
                            this.yoC.setResult(-1, intent);
                            this.yoC.finish();
                        }
                    }
                });
                return;
            }
            j2 = j;
            e.a(this.mController, j2, getString(R.l.eEF), String.valueOf(charSequence), getString(R.l.dGA), new 3(this, str, j));
        } else if (this.scene == 1) {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
            String str2 = (String) hashMap.get("title");
            e.a(this.mController, str2, (String) hashMap.get("img_url"), (String) hashMap.get("desc"), null, true, getResources().getString(R.l.dGA), new com.tencent.mm.pluginsdk.ui.applet.o.a(this) {
                final /* synthetic */ BizChatSelectConversationUI yoC;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        if (!bh.ov(str)) {
                            intent.putExtra("enterprise_share_append_text", str);
                        }
                        this.yoC.setResult(-1, intent);
                        this.yoC.finish();
                    }
                }
            });
        }
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return com.tencent.mm.z.r.gu(this.kGH);
    }

    protected final boolean WU() {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        String str;
                        x.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        wj wjVar = new wj();
                        c cVar = new c();
                        if (this.ynE != null) {
                            str = this.ynE.field_addMemberUrl;
                        } else {
                            str = null;
                        }
                        cVar.field_addMemberUrl = str;
                        cVar.field_brandUserName = this.kGH;
                        if (!com.tencent.mm.ag.a.e.a(cVar, string, null, wjVar)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            a(this.kGH, cVar.field_bizChatLocalId, cVar.field_chatName);
                            z = true;
                        } else {
                            y.Ml();
                            com.tencent.mm.ag.a.n a = h.a(this.kGH, wjVar, this);
                            getString(R.l.dGO);
                            this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.dCE), true, new 5(this, a));
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(this, getString(R.l.eES), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, k kVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (kVar.getType() == 1355) {
            c kl = y.Mh().kl(((com.tencent.mm.ag.a.n) kVar).Mz().vYt.wgJ.vNk);
            if (kl == null) {
                Toast.makeText(ac.getContext(), getString(R.l.eES), 0).show();
            } else {
                a(this.kGH, kl.field_bizChatLocalId, kl.field_chatName);
            }
        }
    }
}
