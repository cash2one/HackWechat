package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.l;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.gallery.j.5;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b extends v {
    public static long kGB = -1;
    public static boolean vnK = false;
    public ImageGalleryUI yCS;
    protected a yCT;
    private String yCU;
    boolean yCV = true;
    public boolean yCW = false;
    public d yCX;
    public i yCY;
    public h yCZ;
    public c yDa;
    boolean yDb;
    protected boolean yDc = true;
    private ArrayList<au> yDd = new ArrayList();

    public static class a {
        protected boolean adD = false;
        int hKb;
        af handler = new af();
        private int sXn;
        private String talker;
        private List<au> yDi;
        int yDj;
        protected int yDk;
        protected int yDl;
        protected int yDm;
        protected long yDn;
        private b yDo;
        public HashMap<Long, e> yDp = new HashMap();
        public HashMap<Long, e> yDq = new HashMap();

        static /* synthetic */ void a(a aVar) {
            aVar.adD = true;
            aVar.hKb = aVar.yDk;
            aVar.sXn = aVar.yDl;
            aVar.yDj = aVar.yDm;
            x.i("MicroMsg.AutoList", "totalCount %s min %s start %s", new Object[]{Integer.valueOf(aVar.hKb), Integer.valueOf(aVar.sXn), Integer.valueOf(aVar.yDj)});
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.AutoList", "min spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            currentTimeMillis = System.currentTimeMillis();
            aVar.s(aVar.yDn, true);
            x.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            currentTimeMillis = System.currentTimeMillis();
            aVar.s(aVar.yDn, false);
            x.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            aVar.yDo.notifyDataSetChanged();
            if (!aVar.yDo.yCS.isFinishing()) {
                b bVar = aVar.yDo;
                View view = (View) aVar.yDo.yeR.get(99999);
                MMViewPager mMViewPager = aVar.yDo.yCS.mTN;
                bVar.d(99999, view);
            }
        }

        static /* synthetic */ void a(a aVar, long j) {
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.AutoList", "isBizChat = " + b.vnK);
            if (b.vnK) {
                ar.Hg();
                aVar.yDk = com.tencent.mm.z.c.Fb().aq(aVar.talker, b.kGB);
            } else {
                ar.Hg();
                aVar.yDk = com.tencent.mm.z.c.Fa().EP(aVar.talker);
            }
            x.i("MicroMsg.AutoList", "<init>, totalCount = " + aVar.yDk);
            x.i("MicroMsg.AutoList", "totalCount spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            long currentTimeMillis2 = System.currentTimeMillis();
            if (b.vnK) {
                ar.Hg();
                aVar.yDl = com.tencent.mm.z.c.Fb().s(aVar.talker, b.kGB, j);
            } else {
                ar.Hg();
                aVar.yDl = com.tencent.mm.z.c.Fa().O(aVar.talker, j);
            }
            x.i("MicroMsg.AutoList", "min spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
                ar.Hg();
                String P = com.tencent.mm.z.c.Fa().P(aVar.talker, j);
                x.w("MicroMsg.AutoList", "explain : %s", new Object[]{P});
            }
            aVar.yDm = aVar.yDl;
            aVar.yDn = j;
        }

        public a(long j, String str, final b bVar, Boolean bool) {
            this.talker = str;
            this.yDi = new LinkedList();
            this.yDo = bVar;
            ar.Hg();
            cf dH = com.tencent.mm.z.c.Fa().dH(j);
            if (dH.field_msgId == 0) {
                Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j + ", stack = " + bh.cgy(), false);
                return;
            }
            this.yDi.add(dH);
            ar.Dm().F(new 1(this, j, bool, bVar));
            bVar.yCS.yFj = new com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.a(this) {
                final /* synthetic */ a yDu;

                public final void j(Boolean bool) {
                    x.i("MicroMsg.AutoList", "isPlaying : " + bool);
                    if (!bool.booleanValue()) {
                        a.a(this.yDu);
                        if (bVar.yDa != null) {
                            bVar.yDa.hX();
                        }
                    }
                }
            };
        }

        private void dk(List<au> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (b.aW((au) list.get(i))) {
                    arrayList.add(Long.valueOf(((au) list.get(i)).field_msgSvrId));
                    if (((au) list.get(i)).field_isSend == 1) {
                        arrayList2.add(Long.valueOf(((au) list.get(i)).field_msgId));
                    }
                }
            }
            this.yDp.putAll(o.Pw().a((Long[]) arrayList.toArray(new Long[0])));
            this.yDq.putAll(o.Pw().b((Long[]) arrayList2.toArray(new Long[0])));
        }

        public final int FV(int i) {
            return (i - 100000) + this.yDj;
        }

        public final au FW(int i) {
            int FV = FV(i);
            int size = (this.sXn + this.yDi.size()) - 1;
            if (FV < this.sXn || FV > size) {
                x.e("MicroMsg.AutoList", "get, invalid pos " + FV + ", min = " + this.sXn + ", max = " + size);
                return null;
            }
            x.d("MicroMsg.AutoList", "get, pos = " + FV);
            au auVar;
            if (FV == this.sXn) {
                auVar = (au) this.yDi.get(0);
                if (!this.adD) {
                    return auVar;
                }
                s(auVar.field_msgId, false);
                return auVar;
            } else if (FV != size || size >= this.hKb - 1) {
                return (au) this.yDi.get(FV - this.sXn);
            } else {
                auVar = (au) this.yDi.get(this.yDi.size() - 1);
                if (!this.adD) {
                    return auVar;
                }
                s(auVar.field_msgId, true);
                return auVar;
            }
        }

        public final void mS(boolean z) {
            this.adD = false;
        }

        private void s(long j, boolean z) {
            List b;
            x.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j + ", forward = " + z);
            if (b.vnK) {
                ar.Hg();
                b = com.tencent.mm.z.c.Fb().b(this.talker, b.kGB, j, z);
            } else {
                ar.Hg();
                b = com.tencent.mm.z.c.Fa().c(this.talker, j, z);
            }
            if (b == null || b.size() == 0) {
                x.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = " + z);
                return;
            }
            x.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + b.size() + ", forward = " + z);
            long currentTimeMillis = System.currentTimeMillis();
            dk(b);
            x.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            if (z) {
                this.yDi.addAll(b);
                return;
            }
            this.yDi.addAll(0, b);
            this.sXn -= b.size();
            if (this.sXn < 0) {
                x.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.sXn);
                return;
            }
            x.i("MicroMsg.AutoList", "min from " + (b.size() + this.sXn) + " to " + this.sXn);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AutoList, Size = " + this.yDi.size());
            stringBuilder.append("; Content = {");
            for (au auVar : this.yDi) {
                stringBuilder.append(auVar.field_msgId);
                stringBuilder.append(",");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public interface c {
        void hX();
    }

    public final /* synthetic */ Object e(int i, View view) {
        return d(i, view);
    }

    public b(ImageGalleryUI imageGalleryUI, long j, String str, boolean z, long j2, boolean z2, String str2, Boolean bool) {
        String str3 = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j + ", talker = " + str + ", stack = " + bh.cgy();
        boolean z3 = imageGalleryUI != null && j > 0 && str != null && str.length() > 0;
        Assert.assertTrue(str3, z3);
        this.yCS = imageGalleryUI;
        vnK = z;
        kGB = j2;
        this.yCT = new a(j, str, this, bool);
        this.yCW = z2;
        this.yCU = str2;
        this.yCX = new d(this);
        this.yCY = new i(this);
        this.yCZ = new h(this);
    }

    public final void ae(int i) {
        if (this.yCX != null && aW(FL(i))) {
            this.yCX.yEl.ae(i);
        }
    }

    public final int getCount() {
        a aVar = this.yCT;
        return ((aVar.hKb - aVar.yDj) + 100000) + 1;
    }

    public final int aCQ() {
        return this.yCT.hKb;
    }

    public final au FL(int i) {
        return this.yCT.FW(i);
    }

    public final void cuw() {
        this.yCT.mS(false);
    }

    public final e f(au auVar, boolean z) {
        return this.yCX.f(auVar, z);
    }

    public static boolean aW(au auVar) {
        if (auVar == null) {
            return false;
        }
        if (auVar.getType() == 3 || auVar.getType() == 39 || auVar.getType() == 13) {
            return true;
        }
        return false;
    }

    public static boolean aX(au auVar) {
        if (auVar == null || bd(auVar)) {
            return false;
        }
        if (auVar.getType() == 43 || auVar.getType() == 44 || auVar.getType() == 62) {
            return true;
        }
        return false;
    }

    public static boolean aY(au auVar) {
        if (auVar != null && auVar.getType() == 62) {
            return true;
        }
        return false;
    }

    public static boolean aZ(au auVar) {
        if (auVar != null && auVar.getType() == 49) {
            return true;
        }
        return false;
    }

    public static boolean ba(au auVar) {
        if (auVar != null && auVar.getType() == 268435505) {
            return true;
        }
        return false;
    }

    public final boolean bb(au auVar) {
        if (auVar == null) {
            return false;
        }
        e f = f(auVar, false);
        if (f == null) {
            r bq = i.bq(auVar);
            if (bq == null || bq == null) {
                return false;
            }
            int i = bq.status;
            boolean z = (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122) && t.f(bq) < 100;
            x.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(r2)});
            return z;
        } else if (auVar == null || f == null) {
            return false;
        } else {
            if (o.Px().a(f.hzP, auVar.field_msgId, 0) || a(auVar, f)) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(au auVar, e eVar) {
        if (auVar == null || eVar == null) {
            return false;
        }
        return o.Px().a(eVar.hzP, auVar.field_msgId, 1);
    }

    public final void FM(int i) {
        cf FL = FL(i);
        switch (2.yDh[bc(FL).ordinal()]) {
            case 1:
            case 2:
                be(FL);
                return;
            case 3:
                String bg = bg(FL);
                Intent intent = new Intent(this.yCS, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", bg);
                intent.putExtra("Retr_Msg_Id", FL.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", FL.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                this.yCS.startActivity(intent);
                return;
            default:
                bf(FL);
                return;
        }
    }

    public final void FN(int i) {
        cf FL = FL(i);
        switch (2.yDh[bc(FL).ordinal()]) {
            case 1:
            case 2:
            case 4:
                Intent intent = new Intent(this.yCS, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", FL.field_msgId);
                this.yCS.startActivity(intent);
                return;
            default:
                return;
        }
    }

    public static b bc(au auVar) {
        b bVar = b.yDw;
        if (auVar == null) {
            bVar = b.yDw;
        }
        if (ba(auVar)) {
            return b.yDA;
        }
        if (aW(auVar)) {
            return b.yDx;
        }
        if (bd(auVar)) {
            return b.yDz;
        }
        if (aX(auVar)) {
            return b.yDy;
        }
        if (aY(auVar)) {
            return b.yDy;
        }
        return b.yDw;
    }

    private static boolean bd(au auVar) {
        if (auVar != null) {
            r nF = t.nF(auVar.field_imgPath);
            if (!(nF == null || nF.hVQ == null || (bh.ov(nF.hVQ.hdo) && nF.hVQ.weC <= 0 && bh.ov(nF.hVQ.hdr) && bh.ov(nF.hVQ.hds) && bh.ov(nF.hVQ.hdq) && bh.ov(nF.hVQ.hdt) && bh.ov(nF.hVQ.hdu) && bh.ov(nF.hVQ.hdv)))) {
                return true;
            }
        }
        return false;
    }

    public final void be(au auVar) {
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            r nF = t.nF(auVar.field_imgPath);
            if (nF == null) {
                x.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                return;
            }
            Intent intent = new Intent(this.yCS, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", nF.hVH);
            intent.putExtra("Retr_File_Name", auVar.field_imgPath);
            intent.putExtra("Retr_video_isexport", nF.hVL);
            intent.putExtra("Retr_Msg_Type", aY(auVar) ? 11 : 1);
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            this.yCS.startActivity(intent);
            return;
        }
        u.fI(this.yCS);
    }

    public final void bf(au auVar) {
        e bl = d.bl(auVar);
        if (auVar == null || auVar.field_msgId == 0 || bl == null || bl.hzP == 0) {
            Object obj;
            String str = "MicroMsg.ImageGalleryAdapter";
            StringBuilder stringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
            if (auVar == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(auVar.field_msgId);
            }
            stringBuilder = stringBuilder.append(obj).append(", imgLocalId = ");
            if (bl == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(bl.hzP);
            }
            x.e(str, stringBuilder.append(obj).toString());
            return;
        }
        String d = d.d(auVar, bl);
        if (d == null || d.length() == 0) {
            x.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + auVar.field_msgId + ", imgLocalId = " + bl.hzP);
        } else if (bh.ov(this.yCU)) {
            x.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            Intent intent = new Intent(this.yCS, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", d);
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", b(auVar, bl));
            this.yCS.startActivity(intent);
        } else {
            int i;
            x.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[]{this.yCU});
            if (auVar.field_isSend == 1) {
                if (bl.Pe()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (bl.Pe()) {
                if (com.tencent.mm.a.e.bO(o.Pw().m(f.a(bl).hzQ, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            String FS = q.FS();
            String m = o.Pw().m(f.c(bl), "", "");
            if (!bh.ov(m)) {
                x.i("MicroMsg.ImageGalleryAdapter", "connector click[img]: to[%s] fileName[%s]", new Object[]{bl, m});
                ar.CG().a(new l(FS, this.yCU, m, i), 0);
                bo.HS().c(bo.hhE, null);
            }
            if (this.yCV) {
                Intent intent2 = new Intent(this.yCS, ChattingUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", this.yCU);
                this.yCS.startActivity(intent2);
            } else {
                h.bu(this.yCS, this.yCS.getString(R.l.dGy));
            }
            g.pQN.h(10424, new Object[]{Integer.valueOf(3), Integer.valueOf(4), this.yCU});
        }
    }

    public static boolean c(Context context, List<au> list) {
        if (context == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean z = list.size() <= 1;
        boolean z2 = false;
        for (au auVar : list) {
            boolean a;
            if (aX(auVar)) {
                a = a(context, auVar, z);
            } else {
                a = b(context, auVar, z);
            }
            if (z2 || !r0) {
                a = z2;
            } else {
                a = true;
            }
            z2 = a;
        }
        if (!z2 && !z) {
            Toast.makeText(context, context.getString(R.l.eHd), 1).show();
            return true;
        } else if (!z2 || z) {
            return true;
        } else {
            Toast.makeText(context, context.getString(R.l.edU, new Object[]{com.tencent.mm.compatible.util.e.gHu}), 1).show();
            return true;
        }
    }

    public static boolean a(Context context, au auVar, boolean z) {
        if (auVar == null) {
            return false;
        }
        boolean z2;
        r nr = com.tencent.mm.modelvideo.o.TU().nr(auVar.field_imgPath);
        if (nr != null) {
            int gl;
            if (s.eV(nr.Ud())) {
                gl = m.gl(nr.Ud());
            } else {
                gl = 0;
            }
            boolean Uj = nr.Uj();
            g.pQN.a(106, 216, 1, false);
            g.pQN.h(12084, new Object[]{Integer.valueOf(nr.hlp), Integer.valueOf(nr.hVH * 1000), Integer.valueOf(0), Integer.valueOf(2), nr.Ud(), Integer.valueOf(gl), r.nq(nr.Ug()), Long.valueOf(nr.hVE)});
            z2 = Uj;
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.modelvideo.o.TU();
            String nG = t.nG(com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath));
            if (!bh.ov(nG)) {
                if (z) {
                    Toast.makeText(context, context.getString(R.l.eTe, new Object[]{nG}), 1).show();
                }
                k.b(nG, context);
                return true;
            } else if (!z) {
                return false;
            } else {
                Toast.makeText(context, context.getString(R.l.eTd), 1).show();
                return false;
            }
        }
        x.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
        if (!z) {
            return false;
        }
        Toast.makeText(context, context.getString(R.l.eTd), 1).show();
        return false;
    }

    public static boolean b(Context context, au auVar, boolean z) {
        String bg;
        if (ba(auVar)) {
            bg = bg(auVar);
        } else if (auVar == null || auVar.field_msgId == 0) {
            x.e("MicroMsg.ImageGalleryAdapter", "msg is null");
            if (z) {
                Toast.makeText(context, context.getString(R.l.eHc), 1).show();
            }
            return false;
        } else {
            e bl = d.bl(auVar);
            if (bl == null || bl.hzP == 0) {
                x.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (auVar == null ? "null" : Long.valueOf(auVar.field_msgId)) + ", imgLocalId = " + (bl == null ? "null" : Long.valueOf(bl.hzP)));
                if (z) {
                    Toast.makeText(context, context.getString(R.l.eHc), 1).show();
                }
                return false;
            }
            bg = d.d(auVar, bl);
        }
        if (bg == null || bg.length() == 0) {
            x.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + auVar.field_msgId);
            if (z) {
                Toast.makeText(context, context.getString(R.l.eHc), 1).show();
            }
            return false;
        } else if (d.a(bg, context, z, R.l.dXO)) {
            return true;
        } else {
            if (z) {
                Toast.makeText(context, context.getString(R.l.eHc), 1).show();
            }
            return false;
        }
    }

    public final void FO(int i) {
        au FL = FL(i);
        com.tencent.mm.g.a.cf cfVar = new com.tencent.mm.g.a.cf();
        com.tencent.mm.pluginsdk.model.f.a(cfVar, FL);
        cfVar.fqp.activity = this.yCS;
        cfVar.fqp.fqw = 44;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        if (cfVar.fqq.ret == 0) {
            if (FL.cji()) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.ypb, com.tencent.mm.ui.chatting.a.d.yph, FL, 0);
            }
            com.tencent.mm.modelstat.b.hPA.u(FL);
        }
    }

    public final View d(int i, View view) {
        j jVar;
        final au FL = FL(i);
        if (view == null) {
            view = View.inflate(this.yCS, R.i.dlF, null);
            jVar = new j(this, view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        b bc = bc(FL);
        jVar.mPosition = i;
        jVar.yGa = bc;
        j.N(jVar.mUL, 0);
        switch (5.yDh[bc.ordinal()]) {
            case 1:
                j.N(jVar.yGi, 8);
                j.N(jVar.yGc, 8);
                break;
            case 2:
                jVar.cvl();
                j.N(jVar.yGi, 0);
                j.N(jVar.yGc, 8);
                if (jVar.yGc != null) {
                    j.N(jVar.yGe, 8);
                    break;
                }
                break;
            case 3:
                jVar.cvk();
                j.N(jVar.yGi, 8);
                j.N(jVar.yGc, 0);
                break;
            case 4:
                j.N(jVar.mUL, 8);
                j.N(jVar.yGi, 8);
                j.N(jVar.yGc, 8);
                break;
        }
        j.N(jVar.yGx, 8);
        j.N(jVar.yGo, 8);
        j.N(jVar.yGu, 8);
        j.N(jVar.yGt, 8);
        x.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[]{Integer.valueOf(i), bc});
        switch (2.yDh[bc.ordinal()]) {
            case 1:
                this.yCY.a(jVar, FL, i);
                break;
            case 2:
                this.yCZ.a(jVar, FL, i);
                break;
            case 3:
                Bitmap oq;
                j.N(jVar.yGx, 0);
                j.N(jVar.yGo, 8);
                j.N(jVar.yGt, 8);
                j.N(jVar.yGu, 8);
                j.N(jVar.yGm, 8);
                final String bg = bg(FL);
                try {
                    oq = j.oq(bg);
                } catch (OutOfMemoryError e) {
                    x.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[]{bg});
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    oq = j.op(bg);
                }
                if (oq == null) {
                    oq = j.op(o.Pw().B(FL.field_imgPath, true));
                    j.N(jVar.yGt, 0);
                    new af().post(new Runnable(this) {
                        final /* synthetic */ b yDf;

                        public final void run() {
                            com.tencent.mm.pluginsdk.model.app.l.a(FL, new 1(this));
                        }
                    });
                }
                if (oq != null) {
                    jVar.yGx.rCd = false;
                    com.tencent.mm.sdk.platformtools.l.k(jVar.yGx, oq.getWidth(), oq.getHeight());
                    jVar.yGx.eS(oq.getWidth(), oq.getHeight());
                    jVar.yGx.setImageBitmap(oq);
                    jVar.yGx.invalidate();
                    break;
                }
                x.w("MicroMsg.ImageGalleryAdapter", "get image fail");
                jVar.yGx.setVisibility(8);
                jVar.cvj().yGu.setVisibility(0);
                jVar.cvj().yGw.setImageResource(R.k.dyO);
                jVar.cvj().yGv.setText(this.yCS.getString(R.l.epp));
                break;
            case 4:
                this.yCX.a(jVar, FL, i);
                break;
        }
        this.yDc = false;
        return view;
    }

    public static String bg(au auVar) {
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(auVar.field_content);
        if (fT == null || fT.fny == null || fT.fny.length() <= 0) {
            return null;
        }
        com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(fT.fny);
        if (Rz != null) {
            return Rz.field_fileFullPath;
        }
        return null;
    }

    public final void detach() {
        this.yCX.detach();
        this.yCY.detach();
        this.yCZ.detach();
        super.detach();
    }

    public static int b(au auVar, e eVar) {
        e a;
        if (auVar.field_isSend == 1) {
            if (eVar.Pe()) {
                a = f.a(eVar);
                if (a != null && a.hzP > 0 && a.Pd() && com.tencent.mm.a.e.bO(o.Pw().m(a.hzQ, "", ""))) {
                    return 1;
                }
            }
            return 0;
        } else if (!eVar.Pd()) {
            return 0;
        } else {
            if (eVar.Pe()) {
                a = f.a(eVar);
                if (a != null && a.hzP > 0 && a.Pd() && com.tencent.mm.a.e.bO(o.Pw().m(a.hzQ, "", ""))) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public final boolean cux() {
        return this.yCT.adD;
    }

    public final int cpM() {
        return 100000 - this.yCT.yDj;
    }

    public final int cpN() {
        return ((100000 - this.yCT.yDj) + this.yCT.hKb) - 1;
    }

    public final void ah(int i, boolean z) {
        this.yCX.ah(i, z);
    }

    public final MultiTouchImageView qx(int i) {
        View EQ = super.EQ(i);
        if (EQ == null) {
            x.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        }
        EQ = EQ.findViewById(R.h.image);
        if (EQ == null || EQ.getVisibility() == 8) {
            return null;
        }
        return (MultiTouchImageView) EQ;
    }

    public final View FP(int i) {
        View EQ = super.EQ(i);
        if (EQ == null) {
            x.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        }
        View findViewById = EQ.findViewById(R.h.cUJ);
        if (findViewById == null) {
            findViewById = EQ.findViewById(R.h.cUI);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            return null;
        }
        return findViewById;
    }

    public final void FQ(int i) {
        this.yCY.g(FL(i), i);
    }

    public final void FR(int i) {
        this.yCY.h(FL(i), i);
    }

    public final au cuy() {
        return FL(this.yCS.cuT());
    }

    public final j cuz() {
        j FJ = this.yCX.FJ(this.yCS.cuT());
        if (FJ == null) {
            FJ = this.yCY.FJ(this.yCS.cuT());
        }
        if (FJ == null) {
            return this.yCZ.FJ(this.yCS.cuT());
        }
        return FJ;
    }

    public final void FS(int i) {
        this.yCY.FK(i);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void cuA() {
        this.yCY.onResume();
    }

    public final void FT(int i) {
        cf FL = FL(i);
        if (FL != null && aW(FL)) {
            com.tencent.mm.aq.d.a aVar = this.yCX;
            e bl = d.bl(FL);
            if (bl != null && FL != null) {
                if (k.cvm().go(FL.field_msgId)) {
                    aVar = k.cvm();
                    aVar.yGF.remove(Long.valueOf(FL.field_msgId));
                    o.Px().a(bl.hzP, FL.field_msgId, aVar);
                    o.Px().l(bl.hzP, FL.field_msgId);
                    return;
                }
                o.Px().a(bl.hzP, FL.field_msgId, aVar);
                o.Px().l(bl.hzP, FL.field_msgId);
            }
        }
    }

    public final void FU(int i) {
        this.yCZ.Ga(i);
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        super.a(viewGroup, i, obj);
    }
}
