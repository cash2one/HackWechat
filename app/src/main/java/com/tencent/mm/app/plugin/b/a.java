package com.tencent.mm.app.plugin.b;

import android.database.Cursor;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {

    public static class g extends c<fg> {
        public g() {
            this.xen = fg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            p pVar = null;
            fg fgVar = (fg) bVar;
            if (m.UD() == null) {
                x.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + bh.cgy());
            }
            u UD = m.UD();
            String str = fgVar.fuv.fileName;
            if (str != null) {
                String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
                Cursor a = UD.hhp.a(str2, new String[]{str}, 2);
                x.d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + a.getCount());
                if (a.moveToFirst()) {
                    pVar = new p();
                    pVar.b(a);
                }
                a.close();
            }
            if (pVar != null) {
                fgVar.fuw.fqm = (long) pVar.hVI;
            }
            return true;
        }
    }

    public static class i extends c<fb> {
        public i() {
            this.xen = fb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
            if (ac.getContext() == null) {
                x.w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
                return false;
            }
            d.bu(ac.getContext());
            return true;
        }
    }
}
