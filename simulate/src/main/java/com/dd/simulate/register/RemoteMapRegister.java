package com.dd.simulate.register;

import com.dd.simulate.framework.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将url地址写入本地文件（替换独立于系统之外的中间件，例如：zk、redis）
 * @author Bryce_dd 2021/11/29 23:18
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {

        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(url);

        REGISTER.put(interfaceName, list);

        saveFile();

    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile();
        return REGISTER.get(interfaceName);
    }

    private static Map<String,List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./registerTemp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./registerTemp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
