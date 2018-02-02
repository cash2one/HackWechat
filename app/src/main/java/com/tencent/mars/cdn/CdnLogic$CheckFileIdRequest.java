package com.tencent.mars.cdn;

import com.tencent.mars.cdn.CdnLogic.CheckFileidItem;

public class CdnLogic$CheckFileIdRequest {
    public CheckFileidItem[] fileItems = null;
    public String fileKey = "";
    public int queueTimeoutSeconds = 1800;
    public String toUser = "";
    public int transforTimeoutSeconds = 600;
}
