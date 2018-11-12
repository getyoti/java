package com.yoti.api.client.qrcode.policy;

import java.util.List;

public final class SimpleAttributeFactory implements AttributeFactory {

    @Override
    public WantedAttribute create(String name, List<String> anchors, String derivation, boolean optional) {
        return new SimpleWantedAttribute(name, anchors, derivation, optional);
    }

}
