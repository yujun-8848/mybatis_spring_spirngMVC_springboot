package com.mybatis.SqlSession;

public interface SqlSession {


    <T> T getMapper(Class<T> interfaceClass);

    void close();

}
