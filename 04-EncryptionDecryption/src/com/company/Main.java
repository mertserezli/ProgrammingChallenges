package com.company;

public class Main {

    public static void main(String[] args) {
        try {
             byte[] cipher = EncryptDecrypt.encrypt("My secret text");
             System.out.println(cipher);
             String plain = EncryptDecrypt.decrypt(cipher);
             System.out.println(plain);
             assert "My secret Text".equals(plain);
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }
}
