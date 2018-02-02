package com.tencent.tmassistantsdk.logreport;

import com.tencent.tmassistantsdk.protocol.jce.UpdateInfoLog;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.UpdateInfoLogTable;
import com.tencent.tmassistantsdk.util.TMLog;

public class UpdateInfoReportManager extends BaseReportManager {
    protected static final String TAG = "UpdateInfoReportManager";
    protected static UpdateInfoReportManager mInstance = null;

    private UpdateInfoReportManager() {
    }

    public static synchronized UpdateInfoReportManager getInstance() {
        UpdateInfoReportManager updateInfoReportManager;
        synchronized (UpdateInfoReportManager.class) {
            if (mInstance == null) {
                mInstance = new UpdateInfoReportManager();
            }
            updateInfoReportManager = mInstance;
        }
        return updateInfoReportManager;
    }

    public UpdateInfoLog createUpdateInfoLog(String str, long j) {
        TMLog.i(TAG, "createUpdateInfoLog");
        UpdateInfoLog updateInfoLog = new UpdateInfoLog();
        updateInfoLog.packageName = str;
        updateInfoLog.appid = j;
        return updateInfoLog;
    }

    protected BaseLogTable getLogTable() {
        return UpdateInfoLogTable.getInstance();
    }

    protected byte getReportType() {
        return (byte) 2;
    }
}
