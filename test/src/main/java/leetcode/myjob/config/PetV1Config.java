package leetcode.myjob.config;

import leetcode.myjob.PetV1;
import leetcode.myjob.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ldb
 * @Package leetcode.myjob.config
 * @date 2020/12/2 19:42
 */
public class PetV1Config {
	/**
	 * 可消除精灵列表
	 */
	private static final Map<Integer, PetV1> ID_PET = new HashMap<>();
	/**
	 * 生成池
	 */
	private static final List<PetV1> GENERATE_PET_POOL = new ArrayList<>();

	static {
		ID_PET.put(1, new PetV1(1, 2));
		ID_PET.put(2, new PetV1(2, 3));
		ID_PET.put(3, new PetV1(3, -1));
		ID_PET.put(4, new PetV1(4, 5));
		ID_PET.put(5, new PetV1(5, 6));
		ID_PET.put(6, new PetV1(6, -1));
		ID_PET.put(7, new PetV1(7, 8));
		ID_PET.put(8, new PetV1(8, 9));
		ID_PET.put(9, new PetV1(9, -1));
		GENERATE_PET_POOL.add(ID_PET.get(1));
		GENERATE_PET_POOL.add(ID_PET.get(4));
		GENERATE_PET_POOL.add(ID_PET.get(7));
	}

	public static PetV1 getPetById(int id) {
		return ID_PET.get(id);
	}

	public static PetV1 randomPet() {
		return GENERATE_PET_POOL.get(RandomUtil.avgRandom(0, GENERATE_PET_POOL.size() - 1));
//		return GENERATE_PET_POOL.get(2);
	}
}
