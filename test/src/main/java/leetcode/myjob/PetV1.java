package leetcode.myjob;

import java.math.BigInteger;

/**
 * @author ldb
 * @Package leetcode.myjob
 * @date 2020/12/2 19:35
 * 可消除的pet
 */
public class PetV1 {
	final int id;
	final int nextPetV1Id;
	BigInteger test;

	public PetV1(int id, int nextPetV1Id) {
		this.id = id;
		this.nextPetV1Id = nextPetV1Id;
	}

	public PetV1(int id, int nextPetV1Id, BigInteger test) {
		this.id = id;
		this.nextPetV1Id = nextPetV1Id;
		this.test = test;
	}

	public void setTest(BigInteger test) {
		this.test = test;
	}
}
