package jimbob.java.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/* 
 *接受端，也就是服务器端。一直在监听端口。 
 */
class SocketUDPRecv {
	public static void main(String[] args) {
		recv();
	}

	public static void recv() {
		try {
			DatagramSocket ds = new DatagramSocket(8600);
			byte[] buf = new byte[100];
			DatagramPacket dp = new DatagramPacket(buf, 100);
			ds.receive(dp);
			System.out.println(new String(buf, 0, dp.getLength()));

			// 演示给发送端返回数据,需要发送端去接受
			String str = "Yes , I received!";
			DatagramPacket dp1 = new DatagramPacket(str.getBytes(),
					str.length(), dp.getAddress(), dp.getPort());
			ds.send(dp1);

			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}