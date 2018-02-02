package com.tencent.mm.plugin.music.model;

import com.tencent.mm.av.a;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.plugin.music.model.b.d;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class h$3 extends c<jr> {
    final /* synthetic */ h oKd;

    h$3(h hVar) {
        this.oKd = hVar;
        this.xen = jr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jr jrVar = (jr) bVar;
        asv com_tencent_mm_protocal_c_asv;
        switch (jrVar.fAt.action) {
            case -3:
                jrVar.fAu.fnI = h.bdz().bdn().Qq();
                break;
            case -2:
                jrVar.fAu.fAv = h.bdz().bdp();
                break;
            case -1:
                h.bdz().Qo();
                break;
            case 0:
                h.bdz().e(jrVar.fAt.fAv);
                break;
            case 1:
                h.bdz().bdn().beb();
                break;
            case 2:
                h.bdz().bdn().resume();
                break;
            case 3:
                e bdz = h.bdz();
                com_tencent_mm_protocal_c_asv = jrVar.fAt.fAv;
                if (com_tencent_mm_protocal_c_asv == null) {
                    x.i("MicroMsg.Music.MusicPlayerManager", "shake music item is null");
                    break;
                }
                bdz.oJB.clear();
                bdz.oJB.add(g.i(com_tencent_mm_protocal_c_asv));
                bdz.oJA = 0;
                h.bdA().x(com_tencent_mm_protocal_c_asv);
                break;
            case 4:
                e bdz2 = h.bdz();
                List list = jrVar.fAt.fvF;
                int i = jrVar.fAt.fAw;
                if (list != null && list.size() != 0 && i < list.size()) {
                    bdz2.oJB.clear();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        asv com_tencent_mm_protocal_c_asv2 = (asv) list.get(i2);
                        bdz2.oJB.add(g.i(com_tencent_mm_protocal_c_asv2));
                        h.bdA().x(com_tencent_mm_protocal_c_asv2);
                    }
                    bdz2.oJA = i;
                    x.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList:%d", new Object[]{Integer.valueOf(bdz2.oJA)});
                    a bdo = bdz2.bdo();
                    com_tencent_mm_protocal_c_asv = bdz2.bdp();
                    if (bdo != null && g.e(bdo)) {
                        x.i("MicroMsg.Music.MusicPlayerManager", "musicType %d", new Object[]{Integer.valueOf(bdo.field_musicType)});
                        if (bdo.field_isBlock != 1) {
                            bdz2.mode = 2;
                            d.f(bdo);
                            if (!d.g(bdo)) {
                                bdz2.b(bdo);
                                break;
                            }
                            x.i("MicroMsg.Music.MusicPlayerManager", "get shake music new url to play");
                            bdz2.FK(bdo.hHQ);
                            break;
                        }
                        x.i("MicroMsg.Music.MusicPlayerManager", "not play music list, music is block %s", new Object[]{bdo.field_musicId});
                        bdz2.f(com_tencent_mm_protocal_c_asv);
                        f.a(bdo, true);
                        break;
                    }
                    x.e("MicroMsg.Music.MusicPlayerManager", "music is null, do not start music");
                    bdz2.f(com_tencent_mm_protocal_c_asv);
                    break;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "music wrapper list error");
                break;
                break;
            case 5:
                h.bdz().f(jrVar.fAt.fvF, jrVar.fAt.fAx);
                break;
            case 6:
                e bdz3 = h.bdz();
                asv com_tencent_mm_protocal_c_asv3 = jrVar.fAt.fAv;
                if (com_tencent_mm_protocal_c_asv3 != null) {
                    boolean z;
                    String i3 = g.i(com_tencent_mm_protocal_c_asv3);
                    if (bdz3.oJB != null) {
                        int i4 = 0;
                        while (i4 < bdz3.oJB.size()) {
                            if (i3.equals(bdz3.oJB.get(i4))) {
                                bdz3.oJA = i4;
                                z = true;
                                if (bdz3.oJB.size() > 1 && com_tencent_mm_protocal_c_asv3.wAA) {
                                    bdz3.mode = 2;
                                }
                            } else {
                                i4++;
                            }
                        }
                        z = false;
                        bdz3.mode = 2;
                        break;
                    }
                    z = false;
                    if (!z) {
                        bdz3.e(com_tencent_mm_protocal_c_asv3);
                        break;
                    }
                    bdz3.e(null);
                    break;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                break;
            case 7:
                jrVar.fAu.fnI = h.bdz().bdn().if(jrVar.fAt.position);
                break;
            case 8:
                jrVar.fAu.fAy = h.bdz().bdn().bdQ();
                break;
            case 9:
                jrVar.fAu.fnI = h.bdz().bdn().Qr();
                break;
            case 10:
                jrVar.fAu.fnI = h.bdz().bdn().bdO();
                break;
            case 11:
                h.bdz().bdv();
                break;
        }
        return false;
    }
}
