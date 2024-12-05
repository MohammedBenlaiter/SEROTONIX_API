package com.example.demo.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericMapper {
    public static <S, T> T map(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();

            Field[] sourceFields = source.getClass().getDeclaredFields();
            Field[] targetFields = targetClass.getDeclaredFields();

            for (Field sourcField : sourceFields) {
                sourcField.setAccessible(true); // to access private fields
                Object value = sourcField.get(source);

                for (Field targetField : targetFields) {
                    if (sourcField.getName().equals(targetField.getName())
                            && sourcField.getType().equals(targetField.getType())) {
                        targetField.setAccessible(true);
                        targetField.set(target, value);
                        break;
                    }
                }
            }
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Mapping failed" + e.getMessage(), e);
        }
    }

    public static <S, T> List<T> mapCollection(List<S> sourceList, Class<T> targetClass) {
        List<T> targetL = new ArrayList<>();
        for (S source : sourceList) {
            targetL.add(map(source, targetClass));
        }
        return targetL;
    }
}
