package com.tencent.mm.modelrecovery;

import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;
import java.util.ArrayList;

public class RecoveryTinkerResultService extends AbstractResultService {
    public void onCreate() {
        super.onCreate();
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public final void a(a aVar) {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", new Object[]{aVar});
        CommonOptions gi = OptionFactory.gi(this);
        ArrayList arrayList = new ArrayList();
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.ned = gi.ned;
        recoveryHandleItem.clientVersion = gi.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.aAM = "KeyPatchResultTotalCount";
        if (aVar.fsH) {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            recoveryHandleItem.aAM = "KeyPatchResultSuccessCount";
        } else {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
            if (aVar.zRu != null) {
                RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", new Object[]{aVar.zRu.getMessage()});
                recoveryHandleItem.aAM = String.format("%s[%s]", new Object[]{"KeyPatchResultFailCount", aVar.zRu.getMessage()});
            } else {
                recoveryHandleItem.aAM = "KeyPatchResultFailCount";
            }
        }
        arrayList.add(recoveryHandleItem);
        RecoveryLogic.a(this, arrayList, WXRecoveryUploadService.class.getName());
        stopSelf();
    }
}
