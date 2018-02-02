package org.xwalk.core.extension;

final class XWalkExternalExtensionBridgeFactory {
    XWalkExternalExtensionBridgeFactory() {
    }

    public static XWalkExternalExtensionBridge createInstance(XWalkExternalExtension xWalkExternalExtension) {
        return new XWalkCoreExtensionBridge(xWalkExternalExtension);
    }
}
