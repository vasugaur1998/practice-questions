public class codes{


//leetcode 671
public TreeNode right(TreeNode left,TreeNode curr){
   
   
   while(left.right!=null && left.right!=curr){
       left=left.right;
   }
   
   return left;
   
}

public void morris(TreeNode root,long min[]){
   
   if(root==null)return ;
   
  
   long a=(long)1e45;
   long b=(long)1e31;
   TreeNode curr=root;
   
   while(curr!=null){
       
     TreeNode left=curr.left;
       if(left==null){
         
           if(curr.val<a){
               b=a;
               a=curr.val;
           }else if(curr.val>a && curr.val<=b){
               b=curr.val;
           }else{
               
           }
           
       curr=curr.right;
    }
   else{
         
      TreeNode rightMost=right(left,curr);
         
      if(rightMost.right==null){
          rightMost.right=curr;
          curr=curr.left;
          
      }else{
          
          rightMost.right=null;
     
       if(curr.val<a){
               b=a;
               b=curr.val;
           }else if(curr.val>a && curr.val<=b){
               b=curr.val;
           }
                
              curr=curr.right;
          
          
      }   
  }  
}
  min[0]=a;
   min[1]=b;

   
}

public int findSecondMinimumValue(TreeNode root) {
 
   long min[]=new long[2];
  morris(root,min);
 
 
   if(min[1]==(long)1e45)
       return -1;
   return (int)min[1];
   
}

//2nd min in an array


public static void Min(int arr[]){
        
        
    int a=(int)1e9;
    int b=(int)1e9;
    for(int i=0;i<arr.length;i++){
        
        int val=arr[i];
        if(val<a){
            b=a;
            a=val;
        }
        else if(val>a && val<=b){
            b=val;
        }
        
        
    }
    System.out.println("first min"+" "+ a);
    System.out.println("second min"+" "+ b);
}

//leetcode 938


int sum=0;
        
public void helper(TreeNode root,int low,int high,int idx){

if(root==null)return;
    if(idx>high){
        return;
    }

helper(root.left,low,high,idx);
if(idx<=high && root.val>=low && root.val<=high){
    idx++;
    sum+=root.val;
}

helper(root.right,low,high,idx);

}
public int rangeSumBST(TreeNode root, int low, int high) {

if(root==null){
    return 0;
}
helper(root,low,high,0);
return sum;

}


//leetcode 530

public int getMinimumDifference(TreeNode root) {
    
    ArrayList<Integer> a = new ArrayList<>();
    get1(root,a);
    
    int x = Integer.MAX_VALUE;
    
    for(int i = 0;i<a.size()-1;i++){
        if(x>( a.get(i+1)-a.get(i) ) ){
            x=a.get(i+1)-a.get(i);
        }
    }
   
    return x;
    
}

void get1(TreeNode root , ArrayList<Integer> a){
    
    if(root!=null){
        
        get1(root.left,a);            
        a.add(root.val);       
        get1(root.right,a);
    }
    

}
//leetcode 384

int arr[]=null;
int temp[]=null;
int i=0;
int j=0;
Random rand=new Random();
public Solution(int[] nums) {
    
 this.arr=new int[nums.length];
 this.temp=new int[nums.length];
    for(int i=0;i<nums.length;i++){
        this.arr[i]=nums[i];
        this.temp[i]=nums[i];
    }
     
}
private void swap(int arr[],int i,int j){
    
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
    
}

/** Resets the array to its original configuration and return it. */
public int[] reset() {
     
    
 return this.arr;
    
}

/** Returns a random shuffling of the array. */
public int[] shuffle() {
     
      int n=this.arr.length;
    this.i=rand.nextInt(n);
    this.j=rand.nextInt(n);
  
    swap(this.temp,this.i,this.j);
    return this.temp;
    
}

//leetcode 977

public int[] sortedSquares(int[] nums) {
    int n = nums.length, low = 0, high = n-1;        
    int[] ans = new int[n];
    int index = n-1;
    
    while(low <= high){
        int right = Math.abs(nums[low]);
        int left = Math.abs(nums[high]);
        if(left >= right){
            ans[index--] = left*left;
            high--;
        }else{
            ans[index--] = right*right;
            low++;
        }
    }        
    return ans;
}


//leetcode 1209

public String removeDuplicates(String s, int k) {
    Stack<Pair> st = new Stack();
    
    for(char ch : s.toCharArray()){
        if(st.size()>0&&st.peek().ch==ch) st.peek().freq++;
        else st.push(new Pair(ch,1));
        if(st.peek().freq==k) st.pop();
    }
    
    StringBuilder ans = new StringBuilder();
    while(st.size()>0){
        Pair pair = st.pop();
        while(pair.freq>0){
            ans.append(pair.ch);
            pair.freq--;
        }
    }
    return ans.reverse().toString();
}
}
class Pair{
char ch;
int freq;

public Pair(char ch , int freq){
    this.ch = ch;
    this.freq = freq;
}

///main=========================================================================================



}