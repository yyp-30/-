import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.math.RoundingMode;
public class zy2{
    public static void main(String[] args){
        int max=10;// ������ʽ����
        char[] op={ ' ', '+', '-', '*', '/' };// ������
        int[] no=new int[4];// ��������ַ
        int useno=0;// ���Ʋ�����
        int n=3;// �����������������
        int[] num1=new int[10];// ������
        char opp;// �ж��Ƿ���Ҫ�˳���
        char real;// �ж��Ƿ���Ҫ���������Ŀ
        int[] cs={ 1, 100 };// ��ֵ��Χ
        String[] userAnser=new String[max];// �û�����Ĵ�
        String[] staticAnser=new String[max];// ��׼��
        int sign; // �ۼ�����ʱ�ķ���
        float left,right;// �������
        int f=0;// �������������Ĳ�����
        int count=0;// ͳ�ƴ�����ȷ������
        DecimalFormat decimal=new DecimalFormat("#.##");
		decimal.setRoundingMode(RoundingMode.HALF_UP);
        int s1=1;// ����ͨ��
        int ss1=1;// ����ͨ��
        int s2=1;// ��ĸͨ��
        int result=0;// ���Ӽ���
        int gys;// ���Լ��
        int ff=0;// ��������������Ϊ0��־λ
		int fff=0;
        String zjfz=new String();// ������
        String zjfm=new String();// ����ĸ
		Pattern pattern=Pattern.compile("[0-9]*"); // �޶�������ʽ��������ı���������
        Scanner in=new Scanner(System.in);
        System.out.print("�������趨�Ƶ���ʽ������");// 1.��������
        do{
			String str=in.nextLine();
            if(pattern.matcher(str).matches()){// �������������־�ִ��
                max=Integer.parseInt(str);
                break;
            }
			else{                 
			    System.out.print("������Ĳ������֣�����������:");
            }
        } while (true);
        System.out.print("�Ƿ���Ҫ�˳�����Y/N��:");// 2.���Ƴ˳�����
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
				System.out.print("���������������");
			}
		}while(true);
        System.out.print("������Χ��eg:1,100��:");// 3.������ֵ��Χ
        String str=new String();
		int sr=0;
        in.nextLine();// ���˵�����.next()����Ļس�
		do{
			try{
				
				str=in.nextLine();
				String[] ss=new String[2];
				ss=str.split(",");
				cs[0]=Integer.valueOf(ss[0]);
				cs[1]=Integer.valueOf(ss[1]);
				sr=1;
			}catch(Exception e){
				System.out.print("���������������:");
			}
		}while(sr!=1);
		System.out.print("�Ƿ������������ϰ�⣨Y/N��:");// 3.������ֵ��Χ
		do{
			
			real=in.next().charAt(0);
			if (real=='Y'||real=='y'){
				break;
			}
			else if(real=='N'||real=='n'){
				break;
			}
			else{
				System.out.print("���������������:");
			}
		}while(true);
		System.out.println();
        for (int i=0;i<max;i++){ 
            System.out.print("("+(i+1)+")");
            n=(int)(Math.random()*3+2);// 2-4��������
            for(int j=0;j<n;j++){
                num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);// �����������ֵ
            }
            for(int k=0;k <n-1;k++){
                no[k]=(int)(Math.random()*useno+1);// �������������
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
            // �����һ�����
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
        // ѧ������ģ��
        System.out.println("###################����ָ���######################");
        for(int i=0;i<max;i++){
            System.out.print((i+1)+":");
            userAnser[i]=in.next();
            if(userAnser[i].equalsIgnoreCase(staticAnser[i])) {
                count++;
            }
        }
        System.out.println("��׼��Ϊ��");
        for(int i=0;i<max;i++){
            System.out.println((i+1)+":"+staticAnser[i]);
        }
        System.out.println("������ȷ��Ϊ��"+String.valueOf(decimal.format(((float)count/(float)max)*100))+"%");
		//�ڶ�����
        if (real=='Y'||real=='y'){
			System.out.println("��������������������ʽ��");
            System.out.println();
            for(int i=0; i<max;i++){
                System.out.print("("+(i+1)+") ");
                for(int j=0;j<2;j++)// (��һ�������)
                {
                    num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);// �����������ֵ
                    if (j==1){
                        while(num1[j-1]>num1[j]||num1[j]==0){
                            num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);// �����������ֵ
                        }
                    }
                }
                for(int j=2;j<4;j++)// (�ڶ��������)
				{
                    num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);// �����������ֵ
                    if(j==3){
                        while(num1[j-1]>num1[j]||num1[j]==0){
                            num1[j]=(int)(Math.random()*(cs[1]-cs[0])+cs[0]);// �����������ֵ
                        }
                    }
                }
                for(int k=0;k <1;k++){// ���Ÿ���
                     no[k]=(int)(Math.random()*useno+1);// �������������
                 }
                for(int h=0;h<4;h++){// 2�������
                    if(h%2==0)
                        System.out.print(("("+num1[h]+"/"));
                    else if (h%2==1){
                        System.out.print(num1[h]+")");
                        if (f<1){// ����ֻ���һ��������                             
						System.out.print(op[no[f]]);
                            f++;
                        } 
						else
                            System.out.println("="); 
                    }
                }
                // ����ڶ������׼�� 
				f=0;
				count=0;
                for (int g=0;g<1;g++){
                    s1=num1[0]*num1[3];
                    s2=num1[1]*num1[3];//��ĸ
					ss1=num1[1]*num1[2];
					ff=0;
					fff=0;
                    switch(op[no[g]]){
                    case '+':
                        result=s1+ss1;
                        gys=countMaxSubmultiple(result,s2);// ���Թ�Լ���õ�������
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
                    case '/':// ���Ե���
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
            }// ����ģ��
            System.out.println("######################����ָ���#####################");
            for(int i=0;i<max;i++){
                System.out.print((i+1)+":");
                userAnser[i]=in.next();
                if(userAnser[i].equals(staticAnser[i])){
                    count++;
                }
            }
            System.out.println("��׼��Ϊ��");
            for(int i=0;i<max;i++){
                System.out.println((i+1)+":"+staticAnser[i]);
            }
            System.out.println("������ȷ��Ϊ��"+String.valueOf(decimal.format(((float)count/(float)max)*100))+"%");
		}
	}
	private static int countMaxSubmultiple(int n1, int n2){// �����Լ��
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