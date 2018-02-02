package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.m.6;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.b.v.4;
import com.tencent.mm.ui.chatting.b.v.5;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

class n$a implements TextWatcher {
    final /* synthetic */ n yAo;
    private boolean yAp;
    private List<String> yAq;

    private n$a(n nVar) {
        this.yAo = nVar;
        this.yAp = false;
        this.yAq = null;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private static void b(List<String> list, String[] strArr) {
        for (String str : strArr) {
            if (str.length() > 0 && str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$")) {
                list.add(str);
            }
        }
    }

    private boolean dl(String str, int i) {
        if (str == null || i < 0 || str.length() <= i) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        if (!str.substring(i - 1, i).matches("[_0-9a-zA-Z]$")) {
            return true;
        }
        if (this.yAq == null) {
            this.yAq = new LinkedList();
            b(this.yAq, this.yAo.fhr.csq().getMMResources().getStringArray(R.c.bqU));
            b(this.yAq, this.yAo.fhr.csq().getMMResources().getStringArray(R.c.bqV));
        }
        String substring = str.substring(0, i);
        for (String endsWith : this.yAq) {
            if (substring.endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String d;
        x.i("MicroMsg.ChattingUI.FootMgr", "[onTextChanged]");
        this.yAo.yvL.FE(1);
        String valueOf = String.valueOf(charSequence);
        String substring = valueOf.substring(i, i + i3);
        Intent intent;
        if (this.yAo.fhr.cse() && "@".equals(substring) && !valueOf.equals(this.yAo.one.vqg.vre) && !this.yAo.one.vqh) {
            this.yAo.one.Sx(valueOf);
            this.yAo.one.Ci(i + 1);
            if (dl(valueOf, i)) {
                d = bh.d(m.gj(this.yAo.fhr.crz()), ",");
                intent = new Intent();
                intent.setClass(this.yAo.fhr.csq().getContext(), AtSomeoneUI.class);
                intent.putExtra("Block_list", q.FS());
                intent.putExtra("Chatroom_member_list", d);
                intent.putExtra("Chat_User", this.yAo.fhr.csi().field_username);
                intent.putExtra("Add_address_titile", this.yAo.fhr.csq().getMMString(R.l.eEL));
                this.yAo.fhr.csq().startActivityForResult(intent, b.CTRL_INDEX);
            }
        } else if (this.yAo.fhr.csg() && "@".equals(substring) && !valueOf.equals(this.yAo.one.vqg.vre) && !this.yAo.one.vqh) {
            this.yAo.one.Sx(valueOf);
            this.yAo.one.Ci(i + 1);
            if (dl(valueOf, i)) {
                d = this.yAo.fhr.cso().field_userList;
                intent = new Intent();
                intent.setClass(this.yAo.fhr.csq().getContext(), BizChatAtSomeoneUI.class);
                intent.putExtra("Block_list", y.Mj().cb(this.yAo.fhr.crz()));
                intent.putExtra("Chatroom_member_list", d);
                intent.putExtra("Chat_User", this.yAo.fhr.csi().field_username);
                intent.putExtra("Add_address_titile", this.yAo.fhr.csq().getMMString(R.l.eEL));
                intent.putExtra("key_biz_chat_id", this.yAo.ywd.cti());
                this.yAo.fhr.csq().startActivityForResult(intent, b.CTRL_INDEX);
            }
        } else if (!valueOf.equals(this.yAo.one.vqg.vre)) {
            this.yAo.one.Sx(valueOf);
        }
        v vVar = this.yAo.yvT;
        if ((vVar.onO == null || !vVar.onO.isShowing()) && !bh.ov(substring) && p.UP(substring)) {
            Bitmap d2 = d.d(substring, 300, 300, false);
            if (d2 == null) {
                x.e("MicroMsg.ChattingUI.SendImgImp", "showAlert fail, bmp is null");
            } else {
                View imageView = new ImageView(vVar.fhr.csq().getContext());
                int dimensionPixelSize = vVar.fhr.csq().getMMResources().getDimensionPixelSize(R.f.bvv);
                imageView.setImageBitmap(d2);
                imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                d = Secure.getString(vVar.fhr.csq().getContentResolver(), "default_input_method");
                boolean z = p.bo(e.d(substring, 0, e.bN(substring))) && (d.contains("com.sohu.inputmethod.sogou") || d.contains("com.tencent.qqpinyin"));
                vVar.onO = h.a(vVar.fhr.csq().getContext(), vVar.fhr.csq().getMMString(R.l.dSW), imageView, vVar.fhr.csq().getMMString(R.l.dFU), vVar.fhr.csq().getMMString(R.l.dEn), new 4(vVar, z, substring), null);
                vVar.fhr.csB().postDelayed(new 5(vVar, valueOf.substring(0, i)), 10);
            }
        }
        if (!this.yAo.fhr.csf()) {
            ChatFooter chatFooter = this.yAo.one;
            if (chatFooter.vqd != null && chatFooter.okw != null) {
                chatFooter.vqd.vrJ = true;
                com.tencent.mm.pluginsdk.ui.chat.m mVar = chatFooter.vqd;
                if (!(bh.ov(valueOf) || valueOf.equals(mVar.vrI))) {
                    g.Dm().F(new 6(mVar, valueOf));
                }
                mVar.vrI = valueOf;
            }
        }
    }
}
