package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.j;
import com.tencent.mm.bf.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

public final class a extends LinearLayout implements e {
    static a vsW;
    private Context context;
    private TextView inu;
    r tipDialog;
    private Button vsX;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(a aVar, String str) {
        if (vsW == null) {
            x.e("MicroMsg.FMessageItemView", "FMessage Args is null");
            return;
        }
        int i;
        x.d("MicroMsg.FMessageItemView", "try to reply verify content");
        List linkedList = new LinkedList();
        linkedList.add(vsW.talker);
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(vsW.scene));
        List linkedList3 = new LinkedList();
        linkedList3.add(vsW.vtc);
        int i2 = vsW.type;
        String str2 = vsW.talker;
        x.d("MicroMsg.FMessageItemView", "getOpCode, type = " + i2 + ", talker = " + str2);
        switch (i2) {
            case 0:
                boolean z;
                if (str2 != null && str2.length() != 0) {
                    f mX = l.Tw().mX(str2);
                    if (mX != null) {
                        if (mX.field_type == 1 || mX.field_type == 2) {
                            z = true;
                            if (!z) {
                                i = 5;
                                break;
                            }
                        }
                    }
                    x.e("MicroMsg.FMessageLogic", "isVerifyReceiver, lastRecvFmsg does not exist, talker = " + str2);
                } else {
                    x.e("MicroMsg.FMessageLogic", "isVerifyReceiver, invalid argument");
                }
                z = false;
                if (z) {
                    i = 5;
                }
                break;
            case 1:
                h nc = l.Ty().nc(str2);
                if (nc != null) {
                    i = SE(nc.field_content);
                    break;
                }
                x.e("MicroMsg.FMessageItemView", "getOpCode, last lbsMsg is null");
            case 2:
                j ne = l.Tz().ne(str2);
                if (ne != null) {
                    i = SE(ne.field_content);
                    break;
                }
                x.e("MicroMsg.FMessageItemView", "getOpCode, last shakeMsg is null");
            default:
                i = 6;
                break;
        }
        x.d("MicroMsg.FMessageItemView", "reply, final opcode = " + i);
        ar.CG().a(30, (e) aVar);
        k oVar = new o(i, linkedList, linkedList2, linkedList3, str, vsW.mOi, null, null, "");
        ar.CG().a(oVar, 0);
        Context context = aVar.context;
        aVar.context.getString(R.l.dGO);
        aVar.tipDialog = com.tencent.mm.ui.base.h.a(context, aVar.context.getString(R.l.dGB), true, new 2(aVar, oVar));
    }

    public a(Context context) {
        super(context);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.diw, this);
        this.inu = (TextView) inflate.findViewById(R.h.ciH);
        this.vsX = (Button) inflate.findViewById(R.h.ciI);
        this.vsX.setOnClickListener(new 1(this));
    }

    private static int SE(String str) {
        if (str == null) {
            x.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            return 6;
        }
        switch (d.Xu(str).fuL) {
            case 2:
            case 5:
                return 6;
            case 6:
                return 5;
            default:
                return 6;
        }
    }

    public final void SF(String str) {
        this.inu.setText(i.b(this.context, bh.ou(str), this.inu.getTextSize()));
    }

    public final void Cv(int i) {
        if (this.vsX != null) {
            this.vsX.setVisibility(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 30) {
            x.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                int i3 = ((o) kVar).fuL;
                String str2 = ((o) kVar).vdz;
                x.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
                x.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + vsW.type);
                switch (vsW.type) {
                    case 1:
                        h hVar = new h();
                        hVar.field_createtime = com.tencent.mm.bf.i.nd(vsW.talker);
                        hVar.field_isSend = 1;
                        hVar.field_content = str2;
                        hVar.field_talker = "fmessage";
                        hVar.field_sayhiuser = vsW.talker;
                        hVar.field_svrid = System.currentTimeMillis();
                        hVar.field_status = 4;
                        l.Ty().a(hVar);
                        break;
                    case 2:
                        j jVar = new j();
                        jVar.field_createtime = com.tencent.mm.bf.k.nd(vsW.talker);
                        jVar.field_isSend = 1;
                        jVar.field_content = str2;
                        jVar.field_talker = "fmessage";
                        jVar.field_sayhiuser = vsW.talker;
                        jVar.field_svrid = System.currentTimeMillis();
                        jVar.field_status = 4;
                        x.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = " + l.Tz().a(jVar));
                        break;
                    default:
                        f fVar = new f();
                        fVar.field_createTime = com.tencent.mm.bf.e.n(vsW.talker, 0);
                        fVar.field_isSend = 1;
                        fVar.field_msgContent = str2;
                        fVar.field_talker = vsW.talker;
                        fVar.field_type = i3 == 5 ? 2 : 3;
                        x.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = " + l.Tw().a(fVar));
                        break;
                }
            }
            if (i == 4 && i2 == -34) {
                str = this.context.getString(R.l.eik);
            } else if (i == 4 && i2 == -94) {
                str = this.context.getString(R.l.eil);
            } else if (!(i == 4 && i2 == -24 && !bh.ov(str))) {
                str = this.context.getString(R.l.eKc);
            }
            Toast.makeText(this.context, str, 1).show();
            ar.CG().b(30, (e) this);
        }
    }
}
