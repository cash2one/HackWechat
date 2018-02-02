package com.tencent.ugc;

public class TXRecordCommon {
    public static final int EVT_CAMERA_CANNOT_USE = 3;
    public static final String EVT_DESCRIPTION = "EVT_DESCRIPTION";
    public static final int EVT_ID_PAUSE = 1;
    public static final int EVT_ID_RESUME = 2;
    public static final int EVT_MIC_CANNOT_USE = 4;
    public static final String EVT_PARAM1 = "EVT_PARAM1";
    public static final String EVT_PARAM2 = "EVT_PARAM2";
    public static final String EVT_TIME = "EVT_TIME";
    public static final int RECORD_RESULT_FAILED = -1;
    public static final int RECORD_RESULT_OK = 0;
    public static final int RECORD_RESULT_OK_LESS_THAN_MINDURATION = 1;
    public static final int RECORD_RESULT_OK_REACHED_MAXDURATION = 2;
    public static final int RECORD_SPEED_FAST = 3;
    public static final int RECORD_SPEED_FASTEST = 4;
    public static final int RECORD_SPEED_NORMAL = 2;
    public static final int RECORD_SPEED_SLOW = 1;
    public static final int RECORD_SPEED_SLOWEST = 0;
    public static final int RECORD_TYPE_STREAM_SOURCE = 1;
    public static final int START_RECORD_ERR_API_IS_LOWER_THAN_18 = -3;
    public static final int START_RECORD_ERR_IS_IN_RECORDING = -1;
    public static final int START_RECORD_ERR_NOT_INIT = -4;
    public static final int START_RECORD_ERR_VIDEO_PATH_IS_EMPTY = -2;
    public static final int START_RECORD_OK = 0;
    public static final int VIDEO_ASPECT_RATIO_1_1 = 2;
    public static final int VIDEO_ASPECT_RATIO_3_4 = 1;
    public static final int VIDEO_ASPECT_RATIO_9_16 = 0;
    public static final int VIDEO_QUALITY_HIGH = 2;
    public static final int VIDEO_QUALITY_LOW = 0;
    public static final int VIDEO_QUALITY_MEDIUM = 1;
    public static final int VIDEO_RESOLUTION_360_640 = 0;
    public static final int VIDEO_RESOLUTION_540_960 = 1;
    public static final int VIDEO_RESOLUTION_720_1280 = 2;

    public interface ITXBGMNotify {
        void onBGMComplete(int i);

        void onBGMProgress(long j, long j2);

        void onBGMStart();
    }
}
