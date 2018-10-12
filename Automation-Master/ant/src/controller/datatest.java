package controller;

import org.apache.bcel.classfile.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//prasetyo
public class datatest{
	
	public String testlocation ="staging";

	public String email ="myjne001@gmail.com";  
	public String nama = this.email;
	public String personalId = "5233357313186502";
	public String alamat = this.email;
	public String mobile ="081284915949";
	public String gender ="L";
	
	//buat wb
	//static buat bisa manggil data diluar static
	
	@DataProvider
	public static Object[][] getDataApply(){
	Object[][] data = null;	
		
		//kiri for numbers of times testcase must execute
		//kanan for no parameter you send
		data = new Object[2][3]; 
			
		data[0][0]= "myjne014@gmail.com";
		data[0][1]= "081284915949";
		data[0][2]= "1239281048374839";
			
		data[1][0]= "myjne015@gmail.com";
		data[1][1]= "087889069665";
		data[1][2]= "1239281048374830";
		
		return data;		
	}
	
}
