package memcached;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.linan.truck.pojo.CommConfig;

public class MemcachedTest {

	public static void main(String[] args) {

		/*String k = "test";  
        String v = "testMemCached";  
          
        System.out.println("-------------------MemCached set begin--------------");  
        MemcacheManager.set(k, v);  
        System.out.println("setValue:" + v);  
        System.out.println("-------------------MemCached set end--------------");  
          
        System.out.println("-------------------MemCached get begin--------------");  
        String r = (String)MemcacheManager.get(k);  
        System.out.println("getValue:" + r);  
        System.out.println("-------------------MemCached get end--------------");  */
        
        Map<Integer,CommConfig> map = MemcacheManager.get(MemcacheManager.COMMON_CONFIG_MAP_KEY);
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
			CommConfig commConfig = map.get(integer);
			System.out.println("名称:"+commConfig.getConfigNameZh()+"\t值:"+commConfig.getConfigValue()+";"+"字符值"+commConfig.getConfigValueStr());
		}
	}
	@Test
	public void test(){
		try {
			Class.forName("memcached.Memcache");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
