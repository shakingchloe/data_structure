package com.changing.huffmancode;

import javax.xml.crypto.NodeSetData;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.*;

/**
 * @author changing
 * @create 2021-08-27 15:37
 */
public class huffmanCode {
    public static void main(String[] args) {

//        String srcFile = "d://shaking.jpg";
//        String dstFile = "d://Shaking04.zip";
//        zipFile(srcFile,dstFile);

        String zipFile = "d://Shaking04.zip";
        String dstFile = "d://shaking0104.jpg";
        unZipFile(zipFile,dstFile);

//        String content = "i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
//        System.out.println(contentBytes);
//        System.out.println(contentBytes.length);

//        List<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);
//
//        Node huffmanTreeRoot = createHuffmanTree(nodes);
//
//        preOrder(huffmanTreeRoot);
//
//        //是否生成了相应的赫夫曼编码
//        getCodes(huffmanTreeRoot,"",stringBuilder);
//        System.out.println("生成的赫夫曼数为" + huffmanCodes);
//
//        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//        System.out.println(Arrays.toString(huffmanCodeBytes));
//
//        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
//        System.out.println(new String(sourceBytes));

    }


//    private static String byteToBitString(byte b){
//        int temp = b;
//
//        String str = Integer.toBinaryString(temp);
//
//
//    }

    public static void unZipFile(String zipFile,String dstFile){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(zipFile);
            ois = new ObjectInputStream(fis);

            byte[] huffmanBytes = (byte[]) ois.readObject();

            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();

            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            fos = new FileOutputStream(dstFile);

            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 压缩文件
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(String srcFile,String dstFile){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(srcFile);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            byte[] huffmanBytes = huffmanZip(b);
            fos = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 压缩
     * @param
     * @return
     */

    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0;i < huffmanBytes.length;i++){
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag,huffmanBytes[i]));
        }

        System.out.println("赫夫曼字节数组对应的二进制字符串=" + stringBuilder.toString());

        Map<String, Byte> map = new HashMap<>();

        for(Map.Entry<Byte,String>entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for(int i = 0;i < stringBuilder.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag){
                String key = stringBuilder.substring(i,i + count);
                b = map.get(key);
                if(b == null){
                    count++;
                }else{
                    flag =false;
                }
            }

            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for(int i = 0;i < b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }

    public static String byteToBitString(boolean flag,byte b){
        int temp = b;

        if(flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length() - 8);
        }else {
            return str;
        }

    }

    //使用一个方法，将前面的方法封装起来，便于我们调用
    public static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);

        Node huffmanTreeRoot = createHuffmanTree(nodes);

        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot, "", stringBuilder);


        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;

    }

    public static byte[] zip(byte[] bytes,Map<Byte,String>huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : bytes){
            //System.out.println(b);
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder);

        int len;
        if(stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }

        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for(int i = 0;i < stringBuilder.length();i += 8){
            String strByte;
            if(i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i,i + 8);
            }
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }

    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();

    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte,String> getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left,"0",stringBuilder2);

                getCodes(node.right,"1",stringBuilder2);
            }else{
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
        return huffmanCodes;
    }


    //前序遍历赫夫曼数
    private static void preOrder(Node node){
        if(node != null){
            System.out.println(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static List<Node> getNodes(byte[] bytes){

        ArrayList<Node> nodes = new ArrayList<>();

        Map<Byte,Integer> counts = new HashMap<>();
        for(byte b : bytes){
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count + 1);
            }
        }

        for(Map.Entry<Byte,Integer> entry: counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    //创建赫夫曼数
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null,left.weight + right.weight);

            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);;

            nodes.add(parent);

        }

        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data,int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
