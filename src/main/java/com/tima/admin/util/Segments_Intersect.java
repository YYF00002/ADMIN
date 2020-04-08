package com.tima.admin.util;

import com.tima.admin.dto.PointDTO;

public class Segments_Intersect {
    private PointDTO p1;
    private PointDTO p2;
    private PointDTO p3;
    private PointDTO p4;
    public Segments_Intersect(PointDTO p1, PointDTO p2, PointDTO p3, PointDTO p4) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    public double det(PointDTO pi, PointDTO pj) { // 叉积
        return pi.getLatitude() * pj.getLongitude() - pj.getLatitude() * pi.getLongitude();
    }
    public PointDTO PiPj(PointDTO pi, PointDTO pj) { // 構造向量
        PointDTO p = new PointDTO();
        p.setLatitude(pj.getLatitude() - pi.getLatitude());
        p.setLongitude(pj.getLongitude() - pi.getLongitude());
        return p;
    }
    public double Direction(PointDTO pi, PointDTO pj, PointDTO pk) { // 大於零表示順時針，即右轉，小於零表示逆時針，即左轉，等於零，表示共綫。
        return det(PiPj(pk, pi), PiPj(pj, pi));
    }
    public boolean On_Segment(PointDTO pi, PointDTO pj, PointDTO pk) {
        double max_x = (pi.getLatitude() - pj.getLatitude()) > 0 ? pi.getLatitude() : pj.getLatitude();
        double min_x = (pi.getLatitude() - pj.getLatitude()) < 0 ? pi.getLatitude() : pj.getLatitude();
        double max_y = (pi.getLongitude() - pj.getLongitude()) > 0 ? pi.getLongitude() : pj.getLongitude();
        double min_y = (pi.getLongitude() - pj.getLongitude()) < 0 ? pi.getLongitude() : pj.getLongitude();
        if ((min_x <= pk.getLatitude()) && (pk.getLatitude() <= max_x)
                && (min_y <= pk.getLongitude()) && (pk.getLongitude() <= max_y))
            return true;
        else
            return false;
    }
    public boolean Segment_Intersect() {
        double d1 = Direction(this.p3, this.p4, this.p1);
        double d2 = Direction(p3, p4, p2);
        double d3 = Direction(p1, p2, p3);
        double d4 = Direction(p1, p2, p4);
        if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0))
                && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0)))
            return true;
        else if (d1 == 0 && On_Segment(p3, p4, p1))
            return true;
        else if (d2 == 0 && On_Segment(p3, p4, p2))
            return true;
        else if (d3 == 0 && On_Segment(p1, p2, p3))
            return true;
        else if (d4 == 0 && On_Segment(p1, p2, p4))
            return true;
        else
            return false;
    }
}


