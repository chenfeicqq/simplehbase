package com.alipay.simplehbase.client.service.basicService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOWithKeyResult;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestFindObjectAndKey extends MyRecordTestBase {

    @Test
    public void findObjectAndKey() {

        MyRecord myRecord = mockSlim(0);
        RowKey rowKey = myRecord.rowKey();

        simpleHbaseClient.putObject(rowKey, myRecord);
        SimpleHbaseDOWithKeyResult<MyRecord> resultRecord = simpleHbaseClient
                .findObjectAndKey(rowKey, MyRecord.class);

        Assert.assertTrue(myRecord.equals(resultRecord.getT()));
        Assert.assertEquals(new BytesRowKey(rowKey.toBytes()),
                resultRecord.getRowKey());
    }
}
