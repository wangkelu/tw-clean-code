package com.zuehlke.cleancodeworkshop.smellyshapes;

public interface Shape {

    boolean containsPoint(int x, int y);

    String toXml();
}
