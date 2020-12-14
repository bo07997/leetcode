package jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb
 * @Package jvm.memory
 * @date 2020/12/13 14:51
 */
public class MemoryLeak {
	static class OOMObject {

	}

	public static void main(String[] args) {
		List<OOMObject> test = new ArrayList<>();
		while (true) {
			test.add(new OOMObject());
		}

	}
}
