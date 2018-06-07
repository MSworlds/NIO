package com.meng.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {
    /**
     * Buffer  缓冲区 负责数据存储
     * 缓冲区底层   是数组
     * 用于存储不同数据类型数据
     * 根据数据类型不同   提供相应类型缓冲区
     * ByteBuffer
     * CharBuffer
     * ShortBuffer
     * IntBuffer
     * LongBuffer
     * FloatBuffer
     * DoubleBuffer
     * 均可通过allocate()获取缓冲区
     *get();获取
     * put();储存
     *     private int mark = -1;
     *     private int position = 0;   位置正在操作数据的位置
     *     private int limit;  界限 表示缓冲区可以操作数据的大小（ limit  后数据不能进行读写
     *     private int capacity;缓冲区最大存储数据容量 一旦声明 不能改变
     *
     */
@Test
    public void tets1(){
        //1.分配一个指定大小缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);
        //
        System.out.println(buf.capacity());
        System.out.println(buf.limit());
        System.out.println(buf.position());
        //2存数据
    String str="123";
    buf.put(str.getBytes());
    System.out.println(buf.capacity());
    System.out.println(buf.limit());
    System.out.println(buf.position());


    buf.flip();
    System.out.println(buf.capacity());
    System.out.println(buf.limit());
    System.out.println(buf.position());
    byte b=buf.get(0);
    System.out.println((char)b);

    }


}
