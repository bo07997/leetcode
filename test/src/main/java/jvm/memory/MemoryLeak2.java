package jvm.memory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import jvm.memory.bean.Pet;

import java.util.Arrays;

/**
 * @author ldb
 * @Package jvm.memory
 * @date 2020/12/13 16:52
 */
public class MemoryLeak2 {
	public static void main(String[] args) {
		while (true) {
			SerializeConfig CONFIG = new SerializeConfig();
			CONFIG.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
			String jsonString = JSON.toJSONString(new Pet(1, Arrays.asList(1, 2, 3)), CONFIG);
			System.out.println(jsonString);
		}
	}
}
