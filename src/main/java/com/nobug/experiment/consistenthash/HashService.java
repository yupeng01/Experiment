package com.nobug.experiment.consistenthash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description MurMurHash算法
 * @createTime 2021年 07月 28日 11:13:00
 */
public class HashService implements IHashService {

    @Override
    public long hash(String key) {
        return hash64A(ByteBuffer.wrap(key.getBytes()));
    }
    public static long hash64A(ByteBuffer buf) {
        int seed = 0x1234ABCD;
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }

}

