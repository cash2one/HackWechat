package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import java.util.ArrayList;
import java.util.List;

public class ConstantsRecovery {

    public static final class DefaultCommonOptions {
        public static final CommonOptions zQW;

        static {
            Builder builder = new Builder();
            builder.ned = "";
            builder.clientVersion = "";
            builder.zRz = "";
            builder.zRD = "";
            builder.zRE = "";
            zQW = builder.cDm();
        }
    }

    public static final class DefaultExpress {
        public static final Express zQX = new Express();
        public static final Express zQY = new Express();
        public static final Express zQZ = new Express();

        static {
            List arrayList = new ArrayList();
            arrayList.add(new ExpressItem(17, 1114112));
            zQX.dF(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1118208));
            zQY.dF(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1114112));
            zQZ.dF(arrayList);
        }
    }

    public static final class DefaultProcessOptions {
        public static final ProcessOptions zRa;
        public static final ProcessOptions zRb;
        public static final ProcessOptions zRc;

        static {
            ProcessOptions.Builder builder = new ProcessOptions.Builder();
            builder.zRJ = DefaultExpress.zQX;
            builder.cDn();
            zRa = builder.cDo();
            builder = new ProcessOptions.Builder();
            builder.zRJ = DefaultExpress.zQY;
            builder.cDn();
            zRb = builder.cDo();
            builder = new ProcessOptions.Builder();
            builder.zRJ = DefaultExpress.zQZ;
            builder.cDn();
            zRc = builder.cDo();
        }
    }

    public static final class IntentAction {
    }

    public static final class IntentKeys {
    }

    public static final class Message {
    }

    public static final class ProcessStage {
    }

    public static final class ProcessStartFlag {
    }

    public static final class ProcessStatus {
    }

    public static final class ReportType {
    }

    public static final class SpKeys {
    }
}
