
public class Sort {
   
	/*
	 * ð������
	 * ��ͷ��ʼ�����αȽ�����������ֵ��С����ǰһ���ϴ�����������λ�ã��Դ�����
	 */
	public void BulleSort(int[] arr)
	{
		System.out.println("ð������");
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				int temp=0;
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			Print(arr);
		}
	}
	
	/*
	 * ѡ������
	 *����ѡ��������ֵ���������
	 *��ʣ�µ���ֵ�У��Դ����ƣ�ѡ�����ķ���ʣ����ֵ�е���󣬼��ϴ�ѡ��������֮ǰ
	 */
	public void SelectSort(int[] arr)
	{
		System.out.println("ѡ������");
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j]) 
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
									
			}
			Print(arr);
		}
	}
	
	/*
	 * ��������
	 * ��ĳ����ֵΪ׼���ڸ���ֵ֮ǰ���������Ѿ��ź����
	 * ����ֵ�Ժ�Ϊδ�ź����
	 * ������ʼʱ��Ĭ�ϵڶ�����ֵΪ׼����һ����ֵΪĬ���ź����
	 * ����Ҫ�ȶԵ����ݲ��뵽���ź��������ȥ
	 * ������β��뵽���ź���Ķ��������£�
	 *    ���²���λ�ã���λ��֮������ݺ���һλ��
	 *    ����Ҫ�������ֵ�����ƶ���ճ���λ��
	 */
	public void InsertSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				int temp=0;
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					for(int t=i;t>j;t--)
						arr[t]=arr[t-1];
                    arr[j]=temp;
                    break;
				}  
			}
			Print(arr);
		}
	}
	
	/*
	 * ��������
	 * ��ĳ����Ϊ��׼�����û�׼������С�ڸû�׼�����Ҳ�����ڸû�׼��
	 * ���û�׼���������м�λ��
	 * ����Դ�����
	 * �Ҳ��Դ�����
	 * ˼·���Ƽ򵥣�����ʵ��������Щ�����
	 */
	public void QuickSort(int left,int right,int[] arr)
	{
		int temp=arr[left];
		int i=right;
		int j=left;
		//�ӽ�β��ʼ���ұȻ�׼��С����
	    while(i>j)
	    {
	    	while(i>j&&arr[i]>temp)
	    		i--;
	    	if(arr[i]<temp)
	    	{
	    		arr[j]=arr[i];
	    		arr[i]=temp;	
	    	} 	    	

	    //�ӿ�ͷ��ʼ���ұȻ�׼�������
	        while(i>j&&arr[j]<temp)
	        	j++;
	    	if(arr[j]>temp)
	    	{
	    		arr[i]=arr[j];
	    		arr[j]=temp;
	    	}	    
	     }
	     Print(arr);       
	     if(j>left)
	     {
	    	 QuickSort(0,j-1,arr);
	     }	  
	     if(i<right)
	     {
	    	 QuickSort(i+1,arr.length-1,arr);
	     }
	}  
	
	/*
	 * ϣ������
	 * ϣ�������Ǿ����޸ĵĲ�������׼ȷ��˵�������ü򵥲���������������һ���㷨
	 * ����һ���Ĳ������������Ϊ���ɸ������У��ڸ����������н��м򵥲�������Ĭ�ϵ�һ�β���Ϊ
	 * ���еݹ飬�ݹ�Ĳ���Ϊ֮ǰ��һ��
	 */
	public void ShellSort(int[] arr)
	{
		int n=arr.length;
		for(int tmp=n/2;tmp>0;tmp/=2)   //��ȡ����,tmpΪ����
		{
			for(int i=0;i<tmp;i++)     //�����ڻ�ȡ������
			{
				for(int j=i+tmp;j<n;j+=tmp)    //�򵥲����㷨
				{
					for(int t=i;t<j;t+=tmp)
					if(arr[j]<arr[t])
					{
						int temp=arr[j];
						while(j>t)
						{
							arr[j]=arr[j-tmp];
							j-=tmp;
						}
					   arr[t]=temp;
					}
				}
			}
			Print(arr);
		}
		
	}
	
	/*
	 * �鲢����
	 * �鲢�����ǽ�������Ϊ���ɸ�С���飬��С�����н�������Ȼ����кϲ�����ֱ��������������
	 * ������
	 */
	public void MergeSort(int[] arr,int left,int right)
	{
		merge(arr,left,right);
		Print(arr);		
	}
	public void merge(int[] arr,int left,int right)
	{
		if(left>=right)
		{
			return;
		}
		int mid=(left+right)/2;
		//���
		merge(arr,left,mid);
		//�Ҳ�
		merge(arr,mid+1,right);
		//��������
		sort(arr,left,mid,right);
	}
	public void sort(int[] arr,int left,int mid,int right)  //���Ǻܶ�
	{
		int[] tempArr=new int[arr.length];
		while(left<=mid&&right>mid)
		{
			if(arr[left]>arr[mid])
				tempArr[left]=arr[left];
			
		}
	}
	
	/*
	 * ��������,�ֳ�ΪͰ����
	 * �Ӹ�λ����ʼ��������ֵ��С���η���
	 * ��λ������󣬰���ʮλ����ֵ��С��ʼ����
	 * �Դ����ƣ�ֱ������λ��
	 */
	 public void BaseSort(int[] arr,int n)
	 {
		int length=arr.length;
		int[][] arr1=new int[n][length];
		int tmp=1;
		for(int i=0;i<n;i++)
		{
		   for(int j=0;j<length;j++)
		   {
			  arr1[i][j]=arr[j]/tmp%10;
		   }
		   tmp*=10;
		   for(int t=1;t<length;t++)  //�ڻ�ȡ����������ʹ�����򣬴˴�ʹ�õ��ǲ������򣬿ɸ�������ѡ�������㷨
		   {
		   for(int j=0;j<t;j++)
		   {
			   if(arr1[i][j]>arr1[i][t])
			   {
				   int temp=arr[t];
				   int temp1=arr1[i][t];
				   for(int k=t;k>j;k--)
				   {
					   arr[k]=arr[k-1];          //��ȡԭ�����˳��
					   arr1[i][k]=arr1[i][k-1];  //��ȡ�µ������˳�򣬶���˳��Ӧһ��
				   }
				   arr[j]=temp;
				   arr1[i][j]=temp1;
				   break;

			   }
		   }
		   
		   }
		   Print(arr);
		   
		}
		
	 }
	 
	 /*
	  * ������
	  */
	 public void HeapSort(int[] arr)
	 {
		 
	 }

	
	//�����������
	public void Print(int[] arr) {
		for(int k=0;k<arr.length;k++)
		{
	        System.out.print(arr[k]+"  ");
		}	
		 System.out.println();
	
	}
	public static void main(String args[])
	{
		int[] arr= {4,65,1,7,9,3,34,12,13,6,232,144};
		Sort sort=new Sort();
		//sort.BulleSort(arr);      //ð������
		//sort.SelectSort(arr);      //ѡ������
		//sort.InsertSort(arr);        //��������
		//sort.QuickSort(0,arr.length-1,arr); //��������
		//sort.ShellSort(arr);         //ϣ������
		 sort.MergeSort(arr,0,arr.length-1);   //�鲢����
		// sort.BaseSort(arr,3);  //��������
		 //  sort.HeapSort(arr);    // ������
	}
		
	}
