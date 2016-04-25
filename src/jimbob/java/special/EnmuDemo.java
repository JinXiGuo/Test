package jimbob.java.special;

public class EnmuDemo {
	public static void main(String[] args) {
		for (Color color : Color.values()) {
			System.out.println(color);
		}
		Color2 red = Color2.RED;
		System.out.println(red.getTitle());
	}
}

// 枚举，使用enum关键字相当于继承了Enum抽象类
// 此时和之前的多例模式一样
enum Color {
	RED("红色"), BLUE("蓝色"), GREEN("绿色");
	private String title;

	private Color(String title) {
		this.title = title;
	}

	public String toString() {
		return this.title;
	}
}

interface Message2 {
	String getTitle();
}

enum Color2 implements Message2 {
	RED("红色") {
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "自己的" + this;
		}
	},
	GREEN("绿色") {
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "自己的" + this;
		}
	},
	BLUE("蓝色") {
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "自己的" + this;
		}
	};
	private String title;

	private Color2(String title) {
		this.title = title;
	}

	public String toString() {
		return this.title;
	}
}
