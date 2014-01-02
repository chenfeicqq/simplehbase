package com.alipay.simplehbase.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * QueryExtInfo
 * 
 * <pre>
 * Extra info when do query.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public class QueryExtInfo {

    private boolean isMaxVersionSet;
    private int     maxVersions;

    private boolean isTimeRangeSet;
    private long    minStamp;
    private long    maxStamp;

    private boolean isLimitSet;
    private long    startIndex;
    private long    length;

    public QueryExtInfo() {
    }

    public void setMaxVersions(int maxVersions) {
        if (maxVersions < 1) {
            throw new SimpleHBaseException(
                    "maxVersions is smaller than 1. maxVersions=" + maxVersions);
        }
        this.maxVersions = maxVersions;
        this.isMaxVersionSet = true;
    }

    public void setTimeRange(long minStamp, long maxStamp) {
        if (maxStamp < minStamp) {
            throw new SimpleHBaseException(
                    "maxStamp is smaller than minStamp. minStamp=" + minStamp
                            + " maxStamp=" + maxStamp);
        }
        this.minStamp = minStamp;
        this.maxStamp = maxStamp;
        this.isTimeRangeSet = true;
    }

    public void setLimit(long startIndex, long length) {
        if (startIndex < 0) {
            throw new SimpleHBaseException("startIndex is invalid. startIndex="
                    + startIndex);
        }
        if (length < 1) {
            throw new SimpleHBaseException("length is invalid. length="
                    + length);
        }
        this.startIndex = startIndex;
        this.length = length;
        this.isLimitSet = true;
    }

    public boolean isLimitSet() {
        return isLimitSet;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public long getLength() {
        return length;
    }

    public boolean isMaxVersionSet() {
        return isMaxVersionSet;
    }

    public int getMaxVersions() {
        return maxVersions;
    }

    public boolean isTimeRangeSet() {
        return isTimeRangeSet;
    }

    public long getMinStamp() {
        return minStamp;
    }

    public long getMaxStamp() {
        return maxStamp;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}