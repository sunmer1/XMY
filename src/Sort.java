
public class Sort {
   
	/*
	 * 冒泡排序
	 * 从头开始，依次比较相邻两个数值大小，若前一个较大，则两数互换位置，以此类推
	 */
	public void BulleSort(int[] arr)
	{
		System.out.println("冒泡排序：");
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
	 * 选择排序
	 *依次选出最大的数值并放于最后
	 *在剩下的数值中，以此类推，选出最大的放于剩余数值中的最后，即上次选出的数据之前
	 */
	public void SelectSort(int[] arr)
	{
		System.out.println("选择排序：");
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
	 * 插入排序
	 * 以某个数值为准，在该数值之前的数据是已经排好序的
	 * 该数值以后为未排好序的
	 * 在排序开始时，默认第二个数值为准，第一个数值为默认排好序的
	 * 将需要比对的数据插入到已排好序队列中去
	 * 关于如何插入到已排好序的队列中如下：
	 *    记下插入位置，该位置之后的数据后移一位；
	 *    将需要插入的数值放入移动后空出的位置
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
	 * 快速排序
	 * 以某个数为基准数，该基准数左侧均小于该基准数，右侧均大于该基准数
	 * 将该基准数放置于中间位置
	 * 左侧以此类推
	 * 右侧以此类推
	 * 思路看似简单，但是实现起来有些难理解
	 */
	public void QuickSort(int left,int right,int[] arr)
	{
		int temp=arr[left];
		int i=right;
		int j=left;
		//从结尾开始查找比基准数小的数
	    while(i>j)
	    {
	    	while(i>j&&arr[i]>temp)
	    		i--;
	    	if(arr[i]<temp)
	    	{
	    		arr[j]=arr[i];
	    		arr[i]=temp;	
	    	} 	    	

	    //从开头开始查找比基准数大的数
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
	 * 希尔排序
	 * 希尔排序是经过修改的插入排序，准确地说，是利用简单插入排序进行排序的一种算法
	 * 按照一定的步长将数据组分为若干个子序列，在各个子序列中进行简单插入排序，默认第一次步长为
	 * 进行递归，递归的步长为之前的一半
	 */
	public void ShellSort(int[] arr)
	{
		int n=arr.length;
		for(int tmp=n/2;tmp>0;tmp/=2)   //获取步长,tmp为步长
		{
			for(int i=0;i<tmp;i++)     //步长内获取子序列
			{
				for(int j=i+tmp;j<n;j+=tmp)    //简单插入算法
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
	 * 归并排序
	 * 归并排序是将数组拆分为若干个小数组，将小数组中进行排序，然后进行合并排序，直至排序至所有数
	 * 二叉树
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
		//左侧
		merge(arr,left,mid);
		//右侧
		merge(arr,mid+1,right);
		//进行排序
		sort(arr,left,mid,right);
	}
	public void sort(int[] arr,int left,int mid,int right)  //不是很懂
	{
		int[] tempArr=new int[arr.length];
		while(left<=mid&&right>mid)
		{
			if(arr[left]>arr[mid])
				tempArr[left]=arr[left];
			
		}
	}
	
	/*
	 * 基数排序,又称为桶排序
	 * 从个位数开始，按照数值大小依次分类
	 * 个位数分类后，按照十位数数值大小开始分类
	 * 以此类推，直至最大的位数
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
		   for(int t=1;t<length;t++)  //在获取的新数组中使用排序，此处使用的是插入排序，可根据需求选择具体的算法
		   {
		   for(int j=0;j<t;j++)
		   {
			   if(arr1[i][j]>arr1[i][t])
			   {
				   int temp=arr[t];
				   int temp1=arr1[i][t];
				   for(int k=t;k>j;k--)
				   {
					   arr[k]=arr[k-1];          //获取原数组的顺序
					   arr1[i][k]=arr1[i][k-1];  //获取新的数组的顺序，二者顺序应一致
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
	  * 堆排序
	  */
	 public void HeapSort(int[] arr)
	 {
		 
	 }

	
	//公共输出函数
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
		//sort.BulleSort(arr);      //冒泡排序
		//sort.SelectSort(arr);      //选择排序
		//sort.InsertSort(arr);        //插入排序
		//sort.QuickSort(0,arr.length-1,arr); //快速排序
		//sort.ShellSort(arr);         //希尔排序
		 sort.MergeSort(arr,0,arr.length-1);   //归并排序
		// sort.BaseSort(arr,3);  //基数排序
		 //  sort.HeapSort(arr);    // 堆排序
	}
		
	}
