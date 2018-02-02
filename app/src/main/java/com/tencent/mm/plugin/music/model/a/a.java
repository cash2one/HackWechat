package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends c<s> {
    public a() {
        this.xen = s.class.getName().hashCode();
    }

    private static boolean a(s sVar) {
        boolean b;
        if (sVar.fnD.action != 6) {
            x.i("MicroMsg..Audio.AudioActionListener", "audio action listener callback, action:%d", new Object[]{Integer.valueOf(sVar.fnD.action)});
        }
        b bdE;
        String str;
        e FV;
        e FV2;
        e FV3;
        com.tencent.mm.ac.a aVar;
        b bdE2;
        switch (sVar.fnD.action) {
            case 0:
                b = h.bdE().b(sVar.fnD.fnH);
                break;
            case 1:
                b = h.bdE().a(sVar.fnD.fnF, sVar.fnD.fnH);
                break;
            case 2:
                bdE = h.bdE();
                str = sVar.fnD.fnF;
                FV = bdE.FV(str);
                if (FV == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
                    b = false;
                } else {
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[]{str});
                    FV.pause();
                    bdE.b(str, FV);
                    bdE.f(str, FV);
                    b = true;
                }
                sVar.fnE.fnI = b;
                break;
            case 3:
                b = h.bdE().FR(sVar.fnD.fnF);
                break;
            case 4:
                bdE = h.bdE();
                str = sVar.fnD.fnF;
                int i = sVar.fnD.fnG;
                FV2 = bdE.FV(str);
                if (FV2 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
                    b = bdE.bI(str, i);
                } else if (i < 0) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(FV2.getDuration())});
                    b = false;
                } else {
                    if (FV2.getDuration() <= 0) {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(FV2.getDuration())});
                    } else if (i <= 0 || i <= FV2.getDuration()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[]{str, Integer.valueOf(i)});
                        if (FV2.Qq() || FV2.Qr() || FV2.isPaused()) {
                            b = FV2.if(i);
                        }
                    } else {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(FV2.getDuration())});
                        b = false;
                    }
                    FV2.bdX();
                    b = bdE.bI(str, i);
                }
                sVar.fnE.fnI = b;
                break;
            case 5:
                b = h.bdE().FS(sVar.fnD.fnF);
                break;
            case 6:
                sVar.fnE.fnJ = h.bdE().FT(sVar.fnD.fnF);
                b = true;
                break;
            case 7:
                FV3 = h.bdE().FV(sVar.fnD.fnF);
                if (FV3 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
                    b = false;
                } else {
                    b = FV3.Qq();
                }
                sVar.fnE.fnI = b;
                break;
            case 8:
                FV3 = h.bdE().FV(sVar.fnD.fnF);
                if (FV3 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
                    b = false;
                } else {
                    b = FV3.Qr();
                }
                sVar.fnE.fnI = b;
                break;
            case 9:
                h.bdE().FX(sVar.fnD.appId);
                b = true;
                break;
            case 10:
                sVar.fnD.fnF = h.bdE().dv(sVar.fnD.appId, sVar.fnD.fnF);
                b = true;
                break;
            case 11:
                sVar.fnE.count = h.bdE().FU(sVar.fnD.appId);
                b = true;
                break;
            case 12:
                h.bdE().FW(sVar.fnD.appId);
                b = true;
                break;
            case 13:
                bdE = h.bdE();
                str = sVar.fnD.fnF;
                FV = bdE.FV(str);
                if (FV == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
                    com.tencent.mm.ac.c FT = bdE.FT(str);
                    b = FT != null ? FT.hkB : false;
                } else {
                    b = FV.hkB;
                }
                sVar.fnE.fnI = b;
                break;
            case 14:
                b bdE3 = h.bdE();
                String str2 = sVar.fnD.fnF;
                FV2 = bdE3.FV(str2);
                if (FV2 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
                    b = false;
                } else {
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[]{str2});
                    FV2.hkB = false;
                    FV2.oKG = true;
                    FV2.bdW();
                    FV2.gKo = System.currentTimeMillis();
                    aVar = (com.tencent.mm.ac.a) bdE3.oKm.get(str2);
                    if (aVar != null) {
                        aVar.hkt = 0;
                        aVar.hkv = true;
                    }
                    bdE3.b(str2, FV2);
                    bdE3.f(str2, FV2);
                    b = true;
                }
                sVar.fnE.fnI = b;
                break;
            case 15:
                bdE2 = h.bdE();
                String str3 = sVar.fnD.processName;
                if (bdE2.oKj.size() != 0) {
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[]{str3});
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(bdE2.oKj);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str4 = (String) it.next();
                        str = (String) bdE2.oKk.get(str4);
                        if (str3 != null && str3.equalsIgnoreCase(str)) {
                            x.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
                            bdE2.FX(str4);
                        }
                    }
                }
                b = true;
                break;
            case 16:
                sVar.fnD.fnH = h.bdE().iN(sVar.fnD.fnF);
                b = true;
                break;
            case 17:
                FV3 = h.bdE().FV(sVar.fnD.fnF);
                if (FV3 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
                    b = true;
                } else {
                    b = FV3.isStopped();
                }
                sVar.fnE.fnI = b;
                break;
            case 18:
                bdE2 = h.bdE();
                com.tencent.mm.ac.a aVar2 = sVar.fnD.fnH;
                if (aVar2 != null) {
                    aVar = (com.tencent.mm.ac.a) bdE2.oKm.get(aVar2.fnF);
                    if (aVar != null) {
                        aVar.fnF = aVar2.fnF;
                        aVar.hks = aVar2.hks;
                        aVar.filePath = aVar2.filePath;
                        aVar.hkt = aVar2.hkt;
                        aVar.hku = aVar2.hku;
                        aVar.hkv = aVar2.hkv;
                        aVar.hkw = aVar2.hkw;
                        aVar.fromScene = aVar2.fromScene;
                        aVar.processName = aVar2.processName;
                        aVar.hky = aVar2.hky;
                        aVar.appId = aVar2.appId;
                    } else {
                        bdE2.oKm.put(aVar2.fnF, aVar2);
                        aVar = aVar2;
                    }
                    e FV4 = bdE2.FV(aVar2.fnF);
                    if (FV4 != null) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
                        FV4.c(aVar);
                    } else {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
                    }
                    b = true;
                    break;
                }
                x.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
                b = false;
                break;
            default:
                b = true;
                break;
        }
        sVar.fnE.fnI = b;
        if (sVar.fnD.action != 6) {
            x.d("MicroMsg..Audio.AudioActionListener", "audio action listener callback, ret:%b", new Object[]{Boolean.valueOf(b)});
        }
        return b;
    }
}
