package com.tima.admin.util;

import com.tima.admin.dto.PointDTO;

/**
 * Created by yijs on 2017/02/17.
 */
public class IntersectionUtil {

    /**
     * 用于判断两条线段是否有交点
     * @return
     */

    public final static boolean toIntersection(PointDTO p1, PointDTO p2, PointDTO p3, PointDTO p4){
        if(new Segments_Intersect(p1, p2, p3, p4).Segment_Intersect()){
            return true;
        }else{
            return false;
        }
    }

}
