package org.jeecg.modules.system.util;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;


public class SecurityUtil {
    
    private static String key = "JEECGBOOT1423670";


    
    public static String jiami(String content) {
            SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
            String encryptResultStr = aes.encryptHex(content);
            return encryptResultStr;
    }

    
    public static String jiemi(String encryptResultStr){
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());

        String decryptResult = aes.decryptStr(encryptResultStr, CharsetUtil.CHARSET_UTF_8);
        return  decryptResult;
    }

    
    public static void main(String[] args) {
        String content="test1111";
        String encrypt = jiami(content);
        System.out.println(encrypt);

        String decrypt = jiemi(encrypt);

        System.out.println(decrypt);
    }
}
