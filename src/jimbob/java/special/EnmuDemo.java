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

// ö�٣�ʹ��enum�ؼ����൱�ڼ̳���Enum������
// ��ʱ��֮ǰ�Ķ���ģʽһ��
enum Color {
	RED("��ɫ"), BLUE("��ɫ"), GREEN("��ɫ");
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
	RED("��ɫ") {
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "�Լ���" + this;
		}
	},
	GREEN("��ɫ") {
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "�Լ���" + this;
		}
	},
	BLUE("��ɫ") {
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "�Լ���" + this;
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
