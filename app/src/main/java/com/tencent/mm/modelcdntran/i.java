package com.tencent.mm.modelcdntran;

import java.util.Map;

public class i {
    public boolean allow_mobile_net_download = false;
    public boolean fLH;
    public int field_advideoflag = 0;
    public String field_aesKey = "";
    public int field_appType = 0;
    public int field_arg = 0;
    public boolean field_autostart = false;
    public int field_bzScene = 0;
    public int field_chattype = 0;
    public boolean field_enable_hitcheck = true;
    public String field_fake_bigfile_signature = "";
    public String field_fake_bigfile_signature_aeskey = "";
    public String field_fileId = "";
    public int field_fileType = 0;
    public String field_filemd5 = "";
    public boolean field_force_aeskeycdn = false;
    public String field_fullpath = "";
    public boolean field_isColdSnsData = false;
    public boolean field_isSilentTask = false;
    public boolean field_isStreamMedia = false;
    public boolean field_largesvideo = false;
    public long field_lastProgressCallbackTime = 0;
    public int field_limitrate = 0;
    public String field_mediaId = "";
    public int field_midFileLength = 0;
    public String field_midimgpath = "";
    public boolean field_needCompressImage = false;
    public boolean field_needStorage = false;
    public boolean field_onlycheckexist = false;
    public int field_preloadRatio = 30;
    public int field_priority = 0;
    public int field_requestVideoFormat = 1;
    public boolean field_sendmsg_viacdn = false;
    public String field_signalQuality = "";
    public int field_smallVideoFlag = 0;
    public String field_snsScene = "";
    public long field_startTime = 0;
    public String field_svr_signature = "";
    public String field_talker = "";
    public String field_thumbpath = "";
    public int field_totalLen = 0;
    public boolean field_trysafecdn = false;
    public String field_videoFileId = "";
    public String field_wxmsgparam = "";
    public String htA = "";
    public Map<String, String> htB = null;
    public boolean htC = false;
    public int htD;
    public int htE = 1;
    public b htF;
    public a htt;
    public String htu = "";
    public int htv = 0;
    public int htw = 0;
    public String[] htx = null;
    public boolean hty = true;
    public boolean htz = false;
    public int initialDownloadLength = -1;
    public int initialDownloadOffset = -1;
    public boolean is_resume_task = false;

    public interface b {
        void b(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult);
    }

    public final boolean MM() {
        return this.htE == 2;
    }

    public final boolean MN() {
        return this.htE == 1;
    }
}
