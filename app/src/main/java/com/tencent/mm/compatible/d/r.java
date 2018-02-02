package com.tencent.mm.compatible.d;

import com.tencent.mm.compatible.h.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class r {
    r() {
    }

    public static boolean a(String str, o oVar, c cVar, b bVar, k kVar, v vVar, z zVar, s sVar, u uVar, x xVar, t tVar, a aVar) {
        try {
            x.d("MicroMsg.DeviceInfoParser", "xml: " + str);
            Map y = bi.y(str, "deviceinfoconfig");
            if (y == null) {
                x.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                return false;
            }
            if (y.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                oVar.gFH = bh.getInt((String) y.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                oVar.gFG = true;
            }
            if (y.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                oVar.gFI = bh.getInt((String) y.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                oVar.gFG = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.num") != null) {
                cVar.gDQ = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.num"), 0);
                cVar.gDR = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.surface") != null) {
                cVar.gDS = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.surface"), 0);
                cVar.gDT = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.format") != null) {
                cVar.gDU = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.format"), 0);
                cVar.ana = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                cVar.gDX.gEx = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                cVar.gDX.fps = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                cVar.gDX.gEy = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                cVar.gDX.fFy = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                cVar.gDX.gEz = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                cVar.gDX.width = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                cVar.gDX.height = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                cVar.gDY = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                cVar.gDV.gEx = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                cVar.gDV.fps = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                cVar.gDV.gEy = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                cVar.gDV.fFy = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                cVar.gDV.gEz = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                cVar.gDV.width = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                cVar.gDV.height = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                cVar.gDW = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                cVar.gEa = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                cVar.gDZ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                cVar.gEb = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                cVar.gDZ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                cVar.gEc = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                cVar.gDZ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                cVar.gEd = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                cVar.gDZ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.gEe = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.gEf = true;
                cVar.gDZ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.gEh = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.gEg = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                cVar.gEi = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                cVar.gEj = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                cVar.gEv = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                cVar.gEw = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.gEe = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.gEf = true;
                cVar.gDZ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.gEh = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.gEg = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                cVar.gEk = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                cVar.gEl = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                cVar.gEm = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                cVar.gEn = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                cVar.gEo = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                cVar.gEp = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                cVar.gEr = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                cVar.gEs = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                cVar.gEt = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                cVar.gEu = bh.getInt((String) y.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                bVar.gCH = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.smode") != null) {
                bVar.gCI = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.smode"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.omode") != null) {
                bVar.gCJ = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.omode"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                bVar.gCK = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.operating") != null) {
                bVar.gCL = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.operating"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                bVar.gCM = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                bVar.gCN = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                bVar.gCG = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                bVar.gCO = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.gCP = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                bVar.gCQ = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                bVar.gCR = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                bVar.gCS = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                bVar.gDf = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                bVar.gDe = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                bVar.gDg = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                bVar.gDh = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                bVar.gDi = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                bVar.gDj = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                bVar.gDk = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                bVar.gDm = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                bVar.gDn = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                bVar.gDo = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                bVar.gDp = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                bVar.gDq = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                bVar.gDr = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                bVar.gDs = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                bVar.gDt = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                bVar.gDu = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                bVar.gDv = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                bVar.gDw = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                bVar.gDx = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                bVar.gCT = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                bVar.gCU = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                bVar.gCV = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                bVar.gCW = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                bVar.gCZ = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                bVar.gDa = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                bVar.gDb = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                bVar.gDc = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                bVar.gDy = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                bVar.gDz = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                bVar.gDB[0] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                bVar.gDB[1] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                bVar.gDB[2] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                bVar.gDB[3] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                bVar.gDB[4] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                bVar.gDB[5] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                bVar.gDB[6] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                bVar.gDB[7] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                bVar.gDB[8] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                bVar.gDB[9] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                bVar.gDB[10] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                bVar.gDB[11] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                bVar.gDB[12] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                bVar.gDB[13] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                bVar.gDB[14] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                bVar.gDA = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctoff") != null && bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                bVar.gDA = 0;
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                bVar.gCX = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                bVar.gCY = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                bVar.gDC[0] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                bVar.gDC[1] = (short) bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                bVar.gDM = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                bVar.gDN = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                bVar.gDO = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                bVar.gDP = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                bVar.gDE = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                bVar.gDd = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.gCP = bh.getInt((String) y.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                bVar.gDG = bh.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                bVar.gDF = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                bVar.gDH = bh.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                bVar.gDF = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                bVar.gDI = bh.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                bVar.gDF = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                bVar.gDJ = bh.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                bVar.gDF = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                bVar.gDK = bh.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                bVar.gDF = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                bVar.gDL = bh.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                bVar.gDF = true;
            }
            if (y.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.gEK = true;
                kVar.gEL = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.gEC = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                kVar.gED = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                kVar.gEE = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                kVar.gEG = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                kVar.gEF = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                kVar.gEH = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                kVar.gEJ = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                kVar.gEI = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.app") != null) {
                kVar.gEM = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                kVar.gFf = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                kVar.gFg = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                kVar.gFh = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                kVar.gFi = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                kVar.gEN = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                kVar.gEO = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                kVar.gEP = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                kVar.gEQ = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.linespe") != null) {
                kVar.gER = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                kVar.gFc = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                kVar.gES = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                kVar.gET = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                kVar.gEU = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                kVar.gEX = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                kVar.gEW = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.gEY = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.gEZ = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                kVar.gEV = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.gEY = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.gEZ = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.base") != null) {
                kVar.gFj = (String) y.get(".deviceinfoconfig.voip.common.base");
            }
            if (y.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                kVar.gFk = (String) y.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (y.get(".deviceinfoconfig.voip.common.classloader") != null) {
                kVar.gFl = (String) y.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (y.get(".deviceinfoconfig.voip.common.resources") != null) {
                kVar.gFm = (String) y.get(".deviceinfoconfig.voip.common.resources");
            }
            if (y.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                kVar.gFa = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                kVar.gFn = (String) y.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                kVar.gFo = (String) y.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                kVar.gFp = (String) y.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                kVar.gFq = (String) y.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                kVar.gFr = (String) y.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (y.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                kVar.gFs = (String) y.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                kVar.gFb = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                kVar.gFt = (String) y.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (y.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                kVar.gFu = (String) y.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (y.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == bh.getInt((String) y.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.xie = true;
            }
            if (y.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.xif = bh.getDouble((String) y.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (y.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                kVar.gFv = (String) y.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (y.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                kVar.gFw = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                kVar.gFx = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (y.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                kVar.gFy = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                a.bi(kVar.gFy == 1);
            }
            if (y.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                kVar.gFz = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (y.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                kVar.gFd = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                kVar.gFe = bh.getDouble((String) y.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (y.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                kVar.gFA = bh.getInt((String) y.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                vVar.gGy = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                vVar.mVideoWidth = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                vVar.mVideoHeight = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                vVar.gGz = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                vVar.gGA = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                vVar.gGB = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                vVar.gGC = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                vVar.gGD = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                vVar.gGE = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                vVar.gGF = bh.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                zVar.gGK = bh.getInt((String) y.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (y.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                zVar.gGL = bh.getInt((String) y.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                x.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(zVar.gGL));
                ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", zVar.gGL).commit();
            }
            kVar.dump();
            int i = bh.getInt((String) y.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = bh.getInt((String) y.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            x.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (sVar != null) {
                sVar.fJ(i);
                sVar.fI(i2);
            }
            x.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(bh.getInt((String) y.get(".deviceinfoconfig.soter.isSupport"), 0)));
            if (xVar != null) {
                xVar.bg(i2 == 1);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) y.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (uVar != null) {
                uVar.eJ(r2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", bi.y(str, "manufacturerName"));
            if (uVar != null) {
                uVar.i(r2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(bh.getInt((String) y.get(".deviceinfoconfig.style.swipback"), 0)));
            if (uVar != null) {
                uVar.fK(i2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", Integer.valueOf(bh.getInt((String) y.get(".deviceinfoconfig.game.isLimit"), 0)), (String) y.get(".deviceinfoconfig.game.limitPrompt"));
            if (aVar != null) {
                aVar.be(i == 1);
                aVar.eF(r2);
            }
            i = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            int i3 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            int i4 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i5 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i6 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i7 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i8 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            int i9 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            int i10 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.useMetering"), -1);
            int i11 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
            i2 = bh.getInt((String) y.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
            if (tVar != null) {
                tVar.gGj = i;
                tVar.gGk = i3;
                tVar.gGl = i4;
                tVar.gGm = i5;
                tVar.gGn = i6;
                tVar.gGo = i7;
                tVar.gGp = i8;
                tVar.gGq = i9;
                tVar.gGr = i10;
                tVar.gGs = i11;
                tVar.gGt = i2;
                x.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", tVar.toString());
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfoParser", e, "", new Object[0]);
            return false;
        }
    }
}
