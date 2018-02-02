package com.tencent.mm.hardcoder;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.format.Time;
import com.tencent.mm.hardcoder.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class HardCoderJNI {
    public static final long ACTION_ALLOC_MEMORY = 65536;
    public static final long ACTION_ANIMATION = 2;
    public static final long ACTION_DECODE_PIC = 64;
    public static final long ACTION_DECODE_STREAM = 1024;
    public static final long ACTION_DECODE_VIDEO = 256;
    public static final long ACTION_DEXO2OAT = 1;
    public static final long ACTION_ENCODE_PIC = 128;
    public static final long ACTION_ENCODE_STREAM = 2048;
    public static final long ACTION_ENCODE_VIDEO = 512;
    public static final long ACTION_INIT_LISTVIEW = 16;
    public static final long ACTION_NET_RX = 131072;
    public static final long ACTION_NET_TX = 262144;
    public static final long ACTION_ONCREATE = 4;
    public static final long ACTION_ONDESTROY = 8;
    public static final long ACTION_QUERY_SQL = 4096;
    public static final long ACTION_READ_FILE = 16384;
    public static final long ACTION_SCROLL_LISTVIEW = 32;
    public static final long ACTION_WRITE_FILE = 32768;
    public static final long ACTION_WRITE_SQL = 8192;
    public static final int CPU_LEVEL_0 = 0;
    public static final int CPU_LEVEL_1 = 1;
    public static final int CPU_LEVEL_2 = 2;
    public static final int CPU_LEVEL_3 = 3;
    public static final long FLAG_ALBUM_SCROLL = 16384;
    public static final long FLAG_ALL = -1;
    public static final long FLAG_BOOT = 2;
    public static final long FLAG_DB = 256;
    public static final long FLAG_DECODE_PIC = 512;
    public static final long FLAG_ENCODE_VIDEO = 4096;
    public static final long FLAG_ENTER_CHATTING = 32;
    public static final long FLAG_GIF_DROP_FRAME = 2048;
    public static final long FLAG_GIF_INIT = 1024;
    public static final long FLAG_MEDIA_GALLERY_SCROLL = 32768;
    public static final long FLAG_QUIT_CHATTING = 64;
    public static final long FLAG_RECEIVE_MSG = 4;
    public static final long FLAG_SEND_MSG = 8;
    public static final long FLAG_SEND_PIC_MSG = 16;
    public static final long FLAG_SNS_SCROLL = 8192;
    public static final long FLAG_UPDATE_CHATROOM = 128;
    public static final int FUNC_BASE = 1000;
    public static final int FUNC_CANCEL_CPU_CORE_FOR_THREAD = 1005;
    public static final int FUNC_CANCEL_CPU_HIGH_FREQ = 1003;
    public static final int FUNC_CANCEL_HIGH_IO_FREQ = 1007;
    public static final int FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE = 1014;
    public static final int FUNC_CHECK_PERMISSION = 1001;
    public static final int FUNC_CPU_CORE_FOR_THREAD = 1004;
    public static final int FUNC_CPU_HIGH_FREQ = 1002;
    public static final int FUNC_HIGH_IO_FREQ = 1006;
    public static final int FUNC_REG_ANR_CALLBACK = 1010;
    public static final int FUNC_REG_PRELOAD_BOOT_RESOURCE = 1011;
    public static final int FUNC_RESET_SCREEN_RESOLUTION = 1009;
    public static final int FUNC_SET_SCREEN_RESOLUTION = 1008;
    public static final int FUNC_TERMINATE_APP = 1012;
    public static final int FUNC_UNIFY_CPU_IO_THREAD_CORE = 1013;
    public static final int IDKEY_HARDCODER_FEATURES = 678;
    public static final int IDKEY_HARDCODER_PERFORMANCES = 679;
    public static final int IO_LEVEL_0 = 0;
    public static final int IO_LEVEL_1 = 1;
    public static final int IO_LEVEL_2 = 2;
    public static final int IO_LEVEL_3 = 3;
    public static final String KEY_HC_ALBUM_SCROLL_ACTION = "KEY_HC_ALBUM_SCROLL_ACTION";
    public static final String KEY_HC_ALBUM_SCROLL_CPU = "KEY_HC_ALBUM_SCROLL_CPU";
    public static final String KEY_HC_ALBUM_SCROLL_DELEY = "KEY_HC_ALBUM_SCROLL_DELEY";
    public static final String KEY_HC_ALBUM_SCROLL_ENABLE = "KEY_HCALBUM_SCROLL_ENABLE";
    public static final String KEY_HC_ALBUM_SCROLL_IO = "KEY_HC_ALBUM_SCROLL_IO";
    public static final String KEY_HC_ALBUM_SCROLL_THR = "KEY_HC_ALBUM_SCROLL_THR";
    public static final String KEY_HC_ALBUM_SCROLL_TIMEOUT = "KEY_HC_ALBUM_SCROLL_TIMEOUT";
    public static final String KEY_HC_BEGIN_TIME_HOUR = "KEY_HC_BEGIN_TIME_HOUR";
    public static final String KEY_HC_BEGIN_TIME_MIN = "KEY_HC_BEGIN_TIME_MIN";
    public static final String KEY_HC_BG_ENABLE = "KEY_HC_BG_ENABLE";
    public static final String KEY_HC_BOOT_ACTION = "KEY_HC_BOOT_ACTION";
    public static final String KEY_HC_BOOT_CPU = "KEY_HC_BOOT_CPU";
    public static final String KEY_HC_BOOT_DELEY = "KEY_HC_BOOT_DELEY";
    public static final String KEY_HC_BOOT_ENABLE = "KEY_HC_BOOT_ENABLE";
    public static final String KEY_HC_BOOT_IO = "KEY_HC_BOOT_IO";
    public static final String KEY_HC_BOOT_THR = "KEY_HC_BOOT_THR";
    public static final String KEY_HC_BOOT_TIMEOUT = "KEY_HC_BOOT_TIMEOUT";
    public static final String KEY_HC_DB_ACTION_QUERY = "KEY_HC_DB_ACTION_QUERY";
    public static final String KEY_HC_DB_ACTION_WRITE = "KEY_HC_DB_ACTION_WRITE";
    public static final String KEY_HC_DB_CPU = "KEY_HC_DB_CPU";
    public static final String KEY_HC_DB_DELEY_QUERY = "KEY_HC_DB_DELEY_QUERY";
    public static final String KEY_HC_DB_DELEY_WRITE = "KEY_HC_DB_DELEY_WRITE";
    public static final String KEY_HC_DB_ENABLE = "KEY_HC_DB_ENABLE";
    public static final String KEY_HC_DB_IO = "KEY_HC_DB_IO";
    public static final String KEY_HC_DB_THR = "KEY_HC_DB_THR";
    public static final String KEY_HC_DB_TIMEOUT = "KEY_HC_DB_TIMEOUT";
    public static final String KEY_HC_DB_TIMEOUT_BUSY = "KEY_HC_DB_TIMEOUT_BUSY";
    public static final String KEY_HC_DEBUG = "KEY_HC_DEBUG";
    public static final String KEY_HC_DECODE_PIC_ACTION = "KEY_HC_DECODE_PIC_ACTION";
    public static final String KEY_HC_DECODE_PIC_CPU = "KEY_HC_DECODE_PIC_CPU";
    public static final String KEY_HC_DECODE_PIC_DELEY = "KEY_HC_DECODE_PIC_DELEY";
    public static final String KEY_HC_DECODE_PIC_ENABLE = "KEY_HC_DECODE_PIC_ENABLE";
    public static final String KEY_HC_DECODE_PIC_IO = "KEY_HC_DECODE_PIC_IO";
    public static final String KEY_HC_DECODE_PIC_THR = "KEY_HC_DECODE_PIC_THR";
    public static final String KEY_HC_DECODE_PIC_TIMEOUT = "KEY_HC_DECODE_PIC_TIMEOUT";
    public static final String KEY_HC_ENABLE = "KEY_HC_ENABLE";
    public static final String KEY_HC_ENCODE_VIDEO_ACTION = "KEY_HC_ENCODE_VIDEO_ACTION";
    public static final String KEY_HC_ENCODE_VIDEO_CPU = "KEY_HC_ENCODE_VIDEO_CPU";
    public static final String KEY_HC_ENCODE_VIDEO_DELEY = "KEY_HC_ENCODE_VIDEO_DELEY";
    public static final String KEY_HC_ENCODE_VIDEO_ENABLE = "KEY_HC_ENCODE_VIDEO_ENABLE";
    public static final String KEY_HC_ENCODE_VIDEO_IO = "KEY_HC_ENCODE_VIDEO_IO";
    public static final String KEY_HC_ENCODE_VIDEO_THR = "KEY_HC_ENCODE_VIDEO_THR";
    public static final String KEY_HC_ENCODE_VIDEO_TIMEOUT = "KEY_HC_ENCODE_VIDEO_TIMEOUT";
    public static final String KEY_HC_END_TIME_HOUR = "KEY_HC_END_TIME_HOUR";
    public static final String KEY_HC_END_TIME_MIN = "KEY_HC_END_TIME_MIN";
    public static final String KEY_HC_ENTER_CHATTING_ACTION = "KEY_HC_ENTER_CHATTING_ACTION";
    public static final String KEY_HC_ENTER_CHATTING_CPU = "KEY_HC_ENTER_CHATTING_CPU";
    public static final String KEY_HC_ENTER_CHATTING_DELEY = "KEY_HC_ENTER_CHATTING_DELEY";
    public static final String KEY_HC_ENTER_CHATTING_ENABLE = "KEY_HC_ENTER_CHATTING_ENABLE";
    public static final String KEY_HC_ENTER_CHATTING_IO = "KEY_HC_ENTER_CHATTING_IO";
    public static final String KEY_HC_ENTER_CHATTING_THR = "KEY_HC_ENTER_CHATTING_THR";
    public static final String KEY_HC_ENTER_CHATTING_TIMEOUT = "KEY_HC_ENTER_CHATTING_TIMEOUT";
    public static final String KEY_HC_GIF_ACTION = "KEY_HC_GIF_ACTION";
    public static final String KEY_HC_GIF_CPU = "KEY_HC_GIF_CPU";
    public static final String KEY_HC_GIF_DELEY = "KEY_HC_GIF_DELEY";
    public static final String KEY_HC_GIF_ENABLE = "KEY_HC_GIF_ENABLE";
    public static final String KEY_HC_GIF_FRAME_ACTION = "KEY_HC_GIF_FRAME_ACTION";
    public static final String KEY_HC_GIF_FRAME_CPU = "KEY_HC_GIF_FRAME_CPU";
    public static final String KEY_HC_GIF_FRAME_DELEY = "KEY_HC_GIF_FRAME_DELEY";
    public static final String KEY_HC_GIF_FRAME_ENABLE = "KEY_HC_GIF_FRAME_ENABLE";
    public static final String KEY_HC_GIF_FRAME_IO = "KEY_HC_GIF_FRAME_IO";
    public static final String KEY_HC_GIF_FRAME_THR = "KEY_HC_GIF_FRAME_THR";
    public static final String KEY_HC_GIF_FRAME_TIMEOUT = "KEY_HC_GIF_FRAME_TIMEOUT";
    public static final String KEY_HC_GIF_IO = "KEY_HC_GIF_IO";
    public static final String KEY_HC_GIF_THR = "KEY_HC_GIF_THR";
    public static final String KEY_HC_GIF_TIMEOUT = "KEY_HC_GIF_TIMEOUT";
    public static final String KEY_HC_KV_FT = "KEY_HC_KV_FT";
    public static final String KEY_HC_KV_PER = "KEY_HC_KV_PER";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_ACTION = "KEY_HC_MEDIA_GALLERY_SCROLL_ACTION";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_CPU = "KEY_HC_MEDIA_GALLERY_SCROLL_CPU";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_DELEY = "KEY_HC_MEDIA_GALLERY_SCROLL_DELEY";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE = "KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_IO = "KEY_HC_MEDIA_GALLERY_SCROLL_IO";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_THR = "KEY_HC_MEDIA_GALLERY_SCROLL_THR";
    public static final String KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT = "KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT";
    public static final String KEY_HC_QUIT_CHATTING_ACTION = "KEY_HC_QUIT_CHATTING_ACTION";
    public static final String KEY_HC_QUIT_CHATTING_CPU = "KEY_HC_QUIT_CHATTING_CPU";
    public static final String KEY_HC_QUIT_CHATTING_DELEY = "KEY_HC_QUIT_CHATTING_DELEY";
    public static final String KEY_HC_QUIT_CHATTING_ENABLE = "KEY_HC_QUIT_CHATTING_ENABLE";
    public static final String KEY_HC_QUIT_CHATTING_IO = "KEY_HC_QUIT_CHATTING_IO";
    public static final String KEY_HC_QUIT_CHATTING_THR = "KEY_HC_QUIT_CHATTING_THR";
    public static final String KEY_HC_QUIT_CHATTING_TIMEOUT = "KEY_HC_QUIT_CHATTING_TIMEOUT";
    public static final String KEY_HC_RECEIVE_MSG_ACTION = "KEY_HC_RECEIVE_MSG_ACTION";
    public static final String KEY_HC_RECEIVE_MSG_CPU = "KEY_HC_RECEIVE_MSG_CPU";
    public static final String KEY_HC_RECEIVE_MSG_DELEY = "KEY_HC_RECEIVE_MSG_DELEY";
    public static final String KEY_HC_RECEIVE_MSG_ENABLE = "KEY_HC_RECEIVE_MSG_ENABLE";
    public static final String KEY_HC_RECEIVE_MSG_IO = "KEY_HC_RECEIVE_MSG_IO";
    public static final String KEY_HC_RECEIVE_MSG_THR = "KEY_HC_RECEIVE_MSG_THR";
    public static final String KEY_HC_RECEIVE_MSG_TIMEOUT = "KEY_HC_RECEIVE_MSG_TIMEOUT";
    public static final String KEY_HC_RETRY_INTERVAL = "KEY_HC_RETRY_INTERVAL";
    public static final String KEY_HC_SEND_MSG_ACTION = "KEY_HC_SEND_MSG_ACTION";
    public static final String KEY_HC_SEND_MSG_CPU = "KEY_HC_SEND_MSG_CPU";
    public static final String KEY_HC_SEND_MSG_DELEY = "KEY_HC_SEND_MSG_DELEY";
    public static final String KEY_HC_SEND_MSG_ENABLE = "KEY_HC_SEND_MSG_ENABLE";
    public static final String KEY_HC_SEND_MSG_IO = "KEY_HC_SEND_MSG_IO";
    public static final String KEY_HC_SEND_MSG_THR = "KEY_HC_SEND_MSG_THR";
    public static final String KEY_HC_SEND_MSG_TIMEOUT = "KEY_HC_SEND_MSG_TIMEOUT";
    public static final String KEY_HC_SEND_PIC_MSG_ACTION = "KEY_HC_SEND_PIC_MSG_ACTION";
    public static final String KEY_HC_SEND_PIC_MSG_CPU = "KEY_HC_SEND_PIC_MSG_CPU";
    public static final String KEY_HC_SEND_PIC_MSG_DELEY = "KEY_HC_SEND_PIC_MSG_DELEY";
    public static final String KEY_HC_SEND_PIC_MSG_ENABLE = "KEY_HC_SEND_PIC_MSG_ENABLE";
    public static final String KEY_HC_SEND_PIC_MSG_IO = "KEY_HC_SEND_PIC_MSG_IO";
    public static final String KEY_HC_SEND_PIC_MSG_THR = "KEY_HC_SEND_PIC_MSG_THR";
    public static final String KEY_HC_SEND_PIC_MSG_TIMEOUT = "KEY_HC_SEND_PIC_MSG_TIMEOUT";
    public static final String KEY_HC_SNS_SCROLL_ACTION = "KEY_HC_SNS_SCROLL_ACTION";
    public static final String KEY_HC_SNS_SCROLL_CPU = "KEY_HC_SNS_SCROLL_CPU";
    public static final String KEY_HC_SNS_SCROLL_DELEY = "KEY_HC_SNS_SCROLL_DELEY";
    public static final String KEY_HC_SNS_SCROLL_ENABLE = "KEY_HC_SNS_SCROLL_ENABLE";
    public static final String KEY_HC_SNS_SCROLL_IO = "KEY_HC_SNS_SCROLL_IO";
    public static final String KEY_HC_SNS_SCROLL_THR = "KEY_HC_SNS_SCROLL_THR";
    public static final String KEY_HC_SNS_SCROLL_TIMEOUT = "KEY_HC_SNS_SCROLL_TIMEOUT";
    public static final String KEY_HC_SWITCH_ENABLE = "KEY_HC_SWITCH_ENABLE";
    public static final String KEY_HC_TIMEOUT_MARGIN = "KEY_HC_TIMEOUT_MARGIN";
    public static final String KEY_HC_TIME_LIMIT = "KEY_HC_TIME_LIMIT";
    public static final String KEY_HC_UIN_HASH = "KEY_HC_UIN_HASH";
    public static final String KEY_HC_UPDATE_CHATROOM_ACTION = "KEY_HC_UPDATE_CHATROOM_ACTION";
    public static final String KEY_HC_UPDATE_CHATROOM_CPU = "KEY_HC_UPDATE_CHATROOM_CPU";
    public static final String KEY_HC_UPDATE_CHATROOM_DELEY = "KEY_HC_UPDATE_CHATROOM_DELEY";
    public static final String KEY_HC_UPDATE_CHATROOM_ENABLE = "KEY_HC_UPDATE_CHATROOM_ENABLE";
    public static final String KEY_HC_UPDATE_CHATROOM_IO = "KEY_HC_UPDATE_CHATROOM_IO";
    public static final String KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT = "KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT";
    public static final String KEY_HC_UPDATE_CHATROOM_THR = "KEY_HC_UPDATE_CHATROOM_THR";
    public static final String KEY_HC_UPDATE_CHATROOM_TIMEOUT = "KEY_HC_UPDATE_CHATROOM_TIMEOUT";
    public static int RELOAD_SCENE_ABTEST = 4;
    public static int RELOAD_SCENE_DAY_RECEIVER = 3;
    public static int RELOAD_SCENE_INIT = 0;
    public static int RELOAD_SCENE_POST_RESET = 2;
    public static int RELOAD_SCENE_SETTING = 1;
    public static final int SCENE_ALBUM_SCROLL = 702;
    public static final int SCENE_BOOT = 101;
    public static final int SCENE_DB = 501;
    public static final int SCENE_DECODE_PIC = 601;
    public static final int SCENE_ENCODE_VIDEO = 603;
    public static final int SCENE_ENTER_CHATTING = 301;
    public static final int SCENE_GIF = 602;
    public static final int SCENE_MEDIA_GALLERY_SCROLL = 703;
    public static final int SCENE_QUIT_CHATTING = 302;
    public static final int SCENE_RECEIVE_MSG = 201;
    public static final int SCENE_SEND_MSG = 202;
    public static final int SCENE_SEND_PIC_MSG = 203;
    public static final int SCENE_SNS_SCROLL = 701;
    public static final int SCENE_UPDATE_CHATROOM = 401;
    public static final String SETTING_SP_FILE = "hardcoder_setting";
    public static final String SETTING_UI_ACTION = "com.tencent.mm.action.HARDCODER_SETTING";
    public static final boolean SETTING_UI_ENABLE = false;
    private static final String TAG = "MicroMsg.HardCoderJNI";
    public static int TICK_RATE = 100;
    private static Callback callback = null;
    public static boolean checkEnv = false;
    private static final String clientSock = ".hardcoder.client.sock";
    public static HashMap<Long, String> flagKeyMap = new HashMap();
    public static boolean foreground = false;
    public static long hcAlbumScrollAction = 96;
    public static int hcAlbumScrollCPU = 3;
    public static int hcAlbumScrollDelay = 0;
    public static boolean hcAlbumScrollEnable = true;
    public static int hcAlbumScrollIO = 2;
    public static boolean hcAlbumScrollThr = false;
    public static int hcAlbumScrollTimeout = 1500;
    public static int hcBeginTimeHour = 8;
    public static int hcBeginTimeMin = 0;
    public static boolean hcBgEnable = true;
    public static long hcBootAction = 4;
    public static int hcBootCPU = 1;
    public static int hcBootDelay = 0;
    public static boolean hcBootEnable = true;
    public static int hcBootIO = 0;
    public static boolean hcBootThr = false;
    public static int hcBootTimeout = 5000;
    public static long hcDBActionQuery = 4096;
    public static long hcDBActionWrite = 12288;
    public static int hcDBCPU = 2;
    public static int hcDBDelayQuery = 100;
    public static int hcDBDelayWrite = 200;
    public static boolean hcDBEnable = false;
    public static int hcDBIO = 2;
    public static boolean hcDBThr = false;
    public static int hcDBTimeout = 500;
    public static int hcDBTimeoutBusy = 5000;
    public static boolean hcDebug = false;
    public static long hcDecodePicAction = sHCDECODEPICACTION;
    public static int hcDecodePicCPU = 2;
    public static int hcDecodePicDelay = 100;
    public static boolean hcDecodePicEnable = false;
    public static int hcDecodePicIO = 2;
    public static boolean hcDecodePicThr = false;
    public static int hcDecodePicTimeout = 500;
    public static boolean hcEnable = true;
    public static long hcEncodeVideoAction = 81984;
    public static int hcEncodeVideoCPU = 1;
    public static int hcEncodeVideoDelay = 0;
    public static boolean hcEncodeVideoEnable = true;
    public static int hcEncodeVideoIO = 1;
    public static boolean hcEncodeVideoThr = false;
    public static int hcEncodeVideoTimeout = sHCENCODEVIDEOTIMEOUT;
    public static int hcEndTimeHour = 23;
    public static int hcEndTimeMin = 0;
    public static long hcEnterChattingAction = sHCENTERCHATTINGACTION;
    public static int hcEnterChattingCPU = 2;
    public static int hcEnterChattingDelay = 0;
    public static boolean hcEnterChattingEnable = true;
    public static int hcEnterChattingIO = 2;
    public static boolean hcEnterChattingThr = false;
    public static int hcEnterChattingTimeout = 1000;
    public static long hcGifAction = 81984;
    public static int hcGifCPU = 3;
    public static int hcGifDelay = 0;
    public static boolean hcGifEnable = true;
    public static long hcGifFrameAction = sHCGIFFRAMEACTION;
    public static int hcGifFrameCPU = 2;
    public static int hcGifFrameDelay = 0;
    public static boolean hcGifFrameEnable = true;
    public static int hcGifFrameIO = 0;
    public static boolean hcGifFrameThr = false;
    public static int hcGifFrameTimeout = 1000;
    public static int hcGifIO = 2;
    public static boolean hcGifThr = false;
    public static int hcGifTimeout = 500;
    public static boolean hcKVFtReport = sHCREPORT;
    public static boolean hcKVPerReport = false;
    public static long hcMediaGalleryScrollAction = 96;
    public static int hcMediaGalleryScrollCPU = 3;
    public static int hcMediaGalleryScrollDelay = 0;
    public static boolean hcMediaGalleryScrollEnable = true;
    public static int hcMediaGalleryScrollIO = 2;
    public static boolean hcMediaGalleryScrollThr = false;
    public static int hcMediaGalleryScrollTimeout = 1500;
    public static long hcQuitChattingAction = sHCQUITCHATTINGACTION;
    public static int hcQuitChattingCPU = 2;
    public static int hcQuitChattingDelay = 0;
    public static boolean hcQuitChattingEnable = true;
    public static int hcQuitChattingIO = 2;
    public static boolean hcQuitChattingThr = false;
    public static int hcQuitChattingTimeout = 800;
    public static long hcReceiveMsgAction = 127040;
    public static int hcReceiveMsgCPU = 2;
    public static int hcReceiveMsgDelay = 500;
    public static boolean hcReceiveMsgEnable = true;
    public static int hcReceiveMsgIO = 2;
    public static boolean hcReceiveMsgThr = true;
    public static int hcReceiveMsgTimeout = 1000;
    public static int hcRetryInterval = 30;
    public static long hcSNSScrollAction = 96;
    public static int hcSNSScrollCPU = 3;
    public static int hcSNSScrollDelay = 0;
    public static boolean hcSNSScrollEnable = true;
    public static int hcSNSScrollIO = 2;
    public static boolean hcSNSScrollThr = false;
    public static int hcSNSScrollTimeout = 1500;
    public static long hcSendMsgAction = 12288;
    public static int hcSendMsgCPU = 3;
    public static int hcSendMsgDelay = 0;
    public static boolean hcSendMsgEnable = true;
    public static int hcSendMsgIO = 0;
    public static boolean hcSendMsgThr = true;
    public static int hcSendMsgTimeout = 1000;
    public static long hcSendPicMsgAction = sHCSENDPICMSGACTION;
    public static int hcSendPicMsgCPU = 1;
    public static int hcSendPicMsgDelay = 0;
    public static boolean hcSendPicMsgEnable = true;
    public static int hcSendPicMsgIO = 2;
    public static boolean hcSendPicMsgThr = true;
    public static int hcSendPicMsgTimeout = 500;
    public static boolean hcSwitchEnable = true;
    private static boolean hcSwitchOn = true;
    public static boolean hcTimeLimit = false;
    public static int hcTimeoutMargin = 0;
    public static int hcUinHash = 0;
    public static long hcUpdateChatroomAction = 127040;
    public static int hcUpdateChatroomCPU = 2;
    public static int hcUpdateChatroomDelay = 0;
    public static boolean hcUpdateChatroomEnable = true;
    public static int hcUpdateChatroomIO = 2;
    public static long hcUpdateChatroomMemberCount = 50;
    public static boolean hcUpdateChatroomThr = true;
    public static int hcUpdateChatroomTimeout = 1000;
    public static final long sHCALBUMSCROLLACTION = 96;
    public static final int sHCALBUMSCROLLCPU = 3;
    public static final int sHCALBUMSCROLLDELAY = 0;
    public static final boolean sHCALBUMSCROLLENABLE = true;
    public static final int sHCALBUMSCROLLIO = 2;
    public static final boolean sHCALBUMSCROLLTHR = false;
    public static final int sHCALBUMSCROLLTIMEOUT = 1500;
    public static final int sHCBEGINHOUR = 8;
    public static final int sHCBEGINMIN = 0;
    public static final boolean sHCBGENABLE = true;
    public static final long sHCBOOTACTION = 4;
    public static final int sHCBOOTCPU = 1;
    public static final int sHCBOOTDELAY = 0;
    public static final boolean sHCBOOTENABLE = true;
    public static final int sHCBOOTIO = 0;
    public static final boolean sHCBOOTTHR = false;
    public static final int sHCBOOTTIMEOUT = 5000;
    public static final long sHCDBACTION_QUERY = 4096;
    public static final long sHCDBACTION_WRITE = 12288;
    public static final int sHCDBCPU = 2;
    public static final int sHCDBDELAY_QUERY = 100;
    public static final int sHCDBDELAY_WRITE = 200;
    public static final boolean sHCDBENABLE = false;
    public static final int sHCDBIO = 2;
    public static final boolean sHCDBTHR = false;
    public static final int sHCDBTIMEOUT = 500;
    public static final int sHCDBTIMEOUT_BUSY = 5000;
    public static final boolean sHCDEBUG = false;
    public static final long sHCDECODEPICACTION = 16448;
    public static final int sHCDECODEPICCPU = 2;
    public static final int sHCDECODEPICDELAY = 100;
    public static final boolean sHCDECODEPICENABLE = false;
    public static final int sHCDECODEPICIO = 2;
    public static final boolean sHCDECODEPICTHR = false;
    public static final int sHCDECODEPICTIMEOUT = 500;
    public static final boolean sHCENABLE = true;
    public static final long sHCENCODEVIDEOACTION = 81984;
    public static final int sHCENCODEVIDEOCPU = 1;
    public static final int sHCENCODEVIDEODELAY = 0;
    public static final boolean sHCENCODEVIDEOENABLE = true;
    public static final int sHCENCODEVIDEOIO = 1;
    public static final boolean sHCENCODEVIDEOTHR = false;
    public static final int sHCENCODEVIDEOTIMEOUT = 20000;
    public static final int sHCENDHOUR = 23;
    public static final int sHCENDMIN = 0;
    public static final long sHCENTERCHATTINGACTION = 12294;
    public static final int sHCENTERCHATTINGCPU = 2;
    public static final int sHCENTERCHATTINGDELAY = 0;
    public static final boolean sHCENTERCHATTINGENABLE = true;
    public static final int sHCENTERCHATTINGIO = 2;
    public static final boolean sHCENTERCHATTINGTHR = false;
    public static final int sHCENTERCHATTINGTIMEOUT = 1000;
    public static final long sHCGIFACTION = 81984;
    public static final int sHCGIFCPU = 3;
    public static final int sHCGIFDELAY = 0;
    public static final boolean sHCGIFENABLE = true;
    public static final long sHCGIFFRAMEACTION = 65600;
    public static final int sHCGIFFRAMECPU = 2;
    public static final int sHCGIFFRAMEDELAY = 0;
    public static final boolean sHCGIFFRAMEENABLE = true;
    public static final int sHCGIFFRAMEIO = 0;
    public static final boolean sHCGIFFRAMETHR = false;
    public static final int sHCGIFFRAMETIMEOUT = 1000;
    public static final int sHCGIFIO = 2;
    public static final boolean sHCGIFTHR = false;
    public static final int sHCGIFTIMEOUT = 500;
    public static final long sHCMEDIAGALLERYSCROLLACTION = 96;
    public static final int sHCMEDIAGALLERYSCROLLCPU = 3;
    public static final int sHCMEDIAGALLERYSCROLLDELAY = 0;
    public static final boolean sHCMEDIAGALLERYSCROLLENABLE = true;
    public static final int sHCMEDIAGALLERYSCROLLIO = 2;
    public static final boolean sHCMEDIAGALLERYSCROLLTHR = false;
    public static final int sHCMEDIAGALLERYSCROLLTIMEOUT = 1500;
    private static a sHCPerfManager = null;
    public static final long sHCQUITCHATTINGACTION = 8194;
    public static final int sHCQUITCHATTINGCPU = 2;
    public static final int sHCQUITCHATTINGDELAY = 0;
    public static final boolean sHCQUITCHATTINGENABLE = true;
    public static final int sHCQUITCHATTINGIO = 2;
    public static final boolean sHCQUITCHATTINGTHR = false;
    public static final int sHCQUITCHATTINGTIMEOUT = 800;
    public static final long sHCRECEIVEMSGACTION = 127040;
    public static final int sHCRECEIVEMSGCPU = 2;
    public static final int sHCRECEIVEMSGDELAY = 500;
    public static final boolean sHCRECEIVEMSGENABLE = true;
    public static final int sHCRECEIVEMSGIO = 2;
    public static final boolean sHCRECEIVEMSGTHR = true;
    public static final int sHCRECEIVEMSGTIMEOUT = 1000;
    public static boolean sHCREPORT = false;
    public static final long sHCSENDMSGACTION = 12288;
    public static final int sHCSENDMSGCPU = 3;
    public static final int sHCSENDMSGDELAY = 0;
    public static final boolean sHCSENDMSGENABLE = true;
    public static final int sHCSENDMSGIO = 0;
    public static final boolean sHCSENDMSGTHR = true;
    public static final int sHCSENDMSGTIMEOUT = 1000;
    public static final long sHCSENDPICMSGACTION = 123072;
    public static final int sHCSENDPICMSGCPU = 1;
    public static final int sHCSENDPICMSGDELAY = 0;
    public static final boolean sHCSENDPICMSGENABLE = true;
    public static final int sHCSENDPICMSGIO = 2;
    public static final boolean sHCSENDPICMSGTHR = true;
    public static final int sHCSENDPICMSGTIMEOUT = 500;
    public static final long sHCSNSSCROLLACTION = 96;
    public static final int sHCSNSSCROLLCPU = 3;
    public static final int sHCSNSSCROLLDELAY = 0;
    public static final boolean sHCSNSSCROLLENABLE = true;
    public static final int sHCSNSSCROLLIO = 2;
    public static final boolean sHCSNSSCROLLTHR = false;
    public static final int sHCSNSSCROLLTIMEOUT = 1500;
    public static final boolean sHCSWITCHENABLE = true;
    public static final boolean sHCTIMELIMIT = false;
    public static final int sHCUINHASH = 0;
    public static final long sHCUPDATECHATROOMACTION = 127040;
    public static final int sHCUPDATECHATROOMCPU = 2;
    public static final int sHCUPDATECHATROOMDELAY = 0;
    public static final boolean sHCUPDATECHATROOMENABLE = true;
    public static final int sHCUPDATECHATROOMIO = 2;
    public static final int sHCUPDATECHATROOMMEMBERCOUNT = 50;
    public static final boolean sHCUPDATECHATROOMTHR = true;
    public static final int sHCUPDATECHATROOMTIMEOUT = 1000;
    public static final int sRETRYINTERVAL = 30;
    public static final int sTIMEOUTMARGIN = 0;
    private static final String serverPropKey = "persist.sys.hardcoder.name";

    public interface Callback {
        void onANR(String str);
    }

    public static native int cancelCpuCoreForThread(int[] iArr, int i, long j);

    public static native int cancelCpuHighFreq(int i, long j);

    public static native int cancelHighIOFreq(int i, long j);

    public static native int cancelUnifyCpuIOThreadCore(boolean z, boolean z2, boolean z3, int[] iArr, int i, long j);

    public static native int checkPermission(int i, int i2, int i3, long j);

    public static native int getTickRate();

    private static native int initHardCoder(String str, int i, String str2, boolean z);

    public static native int isRunning();

    public static native int registerANRCallback(int i, long j);

    public static native int registerBootPreloadResource(String[] strArr, int i, long j);

    public static native int requestCpuCoreForThread(int i, long j, int[] iArr, int i2, int i3, long j2);

    public static native int requestCpuHighFreq(int i, long j, int i2, int i3, int i4, long j2);

    public static native int requestHighIOFreq(int i, long j, int i2, int i3, int i4, long j2);

    public static native int requestScreenResolution(int i, String str, int i2, long j);

    public static native int requestUnifyCpuIOThreadCore(int i, long j, int i2, int i3, int[] iArr, int i4, int i5, long j2);

    public static native int resetScreenResolution(int i, long j);

    public static native void setDebug(boolean z);

    public static native void setHCEnable(boolean z);

    public static native void setRetryConnectInterval(int i);

    private static native int startTraceCpuLoad(int i, int i2);

    public static native int stopTraceCpuLoad(int i);

    public static native int terminateApp(int i, long j);

    public static int startTraceCpuLoad(int i) {
        if (checkEnv) {
            return startTraceCpuLoad(i, 20);
        }
        return -1;
    }

    public static int registerANRCallback(Callback callback) {
        if (!checkEnv) {
            return -1;
        }
        callback = callback;
        return registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
    }

    public static void onData(int i, long j, int i2, int i3, int i4, byte[] bArr) {
        x.i(TAG, "onData callbackType:" + i + " timestamp:" + j + " errCode:" + i2 + " funcid:" + i3 + " dataType:" + i4);
        d.a(i, j, i2, i3, i4);
        if (callback != null) {
            String str;
            String str2 = "";
            try {
                str = new String(bArr);
            } catch (Throwable th) {
                str = str2;
            }
            callback.onANR(str);
        }
    }

    static {
        flagKeyMap.put(Long.valueOf(2), KEY_HC_BOOT_ENABLE);
        flagKeyMap.put(Long.valueOf(4), KEY_HC_RECEIVE_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(8), KEY_HC_SEND_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(16), KEY_HC_SEND_PIC_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(32), KEY_HC_ENTER_CHATTING_ENABLE);
        flagKeyMap.put(Long.valueOf(64), KEY_HC_QUIT_CHATTING_ENABLE);
        flagKeyMap.put(Long.valueOf(128), KEY_HC_UPDATE_CHATROOM_ENABLE);
        flagKeyMap.put(Long.valueOf(256), KEY_HC_DB_ENABLE);
        flagKeyMap.put(Long.valueOf(512), KEY_HC_DECODE_PIC_ENABLE);
        flagKeyMap.put(Long.valueOf(1024), KEY_HC_GIF_ENABLE);
        flagKeyMap.put(Long.valueOf(2048), KEY_HC_GIF_FRAME_ENABLE);
        flagKeyMap.put(Long.valueOf(4096), KEY_HC_ENCODE_VIDEO_ENABLE);
        flagKeyMap.put(Long.valueOf(8192), KEY_HC_SNS_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(16384), KEY_HC_ALBUM_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(32768), KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE);
        reloadSPConfig(RELOAD_SCENE_INIT);
    }

    private HardCoderJNI() {
    }

    public static void reloadSPConfig(int i) {
        if (ac.cfw()) {
            checkEnv = checkHardCoderEnv();
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(SETTING_SP_FILE, 0);
            hcEnable = sharedPreferences.getBoolean(KEY_HC_ENABLE, true);
            if (checkEnv) {
                setHCEnable(hcEnable);
            }
            hcBgEnable = sharedPreferences.getBoolean(KEY_HC_BG_ENABLE, true);
            hcUinHash = sharedPreferences.getInt(KEY_HC_UIN_HASH, 0);
            boolean z = sharedPreferences.getBoolean(KEY_HC_SWITCH_ENABLE, true);
            hcSwitchEnable = z;
            hcSwitchOn = z;
            if (hcEnable && hcSwitchEnable) {
                hcSwitchOn = Calendar.getInstance().get(5) % 2 == 1;
                if (checkEnv) {
                    setHCEnable(hcSwitchOn);
                    reportIDKey(true, hcSwitchOn ? 8 : 9, 1, false);
                }
            }
            hcDebug = sharedPreferences.getBoolean(KEY_HC_DEBUG, false);
            x.i(TAG, "reloadSPConfig scene:%d hcDebug:%b hcEnable:%b hcUinHash:%d hcSwitchEnable:%b hcSwitchOn:%b checkEnv:%b stack[%s]", Integer.valueOf(i), Boolean.valueOf(hcDebug), Boolean.valueOf(hcEnable), Integer.valueOf(hcUinHash), Boolean.valueOf(hcSwitchEnable), Boolean.valueOf(hcSwitchOn), Boolean.valueOf(checkEnv), bh.cgy());
            hcRetryInterval = sharedPreferences.getInt(KEY_HC_RETRY_INTERVAL, 30);
            hcKVPerReport = sharedPreferences.getInt(KEY_HC_KV_PER, 0) < hcUinHash;
            if (sharedPreferences.getInt(KEY_HC_KV_FT, 0) < hcUinHash) {
                z = true;
            } else {
                z = false;
            }
            hcKVFtReport = z;
            hcTimeoutMargin = sharedPreferences.getInt(KEY_HC_TIMEOUT_MARGIN, 0);
            hcTimeLimit = sharedPreferences.getBoolean(KEY_HC_TIME_LIMIT, false);
            hcBeginTimeHour = sharedPreferences.getInt(KEY_HC_BEGIN_TIME_HOUR, 8);
            hcBeginTimeMin = sharedPreferences.getInt(KEY_HC_BEGIN_TIME_MIN, 0);
            hcEndTimeHour = sharedPreferences.getInt(KEY_HC_END_TIME_HOUR, 23);
            hcEndTimeMin = sharedPreferences.getInt(KEY_HC_END_TIME_MIN, 0);
            hcBootEnable = sharedPreferences.getBoolean(KEY_HC_BOOT_ENABLE, true);
            hcBootDelay = sharedPreferences.getInt(KEY_HC_BOOT_DELEY, 0);
            hcBootCPU = sharedPreferences.getInt(KEY_HC_BOOT_CPU, 1);
            hcBootIO = sharedPreferences.getInt(KEY_HC_BOOT_IO, 0);
            hcBootThr = sharedPreferences.getBoolean(KEY_HC_BOOT_THR, false);
            hcBootTimeout = sharedPreferences.getInt(KEY_HC_BOOT_TIMEOUT, 5000);
            hcBootAction = sharedPreferences.getLong(KEY_HC_BOOT_ACTION, 4);
            hcEnterChattingEnable = sharedPreferences.getBoolean(KEY_HC_ENTER_CHATTING_ENABLE, true);
            hcEnterChattingDelay = sharedPreferences.getInt(KEY_HC_ENTER_CHATTING_DELEY, 0);
            hcEnterChattingCPU = sharedPreferences.getInt(KEY_HC_ENTER_CHATTING_CPU, 2);
            hcEnterChattingIO = sharedPreferences.getInt(KEY_HC_ENTER_CHATTING_IO, 2);
            hcEnterChattingThr = sharedPreferences.getBoolean(KEY_HC_ENTER_CHATTING_THR, false);
            hcEnterChattingTimeout = sharedPreferences.getInt(KEY_HC_ENTER_CHATTING_TIMEOUT, 1000);
            hcEnterChattingAction = sharedPreferences.getLong(KEY_HC_ENTER_CHATTING_ACTION, sHCENTERCHATTINGACTION);
            hcQuitChattingEnable = sharedPreferences.getBoolean(KEY_HC_QUIT_CHATTING_ENABLE, true);
            hcQuitChattingDelay = sharedPreferences.getInt(KEY_HC_QUIT_CHATTING_DELEY, 0);
            hcQuitChattingCPU = sharedPreferences.getInt(KEY_HC_QUIT_CHATTING_CPU, 2);
            hcQuitChattingIO = sharedPreferences.getInt(KEY_HC_QUIT_CHATTING_IO, 2);
            hcQuitChattingThr = sharedPreferences.getBoolean(KEY_HC_QUIT_CHATTING_THR, false);
            hcQuitChattingTimeout = sharedPreferences.getInt(KEY_HC_QUIT_CHATTING_TIMEOUT, 800);
            hcQuitChattingAction = sharedPreferences.getLong(KEY_HC_QUIT_CHATTING_ACTION, sHCQUITCHATTINGACTION);
            hcSendMsgEnable = sharedPreferences.getBoolean(KEY_HC_SEND_MSG_ENABLE, true);
            hcSendMsgDelay = sharedPreferences.getInt(KEY_HC_SEND_MSG_DELEY, 0);
            hcSendMsgCPU = sharedPreferences.getInt(KEY_HC_SEND_MSG_CPU, 3);
            hcSendMsgIO = sharedPreferences.getInt(KEY_HC_SEND_MSG_IO, 0);
            hcSendMsgThr = sharedPreferences.getBoolean(KEY_HC_SEND_MSG_THR, true);
            hcSendMsgTimeout = sharedPreferences.getInt(KEY_HC_SEND_MSG_TIMEOUT, 1000);
            hcSendMsgAction = sharedPreferences.getLong(KEY_HC_SEND_MSG_ACTION, 12288);
            hcSendPicMsgEnable = sharedPreferences.getBoolean(KEY_HC_SEND_PIC_MSG_ENABLE, true);
            hcSendPicMsgDelay = sharedPreferences.getInt(KEY_HC_SEND_PIC_MSG_DELEY, 0);
            hcSendPicMsgCPU = sharedPreferences.getInt(KEY_HC_SEND_PIC_MSG_CPU, 1);
            hcSendPicMsgIO = sharedPreferences.getInt(KEY_HC_SEND_PIC_MSG_IO, 2);
            hcSendPicMsgThr = sharedPreferences.getBoolean(KEY_HC_SEND_PIC_MSG_THR, true);
            hcSendPicMsgTimeout = sharedPreferences.getInt(KEY_HC_SEND_PIC_MSG_TIMEOUT, 500);
            hcSendPicMsgAction = sharedPreferences.getLong(KEY_HC_SEND_PIC_MSG_ACTION, sHCSENDPICMSGACTION);
            hcReceiveMsgEnable = sharedPreferences.getBoolean(KEY_HC_RECEIVE_MSG_ENABLE, true);
            hcReceiveMsgDelay = sharedPreferences.getInt(KEY_HC_RECEIVE_MSG_DELEY, 500);
            hcReceiveMsgCPU = sharedPreferences.getInt(KEY_HC_RECEIVE_MSG_CPU, 2);
            hcReceiveMsgIO = sharedPreferences.getInt(KEY_HC_RECEIVE_MSG_IO, 2);
            hcReceiveMsgThr = sharedPreferences.getBoolean(KEY_HC_RECEIVE_MSG_THR, true);
            hcReceiveMsgTimeout = sharedPreferences.getInt(KEY_HC_RECEIVE_MSG_TIMEOUT, 1000);
            hcReceiveMsgAction = sharedPreferences.getLong(KEY_HC_RECEIVE_MSG_ACTION, 127040);
            hcUpdateChatroomEnable = sharedPreferences.getBoolean(KEY_HC_UPDATE_CHATROOM_ENABLE, true);
            hcUpdateChatroomDelay = sharedPreferences.getInt(KEY_HC_UPDATE_CHATROOM_DELEY, 0);
            hcUpdateChatroomCPU = sharedPreferences.getInt(KEY_HC_UPDATE_CHATROOM_CPU, 2);
            hcUpdateChatroomIO = sharedPreferences.getInt(KEY_HC_UPDATE_CHATROOM_IO, 2);
            hcUpdateChatroomThr = sharedPreferences.getBoolean(KEY_HC_UPDATE_CHATROOM_THR, true);
            hcUpdateChatroomTimeout = sharedPreferences.getInt(KEY_HC_UPDATE_CHATROOM_TIMEOUT, 1000);
            hcUpdateChatroomAction = sharedPreferences.getLong(KEY_HC_UPDATE_CHATROOM_ACTION, 127040);
            hcUpdateChatroomMemberCount = sharedPreferences.getLong(KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT, 50);
            hcDBEnable = sharedPreferences.getBoolean(KEY_HC_DB_ENABLE, false);
            hcDBDelayQuery = sharedPreferences.getInt(KEY_HC_DB_DELEY_QUERY, 100);
            hcDBDelayWrite = sharedPreferences.getInt(KEY_HC_DB_DELEY_WRITE, 200);
            hcDBCPU = sharedPreferences.getInt(KEY_HC_DB_CPU, 2);
            hcDBIO = sharedPreferences.getInt(KEY_HC_DB_IO, 2);
            hcDBThr = sharedPreferences.getBoolean(KEY_HC_DB_THR, false);
            hcDBTimeout = sharedPreferences.getInt(KEY_HC_DB_TIMEOUT, 500);
            hcDBTimeoutBusy = sharedPreferences.getInt(KEY_HC_DB_TIMEOUT_BUSY, 5000);
            hcDBActionQuery = sharedPreferences.getLong(KEY_HC_DB_ACTION_QUERY, 4096);
            hcDBActionWrite = sharedPreferences.getLong(KEY_HC_DB_ACTION_WRITE, 12288);
            hcEncodeVideoEnable = sharedPreferences.getBoolean(KEY_HC_ENCODE_VIDEO_ENABLE, true);
            hcEncodeVideoDelay = sharedPreferences.getInt(KEY_HC_ENCODE_VIDEO_DELEY, 0);
            hcEncodeVideoCPU = sharedPreferences.getInt(KEY_HC_ENCODE_VIDEO_CPU, 1);
            hcEncodeVideoIO = sharedPreferences.getInt(KEY_HC_ENCODE_VIDEO_IO, 1);
            hcEncodeVideoThr = sharedPreferences.getBoolean(KEY_HC_ENCODE_VIDEO_THR, false);
            hcEncodeVideoTimeout = sharedPreferences.getInt(KEY_HC_ENCODE_VIDEO_TIMEOUT, sHCENCODEVIDEOTIMEOUT);
            hcEncodeVideoAction = sharedPreferences.getLong(KEY_HC_ENCODE_VIDEO_ACTION, 81984);
            hcDecodePicEnable = sharedPreferences.getBoolean(KEY_HC_DECODE_PIC_ENABLE, false);
            hcDecodePicDelay = sharedPreferences.getInt(KEY_HC_DECODE_PIC_DELEY, 100);
            hcDecodePicCPU = sharedPreferences.getInt(KEY_HC_DECODE_PIC_CPU, 2);
            hcDecodePicIO = sharedPreferences.getInt(KEY_HC_DECODE_PIC_IO, 2);
            hcDecodePicThr = sharedPreferences.getBoolean(KEY_HC_DECODE_PIC_THR, false);
            hcDecodePicTimeout = sharedPreferences.getInt(KEY_HC_DECODE_PIC_TIMEOUT, 500);
            hcDecodePicAction = sharedPreferences.getLong(KEY_HC_DECODE_PIC_ACTION, sHCDECODEPICACTION);
            hcGifEnable = sharedPreferences.getBoolean(KEY_HC_GIF_ENABLE, true);
            hcGifDelay = sharedPreferences.getInt(KEY_HC_GIF_DELEY, 0);
            hcGifCPU = sharedPreferences.getInt(KEY_HC_GIF_CPU, 3);
            hcGifIO = sharedPreferences.getInt(KEY_HC_GIF_IO, 2);
            hcGifThr = sharedPreferences.getBoolean(KEY_HC_GIF_THR, false);
            hcGifTimeout = sharedPreferences.getInt(KEY_HC_GIF_TIMEOUT, 500);
            hcGifAction = sharedPreferences.getLong(KEY_HC_GIF_ACTION, 81984);
            hcGifFrameEnable = sharedPreferences.getBoolean(KEY_HC_GIF_FRAME_ENABLE, true);
            hcGifFrameDelay = sharedPreferences.getInt(KEY_HC_GIF_FRAME_DELEY, 0);
            hcGifFrameCPU = sharedPreferences.getInt(KEY_HC_GIF_FRAME_CPU, 2);
            hcGifFrameIO = sharedPreferences.getInt(KEY_HC_GIF_FRAME_IO, 0);
            hcGifFrameThr = sharedPreferences.getBoolean(KEY_HC_GIF_FRAME_THR, false);
            hcGifFrameTimeout = sharedPreferences.getInt(KEY_HC_GIF_FRAME_TIMEOUT, 1000);
            hcGifFrameAction = sharedPreferences.getLong(KEY_HC_GIF_FRAME_ACTION, sHCGIFFRAMEACTION);
            hcSNSScrollEnable = sharedPreferences.getBoolean(KEY_HC_SNS_SCROLL_ENABLE, true);
            hcSNSScrollDelay = sharedPreferences.getInt(KEY_HC_SNS_SCROLL_DELEY, 0);
            hcSNSScrollCPU = sharedPreferences.getInt(KEY_HC_SNS_SCROLL_CPU, 3);
            hcSNSScrollIO = sharedPreferences.getInt(KEY_HC_SNS_SCROLL_IO, 2);
            hcSNSScrollThr = sharedPreferences.getBoolean(KEY_HC_SNS_SCROLL_THR, false);
            hcSNSScrollTimeout = sharedPreferences.getInt(KEY_HC_SNS_SCROLL_TIMEOUT, 1500);
            hcSNSScrollAction = sharedPreferences.getLong(KEY_HC_SNS_SCROLL_ACTION, 96);
            hcMediaGalleryScrollEnable = sharedPreferences.getBoolean(KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE, true);
            hcMediaGalleryScrollDelay = sharedPreferences.getInt(KEY_HC_MEDIA_GALLERY_SCROLL_DELEY, 0);
            hcMediaGalleryScrollCPU = sharedPreferences.getInt(KEY_HC_MEDIA_GALLERY_SCROLL_CPU, 3);
            hcMediaGalleryScrollIO = sharedPreferences.getInt(KEY_HC_MEDIA_GALLERY_SCROLL_IO, 2);
            hcMediaGalleryScrollThr = sharedPreferences.getBoolean(KEY_HC_MEDIA_GALLERY_SCROLL_THR, false);
            hcMediaGalleryScrollTimeout = sharedPreferences.getInt(KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT, 1500);
            hcMediaGalleryScrollAction = sharedPreferences.getLong(KEY_HC_MEDIA_GALLERY_SCROLL_ACTION, 96);
            hcAlbumScrollEnable = sharedPreferences.getBoolean(KEY_HC_ALBUM_SCROLL_ENABLE, true);
            hcAlbumScrollDelay = sharedPreferences.getInt(KEY_HC_ALBUM_SCROLL_DELEY, 0);
            hcAlbumScrollCPU = sharedPreferences.getInt(KEY_HC_ALBUM_SCROLL_CPU, 3);
            hcAlbumScrollIO = sharedPreferences.getInt(KEY_HC_ALBUM_SCROLL_IO, 2);
            hcAlbumScrollThr = sharedPreferences.getBoolean(KEY_HC_ALBUM_SCROLL_THR, false);
            hcAlbumScrollTimeout = sharedPreferences.getInt(KEY_HC_ALBUM_SCROLL_TIMEOUT, 1500);
            hcAlbumScrollAction = sharedPreferences.getLong(KEY_HC_ALBUM_SCROLL_ACTION, 96);
            x.i(TAG, "reloadSPConfig Boot[%b] EnterChatting[%b] QuitChatting[%b] SendMsg[%b] SendPicMsg[%b] ReceiveMsg[%b] UpdateChatroom[%b] DB[%b] EncodeVideo[%b] DecodePic[%b] Gif[%b] GifFrame[%b] SNS[%b] MediaGallery[%b] Album[%b]", Boolean.valueOf(hcBootEnable), Boolean.valueOf(hcEnterChattingEnable), Boolean.valueOf(hcQuitChattingEnable), Boolean.valueOf(hcSendMsgEnable), Boolean.valueOf(hcSendPicMsgEnable), Boolean.valueOf(hcReceiveMsgEnable), Boolean.valueOf(hcUpdateChatroomEnable), Boolean.valueOf(hcDBEnable), Boolean.valueOf(hcEncodeVideoEnable), Boolean.valueOf(hcDecodePicEnable), Boolean.valueOf(hcGifEnable), Boolean.valueOf(hcGifFrameEnable), Boolean.valueOf(hcSNSScrollEnable), Boolean.valueOf(hcMediaGalleryScrollEnable), Boolean.valueOf(hcAlbumScrollEnable));
            return;
        }
        x.i(TAG, "reloadSPConfig but not mm return stack[%s]", bh.cgy());
    }

    public static boolean isHCEnable() {
        return (checkEnv & hcEnable) != 0 && (!hcSwitchEnable || hcSwitchOn);
    }

    public static int startPerformance(boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, String str) {
        if (!z) {
            return -1;
        }
        if (!hcBgEnable && !foreground) {
            return -2;
        }
        if (sHCPerfManager == null) {
            x.w(TAG, "startPerformance error HCPerfManager is null, check process!");
            return -3;
        }
        a aVar = sHCPerfManager;
        int i7 = hcTimeoutMargin + i5;
        int myTid = Process.myTid();
        a aVar2 = new a();
        aVar2.delay = i;
        aVar2.gKj = i2;
        aVar2.gKk = i3;
        aVar2.gKl = i4;
        aVar2.gKi = i7;
        aVar2.scene = i6;
        aVar2.gKm = j;
        aVar2.gKp = myTid;
        aVar2.gKn = System.currentTimeMillis();
        aVar2.startTime = aVar2.gKn + ((long) i);
        aVar2.gKo = (aVar2.gKn + ((long) i)) + ((long) i7);
        aVar2.tag = str;
        aVar2.lastUpdateTime = aVar2.startTime;
        aVar2.gKC = aVar2.gKn;
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || i7 <= 0 || (i2 == 0 && i3 == 0 && i4 == 0)) {
            x.e("MicroMsg.HardCoder.HCPerfManager", "ErrorParam task:" + aVar2.toString(aVar2.gKn));
        } else {
            boolean offer = aVar.gKg.offer(aVar2);
            if (hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "OutCallAddTask ret:" + offer + " task:" + aVar2.toString(aVar2.gKn));
            }
            if (offer) {
                return aVar2.hashCode();
            }
        }
        return 0;
    }

    public static int stopPerformace(boolean z, int i) {
        if (!z) {
            return -1;
        }
        if (sHCPerfManager == null) {
            x.w(TAG, "stopPerformace error HCPerfManager is null, check process!");
            return -2;
        }
        a aVar = sHCPerfManager;
        b bVar = new b();
        bVar.gKD = System.currentTimeMillis();
        bVar.aen = i;
        boolean offer = i != 0 ? aVar.gKg.offer(bVar) : false;
        if (hcDebug) {
            x.d("MicroMsg.HardCoder.HCPerfManager", String.format("OutCallStopTask ret:%b, hashcode:%x", new Object[]{Boolean.valueOf(offer), Integer.valueOf(i)}));
        }
        return !offer ? -3 : i;
    }

    public static int initHardCoder() {
        if (ac.cfw()) {
            if (sHCPerfManager == null) {
                sHCPerfManager = new a();
                x.i(TAG, "initHardCoder new HCPerfManager[%s]", sHCPerfManager);
            }
            if (isHCEnable()) {
                TICK_RATE = getTickRate();
                setDebug(hcDebug);
                setHCEnable(isHCEnable());
                x.i(TAG, "initHardCoder hcDebug[%b] hcEnable[%b] checkEnv[%b] TICK_RATE[%d]", Boolean.valueOf(hcDebug), Boolean.valueOf(hcEnable), Boolean.valueOf(checkEnv), Integer.valueOf(TICK_RATE));
                return initHardCoder(readServerAddr(false), 0, ac.getPackageName() + clientSock, true);
            }
            x.i(TAG, "initHardCoder isHCEnable false  hcEnable hcSwitchEnable hcSwitchOn checkEnv[%b, %b, %b, %b] ret -2", Boolean.valueOf(hcEnable), Boolean.valueOf(hcSwitchEnable), Boolean.valueOf(hcSwitchOn), Boolean.valueOf(checkEnv));
            return -2;
        }
        x.w(TAG, "initHardCoder error process[%s]  ret -1 stack[%s]", ac.Br(), bh.cgy());
        return -1;
    }

    public static void reportIDKey(boolean z, int i, int i2, boolean z2) {
        if (sHCPerfManager != null) {
            sHCPerfManager.reportIDKey(z, i, i2, z2);
        }
    }

    public static boolean checkHardCoderEnv() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        x.i(TAG, "checkHardCoderEnv manufacture[%s] model[%s] remote[%s]", str, str2, readServerAddr(false));
        if (bh.ov(readServerAddr(false))) {
            return false;
        }
        return true;
    }

    public static void initReporter(a aVar) {
        d.a(aVar);
    }

    public static String readServerAddr(boolean z) {
        int i = 2;
        try {
            String readLine = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop persist.sys.hardcoder.name").getInputStream())).readLine();
            x.i(TAG, "readServerAddr Read prop[%s] result[%s] stack[%s]", serverPropKey, readLine, bh.cgy());
            if (!z || sHCPerfManager == null) {
                return readLine;
            }
            a aVar = sHCPerfManager;
            if (bh.ov(readLine)) {
                i = 1;
            }
            aVar.reportIDKey(true, i, 1, false);
            return readLine;
        } catch (Throwable th) {
            x.printErrStackTrace(TAG, th, "readServerAddr", new Object[0]);
            if (z && sHCPerfManager != null) {
                sHCPerfManager.reportIDKey(true, 3, 1, false);
            }
            return "";
        }
    }

    private static boolean isActiveTime() {
        if (!hcTimeLimit) {
            return true;
        }
        Time time = new Time();
        time.setToNow();
        int i = time.hour;
        int i2 = time.minute;
        int i3 = hcBeginTimeHour;
        int i4 = hcBeginTimeMin;
        int i5 = hcEndTimeHour;
        int i6 = hcEndTimeMin;
        if (i3 == i5 && i4 == i6) {
            return false;
        }
        if (i3 != i5 || i4 >= i6) {
            if (i5 > i3) {
                if (i > i3 && i < i5) {
                    return true;
                }
                if (i == i3 && i2 > i4) {
                    return true;
                }
                if (i != i5 || i2 >= i6) {
                    return false;
                }
                return true;
            } else if (i5 >= i3 && (i3 != i5 || i4 <= i6)) {
                return true;
            } else {
                if (i > i3 && i <= 23) {
                    return true;
                }
                if (i == i3 && i2 > i4) {
                    return true;
                }
                if (i == i5 && i2 < i6) {
                    return true;
                }
                if (i <= 0 || i >= i5) {
                    return false;
                }
                return true;
            }
        } else if (i != i3 || i2 <= i4 || i2 >= i6) {
            return false;
        } else {
            return true;
        }
    }

    public static long[] getMyProcCpuTime() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String[] split = bufferedReader.readLine().split(" ");
                    long[] jArr = new long[]{Long.parseLong(split[13]), Long.parseLong(split[14])};
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        x.e(TAG, "getMyProcCpuTime fileReader close exception:" + e2.getMessage());
                    }
                    try {
                        bufferedReader.close();
                        return jArr;
                    } catch (Exception e22) {
                        x.e(TAG, "getMyProcCpuTime bufferedReader close exception:" + e22.getMessage());
                        return jArr;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e(TAG, "getMyProcCpuTime exception:" + e.getMessage());
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e4) {
                                x.e(TAG, "getMyProcCpuTime fileReader close exception:" + e4.getMessage());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e42) {
                                x.e(TAG, "getMyProcCpuTime bufferedReader close exception:" + e42.getMessage());
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e222) {
                                x.e(TAG, "getMyProcCpuTime fileReader close exception:" + e222.getMessage());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2222) {
                                x.e(TAG, "getMyProcCpuTime bufferedReader close exception:" + e2222.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e42 = e5;
                bufferedReader = null;
                x.e(TAG, "getMyProcCpuTime exception:" + e42.getMessage());
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e42 = e6;
            bufferedReader = null;
            fileReader = null;
            x.e(TAG, "getMyProcCpuTime exception:" + e42.getMessage());
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static long[] getThreadCpuJiffies(int i) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/task/" + i + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                try {
                    x.e(TAG, "getThreadCpuJiffies exception:" + e.getMessage());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                            x.e(TAG, "getThreadCpuJiffies fileReader close exception:" + e3.getMessage());
                        }
                    }
                    if (bufferedReader != null) {
                        return null;
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (Exception e32) {
                        x.e(TAG, "getThreadCpuJiffies bufferedReader close exception:" + e32.getMessage());
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e322) {
                            x.e(TAG, "getThreadCpuJiffies fileReader close exception:" + e322.getMessage());
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3222) {
                            x.e(TAG, "getThreadCpuJiffies bufferedReader close exception:" + e3222.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    try {
                        fileReader.close();
                    } catch (Exception e32222) {
                        x.e(TAG, "getThreadCpuJiffies fileReader close exception:" + e32222.getMessage());
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (Exception e322222) {
                        x.e(TAG, "getThreadCpuJiffies bufferedReader close exception:" + e322222.getMessage());
                        return null;
                    }
                }
                String[] split = readLine.split(" ");
                long[] jArr = new long[]{bh.getLong(split[13], 0), bh.getLong(split[14], 0)};
                try {
                    fileReader.close();
                } catch (Exception e4) {
                    x.e(TAG, "getThreadCpuJiffies fileReader close exception:" + e4.getMessage());
                }
                try {
                    bufferedReader.close();
                } catch (Exception e42) {
                    x.e(TAG, "getThreadCpuJiffies bufferedReader close exception:" + e42.getMessage());
                }
                return jArr;
            } catch (Exception e5) {
                e322222 = e5;
                x.e(TAG, "getThreadCpuJiffies exception:" + e322222.getMessage());
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    return null;
                }
                bufferedReader.close();
                return null;
            }
        } catch (Exception e6) {
            e322222 = e6;
            bufferedReader = null;
            fileReader = null;
            x.e(TAG, "getThreadCpuJiffies exception:" + e322222.getMessage());
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                return null;
            }
            bufferedReader.close();
            return null;
        } catch (Throwable th32) {
            bufferedReader = null;
            fileReader = null;
            th = th32;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static int getThreadCoreId(int i) {
        BufferedReader bufferedReader;
        Exception e;
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        int i2 = -1;
        FileReader fileReader2;
        try {
            fileReader2 = new FileReader("/proc/" + Process.myPid() + "/task/" + i + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader2);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                fileReader = fileReader2;
                try {
                    x.e(TAG, "getThreadCoreId exception:" + e.getMessage());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                            x.e(TAG, "getThreadCoreId fileReader close exception:" + e3.getMessage());
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e32) {
                            x.e(TAG, "getThreadCoreId bufferedReader close exception:" + e32.getMessage());
                        }
                    }
                    return i2;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader2 = fileReader;
                    bufferedReader2 = bufferedReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Exception e322) {
                            x.e(TAG, "getThreadCoreId fileReader close exception:" + e322.getMessage());
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e3222) {
                            x.e(TAG, "getThreadCoreId bufferedReader close exception:" + e3222.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileReader2 != null) {
                    fileReader2.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e32222) {
                        x.e(TAG, "getThreadCoreId fileReader close exception:" + e32222.getMessage());
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e322222) {
                        x.e(TAG, "getThreadCoreId bufferedReader close exception:" + e322222.getMessage());
                    }
                } else {
                    i2 = Integer.parseInt(readLine.split(" ")[38]);
                    try {
                        fileReader2.close();
                    } catch (Exception e3222222) {
                        x.e(TAG, "getThreadCoreId fileReader close exception:" + e3222222.getMessage());
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e32222222) {
                        x.e(TAG, "getThreadCoreId bufferedReader close exception:" + e32222222.getMessage());
                    }
                }
            } catch (Exception e4) {
                e32222222 = e4;
                fileReader = fileReader2;
                x.e(TAG, "getThreadCoreId exception:" + e32222222.getMessage());
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return i2;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = bufferedReader;
                if (fileReader2 != null) {
                    fileReader2.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e32222222 = e5;
            bufferedReader = null;
            x.e(TAG, "getThreadCoreId exception:" + e32222222.getMessage());
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return i2;
        } catch (Throwable th5) {
            th = th5;
            fileReader2 = null;
            if (fileReader2 != null) {
                fileReader2.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        return i2;
    }

    public static long getCpuFreqByCoreId(int i) {
        Exception e;
        Reader reader;
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
            if (!file.exists()) {
                return -1;
            }
            BufferedReader bufferedReader2;
            Reader fileReader2 = new FileReader(file);
            try {
                bufferedReader2 = new BufferedReader(fileReader2);
            } catch (Exception e2) {
                e = e2;
                reader = fileReader2;
                try {
                    x.e(TAG, "getCpuFreqByCoreId exception:" + e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            x.e(TAG, "getCpuFreqByCoreId bufferedReader close exception:" + e3.getMessage());
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e32) {
                            x.e(TAG, "getCpuFreqByCoreId fileReader close exception:" + e32.getMessage());
                        }
                    }
                    return -2;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            x.e(TAG, "getCpuFreqByCoreId bufferedReader close exception:" + e4.getMessage());
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e42) {
                            x.e(TAG, "getCpuFreqByCoreId fileReader close exception:" + e42.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                reader = fileReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
            try {
                long j = bh.getLong(bufferedReader2.readLine(), 0);
                try {
                    bufferedReader2.close();
                } catch (Exception e5) {
                    x.e(TAG, "getCpuFreqByCoreId bufferedReader close exception:" + e5.getMessage());
                }
                try {
                    fileReader2.close();
                    return j;
                } catch (Exception e52) {
                    x.e(TAG, "getCpuFreqByCoreId fileReader close exception:" + e52.getMessage());
                    return j;
                }
            } catch (Exception e6) {
                e32 = e6;
                bufferedReader = bufferedReader2;
                reader = fileReader2;
                x.e(TAG, "getCpuFreqByCoreId exception:" + e32.getMessage());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return -2;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = bufferedReader2;
                reader = fileReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (Exception e7) {
            e32 = e7;
            fileReader = null;
            x.e(TAG, "getCpuFreqByCoreId exception:" + e32.getMessage());
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            return -2;
        } catch (Throwable th5) {
            th = th5;
            fileReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
    }

    public static long[] getCurrCpuFreq() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Reader reader;
        Exception e;
        Reader reader2;
        Throwable th;
        FileReader fileReader;
        FileReader fileReader2;
        try {
            Vector vector = new Vector();
            int i = 0;
            bufferedReader = null;
            fileReader2 = null;
            while (i < 32) {
                try {
                    File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
                    if (file.exists()) {
                        Reader fileReader3 = new FileReader(file);
                        try {
                            bufferedReader2 = new BufferedReader(fileReader3);
                            try {
                                vector.add(Long.valueOf(bh.getLong(bufferedReader2.readLine(), 0)));
                                i++;
                                reader = fileReader3;
                                bufferedReader = bufferedReader2;
                            } catch (Exception e2) {
                                e = e2;
                                reader2 = fileReader3;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                reader = fileReader3;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader2 = bufferedReader;
                            reader2 = fileReader3;
                        } catch (Throwable th3) {
                            th = th3;
                            reader = fileReader3;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader2 = bufferedReader;
                    fileReader = fileReader2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            if (vector.size() <= 0) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        x.e(TAG, "getCurrCpuFreq bufferedReader close exception:" + e5.getMessage());
                    }
                }
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e52) {
                        x.e(TAG, "getCurrCpuFreq fileReader close exception:" + e52.getMessage());
                    }
                }
                return null;
            }
            long[] jArr = new long[vector.size()];
            for (int i2 = 0; i2 < vector.size(); i2++) {
                jArr[i2] = ((Long) vector.get(i2)).longValue();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e522) {
                    x.e(TAG, "getCurrCpuFreq bufferedReader close exception:" + e522.getMessage());
                }
            }
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Exception e5222) {
                    x.e(TAG, "getCurrCpuFreq fileReader close exception:" + e5222.getMessage());
                }
            }
            return jArr;
        } catch (Exception e6) {
            e5222 = e6;
            bufferedReader2 = null;
            fileReader = null;
            try {
                x.e(TAG, "getCurrCpuFreq exception:" + e5222.getMessage());
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e52222) {
                        x.e(TAG, "getCurrCpuFreq bufferedReader close exception:" + e52222.getMessage());
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e522222) {
                        x.e(TAG, "getCurrCpuFreq fileReader close exception:" + e522222.getMessage());
                    }
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileReader2 = fileReader;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e7) {
                        x.e(TAG, "getCurrCpuFreq bufferedReader close exception:" + e7.getMessage());
                    }
                }
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e72) {
                        x.e(TAG, "getCurrCpuFreq fileReader close exception:" + e72.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            fileReader2 = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader2 != null) {
                fileReader2.close();
            }
            throw th;
        }
    }
}
