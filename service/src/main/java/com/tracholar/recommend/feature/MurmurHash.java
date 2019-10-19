package com.tracholar.recommend.feature;


public class MurmurHash {
    private static MurmurHash _instance = new MurmurHash();

    public MurmurHash() {
    }

    public static MurmurHash getInstance() {
        return _instance;
    }

    public long hash(String data){
        return Math.abs(hash(data.getBytes(), 10, 2019));
    }

    public int hash(byte[] data, int length, int seed) {
        return this.hash(data, 0, length, seed);
    }

    public int hash(byte[] data, int offset, int length, int seed) {
        int m = 1540483477;
        int r = 24;
        int h = seed ^ length;
        int len_4 = length >> 2;

        int len_m;
        int left;
        for(len_m = 0; len_m < len_4; ++len_m) {
            left = offset + (len_m << 2);
            int k = data[left + 3];
            k = k << 8;
            k |= data[left + 2] & 255;
            k <<= 8;
            k |= data[left + 1] & 255;
            k <<= 8;
            k |= data[left + 0] & 255;
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }

        len_m = len_4 << 2;
        left = length - len_m;
        if (left != 0) {
            length += offset;
            if (left >= 3) {
                h ^= data[length - 3] << 16;
            }

            if (left >= 2) {
                h ^= data[length - 2] << 8;
            }

            if (left >= 1) {
                h ^= data[length - 1];
            }

            h *= m;
        }

        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;
        return h;
    }
}