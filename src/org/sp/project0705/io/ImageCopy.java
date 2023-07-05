package org.sp.project0705.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ImageCopy {


	public static void main(String[] args) 	{
		//����� �Ǵ� ���Ͽ� ���� �Է½�Ʈ���� �����غ���
		String path="D:/morning/javase_workspace/project0705/res/ddug.png";
		String path2="D:/morning/javase_workspace/project0705/data/copy.png";
		//���ϴ� �ڿ��� �̹����� �Է½�Ʈ���� �����Ѵ�

		/*
		try~catch���� ����:���α׷��� ������ ������ ����
		try�������� ������ �߻��� ������ �ִ� �ڵ带 �ۼ��ϰ�
		����try�������� ����ߴ� ������ �߻��Ѵٸ� �ڵ带 ��ġ��������
		catch������ �����Ͽ� ������ ���� ó���� ����� �Ѵ�. �׷��� �ŷڼ��ִ�
		���α׷��� ����.
		*/
		FileInputStream fis=null;
		FileOutputStream fos=null;

		try{
			fis=new FileInputStream(path);

			//������ ������� �� ��½�Ʈ�� ��ü
			fos=new FileOutputStream(path2);

			System.out.println("��Ʈ�� ��������");
			
			//������ ��Ʈ���� �̿��Ͽ� Ÿ�� �̹����� �̷���ִ� ������ �˰�����
			//�� �˰��̸� ���̸��ź���(�о��)
			
			while(true){
				int data=fis.read();//�� ����Ʈ �б�, �Է�
				if(data==-1)break;//�о���� �����Ͱ� ���ٸ� �ݺ��� ����
				System.out.println(data);
				fos.write(data);//���
			}
			System.out.println("���Ϻ���Ϸ�");
			//���� ��Ʈ���� �ݵ�� �����ؾ����� ������ ��Ģ
		

		}catch(FileNotFoundException e){
			System.out.println("�������� �ʴ� ���ϰ���Դϴ�");
			//e.printStackTrace();
			//System.out.println(e);
		}catch(IOException e){
			System.out.println("�����������ϴ�");
		}finally{
			//����δ�  try���������ϴ�, catch���������ϴ� �ݵ�� finally����
			//��ġ�ԵǾ��մ� ���� finally������ �ַ� ������ �ʴ� �ڿ�����
			//�����Ҷ� � ���.d
			try{
			fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}

			try{
			fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}


		}


	}
}
