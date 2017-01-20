package memcached;

import java.util.Date;  

import com.danga.MemCached.MemCachedClient;  

public class MemcacheManager {
	public static final String COMMON_CONFIG_MAP_KEY="common_config_map";
	 //获取Client方法  
    public static MemCachedClient getClient(){  
        return Memcache.getInstance().getClient();  
    }  
      
    /*public static Object get(String key){  
        return getClient().get(key);  
    }  */
    @SuppressWarnings("unchecked")
	public static <T>  T get(String key) {
    	return (T)getClient().get(key); 
    }
    public static boolean set(String key, Object value){  
        return getClient().set(key, value);  
    }  
      
    public static boolean set(String key, Object value, long time){  
         return getClient().set(key, value, new Date(time));  
    }  
      
    public static boolean delete(String key){  
        return getClient().delete(key);  
    }  
}
