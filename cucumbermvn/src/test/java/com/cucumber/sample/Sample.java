package com.cucumber.sample;

public class Sample {
	/*	To run scenarios with @debug1 and @debug2:

		mvn test -Dcucumber.options="--tags @debug1 --tags @debug2"
		To run scenarios with @debug1 or @debug2:

		mvn test -Dcucumber.options="--tags @debug1,@debug2"
	 */	public static void main(String h[]){
		 String value = "--or @test @test1";
		 String temp ="",flag="";
		 String[] splited = value.split(" ");
		 if(splited[0].equalsIgnoreCase("--and")){
			 for(int i=1;i<splited.length;i++){
				 temp = temp+"--tags "+splited[i]+" ";
			 }
			 flag = temp;
		 }
		 if(splited[0].equalsIgnoreCase("--or")){
			 for(int i=1;i<splited.length;i++){
				 temp = temp+splited[i]+",";
			 }
			 flag = "--tags "+temp.substring(0, temp.length()-1);
		 }
		 System.out.println(flag);
	 }

}
