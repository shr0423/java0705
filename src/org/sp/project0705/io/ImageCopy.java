package org.sp.project0705.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ImageCopy {


	public static void main(String[] args) 	{
		//대상이 되는 파일에 파일 입력스트림을 연결해보자
		String path="D:/morning/javase_workspace/project0705/res/ddug.png";
		String path2="D:/morning/javase_workspace/project0705/data/copy.png";
		//원하는 자원인 이미지에 입력스트림을 연결한다

		/*
		try~catch문의 목적:프로그램의 비정상 종료의 방지
		try문에서는 에러가 발생할 소지가 있는 코드를 작성하고
		만일try영역에서 우려했던 에러가 발생한다면 코드를 방치하지말고
		catch문으로 유도하여 에러에 대한 처리를 해줘야 한다. 그래야 신뢰성있는
		프로그램의 개발.
		*/
		FileInputStream fis=null;
		FileOutputStream fos=null;

		try{
			fis=new FileInputStream(path);

			//파일을 대상으로 한 출력스트림 객체
			fos=new FileOutputStream(path2);

			System.out.println("스트림 생성성공");
			
			//생성된 스트림을 이용하여 타겟 이미지를 이루고있는 수많은 알갱이중
			//한 알갱이를 들이마셔보자(읽어보자)
			
			while(true){
				int data=fis.read();//한 바이트 읽기, 입력
				if(data==-1)break;//읽어들일 데이터가 없다면 반복문 종료
				System.out.println(data);
				fos.write(data);//출력
			}
			System.out.println("파일복사완료");
			//사용된 스트림은 반드시 제거해야함이 개발의 원칙
		

		}catch(FileNotFoundException e){
			System.out.println("존재하지 않는 파일경로입니다");
			//e.printStackTrace();
			//System.out.println(e);
		}catch(IOException e){
			System.out.println("읽을수없습니다");
		}finally{
			//실행부는  try문을수행하던, catch문을수행하던 반드시 finally블럭을
			//거치게되어잇다 따라서 finally에서는 주로 사용되지 않는 자원등을
			//해제할때 등에 사용.d
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
