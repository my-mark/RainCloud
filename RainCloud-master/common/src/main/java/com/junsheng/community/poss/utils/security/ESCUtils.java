package com.junsheng.community.poss.utils.security;

import com.junsheng.community.poss.domain.HeaderEnum;
import com.junsheng.community.poss.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Created by wangshuai on 2017/5/30.
 */
public class ESCUtils {

    private static Logger logger = LoggerFactory.getLogger(ESCUtils.class);
    /**
     * 3DES加密
     *
     * @param key
     * @param data
     * @return
     */
    public static String desEncrypt(String key, String data)  {
        try {
            String keyAlgorithm = "DESede";//定义加密算法,可用 DES,DESede,Blowfish
            String cipherAlgorithm = "DESede/ECB/PKCS5Padding";
            //生成密钥
            SecretKey desKey = new SecretKeySpec(build3DesKey(key), keyAlgorithm);
            //加密
            Cipher c1 = Cipher.getInstance(cipherAlgorithm);//实例化负责加密/解密的Cipher工具类
            c1.init(Cipher.ENCRYPT_MODE, desKey);//初始化为加密模式
            byte[] desData = c1.doFinal(data.getBytes());//在单一方面的加密或解密
//            return new String(Base64.getEncoder().encode(desData));
            return EncoderUtils.encodeHex(desData);
        } catch (java.security.NoSuchAlgorithmException e) {
            logger.error(e.getMessage() ,e);
            throw new ServiceException(HeaderEnum.SYS_MSG);
        } catch (javax.crypto.NoSuchPaddingException e) {
            logger.error(e.getMessage() ,e);
            throw new ServiceException(HeaderEnum.SYS_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage() ,e);
            throw new ServiceException(HeaderEnum.SYS_MSG);
        }
    }

    /**
     * 3DES解密
     *
     * @param key
     * @param data
     * @return
     */
    public static String desDecrypt(String key, String data) {
        try {

            byte[] bytes = EncoderUtils.decodeHex(data);

            String keyAlgorithm = "DESede";//定义加密算法,可用 DES,DESede,Blowfish
            String cipherAlgorithm = "DESede/ECB/PKCS5Padding";
            //生成密钥
            SecretKey desKey = new SecretKeySpec(build3DesKey(key), keyAlgorithm);
            //加密
            Cipher c1 = Cipher.getInstance(cipherAlgorithm);//实例化负责加密/解密的Cipher工具类
            c1.init(Cipher.DECRYPT_MODE, desKey);//初始化为加密模式
//            byte[] dataBytes = Base64.getDecoder().decode(bytes);
            byte[] desData = c1.doFinal(bytes);//在单一方面的加密或解密
            return new String(desData);
        } catch (java.security.NoSuchAlgorithmException e) {
            logger.error(e.getMessage() ,e);
            throw new ServiceException(HeaderEnum.SYS_MSG);
        } catch (javax.crypto.NoSuchPaddingException e) {
            logger.error(e.getMessage() ,e);
            throw new ServiceException(HeaderEnum.SYS_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage() ,e);
            throw new ServiceException(HeaderEnum.SYS_MSG);
        }
    }

    /*
     * 根据字符串生成密钥字节数组
     * @param keyStr 密钥字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes("UTF-8");
        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }
    
    
    public static void main(String[] args) {
    	System.out.println(desDecrypt("wowoohr","46a5fecf57205bbf"));
    	System.out.println(desEncrypt("wowoohr","2"));
	}
}
