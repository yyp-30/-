import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.math.RoundingMode;
public class zy2{
    public static void main(String[] args){
        int max=10;
        char[] op={ ' ', '+', '-', '*', '/' };// 操作符
        int[] no=new int[4];
        int useno=0;
        int n=3;
        int[] num1=new int[10];
        char opp;// 判断是否需要乘除法
        char real;// 判断是否需要真分数的题目
        int[] cs={ 1, 100 };// 数值范围
        String[] userAnser=new String[max];// 用户输入的答案
        String[] staticAnser=new String[max];// 标准答案
        int sign; 
        float left,right;
        int f=0;// 控制输出真分数的操作符
        int count=0;// 统计答题正确的数量
        DecimalFormat decimal=new DecimalFormat("#.##");
		decimal.setRoundingMode(RoundingMode.HALF_UP);
        int s1=1;
        int ss1=1;
        int s2=1;
        int result=0;
        int gys;// 最大公约数
        int ff=0;
		int fff=0;
        String zjfz=new String();// 最简分子
        String zjfm=new String();// 最简分母
		Pattern pattern=Pattern.compile("[0-9]*");
        Scanner in=new Scanner(System.in);
        System.out.print("请输入需定制的算式数量：");
        do{
			String str=in.nextLine();
            if(pattern.matcher(str).matches()){
                max=Integer.parseInt(str);
                break;
            }
			else{                 
			    System.out.print("你输入的不是数字，请重新输入:");
            }
        } while (true);
        System.out.print("是否需要乘除法（Y/N）:");
		do{
			opp=in.next().charAt(0);
			if(opp=='Y'||opp =='y'){
				useno=4;
				break;
			} 
			else if(opp=='N'||opp=='n'){
				useno=2;
				break;
			}
			else{
				System.out.print("输入错误，重新输入");
			}
		}while(true);
        System.out.print("参数范围（eg:1,100）:");
        String str=new String();
		int sr=0;
        in.nextLine();
		do{
			try{
				
				str=in.nextLine();
				String[] ss=new String[2];
				ss=str.split(",");
				cs[0]=Integer.valueOf(ss[0]);
				cs[1]=Integer.valueOf(ss[1]);
				sr=1;
			}catch(Exception e){
				System.out.print("输入错误，重新输入:");
			}
		}while(sr!=1);
		System.out.print("是否增加真分数练习题（Y/N）:");
		do{
			
			real=in.next().charAt(0);
			if (real=='Y'||real=='y'){
				break;
			}
			else if(real=='N'||real=='n'){
				break;
			}
			else{
				System.out.print("输入错误，重新输入:");
			}
		}while(true);
		System.out.println();
        for (int i=0;i<max;i++){ 
            System.out.print("("+(i+1)+")");
            n=(int)(Math.random()*3+2);
            for(int j=0;j<n;j++){
                num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);
            }
            for(int k=0;k <n-1;k++){
                no[k]=(int)(Math.random()*useno+1);
				if(no[k]==4&&num1[k+1]==0){
					do{
						num1[k+1]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);
					}while(num1[k+1]==0);
				}
            }
            for(int h=0;h<n;h++){
                if (h!=n-1){
                    System.out.print(num1[h]);
                    System.out.print(op[no[h]]);
                }
				else{
                    System.out.print(num1[h]+"=");
                }
            }
            System.out.println();
            left=0;
            right=num1[0];
            sign=1;
            for(int g=0;g<n-1;g++){
				switch(op[no[g]]){
                case '+':
                    left=left+sign*right;
                    sign=1;
                    right=num1[g + 1];
                    break;
                case '-':
                    left=left+sign*right;
                    sign=-1;
                    right=num1[g+1];
                    break;
                case '*':
                    right=right*num1[g+1];
                    break;
                case '/':
                    right=right/num1[g + 1];
                    break;
                }
            }
            staticAnser[i]=String.valueOf(decimal.format(left+sign*right));
		}
        System.out.println("###################答题分割线######################");
        for(int i=0;i<max;i++){
            System.out.print((i+1)+":");
            userAnser[i]=in.next();
            if(userAnser[i].equalsIgnoreCase(staticAnser[i])) {
                count++;
            }
        }
        System.out.println("标准答案为：");
        for(int i=0;i<max;i++){
            System.out.println((i+1)+":"+staticAnser[i]);
        }
        System.out.println("答题正确率为："+String.valueOf(decimal.format(((float)count/(float)max)*100))+"%");
        if (real=='Y'||real=='y'){
			System.out.println("二、请计算下列真分数算式。");
            System.out.println();
            for(int i=0; i<max;i++){
                System.out.print("("+(i+1)+") ");
                for(int j=0;j<2;j++)
                {
                    num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);
                    if (j==1){
                        while(num1[j-1]>num1[j]||num1[j]==0){
                            num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);
                        }
                    }
                }
                for(int j=2;j<4;j++)
		{
                    num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);
                    if(j==3){
                        while(num1[j-1]>num1[j]||num1[j]==0){
                            num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);// 控制随机数数值
                        }
                    }
                }
                for(int k=0;k <1;k++){// 符号个数
                     no[k]=(int)(Math.random()*useno+1);// 随机产生操作符
                 }
                for(int h=0;h<4;h++){// 2个真分数
                    if(h%2==0)
                        System.out.print(("("+num1[h]+"/"));
                    else if (h%2==1){
                        System.out.print(num1[h]+")");
                        if (f<1){// 控制只输出一个操作符                             
						System.out.print(op[no[f]]);
                            f++;
                        } 
						else
                            System.out.println("="); 
                    }
                }
				f=0;
				count=0;
                for (int g=0;g<1;g++){
                    s1=num1[0]*num1[3];
                    s2=num1[1]*num1[3];//分母
					ss1=num1[1]*num1[2];
					ff=0;
					fff=0;
                    switch(op[no[g]]){
                    case '+':
                        result=s1+ss1;
                        gys=countMaxSubmultiple(result,s2);// 除以公约数得到最简分数
                        zjfz=String.valueOf(result/gys);
                        zjfm=String.valueOf(s2/gys);
                        break;
                    case '-':
                        result=s1-ss1;
                        gys=countMaxSubmultiple(result, s2);
                        zjfz=String.valueOf(result/gys);
                        zjfm=String.valueOf(s2/gys);
                        break;
                    case '*':
                        result=num1[0]*num1[2];
                        gys=countMaxSubmultiple(result, s2);
						if(num1[0]==0||num1[2]==0)
						{
							fff=1;
						}
						zjfz=String.valueOf(result/gys);
                        zjfm=String.valueOf(s2/gys);
                        break;
                    case '/':// 乘以倒数
						result=num1[0]*num1[3];
                        s2=num1[1]*num1[2];
                        gys=countMaxSubmultiple(s1,s2);
                        if(num1[0]==0||num1[2]==0){
                            ff=1;
                        }
                        zjfz=String.valueOf(result/gys);
                        zjfm=String.valueOf(s2/gys);
                        break;
                    }
				}
                if(ff==1){
                    staticAnser[i]="null";
                }
				else if(fff==1){
					staticAnser[i]="0";
				}
				else if(zjfz==zjfm){
					staticAnser[i]="1";
				}
				else if(zjfm.equalsIgnoreCase("1")){
					staticAnser[i]=zjfz;
				}
				else{
                    staticAnser[i]=zjfz+"/"+zjfm;
                }
            }
            System.out.println("######################答题分割线#####################");
            for(int i=0;i<max;i++){
                System.out.print((i+1)+":");
                userAnser[i]=in.next();
                if(userAnser[i].equals(staticAnser[i])){
                    count++;
                }
            }
            System.out.println("标准答案为：");
            for(int i=0;i<max;i++){
                System.out.println((i+1)+":"+staticAnser[i]);
            }
            System.out.println("答题正确率为："+String.valueOf(decimal.format(((float)count/(float)max)*100))+"%");
		}
	}
	private static int countMaxSubmultiple(int n1, int n2){// 求最大公约数
        int maxSubmultiple=1;
		n1=Math.abs(n1);
		n2=Math.abs(n2);
		int min=Math.min(n1, n2);
        for (int i=min;i>=1;i--){
            if (n1%i==0&&n2%i==0){
                maxSubmultiple=i;
				break;
            }
        }
        return maxSubmultiple;
    }
}
