package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public class d implements ap {
    private static a kYY;
    private c<ju> kYS = new 1(this);
    private c<jx> kYT = new 2(this);
    private c<jw> kYU = new c<jw>(this) {
        final /* synthetic */ d kYZ;

        {
            this.kYZ = r1;
        }

        public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
            jw jwVar = (jw) bVar;
            jwVar.fAW.errCode = i;
            return jwVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jw jwVar = (jw) bVar;
            if (jwVar.fAV.fAJ) {
                c.k(jwVar);
            } else {
                l(jwVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            jw jwVar = (jw) bVar;
            return new g(jwVar.fAV.chatroomName, jwVar.fAV.fAX, jwVar.fAV.scene);
        }

        public final int axw() {
            return 179;
        }
    };
    private c<kb> kYV = new 4(this);
    private c<jv> kYW = new 5(this);
    private com.tencent.mm.sdk.b.c kYX = new 6(this);

    private static d axu() {
        ar.Ha();
        d dVar = (d) bp.hY("plugin.chatroom");
        if (dVar == null) {
            synchronized (d.class) {
                if (dVar == null) {
                    dVar = new d();
                    ar.Ha().a("plugin.chatroom", dVar);
                }
            }
        }
        return dVar;
    }

    private static a axv() {
        com.tencent.mm.kernel.g.Dh().Ct();
        axu();
        if (kYY == null) {
            axu();
            kYY = new a();
        }
        axu();
        return kYY;
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.sdk.b.a.xef.b(this.kYX);
        com.tencent.mm.sdk.b.a.xef.b(this.kYS);
        com.tencent.mm.sdk.b.a.xef.b(this.kYW);
        com.tencent.mm.sdk.b.a.xef.b(this.kYT);
        com.tencent.mm.sdk.b.a.xef.b(this.kYU);
        com.tencent.mm.sdk.b.a.xef.b(this.kYV);
        a axv = axv();
        ar.getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", axv.kZj, true);
        ar.getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", axv.kZj, true);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.kYX);
        com.tencent.mm.sdk.b.a.xef.c(this.kYS);
        com.tencent.mm.sdk.b.a.xef.c(this.kYW);
        com.tencent.mm.sdk.b.a.xef.c(this.kYT);
        com.tencent.mm.sdk.b.a.xef.c(this.kYU);
        com.tencent.mm.sdk.b.a.xef.c(this.kYV);
        a axv = axv();
        ar.getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", axv.kZj, true);
        ar.getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", axv.kZj, true);
    }
}
