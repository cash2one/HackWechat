package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e {
    public p fhr;
    public aa yvM;
    public c ywd;
    protected boolean yyZ = false;
    protected Map<String, String> yza = new HashMap();
    public c yzb = new c<ao>(this) {
        final /* synthetic */ e yzf;

        {
            this.yzf = r2;
            this.xen = ao.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ao aoVar = (ao) bVar;
            if ((aoVar instanceof ao) && this.yzf.fhr.csi() != null && !bh.ov(aoVar.foG.username) && aoVar.foG.username.equals(this.yzf.fhr.csi().field_username)) {
                this.yzf.cto();
            }
            return false;
        }
    };
    public final a yzc = new 4(this);
    public c yzd = new c<rm>(this) {
        final /* synthetic */ e yzf;

        {
            this.yzf = r2;
            this.xen = rm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rm rmVar = (rm) bVar;
            if ((!(rmVar instanceof rm) || this.yzf.fhr.csi().field_username.equals(rmVar.fJo.userName)) && this.yzf.fhr.csi().field_username.toLowerCase().endsWith("@chatroom")) {
                h.b(this.yzf.fhr.csq().getContext(), this.yzf.fhr.csq().getMMString(R.l.eRm), null, true);
            }
            return false;
        }
    };
    public com.tencent.mm.pluginsdk.d.b yze = new com.tencent.mm.pluginsdk.d.b(this) {
        final /* synthetic */ e yzf;

        {
            this.yzf = r2;
        }

        public final void a(int i, int i2, String str, b bVar) {
            this.yzf.fhr.dismissDialog();
            if (bVar instanceof jw) {
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0) {
                        h.bu(this.yzf.fhr.csq().getContext(), this.yzf.fhr.csq().getMMString(R.l.eFk));
                    }
                } else if (i != 0 || i2 != 0) {
                    if (i2 == -2024) {
                        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                        if (eA != null) {
                            eA.a(this.yzf.fhr.csq().getContext(), null, null);
                            return;
                        } else {
                            h.a(this.yzf.fhr.csq().getContext(), this.yzf.fhr.csq().getMMString(R.l.eFh), null, this.yzf.fhr.csq().getMMString(R.l.eFi), false, new 1(this));
                            return;
                        }
                    }
                    h.a(this.yzf.fhr.csq().getContext(), this.yzf.fhr.csq().getMMString(R.l.eFq), null, this.yzf.fhr.csq().getMMString(R.l.dFU), false, new 2(this));
                }
            } else if (!(bVar instanceof kb)) {
            } else {
                if (i != 0 || i2 != 0) {
                    h.a(this.yzf.fhr.csq().getContext(), this.yzf.fhr.csq().getMMString(R.l.eFq), null, this.yzf.fhr.csq().getMMString(R.l.dFU), false, new 3(this));
                } else if (i == 0 && i2 == 0) {
                    h.bu(this.yzf.fhr.csq().getContext(), this.yzf.fhr.csq().getMMString(R.l.eFf));
                }
            }
        }
    };

    class AnonymousClass3 implements OnCancelListener {
        final /* synthetic */ k lax;
        final /* synthetic */ e yzf;

        AnonymousClass3(e eVar, k kVar) {
            this.yzf = eVar;
            this.lax = kVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            ar.CG().c(this.lax);
        }
    }

    public e(p pVar) {
        this.fhr = pVar;
    }

    public final boolean ctm() {
        return this.yyZ;
    }

    public final void ctn() {
        if (s.eV(this.fhr.crz())) {
            this.yyZ = m.gb(this.fhr.crz());
            if (this.yyZ) {
                m.b(this.fhr.crz(), this.yza);
            } else {
                this.yza.clear();
            }
            x.d("MicroMsg.ChattingUI.ChatroomImp", "chatroom display  " + (this.yyZ ? "show " : "not show"));
        } else if (this.ywd.yyK) {
            this.yyZ = true;
        } else {
            this.yyZ = false;
            this.yza.clear();
        }
    }

    public final String gu(String str) {
        String gv = r.gv(str);
        if (!this.ywd.vnK && !bh.ov(gv)) {
            return gv;
        }
        if (this.yza.containsKey(str)) {
            gv = (String) this.yza.get(str);
            if (!bh.ov(gv)) {
                return gv;
            }
        }
        if (this.ywd.vnK) {
            return this.ywd.ync.gu(str);
        }
        return r.gu(str);
    }

    public final void cto() {
        if (this.fhr.csi() == null) {
            x.e("MicroMsg.ChattingUI.ChatroomImp", "getChatroomMemberDetail() talker == null");
        } else if (s.eV(this.fhr.csi().field_username)) {
            x.d("MicroMsg.ChattingUI.ChatroomImp", "cpan[changeTalker]");
            new af().postDelayed(new Runnable(this) {
                final /* synthetic */ e yzf;

                {
                    this.yzf = r1;
                }

                public final void run() {
                    ar.Hg();
                    q hD = com.tencent.mm.z.c.Fh().hD(this.yzf.fhr.csi().field_username);
                    if (hD != null && hD.chR()) {
                        x.d("MicroMsg.ChattingUI.ChatroomImp", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                        b jxVar = new jx();
                        jxVar.fAY.chatroomName = this.yzf.fhr.csi().field_username;
                        jxVar.fAY.fAZ = hD.chQ();
                        com.tencent.mm.sdk.b.a.xef.m(jxVar);
                    }
                }
            }, 1000);
        }
    }

    public final void az(LinkedList<String> linkedList) {
        ar.Hg();
        q hD = com.tencent.mm.z.c.Fh().hD(this.fhr.csi().field_username);
        if (hD == null) {
            h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eFn), null, this.fhr.csq().getMMString(R.l.eFi), new 8(this));
            return;
        }
        String str = this.fhr.csi().field_username;
        List linkedList2 = new LinkedList();
        List Ms = hD.Ms();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (Ms != null && Ms.contains(str2)) {
                linkedList2.add(str2);
            }
        }
        if (linkedList2.size() == 0) {
            if (linkedList.size() == 1) {
                h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eFh), null, this.fhr.csq().getMMString(R.l.eFi), new 9(this));
            } else {
                h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eFd), null, this.fhr.csq().getMMString(R.l.eFi), new 10(this));
            }
        } else if (linkedList.size() == 1) {
            u csq = this.fhr.csq();
            int i = R.l.eFc;
            Object[] objArr = new Object[1];
            str2 = (String) linkedList.get(0);
            if (this.fhr.csd()) {
                ar.Hg();
                com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str2);
                if (!(WO == null || ((int) WO.gJd) == 0)) {
                    if (bh.ov(WO.field_conRemark)) {
                        ar.Hg();
                        hD = com.tencent.mm.z.c.Fh().hD(this.fhr.csi().field_username);
                        str2 = hD == null ? null : hD.gu(WO.field_username);
                    } else {
                        str2 = WO.field_conRemark;
                    }
                    if (bh.ov(str2)) {
                        str2 = WO.field_conRemark;
                    }
                    if (bh.ov(str2)) {
                        str2 = WO.AP();
                    }
                }
            } else {
                str2 = null;
            }
            objArr[0] = str2;
            h.a(this.fhr.csq().getContext(), csq.getMMString(i, objArr), null, this.fhr.csq().getMMString(R.l.eFj), this.fhr.csq().getMMString(R.l.dEn), true, new 11(this, linkedList2, 1), new 2(this));
        } else {
            Intent intent = new Intent();
            intent.putExtra("members", bh.d(linkedList2, ","));
            intent.putExtra("RoomInfo_Id", this.fhr.csi().field_username);
            intent.putExtra("scene", 1);
            d.b(this.fhr.csq().getContext(), "chatroom", ".ui.DelChatroomMemberUI", intent);
        }
    }
}
