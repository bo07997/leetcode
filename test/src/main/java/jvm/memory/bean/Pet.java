package jvm.memory.bean;

import java.util.List;

/**
 * @author ldb
 * @Package jvm.memory.bean
 * @date 2020/12/13 16:53
 */
public class Pet {
	int id;
	List<Integer> buff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getBuff() {
		return buff;
	}

	public void setBuff(List<Integer> buff) {
		this.buff = buff;
	}

	public Pet(int id, List<Integer> buff) {
		this.id = id;
		this.buff = buff;
	}
}
