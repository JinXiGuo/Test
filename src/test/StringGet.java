package test;

import java.io.File;


public class StringGet
{
	public static void main(String args[])
	{
		//delAllFile("d:/t");
		
	}
	
	public static String getRequest(String str){
		String result="";
		String[] temp=str.split(",");
		for (int i = 0; i < temp.length; i++)
		{
			try{
				result+=Long.parseLong(temp[i])+",";
			}catch(NumberFormatException ex){}
		}
		result=result.substring(0,result.length()-1);
		return result;
	}

	// ɾ��ָ���ļ����������ļ�
	// param path �ļ�����������·��
	public static void delAllFile(String path)
	{
		File file = new File(path);

		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++)
		{
			if (tempList[i].endsWith(".zip"))
			{
				System.out.println(tempList[i]);
				temp=new File(path+File.separator+tempList[i]);
				temp.delete();
			}
		}
		
	}
}